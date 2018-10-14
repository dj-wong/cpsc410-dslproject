package ast;

import org.json.JSONArray;
import org.json.JSONObject;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class SHAPEDEC extends STATEMENT {
    private String name;
    private String locationNames;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("create shape");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("around");
        locationNames = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        HashMap<String, LOCATION> locationHashMap = Main.getLocationHashMap();
        JSONObject shapes = Main.getShapes();
        JSONArray paths = new JSONArray();
        return null;
    }
}
