package logica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class TareaService {
    private static Map<Integer, Tarea> tareas = new HashMap<>();
    private static TareaDAO tareaDAO = new TareaDAO();
    private static final Icon db_icon = recursos.iconos.IconGetter.db_JOP_icon;

    public static void cargarTareasDesdeBD() {
        List<Tarea> tareasList = tareaDAO.obtenerTodasTareas();
        for (Tarea tarea : tareasList) {
            tareas.put(tarea.getId(), tarea);
        }
    }

    public static boolean crearTarea(String titulo, String descripcion, String estado, int idUsuario, String fecha_entrega, String fecha_creacion) {
        Tarea nuevaTarea = new Tarea(titulo, descripcion, estado, idUsuario, fecha_entrega, fecha_creacion);
        try {
            int idGenerado = tareaDAO.agregarTarea(nuevaTarea);
            nuevaTarea.setId(idGenerado);  // Establece el ID generado
            tareas.put(idGenerado, nuevaTarea);
            JOptionPane.showMessageDialog(null, 
                    "Tarea añadida a la Base de Datos.", 
                    "TareaService", 
                    JOptionPane.PLAIN_MESSAGE,
                    db_icon);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Error al intentar añadir la tarea a la Base de Datos.\n" + e.getMessage(), 
                    "TareaService", 
                    JOptionPane.ERROR_MESSAGE,
                    db_icon);
            return false;
        }
    }

    public static Tarea obtenerTareaPorId(int id) {
        return tareaDAO.obtenerTareaPorId(id);
    }

    public static List<Tarea> obtenerTareasPorUsuario(int idUsuario) {
        return tareaDAO.obtenerTareasPorUsuario(idUsuario);
    }

    public static boolean actualizarTarea(Tarea tarea) {
        try {
            //tareas.put(tarea.getId(), tarea);  // Actualiza en el mapa también
            return tareaDAO.actualizarTarea(tarea);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Error al intentar actualizar la tarea en la Base de Datos.\n" + e.getMessage(), 
                    "TareaService", 
                    JOptionPane.ERROR_MESSAGE,
                    db_icon);
            return false;
        }
    }

    public static boolean eliminarTarea(int id) {
        try {
            tareaDAO.eliminarTarea(id);
            tareas.remove(id);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Error al intentar eliminar la tarea de la Base de Datos.\n" + e.getMessage(), 
                    "TareaService", 
                    JOptionPane.ERROR_MESSAGE,
                    db_icon);
            return false;
        }
    }   
}
