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
public class cl_ingreso {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int id_ingreso;
    private int periodo;
    private String fecha;
    private int id_documento;
    private String serie;
    private int numero;
    private int id_proveedor;
    private double total;
    private int id_usuario;

    public cl_ingreso() {
    }

    public int getId_ingreso() {
        return id_ingreso;
    }

    public void setId_ingreso(int id_ingreso) {
        this.id_ingreso = id_ingreso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
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

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean comprobar_documento() {
        boolean existe = false;

        try {
            Statement st = c_conectar.conexion();
            String query = "select periodo, id_ingreso "
                    + "from ingresos "
                    + "where id_proveedor = '" + id_proveedor + "' and id_documento = '" + id_documento + "' and serie = '" + serie + "' and numero = '" + numero + "'";
            ResultSet rs = c_conectar.consulta(st, query);
            while (rs.next()) {
                existe = true;
                id_ingreso = rs.getInt("id_ingreso");
                periodo = rs.getInt("periodo");
            }

            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return existe;
    }

    public int obtener_codigo() {
        int resultado = 0;

        try {
            Statement st = c_conectar.conexion();
            String query = "select ifnull(max(id_ingreso) + 1, 1) as codigo "
                    + "from ingresos "
                    + "where periodo = '" + periodo + "' ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                resultado = rs.getInt("codigo");
            }

            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return resultado;
    }

    public void ver_ingresos(JTable tabla, String query) {
        try {
            DefaultTableModel mostrar = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            Statement st = c_conectar.conexion();
            ResultSet rs = c_conectar.consulta(st, query);

            RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(mostrar);
            tabla.setRowSorter(sorter);

            mostrar.addColumn("Codigo");
            mostrar.addColumn("Fecha");
            mostrar.addColumn("Documento");
            mostrar.addColumn("Proveedor");
            mostrar.addColumn("Moneda");
            mostrar.addColumn("Total");

            while (rs.next()) {
                Object fila[] = new Object[6];

                fila[0] = rs.getString("periodo") + c_varios.ceros_izquieda_numero(3, rs.getInt("id_ingreso"));
                fila[1] = c_varios.formato_fecha_vista(rs.getString("fecha"));
                fila[2] = rs.getString("abreviatura") + " / " + c_varios.ceros_izquieda_letras(4, rs.getString("serie")) + " - " + c_varios.ceros_izquieda_numero(7, rs.getInt("numero"));
                fila[3] = rs.getString("num_documento") + " | " + rs.getString("razon_social");
                fila[4] = "S/";
                fila[5] = c_varios.formato_totales(rs.getDouble("total"));
                mostrar.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(mostrar);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(380);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(40);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(60);
//            tabla.setDefaultRenderer(Object.class, new render_tables.render_ingresos());
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public boolean insertar() {
        boolean grabado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into ingresos "
                + "Values ('" + id_ingreso + "', '" + periodo + "', '" + fecha + "', '" + id_documento + "', '" + serie + "', "
                + "'" + numero + "', '" + id_proveedor + "', '" + total + "', '" + id_usuario + "')";
        int resultado = c_conectar.actualiza(st, query);

        if (resultado > -1) {
            grabado = true;
        }

        c_conectar.cerrar(st);

        return grabado;
    }

}
