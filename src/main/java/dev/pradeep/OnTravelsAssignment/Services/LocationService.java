package dev.pradeep.OnTravelsAssignment.Services;

import dev.pradeep.OnTravelsAssignment.Entity.Location;
import dev.pradeep.OnTravelsAssignment.Entity.LocationEntites.Feature;
import dev.pradeep.OnTravelsAssignment.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


/*
    location service
    using Mapbox api to fetch data
    Populate to java objects and then consume or store
 */
@Service
public class LocationService {

    @Value("${mapbox.secret.key}")
    public String mapBoxToken;

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }


    //refernce
    //https://api.mapbox.com/geocoding/v5/mapbox.places/Kolkata.json?types=poi&access_token=pk.eyJ1IjoicHJhZGVlcDAwN25jIiwiYSI6ImNscWNkZjhjbDAwc3EyaW1lYzBieGVoOWUifQ.8wSihNaRUQ2yOEjDg8CY_A
    public List<Feature> fetchAllLocations(String location) {
        String baseUrl = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + location;
        String url = baseUrl + ".json?types=poi&access_token=" + mapBoxToken;

        ResponseEntity<Location> response = new RestTemplate().exchange(url, HttpMethod.GET, null, Location.class);
        System.out.println("worked till here");
        Location mapBoxResponse = response.getBody();

        if (mapBoxResponse != null) {
            return mapBoxResponse.getFeatures();
        } else {
            return Collections.emptyList();
        }
    }

    public void saveAllLocations(String location){
        List<Feature> locations = this.fetchAllLocations(location);

        for (Feature feature: locations){
            Optional<Feature> data = this.locationRepository.findById(feature.getId());
            if (data.isEmpty()){
                this.locationRepository.save(feature);
            }
        }
    }

}
