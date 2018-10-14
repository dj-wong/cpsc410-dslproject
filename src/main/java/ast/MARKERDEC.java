package ast;

import org.json.JSONObject;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class MARKERDEC extends STATEMENT {
    private String name;
    private String locationName;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("create marker");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("at");
        locationName = tokenizer.getNext();

    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        HashMap<String, LOCATION> locationHashMap = Main.getLocationHashMap();
        JSONObject markers = Main.getMarkers();
        LOCATION location = locationHashMap.get(locationName);
        JSONObject newLoc = new JSONObject();
        newLoc.put("lat", location.getLat());
        newLoc.put("lng", location.getLng());
        
        markers.put(name, newLoc);
        return null;
    }
}
