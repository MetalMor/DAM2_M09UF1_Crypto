package edu.m0r.crypto.util;

import edu.m0r.crypto.constants.Variables;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author m0R
 */
public class MapUtils {
    private static Map<String, String> buildLetterMapMember(int increment) {
        List<String> letters = new ArrayList(Variables.getLetters()),
                keys = new ArrayList<>(letters);
        int index = 0, length = keys.size();
        List<String> subLetters = keys.subList(length - 1 - increment, length);
        List<String> values;
        if(!subLetters.isEmpty()) {
            letters.removeAll(subLetters);
            values = new ArrayList<>(subLetters);
            values.addAll(letters);
        } else values = new ArrayList<>(letters);
        Map<String, String> letterMap = new HashMap<>();
        while(index < length)
            letterMap.put(keys.get(index), values.get(index++));
        return letterMap;
    }
    
    public static Map<String, Map<String, String>> buildLetterMap() {
        List<String> keys = Variables.getLetters();
        Map<String, Map<String, String>> letterMap = new HashMap<>();
        int index = 0, length = keys.size();
        while(index < length)
            letterMap.put(keys.get(index), buildLetterMapMember(index++));
        return letterMap;
    }
    
    public static String getValue(String outerKey, String innerKey, Map<String, Map<String, String>> letterMap) {
        return getInnerMap(outerKey, letterMap).get(innerKey);
    }
    
    public static Map<String, String> getInnerMap(String outerKey, Map<String, Map<String, String>> letterMap) {
        return letterMap.get(outerKey);
    }
    
    public static String getOuterKey(String innerKey, String value, Map<String, Map<String, String>> letterMap) {
        Set<String> keys = letterMap.keySet();
        Map<String, String> innerMap;
        for(String key: keys) {
            innerMap = letterMap.get(key);
            if(innerMap.get(innerKey).equals(value))
                return key;
        }
        return value;
    }
}
