package ast;

import org.json.JSONArray;
import org.json.JSONObject;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

public class SHAPEDEC extends POLYLOCATIONDEC {
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
        JSONObject shapes = Main.getShapes();
        JSONArray paths = this.evaluateLocations(locationNames);
        JSONObject newShape = new JSONObject();

        newShape.put("locations", paths);
        shapes.put(name, newShape);
        return null;
    }
}
