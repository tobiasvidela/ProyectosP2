package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_tareas";// Cambia gestion_tareas por el nombre de tu db
    private static final String USER = "root"; // Cambia si tu usuario es diferente
    private static final String PASSWORD = ""; // Cambia si tienes una contraseña

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
                JOptionPane.showMessageDialog(null, "Error parseando fecha.", "Convertir Fecha (String -> Date)", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sin fecha. Devolviendo fecha actual", "Convertir Fecha (String -> Date)", JOptionPane.ERROR_MESSAGE);
            return new Date();
        }        
    }
}
