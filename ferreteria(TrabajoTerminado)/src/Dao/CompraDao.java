/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Compra;
import java.util.List;

/**
 *
 * @author kmvil
 */
public interface CompraDao {
    public int registrarCompra(Compra com);
    public List listarCompras();
    public boolean actualizarCompra(Compra com);
    public boolean eliminarCompra(int id);
    public List listarComprasEntreFechas(String FechaInicio, String FechaFin);
}
