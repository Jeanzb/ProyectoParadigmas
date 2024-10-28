package modelo;

/**
 * Clase que representa una estación de carga rápida.
 * Extiende la clase EstacionBase y añade atributos específicos para la velocidad de carga y la capacidad.
 */
public class EstacionCargaRapida extends EstacionBase {
    private int velocidadCarga;
    private int capacidad;

    /**
     * Constructor para crear una estación de carga rápida.
     *
     * @param id                El ID de la estación.
     * @param ubicacion         La ubicación de la estación.
     * @param puntoDeCarga      El punto de carga asociado a la estación.
     * @param estado            El estado de la estación (operativa o no).
     * @param provincia         La provincia donde se encuentra la estación.
     * @param codigoDeEstacion  El código identificador de la estación.
     * @param velocidadCarga    La velocidad de carga de la estación.
     * @param capacidad         La capacidad de la estación.
     */
    public EstacionCargaRapida(int id, String ubicacion, PuntoDeCarga puntoDeCarga,
                               boolean estado, String provincia, String codigoDeEstacion,
                               int velocidadCarga, int capacidad) {
        super(id, ubicacion, puntoDeCarga, estado, provincia, codigoDeEstacion);
        this.velocidadCarga = velocidadCarga;
        this.capacidad = capacidad;
    }

    /**
     * Obtiene el tipo de estación.
     *
     * @return El tipo de estación como una cadena.
     */
    @Override
    public String getTipoEstacion() {
        return "Carga Rápida";
    }

    /**
     * Obtiene la velocidad de carga de la estación.
     *
     * @return La velocidad de carga.
     */
    @Override
    public int getVelocidadCarga() {
        return velocidadCarga;
    }

    /**
     * Obtiene la capacidad de la estación.
     *
     * @return La capacidad.
     */
    @Override
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Realiza el mantenimiento especializado en la estación de carga rápida.
     */
    @Override
    public void realizarMantenimiento() {
        System.out.println("Realizando mantenimiento especializado en la estación de carga rápida.");
    }

    /**
     * Verifica si la estación tiene suficiente capacidad para una carga específica.
     *
     * @param capacidad La capacidad requerida.
     * @return true si la estación tiene suficiente capacidad, false en caso contrario.
     */
    public boolean verificarDisponibilidad(int capacidad) {
        return this.capacidad >= capacidad;
    }

    /**
     * Calcula el tiempo de carga basado en la capacidad y la velocidad de carga.
     *
     * @param capacidad La capacidad de la estación.
     * @return El tiempo de carga calculado.
     */
    @Override
    public int calcularTiempoCarga(int capacidad) {
        return capacidad / this.velocidadCarga;
    }

    /**
     * Establece la velocidad de carga de la estación.
     *
     * @param velocidadCarga La nueva velocidad de carga.
     */
    public void setVelocidadCarga(int velocidadCarga) {
        this.velocidadCarga = velocidadCarga;
    }

    /**
     * Establece la capacidad de la estación.
     *
     * @param capacidad La nueva capacidad.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "EstacionCargaRapida{" +
                "velocidadCarga=" + velocidadCarga +
                ", capacidad=" + capacidad +
                ", id=" + id +
                ", ubicacion='" + ubicacion + '\'' +
                ", puntoDeCarga=" + puntoDeCarga +
                ", estado=" + estado +
                ", provincia='" + provincia + '\'' +
                ", codigoDeEstacion='" + codigoDeEstacion + '\'' +
                ", mantenimiento=" + mantenimiento +
                '}';
    }
}