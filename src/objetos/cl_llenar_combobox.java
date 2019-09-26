/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import clases.cl_conectar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class cl_llenar_combobox {
    cl_conectar c_conectar = new cl_conectar();

    private void llenar_combobox(JComboBox combobox, String query) {
        combobox.removeAllItems();
        try {
            Statement st = c_conectar.conexion();
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                combobox.addItem(new o_combobox(rs.getInt("id"), rs.getString("descripcion")));
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void verTodosDocumentosSunat (JComboBox combobox) {
        String query = "select idcomprobante as id, nombre as descripcion "
                + "from documento_sunat "
                + "order by nombre asc ";
        llenar_combobox(combobox, query);
    }
    
    public void verClasificacionPlatos (JComboBox combobox) { 
        String query = "select idclas_platos as id, tipo as descripcion "
                + "from clas_platos "
                + "order by tipo asc";
        llenar_combobox(combobox, query);
    }
}
