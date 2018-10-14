package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class MARKERDEC extends STATEMENT {
    private String name;
    private String locationName;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("create marker");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("at");
        locationName = tokenizer.getNext();

    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }
}
