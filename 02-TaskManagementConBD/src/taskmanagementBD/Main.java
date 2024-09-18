package taskmanagementBD;

import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UsuarioService usuarioService = new UsuarioService();
    private static TareaService tareaService = new TareaService();
    private static String usuarioActual = null;

    public static void main(String[] args) {
        
        // Intentar conectar a la base de datos
        try (Connection conn = Util.getConnection()) {
            if (conn != null) {
                System.out.println("Conexion exitosa a la base de datos!");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        
        // Iniciar sistema
        while (true) {
            if (usuarioActual == null) {
                mostrarMenuPrincipal();
            } else {
                mostrarMenuUsuario();
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcion) {
            case 1:
                registrarUsuario();
                break;
            case 2:
                iniciarSesion();
                break;
            case 3:
                System.out.println("¡Hasta luego!");
                System.exit(0);
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    private static void mostrarMenuUsuario() {
        System.out.println("\n--- Menú de Usuario ---");
        System.out.println("1. Crear tarea");
        System.out.println("2. Ver tareas");
        System.out.println("3. Actualizar tarea");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Cerrar sesión");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcion) {
            case 1 -> crearTarea();
            case 2 -> verTareas();
            case 3 -> actualizarTarea();
            case 4 -> eliminarTarea();
            case 5 -> cerrarSesion();
            default -> System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    private static void registrarUsuario() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        if (usuarioService.registrarUsuario(nombre, apellido, username, contrasena)) {
            System.out.println("Usuario registrado con éxito.");
        } else {
            System.out.println("El nombre de usuario ya existe. Intente con otro.");
        }
    }

    private static void iniciarSesion() {
        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();

        if (usuarioService.autenticarUsuario(nombreUsuario, contrasena)) {
            usuarioActual = nombreUsuario;
            System.out.println("Sesión iniciada con éxito.");
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
    }

    private static void crearTarea() {
        System.out.print("Ingrese título de la tarea: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese descripción de la tarea: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese estado de la tarea (Nuevo/Pendiente/Finalizado): ");
        String estado = scanner.nextLine();

        Tarea nuevaTarea = tareaService.crearTarea(usuarioActual, titulo, descripcion, estado);
        System.out.println("Tarea creada con éxito. ID: " + nuevaTarea.getId());
    }

    private static void verTareas() {
        List<Tarea> tareas = tareaService.obtenerTareas(usuarioActual);
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para mostrar.");
        } else {
            for (Tarea tarea : tareas) {
                System.out.println(tarea);
            }
        }
    }

    private static void actualizarTarea() {
        System.out.print("Ingrese ID de la tarea a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese nuevo título (o presione Enter para mantener el actual): ");
        String nuevoTitulo = scanner.nextLine();
        System.out.print("Ingrese nueva descripción (o presione Enter para mantener la actual): ");
        String nuevaDescripcion = scanner.nextLine();
        System.out.print("Ingrese nuevo estado (Nuevo/Pendiente/Finalizado) (o presione Enter para mantener el actual): ");
        String nuevoEstado = scanner.nextLine();

        if (tareaService.actualizarTarea(usuarioActual, id, nuevoTitulo, nuevaDescripcion, nuevoEstado)) {
            System.out.println("Tarea actualizada con éxito.");
        } else {
            System.out.println("No se pudo actualizar la tarea. Verifique el ID.");
        }
    }

    private static void eliminarTarea() {
        System.out.print("Ingrese ID de la tarea a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        if (tareaService.eliminarTarea(usuarioActual, id)) {
            System.out.println("Tarea eliminada con éxito.");
        } else {
            System.out.println("No se pudo eliminar la tarea. Verifique el ID.");
        }
    }

    private static void cerrarSesion() {
        usuarioActual = null;
        System.out.println("Sesión cerrada.");
    }
}
