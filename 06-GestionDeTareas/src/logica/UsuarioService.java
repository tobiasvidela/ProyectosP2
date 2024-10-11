package logica;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class UsuarioService {
    private static Map<String, Usuario> usuarios = new HashMap<>();
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static final Icon db_icon = recursos.iconos.IconGetter.db_JOP_icon;
    public static enum AutenticacionUsuarioResultado {
        EXITO,
        USUARIO_NO_EXISTE,
        CONTRASENA_INCORRECTA
    }


    public static void cargarUsuariosDesdeBD() {
        List<Usuario> usuariosList = usuarioDAO.obtenerTodosUsuarios();
        for (Usuario usuario : usuariosList) {
            usuarios.put(usuario.getUsername(), usuario);
        }
    }

    public static boolean registrarUsuario(String nombre, String apellido, String username, String contrasena) {
        if (usuarios.containsKey(username)) {
            return false;
        }
        Usuario nuevoUsuario = new Usuario(nombre, apellido, username, contrasena);
        try {
            usuarioDAO.agregarUsuario(nuevoUsuario);
            usuarios.put(username, nuevoUsuario);
            JOptionPane.showMessageDialog(null, 
                    username + " añadido a la Base de Datos.", 
                    "UsuarioService", 
                    JOptionPane.PLAIN_MESSAGE,
                    db_icon);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Error al intentar añadir a " + username + " a la Base de Datos.\n" + e.getMessage(), 
                    "UsuarioService", 
                    JOptionPane.ERROR_MESSAGE,
                    db_icon);
            return false;
        }
    }

    public static AutenticacionUsuarioResultado autenticarUsuario(String username, String contrasena) {
        Usuario usuario = usuarioDAO.obtenerUsuarioPorUsername(username);
        if (usuario == null) {
            return AutenticacionUsuarioResultado.USUARIO_NO_EXISTE;
        }
        if (usuario.getContrasena().equals(contrasena)) {
            return AutenticacionUsuarioResultado.EXITO;
        } else {
            return AutenticacionUsuarioResultado.CONTRASENA_INCORRECTA;
        }
    }
    
    public static Usuario obtenerUsuarioPorUsername(String username) {
        return usuarioDAO.obtenerUsuarioPorUsername(username);
    }
    
    public static List<Usuario> obtenerTodosUsuarios() {
        return usuarioDAO.obtenerTodosUsuarios();
    }
    
    public static boolean actualizarUsuario(Usuario usuario) {
        try {
            if (usuarioDAO.existeNombreUsuario(usuario.getUsername(), usuario.getId())) {
                JOptionPane.showMessageDialog(null, 
                    "Error.\nYa existe " + usuario.getUsername() + " en la Base de Datos.", 
                    "UsuarioService", 
                    JOptionPane.ERROR_MESSAGE,
                    db_icon);
                return false;
            }

            usuarioDAO.actualizarUsuario(usuario);
            usuarios.put(usuario.getUsername(), usuario);
            JOptionPane.showMessageDialog(null, 
                    usuario.getUsername() + " actualizado con éxito.", 
                    "UsuarioService", 
                    JOptionPane.PLAIN_MESSAGE,
                    db_icon);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Error al intentar actualizar usuario en la Base de Datos.\n" + e.getMessage(), 
                    "UsuarioService", 
                    JOptionPane.ERROR_MESSAGE,
                    db_icon);
        }
        return false;
    }

    public static boolean eliminarUsuario(int id) {
        try {
            String usernameAEliminar = usuarioDAO.obtenerUsuarioPorId(id).getUsername();
            usuarioDAO.eliminarUsuario(id);
            usuarios.remove(usernameAEliminar);
            JOptionPane.showMessageDialog(null, 
                    "Usuario eliminado con éxito.", 
                    "UsuarioService", 
                    JOptionPane.PLAIN_MESSAGE,
                    db_icon);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Error al intentar eliminar al usuario de la Base de Datos.\n" + e.getMessage(), 
                    "UsuarioService", 
                    JOptionPane.ERROR_MESSAGE,
                    db_icon);
            return false;
        }
    }
}