/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.sql.*;
import clases.cl_conectar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
public class cl_productos {
cl_conectar c_conectar=new cl_conectar();
private Connection con;
private Statement stmt;
private ResultSet rs;
private int id_producto;
private String descripcion;
private int can_actual;
private int estado;

  
    public int getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the can_actual
     */
    public int getCan_actual() {
        return can_actual;
    }

    /**
     * @param can_actual the can_actual to set
     */
    public void setCan_actual(int can_actual) {
        this.can_actual = can_actual;
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
    public boolean insertar(){
        boolean grabar=false;
        try {
            stmt=c_conectar.conexion();
            String query="INSERT insumo VALUES ('"+id_producto+"','"+descripcion+"','"+can_actual+"','"+estado+"')";
            int respuesta=c_conectar.actualiza(stmt, query);
            if(respuesta>-1){
                grabar=true;
            }
        } catch (Exception e) {
        }
        return grabar;
    }
    public boolean modificar(){
        boolean modifica=false;
        try {
            stmt=c_conectar.conexion();
            String query="UPDATE insumo SET descripcion='"+descripcion+"',cant_actual='"+can_actual+"',estado='"+estado+"' WHERE idinsumo='"+id_producto+"'";
            int respuesta=c_conectar.actualiza(stmt, query);
            if(respuesta>-1){
                modifica=true;
            }
        } catch (Exception e) {
        }
        return modifica;
    }
    public boolean eliminar(){
        boolean elimina=false;
        try {
            stmt=c_conectar.conexion();
            String query="DELETE FROM insumo WHERE idinsumo='"+id_producto+"'";
            int respuesta=c_conectar.actualiza(stmt, query);
            if(respuesta>-1){
                elimina=true;
            }
        } catch (Exception e) {
        }
        return elimina;
    }
    public int obtener_codigo(){
        try {
             stmt=c_conectar.conexion();
            String query="select ifnull(max(idinsumo)+1, 1) as idinsumo from insumo";
            rs=c_conectar.consulta(stmt, query);
            while(rs.next()){
                id_producto=rs.getInt("idinsumo");
            }
        } catch (Exception e) {
        }
        c_conectar.cerrar(stmt);
        c_conectar.cerrar(rs);
        return id_producto; 
   }
   public boolean obtener_datos(){
       boolean si=false;
       try {
           stmt=c_conectar.conexion();
           String query="select * from insumo WHERE idinsumo='"+id_producto+"'";
           rs=c_conectar.consulta(stmt, query);
           while(rs.next()){
               id_producto=rs.getInt("idinsumo");
               descripcion=rs.getString("descripcion");
               can_actual=rs.getInt("cant_actual");
               estado=rs.getInt("estado");
               si=true;
           }
       } catch (Exception e) {
       }
       c_conectar.cerrar(stmt);
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
            stmt = c_conectar.conexion();
            rs = c_conectar.consulta(stmt, query);

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
                fila[2]=rs.getInt("cant_actual");
                fila[3] = rs.getString("estado").trim();

                mostrar.addRow(fila);
            }

            c_conectar.cerrar(stmt);
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
