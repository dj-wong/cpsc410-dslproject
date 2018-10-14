package ast;

import org.json.JSONObject;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MARKERSDEC extends STATEMENT {
    private List<String> names;
    private List<String> locationNames;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("create markers");
        String namesToParse = tokenizer.getNext();
        tokenizer.getAndCheckNext("at");
        String locationNamesToParse = tokenizer.getNext();

        String[] nameList = namesToParse.split(",");
        String[] locationsList = locationNamesToParse.split(",");
        if (nameList.length != locationsList.length) {
            System.out.println("Incorrect number of markers and locations");
            System.exit(1);
        }
        names = new ArrayList<String>();
        locationNames = new ArrayList<String>();
        for(int i = 0; i < nameList.length; i++) {
            names.add(nameList[i].trim());
        }
        for(int i = 0; i < locationsList.length; i++) {
            locationNames.add(locationsList[i].trim());
        }

    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        HashMap<String, LOCATION> locationHashMap = Main.getLocationHashMap();
        JSONObject markers = Main.getMarkers();
        int len = names.size();
        for (int i = 0; i < len; i++) {
            String name = names.get(i);
            String locationName = locationNames.get(i);

            LOCATION location = locationHashMap.get(locationName);
            JSONObject newLoc = new JSONObject();
            newLoc.put("lat", location.getLat());
            newLoc.put("lng", location.getLng());

            markers.put(name, newLoc);
        }
        return null;
    }
}
