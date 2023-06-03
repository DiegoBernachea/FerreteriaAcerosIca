/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Marca;
import java.util.List;

/**
 *
 * @author kmvil
 */
public interface MarcaDao {
    public boolean registrarMarca(Marca mar) ;
    public List listarMarcas() ;
    public boolean actualizarMarca(Marca mar) ;
    public boolean eliminarMarca(int id) ;
    public List<Marca> obtenerMarcaPorNombre(String nom);
    public List<Marca> obtenerMarcaPorId(int id);
}
