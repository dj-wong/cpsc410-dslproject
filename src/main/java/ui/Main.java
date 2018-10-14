package ui;

import ast.PROGRAM;
import libs.Tokenizer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {
    public static JSONObject obj = new JSONObject();

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        List<String> literals = Arrays.asList("create location ", "create locations ", "create marker",
                "create markers ", "create line", "create shape", "between", "around",
                "add infowindow", "with content", " at ", " to ");
        Tokenizer.makeTokenizer("input.tvar",literals);
        PROGRAM p = new PROGRAM();
        p.parse();
        p.evaluate();
        System.out.println("completed successfully");
    }

}
