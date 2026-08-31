-- ---------------------------------------------------------------------------
-- Migracion: el detalle de cotizacion pasa de una fila por parametro a un
-- grupo por descripcion de servicio con sus ensayos en una tabla hija.
--
-- ANTES: detallecotizacion = (servicio, UN parametro, tipo toma, plazo,
--        puntos, condicion). El servicio se repetia en cada fila.
-- AHORA: detallecotizacion = (servicio, tipo toma, plazo, puntos, condicion)
--        detalleparametro   = (fk_detalle, fk_parametro, fk_lmp)
--
-- ORDEN DE EJECUCION
--   1. Respalde la base:  pg_dump -U postgres gestalab > respaldo.sql
--   2. Levante el backend una vez. Con ddl-auto=update Hibernate crea la tabla
--      detalleparametro y deja intactas fk_parametro y fk_lmp en
--      detallecotizacion (Hibernate nunca borra columnas).
--   3. Baje el backend y ejecute este script:
--        psql -U postgres -d gestalab -f migracion-detalle-agrupado.sql
--   4. Revise el resumen que imprime al final y recien ahi ejecute a mano el
--      bloque de limpieza comentado al pie.
--
-- El script es transaccional: si algo falla no queda a medias.
-- ---------------------------------------------------------------------------

BEGIN;

-- Sin las columnas viejas no hay nada que migrar (script ya ejecutado antes).
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_name = 'detallecotizacion' AND column_name = 'fk_parametro'
    ) THEN
        RAISE EXCEPTION 'La columna detallecotizacion.fk_parametro ya no existe: la migracion parece haberse ejecutado antes.';
    END IF;
END $$;

-- -----------------------------------------------------------------
-- Paso 1. Elegir una fila superviviente por cada grupo de servicio.
--
-- Dos filas pertenecen al mismo grupo si comparten cotizacion, descripcion de
-- servicio, tipo de toma, plazo, cantidad de puntos y condicion. Se conserva
-- la de menor id y las demas se absorben. COALESCE convierte los nulos en un
-- valor comparable, porque en SQL NULL nunca es igual a NULL.
-- -----------------------------------------------------------------
CREATE TEMP TABLE tmp_grupo AS
SELECT
    d.id_detalle_c,
    MIN(d.id_detalle_c) OVER (PARTITION BY
        d.fk_cotizacion,
        COALESCE(d.fk_descripcion_servicio, -1),
        COALESCE(d.fk_tipo_toma_muestra, -1),
        COALESCE(d.fk_plazo_entrega, -1),
        d.cantidad_puntos_detalle_c,
        COALESCE(d.condicion_detalle_c, '')
    ) AS id_superviviente,
    d.fk_parametro,
    d.fk_lmp
FROM detallecotizacion d;

-- -----------------------------------------------------------------
-- Paso 2. Pasar los parametros a la tabla hija, colgados del superviviente.
-- DISTINCT evita duplicar si el mismo ensayo estaba dos veces en el grupo.
-- -----------------------------------------------------------------
INSERT INTO detalleparametro (fk_detalle, fk_parametro, fk_lmp)
SELECT DISTINCT id_superviviente, fk_parametro, fk_lmp
FROM tmp_grupo
WHERE fk_parametro IS NOT NULL;

-- -----------------------------------------------------------------
-- Paso 3. Reapuntar los planes de muestreo de las filas absorbidas.
--
-- Un plan colgaba de una linea-parametro; ahora cuelga del grupo de servicio.
-- Si dos parametros del mismo grupo tenian plan, quedan dos planes sobre el
-- mismo detalle: es correcto, son dos salidas de campo distintas.
--
-- La tabla del plan se declara como "Plan de Muestreo", con espacios, y el
-- nombre fisico depende de como la haya creado Hibernate. Se busca por su
-- columna fk_detalle_cotizacion en vez de escribirlo a mano.
-- -----------------------------------------------------------------
DO $$
DECLARE
    tabla_plan text;
BEGIN
    SELECT table_name INTO tabla_plan
    FROM information_schema.columns
    WHERE table_schema = current_schema()
      AND column_name = 'fk_detalle_cotizacion'
    LIMIT 1;

    IF tabla_plan IS NULL THEN
        RAISE NOTICE 'No se encontro la tabla de planes de muestreo; no hay planes que reapuntar.';
    ELSE
        EXECUTE format(
            'UPDATE %I p SET fk_detalle_cotizacion = g.id_superviviente
             FROM tmp_grupo g
             WHERE p.fk_detalle_cotizacion = g.id_detalle_c
               AND g.id_detalle_c <> g.id_superviviente', tabla_plan);
        RAISE NOTICE 'Planes de muestreo reapuntados en la tabla %', tabla_plan;
    END IF;
END $$;

-- -----------------------------------------------------------------
-- Paso 4. Borrar las filas absorbidas.
-- -----------------------------------------------------------------
DELETE FROM detallecotizacion
WHERE id_detalle_c IN (
    SELECT id_detalle_c FROM tmp_grupo WHERE id_detalle_c <> id_superviviente
);

-- -----------------------------------------------------------------
-- Resumen para verificar antes de limpiar.
-- -----------------------------------------------------------------
SELECT
    (SELECT COUNT(*) FROM tmp_grupo)                                      AS filas_originales,
    (SELECT COUNT(*) FROM detallecotizacion)                              AS grupos_resultantes,
    (SELECT COUNT(*) FROM detalleparametro)                               AS ensayos_migrados,
    (SELECT COUNT(*) FROM tmp_grupo WHERE fk_parametro IS NULL)           AS filas_sin_parametro;

COMMIT;

-- ---------------------------------------------------------------------------
-- LIMPIEZA - ejecutar por separado y solo despues de comprobar en la
-- aplicacion que las cotizaciones se ven bien.
--
-- Estas columnas ya no las usa el modelo, pero mientras existan sirven de
-- respaldo por si hay que rehacer la migracion desde el punto de partida.
--
--   ALTER TABLE detallecotizacion DROP COLUMN fk_parametro;
--   ALTER TABLE detallecotizacion DROP COLUMN fk_lmp;
-- ---------------------------------------------------------------------------
