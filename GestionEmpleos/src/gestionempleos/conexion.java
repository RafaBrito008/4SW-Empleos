/*
<<<<<<< HEAD
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionempleos;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa Brito
 */
public class conexion {

    Connection connect = null;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/gestionempleos", "root", "");
            //JOptionPane.showMessageDialog(null, "Felicitaciones, estás conectado...");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error..." + ex);
        }
        return connect;
    }
=======
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionempleos;

/**
 *
 * @author denni
 */
public class conexion {
    
>>>>>>> 2636bf9f4058aafceba353e0df83a15f1d1f761b
}
