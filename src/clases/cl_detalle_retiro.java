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
public class cl_detalle_retiro {

    cl_conectar c_conectar = new cl_conectar();

    private int id_retiro;
    private int id_insumo;
    private double cantidad;
    private double costo;

    private Statement st;
    private ResultSet rs;

    public cl_detalle_retiro() {
    }

    public int getId_retiro() {
        return id_retiro;
    }

    public void setId_retiro(int id_retiro) {
        this.id_retiro = id_retiro;
    }

    public int getId_insumo() {
        return id_insumo;
    }

    public void setId_insumo(int id_insumo) {
        this.id_insumo = id_insumo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean insertar() {
        boolean grabar = false;
        st = c_conectar.conexion();
        String quely = "insert INTO detalle_retiro "
                + "VALUES ('" + id_retiro + "','" + id_insumo + "','" + cantidad + "','" + costo + "')";
        int respuesta = c_conectar.actualiza(st, quely);
        if (respuesta > -1) {
            grabar = true;
        }
        return grabar;
    }

    public boolean eliminar() {
        boolean elimina = false;
        st = c_conectar.conexion();
        String query = "delete from detalle_retiro "
                + "WHERE idretiro='" + id_retiro + "'";
        int respuesta = c_conectar.actualiza(st, query);
        if (respuesta > -1) {
            elimina = true;
        }
        return elimina;
    }
}
