package edu.m0r.crypto.cypher;

import edu.m0r.crypto.constants.Alphabet;
import java.util.List;

/**
 * Clase abstracta que representa un objeto cifrador. Está diseñada para ser
 * heredada por una subclase que implemente los métodos de encriptar y desencriptar.
 * @author m0R
 */
public abstract class AbstractCypher implements ICypher {
    /**
     * Alfabeto que el cifrador utilizará.
     */
    protected List<String> _letters;
    /**
     * Mensaje que el cifrador manipula.
     */
    private String _message;    
    /**
     * Flag que indica si el mensaje está encriptado.
     */
    private boolean _encrypted = false;
    
    /**
     * Constructor vacío.
     */
    private AbstractCypher() { }
    
    /**
     * Constructor con parámetro de mensaje. Crea el cifrador con el mensaje
     * definido.
     * @param message Mensaje que el cifrador manipulará.
     */
    public AbstractCypher(String message) {
        this();
        setMessage(message);
    }
    
    /**
     * Encripta el mensaje. Es necesario implementar el método en una subclase.
     */
    @Override
    public void encrypt() {
        System.out.println("Encrypting message...");
    }
    /**
     * Desencripta el mensaje. Es necesario implementar el método en una subclase.
     */
    @Override
    public void decrypt() {
        System.out.println("Decrypting message...");
    }
    
    /**
     * Escribe por el terminal el mensaje que contiene el cifrador, indicando si
     * está encriptado o desencriptado.
     */
    @Override
    public void printMessage() {
        String status = isEncrypted() ? "Encrypted" : "Decrypted";
        printMessage(status + " message: ");
    }
    
    /**
     * Escribe por el terminal el mensaje que contiene el cifrador, con la etiqueta
     * especificada.
     * @param label Etiqueta que encabeza el mensaje en el terminal.
     */
    private void printMessage(String label) {
        System.out.println(label + getMessage());
    }
    
    /**
     * Retorna el alfabeto que usa el cifrador. Si no se ha definido, se generará
     * antes de retornarlo.
     * @return Lista de letras del alfabeto.
     */
    public List<String> getLetters() {
        if(_letters == null) setLetters(Alphabet.getLetters());
        return _letters;
    }
    
    /**
     * Define el alfabeto que usará el cifrador.
     * @param letters Lista de letras del alfabeto.
     */
    protected void setLetters(List<String> letters) {
        _letters = letters;
    }
    
    /**
     * Retorna el mensaje que contiene el cifrador.
     * @return Mensaje que contiene el cifrador.
     */
    public String getMessage() {
        return _message;
    }
    
    /**
     * Define el mensaje que contiene el cifrador.
     * @param message Mensaje que contiene el cifrador.
     */
    public void setMessage(String message) {
        _message = message.toUpperCase();
    }
    
    /**
     * Retorna true si el mensaje está encriptado.
     * @return 
     */
    public boolean isEncrypted() {
        return _encrypted;
    }
    
    /**
     * Define si el mensaje está encriptado.
     * @param encrypted Flag que será true si el mensaje está encriptado.
     */
    protected final void setEncrypted(boolean encrypted) {
        _encrypted = encrypted;
    }
}
