package ast;

import org.json.JSONException;
import org.json.JSONObject;
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
        JSONObject element = getElement();
        System.out.println("Adding infowindow to " + name + " with " + text);
        if (element == null) {
            System.out.println("Could not find " + name + " object");
            System.exit(1);
        }
        element.put("text", text);
        return null;
    }

    private JSONObject getElement() {
        JSONObject markers = Main.getMarkers();
        JSONObject lines = Main.getLines();
        JSONObject shapes = Main.getShapes();

        Object element = null;
        try {
            element = markers.get(name);
        } catch(JSONException e) { }

        if (element == null) {
            try {
                element = lines.get(name);
            } catch(JSONException e) { }
        }

        if (element == null) {
            try {
                element = shapes.get(name);
            } catch(JSONException e) { }
        }
        return (JSONObject) element;
    }
}
