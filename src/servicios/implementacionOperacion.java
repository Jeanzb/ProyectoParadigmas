package servicios;

import modelo.EstacionBase;
import java.util.Arrays;

public class implementacionOperacion implements Operacion {
    private EstacionBase[] estaciones;
    private static final int CAPACIDAD_INICIAL = 2;

    public implementacionOperacion() {
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
                     .filter(estacion -> estacion != null)
                     .toArray(EstacionBase[]::new);
    }

    

    
}
