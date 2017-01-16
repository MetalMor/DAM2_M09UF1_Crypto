package edu.m0r.crypto;

import edu.m0r.crypto.util.InputUtils;
import edu.m0r.crypto.cypher.caesar.CaesarCypher;
import edu.m0r.crypto.cypher.vigenere.VigenereCypher;
import java.util.Scanner;

/**
 * Clase principal
 * @author m0R
 */
public class Main {

    private static InputUtils _input;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Write smth:");
        //String message = getInput().readString();
        String message = "la cacatua voladora";
        VigenereCypher c = new VigenereCypher(message);
        c.setKey("HOWDY");
        c.encrypt();
        c.decrypt();
    }
    
    public static InputUtils getInput() {
        if(_input == null) _input = new InputUtils(new Scanner(System.in));
        return _input;
    }
    
    public static void setInput(InputUtils input) {
        _input = input;
    }
    
}
