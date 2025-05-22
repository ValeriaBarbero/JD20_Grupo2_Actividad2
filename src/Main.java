import Utils.BinarySearch;
import Utils.MergeSort;
import Utils.NumberGenerator;
import Utils.SecretMessage;
import helpers.NumberOpcion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Generar arreglo y preparar todo antes del menú
        int[] numeros = NumberGenerator.generarNumerosAleatorios(1000, 1000, 9999);
        int claveMagica;
        int margen ;
        int minPista;
        int maxPista;
        String mensajeSecreto = SecretMessage.obtenerMensajeAleatorio();

        long tiempoInicioOrdenamiento = System.nanoTime();
        MergeSort.ordenar(numeros);
        long tiempoFinOrdenamiento = System.nanoTime();

        // Menú principal
        do {
            System.out.println("\n===== 🏰 MENÚ DEL CÁLIZ DE LOS CÓDIGOS PERDIDOS 🏰 =====");
            System.out.println("1. ⚔️ Adentrarse en el mundo del Cáliz de los Códigos Perdidos");
            System.out.println("2. 🚪 Salir del reino");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    claveMagica = NumberGenerator.seleccionarClave(numeros);
                    margen = 5;
                    minPista = Math.max(claveMagica - margen, 1000);
                    maxPista = Math.min(claveMagica + margen, 9999);
                    iniciarMundoCaliz(scanner, numeros, claveMagica, mensajeSecreto, minPista, maxPista, tiempoInicioOrdenamiento, tiempoFinOrdenamiento);
                    break;
                case 2:
                    System.out.println("Te has retirado del Cáliz de los Códigos Perdidos. Hasta una próxima aventura...");
                    break;
                default:
                    System.out.println("⚠️ Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 2);

        scanner.close();
    }

    public static void iniciarMundoCaliz(Scanner scanner, int[] numeros, int claveMagica, String mensajeSecreto,
                                         int minPista, int maxPista,
                                         long tiempoInicioOrdenamiento, long tiempoFinOrdenamiento) {

        // Mostrar pista y arreglo
        System.out.println("\n🔢 Arreglo generado:");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();

        System.out.println("🔎 Pista: El número mágico está entre " + minPista + " y " + maxPista + ".");

        System.out.println("\n📊 Arreglo ordenado:");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();

        boolean encontrado = false;

        while (!encontrado) {
            System.out.println("\n🔍 Ingresa un número mágico para encontrar el mensaje secreto:");
            int intento = NumberOpcion.GetOpcion();

            long tiempoInicioBusqueda = System.nanoTime();
            int indice = BinarySearch.buscar(numeros, intento);
            long tiempoFinBusqueda = System.nanoTime();

            if (indice != -1 && numeros[indice] == claveMagica) {
                System.out.println("✅ ¡Correcto! Mensaje del Oráculo: " + mensajeSecreto);
                encontrado = true;

                System.out.println("\n⏱️ Tiempos de ejecución:");
                System.out.printf("🌀 Ordenamiento (MergeSort): %.4f ms\n", (tiempoFinOrdenamiento - tiempoInicioOrdenamiento) / 1e6);
                System.out.printf("🔎 Búsqueda binaria: %.4f ms\n", (tiempoFinBusqueda - tiempoInicioBusqueda) / 1e6);
            } else if (indice != -1) {
                System.out.println("❌ Ese número está en el cáliz... pero no es el correcto. Intenta de nuevo.");
            } else {
                System.out.println("🚫 Ese número no está en el arreglo. Asegúrate de probar uno de los que ves.");
            }
        }
    }
}
