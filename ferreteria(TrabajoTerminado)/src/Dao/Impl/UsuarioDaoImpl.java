/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Impl;

import Dao.Conexion;
import Dao.UsuarioDao;
import Modelo.Usuario;

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
public class UsuarioDaoImpl implements UsuarioDao{
    
    Connection con ;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    @Override
    public boolean registrarUsuario(Usuario usu) {
        String sql = "INSERT INTO usuario (id_usuario, nombre , usuario , contraseña , rol , cod_eliminado , cantidad_venta) VALUES (NULL,?,?,?,?,0,0)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNombre_usu());
            ps.setString(2, usu.getUsuario_usu());
            ps.setString(3 ,usu.getPass_usu());
            ps.setString(4, usu.getRol_usu());
            ps.execute();
            return true;
        }catch (SQLException e) {
           System.out.println("Error en el registro "+e.getMessage());
           return false;
        }finally{
            try{
                con.close();

            }catch(SQLException e){
            System.out.println("Error al cerrar "+e.getMessage());
            }         
        }
    }

    @Override
    public boolean actualizarUsuario(Usuario usu) {

            String sql = "Update usuario set  nombre= ? , usuario= ? , contraseña= ? , rol= ? "
                    + " where id_usuario = ? ";
            try{
                    con = cn.getConnection();
                    ps = con.prepareStatement(sql);
                    ps.setString(1, usu.getNombre_usu());
                    ps.setString(2, usu.getUsuario_usu());
                    ps.setString(3 ,usu.getPass_usu());
                    ps.setString(4, usu.getRol_usu());
                    ps.setInt(5, usu.getId_usu());
                    
                    ps.execute();
                   return true;
               }catch (SQLException e) {
                   System.out.println("Error en actualizar "+e.getMessage());
                    return false;
               }finally{
                  try{
                      con.close();

                  }catch(SQLException e){
                  System.out.println("Error al cerrar "+e.getMessage());
                  }

               }
                   
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuario = new ArrayList<>();
        
        String sql  = "select id_usuario, nombre , usuario , contraseña , rol , cod_eliminado , cantidad_venta FROM usuario Where cod_eliminado = 0";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usu(rs.getInt("id_usuario"));
                usuario.setNombre_usu( rs.getString("nombre"));
                usuario.setUsuario_usu( rs.getString("usuario"));
                usuario.setPass_usu(rs.getString("contraseña"));
                usuario.setRol_usu( rs.getString("rol"));
                usuario.setCod_eliminado(rs.getInt("cod_eliminado"));
                usuario.setCantidad_venta(rs.getInt("cantidad_venta"));

                listaUsuario.add(usuario);
            }

            return listaUsuario;  
        }catch(SQLException e){
            System.out.print("Error al obtener usuarios "+e.getMessage());
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
    public boolean eliminarUsuario(int id) {
        String sql = "Update usuario cod_eliminado=1 set where id_usuario = ? ";
            
            try{
             con = cn.getConnection();
             ps=con.prepareStatement(sql);
             ps.setInt(1, id);
             ps.execute();
             return true;
            }catch(SQLException e){
              System.out.println("error al eliminar el Usuario "+e.getMessage());

            return false;
            }finally {
            
                try {
                  con.close();
                }catch(SQLException e){
                    System.out.println("error al cerrrar la conexión "+e.getMessage());
                
                }
            }
    }

    @Override
    public List<Usuario> obtenerUsuarioPorUsuario(String usu) {
        List<Usuario> listaUsuario = new ArrayList<>();
        
        String sql = "select id_usuario, nombre , usuario , contraseña , rol , cod_eliminado , cantidad_venta from usuario where usuario = ? AND cod_eliminado = 0";
        try {                
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usu(rs.getInt("id_usuario"));
                usuario.setNombre_usu( rs.getString("nombre"));
                usuario.setUsuario_usu( rs.getString("usuario"));
                usuario.setPass_usu(rs.getString("contraseña"));
                usuario.setRol_usu( rs.getString("rol"));
                usuario.setCod_eliminado(rs.getInt("cod_eliminado"));
                usuario.setCantidad_venta(rs.getInt("cantidad_venta"));

                
                listaUsuario.add(usuario);
            }
            return listaUsuario;   
        }catch(SQLException e) {
            System.out.println("ERROR EN OBTENER USUARIO" + e.getMessage());
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
    public List<Usuario> obtenerUsuarioPorNombre(String nom) {
        List<Usuario> listaUsuario = new ArrayList<>();
        
        String sql = "select id_usuario, nombre , usuario , contraseña , rol , cod_eliminado , cantidad_venta from usuario where nombre = ? AND cod_eliminado = 0";
        try {                
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usu(rs.getInt("id_usuario"));
                usuario.setNombre_usu( rs.getString("nombre"));
                usuario.setUsuario_usu( rs.getString("usuario"));
                usuario.setPass_usu(rs.getString("contraseña"));
                usuario.setRol_usu( rs.getString("rol"));
                usuario.setCod_eliminado(rs.getInt("cod_eliminado"));
                usuario.setCantidad_venta(rs.getInt("cantidad_venta"));

                
                listaUsuario.add(usuario);
            }
            return listaUsuario;   
        }catch(SQLException e) {
            System.out.println("ERROR EN OBTENER USUARIO por nombre" + e.getMessage());
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
    public List<Usuario> obtenerUsuarioPorId(int id) {
        List<Usuario> listaUsuario = new ArrayList<>();
        String sql = "select id_usuario, nombre , usuario , contraseña , rol , cod_eliminado , cantidad_venta FROM usuario WHERE id_usuario = ? AND cod_eliminado = 0";
        try {                
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usu(rs.getInt("id_usuario"));
                usuario.setNombre_usu( rs.getString("nombre"));
                usuario.setUsuario_usu( rs.getString("usuario"));
                usuario.setPass_usu(rs.getString("contraseña"));
                usuario.setRol_usu( rs.getString("rol"));
                usuario.setCod_eliminado(rs.getInt("cod_eliminado"));
                usuario.setCantidad_venta(rs.getInt("cantidad_venta"));

                
                listaUsuario.add(usuario);
            }
            return listaUsuario;   
        }catch(SQLException e) {
            System.out.println("ERROR EN OBTENER USUARIO por id" + e.getMessage());
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


