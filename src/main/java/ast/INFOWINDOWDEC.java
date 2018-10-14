package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class INFOWINDOWDEC extends STATEMENT {
    private String name;
    private String text;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("add infowindow");
        tokenizer.getAndCheckNext("to");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("with content");
        text = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }
}
