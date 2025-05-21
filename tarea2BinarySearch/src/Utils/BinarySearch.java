package Utils;

public class BinarySearch {
    public static int buscar(int[] arr, int clave) {
        int izquierda = 0;
        int derecha = arr.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arr[medio] == clave)
                return medio;
            else if (arr[medio] < clave)
                izquierda = medio + 1;
            else
                derecha = medio - 1;
        }

        return -1;
    }
}
