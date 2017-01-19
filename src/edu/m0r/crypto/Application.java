package edu.m0r.crypto;

import edu.m0r.crypto.constants.Errors;
import edu.m0r.crypto.cypher.ICypher;
import edu.m0r.crypto.cypher.caesar.CaesarCypher;
import edu.m0r.crypto.util.InputUtils;
import edu.m0r.crypto.cypher.vigenere.VigenereCypher;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal: ejecuta el programa.
 * @author m0R
 */
public class Application {

    /**
     * Objeto cifrador.
     */
    private static ICypher _cypher;
    /**
     * Objeto que controla la entrada de datos por teclado.
     */
    private static InputUtils _input;
    /**
     * Mensaje que será cifrado.
     */
    private static String _message;
    
    /**
     * Método principal.
     * @param args Argumentos del intérprete de comandos.
     */
    public static void main(String[] args) {
        while (!askMessage().isEmpty()) {
            chooseMode();
            getCypher().encrypt();
            getInput().readString();
            getCypher().decrypt();
        }
        System.out.println("Stopping...");
    }
    
    /**
     * Pide al usuario que introduzca un mensaje para ser encriptado.
     */
    private static String askMessage() {
        System.out.println("Enter a message to encrypt: ");
        String message = getInput().readString();
        setMessage(message);
        return message;
    }
    
    /**
     * Pide al usuario que introduzca un valor numérico para identificar
     * el modo de cifrado.
     */
    public static void chooseMode() {
        System.out.println("Choose encryption mode. 1: Caesar, 2: Vigenère");
        Integer[] allowed = {1, 2};
        List<Integer> allowedList = Arrays.asList(allowed);
        ICypher cypher = null;
        Integer mode, increment = null;
        String key;
        do {
            System.out.println("Mode: ");
            mode = getInput().readInt();
            if(mode != null)
                switch(mode) {
                    case 1:
                        System.out.println("Give a number: ");
                        do {
                            increment = getInput().readInt();
                        } while(increment == null);
                        cypher = new CaesarCypher(getMessage(), increment);
                        break;
                    case 2:
                        System.out.println("Give a key: ");
                        do {
                            key = getInput().readString();
                        } while(key.isEmpty());
                        cypher = new VigenereCypher(getMessage(), key);
                        break;
                    default:
                        Errors.wrongNumberInput();
                        break;
                }
        } while(!allowedList.contains(mode));
        setCypher(cypher);
    }
    
    /**
     * Retorna el mensaje a cifrar.
     * @return Mensaje que será cifrado.
     */
    public static String getMessage() {
        return _message;
    }
    
    /**
     * Define el mensaje a cifrar.
     * @param message Mensaje que será cifrado.
     */
    public static void setMessage(String message) {
        _message = message;
    }
    
    /**
     * Retorna el objeto cifrador.
     * @return Objeto cifrador.
     */
    public static ICypher getCypher() {
        return _cypher;
    }
    
    /**
     * Define el objeto cifrador.
     * @param cypher Objeto cifrador.
     */
    public static void setCypher(ICypher cypher) {
        _cypher = cypher;
    }
    
    /**
     * Retorna el objeto que controla la entrada de datos por teclado.
     * @return Objeto que controla la entrada de datos por teclado.
     */
    public static InputUtils getInput() {
        if(_input == null) setInput(new InputUtils(new Scanner(System.in)));
        return _input;
    }
    
    /**
     * Define el objeto que controla la entrada de datos por teclado.
     * @param input Objeto que controla la entrada de datos por teclado.
     */
    public static void setInput(InputUtils input) {
        _input = input;
    }
    
}
