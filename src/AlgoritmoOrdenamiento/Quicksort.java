package AlgoritmoOrdenamiento;

import java.util.Arrays;

public class Quicksort {
    /**
     * Ordena un array de enteros usando el algoritmo QuickSort sin modificar el original.
     *
     * @param array El array de enteros desordenado.
     * @return Un nuevo array ordenado de menor a mayor.
     */
    public static int[] quickSort(int[] array) {
        // Copiamos el array para no modificar el original
        int[] copia = Arrays.copyOf(array, array.length);
        quickSortHelper(copia, 0, copia.length - 1);
        return copia;
    }

    /**
     * Método auxiliar recursivo para aplicar QuickSort en un subarray.
     *
     * @param array El array a ordenar.
     * @param low Índice inicial del subarray.
     * @param high Índice final del subarray.
     */
    private static void quickSortHelper(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSortHelper(array, low, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, high);
        }
    }
    /**
     * Particiona el array alrededor de un pivote.
     * Los elementos menores al pivote se colocan a la izquierda, los mayores a la derecha.
     *
     * @param array El array a particionar.
     * @param low Índice inicial del subarray.
     * @param high Índice final del subarray (donde se encuentra el pivote).
     * @return El índice final del pivote después de la partición.
     */
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];  // Elegimos el último elemento como pivote
        int i = low - 1;          // Índice del elemento más pequeño

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // Intercambiar array[i] y array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Intercambiar array[i+1] y array[high] (o pivote)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
