package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public abstract class EstacionBase implements Serializable {

    protected int id;
    protected String ubicacion;
    protected PuntoDeCarga puntoDeCarga;
    protected boolean estado;
    protected String provincia;
    protected String codigoDeEstacion;
    protected Mantenimiento mantenimiento;

    public EstacionBase(int id, String ubicacion, PuntoDeCarga puntoDeCarga,
                        boolean estado, String provincia, String codigoDeEstacion) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.puntoDeCarga = puntoDeCarga;
        this.estado = estado;
        this.provincia = provincia;
        this.codigoDeEstacion = codigoDeEstacion;
    }

    // Métodos abstractos que las subclases deben implementar
    public abstract String getTipoEstacion();

    public abstract int getVelocidadCarga();

    public abstract int getCapacidad();


    public int getId() {
        return id;
    }

    public String getCodigoDeEstacion() {
        return codigoDeEstacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public PuntoDeCarga getPuntoDeCarga() {
        return puntoDeCarga;
    }

    public String obtenerEstado() {
        return String.format("ID: %d, Código: %s, Ubicación: %s, Provincia: %s, " +
                        "Estado: %s, Tipo: %s, Velocidad: %d kW, Capacidad: %d kW",
                id, codigoDeEstacion, ubicacion, provincia,
                (estado ? "Disponible" : "No disponible"),
                getTipoEstacion(), getVelocidadCarga(), getCapacidad());
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    public void setPuntoDeCarga(PuntoDeCarga puntoDeCarga) {
        this.puntoDeCarga = puntoDeCarga;
    }


    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public void actualizarEstado(boolean nuevoEstado) {
        this.estado = nuevoEstado;
    }

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


    public abstract void realizarMantenimiento();


    protected String ahora() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }


    public boolean estaOperativa() {
        return estado;
    }


    public int calcularTiempoCarga(int capacidad) {
        return 4;
    }

}