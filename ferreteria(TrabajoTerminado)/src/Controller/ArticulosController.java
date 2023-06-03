/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Dao.Impl.ArticuloDaoImpl;
import Dao.Impl.CatDaoImpl;
import Dao.Impl.MarcaDaoImpl;
import Modelo.Articulo;
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
public class ArticulosController {
    Categoria categoria=new Categoria();
    CatDaoImpl categoriadao=new CatDaoImpl();
    List<Categoria> listacategoria= new ArrayList<>();
           
    Marca marca=new Marca();
    MarcaDaoImpl marcadao=new MarcaDaoImpl();
    List<Marca> listamarca= new ArrayList<>();
    
    Articulo articulo=new Articulo();
    ArticuloDaoImpl articulodao=new ArticuloDaoImpl();
    List<Articulo> listaArticulo= new ArrayList<>();
    
    public Map<String, Object>[] ObtenerArticulos(){
        listaArticulo=articulodao.listarArticulos();
            
            Map<String, Object>[] arreglo = new Map[listaArticulo.size()]; 
            int indice = 0; 

            for (Articulo a : listaArticulo) {
                Map<String, Object> map = new HashMap<>();
                map.put("idArticulo", a.getId_ar());
                map.put("nombre", a.getNombre_ar());
                map.put("descripcion", a.getDescrip_ar());
                map.put("categoria", a.getId_cat());  
                map.put("marca", a.getId_mar());
                map.put("codEliminar", a.getCod_eli());
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
    
    public Map<String, Object> ObtenerNombreCategoria(int id){
        listacategoria=categoriadao.obtenerCatPorId(id);
            Map<String, Object> response = new HashMap<>();
            for (Categoria cat : listacategoria) {
               response.put("nomCategoria", cat.getNombre_cat());
            }

        return response;
    }
    public Map<String, Object> ObtenerNombreMarca(int id){
        listamarca=marcadao.obtenerMarcaPorId(id);
            Map<String, Object> response = new HashMap<>();
            for (Marca mar : listamarca) {
               response.put("nomMarca", mar.getNombre_mar());
            }

        return response;
    }
    public  Map<String, Object>[] ObtenerMarcaPorId(int id){
        listamarca=marcadao.obtenerMarcaPorId(id);

            Map<String, Object>[] arreglo = new Map[listamarca.size()]; 
            int indice = 0; 

            for (Marca mar : listamarca) {
                Map<String, Object> map = new HashMap<>();

                map.put("IdMarca", mar.getId_mar());
                map.put("nombre", mar.getId_mar());
                map.put("codEliminar", mar.getCod_eli());
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
    public  Map<String, Object>[] ObtenerCategoriaPorId(int id){
        listacategoria=categoriadao.obtenerCatPorId(id);

            Map<String, Object>[] arreglo = new Map[listacategoria.size()]; 
            int indice = 0; 

            for (Categoria cat : listacategoria) {
                Map<String, Object> map = new HashMap<>();

                map.put("idCategoria", cat.getId_cat());
                map.put("nombre", cat.getNombre_cat());
                map.put("codEliminar", cat.getCod_eli());
         
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
    
    public Map<String, Object>[] ObtenerMarcas(){
        listamarca=marcadao.listarMarcas();

        Map<String, Object>[] arreglo = new Map[listamarca.size()]; 
        int indice = 0; 

        for (Marca mar : listamarca) {
            Map<String, Object> map = new HashMap<>();

            map.put("IdMarca", mar.getId_mar());
            map.put("nombre", mar.getNombre_mar());
            map.put("codEliminar", mar.getCod_eli());
            arreglo[indice] = map;

            indice++;
        }

        return arreglo;
    }
    public Map<String, Object>[] ObtenerCategorias(){
        listacategoria=categoriadao.listarCategorias();
        Map<String, Object>[] arreglo = new Map[listacategoria.size()]; 
        int indice = 0; 

        for (Categoria cat : listacategoria) {
            Map<String, Object> map = new HashMap<>();

            map.put("idCategoria", cat.getId_cat());
            map.put("nombre", cat.getNombre_cat());
            map.put("codEliminar", cat.getCod_eli());

            arreglo[indice] = map;

            indice++;
        }

        return arreglo;
    }
    public boolean registrarArticulo(String nomCat,String nomMar,String nombre, String descripcion){
       listamarca=marcadao.obtenerMarcaPorNombre(nomMar);
       listacategoria=categoriadao.obtenerCatPorNombre(nomCat);
       
       for (Marca mar : listamarca) {
           articulo.setId_mar(mar.getId_mar());
       }
       for (Categoria cat : listacategoria) {
           articulo.setId_cat(cat.getId_cat());
       }
       articulo.setNombre_ar(nombre);
       articulo.setDescrip_ar(descripcion);
       articulo.setCod_eli(0);
       return articulodao.registrarArticulo(articulo);
    } 
    
    public boolean actualizarArticulo(int id, String nomCat,String nomMar,String nombre, String descripcion){
       listamarca=marcadao.obtenerMarcaPorNombre(nomMar);
       listacategoria=categoriadao.obtenerCatPorNombre(nomCat);
       
       for (Marca mar : listamarca) {
           articulo.setId_mar(mar.getId_mar());
       }
       for (Categoria cat : listacategoria) {
           articulo.setId_cat(cat.getId_cat());
       }
       articulo.setId_ar(id);
       articulo.setNombre_ar(nombre);
       articulo.setDescrip_ar(descripcion);
       articulo.setCod_eli(0);
       return articulodao.actualizarArticulo(articulo);
    } 
    
    public boolean EliminaArticulo(int id){

       return articulodao.eliminarArticulo(id);
    } 
}
