package ui;

import ast.LOCATION;
import ast.PROGRAM;
import libs.Tokenizer;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import com.google.maps.GeoApiContext;

public class Main {
    private static HashMap<String, LOCATION> locationHashMap = new HashMap<String, LOCATION>();
    private static HashMap<String, List<LOCATION>> locationListHashMap = new HashMap<String, List<LOCATION>>();
    public static JSONObject json = new JSONObject();
    private static GeoApiContext geoApiContext = new GeoApiContext.Builder().apiKey("API_KEY").build();

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        List<String> literals = Arrays.asList("create location ", "create locations ", "create marker ",
                "create markers ", "create line", "create shape", "between", "around",
                "add infowindow", "with content", " at ", " to ");
        Tokenizer.makeTokenizer("input.tvar",literals);
        PROGRAM p = new PROGRAM();
        p.parse();
        json.put("markers", new JSONObject());
        json.put("shapes", new JSONObject());
        json.put("lines", new JSONObject());
        p.evaluate();
        String jsonString = json.toString(4);
        System.out.println(jsonString);
        FileWriter fileWriter = new FileWriter("./src/web/fixtures/mapData.json", true);
        try {
            fileWriter.write(jsonString);
            System.out.println("Successfully Copied JSON Object to File...");
        } catch (IOException e) {
            System.out.println("Failed to write to json file");
            e.printStackTrace();
            System.exit(1);
        } finally {
            fileWriter.flush();
            fileWriter.close();
        }
        System.out.println("completed successfully");
    }

    public static GeoApiContext getGeoApiContext() {
        return geoApiContext;
    }

    public static HashMap<String, LOCATION> getLocationHashMap() {
        return locationHashMap;
    }

    public static HashMap<String, List<LOCATION>> getLocationListHashMap() {
        return locationListHashMap;
    }

    public static JSONObject getMarkers() {
        return json.getJSONObject("markers");
    }

    public static JSONObject getShapes() {
        return json.getJSONObject("shapes");
    }

    public static JSONObject getLines() {
        return json.getJSONObject("lines");
    }
}
