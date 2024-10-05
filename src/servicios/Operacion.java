package servicios;

import modelo.EstacionBase;

public interface Operacion {

    String create(EstacionBase estacion);


    EstacionBase read(int id);


    String update(int id, EstacionBase nuevaEstacion);


    EstacionBase delete(int id);

    EstacionBase[] readAll();

    EstacionBase[] deserializar(String path, String name);

    String serializar(EstacionBase[] estaciones, String path, String name);


}
