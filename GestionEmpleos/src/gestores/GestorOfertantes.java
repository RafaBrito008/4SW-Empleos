/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sql.ConexionSQL;

/**
 *
 * @author sebas
 */
public class GestorOfertantes {

    private static DefaultTableModel modeloTabla;
    private static ConexionSQL csql = new ConexionSQL();

    public static DefaultTableModel mostrarOfertantes() {
        try {

            String[] titulos = {"IDENTIFICACION", "NOMBRE",
                "APELLIDO"};
            modeloTabla = new DefaultTableModel(null, titulos);

            String[] registros = new String[3];
            Connection connection = csql.conectar();

            if (connection != null) {
                String sql = "SELECT * FROM OFERTANTES WHERE ID_OFE_PER";
                Statement psd = connection.prepareStatement(sql);
                ResultSet rs = psd.executeQuery(sql);

                while (rs.next()) {
                    registros[0] = rs.getString("ID_OFE");
                    registros[1] = rs.getString("NOM_OFE");
                    registros[2] = rs.getString("APE_OFE");
                    modeloTabla.addRow(registros);
                }
                return modeloTabla;
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
            return null;
        }
    }

    public boolean insertarOfertantes() {
        /*
        Método para insertar ofertantes y cargarlos en la Base de Datos
         */
        return false;
    }

    public boolean elimianrOfertantes() {
        /*
        Método para la eliminacion de un ofertante desde la Base de Datos
         */
        return false;
    }

    public boolean modificarOfertante() {
        /*
        Método para mod
         */
        return false;
    }

    public boolean seleccionarOfertante() {
        /*
        Método en desición, ya que con acciones se puede seleccionar a un ofertantes
         */
        return false;
    }

}
