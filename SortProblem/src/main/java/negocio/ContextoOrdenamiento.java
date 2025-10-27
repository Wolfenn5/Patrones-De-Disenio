package negocio;



/**
 * Clase contexto del Patron Strategy de EstrategiaOrdenamiento.
 * Implementa el patrón Strategy para elegir una estrategia de ordenamiento y la delega en tiempo de ejecucion.
 */
public class ContextoOrdenamiento {
    private EstrategiaOrdenamiento estrategia;
    
    
    /**
     * Establece la estrategia de ordenamiento concreta que se va a usar.
     * @param estrategia Estrategia instancia de EstrategiaOrdenamiento (Burbuja, Quick, Merge, Insert).
     */
    public void setEstrategia(EstrategiaOrdenamiento estrategia){
        this.estrategia = estrategia;
    }
    
    
    /**
     * Ejecuta el metodo "ordenar" de la estrategia seleccionada.
     * @param numeros El arreglo de enteros a ordenar.
     */
    public void ejecutarEstrategia(int[] numeros){
        estrategia.ordenar(numeros);
    }
    
}
