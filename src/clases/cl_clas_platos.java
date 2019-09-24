/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author eliseo
 */
public class cl_clas_platos {

    cl_conectar c_conectar = new cl_conectar();

    private int id;
    private String tipo;
    private Statement st;
    private ResultSet rs;

    public cl_clas_platos() {
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean obtenerDatos() {
        boolean existe = false;
        try {
            st = c_conectar.conexion();
            String query = "select * from clas_platos where idclas_platos = '" + id + "'";
            rs = c_conectar.consulta(st, query);
            if (rs.next()) {
                id = rs.getInt("idclas_platos");
                tipo = rs.getString("tipo");
                existe = true;

            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return existe;
    }

    public boolean insertar() {
        boolean grabar = false;
        st = c_conectar.conexion();
        String sql = "INSERT INTO clas_platos VALUES ('" + id + "','" + tipo + "')";
        int respuesta = c_conectar.actualiza(st, sql);
        if (respuesta > -1) {
            grabar = true;
        }
        return grabar;
    }

    public boolean modificar() {
        boolean modificar = false;
        String sql = "update clas_platos settipo = '" + tipo + "' where idclas_platos = '" + id + "'";
        int respuesta = c_conectar.actualiza(st, sql);
        if (respuesta > -1) {
            modificar = true;
        }
        return modificar;
    }

    public ArrayList obtener_clasificaciones() {
        ArrayList<ArrayList> clas_plato = new ArrayList<>();

        ResultSet rsr;
        String query = "select * "
                + "from clas_platos "
                + "order by tipo asc";
        Statement sts = c_conectar.conexion();
        rsr = c_conectar.consulta(sts, query);
        try {
            while (rsr.next()) {
                int iid = rsr.getInt("idclas_platos");
                String nombre = rsr.getString("tipo");
                ArrayList fila_clase = new ArrayList();
                fila_clase.add(iid);
                fila_clase.add(nombre);
                clas_plato.add(fila_clase);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return clas_plato;
    }

    public int total_clasificaciones() {
        int codigo = 0;
        try {
            st = c_conectar.conexion();
            String sql = "select count(*) as total from clas_platos";
            rs = c_conectar.consulta(st, sql);
            if (rs.next()) {
                codigo = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        //c_conectar.cerrar(st);
        //  c_conectar.cerrar(rs);
        return codigo;
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

            mostrar.addColumn("idclas_platos");
            mostrar.addColumn("tipo");

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

    public int generarCodigo() {
        int codigo = 0;
        try {
            st = c_conectar.conexion();
            String sql = "select ifnull(max(idclas_platos)+1, 1) as idclas_platos from clas_platos";
            rs = c_conectar.consulta(st, sql);
            if (rs.next()) {
                id = rs.getInt("idclas_platos");
                codigo = id;
            }
        } catch (SQLException e) {
        }
        c_conectar.cerrar(st);
        c_conectar.cerrar(rs);
        return codigo;
    }

}
