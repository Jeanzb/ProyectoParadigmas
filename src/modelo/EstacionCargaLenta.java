package modelo;

public class EstacionCargaLenta extends EstacionBase{
    private int velocidadCarga;
    private int capacidad;

    public EstacionCargaLenta(int id, String ubicacion, PuntoDeCarga puntoDeCarga,
                              boolean estado, String provincia, String codigoDeEstacion,
                              int velocidadCarga, int capacidad) {
        super(id, ubicacion, puntoDeCarga, estado, provincia, codigoDeEstacion);
        this.velocidadCarga = velocidadCarga;
        this.capacidad = capacidad;
    }

    @Override
    public String getTipoEstacion() { return "Carga Lenta"; }
    @Override
    public int getVelocidadCarga() { return velocidadCarga; }
    @Override
    public int getCapacidad() { return capacidad; }

    @Override
    public void realizarMantenimiento() {

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

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }



    public boolean verficarDisponibilidad(int capacidad) {
        return this.capacidad >= capacidad;
    }



}