package presentacion;

import java.util.*;

import datos.ManejadorArchivos;
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
     * Genera un arreglo ordenado invertido para probar el peor caso posible.
     * @param arrOrdenado Arreglo que ya esta ordenado.
     * @return Un nuevo arreglo con sus elementos invertidos.
     */
    public static int[] generarArregloInvertido(int[] arrOrdenado) {
        int tamanio = arrOrdenado.length;
        int[] invertido = new int[tamanio];
        for (int i = 0; i < tamanio; i++) {
            invertido[i] = arrOrdenado[tamanio-1-i];
        }
        return invertido;
    }
    
    
    
    /**
     * Main que ejecuta las pruebas.
     * Prueba los algoritmos con arreglos de tamaño 2 a 1000 y luego muestra el hisotgrama.
     * @param args Argumentos de linea de comandos (no se usan)
     */
    public static void main(String[] args) {
        ContextoOrdenamiento contexto = new ContextoOrdenamiento();
        HistogramaTiempos histograma = HistogramaTiempos.getInstancia();
        ManejadorArchivos.escribirEncabezado();
       

        for (int tam = 2; tam <= 1000; tam++) {            
            /* Caso Promedio (Aleatorio) */
            int[] numeros_prom = generarArreglo(tam, 0, 100);

            /* Mejor Caso (Ordenado) */
            int[] numeros_mejor = Arrays.copyOf(numeros_prom, numeros_prom.length);
            Arrays.sort(numeros_mejor);

            /* Peor Caso (Invertido) */
            int[] numeros_peor = generarArregloInvertido(numeros_mejor);
            
            
            
            /* Burbuja */
            contexto.setEstrategia(new Burbuja());
          
            /* Burbuja Promedio */
            int[] copiaBurbujaProm = Arrays.copyOf(numeros_prom, numeros_prom.length);
            long tiempoBurbujaProm = medirTiempo(contexto, copiaBurbujaProm);
            System.out.println("Burbuja Caso Promedio (" + tam + "): " + Arrays.toString(copiaBurbujaProm));
            System.out.println("Tiempo Burbuja Caso Promedio: " + tiempoBurbujaProm + " ns");
            histograma.agregarTiempo("Burbuja (Promedio)", tiempoBurbujaProm);
            
            
            /* Burbuja Mejor */
            int[] copiaBurbujaMejor = Arrays.copyOf(numeros_mejor, numeros_mejor.length);
            long tiempoBurbujaMejor = medirTiempo(contexto, copiaBurbujaMejor);
            System.out.println("Burbuja Mejor Caso (" + tam + "): " + Arrays.toString(copiaBurbujaMejor));
            System.out.println("Tiempo Burbuja Promedio: " + tiempoBurbujaMejor + " ns");
            histograma.agregarTiempo("Burbuja (Mejor)", tiempoBurbujaMejor);
            
            
            /* Burbuja Peor */
            int[] copiaBurbujaPeor = Arrays.copyOf(numeros_peor, numeros_peor.length);
            long tiempoBurbujaPeor = medirTiempo(contexto, copiaBurbujaPeor);
            System.out.println("Burbuja Peor Caso (" + tam + "): " + Arrays.toString(copiaBurbujaPeor));
            System.out.println("Tiempo Burbuja Peor Caso: " + tiempoBurbujaPeor + " ns");
            histograma.agregarTiempo("Burbuja (Peor)", tiempoBurbujaPeor);

            
            
            
            
            
            /* Quick */
            contexto.setEstrategia(new Quick());
            
            /* Quick Promedio */
            int[] copiaQuickProm = Arrays.copyOf(numeros_prom, numeros_prom.length);
            long tiempoQuickProm = medirTiempo(contexto, copiaQuickProm);
            System.out.println("Quick Caso Promedio (" + tam + "): " + Arrays.toString(copiaQuickProm));
            System.out.println("Tiempo Quick Caso Promedio: " + tiempoQuickProm + " ns");
            histograma.agregarTiempo("Quick (Promedio)", tiempoQuickProm);

            
            /* Quick Mejor */
            int[] copiaQuickMejor = Arrays.copyOf(numeros_mejor, numeros_mejor.length);
            long tiempoQuickMejor = medirTiempo(contexto, copiaQuickMejor);
            System.out.println("Quick Mejor Caso (" + tam + "): " + Arrays.toString(copiaQuickMejor));
            System.out.println("Tiempo Quick Mejor Caso: " + tiempoQuickMejor + " ns");
            histograma.agregarTiempo("Quick (Mejor)", tiempoQuickMejor);            
            
            
            /* Quick Peor */
            int[] copiaQuickPeor = Arrays.copyOf(numeros_peor, numeros_peor.length);
            long tiempoQuickPeor = medirTiempo(contexto, copiaQuickPeor);
            System.out.println("Quick Peor Caso(" + tam + "): " + Arrays.toString(copiaQuickPeor));
            System.out.println("Tiempo Quick Peor Caso: " + tiempoQuickPeor + " ns");
            histograma.agregarTiempo("Quick(Peor)", tiempoQuickPeor);
            



            /* Insertion */
            contexto.setEstrategia(new Insertion());

            /* Insertion Promedio*/
            int[] copiaInsertProm = Arrays.copyOf(numeros_prom, numeros_prom.length);
            long tiempoInsertProm = medirTiempo(contexto, copiaInsertProm);
            System.out.println("Insert Caso Promedio (" + tam + "): " + Arrays.toString(copiaInsertProm));
            System.out.println("Tiempo Insert Caso Promedio: " + tiempoInsertProm + " ns");
            histograma.agregarTiempo("Insert (Promedio)", tiempoInsertProm);


            /* Insertion Mejor*/
            int[] copiaInsertMejor = Arrays.copyOf(numeros_mejor, numeros_mejor.length);
            long tiempoInsertMejor = medirTiempo(contexto, copiaInsertMejor);
            System.out.println("Insert Mejor Caso (" + tam + "): " + Arrays.toString(copiaInsertMejor));
            System.out.println("Tiempo Insert Mejor Caso: " + tiempoInsertMejor + " ns");
            histograma.agregarTiempo("Insert (Mejor)", tiempoInsertMejor);


            /* Insertion Peor*/
            int[] copiaInsertPeor = Arrays.copyOf(numeros_peor, numeros_peor.length);
            long tiempoInsertPeor = medirTiempo(contexto, copiaInsertPeor);
            System.out.println("Insert Peor Caso(" + tam + "): " + Arrays.toString(copiaInsertPeor));
            System.out.println("Tiempo Insert Peor Caso: " + tiempoInsertPeor + " ns");
            histograma.agregarTiempo("Insert (Peor)", tiempoInsertPeor);
            
            

            
            /* Merge */
            contexto.setEstrategia(new Merge());

            /* Merge Promedio*/
            int[] copiaMergeProm = Arrays.copyOf(numeros_prom, numeros_prom.length);
            long tiempoMergeProm = medirTiempo(contexto, copiaMergeProm);
            System.out.println("Merge Caso Promedio (" + tam + "): " + Arrays.toString(copiaMergeProm));
            System.out.println("Tiempo Merge Caso Promedio: " + tiempoMergeProm + " ns");
            histograma.agregarTiempo("Merge (Promedio)", tiempoMergeProm);


            /* Merge Mejor*/
            int[] copiaMergeMejor = Arrays.copyOf(numeros_mejor, numeros_mejor.length);
            long tiempoMergeMejor = medirTiempo(contexto, copiaMergeMejor);
            System.out.println("Merge Mejor Caso (" + tam + "): " + Arrays.toString(copiaMergeMejor));
            System.out.println("Tiempo Merge Mejor Caso: " + tiempoMergeMejor + " ns");
            histograma.agregarTiempo("Merge (Mejor)", tiempoMergeMejor);


            /* Merge Peor*/
            int[] copiaMergePeor = Arrays.copyOf(numeros_peor, numeros_peor.length);
            long tiempoMergePeor = medirTiempo(contexto, copiaMergePeor);
            System.out.println("Merge Peor Caso (" + tam + "): " + Arrays.toString(copiaMergePeor));
            System.out.println("Tiempo Merge Peor Caso: " + tiempoMergePeor + " ns");
            histograma.agregarTiempo("Merge (Peor)", tiempoMergePeor);

            ManejadorArchivos.escribirTiemposEnArchivo("src/main/java/datos/tiempos_algoritmos.txt", tam, tiempoBurbujaProm, tiempoBurbujaMejor, tiempoBurbujaPeor, tiempoQuickProm, tiempoQuickMejor, tiempoQuickPeor, tiempoInsertProm, tiempoInsertMejor, tiempoInsertPeor, tiempoMergeProm, tiempoMergeMejor, tiempoMergePeor);
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
