/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Impl;

import Dao.CategoriaDao;
import Dao.Conexion;
import Modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kmvil
 */
public class CatDaoImpl implements CategoriaDao{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    @Override
    public boolean registrarCategoria(Categoria categoria) {
        String sql = "INSERT INTO categoria (id_categoria, Nombre, cod_eliminado) VALUES (NULL, ?, 0)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, categoria.getNombre_cat());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en el registro de la categoría: " + e.getMessage());
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
    public List<Categoria> listarCategorias() {
        List<Categoria> listaCategorias = new ArrayList<>();
        String sql = "SELECT id_categoria, Nombre, cod_eliminado FROM categoria WHERE cod_eliminado=0";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId_cat(rs.getInt("id_categoria"));
                categoria.setNombre_cat(rs.getString("Nombre"));
                categoria.setCod_eli(rs.getInt("cod_eliminado"));
                listaCategorias.add(categoria);
            }
             return listaCategorias;
        } catch (SQLException e) {
            System.out.println("Error al listar categorías: " + e.getMessage());
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
    public boolean actualizarCategoria(Categoria categoria) {
        String sql = "UPDATE categoria SET Nombre=? WHERE id_categoria=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, categoria.getNombre_cat());
            ps.setInt(2, categoria.getId_cat());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar categoría: " + e.getMessage());
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
    public boolean eliminarCategoria(int id) {
        String sql = "UPDATE categoria SET cod_eliminado=1 WHERE id_categoria=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar categoría: " + e.getMessage());
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
    public List<Categoria> obtenerCatPorNombre(String nom) {
       List<Categoria> listaCategorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria WHERE nombre = ? AND cod_eliminado=0 ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId_cat(rs.getInt("id_categoria"));
                categoria.setNombre_cat(rs.getString("Nombre"));
                categoria.setCod_eli(rs.getInt("cod_eliminado"));
                listaCategorias.add(categoria);
            }
            return listaCategorias;
        } catch (SQLException e) {
            System.out.println("Error al listar categorías: " + e.getMessage());
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
    public List<Categoria> obtenerCatPorId(int id) {
        List<Categoria> listaCategorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria WHERE id_categoria = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId_cat(rs.getInt("id_categoria"));
                categoria.setNombre_cat(rs.getString("Nombre"));
                categoria.setCod_eli(rs.getInt("cod_eliminado"));
                listaCategorias.add(categoria);
            }
            return listaCategorias;
        } catch (SQLException e) {
            System.out.println("Error al listar categorías: " + e.getMessage());
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
