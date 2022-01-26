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
/*
    public boolean insertarOfertantes() {
        try {
            Connection conexion = csql.conectar();
            if (conexion != null) {
                if (jtxtCedula.getText().equals("")
                        || jtxtNombre.getText().equals("")
                        || jtxtApellido.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Datos Incompletos");
                    jtxtCedula.requestFocus();
                    return false;
                } else {
                    String sql = "INSERT INTO OFERTANTES(CED_OFE, NOM_OFE, APLE_OFE) VALUES(?, ?, ?)";

                    PreparedStatement psd = conexion.prepareStatement(sql);
                    psd.setString(1, jtxtCedula.getText());
                    psd.setString(2, jtxtNombre.getText().toUpperCase());
                    psd.setString(3, jtxtApellido.getText().toUpperCase());

                    int n = psd.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "¡Inserción Exitosa!");
                    }
                    //limpiar();
                    mostrarOfertantes();
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }

    public boolean elimianrOfertantes() {
        if (!jtxtCedula.getText().equals("")) {
            if (JOptionPane.showConfirmDialog(new JInternalFrame(),
                    "¿Estas Seguro de Borrar el Registro?",
                    "Borrar Registros", JOptionPane.WARNING_MESSAGE,
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    Connection connection = csql.conectar();

                    String sql = "DELETE FROM OFERTANTES WHERE CED_OFE = " + jtxtCedula.getText();
                    PreparedStatement psd = connection.prepareStatement(sql);
                    int n = psd.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "¡Eliminacion Exitosa!");
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
            JOptionPane.showMessageDialog(null, "Ingrese la cedula a Eliminar");
            return false;
        }
    }

    public boolean modificarOfertante() {
        if (!jtxtCedula.getText().equals("")) {
            try {
                Connection connection = csql.conectar();

                if (jtxtNombre.getText().equals("")
                        || jtxtApellido.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Datos Incompletos");
                    jtxtNombre.requestFocus();
                    return false;
                } else {
                    String sql = "UPDATE EMPLEOS_DISPONIBLES SET NOM_OFE = " + jtxtNombre.getText().toUpperCase() + "',"
                            + "APE_OFE = " + jtxtApellido.getText().toUpperCase() + " WHERE CED_EMP = " + jtxtCedula.getText();
                    PreparedStatement psd = connection.prepareStatement(sql);
                    int n = psd.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "¡Actualización Exitosa!");
                    }
                    mostrarOfertantes();
                    limpiar();
                    return true;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Fallido " + ex);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese la Cédula a Modificar");
            return false;
        }
    }
*/
}
