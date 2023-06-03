/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author kmvil
 */
public interface UsuarioDao {   
    
    public List listarUsuarios();
    public List<Usuario> obtenerUsuarioPorUsuario(String usu);
    public boolean registrarUsuario (Usuario usu);
    public boolean actualizarUsuario (Usuario usu);
    public boolean eliminarUsuario (int id); 
    public List<Usuario> obtenerUsuarioPorNombre(String nom) ;
    public List<Usuario> obtenerUsuarioPorId(int id) ;
}
