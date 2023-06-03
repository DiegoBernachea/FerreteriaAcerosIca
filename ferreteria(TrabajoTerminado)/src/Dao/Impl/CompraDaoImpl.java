/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Impl;

import Dao.CompraDao;
import Dao.Conexion;
import Modelo.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del DAO de Compra.
 */
public class CompraDaoImpl implements CompraDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    @Override
    public int registrarCompra(Compra compra) {
        String sql = "INSERT INTO `compra`(`id_compra`, `id_proveedor`, `id_usuario`, `Fecha_compra`, `Total`) VALUES (null,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // Establecer la opción RETURN_GENERATED_KEYS
            ps.setInt(1, compra.getId_pro());
            ps.setInt(2, compra.getId_usu());
            ps.setString(3, compra.getFecha_com());
            ps.setFloat(4, compra.getTotal());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);
                return idGenerado;
            } else {
                throw new SQLException("No se pudo obtener el ID generado");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar compra: " + e.getMessage());
            return -1; // O cualquier otro valor que indique un error
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    @Override
    public List<Compra> listarCompras() {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT `id_compra`, `id_proveedor`, `id_usuario`, `Fecha_compra`, `Total` FROM `compra`";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Compra compra = new Compra();
                compra.setId_com(rs.getInt("id_compra"));
                compra.setId_pro(rs.getInt("id_proveedor"));
                compra.setId_usu(rs.getInt("id_usuario"));
                compra.setFecha_com(rs.getString("Fecha_compra"));
                compra.setTotal(rs.getFloat("Total"));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            System.out.println("Error al listar compras: " + e.getMessage());
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
    public boolean actualizarCompra(Compra compra) {
        String sql = "UPDATE Compra SET id_proveedor = ?, fecha_compra = ?, total = ? WHERE id_compra = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, compra.getId_pro());
            ps.setString(2, compra.getFecha_com());
            ps.setFloat(3, compra.getTotal());
            ps.setInt(4, compra.getId_com());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar compra: " + e.getMessage());
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
    public boolean eliminarCompra(int id) {
        String sql = "DELETE FROM Compra WHERE id_compra = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar compra: " + e.getMessage());
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
    public List<Compra> listarComprasEntreFechas(String fechaInicio, String fechaFin) {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT `id_compra`, `id_proveedor`, `id_usuario`, `Fecha_compra`, `Total` FROM `compra` WHERE Fecha_compra BETWEEN ? AND ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fechaInicio);
            ps.setString(2, fechaFin);
            rs = ps.executeQuery();

            while (rs.next()) {
                Compra compra = new Compra();
                compra.setId_com(rs.getInt("id_compra"));
                compra.setId_pro(rs.getInt("id_proveedor"));
                compra.setId_usu(rs.getInt("id_usuario"));
                compra.setFecha_com(rs.getString("Fecha_compra"));
                compra.setTotal(rs.getFloat("Total"));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            System.out.println("Error al listar compras: " + e.getMessage());
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