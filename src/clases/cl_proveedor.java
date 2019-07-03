package clases;

import clases.cl_varios;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class cl_proveedor {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private int id_proveedor;
    private String num_documento;
    private String razon_social;
    private int telefono;
    private int celular;
    private String email;
    private String direccion;
    private String condicion;
    private String estado;
    private double Tcompra;
    private double Tpaga;

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the celular
     */
    public int getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(int celular) {
        this.celular = celular;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the condicion
     */
    public String getCondicion() {
        return condicion;
    }

    /**
     * @param condicion the condicion to set
     */
    public void setCondicion(String condicion) {
        this.condicion = condicion;
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
     * @return the Tcompra
     */
    public double getTcompra() {
        return Tcompra;
    }

    /**
     * @param Tcompra the Tcompra to set
     */
    public void setTcompra(double Tcompra) {
        this.Tcompra = Tcompra;
    }

    /**
     * @return the Tpaga
     */
    public double getTpaga() {
        return Tpaga;
    }

    /**
     * @param Tpaga the Tpaga to set
     */
    public void setTpaga(double Tpaga) {
        this.Tpaga = Tpaga;
    }

    /**
     * @return the id_proveedor
     */
    public int getId_proveedor() {
        return id_proveedor;
    }

    /**
     * @param id_proveedor the id_proveedor to set
     */
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    /**
     * @return the num_documento
     */
    public String getNum_documento() {
        return num_documento;
    }

    /**
     * @param num_documento the num_documento to set
     */
    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    /**
     * @return the razon_social
     */
    public String getRazon_social() {
        return razon_social;
    }

    /**
     * @param razon_social the razon_social to set
     */
    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public boolean insertar() {
        boolean grabar = false;
        try {
            stmt = c_conectar.conexion();
            String query = "INSERT INTO proveedor VALUES('" + id_proveedor + "','" + num_documento + "','" + razon_social + "','" + telefono + "','" + celular + "','" + email + "','" + direccion + "','" + condicion + "','" + estado + "','" + 12.2 + "','" + 12.5 + "')";
            int respuesta = c_conectar.actualiza(stmt, query);
            if (respuesta > -1) {
                grabar = true;
            }
        } catch (Exception e) {
        }
        return grabar;
    }

    public boolean modificar() {
        boolean modifica = false;
        try {
            stmt = c_conectar.conexion();
            String query = "UPDATE proveedor SET num_documento='" + num_documento + "',razon_social='" + razon_social + "',telefono='" + telefono + "',celular='" + celular + "',email='" + email + "',direccion='" + direccion + "',condicion='" + condicion + "',estado='" + estado + "',tcompra='" + 12 + "',tpagado='" + 12 + "' WHERE idproveedor='" + id_proveedor + "'";
            int respuesta = c_conectar.actualiza(stmt, query);
            if (respuesta > -1) {
                modifica = true;
            }
        } catch (Exception e) {
        }

        return modifica;
    }

    public boolean eliminar() {
        boolean elimina = false;
        try {
            stmt = c_conectar.conexion();
            String query = "DELETE FROM proveedor WHERE idproveedor='" + id_proveedor + "'";
            int respuesta = c_conectar.actualiza(stmt, query);
            if (respuesta > -1) {
                elimina = true;
            }
        } catch (Exception e) {
        }
        return true;
    }

    public int obtenr_codigo() {
        try {
            stmt = c_conectar.conexion();
            String query = "select ifnull(max(idproveedor)+1, 1) as idproveedor from proveedor";
            rs = c_conectar.consulta(stmt, query);
            while (rs.next()) {
                id_proveedor = rs.getInt("idproveedor");
            }
        } catch (Exception e) {
        }
        return id_proveedor;
    }

    public boolean obtener_datos() {
        boolean si = false;
        try {
            stmt = c_conectar.conexion();
            String query = "SELECT * FROM proveedor where idproveedor='" + id_proveedor + "'";
            System.out.println(query);
            rs = c_conectar.consulta(stmt, query);
            while (rs.next()) {
                id_proveedor=rs.getInt("idproveedor");
                num_documento=rs.getString("num_documento");
                razon_social=rs.getString("razon_social");
                telefono=rs.getInt("telefono");
                celular=rs.getInt("celular");
                email=rs.getString("email");
                direccion=rs.getString("direccion");
                condicion=rs.getString("condicion");
                estado=rs.getString("estado");
                si = true;
            }
        } catch (Exception e) {
        }
//        c_conectar.cerrar(rs);
//        c_conectar.cerrar(stmt);
        return si;
    }

    public void ver_proveedores(JTable tabla, String query) {
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
            mostrar.addColumn("codigo");
            mostrar.addColumn("RUC");
            mostrar.addColumn("Razon Social");
            mostrar.addColumn("S/ Compras");
            mostrar.addColumn("S/ Deudas");
            mostrar.addColumn("Estado");

            while (rs.next()) {
                double compras = rs.getDouble("tcompra");
                double pagado = rs.getDouble("tpagado");
                double deuda = compras - pagado;

                Object fila[] = new Object[6];
                fila[0] = rs.getInt("idproveedor");
                fila[1] = rs.getString("num_documento");
                fila[2] = rs.getString("razon_social").trim().toUpperCase();
                fila[3] = c_varios.formato_totales(compras);
                fila[4] = c_varios.formato_totales(deuda);
                if (compras > 0 & deuda == 0) {
                    fila[5] = "-";
                }
                if (compras > 0 & deuda > 0) {
                    fila[5] = "DEUDOR";
                }

                if (deuda < 0) {
                    fila[5] = "DEUDOR";
                }
                if (compras == 0) {
                    fila[5] = "INACTIVO";
                }
                mostrar.addRow(fila);
            }

            c_conectar.cerrar(stmt);
            c_conectar.cerrar(rs);
            tabla.setModel(mostrar);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(500);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
