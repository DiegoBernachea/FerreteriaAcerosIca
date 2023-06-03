/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Impl.CatDaoImpl;
import Dao.Impl.MarcaDaoImpl;
import Modelo.Categoria;
import Modelo.Marca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kmvil
 */
public class CatMarController {
    
    Categoria categoria=new Categoria();
    CatDaoImpl categoriadao=new CatDaoImpl();
    List<Categoria> listacategoria= new ArrayList<>();
           
    Marca marca=new Marca();
    MarcaDaoImpl marcadao=new MarcaDaoImpl();
    List<Marca> listamarca= new ArrayList<>();
    
    public Map<String, Object>[] ObtenerMarcas(){
        listamarca=marcadao.listarMarcas();

        Map<String, Object>[] arreglo = new Map[listamarca.size()]; 
        int indice = 0; 

        for (Marca mar : listamarca) {
            Map<String, Object> map = new HashMap<>();

            map.put("id", mar.getId_mar());
            map.put("nombre", mar.getNombre_mar());
            map.put("codEliminar", mar.getCod_eli());
            arreglo[indice] = map;

            indice++;
        }

        return arreglo;
    }
    
    public boolean registrarMarca(String nombre){
       marca.setNombre_mar(nombre);
       return marcadao.registrarMarca(marca);
    } 
    
    public boolean actualizarMarca(int id, String nombre){
        marca.setNombre_mar(nombre);
        marca.setId_mar(id);
       return marcadao.actualizarMarca(marca);
       
    } 
    
    public boolean EliminarMarca(int id){

       return marcadao.eliminarMarca(id);
    } 
    
    public Map<String, Object>[] ObtenerCategorias(){
        listacategoria=categoriadao.listarCategorias();
        Map<String, Object>[] arreglo = new Map[listacategoria.size()]; 
        int indice = 0; 

        for (Categoria cat : listacategoria) {
            Map<String, Object> map = new HashMap<>();

            map.put("id", cat.getId_cat());
            map.put("nombre", cat.getNombre_cat());
            map.put("codEliminar", cat.getCod_eli());

            arreglo[indice] = map;

            indice++;
        }

        return arreglo;
    }
    public boolean registrarCategoria(String nombre){
       categoria.setNombre_cat(nombre);
       return categoriadao.registrarCategoria(categoria);
    } 
    
    public boolean actualizarCategoria(int id, String nombre){
       categoria.setNombre_cat(nombre);
       categoria.setId_cat(id);
       return categoriadao.actualizarCategoria(categoria);
    } 
    
    public boolean EliminarCategoria(int id){

       return categoriadao.eliminarCategoria(id);
    } 
}
