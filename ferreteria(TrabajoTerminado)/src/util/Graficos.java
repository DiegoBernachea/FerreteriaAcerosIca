/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Dao.Conexion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.geom.Ellipse2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author enriq
 */
public class Graficos{
    Color colorbackground= Color.WHITE; 
    Color colorFuente= Color.BLACK; 
    Connection con ;
    Conexion cn = new Conexion();
    PreparedStatement ps ;
    ResultSet rs;
    
    public ChartPanel graficoPastel(){
        Calendar calendar = Calendar.getInstance();
        int mesActual = calendar.get(Calendar.MONTH) + 1; // Se suma 1 porque los meses en Calendar se indexan desde 0
        try {
            String sql = "SELECT subquery.Nombre, subquery.total_vendidos FROM ( SELECT id_articulo, Nombre, total_vendidos FROM ( SELECT a.id_articulo, a.Nombre, SUM(dv.cantidad) AS total_vendidos FROM det_venta_articulos dv INNER JOIN venta v ON v.id_venta = dv.id_venta INNER JOIN articulo a ON a.id_articulo = dv.id_articulo WHERE MONTH(v.fecha_venta) = ? GROUP BY a.id_articulo ORDER BY total_vendidos DESC LIMIT 8 ) AS top_articulos UNION SELECT 'Otros', NULL AS Nombre, SUM(total_vendidos) AS total_vendidos FROM ( SELECT SUM(dv.cantidad) AS total_vendidos FROM det_venta_articulos dv INNER JOIN venta v ON v.id_venta = dv.id_venta WHERE MONTH(v.fecha_venta) = ? GROUP BY dv.id_articulo ORDER BY total_vendidos DESC LIMIT 8, 9999 ) AS otros_articulos ) AS subquery";
            con= cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,mesActual);
            ps.setInt(2,mesActual);
            rs = ps.executeQuery();

            DefaultPieDataset dataset = new DefaultPieDataset();
            JFreeChart chart = ChartFactory.createPieChart(
                    "MAS VENDIDOS DEL MES", 
                    dataset, 
                    true, 
                    true, 
                    false
            );
            boolean hayRegistros = false; // Variable para realizar un seguimiento de si hay registros adicionales

            while (rs.next()) {
                if (rs.getString("subquery.Nombre") == null) {
                    // Si el valor de "Nombre" es null, no se agrega como registro
                    dataset.setValue("Otros", rs.getInt("subquery.total_vendidos"));
                } else {
                    hayRegistros = true; // Se encontró al menos un registro distinto de "Otros"
                    dataset.setValue(rs.getString("subquery.Nombre"), rs.getInt("subquery.total_vendidos"));
                }
            }

            if (!hayRegistros) {
                chart.setTitle("NO HAY INFORMACION DEL MES");
            }
            
            
            chart.setBackgroundPaint(colorbackground);
            TextTitle title = chart.getTitle();
            title.setPaint(colorFuente); // Establece el color del título (en este caso, rojo)
            PiePlot plot = (PiePlot) chart.getPlot();
                //plot.setSectionPaint("Otros", Color.BLUE);  // Cambia el color de la sección 1 a azul
            plot.setBackgroundPaint(Color.WHITE); // Establece el fondo transparente
            plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} {1}")); // Muestra la etiqueta de cada sección con el formato "Nombre: Valor"
            plot.setLabelBackgroundPaint(Color.WHITE);  // Cambia el color de fondo de las etiquetas a blanco
            
            plot.setLabelOutlinePaint(colorFuente);     // Cambia el color del contorno de las etiquetas a negro
            plot.setLabelFont(plot.getLabelFont().deriveFont(12));  
            plot.setLabelFont(plot.getLabelFont().deriveFont(Font.BOLD));  // Hace que la fuente sea negrita
            plot.setLabelPaint(Color.BLACK);
            
            LegendTitle legend = chart.getLegend();
            legend.setItemFont(legend.getItemFont().deriveFont(Font.BOLD));  // Hacer que la fuente de los elementos de la leyenda sea negrita
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setBackground(Color.red); 
            chartPanel.repaint();
            chartPanel.setMouseWheelEnabled(true);
            chartPanel.setSize(new Dimension(500,400));
            return chartPanel;

        }catch (SQLException e){
             System.out.println(e.toString());
             return null;
        }
    }
    
    public ChartPanel graficoBarrasApiladas(){
        int yearActual = Calendar.getInstance().get(Calendar.YEAR);
        Calendar calendar = Calendar.getInstance();
        int mesActual = calendar.get(Calendar.MONTH) + 1; // Se suma 1 porque los meses en Calendar se indexan desde 0
        try {
            String sql="SELECT subquery.Nombre, subquery.total_vendidos FROM ( SELECT id_articulo, Nombre, total_vendidos FROM ( SELECT a.id_articulo, a.Nombre, SUM(dv.precio_subtotal) AS total_vendidos FROM det_venta_articulos dv INNER JOIN venta v ON v.id_venta = dv.id_venta INNER JOIN articulo a ON a.id_articulo = dv.id_articulo WHERE YEAR(v.fecha_venta) = ? AND MONTH(v.fecha_venta) = ? GROUP BY a.id_articulo ORDER BY total_vendidos DESC LIMIT 8 ) AS top_articulos UNION SELECT 'Otros', NULL AS Nombre, SUM(total_vendidos) AS total_vendidos FROM ( SELECT SUM(dv.precio_subtotal) AS total_vendidos FROM det_venta_articulos dv INNER JOIN venta v ON v.id_venta = dv.id_venta WHERE YEAR(v.fecha_venta) = ? AND MONTH(v.fecha_venta) = ? GROUP BY dv.id_articulo ORDER BY total_vendidos DESC LIMIT 8, 9999 ) AS otros_articulos ) AS subquery";
            con= cn.getConnection();
            int mes=1;
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            JFreeChart chart = ChartFactory.createStackedBarChart(
                    "INGRESOS DEL ARTICULO", 
                    "Meses", 
                    "Ingresos", 
                    dataset);
            if(mesActual>=mes){
                while(mes<=12){
                    ps=con.prepareStatement(sql);
                    ps.setInt(1,yearActual);
                    ps.setInt(2,mes);
                    ps.setInt(3,yearActual);
                    ps.setInt(4,mes);
                    rs = ps.executeQuery();

                    
                    calendar.set(Calendar.MONTH, mes - 1);
                    String nombreMes = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, java.util.Locale.getDefault());
                    while (rs.next()) {
                        if (rs.getString("subquery.Nombre") == null) {
                            // Si el valor de "Nombre" es null, no se agrega como registro
                            dataset.addValue( rs.getFloat("subquery.total_vendidos"),"Otros",nombreMes);
                        } else {
                            dataset.addValue( rs.getFloat("subquery.total_vendidos"),rs.getString("subquery.Nombre"), nombreMes);
                        }
                    }

                    mes++;
                }
            }
            chart.setBackgroundPaint(colorbackground);
            TextTitle title = chart.getTitle();
            title.setPaint(colorFuente); // Establece el color del título (en este caso, rojo)
            // Obtener el objeto Plot del gráfico
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            
            // Establecer el fondo transparente
            plot.setBackgroundPaint(Color.WHITE);
            // Obtener el eje de dominio (eje x) y establecer el color y la fuente de las etiquetas
            CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setLabelPaint(colorFuente);  // Cambiar el color del texto del eje x a blanco
            domainAxis.setLabelFont(domainAxis.getLabelFont().deriveFont(Font.BOLD));  // Hacer que el texto del eje x sea negrita
            domainAxis.setTickLabelPaint(colorFuente);  // Cambiar el color de las etiquetas de las categorías a blanco
            //domainAxis.setTickLabelFont(domainAxis.getTickLabelFont().deriveFont(Font.BOLD));  // Hacer que las etiquetas de las categorías sean negrita

            // Obtener el eje de rango (eje y) y establecer el color y la fuente de las etiquetas
            ValueAxis rangeAxis = plot.getRangeAxis();
            rangeAxis.setLabelPaint(colorFuente);  // Cambiar el color del texto del eje y a blanco
            rangeAxis.setLabelFont(rangeAxis.getLabelFont().deriveFont(Font.BOLD));  // Hacer que el texto del eje y sea negrita
            rangeAxis.setTickLabelPaint(colorFuente);  // Cambiar el color de las etiquetas de los valores a blanco
            rangeAxis.setTickLabelFont(rangeAxis.getTickLabelFont().deriveFont(Font.BOLD));  // Hacer que las etiquetas de los valores sean negrita
           

            plot.setRangeGridlinePaint(Color.BLACK);  // Cambiar el color de la línea guía a negro

            LegendTitle legend = chart.getLegend();
            legend.setItemFont(legend.getItemFont().deriveFont(Font.BOLD));  // Hacer que la fuente de los elementos de la leyenda sea negrita

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setBackground(Color.red); 
            chartPanel.repaint();
            chartPanel.setMouseWheelEnabled(true);
            chartPanel.setSize(new Dimension(500,400));
            return chartPanel;

        }catch (SQLException e){
             System.out.println(e.toString());
             return null;
        }
    }
    
    public ChartPanel graficoLineas(){
        // Obtener el año actual
        int yearActual = Calendar.getInstance().get(Calendar.YEAR);
        // Obtener el año anterior
        int yearAnterior = yearActual - 1;
        Calendar calendar = Calendar.getInstance();
        int mesActual = calendar.get(Calendar.MONTH) + 1; // Se suma 1 porque los meses en Calendar se indexan desde 0
        try {
            String sql="SELECT months.month AS mes, COALESCE(SUM(venta.Total), 0) AS total_ingresos FROM ( SELECT 1 AS month UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION SELECT 11 UNION SELECT 12 ) AS months LEFT JOIN venta ON MONTH(venta.fecha_venta) = months.month AND YEAR(venta.fecha_venta) = ? GROUP BY months.month ORDER BY months.month";
            con= cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,yearActual);
            rs = ps.executeQuery();

            DefaultCategoryDataset dataset= new DefaultCategoryDataset();
            JFreeChart chart = ChartFactory.createLineChart(
                "INGRESOS DEL AÑO", 
                    "Meses", 
                    "Ingresos", 
                    dataset);

            while (rs.next()) {
                int mes = rs.getInt("mes");
                if(mesActual>=mes){
                    
                    int totalIngresos = rs.getInt("total_ingresos");
                    // Agregar los valores al dataset
                    dataset.addValue(totalIngresos, "Año Actual", String.valueOf(mes));
                }
            }
            con= cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,yearAnterior);
            rs = ps.executeQuery();
            while (rs.next()) {
                int mes = rs.getInt("mes");
                int totalIngresos = rs.getInt("total_ingresos");

                // Agregar los valores al dataset
                dataset.addValue(totalIngresos, "Año Pasado",  String.valueOf(mes));
            }
            chart.setBackgroundPaint(colorbackground);
            TextTitle title = chart.getTitle();
            title.setPaint(colorFuente); // Establece el color del título (en este caso, rojo)
            // Obtener el objeto Plot del gráfico
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            
            // Establecer el fondo transparente
            plot.setBackgroundPaint(Color.WHITE);
            // Obtener el eje de dominio (eje x) y establecer el color y la fuente de las etiquetas
            CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setLabelPaint(colorFuente);  // Cambiar el color del texto del eje x a blanco
            domainAxis.setLabelFont(domainAxis.getLabelFont().deriveFont(Font.BOLD));  // Hacer que el texto del eje x sea negrita
            domainAxis.setTickLabelPaint(colorFuente);  // Cambiar el color de las etiquetas de las categorías a blanco
            domainAxis.setTickLabelFont(domainAxis.getTickLabelFont().deriveFont(Font.BOLD));  // Hacer que las etiquetas de las categorías sean negrita

            // Obtener el eje de rango (eje y) y establecer el color y la fuente de las etiquetas
            ValueAxis rangeAxis = plot.getRangeAxis();
            rangeAxis.setLabelPaint(colorFuente);  // Cambiar el color del texto del eje y a blanco
            rangeAxis.setLabelFont(rangeAxis.getLabelFont().deriveFont(Font.BOLD));  // Hacer que el texto del eje y sea negrita
            rangeAxis.setTickLabelPaint(colorFuente);  // Cambiar el color de las etiquetas de los valores a blanco
            rangeAxis.setTickLabelFont(rangeAxis.getTickLabelFont().deriveFont(Font.BOLD));  // Hacer que las etiquetas de los valores sean negrita
           
            LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
            renderer.setSeriesShapesVisible(0, true);  // Hacer que los puntos de alineación sean visibles
            renderer.setSeriesShape(0, new Ellipse2D.Double(-4, -4, 8, 8));  // Establecer la forma de los puntos de alineación (círculo en este caso)
            renderer.setSeriesPaint(0, Color.GREEN);  // Cambiar el color de los puntos de alineación a negro
            
            LineAndShapeRenderer renderer1 = (LineAndShapeRenderer) plot.getRenderer();
            renderer1.setSeriesShapesVisible(1, true);  // Hacer que los puntos de alineación sean visibles
            plot.setRangeGridlinePaint(Color.BLACK);  // Cambiar el color de la línea guía a negro
            
            LegendTitle legend = chart.getLegend();
            legend.setItemFont(legend.getItemFont().deriveFont(Font.BOLD));  // Hacer que la fuente de los elementos de la leyenda sea negrita

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setBackground(Color.red); 
            chartPanel.repaint();
            chartPanel.setMouseWheelEnabled(true);
            chartPanel.setSize(new Dimension(500,400));
            return chartPanel;

        }catch (SQLException e){
             System.out.println(e.toString());
             return null;
        }
        
    }

}