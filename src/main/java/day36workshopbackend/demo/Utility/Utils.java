package day36workshopbackend.demo.Utility;

import java.io.StringReader;
import java.math.BigDecimal;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Utils {

    public static JsonObject JsonOutput(String json) {

        JsonReader jr = Json.createReader(new StringReader(json));
        JsonObject jo = jr.readObject();

        JsonArray ja = jo.getJsonArray("weather");
        
        JsonObject weather = ja.getJsonObject(0);


        JsonObject coord = jo.getJsonObject("coord");
        JsonObject wind = jo.getJsonObject("wind");
        JsonObject main = jo.getJsonObject("main");

        return Json.createObjectBuilder()
                .add("main", weather.getString("main"))
                .add("description", weather.getString("description"))
                .add("lat", BigDecimal.valueOf(coord.getJsonNumber("lat").doubleValue()))
                .add("lon", BigDecimal.valueOf(coord.getJsonNumber("lon").doubleValue()))
                .add("temp", BigDecimal.valueOf(main.getJsonNumber("temp").doubleValue()))
                .add("humidity", main.getInt("humidity"))
                .add("visibility", jo.getInt("visibility"))
                .add("windSpeed", BigDecimal.valueOf(wind.getJsonNumber("speed").doubleValue()))
                .build();
    }
    
}
