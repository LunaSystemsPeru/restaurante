/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luis
 */
public class cl_caja_movimientos {
    cl_conectar c_conectar = new cl_conectar();
 
    private int id_movimiento;
    private String fecha;
    private double ingresa;
    private double salida;
    private String motivo;
    private int id_empleado;
    
    private Statement st;
    private ResultSet rs;

    public cl_caja_movimientos() {
    }

    public int getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getIngresa() {
        return ingresa;
    }

    public void setIngresa(double ingresa) {
        this.ingresa = ingresa;
    }

    public double getSalida() {
        return salida;
    }

    public void setSalida(double salida) {
        this.salida = salida;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    
    public boolean insertar() {
        boolean grabar = false;
        st = c_conectar.conexion();
        String sql = "INSERT INTO cajas_movimientos "
                + "VALUES ('" + fecha + "','"+id_movimiento+"', '"+ingresa+"', '"+salida+"', '"+motivo+"','"+id_empleado+"')";
        int respuesta = c_conectar.actualiza(st, sql);
        if (respuesta > -1) {
            grabar = true;
        }
        return grabar;
    }
    
    public int generarCodigo() {
        try {
            st = c_conectar.conexion();
            String sql = "select ifnull(max(id_movimiento)+1, 1) "
                    + "as codigo "
                    + "from cajas_movimientos";
            rs = c_conectar.consulta(st, sql);
            if (rs.next()) {
                id_movimiento = rs.getInt("codigo");
            }
        } catch (SQLException e) {
        }
        c_conectar.cerrar(st);
        c_conectar.cerrar(rs);
        return id_movimiento;
    }
}
