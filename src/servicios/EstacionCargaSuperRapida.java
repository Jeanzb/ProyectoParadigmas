package servicios;

import modelo.EstacionCargaRapida;
import modelo.PuntoDeCarga;

/**
 * Clase que representa una estación de carga super rápida, extendiendo la funcionalidad de una estación de carga rápida.
 */
public class EstacionCargaSuperRapida extends EstacionCargaRapida {

    private int superVelocidad;

    /**
     * Constructor para crear una estación de carga super rápida.
     *
     * @param id                El ID de la estación.
     * @param ubicacion         La ubicación de la estación.
     * @param puntoDeCarga      El punto de carga asociado a la estación.
     * @param estado            El estado de la estación (operativa o no).
     * @param provincia         La provincia donde se encuentra la estación.
     * @param codigoDeEstacion  El código identificador de la estación.
     * @param velocidadCarga    La velocidad de carga de la estación.
     * @param capacidad         La capacidad de la estación.
     * @param superVelocidad    La super velocidad de carga de la estación.
     */
    public EstacionCargaSuperRapida(int id, String ubicacion, PuntoDeCarga puntoDeCarga, boolean estado, String provincia, String codigoDeEstacion, int velocidadCarga, int capacidad, int superVelocidad) {
        super(id, ubicacion, puntoDeCarga, estado, provincia, codigoDeEstacion, velocidadCarga, capacidad);
        this.superVelocidad = superVelocidad;
    }

    /**
     * Obtiene la super velocidad de carga de la estación.
     *
     * @return La super velocidad de carga.
     */
    public int getSuperVelocidad() {
        return superVelocidad;
    }

    /**
     * Establece la super velocidad de carga de la estación.
     *
     * @param superVelocidad La nueva super velocidad de carga.
     */
    public void setSuperVelocidad(int superVelocidad) {
        this.superVelocidad = superVelocidad;
    }

    @Override
    public String toString() {
        return "EstacionCargaSuperRapida{" +
                "superVelocidad=" + superVelocidad +
                ", id=" + id +
                ", ubicacion='" + ubicacion + '\'' +
                ", puntoDeCarga=" + puntoDeCarga +
                ", estado=" + estado +
                ", provincia='" + provincia + '\'' +
                ", codigoDeEstacion='" + codigoDeEstacion + '\'' +
                ", mantenimiento=" + mantenimiento +
                '}';
    }

    /**
     * Calcula el tiempo de carga basado en la capacidad y la super velocidad de carga.
     *
     * @param capacidad La capacidad de la estación.
     * @return El tiempo de carga calculado.
     */
    @Override
    public int calcularTiempoCarga(int capacidad) {
        return capacidad / this.superVelocidad;
    }
}