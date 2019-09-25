/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author luis
 */
public class cl_detalle_pedido {
    cl_conectar c_conectar = new cl_conectar();
    
    private int id_pedido;
    private int id_plato;
    private int cantidad;
    private double precio;
    
    private Statement st;
    private ResultSet rs;

    public cl_detalle_pedido() {
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public boolean insertar() {
        boolean grabar = false;
        st = c_conectar.conexion();
        String quely = "insert INTO detalle_pedido "
                + "VALUES ('" + id_pedido + "','" + id_plato + "','" + cantidad + "','" + precio + "')";
        int respuesta = c_conectar.actualiza(st, quely);
        if (respuesta > -1) {
            grabar = true;
        }
        return grabar;
    }

    public boolean eliminar() {
        boolean elimina = false;
        st = c_conectar.conexion();
        String query = "delete from detalle_pedido "
                + "WHERE idpedido='" + id_pedido + "'";
        int respuesta = c_conectar.actualiza(st, query);
        if (respuesta > -1) {
            elimina = true;
        }
        return elimina;
    }
}
