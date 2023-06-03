/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Impl.AlmacenDaoImpl;
import Dao.Impl.ArticuloDaoImpl;
import Dao.Impl.Det_VentaDaoImpl;
import Dao.Impl.ProveedorDaoImpl;
import Dao.Impl.UsuarioDaoImpl;
import Dao.Impl.VentaDaoImpl;
import Modelo.Almacen;
import Modelo.Articulo;
import Modelo.Det_Venta;
import Modelo.Proveedor;
import Modelo.Usuario;
import Modelo.Venta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author kmvil
 */
public class VentaController {
    Venta venta=new Venta();
    VentaDaoImpl ventadao=new VentaDaoImpl();
    List<Venta> listaventa= new ArrayList<>();
    
    Articulo articulo=new Articulo();
    ArticuloDaoImpl articulodao=new ArticuloDaoImpl();
    List<Articulo> listaArticulo= new ArrayList<>();
    
    Usuario usuario=new Usuario();
    UsuarioDaoImpl usuariodao=new UsuarioDaoImpl();
    List<Usuario> listaUsuario= new ArrayList<>();
    
    Proveedor proveedor=new Proveedor();
    ProveedorDaoImpl proveedordao=new ProveedorDaoImpl();
    List<Proveedor> listaProveedor= new ArrayList<>();
    
    Det_Venta detalle=new Det_Venta();
    Det_VentaDaoImpl detallerdao=new Det_VentaDaoImpl();
    List<Det_Venta> listadetalle= new ArrayList<>();
    
    Almacen almacen=new Almacen();
    AlmacenDaoImpl almacendao=new AlmacenDaoImpl();
    List<Almacen> listaAlmacen= new ArrayList<>();
    
    public Map<String, Object>[] ObtenerVentas(){
        listaventa=ventadao.listarVentas();
            
            Map<String, Object>[] arreglo = new Map[listaventa.size()]; 
            int indice = 0; 

            for (Venta ven : listaventa) {
                Map<String, Object> map = new HashMap<>();
                
                map.put("id", ven.getId_vent());
                map.put("idusuario", ven.getId_usu());
                map.put("DNICliente", ven.getDNI_vent());
                map.put("NomCliente", ven.getNombre_vent());
                map.put("MetodoPago", ven.getMetodo_pago());
                map.put("fecha", ven.getFecha_vent());
                map.put("total", ven.getTotal());
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }

    
    public int registrarVenta(int idusuario,int DNI,String nombre,String MetodoPago, String fecha , float total){
       venta.setId_usu(idusuario);
       venta.setDNI_vent(DNI);
       venta.setNombre_vent(nombre);
       venta.setMetodo_pago(MetodoPago);
       venta.setFecha_vent(fecha);
       venta.setTotal(total);
       return ventadao.registrarVenta(venta);
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
    
    public Map<String, Object>[] ObtenerDetallePorIdVenta(int idventa){
        listadetalle=detallerdao.obtenerDetVentaPorIdVenta(idventa);
            
            Map<String, Object>[] arreglo = new Map[listadetalle.size()]; 
            int indice = 0; 

            for (Det_Venta detVenta : listadetalle) {
                Map<String, Object> map = new HashMap<>();
                
                map.put("idArticulo", detVenta.getId_ar());
                map.put("Cantidad", detVenta.getCantidad_vent());
                map.put("subTotal", detVenta.getTotalsub());
                
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
    
    public boolean registrarDetalleVenta(int idventa, String articuloNombre,int cantidad, float subtotal){
        detalle.setId_vent(idventa);
        Map<String, Object>[] arreglo=ObtenerArticuloPorNombre(articuloNombre);
        detalle.setId_ar(Integer.parseInt(arreglo[0].get("idArticulo").toString()));
        detalle.setCantidad_vent(cantidad);
        detalle.setTotalsub(subtotal);
        return detallerdao.registrarDetVenta(detalle);
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
    public  Map<String, Object>[] ObtenerAlmacenPorIdArticulo(int id){
        listaAlmacen=almacendao.ObtenerAlmacenPorIdArticulo(id);

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
    

    
}

