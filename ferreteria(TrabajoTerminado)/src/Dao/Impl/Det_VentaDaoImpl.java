/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Impl;

/**
 *
 * @author kmvil
 */

import Dao.Conexion;
import Modelo.Det_Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Det_VentaDao;



/**
 * Clase de implementación del Det_VentaDao
 */
public class Det_VentaDaoImpl implements Det_VentaDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    @Override
    public boolean registrarDetVenta(Det_Venta detVenta) {
        String insertSql = "INSERT INTO det_venta_articulos (id_det_venta, id_venta, id_articulo, cantidad, precio_subtotal) VALUES (NULL, ?, ?, ?, ?)";
        String updateSql = "UPDATE almacen SET stock = stock - ? WHERE id_articulo = ?";

        try {
            con = cn.getConnection();

            // Ejecutar la inserción en la tabla "det_venta_articulos"
            ps = con.prepareStatement(insertSql);
            ps.setInt(1, detVenta.getId_vent());
            ps.setInt(2, detVenta.getId_ar());
            ps.setInt(3, detVenta.getCantidad_vent());
            ps.setFloat(4, detVenta.getTotalsub());
            ps.execute();

            // Ejecutar la actualización del stock en la tabla "almacen"
            ps = con.prepareStatement(updateSql);
            ps.setInt(1, detVenta.getCantidad_vent()); // Reemplaza con el valor adecuado
            ps.setInt(2, detVenta.getId_ar()); // Reemplaza con el valor adecuado
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("Error en el registro del detalle de venta: " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

    }

    @Override
    public List<Det_Venta> listarDetVentas() {
        List<Det_Venta> listaDetVentas = new ArrayList<>();
        String sql = "SELECT id_det_venta, id_venta, id_articulo, cantidad, precio_subtotal FROM det_venta_articulos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Det_Venta detVenta = new Det_Venta();
                detVenta.setId_det_vent(rs.getInt("id_det_venta"));
                detVenta.setId_vent(rs.getInt("id_venta"));
                detVenta.setId_ar(rs.getInt("id_articulo"));
                detVenta.setCantidad_vent(rs.getInt("cantidad"));
                detVenta.setTotalsub(rs.getFloat("precio_subtotal"));
                listaDetVentas.add(detVenta);
            }
            return listaDetVentas;
        } catch (SQLException e) {
            System.out.println("Error al listar detalles de venta: " + e.getMessage());
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        
    }

    @Override
    public boolean actualizarDetVenta(Det_Venta detVenta) {
        String sql = "UPDATE det_venta_articulos SET id_venta=?, id_articulo=?, cantidad=?, precio_subtotal=? WHERE id_det_venta=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detVenta.getId_vent());
            ps.setInt(2, detVenta.getId_ar());
            ps.setInt(3, detVenta.getCantidad_vent());
            ps.setFloat(4, detVenta.getTotalsub());
            ps.setInt(5, detVenta.getId_det_vent());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar detalle de venta: " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    @Override
    public boolean eliminarDetVenta(int id) {
        String sql = "DELETE FROM det_venta_articulos WHERE id_det_venta=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar detalle de venta: " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    @Override
    public List obtenerDetVentaPorIdVenta(int id) {
       List<Det_Venta> listaDetVentas = new ArrayList<>();
        String sql = "SELECT id_det_venta, id_venta, id_articulo, cantidad, precio_subtotal FROM det_venta_articulos WHERE id_venta = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Det_Venta detVenta = new Det_Venta();
                detVenta.setId_det_vent(rs.getInt("id_det_venta"));
                detVenta.setId_vent(rs.getInt("id_venta"));
                detVenta.setId_ar(rs.getInt("id_articulo"));
                detVenta.setCantidad_vent(rs.getInt("cantidad"));
                detVenta.setTotalsub(rs.getFloat("precio_subtotal"));
                listaDetVentas.add(detVenta);
            }
            return listaDetVentas;
        } catch (SQLException e) {
            System.out.println("Error al listar detalles de venta: " + e.getMessage());
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
