package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import gui.*;
import java.text.ParseException;

public class TareaDAO {

    public int agregarTarea(Tarea tarea) {
        // Definir el formato de la fecha
        SimpleDateFormat formato = MainMenu.dateFormat;
        Date fechaEntregaDate,fechaCreacionDate;
        // INSERT
        String sql = "INSERT INTO tareas (titulo, descripcion, estado, idusuario, fecha_entrega, fecha_creacion) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Util.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, tarea.getTitulo());
            stmt.setString(2, tarea.getDescripcion());
            stmt.setString(3, tarea.getEstado());
            stmt.setInt(4, tarea.getIdUsuario());
            // Parsear las fechas
            fechaEntregaDate = formato.parse(tarea.getFechaEntrega());
            fechaCreacionDate = formato.parse(tarea.getFechaCreacion());
            // Convertirlas a java.sql.Date
            java.sql.Date fechaEntregaSQL = new java.sql.Date(fechaEntregaDate.getTime());
            java.sql.Date fechaCreacionSQL = new java.sql.Date(fechaCreacionDate.getTime());

            stmt.setDate(5, fechaEntregaSQL);
            stmt.setDate(6, fechaCreacionSQL);
            stmt.executeUpdate();
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Retorna el ID generado
                }
            }
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Debe ser dd-MM-yyyy");
        } catch (SQLException e) {
            System.err.println("Error al añadir tarea a la Base de Datos: " + e.getMessage());
            e.printStackTrace();
        }
        return -1; // Retorna -1 si no se pudo generar el ID
    }

    public Tarea obtenerTareaPorId(int id) {
        String sql = "SELECT * FROM tareas WHERE id = ?";
        try (Connection conn = Util.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Tarea(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("descripcion"),
                    rs.getString("estado"),
                    rs.getInt("idusuario"),
                    rs.getString("fecha_entrega"),
                    rs.getString("fecha_creacion")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener tarea por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<Tarea> obtenerTareasPorUsuario(int idUsuario) {
        List<Tarea> tareas = new ArrayList<>();
        String sql = "SELECT * FROM tareas WHERE idusuario = ?";
        try (Connection conn = Util.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tarea tarea = new Tarea(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("descripcion"),
                    rs.getString("estado"),
                    rs.getInt("idusuario"),
                    rs.getString("fecha_entrega"),
                    rs.getString("fecha_creacion")
                );
                tareas.add(tarea);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener tareas por usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return tareas;
    }
    
    public List<Tarea> obtenerTodasTareas() {
        List<Tarea> tareas = new ArrayList<>();
        String sql = "SELECT * FROM tareas";
        try (Connection conn = Util.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Tarea tarea = new Tarea(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("descripcion"),
                    rs.getString("estado"),
                    rs.getInt("idusuario"),
                    rs.getString("fecha_entrega"),
                    rs.getString("fecha_creacion")
                );
                tareas.add(tarea);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todas las tareas: " + e.getMessage());
            e.printStackTrace();
        }
        return tareas;
    }


    public void actualizarTarea(Tarea tarea) {
        String sql = "UPDATE tareas SET titulo = ?, descripcion = ?, estado = ?, idusuario = ? WHERE id = ?";
        try (Connection conn = Util.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tarea.getTitulo());
            stmt.setString(2, tarea.getDescripcion());
            stmt.setString(3, tarea.getEstado());
            stmt.setInt(4, tarea.getIdUsuario());
            stmt.setInt(5, tarea.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar tarea: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminarTarea(int id) {
        String sql = "DELETE FROM tareas WHERE id = ?";
        try (Connection conn = Util.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar tarea: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
