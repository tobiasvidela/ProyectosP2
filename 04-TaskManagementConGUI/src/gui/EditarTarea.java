/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.Main;

/**
 *
 * @author La Maquina
 */
public class EditarTarea extends javax.swing.JDialog {

    /**
     * Creates new form EditarTarea
     */
    public EditarTarea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle(MainMenu.tareaSeleccionada.getTitulo() + " - Edición");
        this.setIconImage(new ImageIcon(getClass().getResource("ico_editar_tarea.png")).getImage());
        this.setLocationRelativeTo(parent);
        
        // Rellenar campos con datos de la tarea
        txt_editar_tarea_titulo.setText(MainMenu.tareaSeleccionada.getTitulo());
        txt_editar_tarea_descr.setText(MainMenu.tareaSeleccionada.getDescripcion());
        select_editar_tarea_estado.setSelectedItem(MainMenu.tareaSeleccionada.getEstado());
        Date fecha_e = logica.Util.convertirFecha(MainMenu.tareaSeleccionada.getFechaEntrega(), MainMenu.dateFormat);
        calendar_fecha_entrega.setDate(fecha_e);
        
        // Inicializar el botón como deshabilitado
        btn_actualizar_tarea.setEnabled(false);
    }
    
    private void validarCampos() {
        // Obtener los valores de cada campo
        String titulo = txt_editar_tarea_titulo.getText().trim();
        String descripcion = txt_editar_tarea_descr.getText().trim();
        String estado = (String) select_editar_tarea_estado.getSelectedItem();
        Date fecha = calendar_fecha_entrega.getDate();

        // Comprobar si todos los campos están completos
        boolean camposCompletos = !titulo.isEmpty() && !descripcion.isEmpty() && estado != null && fecha != null;

        // Habilitar o deshabilitar el botón
        btn_actualizar_tarea.setEnabled(camposCompletos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_editar_tarea = new javax.swing.JPanel();
        lbl_editar_tarea_titulo = new javax.swing.JLabel();
        txt_editar_tarea_titulo = new javax.swing.JTextField();
        lbl_editar_tarea_descr = new javax.swing.JLabel();
        scroll_editar_tarea_descr = new javax.swing.JScrollPane();
        txt_editar_tarea_descr = new javax.swing.JTextArea();
        select_editar_tarea_estado = new javax.swing.JComboBox<>();
        lbl_editar_tarea_estado = new javax.swing.JLabel();
        calendar_fecha_entrega = new com.toedter.calendar.JCalendar();
        btn_actualizar_tarea = new javax.swing.JButton();
        lbl_editar_tarea_descr1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Tarea");

        lbl_editar_tarea_titulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_editar_tarea_titulo.setLabelFor(txt_editar_tarea_titulo);
        lbl_editar_tarea_titulo.setText("Título: ");

        txt_editar_tarea_titulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_editar_tarea_tituloKeyReleased(evt);
            }
        });

        lbl_editar_tarea_descr.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_editar_tarea_descr.setLabelFor(txt_editar_tarea_descr);
        lbl_editar_tarea_descr.setText("Descripción: ");

        txt_editar_tarea_descr.setColumns(20);
        txt_editar_tarea_descr.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_editar_tarea_descr.setLineWrap(true);
        txt_editar_tarea_descr.setRows(5);
        txt_editar_tarea_descr.setToolTipText("Añade tu descripción aquí");
        txt_editar_tarea_descr.setWrapStyleWord(true);
        txt_editar_tarea_descr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_editar_tarea_descrKeyReleased(evt);
            }
        });
        scroll_editar_tarea_descr.setViewportView(txt_editar_tarea_descr);

        select_editar_tarea_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo", "Pendiente", "Finalizado" }));
        select_editar_tarea_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_editar_tarea_estadoActionPerformed(evt);
            }
        });

        lbl_editar_tarea_estado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_editar_tarea_estado.setLabelFor(select_editar_tarea_estado);
        lbl_editar_tarea_estado.setText("Estado: ");

        calendar_fecha_entrega.setToolTipText("Fecha de Entrega");
        calendar_fecha_entrega.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendar_fecha_entregaPropertyChange(evt);
            }
        });

        btn_actualizar_tarea.setText("Actualizar Tarea");
        btn_actualizar_tarea.setToolTipText("Crear Tarea");
        btn_actualizar_tarea.setEnabled(false);
        btn_actualizar_tarea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_actualizar_tarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_tareaActionPerformed(evt);
            }
        });

        lbl_editar_tarea_descr1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_editar_tarea_descr1.setLabelFor(calendar_fecha_entrega);
        lbl_editar_tarea_descr1.setText("Fecha de Entrega: ");

        javax.swing.GroupLayout panel_editar_tareaLayout = new javax.swing.GroupLayout(panel_editar_tarea);
        panel_editar_tarea.setLayout(panel_editar_tareaLayout);
        panel_editar_tareaLayout.setHorizontalGroup(
            panel_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_editar_tareaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_editar_tareaLayout.createSequentialGroup()
                        .addComponent(lbl_editar_tarea_titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_editar_tarea_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_editar_tarea_estado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(select_editar_tarea_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_editar_tareaLayout.createSequentialGroup()
                        .addGroup(panel_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scroll_editar_tarea_descr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_actualizar_tarea)
                            .addComponent(lbl_editar_tarea_descr))
                        .addGap(18, 18, 18)
                        .addGroup(panel_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_editar_tarea_descr1)
                            .addComponent(calendar_fecha_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panel_editar_tareaLayout.setVerticalGroup(
            panel_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_editar_tareaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_editar_tarea_estado)
                        .addComponent(select_editar_tarea_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_editar_tarea_titulo)
                        .addComponent(txt_editar_tarea_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_editar_tarea_descr)
                    .addComponent(lbl_editar_tarea_descr1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_editar_tareaLayout.createSequentialGroup()
                        .addComponent(scroll_editar_tarea_descr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_actualizar_tarea))
                    .addComponent(calendar_fecha_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_editar_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_editar_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_editar_tarea_tituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_editar_tarea_tituloKeyReleased
        validarCampos();
    }//GEN-LAST:event_txt_editar_tarea_tituloKeyReleased

    private void txt_editar_tarea_descrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_editar_tarea_descrKeyReleased
        validarCampos();
    }//GEN-LAST:event_txt_editar_tarea_descrKeyReleased

    private void select_editar_tarea_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_editar_tarea_estadoActionPerformed
        validarCampos();
    }//GEN-LAST:event_select_editar_tarea_estadoActionPerformed

    private void calendar_fecha_entregaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendar_fecha_entregaPropertyChange
        validarCampos();
    }//GEN-LAST:event_calendar_fecha_entregaPropertyChange

    private void btn_actualizar_tareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_tareaActionPerformed
        if (JOptionPane.showConfirmDialog(this, 
                "¿Actualizar Tarea?", 
                "Confirmar cambios en " + MainMenu.tareaSeleccionada.getTitulo(),
                JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE) == 0) {
            
            int id = MainMenu.tareaSeleccionada.getId();
            String t = txt_editar_tarea_titulo.getText();
            String d = txt_editar_tarea_descr.getText();
            String e = (String) select_editar_tarea_estado.getSelectedItem();
            SimpleDateFormat dateFormat = MainMenu.dateFormat;
            String f_e = MainMenu.formatFecha(calendar_fecha_entrega.getDate(), dateFormat);
            //  NO MODIFICAR FECHA CREACIÓN
            String f_c = MainMenu.tareaSeleccionada.getFechaCreacion();

            int idUsuarioActual = Main.getUserByUsername(MainMenu.usuarioActual).getId();

            if (Main.actualizarTarea(id, t, d, e, idUsuarioActual, f_e, f_c)) {
                JOptionPane.showMessageDialog(this, 
                        "Tarea actualizada con éxito.",
                        MainMenu.tareaSeleccionada.getTitulo() + " - Edición", 
                        JOptionPane.INFORMATION_MESSAGE
                );
                
                this.dispose();
                
                System.out.println("Tarea " + MainMenu.tareaSeleccionada.getTitulo() + " actualizada.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Tarea no actualizada.");
        }
    }//GEN-LAST:event_btn_actualizar_tareaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarTarea dialog = new EditarTarea(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar_tarea;
    private com.toedter.calendar.JCalendar calendar_fecha_entrega;
    private javax.swing.JLabel lbl_editar_tarea_descr;
    private javax.swing.JLabel lbl_editar_tarea_descr1;
    private javax.swing.JLabel lbl_editar_tarea_estado;
    private javax.swing.JLabel lbl_editar_tarea_titulo;
    private javax.swing.JPanel panel_editar_tarea;
    private javax.swing.JScrollPane scroll_editar_tarea_descr;
    private javax.swing.JComboBox<String> select_editar_tarea_estado;
    private javax.swing.JTextArea txt_editar_tarea_descr;
    private javax.swing.JTextField txt_editar_tarea_titulo;
    // End of variables declaration//GEN-END:variables
}
