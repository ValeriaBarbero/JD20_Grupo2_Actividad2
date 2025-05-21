package Utils;
import java.util.Random;
public class SecretMessage {
    private static final String[] mensajes = {
            "El portal al reino sumergido se abrirá cuando el sol cruce la cima del monte hueco.",
            "Bajo la tercera luna de piedra, encontrarás la biblioteca olvidada del conocimiento prohibido.",
            "El mapa del tesoro está oculto en la última página del códice rojo, sellado por el sabio Alerion."
    };

    public static String obtenerMensajeAleatorio() {
        Random random = new Random();
        return mensajes[random.nextInt(mensajes.length)];
    }
}
