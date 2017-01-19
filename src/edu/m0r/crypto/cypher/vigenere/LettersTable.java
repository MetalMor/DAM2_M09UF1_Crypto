package edu.m0r.crypto.cypher.vigenere;

import edu.m0r.crypto.util.MapUtils;
import java.util.Map;

/**
 * Una tabla de equivalencia de claves alfabeticas. La clave externa corresponde
 * al mensaje que se encripta con la tabla, y la clave interna es la palabra
 * introducida por el usuario para cifrar el mensaje.
 * @author m0R
 */
public class LettersTable {
    /**
     * Tabla alfabetica.
     */
    private Map<String, Map<String, String>> _letterMap;
    
    /**
     * Constructor vacio.
     */
    public LettersTable() {
        initLetterMap();
    }
    
    /**
     * Retorna el valor que corresponde a las claves.
     * @param outerKey Clave que corresponde al mensaje.
     * @param innerKey Clave que cifra el mensaje.
     * @return El valor que corresponde a las claves interna y externa del mapa.
     */
    public String getValue(String outerKey, String innerKey) {
        return MapUtils.getValue(outerKey, innerKey, getLetterMap());
    }
    
    /**
     * Retorna la clave externa.
     * @param innerKey Clave que cifra el mensaje.
     * @param value Valor que corresponde a las claves.
     * @return Clave externa.
     */
    public String getOuterKey(String innerKey, String value) {
        return MapUtils.getOuterKey(innerKey, value, getLetterMap());
    }
    
    /**
     * Retorna el mapa alfabetico.
     * @return Mapa alfabetico bidimensional.
     */
    public Map<String, Map<String, String>> getLetterMap() {
        if(_letterMap == null) initLetterMap();
        return _letterMap;
    }
    /**
     * Define el mapa alfabetico.
     * @param letterMap Mapa alfabetico.
     */
    public void setLetterMap(Map<String, Map<String, String>> letterMap) {
        _letterMap = letterMap;
    }
    
    /**
     * Inicializa el mapa alfabetico.
     */
    private void initLetterMap() {
        setLetterMap(MapUtils.buildLetterMap());
    }
}
