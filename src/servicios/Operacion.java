package servicios;

import modelo.EstacionBase;

/**
 * Interface que define las operaciones CRUD para la gestión de estaciones de carga.
 */
public interface Operacion {

    /**
     * Crea una nueva estación de carga.
     *
     * @param estacion La estación de carga a crear.
     * @return Un mensaje indicando el resultado de la operación.
     */
    String create(EstacionBase estacion);

    /**
     * Lee una estación de carga por su ID.
     *
     * @param id El ID de la estación de carga a leer.
     * @return La estación de carga correspondiente al ID, o null si no se encuentra.
     */
    EstacionBase read(int id);

    /**
     * Actualiza una estación de carga existente.
     *
     * @param id El ID de la estación de carga a actualizar.
     * @param nuevaEstacion La nueva información de la estación de carga.
     * @return Un mensaje indicando el resultado de la operación.
     */
    String update(int id, EstacionBase nuevaEstacion);

    /**
     * Elimina una estación de carga por su ID.
     *
     * @param id El ID de la estación de carga a eliminar.
     * @return La estación de carga eliminada, o null si no se encuentra.
     */
    EstacionBase delete(int id);

    /**
     * Lee todas las estaciones de carga.
     *
     * @return Un arreglo con todas las estaciones de carga.
     */
    EstacionBase[] readAll();

    /**
     * Deserializa un archivo para obtener un arreglo de estaciones de carga.
     *
     * @param path La ruta del archivo.
     * @param name El nombre del archivo.
     * @return Un arreglo de estaciones de carga deserializadas.
     */
    EstacionBase[] deserializar(String path, String name);

    /**
     * Serializa un arreglo de estaciones de carga y lo guarda en un archivo.
     *
     * @param estaciones El arreglo de estaciones de carga a serializar.
     * @param path La ruta del archivo.
     * @param name El nombre del archivo.
     * @return Un mensaje indicando el resultado de la operación.
     */
    String serializar(EstacionBase[] estaciones, String path, String name);
}