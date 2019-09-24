package clases;

import java.sql.*;

public class cl_cliente {

    cl_conectar c_conectar = new cl_conectar();
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private int id_cliente;
    private String documento;
    private String nombre;
    private String apellidos;
    private String direcion;
    private String telefono;
    private String celular;

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
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
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    public boolean insertar() {
        boolean grabar = false;
        try {
            stmt = c_conectar.conexion();
            String query = "INSERT INTO cliente VALUES ('" + id_cliente + "','" + documento + "','" + nombre + "','" + apellidos + "','" + direcion + "','" + telefono + "','" + celular + "')";
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
            String query = "UPDATE cliente SET documento='" + documento + "',nombre='" + nombre + "',apellidos='" + apellidos + "',direccion='" + direcion + "',telefono='" + telefono + "',celular='" + celular + "' WHERE idcliente='" + id_cliente + "'";
            int respuesta = c_conectar.actualiza(stmt, query);
            if (respuesta > -1) {
                modifica = true;
            }
        } catch (Exception e) {
        }
        return modifica;
    }

    public boolean eliminar() {
        boolean eliminar = false;
        try {
            stmt = c_conectar.conexion();
            String query = "DELETE FROM cliente WHERE idcliente='" + id_cliente + "'";

            int respuesta = c_conectar.actualiza(stmt, query);
            if (respuesta > -1) {
                eliminar = true;
            }
        } catch (Exception e) {
        }
        return eliminar;
    }

}
