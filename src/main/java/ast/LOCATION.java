package ast;

import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.GeocodingApi;
import ui.Main;

import java.io.IOException;

public class LOCATION {
    private String location;
    private double lat;
    private double lng;

    LOCATION(String location) {
        this.location = location;
        processLocation();
    }

    private void processLocation() {
        if (location.matches("\\{(.*?)\\}")) {
            getGeoCodedLocation();
        } else {
            String[] latLng = location.split(",");
            if (latLng.length != 2) {
                System.out.println("More than 2 elements in lat lng");
                System.exit(1);
            }
            lat = Double.parseDouble(latLng[0]);
            lng = Double.parseDouble(latLng[1]);
        }
        System.out.println("lat: " + lat);
        System.out.println("lng: " + lng);
    }

    private void getGeoCodedLocation() {
        GeoApiContext context = Main.getGeoApiContext();
        String address = location.substring(location.indexOf("{") + 1, location.indexOf("}"));
        System.out.println("Geocoding: " + address);
        try {

            GeocodingResult[] results =  GeocodingApi.geocode(context, address).await();
            lat = results[0].geometry.location.lat;
            lng = results[0].geometry.location.lng;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
