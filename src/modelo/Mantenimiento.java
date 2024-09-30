package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Mantenimiento {

    private int id;
    private String descripcion;
    private String fecha;

    public Mantenimiento(int id, String descripcion, String fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Mantenimiento{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }


    public boolean validarEstado(PuntoDeCarga puntoDeCarga) {
        if (puntoDeCarga == null) {
            return false;
        }
        return puntoDeCarga.isEstado(); // Asumiendo que 'estado' true significa operativo o en mantenimiento
    }

    //Metodo que no se puede sobrescribir
    final public String calcularProximoMantenimiento(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaAdq = LocalDate.parse(fecha, formatter);
        LocalDate proximoMantenimiento = fechaAdq.plus(6, ChronoUnit.MONTHS);
        return proximoMantenimiento.format(formatter);
    }


}