/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Dao.Conexion;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmvil
 */
public class FacturacionPDF {

public void generarFacturaCompra(int id_venta, String nombreCliente, int dniCliente, String fechaVenta, Map<Integer, Map<String, Object>> detallesMap, float totalVenta) {
    Document documento = new Document();

    try {
        String rutaDescargas = System.getProperty("user.home") + "/Downloads/";
        String nombreArchivo = "Factura_compra_" + fechaVenta.replaceAll("[^a-zA-Z0-9]", "") + "_" + dniCliente + "_" + nombreCliente + ".pdf";
        String rutaCompleta = rutaDescargas + nombreArchivo;

        // Verificar si ya existe un archivo con el mismo nombre
        File archivoExistente = new File(rutaCompleta);
        int contador = 1;
        while (archivoExistente.exists()) {
            String nuevoNombreArchivo = "Factura_compra_" + fechaVenta.replaceAll("[^a-zA-Z0-9]", "") + "_" + dniCliente + "_" + nombreCliente + "(" + contador + ").pdf";
            rutaCompleta = rutaDescargas + nuevoNombreArchivo;
            archivoExistente = new File(rutaCompleta);
            contador++;
        }

        PdfWriter.getInstance(documento, new FileOutputStream(rutaCompleta));
        documento.open();

        // Agregar el título de la factura
        Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.BLACK);
        Paragraph titulo = new Paragraph("Factura de Compra de AcerosIca", fontTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        documento.add(titulo);

        // Agregar los detalles de la venta
        Font fontDetalles = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
        Paragraph detallesCliente = new Paragraph();
        detallesCliente.add(new Phrase("Cliente: ", fontDetalles));
        detallesCliente.add(new Phrase(nombreCliente, fontDetalles));
        detallesCliente.add(Chunk.NEWLINE);
        detallesCliente.add(new Phrase("DNI: ", fontDetalles));
        detallesCliente.add(new Phrase(String.valueOf(dniCliente), fontDetalles));
        detallesCliente.add(Chunk.NEWLINE);
        detallesCliente.add(new Phrase("Fecha: ", fontDetalles));
        detallesCliente.add(new Phrase(fechaVenta, fontDetalles));
        detallesCliente.setSpacingAfter(20);
        documento.add(detallesCliente);

        // Agregar la tabla con los detalles de venta
        PdfPTable tabla = new PdfPTable(3);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(10);
        tabla.setSpacingAfter(20);

        Font fontCabecera = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
        Font fontCelda = FontFactory.getFont(FontFactory.HELVETICA, 11, BaseColor.BLACK);

        PdfPCell celdaCabeceraCantidad = new PdfPCell(new Phrase("Cantidad", fontCabecera));
        celdaCabeceraCantidad.setBackgroundColor(BaseColor.DARK_GRAY);
        celdaCabeceraCantidad.setHorizontalAlignment(Element.ALIGN_CENTER);
        celdaCabeceraCantidad.setVerticalAlignment(Element.ALIGN_MIDDLE);

        PdfPCell celdaCabeceraArticulo = new PdfPCell(new Phrase("Artículo", fontCabecera));
        celdaCabeceraArticulo.setBackgroundColor(BaseColor.DARK_GRAY);
        celdaCabeceraArticulo.setHorizontalAlignment(Element.ALIGN_CENTER);
        celdaCabeceraArticulo.setVerticalAlignment(Element.ALIGN_MIDDLE);

        PdfPCell celdaCabeceraSubtotal = new PdfPCell(new Phrase("Subtotal", fontCabecera));
        celdaCabeceraSubtotal.setBackgroundColor(BaseColor.DARK_GRAY);
        celdaCabeceraSubtotal.setHorizontalAlignment(Element.ALIGN_CENTER);
        celdaCabeceraSubtotal.setVerticalAlignment(Element.ALIGN_MIDDLE);

        tabla.addCell(celdaCabeceraCantidad);
        tabla.addCell(celdaCabeceraArticulo);
        tabla.addCell(celdaCabeceraSubtotal);

        Font fontCeldaValor = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, BaseColor.BLACK);

        // Obtener los detalles de venta del mapa
        for (Map.Entry<Integer, Map<String, Object>> entry : detallesMap.entrySet()) {
            int idDetVenta = entry.getKey();
            Map<String, Object> detalleMap = entry.getValue();
            int cantidadVendida = (int) detalleMap.get("cantidad");
            String nombreProducto = (String) detalleMap.get("nombreProducto");
            float precioUnitario = (float) detalleMap.get("subtotal");

            PdfPCell celdaCantidad = new PdfPCell(new Phrase(String.valueOf(cantidadVendida), fontCeldaValor));
            celdaCantidad.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaCantidad.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell celdaArticulo = new PdfPCell(new Phrase(nombreProducto, fontCelda));
            celdaArticulo.setHorizontalAlignment(Element.ALIGN_LEFT);
            celdaArticulo.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell celdaSubtotal = new PdfPCell(new Phrase(String.valueOf(precioUnitario), fontCeldaValor));
            celdaSubtotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celdaSubtotal.setVerticalAlignment(Element.ALIGN_MIDDLE);

            tabla.addCell(celdaCantidad);
            tabla.addCell(celdaArticulo);
            tabla.addCell(celdaSubtotal);
        }

        PdfPCell celdaTotal = new PdfPCell(new Phrase("Total", fontCabecera));
        celdaTotal.setColspan(2);
        celdaTotal.setBackgroundColor(BaseColor.DARK_GRAY);
        celdaTotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
        celdaTotal.setVerticalAlignment(Element.ALIGN_MIDDLE);

        PdfPCell celdaTotalValor = new PdfPCell(new Phrase(String.valueOf(totalVenta), fontCeldaValor));
        celdaTotalValor.setBackgroundColor(BaseColor.LIGHT_GRAY);
        celdaTotalValor.setHorizontalAlignment(Element.ALIGN_RIGHT);
        celdaTotalValor.setVerticalAlignment(Element.ALIGN_MIDDLE);

        tabla.addCell(celdaTotal);
        tabla.addCell(celdaTotalValor);

        documento.add(tabla);

        // Agregar el pie de página
        Font fontPiePagina = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.GRAY);
        Paragraph piePagina = new Paragraph("* GRACIAS POR SU COMPRA *", fontPiePagina);
        piePagina.setAlignment(Element.ALIGN_CENTER);
        piePagina.setSpacingBefore(20);
        documento.add(piePagina);

        // Cerrar el documento
        documento.close();
        System.out.println("La factura se ha generado correctamente en: " + rutaCompleta);
    } catch (DocumentException | IOException e) {
        System.out.println("Error en el reporte de facturación: " + e.getMessage());
    }
}
}

