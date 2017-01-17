package edu.m0r.crypto.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author becari
 */
public class Variables {
    
    private static Random _random;
    private static final String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G",
                "H", "I", "J", "K", "L", "M" ,"N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"};
    
    public static List<String> getLetters() {
        return getLetters(false);
    }
    
    public static List<String> getLetters(boolean shuffle) {
        List<String> letters = new ArrayList<>(Arrays.asList(LETTERS));
        if(shuffle) Collections.shuffle(letters, getRandom());
        return letters;
    }
    
    public static Random getRandom() {
        if(_random == null) setRandom(new Random(System.nanoTime()));
        return _random;
    }
    
    public static void setRandom(Random random) {
        _random = random;
    }
}
