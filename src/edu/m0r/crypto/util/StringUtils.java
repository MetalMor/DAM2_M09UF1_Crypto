package edu.m0r.crypto.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m0R
 */
public class StringUtils {
    
    public static List<Integer> getIndexList(String word, List<String> letters) {
        List<Integer> result = new ArrayList<>();
        int length = word.length(), index = 0;
        while(index < length) 
            result.add(letters.indexOf(word.substring(index++, index)));
        return result;
    }
    
    public static String buildFromIndexList(List<Integer> indexes, List<String> letters) {
        StringBuilder sb = new StringBuilder();
        for(Integer index : indexes) 
            sb.append(index < 0 ? " " : letters.get(index));
        return sb.toString();
    }
}
