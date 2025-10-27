package negocio;


/**
 * Implementacion del algoritmo de ordenamiento Merge Sort.
 * El algoritmo que divide el arreglo en mitades, ordena recursivamente cada mitad y luego las une en un solo arreglo final.
 */
public class Merge implements EstrategiaOrdenamiento{
    
    
    /**
     * Combina (merge) dos sub-arreglos en un solo arreglo ordenado.
     * @param arr Arreglo principal.
     * @param l Indice izquierdo (inicio del primer sub-arreglo).
     * @param m Indice medio (fin del primer sub-arreglo).
     * @param r Indice derecho (fin del segundo sub-arreglo).
     */
    public void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
        
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2){
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    
    
    /**
     * FunciOn recursiva que ordena el arreglo usando merge().
     * @param arr Arreglo a ordenar.
     * @param l Índice izquierdo (inicio).
     * @param r Índice derecho (fin).
     */
    public void mergeSort(int arr[], int l, int r){
        if (l < r){
            int m = (l+r)/2;

            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);

            merge(arr, l, m, r);
        }
    }

    
    /**
     * Metodo de la interfaz EstrategiaOrdenamiento para iniciar el ordenamiento Merge.
     * @param numeros El arreglo de enteros a ordenar.
     */
    public void ordenar(int[] numeros) {
        mergeSort(numeros, 0, numeros.length - 1);
    }
}
