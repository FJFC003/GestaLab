-- ---------------------------------------------------------------------------
-- Opciones de las listas desplegables del Plan de Muestreo.
--
-- Los valores son los que trae el formato F-PO-02-01 PLAN DE MUESTREO.docx,
-- extraidos de los controles de contenido del propio documento, con dos
-- ajustes pedidos por la Coordinadora Tecnica: "laboratorio" se escribe con
-- mayuscula inicial y Preservacion suma la opcion "Aplica".
--
-- Levante el backend una vez para que Hibernate cree la tabla, y despues:
--   psql -U postgres -d gestalab -f datos-catalogoplan.sql
--
-- Se puede volver a ejecutar sin problema: cada valor se inserta solo si no
-- existe ya en su lista.
--
-- Faltan a proposito las matrices que no son de agua (suelo, ruido, emisiones,
-- calidad del aire): el formato solo contempla agua. Se agregan desde la
-- pantalla Listas del Plan cuando el laboratorio las necesite.
-- ---------------------------------------------------------------------------

-- Si la siembra anterior ya se ejecuto, "laboratorio" quedo en minuscula. Se
-- renombra en vez de insertar la version con mayuscula, para no terminar con
-- las dos en el desplegable. Los planes guardan el texto, asi que los que ya
-- eligieron la opcion conservan el valor viejo hasta que se vuelvan a guardar.
UPDATE catalogoplanmuestreo
SET valor_catalogo_plan_pl = 'Laboratorio'
WHERE tipo_lista = 'SITIO_MEDICION' AND valor_catalogo_plan_pl = 'laboratorio';

INSERT INTO catalogoplanmuestreo (tipo_lista, valor_catalogo_plan_pl, orden_catalogo_plan_pl, estado_catalogo_plan_pl)
SELECT v.tipo, v.valor, v.orden, true
FROM (VALUES
    -- INFORMACION DE LA MATRIZ y PROCEDIMIENTO DE MUESTREO
    ('TIPO_MATRIZ',    'Agua residual',                            1),
    ('TIPO_MATRIZ',    'Agua natural',                             2),
    ('TIPO_MATRIZ',    'Agua de consumo',                          3),
    ('TIPO_MATRIZ',    'Lixiviado',                                4),

    -- PARAMETROS A ANALIZAR - Sitio de medicion
    ('SITIO_MEDICION', 'In situ',                                  1),
    ('SITIO_MEDICION', 'Laboratorio',                              2),

    -- PARAMETROS A ANALIZAR - Preservacion
    -- El formato solo trae "No aplica"; "Aplica" lo pidio la Coordinadora
    -- Tecnica para poder dejar constancia del caso contrario.
    ('PRESERVACION',   'Aplica',                                   1),
    ('PRESERVACION',   'No aplica',                                2),

    -- TIPO DE TOMA / FRECUENCIA Y HORARIOS DE MUESTREO - Frecuencia
    ('FRECUENCIA',     'Única',                                    1),
    ('FRECUENCIA',     'Semanal',                                  2),
    ('FRECUENCIA',     'Trimestral',                               3),
    ('FRECUENCIA',     'Semestral',                                4),
    ('FRECUENCIA',     'Anual',                                    5),

    -- RECURSOS Y CRONOGRAMA - Recursos
    ('RECURSO',        'Por el laboratorio',                       1),
    ('RECURSO',        'Por el cliente',                           2),
    ('RECURSO',        'Por parte del laboratorio y del cliente',  3)
) AS v(tipo, valor, orden)
WHERE NOT EXISTS (
    SELECT 1 FROM catalogoplanmuestreo c
    WHERE c.tipo_lista = v.tipo AND c.valor_catalogo_plan_pl = v.valor
);

-- ---------------------------------------------------------------------------
-- Los parametros y sus unidades NO se siembran aqui.
--
-- El desplegable de Parametros del plan se alimenta de catalogoparametros, que
-- es donde el laboratorio ya mantiene sus ensayos y donde la cotizacion los
-- toma. Duplicarlos permitiria que el plan dijera "pH / mg/L" mientras la
-- cotizacion dice "pH / U de pH".
--
-- El formato lista estos cinco, con su unidad. Verifique que existan en
-- catalogoparametros y agreguelos desde la pantalla Parametros si faltan:
--
--   pH                       U de pH
--   Conductividad eléctrica  uS/cm
--   Oxígeno disuelto         % / mg/L
--   Temperatura              ° C
--   Cloro libre residual     mg/L
--
-- Lo mismo con Tipo de toma de muestra: usa el catalogo TipoTomaMuestra que ya
-- comparte con la cotizacion (Muestra Simple y Muestra Compuesta cubren lo que
-- pide el formato).
-- ---------------------------------------------------------------------------
