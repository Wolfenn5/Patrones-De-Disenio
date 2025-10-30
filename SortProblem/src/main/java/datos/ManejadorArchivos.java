package datos;

public class ManejadorArchivos {
    /**
     * Escribe los tiempos de ejecucion en un archivo separado por comas.
     * 
     * @param nombreArchivo Ruta del archivo donde guardar los datos.
     * @param n             Tamaño del arreglo probado.
     * @param tiempoBurbujaProm  Tiempo del algoritmo Burbuja Promedio.
     * @param tiempoQuickProm    Tiempo del algoritmo Quick Promedio.
     * @param tiempoInsertProm   Tiempo del algoritmo Insertion Promedio.
     * @param tiempoMergeProm    Tiempo del algoritmo Merge Promedio.
     * @param tiempoBurbujaMejor Tiempo del algoritmo Burbuja Mejor.
     * @param tiempoQuickMejor   Tiempo del algoritmo Quick Mejor.
     * @param tiempoInsertMejor  Tiempo del algoritmo Insertion Mejor.
     * @param tiempoMergeMejor   Tiempo del algoritmo Merge Mejor.
     * @param tiempoBurbujaPeor  Tiempo del algoritmo Burbuja Peor
     * @param tiempoQuickPeor    Tiempo del algoritmo Quick Peor.
     * @param tiempoInsertPeor   Tiempo del algoritmo Insertion Peor.
     * @param tiempoMergePeor    Tiempo del algoritmo Merge Peor.
     */
    public static void escribirTiemposEnArchivo(String nombreArchivo, int n, long tiempoBurbujaProm, long tiempoBurbujaMejor,long tiempoBurbujaPeor, long tiempoQuickProm,
            long tiempoQuickMejor, long tiempoQuickPeor, long tiempoInsertProm, long tiempoInsertMejor, long tiempoInsertPeor, long tiempoMergeProm, long tiempoMergeMejor, long tiempoMergePeor) {
        try {
            java.io.FileWriter fw = new java.io.FileWriter(nombreArchivo, true);
            fw.write(n + "," + tiempoBurbujaProm + "," + tiempoBurbujaMejor + "," + tiempoBurbujaPeor + "," + tiempoQuickProm + "," + tiempoQuickMejor + "," + tiempoQuickPeor + "," + tiempoInsertProm + "," + tiempoInsertMejor + "," + tiempoInsertPeor + "," + tiempoMergeProm + "," + tiempoMergeMejor + "," + tiempoMergePeor + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    /**
     * Escribe el encabezado en el archivo de tiempos de algoritmos.
     * Si el archivo ya existe, lo sobrescribe.
     * El encabezado contiene los nombres de las columnas: n, burbuja, quick,
     * insertion, merge.
     */
    public static void escribirEncabezado() {
        try {
            java.io.FileWriter fw = new java.io.FileWriter("src/main/java/datos/tiempos_algoritmos.txt");
            fw.write("n,burbuja_promedio,burbuja_mejor,burbuja_peor,quick_promedio,quick_mejor,quick_peor,insertion_promedio,insertion_mejor,insertion_peor,merge_promedio,merge_mejor,merge_peor\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el encabezado: " + e.getMessage());
        }
    }
}
