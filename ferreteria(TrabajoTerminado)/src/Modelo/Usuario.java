/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author kmvil
 */
public class Usuario {
    private int id_usu;
    private String Nombre_usu;
    private String Usuario_usu;
    private String Pass_usu;
    private String Rol_usu;
    private int Cod_eliminado;
    private int cantidad_venta;

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public String getNombre_usu() {
        return Nombre_usu;
    }

    public void setNombre_usu(String Nombre_usu) {
        this.Nombre_usu = Nombre_usu;
    }

    public String getUsuario_usu() {
        return Usuario_usu;
    }

    public void setUsuario_usu(String Usuario_usu) {
        this.Usuario_usu = Usuario_usu;
    }

    public String getPass_usu() {
        return Pass_usu;
    }

    public void setPass_usu(String Pass_usu) {
        this.Pass_usu = Pass_usu;
    }

    public String getRol_usu() {
        return Rol_usu;
    }

    public void setRol_usu(String Rol_usu) {
        this.Rol_usu = Rol_usu;
    }

    public int getCod_eliminado() {
        return Cod_eliminado;
    }

    public void setCod_eliminado(int Cod_eliminado) {
        this.Cod_eliminado = Cod_eliminado;
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }




    
}
