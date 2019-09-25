package clases;

import java.sql.*;
import clases.cl_conectar;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class cl_mesas {

    cl_conectar c_conectar = new cl_conectar();
    private Statement st;
    private ResultSet rs;
    private int idmesa;
    private int numero;
    private int estado;
    private int numerosillas;

    /**
     * @return the idmesa
     */
    public int getIdmesa() {
        return idmesa;
    }

    /**
     * @param idmesa the idmesa to set
     */
    public void setIdmesa(int idmesa) {
        this.idmesa = idmesa;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param num_mesa the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the num_sillas
     */
    public int getNumerosillas() {
        return numerosillas;
    }

    /**
     * @param numerosillas the numerosillas to set
     */
    public void setNumerosillas(int numerosillas) {
        this.numerosillas = numerosillas;
    }

    public boolean cargar() {
        boolean existe = false;
        try {
            st = c_conectar.conexion();
            String sql = "select * from mesa where idmesa = '" + idmesa + "'";
            rs = c_conectar.consulta(st, sql);
            if (rs.next()) {
                idmesa = rs.getInt("idmesa");
                numero = rs.getInt("numero");
                estado = rs.getInt("estado");
                numerosillas = rs.getInt("numerosillas");
                existe = true;
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);

        } catch (Exception e) {
        }
        return existe;
    }

    public boolean insertar() {
        boolean grabar = false;
        st = c_conectar.conexion();
        String sql = "INSERT INTO mesa VALUES ('" + idmesa + "','" + numero + "','" + estado + "','" + numerosillas + "')";
        System.out.println(sql);
        int respuesta = c_conectar.actualiza(st, sql);
        if (respuesta > - 1) {
            grabar = true;
        }
        return grabar;
    }

    public boolean modificar() {
        boolean modificar = false;
        st = c_conectar.conexion();
        String sql = "Update mesa  setnumero = '" + numero + "', setestado = '" + estado + "', setnumerosillas = '" + numerosillas + "' where idmesa = '" + idmesa + "'";
        int respuesta = c_conectar.actualiza(st, sql);
        if (respuesta > - 1) {
            modificar = true;
        }
        return modificar;
    }

    public int obtener_codigo() {
        int codigo = 0;
        try {
            st = c_conectar.conexion();
            String sql = "select ifnull(max(idmesa)+1, 1) as idmesa from mesa";
            rs = c_conectar.consulta(st, sql);
            if (rs.next()) {
                idmesa = rs.getInt("idmesa");
                codigo = idmesa;
            }
        } catch (Exception e) {
        }
        c_conectar.cerrar(st);
        c_conectar.cerrar(rs);
        return codigo;
    }

    public void ver_mesa(JTable tabla, String query) {
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
            mostrar.addColumn("Numero");
            mostrar.addColumn("estado");
            mostrar.addColumn("numerosillas");

            while (rs.next()) {
                Object fila[] = new Object[4];

                fila[0] = rs.getInt("idmesa");
                fila[1] = rs.getString("numero").trim();
                if (rs.getInt("estado")== 1) {
                    fila[2] = "Activo";
                } else {
                    fila[2] = "Inactivo";
                }
                fila[3] = rs.getString("numerosillas").trim();
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

    public ArrayList obtener_mesass() {
        ArrayList<ArrayList> clas_mesa = new ArrayList<>();

        ResultSet rsr;
        String query = "select * "
                + "from mesa ";
        Statement sts = c_conectar.conexion();
        rsr = c_conectar.consulta(sts, query);
        try {
            while (rsr.next()) {
                int id = rsr.getInt("idmesa");
                int est = rsr.getInt("estado");
                ArrayList fila_mesa = new ArrayList();
                fila_mesa.add(id);
                fila_mesa.add(est);
                clas_mesa.add(fila_mesa);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return clas_mesa;
    }

//    public boolean eliminar (){
//        boolean eliminar = false;
//        try {
//            st = c_conectar.conexion();
//            String sql = "delete from mesa where idmesa = '"+ idmesa +"'";
//            int respuesta = c_conectar.actualiza(st, sql);
//            if (respuesta > -1) {
//                eliminar = true;
//            }
//        } catch (Exception e) {
//        }
//        return eliminar;
//    }
}
