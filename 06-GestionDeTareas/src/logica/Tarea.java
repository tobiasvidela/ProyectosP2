package logica;

import java.text.SimpleDateFormat;

public class Tarea {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    private int id;
    private String titulo;
    private String descripcion;
    private String estado;
    private int idUsuario;
    private String fecha_entrega;
    private String fecha_creacion;

    // Constructor para crear una tarea sin ID (para insertar en la base de datos)
    public Tarea(String titulo, String descripcion, String estado, int idUsuario, String fecha_entrega, String fecha_creacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.fecha_entrega = fecha_entrega;
        this.fecha_creacion = fecha_creacion;
    }
    
    // Constructor para crear una tarea con ID (para cuando se recupera de la base de datos)
    public Tarea(int id, String titulo, String descripcion, String estado, int idUsuario, String fecha_entrega, String fecha_creacion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.fecha_entrega = fecha_entrega;
        this.fecha_creacion = fecha_creacion;
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

    public String getFechaEntrega() {
        return fecha_entrega;
    }

    public String getFechaCreacion() {
        return fecha_creacion;
    }
}
