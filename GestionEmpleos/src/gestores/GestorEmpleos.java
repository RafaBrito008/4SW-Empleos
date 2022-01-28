/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestores;

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
 * @author sebas
 */
public class GestorEmpleos {

    private static ConexionSQL csql = new ConexionSQL();
    private static DefaultTableModel modeloTabla;

    public static DefaultTableModel mostrarEmpleos(String cedula) {
        JOptionPane.showMessageDialog(null, cedula);

        try {
            String[] titulos = {"IDENTIFICACION", "NOMBRE",
                "DESCRIPCION", "MINIMO A PAGAR", "MAXIMO A PAGAR", "ESTADO"};
            modeloTabla = new DefaultTableModel(null, titulos);

            String[] registros = new String[7];
            Connection connection = csql.conectar();
            
            JOptionPane.showMessageDialog(null, cedula);

            if (connection != null) {
                String sql = "SELECT * FROM EMPLEOS_DISPONIBLES WHERE ID_OFE_EMP = '" + cedula + "'";
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
/*
    public static boolean insertarEmpleo() {
        try {
            Connection conexion = csql.conectar();
            if (conexion != null) {
                if (jtxtNombre.getText().equals("")
                        || jtxtDescripcion.getText().equals("")
                        || jtxtPrecioMinimo.getText().equals("")
                        || jtxtPrecioMaximo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Datos Incompletos");
                    jtxtNombre.requestFocus();
                    return false;
                } else {
                    String sql = "INSERT INTO EMPLEOS_DISPONIBLES(NOM_EMP, DES_EMP, PRE_MIN_EMP, PRE_MAX_EMP, EST_EMP, ID_OFE_PER) VALUES(?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement psd = conexion.prepareStatement(sql);
                    psd.setString(1, jtxtNombre.getText());
                    psd.setString(2, jtxtDescripcion.getText().toUpperCase());
                    psd.setString(3, jtxtPrecioMinimo.getText().toUpperCase());
                    psd.setString(4, jtxtPrecioMaximo.getText().toUpperCase());
                    jtxtEstado.setText("DISPONIBLE");
                    psd.setString(5, jtxtEstado.getText());

                    int n = psd.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "¡Inserción Exitosa!");
                    }
                    //limpiar();
                    mostrarEmpleos("1801");
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }

    }

    public boolean eliminarEmpleo() {
        if (!jtxtIdentificacion.getText().equals("")) {
            if (JOptionPane.showConfirmDialog(new JInternalFrame(),
                    "¿Estas Seguro de Borrar el Registro?",
                    "Borrar Registros", JOptionPane.WARNING_MESSAGE,
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    Connection connection = csql.conectar();

                    String sql = "DELETE FROM EMPLEOS_DISPONIBLES WHERE ID_EMP = " + jtxtIdentificacion.getText();
                    PreparedStatement psd = connection.prepareStatement(sql);
                    int n = psd.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(this, "¡Eliminacion Exitosa!");
                    }
                    limpiar();
                    return true;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Fallido " + ex);
                    return false;
                }
            }
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese la Identificación del Empleo para Eliminar");
            return false;
        }
    }

    public boolean modificarEmpleo() {
        if (!jtxtIdentificacion.getText().equals("")) {
            try {
                Connection connection = csql.conectar();

                if (jtxtNombre.getText().equals("")
                        || jtxtDescripcion.getText().equals("")
                        || jtxtPrecioMinimo.getText().equals("")
                        || jtxtPrecioMaximo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Datos Incompletos");
                    jtxtNombre.requestFocus();
                    return false;
                } else {
                    if (jtxtTelefono.getText().equals("")) {
                        jtxtTelefono.setText("NULL");
                    }
                    String sql = "UPDATE EMPLEOS_DISPONIBLES SET NOM_EMP = " + jtxtNombre.getText().toUpperCase() + "',"
                            + "DES_EMP = " + jtxtDescripcion.getText().toUpperCase() + ","
                            + "PRE_MIN_EMP = " + jtxtPrecioMinimo.getText().toUpperCase() + ","
                            + "PRE_MAX_EMP = " + jtxtPrecioMaximo.getText().toUpperCase() + " WHERE ID_EMP = " + jtxtIdentificacion.getText();
                    PreparedStatement psd = connection.prepareStatement(sql);
                    int n = psd.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "¡Actualización Exitosa!");
                    }
                    mostrarEmpleos("1801");
                    limpiar();
                    return true;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Fallido " + ex);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese la Identificacion a Modificar");
            return false;
        }
    }
*/
}
