/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Articulo;
import java.util.List;

/**
 *
 * @author kmvil
 */
public interface ArticuloDao {
    public boolean registrarArticulo(Articulo art);
    public List listarArticulos() ;
    public boolean actualizarArticulo(Articulo art) ;
    public boolean eliminarArticulo(int id) ;
    public List<Articulo> obtenerArticuloPorNombre(String nom);
    public List<Articulo> obtenerArticuloPorId(int id);
}
