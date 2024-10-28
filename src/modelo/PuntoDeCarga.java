package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Clase que representa un punto de carga para vehículos eléctricos.
 * Implementa la interfaz Serializable para permitir la serialización de sus instancias.
 */
public class PuntoDeCarga implements Serializable {
    private boolean operativo;
    private int cargasRealizadas;
    private String estadoActual;
    private List<String> historialFallos;

    /**
     * Constructor que inicializa un punto de carga con valores por defecto.
     * El punto de carga se inicializa como operativo, con 0 cargas realizadas y estado "Disponible".
     */
    public PuntoDeCarga() {
        this.operativo = true;
        this.cargasRealizadas = 0;
        this.estadoActual = "Disponible";
        this.historialFallos = new ArrayList<>();
    }

    /**
     * Verifica si el punto de carga está operativo.
     *
     * @return true si el punto de carga está operativo, false en caso contrario.
     */
    public boolean isOperativo() {
        return operativo;
    }

    /**
     * Obtiene el estado actual del punto de carga.
     *
     * @return El estado actual del punto de carga.
     */
    public String getEstadoActual() {
        return estadoActual;
    }

    /**
     * Obtiene el número de cargas realizadas en el punto de carga.
     *
     * @return El número de cargas realizadas.
     */
    public int getCargasRealizadas() {
        return cargasRealizadas;
    }

    /**
     * Realiza una carga en el punto de carga.
     *
     * @return Un mensaje indicando el resultado de la operación.
     */
    public String realizarCarga() {
        if (!operativo) {
            return "Error: Punto de carga no operativo";
        }
        cargasRealizadas++;
        return "Carga realizada exitosamente. Total de cargas: " + cargasRealizadas;
    }

    /**
     * Reporta un fallo en el punto de carga.
     *
     * @param descripcion La descripción del fallo.
     * @return Un mensaje indicando el resultado de la operación.
     */
    public String reportarFallo(String descripcion) {
        operativo = false;
        estadoActual = "Fuera de servicio";
        historialFallos.add("Fallo reportado: " + descripcion + " - Fecha: " +
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return "Fallo reportado y registrado";
    }

    /**
     * Obtiene el historial de fallos del punto de carga.
     *
     * @return Una lista con el historial de fallos.
     */
    public List<String> getHistorialFallos() {
        return new ArrayList<>(historialFallos);
    }

    /**
     * Establece el estado operativo del punto de carga.
     *
     * @param operativo El nuevo estado operativo.
     */
    public void setOperativo(boolean operativo) {
        this.operativo = operativo;
    }

    /**
     * Establece el número de cargas realizadas en el punto de carga.
     *
     * @param cargasRealizadas El nuevo número de cargas realizadas.
     */
    public void setCargasRealizadas(int cargasRealizadas) {
        this.cargasRealizadas = cargasRealizadas;
    }

    /**
     * Establece el estado actual del punto de carga.
     *
     * @param estadoActual El nuevo estado actual.
     */
    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    /**
     * Establece el historial de fallos del punto de carga.
     *
     * @param historialFallos La nueva lista de historial de fallos.
     */
    public void setHistorialFallos(List<String> historialFallos) {
        this.historialFallos = historialFallos;
    }

    /**
     * Calcula el costo de la carga basada en los kilovatios consumidos.
     *
     * @param kilovatiosConsumidos La cantidad de kilovatios consumidos.
     * @return El costo de la carga.
     */
    public double calcularCosto(double kilovatiosConsumidos) {
        double costoPorKWh = 0.15; // Ejemplo de costo por kWh
        return kilovatiosConsumidos * costoPorKWh;
    }

    /**
     * Calcula el tiempo de carga basado en el nivel de batería y la capacidad de la batería.
     *
     * @param nivelBateria     El nivel actual de la batería en porcentaje.
     * @param capacidadBateria La capacidad total de la batería en kWh.
     * @return El tiempo de carga calculado en horas.
     */
    public double calcularTiempoDeCarga(double nivelBateria, double capacidadBateria) {
        double porcentajeRestante = 100 - nivelBateria;
        double kWhNecesarios = (porcentajeRestante / 100) * capacidadBateria;
        double velocidadDeCarga = 7.4; // Ejemplo de velocidad de carga en kW
        return kWhNecesarios / velocidadDeCarga;
    }
}