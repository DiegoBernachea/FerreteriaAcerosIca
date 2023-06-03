/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Venta;
import java.util.List;

/**
 *
 * @author kmvil
 */
public interface VentaDao {
    public int registrarVenta(Venta ven) ;
    public List listarVentas() ;
    public boolean actualizarVenta(Venta ven) ;
    public boolean eliminarVenta(int id) ;
    public List listarVentasEntreFechas(String FechaInicio, String FechaFin);
}
