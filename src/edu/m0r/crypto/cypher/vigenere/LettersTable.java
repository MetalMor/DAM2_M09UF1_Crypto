package edu.m0r.crypto.cypher.vigenere;

import edu.m0r.crypto.util.MapUtils;
import java.util.Map;

/**
 *
 * @author m0R
 */
public class LettersTable {
    private Map<String, Map<String, String>> _letterMap;
    
    public LettersTable() { }
    
    public String getValue(String outerKey, String innerKey) {
        return MapUtils.getValue(outerKey, innerKey, getLetterMap());
    }
    
    public String getOuterKey(String innerKey, String value) {
        return MapUtils.getOuterKey(innerKey, value, getLetterMap());
    }
    
    public Map<String, Map<String, String>> getLetterMap() {
        if(_letterMap == null) _letterMap = MapUtils.buildLetterMap();
        return _letterMap;
    }
    
    public void setLetterMap(Map<String, Map<String, String>> letterMap) {
        _letterMap = letterMap;
    }
}
