package clases;

import java.sql.*;
import clases.cl_conectar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import objetos.o_combobox;

public class cl_documento_sunat {

    cl_conectar c_conectar = new cl_conectar();

    private int id_documento;
    private String nombre;
    private String cod_sunat;
    private String abreviatura;

    private Statement stmt;
    private ResultSet rs;

    /**
     * @return the id_documento
     */
    public int getId_documento() {
        return id_documento;
    }

    /**
     * @param id_documento the id_documento to set
     */
    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cod_sunat
     */
    public String getCod_sunat() {
        return cod_sunat;
    }

    /**
     * @param cod_sunat the cod_sunat to set
     */
    public void setCod_sunat(String cod_sunat) {
        this.cod_sunat = cod_sunat;
    }

    /**
     * @return the abreviatura
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * @param abreviatura the abreviatura to set
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public boolean insertar() {
        boolean grabar = false;
        try {
            stmt = c_conectar.conexion();
            String quely = "insert INTO documento_sunat VALUES ('" + id_documento + "','" + nombre + "','" + cod_sunat + "','" + abreviatura + "')";
            int respuesta = c_conectar.actualiza(stmt, quely);
            if (respuesta > -1) {
                grabar = true;
            }
        } catch (Exception e) {
        }
        return grabar;
    }

    public boolean modificar() {
        boolean modifica = false;
        stmt = c_conectar.conexion();
        String query = "UPDATE documento_sunat SET nombre='" + nombre + "',cod_sunat='" + cod_sunat + "',abreviatura='" + abreviatura + "' WHERE idcomprobante='" + id_documento + "'";
        int respuesta = c_conectar.actualiza(stmt, query);
        if (respuesta > -1) {
            modifica = true;
        }
        return modifica;
    }

    public boolean eliminar() {
        boolean elimina = false;
        try {
            stmt = c_conectar.conexion();
            String query = "delete from documento_sunat WHERE idcomprobante='" + id_documento + "'";
            int respuesta = c_conectar.actualiza(stmt, query);
            if (respuesta > -1) {
                elimina = true;
            }
        } catch (Exception e) {
        }
        return elimina;
    }

    public int obtener_codigo() {
        try {
            stmt = c_conectar.conexion();
            String query = "select ifnull(max(idcomprobante)+1, 1) as idcomprobante from documento_sunat";
            rs = c_conectar.consulta(stmt, query);
            while (rs.next()) {
                id_documento = rs.getInt("idcomprobante");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        c_conectar.cerrar(rs);
        c_conectar.cerrar(stmt);
        return id_documento;
    }

    public void obtener_datos() {
        try {
            stmt = c_conectar.conexion();
            String query = "SELECT * FROM documento_sunat WHERE idcomprobante='" + id_documento + "'";
            rs = c_conectar.consulta(stmt, query);
            while (rs.next()) {
                nombre = rs.getString("nombre");
                cod_sunat = rs.getString("cod_sunat");
                abreviatura = rs.getString("abreviatura");
            }
        } catch (SQLException e) {
        }
        c_conectar.cerrar(stmt);
        c_conectar.cerrar(rs);
    }

    public void ver_documentos_sunat(JTable tabla, String query) {
        try {
            DefaultTableModel mostrar = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            stmt = c_conectar.conexion();
            rs = c_conectar.consulta(stmt, query);

            RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(mostrar);
            tabla.setRowSorter(sorter);

            mostrar.addColumn("Codigo");
            mostrar.addColumn("cod_sunat");
            mostrar.addColumn("abreviatura");

            while (rs.next()) {
                Object fila[] = new Object[3];

                fila[0] = rs.getInt("idcomprobante");
                fila[1] = rs.getString("cod_sunat");
                fila[2] = rs.getString("abreviatura").trim();

                mostrar.addRow(fila);
            }

            c_conectar.cerrar(stmt);
            c_conectar.cerrar(rs);
            tabla.setModel(mostrar);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100);

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
