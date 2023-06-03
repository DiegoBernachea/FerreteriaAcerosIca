/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Categoria;
import java.util.List;

/**
 *
 * @author kmvil
 */
public interface CategoriaDao {
    public boolean registrarCategoria(Categoria cat) ;
    public List listarCategorias();
    public boolean actualizarCategoria(Categoria cat) ;
    public boolean eliminarCategoria(int id) ;
    public List<Categoria> obtenerCatPorNombre(String nom) ;
    public List<Categoria> obtenerCatPorId(int id) ;
}
