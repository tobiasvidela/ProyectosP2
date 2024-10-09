package logica;

import java.util.List;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UsuarioService usuarioService = new UsuarioService();
    private static TareaService tareaService = new TareaService();
    private static String usuarioActual = null;

    public static void main(String[] args) {
        // Mostrar pantalla de carga
        gui.PantallaDeCarga pantallaCarga = new gui.PantallaDeCarga();
        pantallaCarga.setVisible(true);
        
        // Crear un hilo separado para la espera y la conexión
        new Thread(() -> {
            try {
                // por si se conecta demasiado rápido
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Intentar conectar a la base de datos en el hilo de eventos de Swing
            SwingUtilities.invokeLater(() -> {
                try {
                    Util.conectarBaseDatos();
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    // eliminar pantalla de carga
                    pantallaCarga.dispose();
                }
            });
        }).start();
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
    
    public static boolean eliminarTarea(int id) {
        return tareaService.eliminarTarea(id);
    }
}
