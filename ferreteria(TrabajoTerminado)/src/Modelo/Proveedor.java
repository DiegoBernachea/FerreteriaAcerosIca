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
public class Proveedor {
    private int id_pro;
    private String nombre_pro;
    private String RUC_pro;
    private int Telefono_pro;
    private String Direccion_pro;
    private int cod_eli;

    public int getId_pro() {
        return id_pro;
    }

    public String getNombre_pro() {
        return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public String getRUC_pro() {
        return RUC_pro;
    }

    public void setRUC_pro(String RUC_pro) {
        this.RUC_pro = RUC_pro;
    }

    public int getTelefono_pro() {
        return Telefono_pro;
    }

    public void setTelefono_pro(int Telefono_pro) {
        this.Telefono_pro = Telefono_pro;
    }

    public String getDireccion_pro() {
        return Direccion_pro;
    }

    public void setDireccion_pro(String Direccion_pro) {
        this.Direccion_pro = Direccion_pro;
    }

    public int getCod_eli() {
        return cod_eli;
    }

    public void setCod_eli(int cod_eli) {
        this.cod_eli = cod_eli;
    }
    
    
}
