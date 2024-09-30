package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Clase base EstacionBase (Superclase de la jerarquía)
// Herencia: EstacionBase es la clase padre que será heredada por otras clases
public abstract class EstacionBase {

    private int id;

    private String ubicacion;
    private PuntoDeCarga puntoDeCarga;

    private boolean estado;

    private String provincia;

    private Mantenimiento mantenimiento;

    private final String codigoDeEstacion;


    public EstacionBase(int id, String ubicacion, PuntoDeCarga puntoDeCarga, boolean estado, String provincia, String codigoDeEstacion) {
        this.id = id;
        this.ubicacion = ubicacion;
        //Composicion fuerte
        this.puntoDeCarga = puntoDeCarga;
        this.estado = estado;
        this.provincia = provincia;

        this.codigoDeEstacion = codigoDeEstacion;
    }

    public String getCodigoDeEstacion() {
        return codigoDeEstacion;
    }

    public int getId() {
        return id;
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

    public PuntoDeCarga getPuntoDeCarga() {
        return puntoDeCarga;
    }

    public void setPuntoDeCarga(PuntoDeCarga puntoDeCarga) {
        this.puntoDeCarga = puntoDeCarga;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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