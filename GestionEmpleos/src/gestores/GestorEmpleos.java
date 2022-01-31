/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestores;

import Interfaces.Ofertante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sql.ConexionSQL;

/**
 *
 * @author Rafael Brito, Dennis Bonilla y Sebastián Palate
 */
public class GestorEmpleos {

    private static final ConexionSQL csql = new ConexionSQL();
    private static DefaultTableModel modeloTabla;

    /**
     * Método para mostrar los empleos de un ofertante
     *
     * @param cedula
     * @return
     */
    public static DefaultTableModel mostrarEmpleos(String cedula) {

        try {
            String[] titulos = {"IDENTIFICACION", "NOMBRE",
                "DESCRIPCION", "MINIMO A PAGAR", "MAXIMO A PAGAR", "ESTADO", "OFERTANTE", "CLIENTE"};
            modeloTabla = new DefaultTableModel(null, titulos);

            String[] registros = new String[8];
            Connection connection = csql.conectar();

            if (connection != null) {
                String sql = "SELECT * FROM EMPLEOS_DISPONIBLES WHERE ID_OFE_EMP='" + cedula + "'";
                Statement psd = connection.prepareStatement(sql);
                ResultSet rs = psd.executeQuery(sql);

                while (rs.next()) {
                    registros[0] = rs.getString("ID_EMP");
                    registros[1] = rs.getString("NOM_EMP");
                    registros[2] = rs.getString("DES_EMP");
                    registros[3] = rs.getString("PRE_MIN_EMP");
                    registros[4] = rs.getString("PRE_MAX_EMP");
                    registros[5] = rs.getString("EST_EMP");
                    registros[6] = rs.getString("ID_OFE_EMP");
                    registros[7] = rs.getString("CED_CLI_EMP");

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

    public static boolean eliminarEmpleo() {
        if (JOptionPane.showConfirmDialog(new JInternalFrame(),
                "¿Estas Seguro de Borrar al Empleo " + Ofertante.identificacion + "?",
                "Borrar Registros", JOptionPane.WARNING_MESSAGE,
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                Connection connection = csql.conectar();
                String sql = "DELETE FROM EMPLEOS_DISPONIBLES WHERE ID_EMP = '" + Ofertante.identificacion + "'";

                PreparedStatement psd = connection.prepareStatement(sql);
                int n = psd.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "¡Eliminacion Exitosa!");
                }
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Fallido " + ex);
                return false;
            }
        }
        return false;

    }
}
