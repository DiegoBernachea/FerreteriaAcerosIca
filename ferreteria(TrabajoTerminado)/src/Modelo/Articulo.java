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
public class Articulo {
    private int id_ar;
    private String Nombre_ar;
    private String Descrip_ar;
    private int id_cat;
    private int id_mar;
    private int cod_eli;

    public int getId_ar() {
        return id_ar;
    }

    public void setId_ar(int id_ar) {
        this.id_ar = id_ar;
    }

    public String getNombre_ar() {
        return Nombre_ar;
    }

    public void setNombre_ar(String Nombre_ar) {
        this.Nombre_ar = Nombre_ar;
    }

    public String getDescrip_ar() {
        return Descrip_ar;
    }

    public void setDescrip_ar(String Descrip_ar) {
        this.Descrip_ar = Descrip_ar;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public int getId_mar() {
        return id_mar;
    }

    public void setId_mar(int id_mar) {
        this.id_mar = id_mar;
    }

    public int getCod_eli() {
        return cod_eli;
    }

    public void setCod_eli(int cod_eli) {
        this.cod_eli = cod_eli;
    }
    
    
}
