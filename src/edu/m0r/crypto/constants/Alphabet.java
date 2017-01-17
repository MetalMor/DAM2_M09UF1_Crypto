package edu.m0r.crypto.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa el alfabeto utilizado para cifrar mensajes. Sólo permite
 * caracteres alfabéticos sin tildes.
 * @author m0R
 */
public class Alphabet {
    
    /**
     * Objeto controlador de números aleatorios.
     */
    private static Random _random;
    /**
     * Vector de letras del alfabeto.
     */
    private static final String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G",
                "H", "I", "J", "K", "L", "M" ,"N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"};
    
    /**
     * Retorna una lista de letras del alfabeto ordenadas.
     * @return Lista de letras del alfabeto ordenadas.
     */
    public static List<String> getLetters() {
        return getLetters(false);
    }
    
    /**
     * Retorna una lista de letras del alfabeto. Se pueden desordenar.
     * @param shuffle Indica si la función debe desordenar las letras (true).
     * @return Lista de letras del alfabeto. Si shuffle es true, estarán desordenadas.
     */
    public static List<String> getLetters(boolean shuffle) {
        List<String> letters = new ArrayList<>(Arrays.asList(LETTERS));
        if(shuffle) Collections.shuffle(letters, getRandom());
        return letters;
    }
    
    /**
     * Retorna el controlador de números aleatorios.
     * @return Controlador de números aleatorios.
     */
    public static Random getRandom() {
        if(_random == null) setRandom(new Random(System.nanoTime()));
        return _random;
    }
    
    /**
     * Define el controlador de números aleatorios.
     * @param random Controlador de números aleatorios.
     */
    public static void setRandom(Random random) {
        _random = random;
    }
}
