/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Impl;

import Dao.Conexion;
import Dao.VentaDao;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de implementación del VentaDao
 */
public class VentaDaoImpl implements VentaDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    @Override
    public int registrarVenta(Venta venta) {
        String insertVentaSql = "INSERT INTO venta (id_venta, id_usuario, DNI_cliente, Nombre_cliente, metodo_pago, fecha_venta, Total) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
        String updateUsuarioSql = "UPDATE usuario SET cantidad_venta = cantidad_venta + 1 WHERE id_usuario = ?";

        try {
            con = cn.getConnection();
            con.setAutoCommit(false); // Desactivar el modo de autocommit

            // Insertar en la tabla "venta"
            ps = con.prepareStatement(insertVentaSql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getId_usu());
            ps.setInt(2, venta.getDNI_vent());
            ps.setString(3, venta.getNombre_vent());
            ps.setString(4, venta.getMetodo_pago());
            ps.setString(5, venta.getFecha_vent());
            ps.setFloat(6, venta.getTotal());
            ps.executeUpdate();

            // Obtener el ID generado
            rs = ps.getGeneratedKeys();
            int idVentaGenerado;
            if (rs.next()) {
                idVentaGenerado = rs.getInt(1);
            } else {
                throw new SQLException("No se pudo obtener el ID generado para la venta");
            }

            // Actualizar la columna "cantidad_venta" en la tabla "usuario"
            ps = con.prepareStatement(updateUsuarioSql);
            ps.setInt(1, venta.getId_usu());
            ps.executeUpdate();

            con.commit(); // Confirmar la transacción
            return idVentaGenerado;
        } catch (SQLException e) {
            try {
                con.rollback(); // Revertir la transacción en caso de error
            } catch (SQLException ex) {
                System.out.println("Error al realizar rollback: " + ex.getMessage());
            }
            System.out.println("Error en el registro de la venta: " + e.getMessage());
            return -1; // O cualquier otro valor que indique un error
        } finally {
            try {
                con.setAutoCommit(true); // Restaurar el modo de autocommit
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    @Override
    public List<Venta> listarVentas() {
        List<Venta> listaVentas = new ArrayList<>();
        String sql = "SELECT id_venta, id_usuario, DNI_cliente, Nombre_cliente, metodo_pago, fecha_venta, Total FROM venta";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId_vent(rs.getInt("id_venta"));
                venta.setId_usu(rs.getInt("id_usuario"));
                venta.setDNI_vent(rs.getInt("DNI_cliente"));
                venta.setNombre_vent(rs.getString("Nombre_cliente"));
                venta.setMetodo_pago(rs.getString("metodo_pago"));
                venta.setFecha_vent(rs.getString("fecha_venta"));
                venta.setTotal(rs.getFloat("Total"));
                listaVentas.add(venta);
            }
            return listaVentas;
        } catch (SQLException e) {
            System.out.println("Error al listar ventas: " + e.getMessage());
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
    public boolean actualizarVenta(Venta venta) {
        String sql = "UPDATE venta SET id_usuario=?, DNI_cliente=?, Nombre_cliente=?, metodo_pago=?, fecha_venta=?, Total=? WHERE id_venta=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getId_usu());
            ps.setInt(2, venta.getDNI_vent());
            ps.setString(3, venta.getNombre_vent());
            ps.setString(4, venta.getMetodo_pago());
            ps.setString(5, venta.getFecha_vent());
            ps.setFloat(6, venta.getTotal());
            ps.setInt(7, venta.getId_vent());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar venta: " + e.getMessage());
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
    public boolean eliminarVenta(int id) {
        String sql = "DELETE FROM venta WHERE id_venta=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar venta: " + e.getMessage());
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
    public List<Venta> listarVentasEntreFechas(String fechaInicio, String fechaFin) {
        List<Venta> listaVentas = new ArrayList<>();
        String sql = "SELECT id_venta, id_usuario, DNI_cliente, Nombre_cliente, metodo_pago, fecha_venta, Total FROM venta WHERE fecha_venta BETWEEN ? AND ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fechaInicio);
            ps.setString(2, fechaFin);
            rs = ps.executeQuery();

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId_vent(rs.getInt("id_venta"));
                venta.setId_usu(rs.getInt("id_usuario"));
                venta.setDNI_vent(rs.getInt("DNI_cliente"));
                venta.setNombre_vent(rs.getString("Nombre_cliente"));
                venta.setMetodo_pago(rs.getString("metodo_pago"));
                venta.setFecha_vent(rs.getString("fecha_venta"));
                venta.setTotal(rs.getFloat("Total"));
                listaVentas.add(venta);
            }
            return listaVentas;
        } catch (SQLException e) {
            System.out.println("Error al listar ventas: " + e.getMessage());
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

