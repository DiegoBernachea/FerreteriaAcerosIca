/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.Impl.UsuarioDaoImpl;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author enriq
 */
public class LoginController {
    
    public static Usuario usuarioLogueado;
    
    Usuario usuario = new Usuario();
    UsuarioDaoImpl usuarioDaoImpl= new UsuarioDaoImpl();
    List<Usuario> listaUsuario = new ArrayList<>();
    Map<String, Object> response = new HashMap<>();
   
    public Map<String, Object> LoguearUsuario(String usu, String pass){
        listaUsuario=usuarioDaoImpl.obtenerUsuarioPorUsuario(usu);
        if(!listaUsuario.isEmpty()){
            for (Usuario u : listaUsuario) {
                usuario.setId_usu(u.getId_usu());
                usuario.setNombre_usu(u.getNombre_usu());
                usuario.setUsuario_usu(u.getUsuario_usu());
                usuario.setPass_usu(u.getPass_usu());
                usuario.setRol_usu(u.getRol_usu());
                usuario.setCod_eliminado(u.getCod_eliminado());
                usuario.setCantidad_venta(u.getCantidad_venta());
            }
            if(pass.equals(usuario.getPass_usu())){
                usuarioLogueado=usuario;
                response.put("success", true);
                response.put("message", usuarioLogueado.getRol_usu());
            }
            else{
                response.put("success", false);
                response.put("message", "La contraseña es incorrecta");
            }
        }
        else{
            response.put("success", false);
            response.put("message", "El usuario no existe");
        }
        return response;
    }
    public Map<String, Object> obtenerUsuarioLogueado(){
       response.put("id", usuarioLogueado.getId_usu());
       response.put("nombre", usuarioLogueado.getNombre_usu());
       response.put("usuario", usuarioLogueado.getUsuario_usu());
       response.put("password", usuarioLogueado.getPass_usu());
       response.put("rol", usuarioLogueado.getRol_usu());
       response.put("codEliminado", usuarioLogueado.getCod_eliminado());
       response.put("cantVenta", usuarioLogueado.getCantidad_venta());
       
       return response;
    }
     public void ActualizarSesionUsuario(){
        listaUsuario=usuarioDaoImpl.obtenerUsuarioPorId(usuarioLogueado.getId_usu());
            for (Usuario u : listaUsuario) {
                usuario.setId_usu(u.getId_usu());
                usuario.setNombre_usu(u.getNombre_usu());
                usuario.setUsuario_usu(u.getUsuario_usu());
                usuario.setPass_usu(u.getPass_usu());
                usuario.setRol_usu(u.getRol_usu());
                usuario.setCod_eliminado(u.getCod_eliminado());
                usuario.setCantidad_venta(u.getCantidad_venta());
            }
        usuarioLogueado=usuario;
     }
}
