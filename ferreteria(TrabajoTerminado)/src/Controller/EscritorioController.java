/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.Impl.ArticuloDaoImpl;
import Dao.Impl.ProveedorDaoImpl;
import Dao.Impl.VentaDaoImpl;
import Modelo.Articulo;
import Modelo.Proveedor;
import Modelo.Venta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author enriq
 */
public class EscritorioController {
    ArticuloDaoImpl articuloDaoImpl= new ArticuloDaoImpl();
    List<Articulo> listaArticulo = new ArrayList<>();
    
    ProveedorDaoImpl proveedorDaoImpl= new ProveedorDaoImpl();
    List<Proveedor> listaProveedor = new ArrayList<>();
    
    VentaDaoImpl ventaDaoDaoImpl= new VentaDaoImpl();
    List<Venta> listaVenta = new ArrayList<>();
    Map<String, Object> response = new HashMap<>();
    
    public Map<String, Object> TotalArticulos(){
        listaArticulo=articuloDaoImpl.listarArticulos();
        response.put("Cantidad", listaArticulo.size());
        
        return response;
    }
    public Map<String, Object> TotalProveedores(){
        listaProveedor=proveedorDaoImpl.listarProveedores();
        response.put("Cantidad", listaProveedor.size());
        
        return response;
    }
    public Map<String, Object> TotalIngresos(){
        listaVenta=ventaDaoDaoImpl.listarVentas();
        double recaudacion=0;
        for(Venta vt: listaVenta){
            recaudacion+=vt.getTotal();
        }
         double ingreso=Math.round(recaudacion * 100.0) / 100.0;
        response.put("Total", "S/"+ingreso);
        
        return response;
    }
}
