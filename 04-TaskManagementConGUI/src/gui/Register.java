/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author NETBOOK G5
 */
public class Register extends javax.swing.JFrame {
    private Login login;

    /**
     * Creates new form Register
     * @param login frame de login "padre"
     */
    public Register(Login login) {
        this.login = login;
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("ico_signup.png")).getImage());
        setLocationRelativeTo(null);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                // Al cerrar la ventana de Registro
                login.setVisible(true);
                dispose();
            }
        });
    }
    public Register(){
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_name_signup = new javax.swing.JTextField();
        txt_lastname_signup = new javax.swing.JTextField();
        txt_username_signup = new javax.swing.JTextField();
        txt_password_signup = new javax.swing.JTextField();
        btn_registrarUsuario = new javax.swing.JButton();
        btn_exit_signup = new javax.swing.JButton();
        lbl_signupTitle = new javax.swing.JLabel();
        lbl_name_signup = new javax.swing.JLabel();
        lbl_username_signup = new javax.swing.JLabel();
        lbl_lastname_signup = new javax.swing.JLabel();
        lbl_password_signup = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btn_registrarUsuario.setText("Registrar Usuario");
        btn_registrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarUsuarioActionPerformed(evt);
            }
        });

        btn_exit_signup.setText("Volver");
        btn_exit_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exit_signupActionPerformed(evt);
            }
        });

        lbl_signupTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_signupTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_signupTitle.setText("Formulario de Registro");

        lbl_name_signup.setText("Nombre/s");

        lbl_username_signup.setText("Username");

        lbl_lastname_signup.setText("Apellido/s");

        lbl_password_signup.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(lbl_signupTitle)
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_name_signup)
                    .addComponent(txt_name_signup)
                    .addComponent(lbl_username_signup)
                    .addComponent(txt_username_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_registrarUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_lastname_signup)
                    .addComponent(lbl_password_signup)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_exit_signup)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_password_signup, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txt_lastname_signup))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_signupTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_name_signup)
                    .addComponent(lbl_lastname_signup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_name_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_lastname_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_username_signup)
                    .addComponent(lbl_password_signup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_username_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_password_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_exit_signup)
                    .addComponent(btn_registrarUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exit_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exit_signupActionPerformed
        this.dispose();
        login.setVisible(true);
        System.out.println("Exit Registro");
    }//GEN-LAST:event_btn_exit_signupActionPerformed

    private void btn_registrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarUsuarioActionPerformed
        String name = txt_name_signup.getText();
        String lastname = txt_lastname_signup.getText();
        String username = txt_username_signup.getText();
        String password = txt_password_signup.getText();
        if (name != null && lastname != null && username != null && password != null
                && !name.equals("") && !lastname.equals("") && !username.equals("") && !password.equals("")) {
            if (logica.Main.registrarUsuario(name, lastname, username, password)) {
                JOptionPane.showMessageDialog(this, "Usuario registrado con éxito", "Registro", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al añadir al Usuario a la Base de Datos", "Registro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_registrarUsuarioActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit_signup;
    private javax.swing.JButton btn_registrarUsuario;
    private javax.swing.JLabel lbl_lastname_signup;
    private javax.swing.JLabel lbl_name_signup;
    private javax.swing.JLabel lbl_password_signup;
    private javax.swing.JLabel lbl_signupTitle;
    private javax.swing.JLabel lbl_username_signup;
    private javax.swing.JTextField txt_lastname_signup;
    private javax.swing.JTextField txt_name_signup;
    private javax.swing.JTextField txt_password_signup;
    private javax.swing.JTextField txt_username_signup;
    // End of variables declaration//GEN-END:variables
}
