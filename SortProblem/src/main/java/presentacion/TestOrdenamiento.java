package presentacion;

import java.util.*;

import negocio.Burbuja;
import negocio.ContextoOrdenamiento;
import negocio.HistogramaTiempos;
import negocio.Quick;
import negocio.Merge;
import negocio.Insertion;



/**
 * Clase principal que ejecuta las pruebas de los algoritmos de ordenamiento.
 * Hace pruebas con diferentes tamaños de arreglos (de 2 a 1000).
 */
public class TestOrdenamiento {

    
    
    /**
     * Mide el tiempo de ejecucion (en nanosegundos) de la estrategia de ordenamiento segun el contexto.
     * @param contexto El objeto ContextoOrdenamiento que tiene la estrategia (tipo de algoritmo).
     * @param numeros El arreglo de enteros a ordenar.
     * @return El tiempo de ejecucion en nanosegundos.
     */
    public static long medirTiempo(ContextoOrdenamiento contexto, int[] numeros) {
        long inicio = System.nanoTime();
        contexto.ejecutarEstrategia(numeros);
        long fin = System.nanoTime();
        return fin - inicio;
    }

    
    /**
     * Genera un arreglo de enteros aleatorios.
     * @param tamanio El numero de elementos en el arreglo.
     * @param min El valor minimo.
     * @param max El valor maximo.
     * @return Un arreglo de enteros aleatorios.
     */
    public static int[] generarArreglo(int tamanio, int min, int max) {
        int[] numeros = new int[tamanio];
        Random ran = new Random();
        for (int i = 0; i < tamanio; i++) {
            numeros[i] = ran.nextInt(max - min + 1) + min;
        }
        return numeros;
    }

    
    
    
    /**
     * Escribe los tiempos de ejecucion en un archivo separado por comas.
     * @param nombreArchivo Ruta del archivo donde guardar los datos.
     * @param n Tamaño del arreglo probado.
     * @param tiempoBurbuja Tiempo del algoritmo Burbuja.
     * @param tiempoQuick Tiempo del algoritmo Quick.
     * @param tiempoInsert Tiempo del algoritmo Insertion.
     * @param tiempoMerge Tiempo del algoritmo Merge.
     */
    public static void escribirTiemposEnArchivo(String nombreArchivo, int n, long tiempoBurbuja, long tiempoQuick,
            long tiempoInsert, long tiempoMerge) {
        try {
            java.io.FileWriter fw = new java.io.FileWriter(nombreArchivo, true); // el true es para modo "append" (añadir al final)
            fw.write(n + "," + tiempoBurbuja + "," + tiempoQuick + "," + tiempoInsert + "," + tiempoMerge + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    
    
    
    /**
     * Main que ejecuta las pruebas.
     * Prueba los algoritmos con arreglos de tamaño 2 a 1000 y luego muestra el hisotgrama.
     * @param args Argumentos de linea de comandos (no se usan)
     */
    public static void main(String[] args) {
        ContextoOrdenamiento contexto = new ContextoOrdenamiento();
        HistogramaTiempos histograma = HistogramaTiempos.getInstancia();

        try {
            java.io.FileWriter fw = new java.io.FileWriter("src/main/java/datos/tiempos_algoritmos.txt");
            fw.write("n,burbuja,quick,insertion,merge\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el encabezado: " + e.getMessage());
        }

        for (int tam = 2; tam <= 1000; tam++) {
            int[] numeros = generarArreglo(tam, 0, 100);

            /* Burbuja */
            contexto.setEstrategia(new Burbuja());
            int[] copiaBurbuja = Arrays.copyOf(numeros, numeros.length);
            long tiempoBurbuja = medirTiempo(contexto, copiaBurbuja);
            System.out.println("Burbuja (" + tam + "): " + Arrays.toString(copiaBurbuja));
            System.out.println("Tiempo Burbuja: " + tiempoBurbuja + " ns");
            histograma.agregarTiempo("Burbuja", tiempoBurbuja);

            /* Quick */
            contexto.setEstrategia(new Quick());
            int[] copiaQuick = Arrays.copyOf(numeros, numeros.length);
            long tiempoQuick = medirTiempo(contexto, copiaQuick);
            System.out.println("Quick (" + tam + "): " + Arrays.toString(copiaQuick));
            System.out.println("Tiempo Quick: " + tiempoQuick + " ns");
            histograma.agregarTiempo("Quick", tiempoQuick);

            /* Insertion */
            contexto.setEstrategia(new Insertion());
            int[] copiaInsert = Arrays.copyOf(numeros, numeros.length);
            long tiempoInsert = medirTiempo(contexto, copiaInsert);
            System.out.println("Insert (" + tam + "): " + Arrays.toString(copiaInsert));
            System.out.println("Tiempo Insert: " + tiempoInsert + " ns");
            histograma.agregarTiempo("Insert", tiempoInsert);

            /* Merge */
            contexto.setEstrategia(new Merge());
            int[] copiaMerge = Arrays.copyOf(numeros, numeros.length);
            long tiempoMerge = medirTiempo(contexto, copiaMerge);
            System.out.println("Merge (" + tam + "): " + Arrays.toString(copiaMerge));
            System.out.println("Tiempo Merge: " + tiempoMerge + " ns");
            histograma.agregarTiempo("Merge", tiempoMerge);

            escribirTiemposEnArchivo("src/main/java/datos/tiempos_algoritmos.txt", tam, tiempoBurbuja, tiempoQuick, tiempoInsert, tiempoMerge);
        }

        System.out.println("Histograma de tiempos:");
        for (String algoritmo : histograma.getTiempos().keySet()) {
            System.out.println(algoritmo + ": " + histograma.getTiempos().get(algoritmo));
        }
        int[] tamanios = new int[999];
        for (int i = 0; i < tamanios.length; i++) {
            tamanios[i] = i + 2;
        }

        GraficaTiempos.mostrarHistograma(histograma.getTiempos(), tamanios);
    }
}
