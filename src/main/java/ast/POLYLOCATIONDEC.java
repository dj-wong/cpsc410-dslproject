package ast;

import org.json.JSONArray;
import org.json.JSONObject;
import ui.Main;

import java.util.HashMap;
import java.util.List;

public abstract class POLYLOCATIONDEC extends STATEMENT {

    public JSONArray evaluateLocations(String locationNames) {
        HashMap<String, LOCATION> locationHashMap = Main.getLocationHashMap();
        HashMap<String, List<LOCATION>> locationListHashMap = Main.getLocationListHashMap();
        JSONArray paths = new JSONArray();
        if (locationNames.matches("\\[(.*?)\\]")) {
            String[] locations = locationNames.substring(locationNames.indexOf("[") + 1, locationNames.indexOf("]")).split(",");
            for(int i = 0; i < locations.length; i++) {
                LOCATION location = locationHashMap.get(locations[i].trim());
                JSONObject newLoc = new JSONObject();
                newLoc.put("lat", location.getLat());
                newLoc.put("lng", location.getLng());
                paths.put(newLoc);
            }
        } else {
            List<LOCATION> locations = locationListHashMap.get(locationNames);
            for(LOCATION location: locations) {
                JSONObject newLoc = new JSONObject();
                newLoc.put("lat", location.getLat());
                newLoc.put("lng", location.getLng());
                paths.put(newLoc);
            }
        }
        return paths;
    }
}
