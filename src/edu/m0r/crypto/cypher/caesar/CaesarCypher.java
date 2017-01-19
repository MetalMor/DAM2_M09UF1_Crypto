package edu.m0r.crypto.cypher.caesar;

import edu.m0r.crypto.cypher.AbstractCypher;
import edu.m0r.crypto.constants.Alphabet;
import edu.m0r.crypto.util.NumberUtils;
import edu.m0r.crypto.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para cifrar Strings con el método César.
 * @author m0R
 */
public class CaesarCypher extends AbstractCypher {
    private Integer _increment;
    
    public CaesarCypher(String message) {
        super(message);
    }
    
    public CaesarCypher(String message, int increment) {
        this(message);
        setIncrement(increment);
    }
    
    @Override
    public final void encrypt() {
        super.encrypt();
        if(!isEncrypted()) {
            List<String> letters = Alphabet.getLetters();
            List<Integer> indexes = StringUtils.getIndexList(getMessage(), letters);
            setMessage(StringUtils.buildFromIndexList(indexes, getLetters()));
            setEncrypted(true);
        }
        printMessage();
    }
    
    @Override
    public final void decrypt() {
        super.decrypt();
        if(isEncrypted()) {
            List<String> letters = Alphabet.getLetters();
            List<Integer> indexes = StringUtils.getIndexList(getMessage(), getLetters());
            setMessage(StringUtils.buildFromIndexList(indexes, letters));
            setEncrypted(false);
        }
        printMessage();
    }
    
    public int getIncrement() {
        if(_increment == null) {
            int max = Alphabet.getLetters().size(),
                    min = 1;
            setIncrement(NumberUtils.randomNumber(min, max));
        }
        return _increment;
    }
    
    public final void setIncrement(int increment) {
        _increment = increment;
    }
    
    private List<String> translateAlphabet() {
        List<String> result = new ArrayList<>(),
                letters = Alphabet.getLetters();
        boolean indexSign = getIncrement() > 0;
        int increment = Math.abs(getIncrement()),
                lastIndex = indexSign ? letters.size() : increment,
                firstIndex = indexSign ? lastIndex - increment : 0;
        List<String> subList = new ArrayList<>(letters.subList(firstIndex, lastIndex));
        letters.removeAll(subList);
        if(indexSign) {
            result.addAll(subList);
            result.addAll(letters);
        } else {
            result.addAll(letters);
            result.addAll(subList);
        }
        return result;
    }
    
    @Override
    public List<String> getLetters() {
        if(getIncrement() == 0) return Alphabet.getLetters();
        if(_letters == null) setLetters(translateAlphabet());
        return _letters;
    }
}
