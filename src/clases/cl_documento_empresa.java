/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author luis
 */
public class cl_documento_empresa {

    cl_conectar c_conectar = new cl_conectar();

    private int id_comprobante;
    private String serie;
    private int numero;

    private Statement st;
    private ResultSet rs;

    public cl_documento_empresa() {
    }

    public int getId_comprobante() {
        return id_comprobante;
    }

    public void setId_comprobante(int id_comprobante) {
        this.id_comprobante = id_comprobante;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean insertar() {
        boolean grabar = false;
        st = c_conectar.conexion();
        String quely = "insert INTO documentos_empresa "
                + "VALUES ('" + id_comprobante + "','" + serie + "','" + numero + "')";
        int respuesta = c_conectar.actualiza(st, quely);
        if (respuesta > -1) {
            grabar = true;
        }
        return grabar;
    }

    public void obtener_datos() {
        try {
            st = c_conectar.conexion();
            String query = "SELECT * FROM documentos_empresa WHERE idcomprobante ='" + id_comprobante + "'";
            rs = c_conectar.consulta(st, query);
            while (rs.next()) {
                serie = rs.getString("serie");
                numero = rs.getInt("numero");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        c_conectar.cerrar(st);
        c_conectar.cerrar(rs);
    }

    public void mostrar(JTable tabla, String query) {
        try {
            DefaultTableModel mostrar = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            st = c_conectar.conexion();
            rs = c_conectar.consulta(st, query);

            RowSorter<TableModel> sorter = new TableRowSorter<>(mostrar);
            tabla.setRowSorter(sorter);

            mostrar.addColumn("Id.");
            mostrar.addColumn("Nombre");
            mostrar.addColumn("Serie");
            mostrar.addColumn("Numero");

            while (rs.next()) {
                Object fila[] = new Object[4];

                fila[0] = rs.getInt("idcomprobante");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("serie");
                fila[3] = rs.getString("numero");
                mostrar.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(mostrar);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(60);
//            tabla.setDefaultRenderer(Object.class, new render_tables.render_ingresos());
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
