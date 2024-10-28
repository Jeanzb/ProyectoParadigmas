package modelo;

/**
 * Clase que representa una estación de carga lenta.
 * Extiende la clase EstacionBase y añade atributos específicos para la velocidad de carga y la capacidad.
 */
public class EstacionCargaLenta extends EstacionBase {
    private int velocidadCarga;
    private int capacidad;

    /**
     * Constructor para crear una estación de carga lenta.
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
    public EstacionCargaLenta(int id, String ubicacion, PuntoDeCarga puntoDeCarga,
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
        return "Carga Lenta";
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
     * Realiza el mantenimiento de la estación de carga lenta.
     */
    @Override
    public void realizarMantenimiento() {
        // Implementación del mantenimiento para la estación de carga lenta
    }

    /**
     * Establece la capacidad de la estación.
     *
     * @param capacidad La nueva capacidad.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Verifica si la estación tiene suficiente capacidad para una carga específica.
     *
     * @param capacidad La capacidad requerida.
     * @return true si la estación tiene suficiente capacidad, false en caso contrario.
     */
    public boolean verficarDisponibilidad(int capacidad) {
        return this.capacidad >= capacidad;
    }

    @Override
    public String toString() {
        return "EstacionCargaLenta{" +
                "mantenimiento=" + mantenimiento +
                ", codigoDeEstacion='" + codigoDeEstacion + '\'' +
                ", provincia='" + provincia + '\'' +
                ", estado=" + estado +
                ", puntoDeCarga=" + puntoDeCarga +
                ", ubicacion='" + ubicacion + '\'' +
                ", id=" + id +
                ", capacidad=" + capacidad +
                ", velocidadCarga=" + velocidadCarga +
                '}';
    }
}