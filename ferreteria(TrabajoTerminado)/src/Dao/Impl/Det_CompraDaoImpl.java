/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Impl;

import Dao.Conexion;
import Dao.Det_CompraDao;
import Modelo.Det_Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del DAO de Det_Compra.
 */
public class Det_CompraDaoImpl implements Det_CompraDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    @Override
    public boolean registrarDetCompra(Det_Compra detCompra) {
        String insertSql = "INSERT INTO `det_compra_articulos`(`id_det_compra`, `id_compra`, `id_articulo`, `cantidad`, `precio_subtotal`) VALUES (NULL, ?, ?, ?, ?)";
        String updateSql = "UPDATE `almacen` SET `stock` = `stock` + ? WHERE `id_articulo` = ?";

        try {
            con = cn.getConnection();
            con.setAutoCommit(false); // Desactivar el modo de autocommit

            // Insertar en la tabla "det_compra_articulos"
            ps = con.prepareStatement(insertSql);
            ps.setInt(1, detCompra.getId_com());
            ps.setInt(2, detCompra.getId_ar());
            ps.setInt(3, detCompra.getCantidad_com());
            ps.setFloat(4, detCompra.getPrecio());
            ps.executeUpdate();

            // Actualizar el stock en la tabla "almacen"
            ps = con.prepareStatement(updateSql);
            ps.setInt(1, detCompra.getCantidad_com());
            ps.setInt(2, detCompra.getId_ar());
            ps.executeUpdate();

            con.commit(); // Confirmar la transacción
            return true;
        } catch (SQLException e) {
            try {
                con.rollback(); // Revertir la transacción en caso de error
            } catch (SQLException ex) {
                System.out.println("Error al realizar rollback: " + ex.getMessage());
            }
            System.out.println("Error en el registro del detalle de compra: " + e.getMessage());
            return false;
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
    public List<Det_Compra> listarDetCompras() {
        List<Det_Compra> detCompras = new ArrayList<>();
        String sql = "SELECT * FROM Det_Compra";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Det_Compra detCompra = new Det_Compra();
                detCompra.setId_det_com(rs.getInt("id_det_compra"));
                detCompra.setId_com(rs.getInt("id_compra"));
                detCompra.setId_ar(rs.getInt("id_articulo"));
                detCompra.setCantidad_com(rs.getInt("cantidad"));
                detCompra.setPrecio(rs.getFloat("precio_unitario"));
                detCompras.add(detCompra);
            }
            return detCompras;
        } catch (SQLException e) {
            System.out.println("Error al listar detalle de compra: " + e.getMessage());
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
    public boolean actualizarDetCompra(Det_Compra detCompra) {
        String sql = "UPDATE Det_Compra SET id_compra = ?, id_articulo = ?, cantidad = ?, precio_subtotal = ? WHERE id_det_compra = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detCompra.getId_com());
            ps.setInt(2, detCompra.getId_ar());
            ps.setInt(3, detCompra.getCantidad_com());
            ps.setFloat(4, detCompra.getPrecio());
            ps.setInt(5, detCompra.getId_det_com());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar detalle de compra: " + e.getMessage());
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
    public boolean eliminarDetCompra(int id) {
        String sql = "DELETE FROM Det_Compra WHERE id_compra = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al elimar detalle de compra: " + e.getMessage());
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
    public List obtenerDetCompraPorIdCompra(int id) {
        List<Det_Compra> detCompras = new ArrayList<>();
        String sql = "SELECT `id_det_compra`, `id_compra`, `id_articulo`, `cantidad`, `precio_subtotal` FROM `det_compra_articulos` WHERE id_compra= ? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Det_Compra detCompra = new Det_Compra();
                detCompra.setId_det_com(rs.getInt("id_det_compra"));
                detCompra.setId_com(rs.getInt("id_compra"));
                detCompra.setId_ar(rs.getInt("id_articulo"));
                detCompra.setCantidad_com(rs.getInt("cantidad"));
                detCompra.setPrecio(rs.getFloat("precio_subtotal"));
                detCompras.add(detCompra);
            }
            return detCompras;
        } catch (SQLException e) {
            System.out.println("Error al listar detalle de compra: " + e.getMessage());
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

