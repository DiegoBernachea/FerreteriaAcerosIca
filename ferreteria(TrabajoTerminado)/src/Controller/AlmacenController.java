/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Impl.AlmacenDaoImpl;
import Dao.Impl.ArticuloDaoImpl;
import Modelo.Almacen;
import Modelo.Articulo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kmvil
 */
public class AlmacenController {
    
    Almacen almacen=new Almacen();
    AlmacenDaoImpl almacendao=new AlmacenDaoImpl();
    List<Almacen> listaAlmacen= new ArrayList<>();
            
    Articulo articulo=new Articulo();
    ArticuloDaoImpl articulodao=new ArticuloDaoImpl();
    List<Articulo> listaArticulo= new ArrayList<>();
    
    public Map<String, Object>[] ObtenerAlmacenes(){
        listaAlmacen=almacendao.listarAlmacen();
            
            Map<String, Object>[] arreglo = new Map[listaAlmacen.size()]; 
            int indice = 0; 

            for (Almacen a : listaAlmacen) {
                Map<String, Object> map = new HashMap<>();

                map.put("idAlmacen", a.getId_al());
                map.put("idArticulo", a.getId_ar());
                map.put("precio", a.getPrecio());
                map.put("stock", a.getStock());

                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
    
    public Map<String, Object> ObtenerNombreArticulo(int id){
        listaArticulo=articulodao.obtenerArticuloPorId(id);
            Map<String, Object> response = new HashMap<>();
            for (Articulo a : listaArticulo) {
               response.put("nomArticulo", a.getNombre_ar());
            }

        return response;
    }
    
    public  Map<String, Object>[] ObtenerArticuloPorId(int id){
        listaArticulo=articulodao.obtenerArticuloPorId(id);

            Map<String, Object>[] arreglo = new Map[listaArticulo.size()]; 
            int indice = 0; 

            for (Articulo a : listaArticulo) {
                Map<String, Object> map = new HashMap<>();

                map.put("idArticulo", a.getId_ar());
                map.put("idCategoria", a.getId_cat());
                map.put("marca", a.getId_mar());
                map.put("nombre", a.getNombre_ar());
                map.put("descripcion", a.getDescrip_ar());
                map.put("codElimar", a.getCod_eli());
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
    
    public Map<String, Object>[] ObtenerArticulos(){
        listaArticulo=articulodao.listarArticulos();

            Map<String, Object>[] arreglo = new Map[listaArticulo.size()]; 
            int indice = 0; 

            for (Articulo a : listaArticulo) {
                Map<String, Object> map = new HashMap<>();

                map.put("idArticulo", a.getId_ar());
                map.put("idCategoria", a.getId_cat());
                map.put("marca", a.getId_mar());
                map.put("nombre", a.getNombre_ar());
                map.put("descripcion", a.getDescrip_ar());
                map.put("codElimar", a.getCod_eli());
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
    
    public boolean registrarAlmacen(String nomArticulo,float precio, int stock){
       listaArticulo=articulodao.obtenerArticuloPorNombre(nomArticulo);
       for (Articulo a : listaArticulo) {
           almacen.setId_ar(a.getId_ar());
       }
       almacen.setPrecio(precio);
       almacen.setStock(stock);
       return almacendao.registrarAlmacen(almacen);
    } 
    public boolean actualizarAlmacen(int id, String nomArticulo,float precio, int stock){
       listaArticulo=articulodao.obtenerArticuloPorNombre(nomArticulo);
       for (Articulo a : listaArticulo) {
           almacen.setId_ar(a.getId_ar());
       }
       almacen.setId_al(id);
       almacen.setPrecio(precio);
       almacen.setStock(stock);
       return almacendao.actualizarAlmacen(almacen);
    } 
    public boolean EliminarAlmace(int id){

       return almacendao.eliminarAlmacen(id);
    } 
}
