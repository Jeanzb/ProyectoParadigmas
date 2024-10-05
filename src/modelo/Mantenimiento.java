package modelo;

import java.util.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Mantenimiento {
    private LocalDateTime ultimoMantenimiento;
    private List<String> historialMantenimiento;
    private boolean enMantenimiento;

    public Mantenimiento() {
        this.historialMantenimiento = new ArrayList<>();
        this.enMantenimiento = false;
    }

    public void iniciarMantenimiento() {
        this.enMantenimiento = true;
        this.ultimoMantenimiento = LocalDateTime.now();
        this.historialMantenimiento.add("Mantenimiento iniciado: " +
                ultimoMantenimiento.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    public void finalizarMantenimiento() {
        this.enMantenimiento = false;
        this.historialMantenimiento.add("Mantenimiento finalizado: " +
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    public boolean isEnMantenimiento() {
        return enMantenimiento;
    }

    public LocalDateTime getUltimoMantenimiento() {
        return ultimoMantenimiento;
    }

    public List<String> getHistorialMantenimiento() {
        return new ArrayList<>(historialMantenimiento);
    }

    public void setUltimoMantenimiento(LocalDateTime ultimoMantenimiento) {
        this.ultimoMantenimiento = ultimoMantenimiento;
    }

    public void setHistorialMantenimiento(List<String> historialMantenimiento) {
        this.historialMantenimiento = historialMantenimiento;
    }

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




