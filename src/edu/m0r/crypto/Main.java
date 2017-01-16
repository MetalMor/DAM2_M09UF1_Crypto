package edu.m0r.crypto;

import edu.m0r.crypto.util.InputUtils;
import edu.m0r.crypto.encryption.Caesar;
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
        String message = getInput().readString();
        System.out.println("U wrote: " + message);
        Caesar c = new Caesar(message);
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
