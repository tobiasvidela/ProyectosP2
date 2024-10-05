package logica;

import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UsuarioService usuarioService = new UsuarioService();
    private static TareaService tareaService = new TareaService();
    private static String usuarioActual = null;

    public static void main(String[] args) {
        
        // Intentar conectar a la base de datos
        try (Connection conn = Util.getConnection()) {
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos!");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        
        // Iniciar sistema
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //      LOGIN
                gui.Login login = new gui.Login();
            }
        });
        // CLI
        /*while (true) {
            if (usuarioActual == null) {
                mostrarMenuPrincipal();
            } else {
                mostrarMenuUsuario();
            }
        }*/
    }
    public static boolean autenticarUsuario(String username, String contrasena) {
        return usuarioService.autenticarUsuario(username, contrasena);
    }

    public static boolean registrarUsuario(String nombre, String apellido, String username, String contrasena) {
        return usuarioService.registrarUsuario(nombre, apellido, username, contrasena);
    }
    
    private static void verTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodosUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Usuarios registrados:");

            // Definir el formato de la tabla
            String formato = "| %-4s | %-23s | %-23s | %-18s |%n";

            // Imprimir el encabezado de la tabla
            System.out.println("+------+-------------------------+-------------------------+--------------------+");
            System.out.printf(formato, "ID", "Nombre", "Apellido", "Username");
            System.out.println("+------+-------------------------+-------------------------+--------------------+");

            // Imprimir los datos de cada usuario
            for (Usuario usuario : usuarios) {
                System.out.printf(formato, 
                                  usuario.getId(), 
                                  usuario.getNombre(), 
                                  usuario.getApellido(), 
                                  usuario.getUsername());
            }

            // Imprimir el pie de la tabla
            System.out.println("+------+-------------------------+-------------------------+--------------------+");
        }
    }

    private static void eliminarUsuario() {
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        if (usuarioService.eliminarUsuario(id)) {
            System.out.println("Usuario eliminado con éxito.");
        } else {
            System.out.println("No se pudo eliminar el usuario. Verifique el ID.");
        }
    }

    private static void crearTarea(int idUsuarioActual) {
        System.out.print("Ingrese título de la tarea: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese descripción de la tarea: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese estado de la tarea (Nuevo/Pendiente/Finalizado): ");
        String estado = scanner.nextLine();

        if(tareaService.crearTarea(titulo, descripcion, estado, idUsuarioActual)){
            System.out.println("Tarea creada con éxito.");
        } else {
            System.out.println("Hubo un problema con la creación de la tarea.");
        }
    }

    private static void verTareas(int idUsuarioActual) {
        List<Tarea> tareas = tareaService.obtenerTareasPorUsuario(idUsuarioActual);
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para mostrar.");
        } else {
            System.out.println(" Sus tareas:");
            // Definir el formato de la tabla
            String formato = "| %12s | %-75s |%n";

            for (Tarea tarea : tareas) {
                System.out.printf(formato, tarea.getId(), tarea.getTitulo());
                System.out.printf(formato, "Descripcion", tarea.getDescripcion());
                System.out.printf(formato, "Estado", tarea.getEstado());
                System.out.println("+--------------+-----------------------------------------------------------------------------+");
            }
        }
    }

    private static void actualizarTarea(int idUsuarioActual) {
        verTareas(idUsuarioActual);

        System.out.print("Ingrese ID de la tarea a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        // Veirificar si existe la tarea
        if (tareaService.obtenerTareaPorId(id) == null) {
            System.out.println("Prueba con otro ID."); //Avisar al usuario que intente otro ID
            return;
        }

        if (tareaService.obtenerTareaPorId(id).getIdUsuario() != idUsuarioActual) {
            System.out.println("La tarea seleccionada no te pertenece.");
        } else {
            Tarea tareaActualizarObj = tareaService.obtenerTareaPorId(id);

            if (tareaActualizarObj == null) {
                System.out.println("No se encontró la tarea.");
                return;
            }

            System.out.println("\n--- Actualizar tarea ---");
            System.out.println("\n(Presiona Enter para no modificar el campo)\n");

            System.out.print("Nuevo título (actual: " + tareaActualizarObj.getTitulo() + "): ");
            String nuevoTitulo = scanner.nextLine();
            if (nuevoTitulo.isEmpty()) {
                nuevoTitulo = tareaActualizarObj.getTitulo();
            }

            System.out.print("Nueva descripción: ");
            String nuevaDescripcion = scanner.nextLine();
            if (nuevaDescripcion.isEmpty()) {
                nuevaDescripcion = tareaActualizarObj.getDescripcion();
            }

            System.out.print("Nuevo estado (Nuevo/Pendiente/Finalizado): ");
            String nuevoEstado = scanner.nextLine();
            if (nuevoEstado.isEmpty()) {
                nuevoEstado = tareaActualizarObj.getEstado();
            }

            Tarea nuevaTarea = new Tarea(id, nuevoTitulo, nuevaDescripcion, nuevoEstado, idUsuarioActual);
            
            tareaActualizarObj = nuevaTarea;

            if (tareaService.actualizarTarea(tareaActualizarObj)) {
                System.out.println("Tarea actualizada con éxito.");
            } else {
                System.out.println("No se pudo actualizar la tarea. Verifique el ID.");
            }
        }
    }

    private static void eliminarTarea(int idUsuarioActual) {
        verTareas(idUsuarioActual);
        System.out.print("Ingrese ID de la tarea a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        // Veirificar si existe la tarea
        if (tareaService.obtenerTareaPorId(id) == null) {
            System.out.println("Prueba con otro ID."); //Avisar al usuario que intente otro ID
            return;
        }
        
        if (tareaService.obtenerTareaPorId(id).getIdUsuario() != idUsuarioActual) {
            System.out.println("La tarea seleccionada no te pertenece.");
        } else {
            if (tareaService.eliminarTarea(id)) {
                System.out.println("Tarea eliminada con éxito.");
            } else {
                System.out.println("No se pudo eliminar la tarea. Verifique el ID.");
            }
        }
    }

    private static void actualizarPerfil() {
        Usuario usuarioActualObj = usuarioService.obtenerUsuarioPorUsername(usuarioActual);

        if (usuarioActualObj == null) {
            System.out.println("No se encontró el usuario actual.");
            return;
        }

        System.out.println("\n--- Actualizar perfil ---");
        System.out.println("\n(Presiona Enter para no modificar el campo)\n");

        System.out.print("Nuevo nombre (actual: " + usuarioActualObj.getNombre() + "): ");
        String nuevoNombre = scanner.nextLine();
        if (nuevoNombre.isEmpty()) {
            nuevoNombre = usuarioActualObj.getNombre();  // Si se presiona Enter, mantiene el valor actual
        }

        System.out.print("Nuevo apellido (actual: " + usuarioActualObj.getApellido() + "): ");
        String nuevoApellido = scanner.nextLine();
        if (nuevoApellido.isEmpty()) {
            nuevoApellido = usuarioActualObj.getApellido();  // Si se presiona Enter, mantiene el valor actual
        }

        System.out.print("Nuevo nombre de usuario (actual: " + usuarioActualObj.getUsername() + "): ");
        String nuevoUsername = scanner.nextLine();
        if (nuevoUsername.isEmpty()) {
            nuevoUsername = usuarioActualObj.getUsername();  // Si se presiona Enter, mantiene el valor actual
        }

        System.out.print("Nueva contraseña: ");
        String nuevaContrasena = scanner.nextLine();
        if (nuevaContrasena.isEmpty()) {
            nuevaContrasena = usuarioActualObj.getContrasena();  // Si se presiona Enter, mantiene el valor actual
        }

        Usuario usuarioActualizado = new Usuario(
                usuarioActualObj.getId(), 
                nuevoNombre, 
                nuevoApellido, 
                nuevoUsername, 
                nuevaContrasena
        );

        // Actualizamos en el servicio y la base de datos
        usuarioService.actualizarUsuario(usuarioActualizado);
        System.out.println("Perfil actualizado con éxito.");
    }
    
    private static void cerrarSesion() {
        usuarioActual = null;
        System.out.println("Sesión cerrada.");
    }
}
