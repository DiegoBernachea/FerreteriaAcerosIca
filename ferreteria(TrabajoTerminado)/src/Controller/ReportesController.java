/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Impl.AlmacenDaoImpl;
import Dao.Impl.ArticuloDaoImpl;
import Dao.Impl.CompraDaoImpl;
import Dao.Impl.VentaDaoImpl;
import Modelo.Almacen;
import Modelo.Articulo;
import Modelo.Compra;
import Modelo.Venta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kmvil
 */
public class ReportesController {
    Compra compra=new Compra();
    CompraDaoImpl compradao=new CompraDaoImpl();
    List<Compra> listaCompra= new ArrayList<>();
    
    Venta venta=new Venta();
    VentaDaoImpl ventadao=new VentaDaoImpl();
    List<Venta> listaventa= new ArrayList<>();
    
    Almacen almacen=new Almacen();
    AlmacenDaoImpl almacendao=new AlmacenDaoImpl();
    List<Almacen> listaAlmacen= new ArrayList<>();
    
    Articulo articulo=new Articulo();
    ArticuloDaoImpl articulodao=new ArticuloDaoImpl();
    List<Articulo> listaArticulo= new ArrayList<>();
    
    public Map<String, Object>[] ObtenerArticulos(){
        listaArticulo=articulodao.listarArticulos();
            
            Map<String, Object>[] arreglo = new Map[listaArticulo.size()]; 
            int indice = 0; 

            for (Articulo a : listaArticulo) {
                Map<String, Object> map = new HashMap<>();
                map.put("idArticulo", a.getId_ar());
                map.put("nombre", a.getNombre_ar());
                map.put("descripcion", a.getDescrip_ar());
                map.put("categoria", a.getId_cat());  
                map.put("marca", a.getId_mar());
                map.put("codEliminar", a.getCod_eli());
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
   
    public  Map<String, Object>[] ObtenerAlmacenPorIdArticulo(int id){
        listaAlmacen=almacendao.ObtenerAlmacenPorIdArticulo(id);

            Map<String, Object>[] arreglo = new Map[listaAlmacen.size()]; 
            int indice = 0; 

           for (Almacen a : listaAlmacen) {
                Map<String, Object> map = new HashMap<>();

                map.put("idAlmacen", a.getId_al());
                map.put("idArticulo", a.getId_ar());
                map.put("precio", a.getPrecio());
                map.put("stock", a.getStock());

                arreglo[indice] = map;

                indice++;
            }
           
        return arreglo;
    }
    
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
    public Map<String, Object>[] ObtenerVentasEntreFechas(String inicio, String Fin){
        listaventa=ventadao.listarVentasEntreFechas(inicio, Fin);
            
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
    
    public Map<String, Object>[] ObtenerCompras(){
        listaCompra=compradao.listarCompras();
            
            Map<String, Object>[] arreglo = new Map[listaCompra.size()]; 
            int indice = 0; 

            for (Compra com : listaCompra) {
                Map<String, Object> map = new HashMap<>();
                
                map.put("id", com.getId_com());
                map.put("idProveedor", com.getId_pro());
                map.put("idUsuario", com.getId_usu());
                map.put("fecha", com.getFecha_com());
                map.put("total", com.getTotal());
                
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
    public Map<String, Object>[] ObtenerComprasEntreFechas(String inicio, String Fin){
        listaCompra=compradao.listarComprasEntreFechas(inicio, Fin);
            
            Map<String, Object>[] arreglo = new Map[listaCompra.size()]; 
            int indice = 0; 

            for (Compra com : listaCompra) {
                Map<String, Object> map = new HashMap<>();
                
                map.put("id", com.getId_com());
                map.put("idProveedor", com.getId_pro());
                map.put("idUsuario", com.getId_usu());
                map.put("fecha", com.getFecha_com());
                map.put("total", com.getTotal());
                
                arreglo[indice] = map;

                indice++;
            }

        return arreglo;
    }
    public List<List<Object>> obtenerDatosTabla(Object[][] data) {
        List<List<Object>> datosTabla = new ArrayList<>();

        int rowCount = data.length;
        int columnCount = data[0].length;

        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            List<Object> fila = new ArrayList<>();

            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                Object value = data[rowIndex][columnIndex];
                fila.add(value);
            }

            datosTabla.add(fila);
        }

        return datosTabla;
    }
    
    public List<String> obtenerEncabezadosColumna(String tipoReporte) {
    List<String> encabezados = new ArrayList<>();

    switch (tipoReporte) {
        case "Ventas":
            encabezados.add("ID");
            encabezados.add("Usuario");
            encabezados.add("Nombre Cliente");
            encabezados.add("DNI Cliente");
            encabezados.add("Metodo de Pago");
            encabezados.add("Fecha de Venta");
            encabezados.add("Total");
            break;
        case "Compras":
            encabezados.add("ID");
            encabezados.add("Proveedor");
            encabezados.add("RUC del Proveedor");
            encabezados.add("Usuario");
            encabezados.add("Fecha");
            encabezados.add("Total");
            break;
        case "Inventario":
            encabezados.add("id");
            encabezados.add("Nombre");
            encabezados.add("Descripcion");
            encabezados.add("Categoria");
            encabezados.add("Marca");
            encabezados.add("Stock");
            encabezados.add("Precio Unitario");
            break;
        default:
            // Tipo de reporte no válido, retornar lista vacía
            break;
    }

    return encabezados;
    }
}
