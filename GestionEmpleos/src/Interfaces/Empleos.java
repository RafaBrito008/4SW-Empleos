/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import sql.ConexionSQL;

/**
 *
 * @author denni
 */
public class Empleos extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    Integer fila;
    public String id_empleo, id_empleoCancelado;

    String ced_usu_login;

    /**
     * Creates new form Empleos
     */
    public Empleos() {
        initComponents();
        cargarTablaEmpleosDisponibles();
        obtenerIdEmpleo();
        cargarTablaEmpleosCliente();
        obtenerIdEmpleoACancelar();
        bloquearBotones();
        this.setLocationRelativeTo(null);
    }

    public void cargarTablaEmpleosDisponibles() {
        try {
            String[] titulos = {"Id", "Nombre", "Descripcion", "Precio Min.", "Precio Max.", "Estado"};
            String[] registros = new String[6];
            modelo = new DefaultTableModel(null, titulos);
            ConexionSQL cc = new ConexionSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "select * from empleos_disponibles where EST_EMP='DISPONIBLE'";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("ID_EMP");
                registros[1] = rs.getString("NOM_EMP");
                registros[2] = rs.getString("DES_EMP");
                registros[3] = rs.getString("PRE_MIN_EMP");
                registros[4] = rs.getString("PRE_MAX_EMP");
                registros[5] = rs.getString("EST_EMP");
                modelo.addRow(registros);
            }
            jtblEmpleos.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void cargarTablaEmpleosCliente() {
        Login g = new Login();
        ced_usu_login = g.ced_login;
        try {
            String[] titulos = {"Id", "Nombre", "Descripcion", "Precio Min.", "Precio Max.", "Estado"};
            String[] registros = new String[6];
            modelo = new DefaultTableModel(null, titulos);
            ConexionSQL cc = new ConexionSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "select * from empleos_disponibles where CED_CLI_EMP='" + ced_usu_login + "'";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("ID_EMP");
                registros[1] = rs.getString("NOM_EMP");
                registros[2] = rs.getString("DES_EMP");
                registros[3] = rs.getString("PRE_MIN_EMP");
                registros[4] = rs.getString("PRE_MAX_EMP");
                registros[5] = rs.getString("EST_EMP");
                modelo.addRow(registros);
            }
            jtblMisEmpleos.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void editar() {
        try {
            // TODO add your handling code here:
            ConexionSQL cc = new ConexionSQL();//conexion
            Connection cn = cc.conectar();
            String sql = "";
            sql = "update empleos_disponibles set EST_EMP='NO DISPONIBLE',CED_CLI_EMP='" + ced_usu_login + "' where ID_EMP='" + id_empleo + "'";//sentencia sql
            PreparedStatement psd = cn.prepareStatement(sql);//preparar sentencia
            //System.out.println(psd.executeUpdate());
            int n = psd.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(this, "HA ACEPTADO ESTE EMPLEO");
                cargarTablaEmpleosDisponibles();
                cargarTablaEmpleosCliente();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void obtenerIdEmpleo() {
        jtblEmpleos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtblEmpleos.getSelectedRow() != -1) {
                    fila = jtblEmpleos.getSelectedRow();
                    id_empleo = jtblEmpleos.getValueAt(fila, 0).toString();
                    jbtnAceptarEmpleo.setEnabled(true);
                    jbtnCancelarEmpleo.setEnabled(false);
                }
            }
        });
    }

    public void obtenerIdEmpleoACancelar() {
        jtblMisEmpleos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtblMisEmpleos.getSelectedRow() != -1) {
                    fila = jtblMisEmpleos.getSelectedRow();
                    id_empleoCancelado = jtblMisEmpleos.getValueAt(fila, 0).toString();
                    jbtnAceptarEmpleo.setEnabled(false);
                    jbtnCancelarEmpleo.setEnabled(true);
                }
            }
        });
    }

    public void cancelarEmpleo() {
        try {
            // TODO add your handling code here:
            ConexionSQL cc = new ConexionSQL();//conexion
            Connection cn = cc.conectar();
            String sql = "";
            sql = "update empleos_disponibles set EST_EMP='DISPONIBLE', CED_CLI_EMP='NULL' where ID_EMP='" + id_empleoCancelado + "'";//sentencia sql
            PreparedStatement psd = cn.prepareStatement(sql);//preparar sentencia
            //System.out.println(psd.executeUpdate());
            int n = psd.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(this, "HA CANCELADO ESTE EMPLEO");
                cargarTablaEmpleosDisponibles();
                cargarTablaEmpleosCliente();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void bloquearBotones() {
        jbtnAceptarEmpleo.setEnabled(false);
        jbtnCancelarEmpleo.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtnAceptarEmpleo = new javax.swing.JButton();
        jbtnCancelarEmpleo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblEmpleos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblMisEmpleos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscar");

        jbtnAceptarEmpleo.setText("ACEPTAR EMPLEO");
        jbtnAceptarEmpleo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAceptarEmpleoActionPerformed(evt);
            }
        });

        jbtnCancelarEmpleo.setText("CANCELAR EMPLEO");
        jbtnCancelarEmpleo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarEmpleoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(147, 147, 147)
                .addComponent(jbtnAceptarEmpleo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnCancelarEmpleo)
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbtnCancelarEmpleo)
                    .addComponent(jbtnAceptarEmpleo))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jtblEmpleos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtblEmpleos);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Empleos disponibles");
        jLabel2.setMaximumSize(new java.awt.Dimension(140, 28));
        jLabel2.setMinimumSize(new java.awt.Dimension(140, 28));
        jLabel2.setPreferredSize(new java.awt.Dimension(140, 28));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mis Empleos");

        jtblMisEmpleos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtblMisEmpleos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAceptarEmpleoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAceptarEmpleoActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_jbtnAceptarEmpleoActionPerformed

    private void jbtnCancelarEmpleoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarEmpleoActionPerformed
        // TODO add your handling code here:
        cancelarEmpleo();
    }//GEN-LAST:event_jbtnCancelarEmpleoActionPerformed

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
            java.util.logging.Logger.getLogger(Empleos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnAceptarEmpleo;
    private javax.swing.JButton jbtnCancelarEmpleo;
    private javax.swing.JTable jtblEmpleos;
    private javax.swing.JTable jtblMisEmpleos;
    // End of variables declaration//GEN-END:variables
}
