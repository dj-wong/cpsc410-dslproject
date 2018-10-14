package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class LINEDEC extends STATEMENT {
    private String name;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("new");
        name = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }
}
