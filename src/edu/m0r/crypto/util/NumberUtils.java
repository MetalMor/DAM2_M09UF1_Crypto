package edu.m0r.crypto.util;

import edu.m0r.crypto.constants.Errors;
import java.util.Random;

/**
 *
 * @author m0R
 */
public class NumberUtils {
    
    private static Random _random = new Random();
    
    public static int randomNumber(int min, int max) throws IllegalArgumentException {
        if (max <= min) 
            throw new IllegalArgumentException(Errors.randomNumberRangeError(min, max));
        return getRandom().nextInt(max - min) + min;
    }
    
    public static Random getRandom() {
        return _random;
    }
    
    public static void setRandom(Random random) {
        _random = random;
    }
}
