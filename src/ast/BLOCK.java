package ast;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class BLOCK extends STATEMENT {
    List<STATEMENT> statements;
    String retval;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("start");
        statements = new ArrayList<>();
        while (!tokenizer.checkToken("return")){
            STATEMENT s = STATEMENT.getSubStatement();
            statements.add(s);
            s.parse();
        }
        tokenizer.getAndCheckNext("return");
        retval = tokenizer.getNext();
        tokenizer.getAndCheckNext("end");
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        for (STATEMENT s : statements){
            s.evaluate();
        }
        return retval;
    }
}
