/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author kmvil
 */
public class ExcelUtil {

public File construirExcel(List<List<Object>> datosTabla, List<String> cabecera, String tipoReporte, String nombreUsuario) throws Exception {
    Workbook book = new XSSFWorkbook();
    Sheet sheet = book.createSheet(tipoReporte);

    String fechaActual = obtenerFechaActual();

    String baseFileName = "Reporte " + tipoReporte + " " + fechaActual;
    String fileName = baseFileName;
    String home = System.getProperty("user.home");
    File file = new File(home + "/Downloads/" + fileName + ".xlsx");

    int fileNumber = 1;
    while (file.exists()) {
        fileName = baseFileName + " (" + fileNumber + ")";
        file = new File(home + "/Downloads/" + fileName + ".xlsx");
        fileNumber++;
    }

    try {
        InputStream is = new FileInputStream("src/img/logo.png");
        byte[] bytes = IOUtils.toByteArray(is);
        int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        is.close();

        CreationHelper help = book.getCreationHelper();
        Drawing draw = sheet.createDrawingPatriarch();

        // Agregar logo
        ClientAnchor logoAnchor = help.createClientAnchor();
        logoAnchor.setCol1(9);
        logoAnchor.setCol2(11);
        logoAnchor.setRow1(1);
        logoAnchor.setRow2(6);
        Picture logo = draw.createPicture(logoAnchor, imgIndex);

        // Estilos de celdas
        CellStyle tituloEstilo = book.createCellStyle();
        tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
        tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
        Font fuenteTitulo = book.createFont();
        fuenteTitulo.setFontName("Arial");
        fuenteTitulo.setBold(true);
        fuenteTitulo.setFontHeightInPoints((short) 14);
        tituloEstilo.setFont(fuenteTitulo);

        CellStyle encabezadoEstilo = book.createCellStyle();
        encabezadoEstilo.setFont(fuenteTitulo);
        
        

        // Agregar título del tipo de reporte
        Row filaTitulo = sheet.createRow(0);
        Cell celdaTitulo = filaTitulo.createCell(2);
        celdaTitulo.setCellStyle(tituloEstilo);
        celdaTitulo.setCellValue(tipoReporte);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, 4));

        // Agregar nombre y fecha y empresa
        Row filaNombreFechaEmpresa = sheet.createRow(2);
        
        Cell celdaTextoEmpresa = filaNombreFechaEmpresa.createCell(0);
        celdaTextoEmpresa.setCellValue("Empresa:");
        celdaTextoEmpresa.setCellStyle(encabezadoEstilo);

        Cell celdaNombreEmpresa = filaNombreFechaEmpresa.createCell(1);
        celdaNombreEmpresa.setCellValue("Aceros Ica");

        Cell celdaNombre = filaNombreFechaEmpresa.createCell(2);
        celdaNombre.setCellValue("Nombre:");
        celdaNombre.setCellStyle(encabezadoEstilo);

        Cell celdaNombreValor = filaNombreFechaEmpresa.createCell(3);
        celdaNombreValor.setCellValue(nombreUsuario);


        Cell celdaFecha = filaNombreFechaEmpresa.createCell(4);
        celdaFecha.setCellValue("Fecha:");
        celdaFecha.setCellStyle(encabezadoEstilo);

        Cell celdaFechaValor = filaNombreFechaEmpresa.createCell(5);
        celdaFechaValor.setCellValue(fechaActual);

        // Agregar encabezados de tabla
        CellStyle headerStyle = book.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);

        Font font = book.createFont();
        font.setFontName("Arial");
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setFontHeightInPoints((short) 12);
        headerStyle.setFont(font);

        Row filaEncabezados = sheet.createRow(4);

        for (int i = 0; i < cabecera.size(); i++) {
            Cell celdaEncabezado = filaEncabezados.createCell(i);
            celdaEncabezado.setCellStyle(headerStyle);
            celdaEncabezado.setCellValue(cabecera.get(i));
        }

        // Agregar datos de tabla
        int numFilaDatos = 5;

        CellStyle datosEstilo = book.createCellStyle();
        datosEstilo.setBorderBottom(BorderStyle.THIN);
        datosEstilo.setBorderLeft(BorderStyle.THIN);
        datosEstilo.setBorderRight(BorderStyle.THIN);
        datosEstilo.setBorderBottom(BorderStyle.THIN);

        for (List<Object> filaDatos : datosTabla) {
            Row fila = sheet.createRow(numFilaDatos);

            for (int columna = 0; columna < filaDatos.size(); columna++) {
                Cell celda = fila.createCell(columna);
                celda.setCellStyle(datosEstilo);
                celda.setCellValue(filaDatos.get(columna).toString());
            }

            numFilaDatos++;
        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        sheet.autoSizeColumn(4);

        sheet.setZoom(150);

        FileOutputStream fileOut = new FileOutputStream(file);
        book.write(fileOut);
        fileOut.close();

        return file;

    } catch (FileNotFoundException ex) {
        Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}

    public String obtenerFechaActual() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fechaActual.format(formato);
    }
}