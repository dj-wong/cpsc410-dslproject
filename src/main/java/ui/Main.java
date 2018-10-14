package ui;

import ast.PROGRAM;
import libs.Tokenizer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.maps.GeoApiContext;

public class Main {
    public static JSONObject obj = new JSONObject();
    private static GeoApiContext geoApiContext = new GeoApiContext.Builder().apiKey("API_KEY").build();

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

    public static GeoApiContext getGeoApiContext() {
        return geoApiContext;
    }
}
