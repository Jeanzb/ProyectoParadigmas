package servicios;

import modelo.EstacionBase;

public interface Operacion {

    public String create(EstacionBase estacion);


    public EstacionBase read(int id);


    public String update(int id, EstacionBase nuevaEstacion);


    public EstacionBase delete(int id);

    public EstacionBase[] readAll();
 
}
