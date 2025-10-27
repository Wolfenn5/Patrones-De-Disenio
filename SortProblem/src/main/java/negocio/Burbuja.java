package negocio;


/**
 * Implementacion del algoritmo de ordenamiento Burbuja.
 * Este algoritmo recorre el arreglo, compara elementos y los intercambia dependiendo si un elemento es menor que el otro (adyacentes).
 */
public class Burbuja implements EstrategiaOrdenamiento {
    
    
    /**
     * Metodo de la interfaz EstrategiaOrdenamiento para iniciar el ordenamiento de Burbuja.
     * Usa una bandera "intercambiado" para saber si el arreglo ya quedo ordenado.
     * * @param numeros El arreglo de enteros a ordenar.
     */
    @Override
    public void ordenar(int[] numeros){
        int tamanio = numeros.length;
        int i, j, temp;
        boolean intercambiado;
        for(i=0; i<tamanio-1; i++){
            intercambiado = false;
            for(j=0; j<tamanio-i-1; j++){
                if(numeros[j] > numeros[j + 1]){
                    temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j+1] = temp;
                    intercambiado = true;
                }
            }
            if(!intercambiado){
                break;
            }
        }
    }
}
