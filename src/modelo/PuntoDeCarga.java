package modelo;
import java.util.Arrays;


public class PuntoDeCarga {

    private int id;

    /**
     * 
     */
    private String nombre;



    private String direccion;

    /**
     * 
     */
    private String tiposDeConector;

    /**
     * 
     */
    private boolean estado;

    /**
     * 
     */
    private String[ ] historialDeCarga;

    public PuntoDeCarga(int id, String nombre, String direccion, String tiposDeConector, boolean estado, String[] historialDeCarga) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tiposDeConector = tiposDeConector;
        this.estado = estado;
        this.historialDeCarga = historialDeCarga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTiposDeConector() {
        return tiposDeConector;
    }

    public void setTiposDeConector(String tiposDeConector) {
        this.tiposDeConector = tiposDeConector;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String[] getHistorialDeCarga() {
        return historialDeCarga;
    }

    public void setHistorialDeCarga(String[] historialDeCarga) {
        this.historialDeCarga = historialDeCarga;
    }

    @Override
    public String toString() {
        return "PuntoDeCarga{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tiposDeConector='" + tiposDeConector + '\'' +
                ", estado=" + estado +

                ", historialDeCarga=" + Arrays.toString(historialDeCarga) +
                '}';
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

    public void agregarCargaAlHistorial(String nuevaCarga) {
        String[] nuevoHistorial = Arrays.copyOf(historialDeCarga, historialDeCarga.length + 1);
        nuevoHistorial[nuevoHistorial.length - 1] = nuevaCarga;
        historialDeCarga = nuevoHistorial;
    }


}