package taskmanagementBD;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */

public class UsuarioService {
    private Map<String, Usuario> usuarios = new HashMap<>();

    public boolean registrarUsuario(String nombreUsuario, String contrasena) {
        if (usuarios.containsKey(nombreUsuario)) {
            return false;
        }
        usuarios.put(nombreUsuario, new Usuario(nombreUsuario, contrasena));
        return true;
    }

    public boolean autenticarUsuario(String nombreUsuario, String contrasena) {
        Usuario usuario = usuarios.get(nombreUsuario);
        return usuario != null && usuario.getContrasena().equals(contrasena);
    }
}
