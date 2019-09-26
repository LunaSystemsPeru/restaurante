package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class cl_pedido {

    cl_conectar c_conectar = new cl_conectar();
    Connection con;
    Statement st;
    ResultSet rs;

    private int id_pedido;
    private int id_mesa;
    private String fecha;
    private float total;
    private String fecha_registro;
    private int id_empleado;
    private int estado;

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getIdmesa() {
        return id_mesa;
    }

    public void setIdmesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
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

//    public void ver_platos(JTable tabla, String query) {
//        try {
//            DefaultTableModel mostrar = new DefaultTableModel() {
//                @Override
//                public boolean isCellEditable(int fila, int columna) {
//                    return false;
//                }
//            };
//            Statement st = c_conectar.conexion();
//            ResultSet rs = c_conectar.consulta(st, query);
//
//            RowSorter<TableModel> sorter = new TableRowSorter<>(mostrar);
//            tabla.setRowSorter(sorter);
//
//            mostrar.addColumn("Codigo");
//            mostrar.addColumn("nombre");
//            mostrar.addColumn("precio");
//            mostrar.addColumn("Clasificacion");
//
//            while (rs.next()) {
//                Object fila[] = new Object[4];
//
//                fila[0] = rs.getInt("idplatos");
//                fila[1] = rs.getString("descripcion").trim();
//                fila[2] = rs.getString("precio").trim();
//                fila[3] = rs.getString("tipo").trim();
//                mostrar.addRow(fila);
//            }
//
//            c_conectar.cerrar(st);
//            //c_conectar.cerrar(rs);
//            tabla.setModel(mostrar);
//            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
//            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
//            tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
//            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//            JOptionPane.showMessageDialog(null, ex);
//        }
//    }
    
    public boolean obtener_datos() {
        boolean existe = false;
        
        try {
            st = c_conectar.conexion();
            String query = "select * from pedido where idpedido = '" + id_pedido + "'";
            rs = c_conectar.consulta(st, query);
            if (rs.next()) {
                id_pedido = rs.getInt("idplatos");
                id_mesa = rs.getInt("id_mesa");
                fecha = rs.getString("fecha");
                total = rs.getFloat("total");
                fecha_registro = rs.getString("fecha_registro");
                id_empleado = rs.getInt("id_empleado");
                estado = rs.getInt("estado");
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
        String sql = "UPDATE pedido SET    id_pedido='" + id_pedido + "',"
                                        + "id_mesa= '" + id_mesa + "',"
                                        + "fecha='" + fecha + "',"
                                        + "total='" + total + "',"
                                        + "fecha_registro='" + fecha_registro + "',"
                                        + "id_empleado='" + id_empleado + "',"
                                        + "estado='" + estado + "'"
                                        + " where id_pedido = '" + id_pedido + "'";
        int respuesta = c_conectar.actualiza(st, sql);
        if (respuesta > -1) {
            modificar = true;
        }
        return modificar;
    }
    
    public boolean insertar() {
        boolean grabar = false;
        st = c_conectar.conexion();
        String squly = "insert into pedido values('" + id_pedido + "',"
                                                    + "'"+id_mesa+"',"
                                                    + "'"+fecha+"',"
                                                    + "'"+total+"',"
                                                    + "CURRENT_TIMESTAMP(),"
                                                    + "'"+id_empleado+"',"
                                                    + "'1')";
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
            String sql = "select ifnull(max(idpedido)+1, 1) as codigo from pedido";
            rs = c_conectar.consulta(st, sql);
            if (rs.next()) {
                id_pedido = rs.getInt("codigo");
                codigo = id_pedido;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        c_conectar.cerrar(st);
        return codigo;
    }
}
