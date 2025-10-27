package negocio;


/**
 * Implementacion del algoritmo de ordenamiento Quick Sort.
 * El algoritmo de "divide y venceras" que usa un pivote y parte el arreglo alrededor del pivote.
 */
public class Quick implements EstrategiaOrdenamiento {
    
    
    /**
     * Parte el arreglo alrededor del pivote, el ultimo elemento.
     * Coloca el pivote y todos los elementos menores iran a la izquierda y los mayores a la derecha. 
     * @param numeros Arreglo a partir
     * @param minimo Indice minimo del subarreglo
     * @param maximo Indice maximo del subarreglo (este sera el pivote)
     * @return Indice de la posicion final del pivote
     */
    private static int particion(int[] numeros, int minimo, int maximo) {
        int pivote = numeros[maximo];
        int i = minimo - 1;

        for(int j = minimo; j < maximo; j++){
            if(numeros[j] < pivote){
                i++;
                intercambiar(numeros, i, j);
            }
        }
        intercambiar(numeros, i + 1, maximo);
        return i + 1;
    }
    
    
    /**
     * Intercambia dos elementos en un arreglo.
     * @param numeros El arreglo
     * @param i Indice del primer elemento.
     * @param j Indice del segundo elemento.
     */
    private static void intercambiar(int[] numeros, int i, int j){
        int temporal = numeros[i];
        numeros[i] = numeros[j];
        numeros[j] = temporal;
    }

    
    /**
     * Funcion recursiva del algoritmo Quicksort.
     * * @param numeros Arreglo a ordenar.
     * @param minimo Indice de inicio.
     * @param maximo Indice de fin.
     */
    private static void ordenarQuick(int[] numeros, int minimo, int maximo){
        if(minimo < maximo){
            int pi = particion(numeros, minimo, maximo);
            ordenarQuick(numeros, minimo, pi - 1);
            ordenarQuick(numeros, pi + 1, maximo);
        }
    }
    
    
    /**
     * Metodo de la interfaz EstrategiaOrdenamiento para iniciar el ordenamiento Quicksort.
     * @param numeros El arreglo de enteros a ordenar.
     */
    @Override
    public void ordenar(int[] numeros){
        if(numeros == null || numeros.length == 0) return;
        ordenarQuick(numeros, 0, numeros.length - 1);
    }
}
