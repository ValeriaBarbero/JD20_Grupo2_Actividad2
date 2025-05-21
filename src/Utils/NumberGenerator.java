package Utils;

import java.util.Random;
public class NumberGenerator {
    private static Random random = new Random();
    private static int clave;

    public static int[] generarNumerosAleatorios(int cantidad, int min, int max) {
        int[] numeros = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            numeros[i] = random.nextInt(max - min + 1) + min;
        }
        return numeros;
    }

    public static int seleccionarClave(int[] array) {
        int indice = random.nextInt(array.length);
        clave = array[indice];
        return clave;
    }

    public static int getClave() {
        return clave;
    }
}
