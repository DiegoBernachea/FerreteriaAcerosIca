/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Det_Compra;
import java.util.List;

/**
 *
 * @author kmvil
 */
public interface Det_CompraDao {
   public boolean registrarDetCompra(Det_Compra detCom);
   public List listarDetCompras();
   public boolean actualizarDetCompra(Det_Compra detCom);
   public boolean eliminarDetCompra(int id);
   public List obtenerDetCompraPorIdCompra(int id);
}
