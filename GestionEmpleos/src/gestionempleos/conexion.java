/*
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
}
