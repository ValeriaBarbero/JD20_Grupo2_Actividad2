import AlgoritmoOrdenamiento.Quicksort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int[] desordenado = {34, 7, 23, 32, 5, 62};

        int[] ordenado = Quicksort.quickSort(desordenado);

        System.out.println("Original: " + Arrays.toString(desordenado));
        System.out.println("Ordenado: " + Arrays.toString(ordenado));
    }

}