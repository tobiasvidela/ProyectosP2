package gui;

import java.util.Date;
import javax.swing.JOptionPane;

public class CrearTarea extends javax.swing.JDialog {
    
    public CrearTarea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/new_task_menu.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_crear_tarea = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        txt_titulo = new javax.swing.JTextField();
        lbl_descr = new javax.swing.JLabel();
        sp_descr = new javax.swing.JScrollPane();
        txt_descr = new javax.swing.JTextArea();
        lbl_estado = new javax.swing.JLabel();
        select_estado = new javax.swing.JComboBox<>();
        lbl_fecha_entrega = new javax.swing.JLabel();
        lbl_fecha_seleccionada = new javax.swing.JLabel();
        calendar_fecha_entrega = new com.toedter.calendar.JCalendar();
        btn_crear_tarea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva tarea");
        setBackground(new java.awt.Color(230, 247, 245));
        setResizable(false);

        p_crear_tarea.setBackground(new java.awt.Color(230, 247, 245));

        lbl_titulo.setText("Título:");

        txt_titulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_descr.setText("Descripción:");

        txt_descr.setColumns(20);
        txt_descr.setLineWrap(true);
        txt_descr.setRows(5);
        txt_descr.setWrapStyleWord(true);
        txt_descr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sp_descr.setViewportView(txt_descr);

        lbl_estado.setText("Estado:");

        select_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo", "Pendiente", "Finalizado" }));
        select_estado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_fecha_entrega.setText("Fecha de Entrega:");

        lbl_fecha_seleccionada.setText("yyyy-mm-dd");

        calendar_fecha_entrega.setBackground(new java.awt.Color(230, 247, 245));
        calendar_fecha_entrega.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        calendar_fecha_entrega.setDecorationBackgroundVisible(false);
        calendar_fecha_entrega.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendar_fecha_entregaPropertyChange(evt);
            }
        });

        btn_crear_tarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/new_task_menu.png"))); // NOI18N
        btn_crear_tarea.setText("Crear Tarea");
        btn_crear_tarea.setToolTipText("");
        btn_crear_tarea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_crear_tarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crear_tareaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_crear_tareaLayout = new javax.swing.GroupLayout(p_crear_tarea);
        p_crear_tarea.setLayout(p_crear_tareaLayout);
        p_crear_tareaLayout.setHorizontalGroup(
            p_crear_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_crear_tareaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(p_crear_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_titulo)
                    .addComponent(lbl_descr)
                    .addGroup(p_crear_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_titulo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sp_descr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
                .addGap(20, 20, 20)
                .addGroup(p_crear_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_crear_tareaLayout.createSequentialGroup()
                        .addComponent(lbl_fecha_entrega)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(lbl_fecha_seleccionada))
                    .addGroup(p_crear_tareaLayout.createSequentialGroup()
                        .addComponent(lbl_estado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(calendar_fecha_entrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(select_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_crear_tareaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_crear_tarea)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_crear_tareaLayout.setVerticalGroup(
            p_crear_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_crear_tareaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(p_crear_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_titulo)
                    .addComponent(lbl_estado))
                .addGap(10, 10, 10)
                .addGroup(p_crear_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(p_crear_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_descr)
                    .addComponent(lbl_fecha_entrega)
                    .addComponent(lbl_fecha_seleccionada))
                .addGap(10, 10, 10)
                .addGroup(p_crear_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calendar_fecha_entrega, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(sp_descr))
                .addGap(18, 18, 18)
                .addComponent(btn_crear_tarea)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_crear_tarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_crear_tarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calendar_fecha_entregaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendar_fecha_entregaPropertyChange
        lbl_fecha_seleccionada.setText(logica.Util.getDateFormat().format(calendar_fecha_entrega.getDate()));
    }//GEN-LAST:event_calendar_fecha_entregaPropertyChange

    private void btn_crear_tareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crear_tareaActionPerformed
        boolean camposCompletos = validarCampos();
        
        String titulo = txt_titulo.getText().trim();
        String descr = txt_descr.getText().trim();
        String estado = (String) select_estado.getSelectedItem();
        String f_e = lbl_fecha_seleccionada.getText();
        String F_C = logica.Util.getDateFormat().format(new Date());
        
        int id_usuario = logica.UsuarioService.obtenerUsuarioPorUsername(logica.Main.USUARIO_ACTUAL).getId();
        
        if (camposCompletos) {
            logica.TareaService.crearTarea(titulo, descr, estado, id_usuario, f_e, F_C);
            this.dispose();
        }
    }//GEN-LAST:event_btn_crear_tareaActionPerformed

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
            java.util.logging.Logger.getLogger(CrearTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CrearTarea dialog = new CrearTarea(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_crear_tarea;
    private com.toedter.calendar.JCalendar calendar_fecha_entrega;
    private javax.swing.JLabel lbl_descr;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_fecha_entrega;
    private javax.swing.JLabel lbl_fecha_seleccionada;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPanel p_crear_tarea;
    private javax.swing.JComboBox<String> select_estado;
    private javax.swing.JScrollPane sp_descr;
    private javax.swing.JTextArea txt_descr;
    private javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables

    private boolean validarCampos() {
        String titulo = txt_titulo.getText().trim();
        String descripcion = txt_descr.getText().trim();
        String estado = (String) select_estado.getSelectedItem();
        String fecha_entrega = lbl_fecha_seleccionada.getText();

        // Validar que todos los campos estén completos
        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debes ingresar un título para la tarea.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debes ingresar una descripción para la tarea.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (estado == null || estado.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debes seleccionar un estado para la tarea.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (fecha_entrega.equals("yyyy-mm-dd")) {
            JOptionPane.showMessageDialog(this,
                    "Debes seleccionar una fecha de entrega.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
}
