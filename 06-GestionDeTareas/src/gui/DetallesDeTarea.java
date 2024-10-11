package gui;

public class DetallesDeTarea extends javax.swing.JDialog {
    
    public DetallesDeTarea(java.awt.Frame parent, boolean modal, logica.Tarea tareaSeleccionada) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        if (tareaSeleccionada != null) {
            txt_titulo.setText(tareaSeleccionada.getTitulo());
            txt_descr.setText(tareaSeleccionada.getDescripcion());
            txt_estado.setText(tareaSeleccionada.getEstado());
            txt_fecha_entrega.setText(tareaSeleccionada.getFechaEntrega());
            txt_fecha_creacion.setText(tareaSeleccionada.getFechaCreacion());
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

        p_detalles = new javax.swing.JPanel();
        sp_descr = new javax.swing.JScrollPane();
        txt_descr = new javax.swing.JTextArea();
        lbl_fecha_entrega = new javax.swing.JLabel();
        lbl_fecha_creacion = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_estado = new javax.swing.JLabel();
        txt_titulo = new javax.swing.JLabel();
        txt_estado = new javax.swing.JLabel();
        txt_fecha_entrega = new javax.swing.JLabel();
        txt_fecha_creacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txt_descr.setEditable(false);
        txt_descr.setColumns(20);
        txt_descr.setLineWrap(true);
        txt_descr.setRows(5);
        txt_descr.setText("Descripción");
        txt_descr.setWrapStyleWord(true);
        txt_descr.setOpaque(false);
        sp_descr.setViewportView(txt_descr);

        lbl_fecha_entrega.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_fecha_entrega.setText("Entrega: ");

        lbl_fecha_creacion.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_fecha_creacion.setText("Creada: ");

        lbl_titulo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_titulo.setText("Título: ");

        lbl_estado.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_estado.setText("Estado: ");

        txt_titulo.setText("titulo");

        txt_estado.setText("estado");

        txt_fecha_entrega.setText("yyyy-mm-dd");

        txt_fecha_creacion.setText("yyyy-mm-dd");

        javax.swing.GroupLayout p_detallesLayout = new javax.swing.GroupLayout(p_detalles);
        p_detalles.setLayout(p_detallesLayout);
        p_detallesLayout.setHorizontalGroup(
            p_detallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_detallesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(p_detallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_descr)
                    .addGroup(p_detallesLayout.createSequentialGroup()
                        .addComponent(lbl_titulo)
                        .addGap(33, 33, 33)
                        .addComponent(txt_titulo)
                        .addGap(0, 153, Short.MAX_VALUE))
                    .addGroup(p_detallesLayout.createSequentialGroup()
                        .addGroup(p_detallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_detallesLayout.createSequentialGroup()
                                .addComponent(lbl_estado)
                                .addGap(24, 24, 24)
                                .addComponent(txt_estado))
                            .addGroup(p_detallesLayout.createSequentialGroup()
                                .addComponent(lbl_fecha_creacion)
                                .addGap(20, 20, 20)
                                .addComponent(txt_fecha_creacion))
                            .addGroup(p_detallesLayout.createSequentialGroup()
                                .addComponent(lbl_fecha_entrega)
                                .addGap(16, 16, 16)
                                .addComponent(txt_fecha_entrega)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        p_detallesLayout.setVerticalGroup(
            p_detallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_detallesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(p_detallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_titulo)
                    .addComponent(txt_titulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_detallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_estado)
                    .addComponent(txt_estado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_detallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_fecha_entrega)
                    .addComponent(txt_fecha_entrega))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_detallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_fecha_creacion)
                    .addComponent(txt_fecha_creacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp_descr, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_detalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_detalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DetallesDeTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesDeTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesDeTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesDeTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetallesDeTarea dialog = new DetallesDeTarea(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_fecha_creacion;
    private javax.swing.JLabel lbl_fecha_entrega;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPanel p_detalles;
    private javax.swing.JScrollPane sp_descr;
    private javax.swing.JTextArea txt_descr;
    private javax.swing.JLabel txt_estado;
    private javax.swing.JLabel txt_fecha_creacion;
    private javax.swing.JLabel txt_fecha_entrega;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}
