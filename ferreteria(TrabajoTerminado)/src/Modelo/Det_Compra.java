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
public class Det_Compra {
    private int id_det_com;
    private int id_com;
    private int id_ar;
    private int cantidad_com;
    private float precio;

    public int getId_det_com() {
        return id_det_com;
    }

    public void setId_det_com(int id_det_com) {
        this.id_det_com = id_det_com;
    }

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public int getId_ar() {
        return id_ar;
    }

    public void setId_ar(int id_ar) {
        this.id_ar = id_ar;
    }

    public int getCantidad_com() {
        return cantidad_com;
    }

    public void setCantidad_com(int cantidad_com) {
        this.cantidad_com = cantidad_com;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
