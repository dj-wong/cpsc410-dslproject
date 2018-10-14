package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MARKERSDEC extends STATEMENT {
    private List<String> names;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("create markers");
        names = new ArrayList<>();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }
}
