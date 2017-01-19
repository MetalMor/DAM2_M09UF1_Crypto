package edu.m0r.crypto.cypher.vigenere;

import edu.m0r.crypto.cypher.AbstractCypher;

/**
 *
 * @author m0R
 */
public class VigenereCypher extends AbstractCypher {
    private String _key;
    private LettersTable _table;
    
    public VigenereCypher(String message) {
        super(message);
        setTable(new LettersTable());
    }
    
    public VigenereCypher(String message, String key) {
        this(message);
        setKey(key);
    }
    
    @Override
    public void encrypt() {
        super.encrypt();
        if(!isEncrypted() && getKey() != null) {
            StringBuilder sb = new StringBuilder();
            String outerKey, innerKey;
            int index = 0, length = getMessage().length();
            while(index < length) {
                outerKey = String.valueOf(getMessage().charAt(index));
                innerKey = String.valueOf(getKey().charAt(index++));
                sb.append(getTable().getValue(outerKey, innerKey));
            }
            setMessage(sb.toString());
            setEncrypted(true);
        }
        printMessage();
    }
    
    @Override
    public void decrypt() { 
        super.decrypt();
        if(isEncrypted() && getKey() != null) {
            StringBuilder sb = new StringBuilder();
            String value, innerKey;
            int index = 0, length = getMessage().length();
            while(index < length) {
                value = String.valueOf(getMessage().charAt(index));
                innerKey = String.valueOf(getKey().charAt(index++));
                sb.append(getTable().getOuterKey(innerKey, value));
            }
            setMessage(sb.toString());
            setEncrypted(false);
        }
        printMessage();
    }
    
    public LettersTable getTable() {
        if(_table == null) setTable(new LettersTable());
        return _table;
    }
    
    private void setTable(LettersTable table) {
        _table = table;
    }
    
    public String getKey() {
        return _key;
    }
    
    @Override
    public void setMessage(String message) {
        super.setMessage(message);
        if(getKey() != null) setKey(getKey());
    }
    
    public final void setKey(String key) {
        key = key.toUpperCase();
        if(getMessage() != null) {
            int length = getMessage().length(), index = 0;
            while(key.length() < length) 
                key = key.concat(String.valueOf(key.charAt(index++%key.length())));
        }
        _key = key;
    }
}
