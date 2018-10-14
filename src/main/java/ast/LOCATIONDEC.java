package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class LOCATIONDEC extends STATEMENT {
    private String name;
    private LOCATION location;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("create location");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("at");
        location = new LOCATION(tokenizer.getNext());
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        HashMap<String, LOCATION> locationHashMap = Main.getLocationHashMap();
        locationHashMap.put(name, location);
        return null;
    }
}
