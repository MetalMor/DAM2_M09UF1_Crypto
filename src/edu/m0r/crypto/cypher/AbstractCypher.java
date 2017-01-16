package edu.m0r.crypto.cypher;

import edu.m0r.crypto.constants.Variables;
import java.util.List;

/**
 *
 * @author becari
 */
public abstract class AbstractCypher {
    protected List<String> _letters;
    private String _message;    
    private boolean _encrypted = false;
    
    public AbstractCypher() { }
    
    public AbstractCypher(String message) {
        this();
        setMessage(message);
    }
    
    public abstract void encrypt();
    public abstract void decrypt();
    
    public void printMessage() {
        printMessage("Message: ");
    }
    
    private void printMessage(String label) {
        System.out.println(label + getMessage());
    }
    
    public List<String> getLetters() {
        if(_letters == null) setLetters(Variables.getLetters());
        return _letters;
    }
    
    protected void setLetters(List<String> letters) {
        _letters = letters;
    }
    
    public String getMessage() {
        return _message;
    }
    
    public void setMessage(String message) {
        _message = message.toUpperCase();
    }
    
    public boolean isEncrypted() {
        return _encrypted;
    }
    
    protected final void setEncrypted(boolean encrypted) {
        _encrypted = encrypted;
    }
}
