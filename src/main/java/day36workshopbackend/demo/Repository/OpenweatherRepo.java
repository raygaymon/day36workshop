package day36workshopbackend.demo.Repository;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import day36workshopbackend.demo.Utility.Utils;
import jakarta.json.JsonObject;

@Repository
public class OpenweatherRepo {
    
    @Value("${openweather.api.url}")
    private String apiURL;

    @Value("${openweather.api.key}")
    private String apiKey;

    public JsonObject getCityWeather (String country ){

        URI url = UriComponentsBuilder.fromUriString(apiURL).queryParam("q", country).queryParam("appid", apiKey).build().toUri();

        RequestEntity<Void> req = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();

        RestTemplate rest = new RestTemplate();

        return Utils.JsonOutput((rest.exchange(req, String.class)).getBody());
    }
}
