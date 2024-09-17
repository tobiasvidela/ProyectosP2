package taskmanagementBD;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */

public class Tarea {
    private static int contadorId = 1;
    private int id;
    private String titulo;
    private String descripcion;
    private String estado;

    public Tarea(String titulo, String descripcion, String estado) {
        this.id = contadorId++;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ID : " + id + "\n Título : " + titulo + "\n Descripción : " + descripcion + "\n Estado : " + estado + "\n";
    }
}