/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Impl;

import Dao.Conexion;
import Dao.MarcaDao;
import Modelo.Marca;
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
public class MarcaDaoImpl implements MarcaDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    @Override
    public boolean registrarMarca(Marca marca) {
        String sql = "INSERT INTO marca (id_marca, nombre, cod_eliminado) VALUES (NULL, ?, 0)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, marca.getNombre_mar());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en el registro de la marca: " + e.getMessage());
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
    public List listarMarcas() {
        List<Marca> listaMarcas = new ArrayList<>();
        String sql = "SELECT id_marca, nombre, cod_eliminado FROM marca WHERE cod_eliminado = 0";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId_mar(rs.getInt("id_marca"));
                marca.setNombre_mar(rs.getString("nombre"));
                marca.setCod_eli(rs.getInt("cod_eliminado"));
                listaMarcas.add(marca);
            }
            return listaMarcas;
        } catch (SQLException e) {
            System.out.println("Error al listar marcas: " + e.getMessage());
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
    public boolean actualizarMarca(Marca marca) {
        String sql = "UPDATE marca SET nombre=? WHERE id_marca=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, marca.getNombre_mar());
            ps.setInt(2, marca.getId_mar());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar marca: " + e.getMessage());
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
    public boolean eliminarMarca(int id) {
        String sql = "UPDATE marca SET cod_eliminado=1 WHERE id_marca=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar marca: " + e.getMessage());
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
    public List obtenerMarcaPorNombre(String nom) {
        
        
        List<Marca> listaMarcas = new ArrayList<>();
        String sql = "SELECT * FROM marca WHERE nombre = ? AND cod_eliminado = 0";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();

            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId_mar(rs.getInt("id_marca"));
                marca.setNombre_mar(rs.getString("nombre"));
                marca.setCod_eli(rs.getInt("cod_eliminado"));
                listaMarcas.add(marca);
            }
            return listaMarcas;
        } catch (SQLException e) {
            System.out.println("Error al listar marcas: " + e.getMessage());
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
    public List<Marca> obtenerMarcaPorId(int id) {
        List<Marca> listaMarcas = new ArrayList<>();
        String sql = "SELECT * FROM marca WHERE id_marca = ? AND cod_eliminado = 0";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId_mar(rs.getInt("id_marca"));
                marca.setNombre_mar(rs.getString("nombre"));
                marca.setCod_eli(rs.getInt("cod_eliminado"));
                listaMarcas.add(marca);
            }
            return listaMarcas;
        } catch (SQLException e) {
            System.out.println("Error al listar marcas: " + e.getMessage());
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
