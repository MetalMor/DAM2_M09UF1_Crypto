package edu.m0r.crypto.util;

import edu.m0r.crypto.constants.Errors;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author m0R
 */
public class InputUtils {
    
    private Scanner _scanner;
    
    public InputUtils() { }
    
    public InputUtils(Scanner scanner) {
        this();
        setScanner(scanner);
    }
    
    public String readString() {
        return getScanner().nextLine();
    }
    
    public Integer readInt() throws InputMismatchException {
        Integer input;
        do {
            try {
                input = getScanner().nextInt();
            } catch(InputMismatchException imEx) {
                System.out.println("Wrong input: only numbers.");
                input = null;
                setScanner(new Scanner(System.in));
            }
        } while(input == null);
        return input;
    }
    
    public Scanner getScanner() {
        if(_scanner == null) setScanner(new Scanner(System.in));
        return _scanner;
    }
    
    public final void setScanner(Scanner scanner) {
        if(scanner != null) _scanner = scanner;
    }
}
