package vista;

import java.util.*;
import modelo.*;
import servicios.*;

/**
 * La clase Principal es la clase principal del sistema de gestión de estaciones de carga.
 * Proporciona una interfaz de usuario basada en consola para realizar diversas operaciones
 * relacionadas con las estaciones de carga, como crear, ver, actualizar, eliminar, serializar
 * y deserializar estaciones.
 * 
 * <p>Esta clase utiliza la clase ImplementacionOperacion para realizar las operaciones
 * CRUD (Crear, Leer, Actualizar, Eliminar) en las estaciones de carga.</p>
 * 
 * <p>El menú principal ofrece las siguientes opciones:</p>
 * <ul>
 *   <li>1. Crear estación</li>
 *   <li>2. Ver todas las estaciones</li>
 *   <li>3. Ver estación específica</li>
 *   <li>4. Actualizar estación</li>
 *   <li>5. Eliminar estación</li>
 *   <li>6. Guardar datos en archivo</li>
 *   <li>7. Cargar datos desde archivo</li>
 *   <li>8. Salir</li>
 * </ul>
 * 
 * <p>La clase maneja las entradas del usuario y las excepciones que puedan ocurrir durante
 * la ejecución de las operaciones.</p>
 * 
 * @see ImplementacionOperacion
 */
public class Principal {

    private static final ImplementacionOperacion operacion = new ImplementacionOperacion();
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {

        String path = "";
        String file = "TextNoBinary.txt";
        ImplementacionOperacion op = new ImplementacionOperacion();

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            String opcion = leerEntrada("Seleccione una opción: ");

            try {
                switch (Integer.parseInt(opcion)) {
                    case 1 -> crearEstacion();
                    case 2 -> verTodasEstaciones();
                    case 3 -> verEstacionEspecifica();
                    case 4 -> actualizarEstacion();
                    case 5 -> eliminarEstacion();
                    case 6 -> op.serializar(operacion.readAll(), path, file);
                    case 7 -> operacion.setEstaciones(op.deserializar(path, file));
                    case 8 -> salir = true;
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Gracias por usar el sistema de gestión de estaciones de carga.");
    }

    /**
     * Muestra el menú principal de opciones.
     */
    private static void mostrarMenu() {
        System.out.println("\n=== Sistema de Gestión de Estaciones de Carga ===");
        System.out.println("1. Crear estación");
        System.out.println("2. Ver todas las estaciones");
        System.out.println("3. Ver estación específica");
        System.out.println("4. Actualizar estación");
        System.out.println("5. Eliminar estación");
        System.out.println("6. Guardar datos en archivo");
        System.out.println("7. Cargar datos desde archivo");
        System.out.println("8. Salir");
        System.out.println("=============================================");
    }

    /**
     * Lee una entrada del usuario.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @return La entrada del usuario como una cadena.
     */
    private static String leerEntrada(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    /**
     * Lee una entrada del usuario y la convierte a un entero válido.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @return La entrada del usuario como un entero.
     */
    private static int leerEnteroValido(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(leerEntrada(mensaje));
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    /**
     * Crea una nueva estación de carga.
     */
    private static void crearEstacion() {
        try {
            int id = leerEnteroValido("ID de la estación: ");

            if (operacion.read(id) != null) {
                System.out.println("Error: Ya existe una estación con el mismo ID.");
                return;
            }

            String ubicacion = leerEntrada("Ubicación: ");
            String provincia = leerEntrada("Provincia: ");
            String codigo = leerEntrada("Código de estación: ");

            System.out.println("Tipos de estación disponibles:");
            System.out.println("1. Carga Lenta");
            System.out.println("2. Carga Rápida");
            System.out.println("3. Carga Super Rápida");
            int tipo = leerEnteroValido("Seleccione el tipo de estación (1-3): ");

            int velocidadCarga = leerEnteroValido("Velocidad de carga (kW): ");
            int capacidad = leerEnteroValido("Capacidad (kW): ");

            EstacionBase nuevaEstacion = switch (tipo) {
                case 1 -> new EstacionCargaLenta(id, ubicacion, new PuntoDeCarga(),
                        true, provincia, codigo, velocidadCarga, capacidad);
                case 2 -> new EstacionCargaRapida(id, ubicacion, new PuntoDeCarga(),
                        true, provincia, codigo, velocidadCarga, capacidad);
                case 3 -> {
                    int superVelocidad = leerEnteroValido("Super velocidad adicional (kW): ");
                    yield new EstacionCargaSuperRapida(id, ubicacion, new PuntoDeCarga(),
                            true, provincia, codigo, velocidadCarga, capacidad, superVelocidad);
                }
                default -> throw new IllegalArgumentException("Tipo de estación no válido");
            };

            System.out.println(operacion.create(nuevaEstacion));

        } catch (Exception e) {
            System.out.println("Error al crear la estación: " + e.getMessage());
        }
    }

    /**
     * Muestra todas las estaciones de carga.
     */
    private static void verTodasEstaciones() {
        try {
            List<EstacionBase> estaciones = List.of(operacion.readAll());
            if (estaciones.isEmpty()) {
                System.out.println("No hay estaciones registradas.");
                return;
            }

            System.out.println("\n=== Listado de Estaciones ===");
            for (EstacionBase estacion : estaciones) {
                System.out.println(estacion.obtenerEstado());
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener las estaciones: " + e.getMessage());
        }
    }

    /**
     * Muestra los detalles de una estación específica.
     */
    private static void verEstacionEspecifica() {
        try {
            int id = leerEnteroValido("ID de la estación: ");
            EstacionBase estacion = operacion.read(id);
            if (estacion != null) {
                System.out.println("\n=== Detalles de la Estación ===");
                System.out.println(estacion.obtenerEstado());
                System.out.println("==============================");
            } else {
                System.out.println("Estación no encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar la estación: " + e.getMessage());
        }
    }

    /**
     * Actualiza una estación de carga existente.
     */
    private static void actualizarEstacion() {
        try {
            int id = leerEnteroValido("ID de la estación a actualizar: ");
            EstacionBase estacionExistente = operacion.read(id);

            if (estacionExistente == null) {
                System.out.println("Estación no encontrada.");
                return;
            }

            String ubicacion = leerEntrada("Nueva ubicación: ");
            String provincia = leerEntrada("Nueva provincia: ");
            String codigo = leerEntrada("Nuevo código de estación: ");
            int velocidadCarga = leerEnteroValido("Nueva velocidad de carga (kW): ");
            int capacidad = leerEnteroValido("Nueva capacidad (kW): ");

            EstacionBase estacionActualizada;
            if (estacionExistente instanceof EstacionCargaLenta) {
                estacionActualizada = new EstacionCargaLenta(id, ubicacion, new PuntoDeCarga(),
                        true, provincia, codigo, velocidadCarga, capacidad);
            } else if (estacionExistente instanceof EstacionCargaRapida) {
                estacionActualizada = new EstacionCargaRapida(id, ubicacion, new PuntoDeCarga(),
                        true, provincia, codigo, velocidadCarga, capacidad);
            } else {
                int superVelocidad = leerEnteroValido("Nueva super velocidad (kW): ");
                estacionActualizada = new EstacionCargaSuperRapida(id, ubicacion, new PuntoDeCarga(),
                        true, provincia, codigo, velocidadCarga, capacidad, superVelocidad);
            }

            System.out.println(operacion.update(id, estacionActualizada));
        } catch (Exception e) {
            System.out.println("Error al actualizar la estación: " + e.getMessage());
        }
    }

    /**
     * Elimina una estación de carga existente.
     */
    private static void eliminarEstacion() {
        try {
            int id = leerEnteroValido("ID de la estación a eliminar: ");
            String confirmacion = leerEntrada("¿Está seguro de eliminar la estación? (S/N): ");

            if (confirmacion.equalsIgnoreCase("S")) {
                System.out.println(operacion.delete(id));
            } else {
                System.out.println("Operación cancelada.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar la estación: " + e.getMessage());
        }
    }

    // Métodos comentados para futuras funcionalidades
    // private static void realizarMantenimiento() {
    //     try {
    //         int id = leerEnteroValido("ID de la estación para mantenimiento: ");
    //         System.out.println(operacion.realizarMantenimiento(id));
    //     } catch (Exception e) {
    //         System.out.println("Error al realizar el mantenimiento: " + e.getMessage());
    //     }
    // }

    // private static void realizarCarga() {
    //     try {
    //         int id = leerEnteroValido("ID de la estación para realizar carga: ");
    //         System.out.println(operacion.realizarCarga(id));
    //     } catch (Exception e) {
    //         System.out.println("Error al realizar la carga: " + e.getMessage());
    //     }
    // }

    // private static void reportarFallo() {
    //     try {
    //         int id = leerEnteroValido("ID de la estación para reportar fallo: ");
    //         String descripcion = leerEntrada("Descripción del fallo: ");
    //         System.out.println(operacion.reportarFallo(id));
    //         System.out.println("Descripción registrada: " + descripcion);
    //     } catch (Exception e) {
    //         System.out.println("Error al reportar el fallo: " + e.getMessage());
    //     }
    // }
}