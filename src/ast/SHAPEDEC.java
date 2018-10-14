package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class SHAPEDEC extends STATEMENT {
    private String name;
    private String locationNames;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("create shape");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("around");
        locationNames = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }
}
