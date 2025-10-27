package negocio;

import java.util.*;



/**
 * Clase que almacena los tiempos de ejecucion de los algoritmos.
 * Usa el Patron Singleton que asegura una unica instancia, obtiene los datos de tiempo de ejecucion de los algoritmos.
 */
public class HistogramaTiempos {
    private static HistogramaTiempos histograma;
    private Map<String, List<Long>> tiempos = new HashMap<>();

    
    
    /**
     * Constructor privado para implementar el Patron Singleton.
     */
    private HistogramaTiempos() {
        
    }
    
    
    /**
     * Obtiene la instancia unica de HistogramaTiempos. 
     * @return Instancia única de HistogramaTiempos
     */
    public static HistogramaTiempos getInstancia() {
        if (histograma == null) {
            histograma = new HistogramaTiempos();
        }
        return histograma;
    }
    
    
    /**
     * Agrega un tiempo de ejecucion para un algoritmo especifico.
     * @param algoritmo Nombre del algoritmo (Burbuja, Merge, Insertion, Quick)
     * @param tiempo Tiempo de ejecución en nanosegundos
     */
    public void agregarTiempo(String algoritmo, long tiempo){
        List<Long> lista = tiempos.get(algoritmo);
        if(lista == null){
            lista = new ArrayList<>();
            tiempos.put(algoritmo, lista);
        }
        lista.add(tiempo);
    }
    
    
    /**
     * Obtiene todos los tiempos de cada algoritmo.
     * * @return Un "mapa" con los tiempos de cada algoritmo.
     */
    public Map<String, List<Long>> getTiempos(){
        return tiempos;
    }
}
