package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LOCATIONSDEC extends STATEMENT {
    private List<String> names;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("new");
        names = new ArrayList<>();
        // TODO parse names
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }
}
