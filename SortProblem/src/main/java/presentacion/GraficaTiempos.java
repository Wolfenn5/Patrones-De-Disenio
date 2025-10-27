package presentacion;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.List;
import java.util.Map;




/**
 * Clase de utilidad para generar y mostrar graficas de los tiempos de ejecucion.
 * Usa la biblioteca JFreeChart para crear un grafico con lineas XY y ver los datos de cada algoritmo.
 */
public class GraficaTiempos {

    
    
    
    /**
     * Muestra una ventana con el histograma de tiempos de ejecucion.
     * @param tiempos Mapa con los tiempos de ejecucion de cada algoritmo
     * @param tamanios Arreglo con los tamaños de los arreglos probados
     */
    public static void mostrarHistograma(Map<String, List<Long>> tiempos, int[] tamanios) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        for (String algoritmo : tiempos.keySet()) {
            XYSeries series = new XYSeries(algoritmo);
            List<Long> listaTiempos = tiempos.get(algoritmo);
            for (int i = 0; i < listaTiempos.size(); i++) {
                series.add(tamanios[i], listaTiempos.get(i));
            }
            dataset.addSeries(series);

            XYSeries proyeccion = new XYSeries(algoritmo + " Proyección");
            double sumX = 0, sumY = 0, sumXY = 0, sumXX = 0;
            int n = listaTiempos.size();
            for (int i = 0; i < n; i++) {
                sumX += tamanios[i];
                sumY += listaTiempos.get(i);
                sumXY += tamanios[i] * listaTiempos.get(i);
                sumXX += tamanios[i] * tamanios[i];
            }
            double slope = (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX);
            double intercept = (sumY - slope * sumX) / n;
            for (int i = 0; i < n; i++) {
                double yProj = slope * tamanios[i] + intercept;
                proyeccion.add(tamanios[i], yProj);
            }
            dataset.addSeries(proyeccion);
        }

        JFreeChart chart = org.jfree.chart.ChartFactory.createXYLineChart(
                "Tiempos de Ordenamiento",
                "Tamaño del arreglo",
                "Tiempo (ns)",
                dataset);

        ChartPanel panel = new ChartPanel(chart);
        JFrame ventana = new JFrame("Histograma de Tiempos");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(panel);
        ventana.pack();
        ventana.setVisible(true);
    }
}