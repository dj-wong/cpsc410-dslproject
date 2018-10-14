package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class LOCATIONDEC extends STATEMENT {
    private String name;
    private String location;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("create location");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("at");
        location = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }
}
