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
public class Venta {
    private int id_vent;
    private int id_usu;
    private int DNI_vent;
    private String nombre_vent;
    private String metodo_pago;
    private String fecha_vent;
    private float total;

    
    public int getId_vent() {
        return id_vent;
    }

    public void setId_vent(int id_vent) {
        this.id_vent = id_vent;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public int getDNI_vent() {
        return DNI_vent;
    }

    public void setDNI_vent(int DNI_vent) {
        this.DNI_vent = DNI_vent;
    }

    public String getNombre_vent() {
        return nombre_vent;
    }

    public void setNombre_vent(String nombre_vent) {
        this.nombre_vent = nombre_vent;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getFecha_vent() {
        return fecha_vent;
    }

    public void setFecha_vent(String fecha_vent) {
        this.fecha_vent = fecha_vent;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
    
}
