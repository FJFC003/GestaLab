-- ---------------------------------------------------------------------------
-- Datos iniciales del catalogo Tipo de Toma de Muestra
--
-- La tabla TipoTomaMuestra y la columna fk_tipo_toma_muestra de
-- DetalleCotizacion las crea Hibernate solo, porque application.properties
-- tiene spring.jpa.hibernate.ddl-auto=update. Levante primero el backend
-- (puerto 8080) y despues ejecute este script en la base gestalab.
--
-- Ejecucion desde psql:
--   psql -U postgres -d gestalab -f datos-tipotomamuestra.sql
-- ---------------------------------------------------------------------------

INSERT INTO tipotomamuestra (codigo_tipo_toma_muestra_c, texto_tipo_toma_muestra_c, observacion_tipo_toma_muestra_c)
SELECT v.codigo, v.texto, v.observacion
FROM (VALUES
    ('TM-01', 'Muestra Simple',
     'Toma puntual en un solo momento y un solo punto. Refleja la condicion instantanea del efluente o cuerpo receptor.'),
    ('TM-02', 'Muestra Compuesta',
     'Mezcla de alicuotas tomadas a intervalos definidos durante la jornada. Entrega un valor promedio del periodo muestreado.'),
    ('TM-03', 'Muestra Integrada',
     'Combinacion de muestras tomadas en varios puntos al mismo tiempo. Se usa cuando la matriz no es homogenea.'),
    ('TM-04', 'Muestreo Isocinetico',
     'Aplicable a emisiones de fuentes fijas. La velocidad de succion iguala la del gas en la chimenea (NTE INEN 2266).'),
    ('TM-05', 'Medicion en Sitio',
     'El parametro se mide directamente en campo con equipo portatil; no se traslada muestra al laboratorio.'),
    ('TM-06', 'Muestra Entregada por el Cliente',
     'El cliente entrega la muestra en recepcion. El laboratorio no se responsabiliza del procedimiento de toma ni de la cadena de custodia previa.')
) AS v(codigo, texto, observacion)
WHERE NOT EXISTS (
    SELECT 1 FROM tipotomamuestra t WHERE t.codigo_tipo_toma_muestra_c = v.codigo
);
