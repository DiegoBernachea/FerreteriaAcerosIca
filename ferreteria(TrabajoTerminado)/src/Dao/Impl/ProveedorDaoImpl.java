/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Impl;

import Dao.Conexion;
import Dao.ProveedorDao;
import Modelo.Proveedor;
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
public class ProveedorDaoImpl implements ProveedorDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    @Override
    public boolean registrarProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO Proveedor (id_proveedor, Nombre_pro, RUC, Telefono, Direccion, cod_eliminado) VALUES (NULL,?,?,?,?,0)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,proveedor.getNombre_pro());
            ps.setString(2, proveedor.getRUC_pro());
            ps.setInt(3, proveedor.getTelefono_pro());
            ps.setString(4, proveedor.getDireccion_pro());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en el registro del proveedor: " + e.getMessage());
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
    public List<Proveedor> listarProveedores() {
        List<Proveedor> listaProveedores = new ArrayList<>();
        String sql = "SELECT id_proveedor, Nombre_pro, RUC, Telefono, Direccion, cod_eliminado FROM Proveedor WHERE cod_eliminado=0";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_pro(rs.getInt("id_proveedor"));
                proveedor.setNombre_pro(rs.getString("Nombre_pro"));
                proveedor.setRUC_pro(rs.getString("RUC"));
                proveedor.setTelefono_pro(rs.getInt("Telefono"));
                proveedor.setDireccion_pro(rs.getString("Direccion"));
                proveedor.setCod_eli(rs.getInt("cod_eliminado"));
                listaProveedores.add(proveedor);
            }
            return listaProveedores;
        } catch (SQLException e) {
            System.out.println("Error al listar proveedores: " + e.getMessage());
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
    public boolean actualizarProveedor(Proveedor proveedor) {
        String sql = "UPDATE Proveedor SET Nombre_pro=?, RUC=?, Telefono=?, Direccion=? WHERE id_proveedor=? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, proveedor.getNombre_pro());
            ps.setString(2, proveedor.getRUC_pro());
            ps.setInt(3, proveedor.getTelefono_pro());
            ps.setString(4, proveedor.getDireccion_pro());
            ps.setInt(5, proveedor.getId_pro());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar proveedor: " + e.getMessage());
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
    public boolean eliminarProveedor(int id) {
        String sql = "UPDATE Proveedor SET cod_eliminado=1 WHERE id_proveedor=?";
        try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.execute();
                return true;
            } catch (SQLException e) {
                System.out.println("Error al eliminar proveedor: " + e.getMessage());
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
    public List obtenerProveedorPorNombre(String nom) {
        String sql = "SELECT * FROM proveedor WHERE Nombre_pro = ? AND cod_eliminado=0";
        List<Proveedor> listaProveedores = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_pro(rs.getInt("id_proveedor"));
                proveedor.setNombre_pro(rs.getString("Nombre_pro"));
                proveedor.setRUC_pro(rs.getString("RUC"));
                proveedor.setTelefono_pro(rs.getInt("Telefono"));
                proveedor.setDireccion_pro(rs.getString("Direccion"));
                proveedor.setCod_eli(rs.getInt("cod_eliminado"));
                listaProveedores.add(proveedor);
            }
            return listaProveedores;
        } catch (SQLException e) {
            System.out.println("Error al obtenerProveedorPorNombre: " + e.getMessage());
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
    public List<Proveedor> obtenerProveedorPorId(int id) {
        String sql = "SELECT id_proveedor, Nombre_pro, RUC, Telefono, Direccion, cod_eliminado FROM Proveedor WHERE id_proveedor = ? ";
        List<Proveedor> listaProveedores = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_pro(rs.getInt("id_proveedor"));
                proveedor.setNombre_pro(rs.getString("Nombre_pro"));
                proveedor.setRUC_pro(rs.getString("RUC"));
                proveedor.setTelefono_pro(rs.getInt("Telefono"));
                proveedor.setDireccion_pro(rs.getString("Direccion"));
                proveedor.setCod_eli(rs.getInt("cod_eliminado"));
                listaProveedores.add(proveedor);
            }
            return listaProveedores;
        } catch (SQLException e) {
            System.out.println("Error al obtenerProveedorPorid: " + e.getMessage());
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

