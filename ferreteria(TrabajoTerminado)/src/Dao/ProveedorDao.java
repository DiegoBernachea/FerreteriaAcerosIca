/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Proveedor;
import java.util.List;

/**
 *
 * @author kmvil
 */
public interface ProveedorDao {
    public boolean registrarProveedor(Proveedor pv) ;
    public List listarProveedores() ;
    public boolean actualizarProveedor(Proveedor pv) ;
    public boolean eliminarProveedor(int id) ;
    public List<Proveedor> obtenerProveedorPorNombre(String nom) ;
    public List<Proveedor> obtenerProveedorPorId(int id) ;
}
