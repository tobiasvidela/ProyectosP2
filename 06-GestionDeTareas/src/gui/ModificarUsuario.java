package gui;

import javax.swing.Icon;
import javax.swing.JOptionPane;

public class ModificarUsuario extends javax.swing.JDialog {
    private static Icon modify_JOP_icon = recursos.iconos.IconGetter.modify_user_JOP_icon;
    private logica.Usuario usuarioActual = logica.UsuarioService.obtenerUsuarioPorUsername(logica.Main.USUARIO_ACTUAL);
    
    public ModificarUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/modify_user_JOP.png")).getImage());
        txt_nombre.setText(usuarioActual.getNombre());
        txt_apellido.setText(usuarioActual.getApellido());
        txt_username.setText(usuarioActual.getUsername());
        txt_password.setText(usuarioActual.getContrasena());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_modificar_usuario = new javax.swing.JPanel();
        lbl_nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        lbl_apellido = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        lbl_username = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        lbl_password = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        btn_modificar_usuario = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar Datos");
        setIconImage(null);
        setResizable(false);

        p_modificar_usuario.setBackground(new java.awt.Color(230, 247, 245));

        lbl_nombre.setText("Nombre/s:");

        txt_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_apellido.setText("Apellido/s:");

        txt_apellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_username.setText("Username:");

        txt_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_password.setText("Password:");

        txt_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_modificar_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/guardar_cambios_JOP.png"))); // NOI18N
        btn_modificar_usuario.setToolTipText("Modificar");
        btn_modificar_usuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_modificar_usuario.setBorderPainted(false);
        btn_modificar_usuario.setContentAreaFilled(false);
        btn_modificar_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificar_usuario.setFocusPainted(false);
        btn_modificar_usuario.setFocusable(false);
        btn_modificar_usuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_modificar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_usuarioActionPerformed(evt);
            }
        });

        btn_volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/volver_JOP.png"))); // NOI18N
        btn_volver.setToolTipText("Volver");
        btn_volver.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_volver.setBorderPainted(false);
        btn_volver.setContentAreaFilled(false);
        btn_volver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_volver.setFocusPainted(false);
        btn_volver.setFocusable(false);
        btn_volver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_modificar_usuarioLayout = new javax.swing.GroupLayout(p_modificar_usuario);
        p_modificar_usuario.setLayout(p_modificar_usuarioLayout);
        p_modificar_usuarioLayout.setHorizontalGroup(
            p_modificar_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_modificar_usuarioLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(p_modificar_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_modificar_usuarioLayout.createSequentialGroup()
                        .addComponent(btn_modificar_usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_volver))
                    .addGroup(p_modificar_usuarioLayout.createSequentialGroup()
                        .addGroup(p_modificar_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_modificar_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(p_modificar_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(p_modificar_usuarioLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lbl_nombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(p_modificar_usuarioLayout.createSequentialGroup()
                                        .addComponent(lbl_apellido)
                                        .addGap(12, 12, 12)))
                                .addGroup(p_modificar_usuarioLayout.createSequentialGroup()
                                    .addComponent(lbl_username)
                                    .addGap(13, 13, 13)))
                            .addGroup(p_modificar_usuarioLayout.createSequentialGroup()
                                .addComponent(lbl_password)
                                .addGap(16, 16, 16)))
                        .addGroup(p_modificar_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(txt_username)
                            .addComponent(txt_apellido)
                            .addComponent(txt_nombre))))
                .addGap(48, 48, 48))
        );
        p_modificar_usuarioLayout.setVerticalGroup(
            p_modificar_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_modificar_usuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(p_modificar_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombre)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(p_modificar_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_apellido)
                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(p_modificar_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_username)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(p_modificar_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_password)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(p_modificar_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_modificar_usuario)
                    .addComponent(btn_volver))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_modificar_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_modificar_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_modificar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_usuarioActionPerformed
        String nombre = txt_nombre.getText();
        String apellido = txt_apellido.getText();
        String username = txt_username.getText().toLowerCase();
        String password = txt_password.getText();
        
        // Verificar si algún campo está vacío
        if (nombre.isEmpty() || apellido.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Ningún campo debe estar vacío.",
                    "Actualizar Datos",
                    JOptionPane.WARNING_MESSAGE,
                    modify_JOP_icon);
            return;
        }
        
        // Verificar si se ha realizado algún cambio
        boolean cambiosRealizados = !nombre.equalsIgnoreCase(usuarioActual.getNombre()) ||
                !apellido.equalsIgnoreCase(usuarioActual.getApellido()) ||
                !username.equalsIgnoreCase(usuarioActual.getUsername()) ||
                !password.equals(usuarioActual.getContrasena());
        
        if (!cambiosRealizados) {
            JOptionPane.showMessageDialog(this,
                    "No has alterado ningún campo.",
                    "Actualizar Datos",
                    JOptionPane.INFORMATION_MESSAGE,
                    modify_JOP_icon);
            return;
        }
        
        logica.Usuario usuarioActualizado = new logica.Usuario(usuarioActual.getId(), nombre, apellido, username, password);
        if (logica.UsuarioService.actualizarUsuario(usuarioActualizado)) {
            logica.Main.USUARIO_ACTUAL = username;
            JOptionPane.showMessageDialog(this,
                    "Tu información ha sido actualizada exitosamente.",
                    "Actualizar Datos",
                    JOptionPane.INFORMATION_MESSAGE,
                    modify_JOP_icon);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "No se pudo actualizar tu información.",
                    "Actualizar Datos",
                    JOptionPane.ERROR_MESSAGE,
                    modify_JOP_icon);
        }
    }//GEN-LAST:event_btn_modificar_usuarioActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarUsuario dialog = new ModificarUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_modificar_usuario;
    private javax.swing.JButton btn_volver;
    private javax.swing.JLabel lbl_apellido;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JPanel p_modificar_usuario;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
