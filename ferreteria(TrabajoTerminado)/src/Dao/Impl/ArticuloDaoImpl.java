/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Impl;

import Dao.ArticuloDao;
import Dao.Conexion;
import Modelo.Articulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de implementación del ArticuloDao
 */
public class ArticuloDaoImpl implements ArticuloDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    @Override
    public boolean registrarArticulo(Articulo articulo) {
        String sql = "INSERT INTO articulo (id_articulo, nombre, descripcion, id_categoria, id_marca, cod_eliminado) VALUES (NULL, ?, ?, ?, ?, 0)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, articulo.getNombre_ar());
            ps.setString(2, articulo.getDescrip_ar());
            ps.setInt(3, articulo.getId_cat());
            ps.setInt(4, articulo.getId_mar());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en el registro del artículo: " + e.getMessage());
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
    public List<Articulo> listarArticulos() {
        List<Articulo> listaArticulos = new ArrayList<>();
        
        String sql = "SELECT id_articulo, nombre, descripcion, id_categoria, id_marca, cod_eliminado FROM articulo WHERE cod_eliminado = 0";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setId_ar(rs.getInt("id_articulo"));
                articulo.setNombre_ar(rs.getString("nombre"));
                articulo.setDescrip_ar(rs.getString("descripcion"));
                articulo.setId_cat(rs.getInt("id_categoria"));
                articulo.setId_mar(rs.getInt("id_marca"));
                articulo.setCod_eli(rs.getInt("cod_eliminado"));
                listaArticulos.add(articulo);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar artículos: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return listaArticulos;
    }

    @Override
    public boolean actualizarArticulo(Articulo articulo) {
        String sql = "UPDATE articulo SET nombre=?, descripcion=?, id_categoria=?, id_marca=? WHERE id_articulo=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, articulo.getNombre_ar());
            ps.setString(2, articulo.getDescrip_ar());
            ps.setInt(3, articulo.getId_cat());
            ps.setInt(4, articulo.getId_mar());
            ps.setInt(5, articulo.getId_ar());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar artículo: " + e.getMessage());
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
    public boolean eliminarArticulo(int id) {
        String sql = "UPDATE articulo SET cod_eliminado=1 WHERE id_articulo=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar artículo: " + e.getMessage());
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
    public List<Articulo> obtenerArticuloPorNombre(String nom) {
        List<Articulo> listaArticulos = new ArrayList<>();
        String sql = "SELECT `id_articulo`, `Nombre`, `descripcion`, `id_categoria`, `id_marca`, `cod_eliminado` FROM `articulo` WHERE `Nombre`=? AND `cod_eliminado`=0";
        
        try  {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setId_ar(rs.getInt("id_articulo"));
                articulo.setNombre_ar(rs.getString("nombre"));
                articulo.setDescrip_ar(rs.getString("descripcion"));
                articulo.setId_cat(rs.getInt("id_categoria"));
                articulo.setId_mar(rs.getInt("id_marca"));
                articulo.setCod_eli(rs.getInt("cod_eliminado"));
                listaArticulos.add(articulo);
            }
            return listaArticulos;
        } catch (SQLException e) {
            System.out.println("Error obtenre articulo por nombre: " + e.getMessage());
            return null;
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        
    }

    @Override
    public List<Articulo> obtenerArticuloPorId(int id) {
        List<Articulo> listaArticulos = new ArrayList<>();
        String sql = "SELECT `id_articulo`, `Nombre`, `descripcion`, `id_categoria`, `id_marca`, `cod_eliminado` FROM `articulo` WHERE `id_articulo`=? AND `cod_eliminado`=0";
        
        try  {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setId_ar(rs.getInt("id_articulo"));
                articulo.setNombre_ar(rs.getString("nombre"));
                articulo.setDescrip_ar(rs.getString("descripcion"));
                articulo.setId_cat(rs.getInt("id_categoria"));
                articulo.setId_mar(rs.getInt("id_marca"));
                articulo.setCod_eli(rs.getInt("cod_eliminado"));
                listaArticulos.add(articulo);
            }
            return listaArticulos;
        } catch (SQLException e) {
            System.out.println("Error obtenre articulo por nombre: " + e.getMessage());
            return null;
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

   

}

