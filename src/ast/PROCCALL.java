package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class PROCCALL extends STATEMENT {
    private String name;


    @Override
    public void parse() {
        tokenizer.getAndCheckNext("call");
        name = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        BLOCK block = (BLOCK) Main.symbolTable.get(name);
        return block.evaluate();
    }
}
