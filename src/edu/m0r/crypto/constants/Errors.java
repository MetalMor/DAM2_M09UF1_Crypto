package edu.m0r.crypto.constants;

/**
 *
 * @author m0R
 */
public class Errors {
    public static final String ERROR_WRONG_NUMBER_INPUT = "Wrong keyboard input: only integer numbers.";
    
    private static void printError(String strErr) {
        System.out.println(strErr);
    }
    
    public static void wrongNumberInput() {
        printError(ERROR_WRONG_NUMBER_INPUT);
    }
    
    public static String randomNumberRangeError(int min, int max) {
        return "Number " + min + " cannot be greater or equal than " + max;
    }
}
