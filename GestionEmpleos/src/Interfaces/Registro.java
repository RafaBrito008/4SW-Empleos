/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sql.ConexionSQL;

/**
 *
 * @author Rafa Brito
 */
public class Registro extends javax.swing.JFrame {
    Login login = new Login();
    Principal principal = new Principal();

    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
        estilos();
        this.setLocation(600, 250);
    }

    public void registrar() {
        if (comprobarVacio() == true) {
            if (comprobarPassword() == true) {
                try {
                    ConexionSQL cc = new ConexionSQL();
                    Connection cn = cc.conectar();

                    String sql = "INSERT INTO usuarios (CED_USU, USERNAME_USU, PASSWORD_USU, NOMBRE_USU, APELLIDO_USU, TIPO_USU) "
                            + "VALUES (?,?,(aes_encrypt(?, 'AES')),?,?,?)";
                    PreparedStatement psd = cn.prepareStatement(sql);

                    psd.setString(1, this.jtxtCedula.getText().toUpperCase());
                    psd.setString(2, this.jtxtUsername.getText().toUpperCase());
                    psd.setString(3, this.jpswfPassword.getText().toUpperCase());
                    psd.setString(4, this.jtxtNombre.getText().toUpperCase());
                    psd.setString(5, this.jtxtApellido.getText().toUpperCase());
                    psd.setString(6, String.valueOf(this.jcbxTipo.getSelectedItem()));

                    int n = psd.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Se registr?? correctamente.");
                        limpiarTextos();
                        this.dispose();
                        this.login.setVisible(true);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean comprobarVacio() {
        boolean valido = false;
        if (this.jtxtCedula.getText().isEmpty() || this.jtxtUsername.getText().isEmpty() || this.jpswfPassword.getText().isEmpty()
                || this.jpswfConfPass.getText().isEmpty() || this.jtxtNombre.getText().isEmpty()
                || this.jtxtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Ingrese todos los campos.");
        } else {
            valido = true;
        }
        return valido;
    }

    public boolean comprobarPassword() {
        boolean valido = false;
        String password = this.jpswfPassword.getText();
        String confPass = this.jpswfConfPass.getText();

        if (password.equals(confPass)) {
            valido = true;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ingrese contrase??as iguales.");
        }
        return valido;
    }

    public void limpiarTextos() {
        this.jtxtCedula.setText(null);
        this.jtxtUsername.setText(null);
        this.jpswfPassword.setText(null);
        this.jpswfConfPass.setText(null);
        this.jtxtNombre.setText(null);
        this.jtxtApellido.setText(null);
    }
    
    public void estilos(){
        //TITULO
        this.jlblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        this.jlblTitulo.setForeground(Color.WHITE);
        
        //ETIQUETAS
        this.jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        this.jLabel1.setForeground(Color.WHITE);
        
        this.jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        this.jLabel2.setForeground(Color.WHITE);
        
        this.jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 18));
        this.jLabel3.setForeground(Color.WHITE);
        
        this.jLabel4.setFont(new Font("Segoe UI", Font.BOLD, 18));
        this.jLabel4.setForeground(Color.WHITE);
        
        this.jLabel5.setFont(new Font("Segoe UI", Font.BOLD, 18));
        this.jLabel5.setForeground(Color.WHITE);
        
        this.jLabel6.setFont(new Font("Segoe UI", Font.BOLD, 18));
        this.jLabel6.setForeground(Color.WHITE);
        
        this.jLabel7.setFont(new Font("Segoe UI", Font.BOLD, 18));
        this.jLabel7.setForeground(Color.WHITE);
                
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jtxtUsername = new javax.swing.JTextField();
        jtxtCedula = new javax.swing.JTextField("", 10);
        jpswfPassword = new javax.swing.JPasswordField();
        jpswfConfPass = new javax.swing.JPasswordField();
        jtxtNombre = new javax.swing.JTextField();
        jtxtApellido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcbxTipo = new javax.swing.JComboBox<>();
        jlblTitulo = new javax.swing.JLabel();
        jbtnRegistrar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtxtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtUsernameKeyTyped(evt);
            }
        });

        jtxtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCedulaKeyTyped(evt);
            }
        });

        jpswfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jpswfPasswordKeyTyped(evt);
            }
        });

        jpswfConfPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jpswfConfPassKeyTyped(evt);
            }
        });

        jtxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNombreKeyTyped(evt);
            }
        });

        jtxtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtApellidoKeyTyped(evt);
            }
        });

        jLabel1.setText("C??dula:");

        jLabel2.setText("Username:");

        jLabel3.setText("Contrase??a:");

        jLabel4.setText("Confirmar contrase??a:");

        jLabel5.setText("Nombre:");

        jLabel6.setText("Apellido:");

        jLabel7.setText("Tipo:");

        jcbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OFERTANTE", "TRABAJADOR" }));

        jlblTitulo.setText("REGISTRO DE USUARIO");

        jbtnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnRegistrar.setText("Registrar");
        jbtnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegistrarActionPerformed(evt);
            }
        });

        jbtnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jtxtUsername, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtxtCedula, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jpswfPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jpswfConfPass, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtxtNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtxtApellido, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbxTipo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jlblTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbtnRegistrar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbtnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(jpswfConfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jpswfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jlblTitulo))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnCancelar)))
                .addGap(18, 18, 18)
                .addComponent(jbtnRegistrar)
                .addGap(22, 22, 22))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblTitulo)
                .addGap(43, 43, 43)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpswfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpswfConfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnRegistrar)
                    .addComponent(jbtnCancelar))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        this.dispose();
        this.principal.setVisible(true);
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jtxtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCedulaKeyTyped
        if (jtxtCedula.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtCedulaKeyTyped

    private void jtxtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtUsernameKeyTyped
        if (jtxtUsername.getText().length() >= 25) {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtUsernameKeyTyped

    private void jtxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombreKeyTyped
        if (jtxtNombre.getText().length() >= 25) {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtNombreKeyTyped

    private void jtxtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtApellidoKeyTyped
        if (jtxtApellido.getText().length() >= 25) {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtApellidoKeyTyped

    private void jpswfPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpswfPasswordKeyTyped
        if (jpswfPassword.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_jpswfPasswordKeyTyped

    private void jpswfConfPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpswfConfPassKeyTyped
        if (jpswfConfPass.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_jpswfConfPassKeyTyped

    private void jbtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegistrarActionPerformed
        registrar();
    }//GEN-LAST:event_jbtnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnRegistrar;
    private javax.swing.JComboBox<String> jcbxTipo;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JPasswordField jpswfConfPass;
    private javax.swing.JPasswordField jpswfPassword;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JTextField jtxtCedula;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtUsername;
    // End of variables declaration//GEN-END:variables
}
