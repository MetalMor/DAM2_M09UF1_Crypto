package edu.m0r.crypto.encryption;

import edu.m0r.crypto.constants.Variables;
import edu.m0r.crypto.util.NumberUtils;
import edu.m0r.crypto.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author m0R
 */
public class Caesar {
    private List<String> _letters;
    private String _message;
    private Integer _increment;
    private boolean _encrypted = false;
    
    public Caesar() { }
    
    public Caesar(String message) {
        this();
        setMessage(message);
    }
    
    public Caesar(String message, int increment) {
        this(message);
        setIncrement(increment);
    }
    
    public String getMessage() {
        return _message;
    }
    
    public final void encrypt() {
        if(!isEncrypted()) {
            List<String> letters = Arrays.asList(Variables.LETTERS);
            List<Integer> indexes = StringUtils.getIndexList(getMessage(), letters);
            setMessage(StringUtils.buildFromIndexList(indexes, getLetters()));
            setEncrypted(true);
        }
        printMessage("Encrypted message: ");
    }
    
    public final void decrypt() {
        if(isEncrypted()) {
            List<String> letters = Arrays.asList(Variables.LETTERS);
            List<Integer> indexes = StringUtils.getIndexList(getMessage(), getLetters());
            setMessage(StringUtils.buildFromIndexList(indexes, letters));
            setEncrypted(false);
        }
        printMessage("Decrypted message: ");
    }
    
    private void printMessage() {
        printMessage("");
    }
    
    private void printMessage(String label) {
        System.out.println(label + getMessage());
    }
    
    public final void setMessage(String message) {
        _message = message;
    }
    
    public int getIncrement() {
        if(_increment == null) {
            int max = Arrays.asList(Variables.LETTERS).size(),
                    min = 1;
            setIncrement(NumberUtils.randomNumber(min, max));
        }
        return _increment;
    }
    
    public final void setIncrement(int increment) {
        _increment = increment;
    }
    
    public List<String> getLetters() {
        if(_letters == null) {
            List<String> letters = new ArrayList<>(Arrays.asList(Variables.LETTERS));
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
    
    public void setLetters(List<String> letters) {
        _letters = letters;
    }
    
    public boolean isEncrypted() {
        return _encrypted;
    }
    
    public final void setEncrypted(boolean encrypted) {
        _encrypted = encrypted;
    }
}
