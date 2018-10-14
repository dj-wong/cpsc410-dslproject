package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MARKERSDEC extends STATEMENT {
    private String names;
    private String locationNames;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("create markers");
        names = tokenizer.getNext();
        tokenizer.getAndCheckNext("at");
        locationNames = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }
}
