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
public class Det_Venta {
    private int id_det_vent;
    private int id_vent;
    private int id_ar;
    private int cantidad_vent;
    private float totalsub;
    private String nombre_ar;

    public String getNombre_ar() {
        return nombre_ar;
    }

    public void setNombre_ar(String nombre_ar) {
        this.nombre_ar = nombre_ar;
    }
    
    

    public int getId_det_vent() {
        return id_det_vent;
    }

    public void setId_det_vent(int id_det_vent) {
        this.id_det_vent = id_det_vent;
    }

    public int getId_vent() {
        return id_vent;
    }

    public void setId_vent(int id_vent) {
        this.id_vent = id_vent;
    }

    public int getId_ar() {
        return id_ar;
    }

    public void setId_ar(int id_ar) {
        this.id_ar = id_ar;
    }

    public int getCantidad_vent() {
        return cantidad_vent;
    }

    public void setCantidad_vent(int cantidad_vent) {
        this.cantidad_vent = cantidad_vent;
    }

    public float getTotalsub() {
        return totalsub;
    }

    public void setTotalsub(float totalsub) {
        this.totalsub = totalsub;
    }
    
    
}
