/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.LoginController.usuarioLogueado;
import Dao.Impl.UsuarioDaoImpl;
import Modelo.Proveedor;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
;



/**
 *
 * @author kmvil
 */
public class UsuarioController {
    
    Usuario usuario=new Usuario();
    UsuarioDaoImpl usuariodao=new UsuarioDaoImpl();
    List<Usuario> listaUsuario= new ArrayList<>();
    
    public Map<String, Object>[] ObtenerUsuarios(){
        listaUsuario=usuariodao.listarUsuarios();
            
            Map<String, Object>[] arreglo = new Map[listaUsuario.size()]; 
            int indice = 0; 

            for (Usuario usu : listaUsuario) {
                Map<String, Object> map = new HashMap<>();
                
                map.put("id", usu.getId_usu());
                map.put("nombre", usu.getNombre_usu());
                map.put("usuario", usu.getUsuario_usu());
                map.put("password", usu.getPass_usu());
                map.put("rol", usu.getRol_usu());
                map.put("codEliminado", usu.getCod_eliminado());
                map.put("cantVenta", usu.getCantidad_venta());
                
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }

    
    public boolean registrarUsuario(String nombre,String Usuario,String rol, String Pass){
        
       usuario.setNombre_usu(nombre);
       usuario.setUsuario_usu(Usuario);
       usuario.setPass_usu(Pass);
       usuario.setRol_usu(rol);
       
       return usuariodao.registrarUsuario(usuario);
    } 
    public boolean actualizarUsuario(int id, String nombre,String Usuario,String rol, String Pass){
       usuario.setId_usu(id);
       usuario.setNombre_usu(nombre);
       usuario.setUsuario_usu(Usuario);
       usuario.setPass_usu(Pass);
       usuario.setRol_usu(rol);
       
       return usuariodao.actualizarUsuario(usuario);
    } 
    public boolean EliminarUsuario(int id){

       return usuariodao.eliminarUsuario(id);
    } 
}
