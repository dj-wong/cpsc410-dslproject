package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LOCATIONSDEC extends STATEMENT {
    private String name;
    private String locations;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("create locations");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("at");
        locations = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }
}
