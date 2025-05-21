

import Utils.BinarySearch;
import Utils.MergeSort;
import Utils.NumberGenerator;
import Utils.SecretMessage;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Generar arreglo de 1000 números aleatorios entre 1000 y 9999
        int[] numeros = NumberGenerator.generarNumerosAleatorios(1000, 1000, 9999);

        // Mostrar el arreglo generado
        System.out.println("🔢 Arreglo generado:");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();

        // Seleccionar clave mágica aleatoriamente del arreglo
        int claveMagica = NumberGenerator.seleccionarClave(numeros);

        // Generar pista: mostrar un rango alrededor de la clave (por ejemplo, ±50)
        int margen = 5;
        int minPista = Math.max(claveMagica - margen, 1000);  // No menor a 1000
        int maxPista = Math.min(claveMagica + margen, 9999);  // No mayor a 9999

        System.out.println("🔎 Pista: El número mágico está entre " + minPista + " y " + maxPista + ".");

        // Obtener un mensaje secreto aleatorio
        String mensajeSecreto = SecretMessage.obtenerMensajeAleatorio();

        // Medir tiempo de ejecución del ordenamiento
        long tiempoInicioOrdenamiento = System.nanoTime();
        MergeSort.ordenar(numeros);
        long tiempoFinOrdenamiento = System.nanoTime();

        // Mostrar arreglo ordenado
        System.out.println("\n📊 Arreglo ordenado:");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();

        // Crear escáner para entrada del usuario
        Scanner scanner = new Scanner(System.in);
        boolean encontrado = false;

        // Repetir hasta que el usuario acierte
        while (!encontrado) {
            System.out.println("\n🔍 Ingresa un número mágico para encontrar el mensaje secreto:");
            int intento = scanner.nextInt();

            // Medir tiempo de búsqueda binaria
            long tiempoInicioBusqueda = System.nanoTime();
            int indice = BinarySearch.buscar(numeros, intento);
            long tiempoFinBusqueda = System.nanoTime();

            // Evaluar si el número ingresado es la clave mágica
            if (indice != -1 && numeros[indice] == claveMagica) {
                System.out.println("✅ ¡Correcto! Mensaje del Oráculo: " + mensajeSecreto);
                encontrado = true;

                // Mostrar tiempos de ejecución
                System.out.println("\n⏱️ Tiempos de ejecución:");
                System.out.printf("🌀 Ordenamiento (MergeSort): %.4f ms\n", (tiempoFinOrdenamiento - tiempoInicioOrdenamiento) / 1e6);
                System.out.printf("🔎 Búsqueda binaria: %.4f ms\n", (tiempoFinBusqueda - tiempoInicioBusqueda) / 1e6);
            } else if (indice != -1) {
                System.out.println("❌ Ese número está en el cáliz... pero no es el correcto. Intenta de nuevo.");
            } else {
                System.out.println("🚫 Ese número no está en el arreglo. Asegúrate de probar uno de los que ves.");
            }
        }

        scanner.close(); // Cerramos el escáner al final del programa
    }
}