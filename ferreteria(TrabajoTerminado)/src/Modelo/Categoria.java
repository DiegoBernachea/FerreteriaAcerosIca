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
public class Categoria {
    private int id_cat;
    private String Nombre_cat;
    private int cod_eli;

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getNombre_cat() {
        return Nombre_cat;
    }

    public void setNombre_cat(String Nombre_cat) {
        this.Nombre_cat = Nombre_cat;
    }

    public int getCod_eli() {
        return cod_eli;
    }

    public void setCod_eli(int cod_eli) {
        this.cod_eli = cod_eli;
    }
    
    
}
