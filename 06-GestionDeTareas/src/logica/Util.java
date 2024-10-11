package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_tareas";// Cambia gestion_tareas por el nombre de tu db
    private static final String USER = "root"; // Cambia si tu usuario es diferente
    private static final String PASSWORD = ""; // Cambia si tienes una contraseña
    
    private static final Icon db_JOP_icon = recursos.iconos.IconGetter.db_JOP_icon;
    
    public static void conectarBaseDatos() {
        boolean conectado = false;
        
        while (!conectado) {
            try (Connection conn = Util.getConnection()) {
                if (conn != null) {
                    conectado = true;
                    JOptionPane.showMessageDialog(null,
                            "Conexión exitosa.",
                            "Database Connection",
                            JOptionPane.PLAIN_MESSAGE,
                            db_JOP_icon);
                    //cargar todos los usuarios desde la BD
                    UsuarioService.cargarUsuariosDesdeBD();
                    // Mostrar la pantalla de login
                    java.awt.EventQueue.invokeLater(() -> {
                        gui.Login login = new gui.Login();
                        login.setVisible(true);
                    });
                }
            } catch (SQLException e) {
                // Mostrar mensaje de error y opciones para reintentar o salir
                int opcion = JOptionPane.showOptionDialog(null,
                        "No se pudo conectar con la base de datos. ¿Desea reintentar?",
                        "Conexión a la Base de Datos",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.ERROR_MESSAGE,
                        null, new String[]{"Reintentar", "Salir"}, "Reintentar");
                
                if (opcion == JOptionPane.NO_OPTION) {
                    // Salir del sistema si elige "Salir"
                    System.exit(0);
                }
            }
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static Date convertirFecha(String fecha, SimpleDateFormat formato) {
        if (fecha != null) {
            try {
                // Convertir el String a Date
                Date fechaEntregaDate = formato.parse(fecha);
                return fechaEntregaDate;
            } catch (ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Error parseando fecha.",
                        "Convertir Fecha (String -> Date)",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Sin fecha. Devolviendo fecha actual",
                    "Convertir Fecha (String -> Date)",
                    JOptionPane.ERROR_MESSAGE);
            return new Date();
        }        
    }
}

