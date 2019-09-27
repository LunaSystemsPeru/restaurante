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
 * @author s1nn0mbr3
 */
public class cl_venta {

    cl_conectar c_conectar = new cl_conectar();

    private int id_venta;
    private String fecha;
    private int id_comprobante;
    private String serie;
    private int numero;
    private int id_mesa;
    private int id_cliente;
    private int id_empleado;
    private int estado;
    private double total;
    private int id_pedido;

    Statement st;
    ResultSet rs;

    public cl_venta() {
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public boolean obtener_datos() {
        boolean existe = false;

        try {
            st = c_conectar.conexion();
            String query = "select * from venta where idventa = '" + id_venta + "'";
            rs = c_conectar.consulta(st, query);
            if (rs.next()) {
                id_comprobante = rs.getInt("idcomprobante");
                serie = rs.getString("serie");
                fecha = rs.getString("fecha");
                numero = rs.getInt("numero");
                id_mesa = rs.getInt("id_mesa");
                id_cliente = rs.getInt("idcliente");
                id_empleado = rs.getInt("idempleados");
                estado = rs.getInt("estado");
                total = rs.getDouble("total");
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
        String sql = "UPDATE venta "
                + "set estado = '2', total = 0 "
                + " where idventa= '" + id_venta + "'";
        int respuesta = c_conectar.actualiza(st, sql);
        if (respuesta > -1) {
            modificar = true;
        }
        return modificar;
    }

    public boolean insertar() {
        boolean grabar = false;
        st = c_conectar.conexion();
        String squly = "insert into venta values('" + id_venta + "',"
                + "'" + fecha + "',"
                + "'" + id_comprobante + "',"
                + "'" + serie + "',"
                + "'" + numero + "',"
                + "'" + id_mesa + "',"
                + "'" + id_cliente + "',"
                + "'" + id_empleado + "',"
                + "'2',"
                + "'" + total + "',"
                + "'" + id_pedido + "')";
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
            String sql = "select ifnull(max(idventa)+1, 1) "
                    + "as codigo "
                    + "from venta";
            rs = c_conectar.consulta(st, sql);
            if (rs.next()) {
                id_venta = rs.getInt("codigo");
                codigo = id_venta;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        c_conectar.cerrar(st);
        return codigo;
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

            mostrar.addColumn("Codigo");
            mostrar.addColumn("Fecha");
            mostrar.addColumn("Documento");
            mostrar.addColumn("Cliente");
            mostrar.addColumn("Usuario");
            mostrar.addColumn("Total");
            mostrar.addColumn("Estado");

            while (rs.next()) {
                Object fila[] = new Object[7];

                fila[0] = rs.getInt("idventa");
                fila[1] = rs.getString("fecha");
                fila[2] = rs.getString("abreviatura") + " | " + rs.getString("serie") + " - " + rs.getString("numero");
                fila[3] = rs.getString("nombre");
                fila[4] = rs.getString("usuario");
                fila[5] = rs.getDouble("total");
                fila[6] = "-";

                int iestado = rs.getInt("estado");
                if (iestado == 2) {
                    fila[6] = "POR COBRAR";
                }
                if (iestado == 3) {
                    fila[6] = "ANULADO";
                }

                mostrar.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(mostrar);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
