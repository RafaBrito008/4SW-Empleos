/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class ConexionSQL {

    Connection conectar;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Obtiene la direccion de la base de datos
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/Empleos", "root", "");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }
        return conectar;
    }

}
