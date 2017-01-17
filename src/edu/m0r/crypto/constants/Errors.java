package edu.m0r.crypto.constants;

/**
 * Clase que contiene información para manejar los errores de la aplicación.
 * @author m0R
 */
public class Errors {
    /**
     * String error de entrada por teclado. Sólo números.
     */
    public static final String ERROR_WRONG_NUMBER_INPUT = "Wrong keyboard input: only integer numbers.";
    /**
     * String error de clave externa del cifrador Vigenère.
     */
    public static final String ERROR_MISSING_OUTER_KEY = "Could not find outer key.";
    
    /**
     * Escribe una cadena de error por el terminal.
     * @param strErr Cadena de error.
     */
    private static void printError(String strErr) {
        System.out.println(strErr);
    }
    
    /**
     * Escribe por el terminal la cadena de error de entrada por teclado numérico.
     */
    public static void wrongNumberInput() {
        printError(ERROR_WRONG_NUMBER_INPUT);
    }
    
    /**
     * Retorna un mensaje de error de rangos numéricos.
     * @param min Mínimo.
     * @param max Máximo.
     * @return Mensaje de error de rangos numéricos.
     */
    public static String randomNumberRangeError(int min, int max) {
        return "Number " + min + " cannot be greater or equal than " + max;
    }
}
