/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class cl_productos {

    cl_conectar c_conectar = new cl_conectar();

    private Statement st;
    private ResultSet rs;

    private int id_producto;
    private String descripcion;
    private double can_actual;
    private int estado;
    private double costo;

    public cl_productos() {
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCan_actual() {
        return can_actual;
    }

    public void setCan_actual(double can_actual) {
        this.can_actual = can_actual;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean insertar() {
        boolean grabar = false;
        try {
            st = c_conectar.conexion();
            String query = "INSERT insumo VALUES ('" + id_producto + "','" + descripcion + "','" + can_actual + "','" + estado + "')";
            int respuesta = c_conectar.actualiza(st, query);
            if (respuesta > -1) {
                grabar = true;
            }
        } catch (Exception e) {
        }
        return grabar;
    }

    public boolean modificar() {
        boolean modifica = false;
        try {
            st = c_conectar.conexion();
            String query = "UPDATE insumo SET descripcion='" + descripcion + "',cant_actual='" + can_actual + "',estado='" + estado + "' WHERE idinsumo='" + id_producto + "'";
            int respuesta = c_conectar.actualiza(st, query);
            if (respuesta > -1) {
                modifica = true;
            }
        } catch (Exception e) {
        }
        return modifica;
    }

    public boolean eliminar() {
        boolean elimina = false;
        try {
            st = c_conectar.conexion();
            String query = "DELETE FROM insumo WHERE idinsumo='" + id_producto + "'";
            int respuesta = c_conectar.actualiza(st, query);
            if (respuesta > -1) {
                elimina = true;
            }
        } catch (Exception e) {
        }
        return elimina;
    }

    public int obtener_codigo() {
        try {
            st = c_conectar.conexion();
            String query = "select ifnull(max(idinsumo)+1, 1) as idinsumo from insumo";
            rs = c_conectar.consulta(st, query);
            while (rs.next()) {
                id_producto = rs.getInt("idinsumo");
            }
        } catch (Exception e) {
        }
        c_conectar.cerrar(st);
        c_conectar.cerrar(rs);
        return id_producto;
    }

    public boolean obtener_datos() {
        boolean si = false;
        try {
            st = c_conectar.conexion();
            String query = "select * from insumo WHERE idinsumo='" + id_producto + "'";
            rs = c_conectar.consulta(st, query);
            while (rs.next()) {
                id_producto = rs.getInt("idinsumo");
                descripcion = rs.getString("descripcion");
                can_actual = rs.getInt("cant_actual");
                estado = rs.getInt("estado");
                si = true;
            }
        } catch (Exception e) {
        }
        c_conectar.cerrar(st);
        c_conectar.cerrar(rs);
        return si;
    }

    public void ver_productos(JTable tabla, String query) {
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

            mostrar.addColumn("Codigo");
            mostrar.addColumn("descripcion");
            mostrar.addColumn("cantidad");
            mostrar.addColumn("estado");

            while (rs.next()) {
                Object fila[] = new Object[4];

                fila[0] = rs.getInt("idinsumo");
                fila[1] = rs.getString("descripcion");
                fila[2] = rs.getInt("cant_actual");
                fila[3] = rs.getString("estado").trim();

                mostrar.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(mostrar);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(180);

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
