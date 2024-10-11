package gui;

import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    public static final Icon login_JOP_icon = recursos.iconos.IconGetter.login_JOP_icon;
    public static final Icon exit_JOP_icon = recursos.iconos.IconGetter.exit_JOP_icon;
    
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_login = new javax.swing.JPanel();
        lbl_username = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        lbl_password = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        btn_registrarse = new javax.swing.JButton();
        btn_iniciar_sesion = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_username.setText("Usuario");

        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });

        lbl_password.setText("Contraseña");

        btn_registrarse.setText("Registrarse");

        btn_iniciar_sesion.setText("Iniciar Sesión");
        btn_iniciar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciar_sesionActionPerformed(evt);
            }
        });

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_loginLayout = new javax.swing.GroupLayout(p_login);
        p_login.setLayout(p_loginLayout);
        p_loginLayout.setHorizontalGroup(
            p_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_loginLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(p_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_loginLayout.createSequentialGroup()
                        .addComponent(btn_registrarse)
                        .addGap(18, 18, 18)
                        .addComponent(btn_iniciar_sesion))
                    .addGroup(p_loginLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(p_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_password)
                            .addComponent(lbl_username))
                        .addGap(20, 20, 20)
                        .addGroup(p_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_username, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txt_password))))
                .addGap(18, 18, 18)
                .addComponent(btn_salir)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        p_loginLayout.setVerticalGroup(
            p_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_loginLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(p_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_username)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_password)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_registrarse)
                    .addComponent(btn_iniciar_sesion)
                    .addComponent(btn_salir))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void btn_iniciar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciar_sesionActionPerformed
        String username = txt_username.getText();
        String password = new String(txt_password.getPassword());
        if (!username.isEmpty() && !password.isEmpty()) {
            if (logica.UsuarioService.autenticarUsuario(username, password)) {
                //Ir a principal
                logica.Main.USUARIO_ACTUAL = username;
                Principal main = new Principal();
                main.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Debes estar registrado para iniciar sesión.",
                    "Iniciar Sesión",
                    JOptionPane.WARNING_MESSAGE, 
                    login_JOP_icon);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Debes ingresar un nombre de usuario y una contraseña para iniciar sesión.",
                    "Iniciar Sesión",
                    JOptionPane.WARNING_MESSAGE, 
                    login_JOP_icon);
        }
    }//GEN-LAST:event_btn_iniciar_sesionActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        if (JOptionPane.showConfirmDialog(this,
                "¿Salir del programa?",
                "Salir del programa",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE,
                exit_JOP_icon) == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btn_salirActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_iniciar_sesion;
    private javax.swing.JButton btn_registrarse;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JPanel p_login;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
