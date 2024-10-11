package gui;

import javax.swing.JOptionPane;

public class EditarTarea extends javax.swing.JDialog {
    private logica.Tarea tarea = null;

    public EditarTarea(java.awt.Frame parent, boolean modal, logica.Tarea tarea) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/edit_task_menu.png")).getImage());
        if (tarea != null) {
            this.tarea = tarea;
            this.setTitle("Editando " + tarea.getTitulo());
            txt_titulo.setText(tarea.getTitulo());
            txt_descr.setText(tarea.getDescripcion());
            select_estado.setSelectedItem(tarea.getEstado());
            calendar_fecha_entrega.setDate(logica.Util.convertirFecha(tarea.getFechaEntrega()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_editar_tarea = new javax.swing.JPanel();
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
        btn_editar_tarea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar");
        setBackground(new java.awt.Color(230, 247, 245));
        setResizable(false);

        p_editar_tarea.setBackground(new java.awt.Color(230, 247, 245));

        lbl_titulo.setText("Título:");

        txt_titulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_descr.setText("Descripción:");

        sp_descr.setBackground(new java.awt.Color(230, 247, 245));

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

        btn_editar_tarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/edit_task_menu.png"))); // NOI18N
        btn_editar_tarea.setText("Actualizar Tarea");
        btn_editar_tarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_tareaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_editar_tareaLayout = new javax.swing.GroupLayout(p_editar_tarea);
        p_editar_tarea.setLayout(p_editar_tareaLayout);
        p_editar_tareaLayout.setHorizontalGroup(
            p_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_editar_tareaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(p_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_titulo)
                    .addComponent(lbl_descr)
                    .addGroup(p_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_titulo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sp_descr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
                .addGap(20, 20, 20)
                .addGroup(p_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_editar_tareaLayout.createSequentialGroup()
                        .addComponent(lbl_fecha_entrega)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(lbl_fecha_seleccionada))
                    .addGroup(p_editar_tareaLayout.createSequentialGroup()
                        .addComponent(lbl_estado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(calendar_fecha_entrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(select_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_editar_tareaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_editar_tarea)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_editar_tareaLayout.setVerticalGroup(
            p_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_editar_tareaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(p_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_titulo)
                    .addComponent(lbl_estado))
                .addGap(10, 10, 10)
                .addGroup(p_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(p_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_descr)
                    .addComponent(lbl_fecha_entrega)
                    .addComponent(lbl_fecha_seleccionada))
                .addGap(10, 10, 10)
                .addGroup(p_editar_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calendar_fecha_entrega, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(sp_descr))
                .addGap(18, 18, 18)
                .addComponent(btn_editar_tarea)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_editar_tarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_editar_tarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calendar_fecha_entregaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendar_fecha_entregaPropertyChange
        lbl_fecha_seleccionada.setText(logica.Util.getDateFormat().format(calendar_fecha_entrega.getDate()));
    }//GEN-LAST:event_calendar_fecha_entregaPropertyChange

    private void btn_editar_tareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_tareaActionPerformed
        boolean camposCompletos = validarCampos();
        
        String titulo = txt_titulo.getText().trim();
        String descr = txt_descr.getText().trim();
        String estado = (String) select_estado.getSelectedItem();
        String f_e = lbl_fecha_seleccionada.getText();
        String F_C = this.tarea.getFechaCreacion();
        
        if (camposCompletos) {
            logica.Tarea tareaActualizada = new logica.Tarea(tarea.getId(),
                    titulo, descr, estado,
                    tarea.getIdUsuario(), f_e, F_C);
            logica.TareaService.actualizarTarea(tareaActualizada);
            this.dispose();
        }
    }//GEN-LAST:event_btn_editar_tareaActionPerformed

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
                EditarTarea dialog = new EditarTarea(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton btn_editar_tarea;
    private com.toedter.calendar.JCalendar calendar_fecha_entrega;
    private javax.swing.JLabel lbl_descr;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_fecha_entrega;
    private javax.swing.JLabel lbl_fecha_seleccionada;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPanel p_editar_tarea;
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
