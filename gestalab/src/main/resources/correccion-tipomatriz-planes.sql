-- ---------------------------------------------------------------------------
-- Corrige los planes creados antes de separar Tipo de matriz de Descripcion
-- del servicio.
--
-- QUE PASABA: al generar el plan desde la cotizacion, el sistema tomaba la
-- descripcion del servicio ("Monitoreo y analisis de aguas residuales") y la
-- escribia en la columna Tipo de matriz, tanto en Procedimiento de Muestreo
-- como en Informacion de la Matriz. El tipo de matriz es otra cosa: la
-- clasificacion tecnica de la muestra (Agua residual, Lixiviado...).
--
-- QUE HACE ESTE SCRIPT:
--   Paso 1  Procedimiento -> rellena Descripcion relevante leyendola de la
--           cotizacion (plan -> detalle -> descripcion de servicio). No depende
--           de lo que haya quedado en Tipo de matriz, asi que funciona aunque
--           esa columna ya se haya corregido a mano.
--   Paso 2  Procedimiento -> vacia Tipo de matriz si su valor no es una opcion
--           real del catalogo (ahi quedo la descripcion del servicio).
--   Paso 3  Informacion de la Matriz -> lo mismo con Tipo de matriz.
--
-- El codigo ya quedo arreglado y los planes nuevos nacen bien; esto es solo
-- para los que ya existen.
--
--   psql -U postgres -d gestalab -f correccion-tipomatriz-planes.sql
--
-- Se puede ejecutar mas de una vez: solo toca filas que sigan mal.
-- ---------------------------------------------------------------------------

BEGIN;

-- Varias tablas se declaran con espacios en el nombre ("Procedimiento de
-- Muestra", "Plan de Muestreo", "Informacion de la Matriz"), asi que se
-- localizan por una columna caracteristica en vez de escribirlas a mano.
DO $$
DECLARE
    tabla_proc   text;
    tabla_plan   text;
    tabla_matriz text;
    afectadas    integer;
BEGIN

    SELECT table_name INTO tabla_proc
    FROM information_schema.columns
    WHERE table_schema = current_schema() AND column_name = 'precausiones'
    LIMIT 1;

    SELECT table_name INTO tabla_plan
    FROM information_schema.columns
    WHERE table_schema = current_schema() AND column_name = 'fk_detalle_cotizacion'
    LIMIT 1;

    SELECT table_name INTO tabla_matriz
    FROM information_schema.columns
    WHERE table_schema = current_schema() AND column_name = 'descripcion_del_punto'
    LIMIT 1;

    -- ------------------------------------------------------------------
    -- Paso 1. Descripcion relevante <- descripcion del servicio cotizado.
    -- Solo se rellenan las que esten vacias, para no pisar lo que el
    -- Tecnico de Campo haya escrito.
    -- ------------------------------------------------------------------
    IF tabla_proc IS NULL OR tabla_plan IS NULL THEN
        RAISE NOTICE 'Falta la tabla de Procedimiento o la de Planes: se omite el relleno de la descripcion.';
    ELSE
        EXECUTE format(
            'UPDATE %I pr
             SET descripcion = ds.texto_descripcion_servicio_c
             FROM %I pl
             JOIN detallecotizacion d ON d.id_detalle_c = pl.fk_detalle_cotizacion
             JOIN descripcionservicio ds ON ds.id_descripcion_servicio_c = d.fk_descripcion_servicio
             WHERE pr.fk_plan_muestreo = pl.id_plan
               AND COALESCE(pr.descripcion, %L) = %L',
            tabla_proc, tabla_plan, '', '');
        GET DIAGNOSTICS afectadas = ROW_COUNT;
        RAISE NOTICE 'Descripcion relevante rellenada en % filas de %', afectadas, tabla_proc;
    END IF;

    -- ------------------------------------------------------------------
    -- Paso 2. Tipo de matriz en Procedimiento: se vacia si no es una
    -- opcion del catalogo, porque entonces es la descripcion vieja.
    -- ------------------------------------------------------------------
    IF tabla_proc IS NOT NULL THEN
        EXECUTE format(
            'UPDATE %I
             SET tipo = NULL
             WHERE tipo IS NOT NULL
               AND tipo <> %L
               AND tipo NOT IN (
                   SELECT valor_catalogo_plan_pl FROM catalogoplanmuestreo
                   WHERE tipo_lista = %L)', tabla_proc, '', 'TIPO_MATRIZ');
        GET DIAGNOSTICS afectadas = ROW_COUNT;
        RAISE NOTICE 'Tipo de matriz vaciado en % filas de %', afectadas, tabla_proc;
    END IF;

    -- ------------------------------------------------------------------
    -- Paso 3. Lo mismo en Informacion de la Matriz.
    -- ------------------------------------------------------------------
    IF tabla_matriz IS NULL THEN
        RAISE NOTICE 'No se encontro la tabla de Informacion de la Matriz.';
    ELSE
        EXECUTE format(
            'UPDATE %I
             SET tipo_matriz = NULL
             WHERE tipo_matriz IS NOT NULL
               AND tipo_matriz <> %L
               AND tipo_matriz NOT IN (
                   SELECT valor_catalogo_plan_pl FROM catalogoplanmuestreo
                   WHERE tipo_lista = %L)', tabla_matriz, '', 'TIPO_MATRIZ');
        GET DIAGNOSTICS afectadas = ROW_COUNT;
        RAISE NOTICE 'Tipo de matriz vaciado en % filas de %', afectadas, tabla_matriz;
    END IF;

END $$;

COMMIT;

-- ---------------------------------------------------------------------------
-- IMPORTANTE: ejecute primero datos-catalogoplan.sql.
--
-- Los pasos 2 y 3 comparan contra el catalogo TIPO_MATRIZ. Si esta vacio, la
-- condicion "NOT IN (catalogo)" se cumple para todas las filas y se vaciarian
-- tambien los tipos de matriz que esten bien puestos. El paso 1 no depende del
-- catalogo y es seguro en cualquier caso.
-- ---------------------------------------------------------------------------
