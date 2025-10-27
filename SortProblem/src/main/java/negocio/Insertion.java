package negocio;


/**
 * Implementacion del algoritmo de ordenamiento Insertion Sort.
 */
public class Insertion implements EstrategiaOrdenamiento {
    
    /**
     * Metodo de la interfaz EstrategiaOrdenamiento para iniciar el ordenamiento Insertion Sort.
     * Este va insertando los elementos al inicio del arreglo para quedar ordenado
     * @param numeros Arreglo de enteros a ordenar
     */
    @Override
    public void ordenar(int[] numeros){
        int tamanio = numeros.length;
        for(int i=1; i<tamanio; i++){
            int key = numeros[i];
            int j = i - 1;
            while(j >= 0 && numeros[j] > key){
                numeros[j + 1] = numeros[j];
                j = j - 1;
            }
            numeros[j + 1] = key;
        }
    }
}
