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
public class cl_empleado {
    cl_conectar c_conectar=new cl_conectar();
    private Statement stmt;
    private ResultSet rs;
    private int id_empleados;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contraseña;
    private String nur_documento;
    private String estado;
    private String cargo;

   
    public int getId_empleados() {
        return id_empleados;
    }

    /**
     * @param id_empleados the id_empleados to set
     */
    public void setId_empleados(int id_empleados) {
        this.id_empleados = id_empleados;
        
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
       public String getNur_documento() {
        return nur_documento;
    }

    /**
     * @param nur_documento the nur_documento to set
     */
    public void setNur_documento(String nur_documento) {
        this.nur_documento = nur_documento;
    }
    
    public boolean insertar(){
      boolean grabar=false;
        try {
             stmt=c_conectar.conexion();
            String query="INSERT INTO empleados VALUES('"+id_empleados+"','"+usuario+"','"+contraseña+"','"+nombres+"','"+apellidos+"','"+nur_documento+"','"+estado+"','"+cargo+"')";
            int respuesta=c_conectar.actualiza(stmt, query);
            if(respuesta>-1){
                grabar=true;
            }
        } catch (Exception e) {
        }
        return true;
    }
   public boolean modificar(){
       boolean modifica=false;
       try {
            stmt=c_conectar.conexion();
           String query="UPDATE empleados SET usuario='"+usuario+"',password='"+contraseña+"',nombres='"+nombres+"',apellidos='"+apellidos+"',nro_documento='"+nur_documento+"',estado='"+estado+"',cargo='"+cargo+"' WHERE idempleados='"+id_empleados+"'";
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
           String query="DELETE FROM empleados WHERE idempleados='"+id_empleados+"'";
           int respuesta=c_conectar.actualiza(stmt,query);
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
            String query="select ifnull(max(idempleados)+1, 1) as idempleados from  empleados";
            rs=c_conectar.consulta(stmt, query);
            while(rs.next()){
                id_empleados=rs.getInt("idempleados");
            }
        } catch (Exception e) {
        }
        c_conectar.cerrar(stmt);
        c_conectar.cerrar(rs);
        return id_empleados; 
   }
    public boolean obtener_datos(){
       boolean si=false;
       try {
           stmt=c_conectar.conexion();
           String query="SELECT * from empleados where idempleados='"+id_empleados+"'";
           rs=c_conectar.consulta(stmt, query);
           while(rs.next()){
               usuario=rs.getString("usuario");
               contraseña=rs.getString("password");
               nombres=rs.getString("nombres");
               apellidos=rs.getString("apellidos");
               nur_documento=rs.getString("nro_documento");
               estado=rs.getString("estado");
               cargo=rs.getString("cargo");
               si=true;
           }
       } catch (Exception e) {
       }
       c_conectar.cerrar(stmt);
       c_conectar.cerrar(rs);
       return si;
   }
      public void ver_empleados(JTable tabla, String query) {
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
            mostrar.addColumn("Usuario");
            mostrar.addColumn("datos del empleado");
            mostrar.addColumn("cargo");
            mostrar.addColumn("estado");

            while (rs.next()) {
                Object fila[] = new Object[5];

                fila[0] = rs.getInt("idempleados");
                fila[1] = rs.getString("usuario");
                fila[2] = rs.getString("nombres") + " " + rs.getString("apellidos").trim();
                fila[3] = rs.getString("cargo").trim();
                fila[4] = rs.getString("estado").trim();

                mostrar.addRow(fila);
            }

            c_conectar.cerrar(stmt);
            c_conectar.cerrar(rs);
            tabla.setModel(mostrar);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(180);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(50);

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
