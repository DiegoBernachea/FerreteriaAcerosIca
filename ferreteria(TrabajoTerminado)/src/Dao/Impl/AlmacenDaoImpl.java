/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Impl;

import Dao.AlmacenDao;
import Dao.Conexion;
import Modelo.Almacen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de implementación del AlmacenDao
 */
public class AlmacenDaoImpl implements AlmacenDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    @Override
    public boolean registrarAlmacen(Almacen almacen) {
        String sql = "INSERT INTO almacen (id_almacen, id_articulo, stock, precio_unitario) VALUES (NULL, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, almacen.getId_ar());
            ps.setInt(2, almacen.getStock());
            ps.setFloat(3, almacen.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en el registro del almacén: " + e.getMessage());
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
    public List<Almacen> listarAlmacen() {
        List<Almacen> listaAlmacen = new ArrayList<>();
        String sql = "SELECT `id_almacen`, `id_articulo`, `stock`, `precio_unitario` FROM `almacen`";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Almacen almacen = new Almacen();
                almacen.setId_al(rs.getInt("id_almacen"));
                almacen.setId_ar(rs.getInt("id_articulo"));
                almacen.setStock(rs.getInt("stock"));
                almacen.setPrecio(rs.getFloat("precio_unitario"));
                listaAlmacen.add(almacen);
            }
            return listaAlmacen;
        } catch (SQLException e) {
            System.out.println("Error al listar almacén: " + e.getMessage());
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
    public boolean actualizarAlmacen(Almacen almacen) {
        String sql = "UPDATE almacen SET id_articulo=?, stock=?, precio_unitario=? WHERE id_almacen=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, almacen.getId_ar());
            ps.setInt(2, almacen.getStock());
            ps.setFloat(3, almacen.getPrecio());
            ps.setInt(4, almacen.getId_al());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar almacén: " + e.getMessage());
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
    public boolean eliminarAlmacen(int id) {
        String sql = "DELETE FROM almacen WHERE id_almacen=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar almacén: " + e.getMessage());
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
    public List ObtenerAlmacenPorIdArticulo(int id) {
        List<Almacen> listaAlmacen = new ArrayList<>();
        String sql = "SELECT `id_almacen`, `id_articulo`, `stock`, `precio_unitario` FROM `almacen` WHERE id_articulo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Almacen almacen = new Almacen();
                almacen.setId_al(rs.getInt("id_almacen"));
                almacen.setId_ar(rs.getInt("id_articulo"));
                almacen.setStock(rs.getInt("stock"));
                almacen.setPrecio(rs.getFloat("precio_unitario"));
                listaAlmacen.add(almacen);
            }
            return listaAlmacen;
        } catch (SQLException e) {
            System.out.println("Error al listar almacén: " + e.getMessage());
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
