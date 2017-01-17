package edu.m0r.crypto;

import edu.m0r.crypto.cypher.ICypher;
import edu.m0r.crypto.cypher.caesar.CaesarCypher;
import edu.m0r.crypto.util.InputUtils;
import edu.m0r.crypto.cypher.vigenere.VigenereCypher;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal
 * @author m0R
 */
public class Main {

    private static ICypher _cypher;
    private static InputUtils _input;
    private static String _message;
    private static String _param;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        askMessage();
        chooseMode();
        getCypher().encrypt();
        getInput().readString();
        getCypher().decrypt();
    }
    
    public static void askMessage() {
        System.out.println("Enter a message to encrypt: ");
        String message;
        do {
            message = getInput().readString();
        } while(message == null || message.isEmpty());
        setMessage(message);
    }
    
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
                        } while(key == null || key.isEmpty());
                        cypher = new VigenereCypher(getMessage(), key);
                        break;
                    default:
                        System.out.println("Wrong mode, try again.");
                        break;
                }
        } while(!allowedList.contains(mode));
        setCypher(cypher);
    }
    
    public static String getMessage() {
        return _message;
    }
    
    public static void setMessage(String message) {
        _message = message;
    }
    
    public static String getParam() {
        return _param;
    }
    
    public static void setParam(String param) {
        _param = param;
    }
    
    public static ICypher getCypher() {
        return _cypher;
    }
    
    public static void setCypher(ICypher cypher) {
        _cypher = cypher;
    }
    
    public static InputUtils getInput() {
        if(_input == null) setInput(new InputUtils(new Scanner(System.in)));
        return _input;
    }
    
    public static void setInput(InputUtils input) {
        _input = input;
    }
    
}
