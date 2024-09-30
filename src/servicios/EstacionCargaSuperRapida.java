package servicios;
import modelo.EstacionCargaRapida;
import modelo.PuntoDeCarga;

public class EstacionCargaSuperRapida extends EstacionCargaRapida {


    public EstacionCargaSuperRapida(int id, String ubicacion, PuntoDeCarga puntoDeCarga, boolean estado, String provincia, String codigoDeEstacion, int velocidadCarga, int capacidad, int superVelocidad) {
        super(id, ubicacion, puntoDeCarga, estado, provincia, codigoDeEstacion, velocidadCarga, capacidad);
        this.superVelocidad = superVelocidad;
    }
    private int superVelocidad;


    public int getSuperVelocidad() {
        return superVelocidad;

    }

    @Override
    public String toString() {
        return "EstacionCargaSuperRapida{" +
                "superVelocidad=" + superVelocidad +
                '}';
    }

    public void setSuperVelocidad(int superVelocidad) {
        this.superVelocidad = superVelocidad;
    }

    @Override
    public int calcularTiempoCarga(int capacidad) {
        return capacidad / this.superVelocidad;
    }

}