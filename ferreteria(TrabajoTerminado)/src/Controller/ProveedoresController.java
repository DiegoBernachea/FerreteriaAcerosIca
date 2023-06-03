/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Impl.ProveedorDaoImpl;
import Modelo.Proveedor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kmvil
 */
public class ProveedoresController {
            
    Proveedor proveedor=new Proveedor();
    ProveedorDaoImpl proveedordao=new ProveedorDaoImpl();
    List<Proveedor> listaProveedor= new ArrayList<>();
    
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

    
    public boolean registrarProveedor(String nombre,String ruc, String telefono, String direccion){
        
       proveedor.setNombre_pro(nombre);
       proveedor.setRUC_pro(ruc);
       proveedor.setTelefono_pro(Integer.parseInt(telefono));
       proveedor.setDireccion_pro(direccion);
       return proveedordao.registrarProveedor(proveedor);
    } 
    public boolean actualizarProveedor(int id, String nombre,String ruc, String telefono, String direccion){
       proveedor.setId_pro(id);
       proveedor.setNombre_pro(nombre);
       proveedor.setRUC_pro(ruc);
       proveedor.setTelefono_pro(Integer.parseInt(telefono));
       proveedor.setDireccion_pro(direccion);
       
       return proveedordao.actualizarProveedor(proveedor);
    } 
    public boolean EliminarProveedor(int id){

       return proveedordao.eliminarProveedor(id);
    } 
}
