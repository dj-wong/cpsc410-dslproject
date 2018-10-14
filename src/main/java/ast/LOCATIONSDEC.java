package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LOCATIONSDEC extends STATEMENT {
    private String name;
    private List<LOCATION> locationsList;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("create locations");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("at");
        String locations = tokenizer.getNext();
        locations = locations.substring(locations.indexOf("[") + 1, locations.indexOf("]"));
        String[] locationsToParse = locations.split(";");
        locationsList = new ArrayList<LOCATION>();
        for (int i = 0; i < locationsToParse.length; i++) {
            String location = locationsToParse[i].trim();
            locationsList.add(new LOCATION(location));
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        HashMap<String, List<LOCATION>> locationListHashMap = Main.getLocationListHashMap();
        locationListHashMap.put(name, locationsList);
        return null;
    }
}
