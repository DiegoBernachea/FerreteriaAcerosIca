/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Impl.ArticuloDaoImpl;
import Dao.Impl.CompraDaoImpl;
import Dao.Impl.Det_CompraDaoImpl;
import Dao.Impl.ProveedorDaoImpl;
import Dao.Impl.UsuarioDaoImpl;
import Modelo.Articulo;
import Modelo.Compra;
import Modelo.Det_Compra;
import Modelo.Proveedor;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kmvil
 */
public class CompraController {
    Compra compra=new Compra();
    CompraDaoImpl compradao=new CompraDaoImpl();
    List<Compra> listaCompra= new ArrayList<>();
    
    Articulo articulo=new Articulo();
    ArticuloDaoImpl articulodao=new ArticuloDaoImpl();
    List<Articulo> listaArticulo= new ArrayList<>();
    
    Usuario usuario=new Usuario();
    UsuarioDaoImpl usuariodao=new UsuarioDaoImpl();
    List<Usuario> listaUsuario= new ArrayList<>();
    
    Proveedor proveedor=new Proveedor();
    ProveedorDaoImpl proveedordao=new ProveedorDaoImpl();
    List<Proveedor> listaProveedor= new ArrayList<>();
    
    Det_Compra detalle=new Det_Compra();
    Det_CompraDaoImpl detallerdao=new Det_CompraDaoImpl();
    List<Det_Compra> listadetalle= new ArrayList<>();
    
    public Map<String, Object>[] ObtenerCompras(){
        listaCompra=compradao.listarCompras();
            
            Map<String, Object>[] arreglo = new Map[listaCompra.size()]; 
            int indice = 0; 

            for (Compra com : listaCompra) {
                Map<String, Object> map = new HashMap<>();
                
                map.put("id", com.getId_com());
                map.put("idProveedor", com.getId_pro());
                map.put("idUsuario", com.getId_usu());
                map.put("fecha", com.getFecha_com());
                map.put("total", com.getTotal());
                
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }

    
    public int registrarCompra(String proveedor,int idUsuario,String fecha, float total){
       Map<String, Object>[] arreglopv=ObtenerPorveedorPorNombre(proveedor);
       compra.setId_pro(Integer.parseInt(arreglopv[0].get("id").toString()));
       compra.setId_usu(idUsuario);
       compra.setFecha_com(fecha);
       compra.setTotal(total);
       
       return compradao.registrarCompra(compra);
    } 
   /*public boolean actualizarCompra(){}*/
   /*public boolean EliminarCompra(){ }*/

    
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
     
    
    public Map<String, Object>[] ObtenerProveedores(){
        listaProveedor=proveedordao.listarProveedores();
            
            Map<String, Object>[] arreglo = new Map[listaProveedor.size()]; 
            int indice = 0; 

            for (Proveedor pv : listaProveedor) {
                Map<String, Object> map = new HashMap<>();

                map.put("id", pv.getId_pro());
                map.put("nombre", pv.getNombre_pro());
                map.put("ruc", pv.getRUC_pro());
                map.put("telefono", pv.getTelefono_pro());
                map.put("direccion", pv.getDireccion_pro());
                map.put("codEliminar", pv.getCod_eli());
                
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
    
    public Map<String, Object> ObtenerNombreUsuario(int id){
        listaUsuario=usuariodao.obtenerUsuarioPorId(id);
            Map<String, Object> response = new HashMap<>();
            for (Usuario usu : listaUsuario) {
               response.put("usuUsuario", usu.getUsuario_usu());
            }

        return response;
    }
    
    public Map<String, Object> ObtenerNombreProveedor(int id){
        listaProveedor=proveedordao.obtenerProveedorPorId(id);
            Map<String, Object> response = new HashMap<>();
            for (Proveedor a : listaProveedor) {
               response.put("nomProveedor", a.getNombre_pro());
            }

        return response;
    }
    
    public Map<String, Object>[] ObtenerDetallePorIdCompra(int idcompra){
        listadetalle=detallerdao.obtenerDetCompraPorIdCompra(idcompra);
            
            Map<String, Object>[] arreglo = new Map[listadetalle.size()]; 
            int indice = 0; 

            for (Det_Compra detCom : listadetalle) {
                Map<String, Object> map = new HashMap<>();
                
                map.put("idArticulo", detCom.getId_ar());
                map.put("Cantidad", detCom.getCantidad_com());
                map.put("subTotal", detCom.getPrecio());
                
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
    
    public boolean registrarDetallecompra(int idcompra, String articuloNombre,int cantidad, float subtotal){
        detalle.setId_com(idcompra);
        Map<String, Object>[] arreglo=ObtenerArticuloPorNombre(articuloNombre);
        detalle.setId_ar(Integer.parseInt(arreglo[0].get("idArticulo").toString()));
        detalle.setCantidad_com(cantidad);
        detalle.setPrecio(subtotal);
        return detallerdao.registrarDetCompra(detalle);
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
    
    public  Map<String, Object>[] ObtenerArticuloPorNombre(String nom){
        listaArticulo=articulodao.obtenerArticuloPorNombre(nom);

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
    public  Map<String, Object>[] ObtenerPorveedorPorNombre(String nom){
            listaProveedor=proveedordao.obtenerProveedorPorNombre(nom);

                Map<String, Object>[] arreglo = new Map[listaProveedor.size()]; 
            int indice = 0; 

            for (Proveedor pv : listaProveedor) {
                Map<String, Object> map = new HashMap<>();

                map.put("id", pv.getId_pro());
                map.put("nombre", pv.getNombre_pro());
                map.put("ruc", pv.getRUC_pro());
                map.put("telefono", pv.getTelefono_pro());
                map.put("direccion", pv.getDireccion_pro());
                map.put("codEliminar", pv.getCod_eli());
                
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }    
}
