package servicios;

import modelo.EstacionBase;
import modelo.Mantenimiento;
import modelo.PuntoDeCarga;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ImplementacionOperacion implements Operacion {
    private EstacionBase[] estaciones;
    private static final int CAPACIDAD_INICIAL = 2;


    public void setEstaciones(EstacionBase[] estaciones) {
        this.estaciones = estaciones;
    }

    public ImplementacionOperacion() {
        estaciones = new EstacionBase[CAPACIDAD_INICIAL];
    }

    @Override
    public String toString() {
        return "implementacionOperacion{" +
                "estaciones=" + Arrays.toString(estaciones) +
                '}';
    }

    @Override
    public String create(EstacionBase nuevaEstacion) {
        try {
            
            for (EstacionBase estacion : estaciones) {
                if (estacion != null && estacion.getId() == nuevaEstacion.getId()) {
                    return "Error: Ya existe una estación con el mismo ID.";
                }
            }


            for (int i = 0; i < estaciones.length; i++) {
                if (estaciones[i] == null) {
                    estaciones[i] = nuevaEstacion;
                    return "Estación base agregada exitosamente";
                }
            }

            estaciones = Arrays.copyOf(estaciones, estaciones.length * 2);
            estaciones[estaciones.length / 2] = nuevaEstacion;
            return "Estación base agregada exitosamente";
        } catch (Exception e) {
            return "Error al agregar estación base: " + e.getMessage();
        }
    }

    @Override
    public EstacionBase read(int id) {
        for (EstacionBase estacion : estaciones) {
            if (estacion != null && estacion.getId() == id) {
                return estacion;
            }
        }
        return null;
    }

    @Override
    public String update(int id, EstacionBase nuevaEstacion) {
        for (int i = 0; i < estaciones.length; i++) {
            if (estaciones[i] != null && estaciones[i].getId() == id) {
                estaciones[i] = nuevaEstacion;
                return "Estación base actualizada exitosamente";
            }
        }
        return "Estación base no encontrada";
    }

    @Override
    public EstacionBase delete(int id) {
        for (int i = 0; i < estaciones.length; i++) {
            if (estaciones[i] != null && estaciones[i].getId() == id) {
                EstacionBase estacionEliminada = estaciones[i];
                estaciones[i] = null;
                return estacionEliminada;
            }
        }
        return null;
    }

    @Override
    public EstacionBase[] readAll() {
        return Arrays.stream(estaciones)
                     .filter(Objects::nonNull)
                     .toArray(EstacionBase[]::new);
    }

    public String serializar(EstacionBase[] estaciones, String path, String name) {
        try {
            FileOutputStream fos = new FileOutputStream(path + name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(estaciones);
            oos.close();
            fos.close();
            return "File create!!";
        } catch (IOException ioe) {
            return "Error file " + ioe.getMessage();
        }
    }
    public EstacionBase[] deserializar(String path, String name) {
        EstacionBase[] a = null;
        try {
            FileInputStream fis = new FileInputStream(path + name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            a = (EstacionBase[]) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return a;
    }

    public String realizarCarga(int id) {
        EstacionBase estacion = read(id);
        if (estacion == null) {
            return "Error: Estación no encontrada";
        }

        if (!estacion.isEstado()) {
            return "Error: Estación no disponible";
        }

        PuntoDeCarga punto = estacion.getPuntoDeCarga();
        if (!punto.isOperativo()) {
            return "Error: Punto de carga no operativo";
        }

        String resultadoCarga = punto.realizarCarga();
        return String.format("Estación %s (%s): %s",
                estacion.getCodigoDeEstacion(),
                estacion.getTipoEstacion(),
                resultadoCarga);
    }

    public String reportarFallo(int id) {
        EstacionBase estacion = read(id);
        if (estacion == null) {
            return "Error: Estación no encontrada";
        }

        PuntoDeCarga punto = estacion.getPuntoDeCarga();
        String descripcionFallo = String.format("Fallo en estación %s (%s)",
                estacion.getCodigoDeEstacion(),
                estacion.getTipoEstacion());

        String resultado = punto.reportarFallo(descripcionFallo);
        estacion.setEstado(false);

        return resultado;
    }

    public String verificarEstado(int id) {
        EstacionBase estacion = read(id);
        if (estacion == null) {
            return "Error: Estación no encontrada";
        }

        PuntoDeCarga punto = estacion.getPuntoDeCarga();
        return String.format("""
                        Estado de la estación %s:
                        - Tipo: %s
                        - Estado general: %s
                        - Estado del punto de carga: %s
                        - Cargas realizadas: %d""",
                estacion.getCodigoDeEstacion(),
                estacion.getTipoEstacion(),
                estacion.isEstado() ? "Operativa" : "No operativa",
                punto.getEstadoActual(),
                punto.getCargasRealizadas());
    }

    public String realizarMantenimiento(int id) {
        EstacionBase estacion = read(id);
        if (estacion == null) {
            return "Error: Estación no encontrada";
        }

        Mantenimiento mantenimiento = estacion.getMantenimiento();
        if (mantenimiento.isEnMantenimiento()) {
            mantenimiento.finalizarMantenimiento();
            estacion.setEstado(true);
            return String.format("Mantenimiento finalizado en estación %s (%s)\n" +
                            "La estación está nuevamente disponible.",
                    estacion.getCodigoDeEstacion(),
                    estacion.getTipoEstacion());
        } else {
            mantenimiento.iniciarMantenimiento();
            estacion.setEstado(false);
            return String.format("Mantenimiento iniciado en estación %s (%s)\n" +
                            "La estación estará fuera de servicio hasta que finalice el mantenimiento.",
                    estacion.getCodigoDeEstacion(),
                    estacion.getTipoEstacion());
        }
    }

    public String obtenerHistorialMantenimiento(int id) {
        EstacionBase estacion = read(id);
        if (estacion == null) {
            return "Error: Estación no encontrada";
        }

        List<String> historial = estacion.getMantenimiento().getHistorialMantenimiento();
        if (historial.isEmpty()) {
            return "No hay registros de mantenimiento para esta estación.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Historial de mantenimiento para estación %s (%s):\n",
                estacion.getCodigoDeEstacion(),
                estacion.getTipoEstacion()));

        for (String registro : historial) {
            sb.append("- ").append(registro).append("\n");
        }

        LocalDateTime ultimoMantenimiento = estacion.getMantenimiento().getUltimoMantenimiento();
        if (ultimoMantenimiento != null) {
            sb.append("\nÚltimo mantenimiento realizado: ")
                    .append(ultimoMantenimiento.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }

        return sb.toString();
    }

    
}
