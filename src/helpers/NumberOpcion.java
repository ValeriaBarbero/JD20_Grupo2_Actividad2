package helpers;

import java.util.Scanner;

public class NumberOpcion {
    public static int GetOpcion(){
        Scanner scanner = new Scanner(System.in);
        int opcion=0;
        boolean salir = true;
        while(salir){
            try {
                opcion = scanner.nextInt();
            }catch (Exception e){
                System.out.println("⚠️ Opción no válida. Intenta de nuevo.");
                scanner.nextLine(); // Limpiar el buffer
            }
            salir = false;
        }
        return opcion;
    }
}
