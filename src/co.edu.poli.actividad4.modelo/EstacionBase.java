import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



package co.edu.poli.actividad4.modelo;

public class EstacionBase {


    public EstacionBase(int id, String ubicacion, PuntoDeCarga puntoDeCarga, boolean estado, String provincia) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.puntoDeCarga = puntoDeCarga;
        this.estado = estado;
        this.provincia = provincia;
    }

    private int id;

    private String ubicacion;

    private PuntoDeCarga puntoDeCarga;

    private boolean estado;

    private String provincia;


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

    @Override
    public String toString() {
        return "EstacionBase{" +
                "id=" + id +
                ", ubicacion='" + ubicacion + '\'' +
                ", puntoDeCarga=" + puntoDeCarga +
                ", estado=" + estado +
                ", provincia='" + provincia + '\'' +
                '}';
    }

    /**
     * @return
     */
    /**
     * Este método devolverá la fecha actual.
     * 
     * @return La fecha y hora actual como una cadena de texto.
     */
    private String ahora() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    /**
     * @return
     */
    public boolean verificarDisponibilidad() {
        // Implementar la lógica para verificar la disponibilidad
            return this.estado;  }

    /**
     * @return
     */
    public boolean notificarMantenimientoNecesario() {
        // Implementar la lógica para notificar si es necesario el mantenimiento
        
    }

    /**
     * @return
     */
    protected boolean actualizarEstado() {
        if (!this.estado) {
            this.estado = true;
            return true;
        }
        return false;
    }

    /**
     * @param nuevoEstado 
     * @param estadoDetallado 
     * @return
     */
    public boolean actualizarEstado(String nuevoEstado, boolean estadoDetallado) {
        if (nuevoEstado.equalsIgnoreCase("activo") && !this.estado) {
            this.estado = true;
            return true;
        } else if (nuevoEstado.equalsIgnoreCase("inactivo") && this.estado) {
            this.estado = false;
            return true;
        } else if (estadoDetallado) {
            this.estado = !this.estado;
            return true;
        }
        return false;
    }

    private int id;
    private String ubicacion;
    private PuntoDeCarga punto;
}