package taskmanagementBD;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */

public class Usuario {
    private String nombre;
    private String apellido;
    private String username;
    private String contrasena;

    public Usuario(String nombre, String apellido, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = usuario;
        this.contrasena = contrasena;
    }
    /*
    public Usuario(int id, String nombre, String apellido, String username, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.contrasena = contrasena;
    }*/

    // Getters

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getUsername() {
        return this.username;
    }

    public String getContrasena() {
        return this.contrasena;
    }
    
}