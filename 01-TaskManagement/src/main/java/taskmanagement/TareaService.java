/**
 * Gestión de Tareas 
 * 
 * 1. Crear Tarea: Los usuarios deben poder crear nuevas tareas proporcionando un título,
 * una descripción y asignando un estado inicial (Nuevo, Pendiente, Finalizado).
 * 2. Ver Tareas: Los usuarios deben poder ver la lista de todas sus tareas con su ID, título,
 * descripción y estado.
 * 3. Actualizar Tarea: Los usuarios deben poder actualizar el título, la descripción y el estado 
 * de una tarea específica, identificándola por su ID.
 * 4. Eliminar Tarea: Los usuarios deben poder eliminar una tarea específica, identificándola por su ID.
 */
package taskmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */
public class TareaService {
    private Map<String, List<Tarea>> tareasPorUsuario = new HashMap<>();

    public Tarea crearTarea(String nombreUsuario, String titulo, String descripcion, String estado) {
        Tarea nuevaTarea = new Tarea(titulo, descripcion, estado);
        tareasPorUsuario.computeIfAbsent(nombreUsuario, k -> new ArrayList<>()).add(nuevaTarea);
        return nuevaTarea;
    }

    public List<Tarea> obtenerTareas(String nombreUsuario) {
        return tareasPorUsuario.getOrDefault(nombreUsuario, new ArrayList<>());
    }

    public boolean actualizarTarea(String nombreUsuario, int id, String nuevoTitulo, String nuevaDescripcion, String nuevoEstado) {
        List<Tarea> tareas = tareasPorUsuario.get(nombreUsuario);
        if (tareas != null) {
            for (Tarea tarea : tareas) {
                if (tarea.getId() == id) {
                    if (nuevoTitulo != null && !nuevoTitulo.trim().isEmpty()) {
                        tarea.setTitulo(nuevoTitulo);
                    }
                    if (nuevaDescripcion != null && !nuevaDescripcion.trim().isEmpty()) {
                        tarea.setDescripcion(nuevaDescripcion);
                    }
                    if (nuevoEstado != null && !nuevoEstado.trim().isEmpty()) {
                        tarea.setEstado(nuevoEstado);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean eliminarTarea(String nombreUsuario, int id) {
        List<Tarea> tareas = tareasPorUsuario.get(nombreUsuario);
        if (tareas != null) {
            return tareas.removeIf(tarea -> tarea.getId() == id);
        }
        return false;
    }
}