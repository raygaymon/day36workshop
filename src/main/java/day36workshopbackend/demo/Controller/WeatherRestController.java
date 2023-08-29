package day36workshopbackend.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import day36workshopbackend.demo.Repository.OpenweatherRepo;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path="/api")
@CrossOrigin
public class WeatherRestController {
    
    @Autowired
    private OpenweatherRepo repo;

    @GetMapping(path="/weather/{city}", produces = "application/json")
    public ResponseEntity<String> getCityWeather (@PathVariable("city") String city){

        JsonObject weather = repo.getCityWeather(city);

        if (weather != null){
            return ResponseEntity.ok(weather.toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
