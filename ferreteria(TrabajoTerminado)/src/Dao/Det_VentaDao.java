/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Det_Venta;
import java.util.List;

/**
 *
 * @author kmvil
 */
public interface Det_VentaDao {
    public boolean registrarDetVenta(Det_Venta detVen) ;
    public List listarDetVentas() ;
    public boolean actualizarDetVenta(Det_Venta detVen) ;
    public boolean eliminarDetVenta(int id) ;
    public List obtenerDetVentaPorIdVenta(int id);
}
