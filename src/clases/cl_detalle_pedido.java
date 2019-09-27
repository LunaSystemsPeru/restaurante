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
public class cl_detalle_pedido {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int id_pedido;
    private int id_plato;
    private int cantidad;
    private double precio;

    private Statement st;
    private ResultSet rs;

    public cl_detalle_pedido() {
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean insertar() {
        boolean grabar = false;
        st = c_conectar.conexion();
        String quely = "insert INTO detalle_pedido "
                + "VALUES ('" + id_pedido + "','" + id_plato + "','" + cantidad + "','" + precio + "')";
        int respuesta = c_conectar.actualiza(st, quely);
        if (respuesta > -1) {
            grabar = true;
        }
        return grabar;
    }

    public boolean eliminar() {
        boolean elimina = false;
        st = c_conectar.conexion();
        String query = "delete from detalle_pedido "
                + "WHERE idpedido='" + id_pedido + "'";
        int respuesta = c_conectar.actualiza(st, query);
        if (respuesta > -1) {
            elimina = true;
        }
        return elimina;
    }

    public double mostrar(JTable tabla) {
        double total = 0;
        try {
            DefaultTableModel mostrar = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            st = c_conectar.conexion();
            String query = "select dp.idplatos, dp.cantidad, dp.precio, p.descripcion from detalle_pedido as dp "
                    + "inner join platos as p on p.idplatos = dp.idplatos "
                    + "where dp.idpedido = '" + id_pedido + "' "
                    + "order by p.descripcion asc ";
            rs = c_conectar.consulta(st, query);

            //RowSorter<TableModel> sorter = new TableRowSorter<>(mostrar);
//            tabla.setRowSorter(sorter);
            mostrar.addColumn("Item");
            mostrar.addColumn("Descripcion");
            mostrar.addColumn("Cantidad");
            mostrar.addColumn("P. Unit.");
            mostrar.addColumn("Total");

            while (rs.next()) {
                double dcantidad = rs.getDouble("cantidad");
                double dprecio = rs.getDouble("precio");
                double dtotal = dcantidad * dprecio;
                total += dtotal;

                Object fila[] = new Object[5];

                fila[0] = rs.getInt("idplatos");
                fila[1] = rs.getString("descripcion");
                fila[2] = dcantidad;
                fila[3] = c_varios.formato_totales(dprecio);
                fila[4] = c_varios.formato_totales(dtotal);
                mostrar.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(mostrar);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(80);
            c_varios.centrar_celda(tabla, 0);
            c_varios.derecha_celda(tabla, 2);
            c_varios.derecha_celda(tabla, 3);
            c_varios.derecha_celda(tabla, 4);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        return total;
    }
}

