package taskmanagementBD;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */

public class UsuarioService {
    private Map<String, Usuario> usuarios = new HashMap<>();

    public boolean registrarUsuario(String nombre, String apellido, String username, String contrasena) {
        if (usuarios.containsKey(username)) {
            return false;
        }
        Usuario nuevoUsuario = new Usuario(nombre, apellido, username, contrasena);
        usuarios.put(username, nuevoUsuario);
        
        // Persistir en la BD
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.agregarUsuario(nuevoUsuario);
        System.out.println("Usuario añadido a la Base de Datos.");
        
        return true;
    }

    public boolean autenticarUsuario(String username, String contrasena) {
        Usuario usuario = usuarios.get(username);
        return usuario != null && usuario.getContrasena().equals(contrasena);
    }
}
