package logica;

import java.util.Date;

public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private String estado;
    private int idUsuario;
    private Date fecha_entrega;
    private Date fecha_creacion;

    // Constructor para crear una tarea sin ID (para insertar en la base de datos)
    public Tarea(String titulo, String descripcion, String estado, int idUsuario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }
    
    // Constructor para crear una tarea con ID (para cuando se recupera de la base de datos)
    public Tarea(int id, String titulo, String descripcion, String estado, int idUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public Date getFechaEntrega() {
        return fecha_entrega;
    }

    public Date getFechaCreacion() {
        return fecha_creacion;
    }

    
}
