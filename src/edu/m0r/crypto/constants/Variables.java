package edu.m0r.crypto.constants;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author becari
 */
public class Variables {
    private static final String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G",
                "H", "I", "J", "K", "L", "M" ,"N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"};
    
    public static List<String> getLetters() {
        return Arrays.asList(LETTERS);
    }
}
