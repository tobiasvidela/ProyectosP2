package gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Color alternado para las filas
        if (row % 2 == 0) {
            cell.setBackground(new Color(230, 240, 255)); // Color suave para las filas pares
        } else {
            cell.setBackground(Color.WHITE); // Color blanco para las filas impares
        }

        // Cambiar el color de la fila si está seleccionada
        if (isSelected) {
            cell.setBackground(new Color(184, 207, 229)); // Color para la fila seleccionada
        }

        // Asegurarse de que el texto sea legible
        cell.setForeground(Color.BLACK);

        return cell;
    }
}
