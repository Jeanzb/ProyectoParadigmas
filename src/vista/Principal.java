package vista;
import modelo.*;
import servicios.*;

public class Principal {

    
    public static void main(String[ ] args) {
        String[] historial1 = {"Carga 1: 10kWh", "Carga 2: 15kWh"};
        String[] historial2 = {"Carga 1: 8kWh", "Carga 2: 12kWh", "Carga 3: 20kWh"};
        String[] historial3 = {"Carga 1: 5kWh"};

        PuntoDeCarga punto1 = new PuntoDeCarga(1, "Punto Central", "Av. Siempre Viva 742", "Tipo1", true, historial1);
        PuntoDeCarga punto2 = new PuntoDeCarga(2, "Punto Norte", "Calle 123", "CSS", true, historial2);
        PuntoDeCarga punto3 = new PuntoDeCarga(3, "Punto Sur", "Avenida Sur 45", "Tipo2", true, historial3);


        EstacionCargaSuperRapida estacion1 = new EstacionCargaSuperRapida(4, "Ciudad D", punto2, true, "Provincia D", "SSD3432", 200, 150, 400);
        EstacionCargaRapida estacion2 = new EstacionCargaRapida(2, "Ciudad B", punto2, true, "Provincia B", "DGDF43", 100, 100);
        EstacionCargaLenta estacion3 = new EstacionCargaLenta(3, "Ciudad C", punto3, false, "Provincia C", "DGDF34", 50, 50);


        /* System.out.println("Tiempo de carga en EstacionCargaLenta: " + estacion1.calcularTiempoCarga(50) + " horas");
        System.out.println("Tiempo de carga en EstacionCargaRapida: " + estacion2.calcularTiempoCarga(50) + " horas");
        System.out.println("Tiempo de carga en EstacionCargaSuperRapida: " + estacion3.calcularTiempoCarga(50) + " horas"); */
        System.out.println("-----------------------------------------------------------------------------------------");
        implementacionOperacion operacion = new implementacionOperacion();
        System.out.println("Prueba de creación de operaciones:\n");
        System.out.println(operacion.create(estacion1));
        System.out.println(operacion.create(estacion2));
        operacion.create(estacion3);
        
        
        System.out.println(operacion);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Prueba de lectura de operaciones:\n" + //
                        "");
        System.out.println(operacion.read(estacion1.getId()));
        System.out.println(operacion.read(estacion2.getId()));
        System.out.println(operacion.read(estacion3.getId()));
        
        System.out.println("-----------------------------------------------------------------------------------------");
       
        System.out.println("Prueba de actualización de operaciones:\n" + //
                        "");
        EstacionCargaLenta estacionActualizada = new EstacionCargaLenta(34, "Ciudad A", punto1, false, "Provincia A", "SDSD", 10, 2);
        System.out.println(operacion.update(estacion1.getId(), estacionActualizada));
        System.out.println(operacion.read(estacionActualizada.getId()));
        System.out.println("-----------------------------------------------------------------------------------------");
        
        System.out.println("Prueba de eliminación de operaciones:\n" + //
                        "");
        System.out.println(operacion.delete(estacionActualizada.getId()));
        System.out.println(operacion.read(estacionActualizada.getId()));
        System.out.println("-----------------------------------------------------------------------------------------");
    
        System.out.println("Prueba de lectura de todas las estaciones: \n" + //
                        "");
        EstacionBase[] estaciones = operacion.readAll();
        for (EstacionBase estacion : estaciones) {
            System.out.println(estacion + "\n");
        }
        
        





    }

    
    

    

   

}