package edu.m0r.crypto.cypher.caesar;

import edu.m0r.crypto.cypher.AbstractCypher;
import edu.m0r.crypto.constants.Variables;
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
    
    public CaesarCypher() { }
    
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
            List<String> letters = Variables.getLetters();
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
            List<String> letters = Variables.getLetters();
            List<Integer> indexes = StringUtils.getIndexList(getMessage(), getLetters());
            setMessage(StringUtils.buildFromIndexList(indexes, letters));
            setEncrypted(false);
        }
        printMessage();
    }
    
    public int getIncrement() {
        if(_increment == null) {
            int max = Variables.getLetters().size(),
                    min = 1;
            setIncrement(NumberUtils.randomNumber(min, max));
        }
        return _increment;
    }
    
    public final void setIncrement(int increment) {
        _increment = increment;
    }
    
    @Override
    public List<String> getLetters() {
       if(_letters == null) {
            List<String> letters = Variables.getLetters();
            int lastIndex = letters.size();
            List<String> subList = new ArrayList<>(letters.subList(lastIndex - getIncrement(), lastIndex)),
                    result = new ArrayList<>();
            letters.removeAll(subList);
            result.addAll(subList);
            result.addAll(letters);
            setLetters(result);
        }
        return _letters;
    }
}
