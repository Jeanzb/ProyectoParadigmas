package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase abstracta que representa una estación de carga base.
 * Implementa la interfaz Serializable para permitir la serialización de sus instancias.
 */
public abstract class EstacionBase implements Serializable {

    protected int id;
    protected String ubicacion;
    protected PuntoDeCarga puntoDeCarga;
    protected boolean estado;
    protected String provincia;
    protected String codigoDeEstacion;
    protected Mantenimiento mantenimiento;

    /**
     * Constructor para crear una estación de carga base.
     *
     * @param id                El ID de la estación.
     * @param ubicacion         La ubicación de la estación.
     * @param puntoDeCarga      El punto de carga asociado a la estación.
     * @param estado            El estado de la estación (operativa o no).
     * @param provincia         La provincia donde se encuentra la estación.
     * @param codigoDeEstacion  El código identificador de la estación.
     */
    public EstacionBase(int id, String ubicacion, PuntoDeCarga puntoDeCarga,
                        boolean estado, String provincia, String codigoDeEstacion) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.puntoDeCarga = puntoDeCarga;
        this.estado = estado;
        this.provincia = provincia;
        this.codigoDeEstacion = codigoDeEstacion;
    }

    /**
     * Obtiene el tipo de estación.
     *
     * @return El tipo de estación como una cadena.
     */
    public abstract String getTipoEstacion();

    /**
     * Obtiene la velocidad de carga de la estación.
     *
     * @return La velocidad de carga.
     */
    public abstract int getVelocidadCarga();

    /**
     * Obtiene la capacidad de la estación.
     *
     * @return La capacidad.
     */
    public abstract int getCapacidad();

    /**
     * Obtiene el ID de la estación.
     *
     * @return El ID de la estación.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el código de la estación.
     *
     * @return El código de la estación.
     */
    public String getCodigoDeEstacion() {
        return codigoDeEstacion;
    }

    /**
     * Verifica si la estación está operativa.
     *
     * @return true si la estación está operativa, false en caso contrario.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado de la estación.
     *
     * @param estado El nuevo estado de la estación.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el punto de carga asociado a la estación.
     *
     * @return El punto de carga.
     */
    public PuntoDeCarga getPuntoDeCarga() {
        return puntoDeCarga;
    }

    /**
     * Obtiene una cadena que representa el estado de la estación.
     *
     * @return Una cadena con el estado de la estación.
     */
    public String obtenerEstado() {
        return String.format("ID: %d, Código: %s, Ubicación: %s, Provincia: %s, " +
                        "Estado: %s, Tipo: %s, Velocidad: %d kW, Capacidad: %d kW",
                id, codigoDeEstacion, ubicacion, provincia,
                (estado ? "Disponible" : "No disponible"),
                getTipoEstacion(), getVelocidadCarga(), getCapacidad());
    }

    /**
     * Establece el ID de la estación.
     *
     * @param id El nuevo ID de la estación.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la ubicación de la estación.
     *
     * @return La ubicación de la estación.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación de la estación.
     *
     * @param ubicacion La nueva ubicación de la estación.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Establece el punto de carga asociado a la estación.
     *
     * @param puntoDeCarga El nuevo punto de carga.
     */
    public void setPuntoDeCarga(PuntoDeCarga puntoDeCarga) {
        this.puntoDeCarga = puntoDeCarga;
    }

    /**
     * Obtiene la provincia donde se encuentra la estación.
     *
     * @return La provincia de la estación.
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Establece la provincia donde se encuentra la estación.
     *
     * @param provincia La nueva provincia de la estación.
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Obtiene el mantenimiento asociado a la estación.
     *
     * @return El mantenimiento de la estación.
     */
    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    /**
     * Establece el mantenimiento asociado a la estación.
     *
     * @param mantenimiento El nuevo mantenimiento de la estación.
     */
    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    /**
     * Actualiza el estado de la estación.
     *
     * @param nuevoEstado El nuevo estado de la estación.
     */
    public void actualizarEstado(boolean nuevoEstado) {
        this.estado = nuevoEstado;
    }

    /**
     * Actualiza el estado de la estación con un motivo.
     *
     * @param nuevoEstado El nuevo estado de la estación.
     * @param motivo      El motivo del cambio de estado.
     */
    public void actualizarEstado(boolean nuevoEstado, String motivo) {
        this.estado = nuevoEstado;
        System.out.println("El estado fue actualizado por la siguiente razón: " + motivo);
    }

    @Override
    public String toString() {
        return "EstacionBase{" +
                "id=" + id +
                ", ubicacion='" + ubicacion + '\'' +
                ", puntoDeCarga=" + puntoDeCarga +
                ", estado=" + estado +
                ", provincia='" + provincia + '\'' +
                ", mantenimiento=" + mantenimiento +
                '}';
    }

    /**
     * Realiza el mantenimiento de la estación.
     * Este método debe ser implementado por las subclases.
     */
    public abstract void realizarMantenimiento();

    /**
     * Obtiene la fecha y hora actuales en formato "yyyy/MM/dd HH:mm:ss".
     *
     * @return La fecha y hora actuales como una cadena.
     */
    protected String ahora() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    /**
     * Verifica si la estación está operativa.
     *
     * @return true si la estación está operativa, false en caso contrario.
     */
    public boolean estaOperativa() {
        return estado;
    }

    /**
     * Calcula el tiempo de carga basado en la capacidad.
     * Este método puede ser sobrescrito por las subclases.
     *
     * @param capacidad La capacidad de la estación.
     * @return El tiempo de carga calculado.
     */
    public int calcularTiempoCarga(int capacidad) {
        return 4;
    }
}