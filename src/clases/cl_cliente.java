package clases;

import java.sql.*;

public class cl_cliente {

    cl_conectar c_conectar = new cl_conectar();

    private Statement stmt;
    private ResultSet rs;

    private int id_cliente;
    private String documento;
    private String nombre;
    private String email;
    private String direcion;
    private String telefono;

    public cl_cliente() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean insertar() {
        boolean grabar = false;
        stmt = c_conectar.conexion();
        String query = "INSERT INTO cliente "
                + "VALUES ('" + id_cliente + "','" + documento + "','" + nombre + "','" + email + "','" + direcion + "','" + telefono + "')";
        int respuesta = c_conectar.actualiza(stmt, query);
        if (respuesta > -1) {
            grabar = true;
        }
        return grabar;
    }

    public boolean modificar() {
        boolean modifica = false;
        try {
            stmt = c_conectar.conexion();
            String query = "UPDATE cliente "
                    + "SET documento='" + documento + "',nombre='" + nombre + "',email='" + email + "',direccion='" + direcion + "',telefono='" + telefono + "' "
                    + "WHERE idcliente='" + id_cliente + "'";
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
            String query = "DELETE FROM cliente "
                    + "WHERE idcliente='" + id_cliente + "'";

            int respuesta = c_conectar.actualiza(stmt, query);
            if (respuesta > -1) {
                eliminar = true;
            }
        } catch (Exception e) {
        }
        return eliminar;
    }

}
