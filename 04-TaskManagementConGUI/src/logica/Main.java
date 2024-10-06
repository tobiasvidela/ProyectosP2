package logica;

import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
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
    }
    public static boolean autenticarUsuario(String username, String contrasena) {
        return usuarioService.autenticarUsuario(username, contrasena);
    }

    public static boolean registrarUsuario(String nombre, String apellido, String username, String contrasena) {
        return usuarioService.registrarUsuario(nombre, apellido, username, contrasena);
    }
    
    public static boolean actualizarUsuario(Usuario usuario) {
        return usuarioService.actualizarUsuario(usuario);
    }
    
    public static boolean eliminarUsuario(String username) {
        return usuarioService.eliminarUsuario(usuarioService.obtenerUsuarioPorUsername(username).getId());
    }
    
    public static Usuario getUserByUsername(String username) {
        return usuarioService.obtenerUsuarioPorUsername(username);
    }
    
    public static List<Tarea> getAllTaskFromUsername(String username) {
        return tareaService.obtenerTareasPorUsuario(usuarioService.obtenerUsuarioPorUsername(username).getId());
    }
    
    public static Tarea getTaskById(int id) {
        return tareaService.obtenerTareaPorId(id);
    }
    public static boolean agregarTarea(String titulo, String descripcion, String estado, int idUsuarioActual, String fecha_entrega, String fecha_creacion) {
        return tareaService.crearTarea(titulo, descripcion, estado, idUsuarioActual, fecha_entrega, fecha_creacion);
    }
    
    public static boolean actualizarTarea(int id, String titulo, String descripcion, String estado, int idUsuarioActual, String fecha_entrega, String fecha_creacion) {
        return tareaService.actualizarTarea(new Tarea(id, titulo, descripcion, estado, idUsuarioActual, fecha_entrega, fecha_creacion));
    }
    
    private static void eliminarTarea(int idUsuarioActual) {
        //verTareas(idUsuarioActual);
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
}
