package modelo;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa el mantenimiento de una estación de carga.
 * Gestiona el estado de mantenimiento, el historial de mantenimientos y la fecha del último mantenimiento.
 */
public class Mantenimiento {
    private LocalDateTime ultimoMantenimiento;
    private List<String> historialMantenimiento;
    private boolean enMantenimiento;

    /**
     * Constructor que inicializa un objeto de mantenimiento con valores por defecto.
     * El historial de mantenimiento se inicializa como una lista vacía y el estado de mantenimiento se establece en false.
     */
    public Mantenimiento() {
        this.historialMantenimiento = new ArrayList<>();
        this.enMantenimiento = false;
    }

    /**
     * Inicia el mantenimiento de la estación.
     * Establece el estado de mantenimiento en true, registra la fecha y hora actuales como el último mantenimiento,
     * y agrega una entrada al historial de mantenimiento.
     */
    public void iniciarMantenimiento() {
        this.enMantenimiento = true;
        this.ultimoMantenimiento = LocalDateTime.now();
        this.historialMantenimiento.add("Mantenimiento iniciado: " +
                ultimoMantenimiento.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    /**
     * Finaliza el mantenimiento de la estación.
     * Establece el estado de mantenimiento en false y agrega una entrada al historial de mantenimiento.
     */
    public void finalizarMantenimiento() {
        this.enMantenimiento = false;
        this.historialMantenimiento.add("Mantenimiento finalizado: " +
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    /**
     * Verifica si la estación está en mantenimiento.
     *
     * @return true si la estación está en mantenimiento, false en caso contrario.
     */
    public boolean isEnMantenimiento() {
        return enMantenimiento;
    }

    /**
     * Obtiene la fecha y hora del último mantenimiento realizado.
     *
     * @return La fecha y hora del último mantenimiento.
     */
    public LocalDateTime getUltimoMantenimiento() {
        return ultimoMantenimiento;
    }

    /**
     * Obtiene el historial de mantenimientos realizados.
     *
     * @return Una lista con el historial de mantenimientos.
     */
    public List<String> getHistorialMantenimiento() {
        return new ArrayList<>(historialMantenimiento);
    }

    /**
     * Establece la fecha y hora del último mantenimiento realizado.
     *
     * @param ultimoMantenimiento La nueva fecha y hora del último mantenimiento.
     */
    public void setUltimoMantenimiento(LocalDateTime ultimoMantenimiento) {
        this.ultimoMantenimiento = ultimoMantenimiento;
    }

    /**
     * Establece el historial de mantenimientos realizados.
     *
     * @param historialMantenimiento La nueva lista de historial de mantenimientos.
     */
    public void setHistorialMantenimiento(List<String> historialMantenimiento) {
        this.historialMantenimiento = historialMantenimiento;
    }

    /**
     * Establece el estado de mantenimiento de la estación.
     *
     * @param enMantenimiento El nuevo estado de mantenimiento.
     */
    public void setEnMantenimiento(boolean enMantenimiento) {
        this.enMantenimiento = enMantenimiento;
    }

    @Override
    public String toString() {
        return "Mantenimiento{" +
                "ultimoMantenimiento=" + ultimoMantenimiento +
                ", historialMantenimiento=" + historialMantenimiento +
                ", enMantenimiento=" + enMantenimiento +
                '}';
    }
}