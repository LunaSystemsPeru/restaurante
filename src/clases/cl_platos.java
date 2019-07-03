/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class cl_platos {

    cl_conectar c_conectar = new cl_conectar();
    Connection con;
    Statement st;
    ResultSet rs;
    private int idplatos;
    private String descripcion;
    private String precio;
    private String cantidad;
    private int idclas_platos;

    /**
     * @return the id_plato
     */
    public int getIdplatos() {
        return idplatos;
    }

    /**
     * @param idplatos the idplatos to set
     */
    public void setIdplatos(int idplatos) {
        this.idplatos = idplatos;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the idclas_platos
     */
    public int getIdclas_platos() {
        return idclas_platos;
    }

    /**
     * @param idclas_platos the id_clases_platos to set
     */
    public void setId_clases_platos(int idclas_platos) {
        this.idclas_platos = idclas_platos;
    }

    public void ver_platos(JTable tabla, String query) {
        try {
            DefaultTableModel mostrar = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            Statement st = c_conectar.conexion();
            ResultSet rs = c_conectar.consulta(st, query);

            RowSorter<TableModel> sorter = new TableRowSorter<>(mostrar);
            tabla.setRowSorter(sorter);

            mostrar.addColumn("Codigo");
            mostrar.addColumn("nombre");
            mostrar.addColumn("precio");
            mostrar.addColumn("cantidad");

            while (rs.next()) {
                Object fila[] = new Object[4];

                fila[0] = rs.getInt("idplatos");
                fila[1] = rs.getString("descripcion").trim();
                fila[2] = rs.getString("precio").trim();
                fila[3] = rs.getString("cantidad").trim();
                mostrar.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(mostrar);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public boolean obtener_datos() {
        boolean existe = false;
        try {
            st = c_conectar.conexion();
            String query = "select * from platos where idplatos = '" + idplatos + "'";
            rs = c_conectar.consulta(st, query);
            if (rs.next()) {
                idplatos = rs.getInt("idplatos");
                descripcion = rs.getString("descripcion");
                precio = rs.getString("precio");
                cantidad = rs.getString("cantidad");
                idclas_platos = rs.getInt("idclas_platos");
                existe = true;

            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return existe;
    }

    public boolean modificar() {
        boolean modificar = false;
        st = c_conectar.conexion();
        String sql = "Update platos setideclas_platos='" + idclas_platos + "', setdescripcion= '" + descripcion + "', setprecio='" + precio + "'"
                + ", setcantidad = '" + cantidad + "'  wehere idplatos = '" + idplatos + "'";
        int respuesta = c_conectar.actualiza(st, sql);
        if (respuesta > -1) {
            modificar = true;
        }
        return modificar;
    }

    public boolean insertar() {
        boolean grabar = false;
        st = c_conectar.conexion();
        String squly = "insert into platos values('" + idplatos + "','" + idclas_platos + "','" + descripcion + "','" + precio + "','" + cantidad + "')";
        int respuesta = c_conectar.actualiza(st, squly);
        if (respuesta > -1) {
            grabar = true;
        }
        return grabar;
    }

    public int obtener_codigo() {
        int codigo = 0;
        try {
            st = c_conectar.conexion();
            String sql = "x";
            rs = c_conectar.consulta(st, sql);
            if (rs.next()) {
                idplatos = rs.getInt("idplatos");
                codigo = idplatos;
            }
        } catch (SQLException e) {
        }
        c_conectar.cerrar(st);
        c_conectar.cerrar(rs);
        return codigo;
    }
}
