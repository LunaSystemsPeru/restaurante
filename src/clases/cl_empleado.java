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

public class cl_empleado {

    cl_conectar c_conectar = new cl_conectar();

    private Statement st;
    private ResultSet rs;

    private int id_empleados;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String password;
    private String nro_documento;
    private int estado;
    private int cargo;

    public cl_empleado() {
    }

    public int getId_empleados() {
        return id_empleados;
    }

    public void setId_empleados(int id_empleados) {
        this.id_empleados = id_empleados;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public int obtener_codigo() {
        try {
            st = c_conectar.conexion();
            String query = "select ifnull(max(idempleados)+1, 1) "
                    + "as codigo "
                    + "from  empleados";
            rs = c_conectar.consulta(st, query);
            while (rs.next()) {
                id_empleados = rs.getInt("codigo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        c_conectar.cerrar(st);
        c_conectar.cerrar(rs);
        return id_empleados;
    }

    public boolean insertar() {
        boolean grabar = false;
        st = c_conectar.conexion();
        String query = "INSERT INTO empleados "
                + "VALUES('" + id_empleados + "','" + usuario + "','" + password + "','" + nombres + "','" + apellidos + "','" + nro_documento + "','" + estado + "','" + cargo + "')";
        int respuesta = c_conectar.actualiza(st, query);
        if (respuesta > -1) {
            grabar = true;
        }
        return grabar;
    }

    public boolean modificar() {
        boolean modifica = false;
        st = c_conectar.conexion();
        String query = "UPDATE empleados "
                + "SET usuario='" + usuario + "',password='" + password + "',nombres='" + nombres + "',apellidos='" + apellidos + "',nro_documento='" + nro_documento + "',estado='" + estado + "',cargo='" + cargo + "' "
                + "WHERE idempleados='" + id_empleados + "'";
        int respuesta = c_conectar.actualiza(st, query);
        if (respuesta > -1) {
            modifica = true;
        }
        return modifica;
    }

    public boolean eliminar() {
        boolean elimina = false;
        st = c_conectar.conexion();
        String query = "DELETE FROM empleados "
                + "WHERE idempleados='" + id_empleados + "'";
        int respuesta = c_conectar.actualiza(st, query);
        if (respuesta > -1) {
            elimina = true;
        }
        return elimina;
    }

    public boolean obtener_datos() {
        boolean si = false;
        try {
            st = c_conectar.conexion();
            String query = "SELECT * from empleados "
                    + "where idempleados='" + id_empleados + "'";
            rs = c_conectar.consulta(st, query);
            while (rs.next()) {
                usuario = rs.getString("usuario");
                password = rs.getString("password");
                nombres = rs.getString("nombres");
                apellidos = rs.getString("apellidos");
                nro_documento = rs.getString("nro_documento");
                estado = rs.getInt("estado");
                cargo = rs.getInt("cargo");
                si = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        c_conectar.cerrar(st);
        c_conectar.cerrar(rs);
        return si;
    }
    
    public boolean validar_usuario() {
        boolean si = false;
        try {
            st = c_conectar.conexion();
            String query = "SELECT idempleados from empleados "
                    + "where usuario ='" + usuario + "'";
            rs = c_conectar.consulta(st, query);
            while (rs.next()) {
                id_empleados = rs.getInt("idempleados");
                si = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        c_conectar.cerrar(st);
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
            st = c_conectar.conexion();
            rs = c_conectar.consulta(st, query);

            RowSorter<TableModel> sorter = new TableRowSorter<>(mostrar);
            tabla.setRowSorter(sorter);

            mostrar.addColumn("Codigo");
            mostrar.addColumn("Usuario");
            mostrar.addColumn("datos del empleado");
            mostrar.addColumn("cargo");
            mostrar.addColumn("estado");

            while (rs.next()) {
                String scargo = "";
                if (rs.getInt("cargo") == 1) {
                    scargo = "VENDEDOR";
                }
                if (rs.getInt("cargo") == 2) {
                    scargo = "GERENTE";
                }
                Object fila[] = new Object[5];

                fila[0] = rs.getInt("idempleados");
                fila[1] = rs.getString("usuario");
                fila[2] = rs.getString("nombres") + " " + rs.getString("apellidos").trim();
                String  cargo="";
                switch (rs.getInt("cargo")) {
                    case 0:
                        cargo="Administrador";
                        break;
                    case 1:
                        cargo="Mozo";
                        break;
                    case 2:
                        cargo="Cajero";
                        break;
                    default:
                        break;
                }
                fila[3] = cargo;
                fila[4] = (rs.getInt("estado")==1)?"Activo":"Inactivo";

                mostrar.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(mostrar);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(180);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(50);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
