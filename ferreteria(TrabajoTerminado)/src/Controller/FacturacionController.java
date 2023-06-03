/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Impl.ArticuloDaoImpl;
import Dao.Impl.Det_VentaDaoImpl;
import Dao.Impl.VentaDaoImpl;
import Modelo.Articulo;
import Modelo.Det_Venta;
import Modelo.Venta;
import Vista.panelFacturacion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.FacturacionPDF;

/**
 *
 * @author kmvil
 */
public class FacturacionController {
    int id_venta;
    String nombreCliente;
    String dniCliente;
    String fechaVenta;
    String totalVenta;
    
    FacturacionPDF facturacionpdf = new FacturacionPDF();
    panelFacturacion facturacionView;
    
    Venta venta=new Venta();
    VentaDaoImpl ventadao=new VentaDaoImpl();
    List<Venta> listaventa= new ArrayList<>();
    
    Det_Venta detalle=new Det_Venta();
    Det_VentaDaoImpl detallerdao=new Det_VentaDaoImpl();
    List<Det_Venta> listadetalle= new ArrayList<>();
    
    Articulo articulo=new Articulo();
    ArticuloDaoImpl articulodao=new ArticuloDaoImpl();
    List<Articulo> listaArticulo= new ArrayList<>();
    
    public Map<String, Object>[] ObtenerVentas(){
        listaventa=ventadao.listarVentas();
            
            Map<String, Object>[] arreglo = new Map[listaventa.size()]; 
            int indice = 0; 

            for (Venta ven : listaventa) {
                Map<String, Object> map = new HashMap<>();
                
                map.put("id", ven.getId_vent());
                map.put("idusuario", ven.getId_usu());
                map.put("DNICliente", ven.getDNI_vent());
                map.put("NomCliente", ven.getNombre_vent());
                map.put("MetodoPago", ven.getMetodo_pago());
                map.put("fecha", ven.getFecha_vent());
                map.put("total", ven.getTotal());
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
    public  Map<String, Object>[] ObtenerArticuloPorId(int id){
        listaArticulo=articulodao.obtenerArticuloPorId(id);

            Map<String, Object>[] arreglo = new Map[listaArticulo.size()]; 
            int indice = 0; 

            for (Articulo a : listaArticulo) {
                Map<String, Object> map = new HashMap<>();

                map.put("idArticulo", a.getId_ar());
                map.put("idCategoria", a.getId_cat());
                map.put("marca", a.getId_mar());
                map.put("nombre", a.getNombre_ar());
                map.put("descripcion", a.getDescrip_ar());
                map.put("codElimar", a.getCod_eli());
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
    public void generarFacturaCompra() {
        
        int idVenta = id_venta;
        int dniClienteInt = Integer.parseInt(dniCliente);
        float totalVentaFloat = Float.parseFloat(totalVenta);
        listadetalle = detallerdao.obtenerDetVentaPorIdVenta(idVenta);

        // Construir el mapa de detalles de venta
        Map<Integer, Map<String, Object>> detallesMap = new HashMap<>();
        for (Det_Venta detventa : listadetalle) {
            int idDetVenta = detventa.getId_det_vent();
            int cantidadVendida = detventa.getCantidad_vent();
            Map<String, Object>[] nomProducto=ObtenerArticuloPorId(detventa.getId_ar());
            String nombreProducto = nomProducto[0].get("nombre").toString();
            float subtotal = detventa.getTotalsub();

            Map<String, Object> detalleMap = new HashMap<>();
            detalleMap.put("cantidad", cantidadVendida);
            detalleMap.put("nombreProducto", nombreProducto);
            detalleMap.put("subtotal", subtotal);

            detallesMap.put(idDetVenta, detalleMap);
        }

        // Llamar al método de generación de la factura de compra en la utilidad
        facturacionpdf.generarFacturaCompra(idVenta, nombreCliente, dniClienteInt, fechaVenta, detallesMap, totalVentaFloat);
    }
    public void guardarDatosSeleccionados(int filaSeleccionada) {
        facturacionView = new panelFacturacion();
        if (filaSeleccionada != -1) {
            Object idVentaObj = facturacionView.getValueAt(filaSeleccionada, 0);
            //System.out.println(idVentaObj.toString());
            Object nombreClienteObj = facturacionView.getValueAt(filaSeleccionada, 2);
            Object dniClienteObj = facturacionView.getValueAt(filaSeleccionada, 3);
            Object fechaVentaObj = facturacionView.getValueAt(filaSeleccionada, 5);
            Object totalVentaObj = facturacionView.getValueAt(filaSeleccionada, 6);

            if (idVentaObj != null && nombreClienteObj != null && dniClienteObj != null
                    && fechaVentaObj != null && totalVentaObj != null) {

                id_venta =  Integer.parseInt(facturacionView.getValueAt(filaSeleccionada, 0).toString());
                nombreCliente = nombreClienteObj.toString();
                int dniCliente2 = Integer.parseInt(dniClienteObj.toString());
                fechaVenta = fechaVentaObj.toString();
                float totalVenta3 = Float.parseFloat(totalVentaObj.toString());

                dniCliente = String.valueOf(dniCliente2);
                totalVenta = String.valueOf(totalVenta3);

                // Aquí puedes hacer algo con las variables id_vent, dniCliente y totalVenta
            }
        }
    }
}
