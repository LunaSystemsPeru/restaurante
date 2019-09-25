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
public class cl_caja {

    cl_conectar c_conectar = new cl_conectar();

    private String fecha;
    private double ing_venta;
    private double cobro_venta;
    private double o_ingresos;
    private double devolucion;
    private double gastos;
    private double sistema;
    private double apertura;
    private double cierre;

    private Statement st;
    private ResultSet rs;

    public cl_caja() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getIng_venta() {
        return ing_venta;
    }

    public void setIng_venta(double ing_venta) {
        this.ing_venta = ing_venta;
    }

    public double getCobro_venta() {
        return cobro_venta;
    }

    public void setCobro_venta(double cobro_venta) {
        this.cobro_venta = cobro_venta;
    }

    public double getO_ingresos() {
        return o_ingresos;
    }

    public void setO_ingresos(double o_ingresos) {
        this.o_ingresos = o_ingresos;
    }

    public double getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(double devolucion) {
        this.devolucion = devolucion;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public double getSistema() {
        return sistema;
    }

    public void setSistema(double sistema) {
        this.sistema = sistema;
    }

    public double getApertura() {
        return apertura;
    }

    public void setApertura(double apertura) {
        this.apertura = apertura;
    }

    public double getCierre() {
        return cierre;
    }

    public void setCierre(double cierre) {
        this.cierre = cierre;
    }

    public boolean obtenerDatos() {
        boolean existe = false;
        try {
            st = c_conectar.conexion();
            String query = "select * from cajas"
                    + "where fecha = :fecha";
            rs = c_conectar.consulta(st, query);
            if (rs.next()) {
                existe = true;
                ing_venta = rs.getDouble("ing_venta");
                cobro_venta = rs.getDouble("cobro_venta");
                o_ingresos = rs.getDouble("o_ingresos");
                devolucion = rs.getDouble("devolucion_ventas");
                gastos = rs.getDouble("gastos_varios");
                sistema = rs.getDouble("m_sistemas");
                apertura = rs.getDouble("m_apertura");
                cierre = rs.getDouble("m_cierre");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());

        }
        return existe;
    }

    public boolean insertar() {
        boolean grabar = false;
        st = c_conectar.conexion();
        String sql = "INSERT INTO cajas "
                + "VALUES ('" + fecha + "','0', '0', '0', '0','0', '" + apertura + "', '" + apertura + "', '0')";
        int respuesta = c_conectar.actualiza(st, sql);
        if (respuesta > -1) {
            grabar = true;
        }
        return grabar;
    }
    
    public void ver(JTable tabla, String query) {
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

            mostrar.addColumn("Fecha");
            mostrar.addColumn("Apertura");
            mostrar.addColumn("Ventas");
            mostrar.addColumn("Otros Movimientos");
            mostrar.addColumn("Total Sistema");
            mostrar.addColumn("Cierre de Caja");
            mostrar.addColumn("Diferencia");

            while (rs.next()) {
                Object fila[] = new Object[4];

                fila[0] = rs.getInt("idclas_platos");
                fila[1] = rs.getString("tipo").trim();
                mostrar.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(mostrar);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
