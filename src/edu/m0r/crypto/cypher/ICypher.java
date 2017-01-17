package edu.m0r.crypto.cypher;

/**
 * Interfaz que enmascara cifradores con los métodos necesarios para manipular los mensajes.
 * @author m0R
 */
public interface ICypher {
    /**
     * Encripta el mensaje que el cifrador ha recibido.
     */
    public void encrypt();
    /**
     * Desencripta el mensaje que el cifrador ha ofuscado.
     */
    public void decrypt();
    /**
     * Escribe el mensaje, en el estado en el que se encuentre, por el terminal.
     */
    public void printMessage();
}
