package modelo;

public class EstacionCargaLenta extends EstacionBase{

    private int velocidadCarga;


    private int capacidad;

    public EstacionCargaLenta(int id, String ubicacion, PuntoDeCarga puntoDeCarga, boolean estado, String provincia, String codigoDeEstacion, int velocidadCarga, int capacidad) {
        super(id, ubicacion, puntoDeCarga, estado, provincia, codigoDeEstacion);
        this.velocidadCarga = velocidadCarga;
        this.capacidad = capacidad;
    }

    public int getVelocidadCarga() {
        return velocidadCarga;
    }

    public void setVelocidadCarga(int velocidadCarga) {
        this.velocidadCarga = velocidadCarga;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "EstacionCargaLenta{" +
                "velocidadCarga=" + velocidadCarga +
                ", Capacidad=" + capacidad +
                '}';
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public void  realizarMantenimiento() {
        System.out.println("Realizando mantenimiento especializado en la estación de carga lenta.");
    }

    public boolean verficarDisponibilidad(int capacidad) {
        return this.capacidad >= capacidad;
    }

    @Override
    public int calcularTiempoCarga(int capacidad) {
        return capacidad / this.velocidadCarga;
    }

}