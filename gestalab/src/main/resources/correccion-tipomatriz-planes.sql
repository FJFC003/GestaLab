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
--   Paso 1  Procedimiento -> vacia Tipo de matriz si su valor no es una opcion
--           real del catalogo (ahi quedo la descripcion del servicio).
--   Paso 2  Informacion de la Matriz -> lo mismo con Tipo de matriz.
--
-- La Descripcion relevante NO se rellena: la Coordinadora Tecnica la redacta a
-- mano en la pantalla del plan. Es una nota del procedimiento de muestreo, no
-- el texto comercial del servicio.
--
-- El codigo ya quedo arreglado y los planes nuevos nacen bien; esto es solo
-- para los que ya existen.
--
--   psql -U postgres -d gestalab -f correccion-tipomatriz-planes.sql
--
-- Se puede ejecutar mas de una vez: solo toca filas que sigan mal.
-- ---------------------------------------------------------------------------

BEGIN;

-- Las tablas se declaran con espacios en el nombre ("Procedimiento de Muestra",
-- "Informacion de la Matriz"), asi que se localizan por una columna
-- caracteristica en vez de escribirlas a mano.
DO $$
DECLARE
    tabla_proc   text;
    tabla_matriz text;
    afectadas    integer;
BEGIN

    SELECT table_name INTO tabla_proc
    FROM information_schema.columns
    WHERE table_schema = current_schema() AND column_name = 'precausiones'
    LIMIT 1;

    SELECT table_name INTO tabla_matriz
    FROM information_schema.columns
    WHERE table_schema = current_schema() AND column_name = 'descripcion_del_punto'
    LIMIT 1;

    -- ------------------------------------------------------------------
    -- Paso 1. Tipo de matriz en Procedimiento: se vacia si no es una
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
    -- Paso 2. Lo mismo en Informacion de la Matriz.
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
-- Ambos pasos comparan contra el catalogo TIPO_MATRIZ. Si esta vacio, la
-- condicion "NOT IN (catalogo)" se cumple para todas las filas y se vaciarian
-- tambien los tipos de matriz que esten bien puestos.
-- ---------------------------------------------------------------------------
