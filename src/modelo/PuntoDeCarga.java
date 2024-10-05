package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class PuntoDeCarga implements Serializable {
    private boolean operativo;
    private int cargasRealizadas;
    private String estadoActual;
    private List<String> historialFallos;

    public PuntoDeCarga() {
        this.operativo = true;
        this.cargasRealizadas = 0;
        this.estadoActual = "Disponible";
        this.historialFallos = new ArrayList<>();
    }

    public boolean isOperativo() {
        return operativo;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public int getCargasRealizadas() {
        return cargasRealizadas;
    }

    public String realizarCarga() {
        if (!operativo) {
            return "Error: Punto de carga no operativo";
        }
        cargasRealizadas++;
        return "Carga realizada exitosamente. Total de cargas: " + cargasRealizadas;
    }

    public String reportarFallo(String descripcion) {
        operativo = false;
        estadoActual = "Fuera de servicio";
        historialFallos.add("Fallo reportado: " + descripcion + " - Fecha: " +
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return "Fallo reportado y registrado";
    }

    public List<String> getHistorialFallos() {
        return new ArrayList<>(historialFallos);
    }

    public void setOperativo(boolean operativo) {
        this.operativo = operativo;
    }

    public void setCargasRealizadas(int cargasRealizadas) {
        this.cargasRealizadas = cargasRealizadas;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public void setHistorialFallos(List<String> historialFallos) {
        this.historialFallos = historialFallos;
    }




    public double calcularCosto(double kilovatiosConsumidos) {
        double costoPorKWh = 0.15; // Ejemplo de costo por kWh
        return kilovatiosConsumidos * costoPorKWh;
    }


    public double calcularTiempoDeCarga(double nivelBateria, double capacidadBateria) {
        double porcentajeRestante = 100 - nivelBateria;
        double kWhNecesarios = (porcentajeRestante / 100) * capacidadBateria;
        double velocidadDeCarga = 7.4; // Ejemplo de velocidad de carga en kW
        return kWhNecesarios / velocidadDeCarga;
    }





}