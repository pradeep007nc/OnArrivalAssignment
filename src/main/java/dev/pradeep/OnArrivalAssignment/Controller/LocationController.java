package dev.pradeep.OnArrivalAssignment.Controller;

import dev.pradeep.OnArrivalAssignment.Dto.LocationDto;
import dev.pradeep.OnArrivalAssignment.Entity.LocationEntites.Feature;
import dev.pradeep.OnArrivalAssignment.Services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    controller for tourist attraction data and rating tourist destination
    in postman choose basic auth in username enter email
    in password enter user password
    ex:
    {
        "email": "pradeepnaidu2486@gmail.com",
        "password": "demouser"
    }
 */

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/dummy_test")
    public List<String> test(){
        return Stream.of("demo", "pradeep").collect(Collectors.toList());
    }

    /*
        controller to fetch live locations from mapbox
        takes parameter location name and returns list of all tourist attractions in that location
        ex: http://localhost:8080/api/locations/raw_mapbox_locations/kolkata
        returns raw data fetched from mapbox
     */
    @GetMapping("/raw_mapbox_locations/{locationName}")
    public ResponseEntity<List<Feature>> fetchAllLocations(@PathVariable String locationName){
           return ResponseEntity.status(200).body(this.locationService.fetchAllLocations(locationName));
    }

    /*
        also fetches data from mapbox live data but returns filtered data
        takes location name as parameter and returns location dto
        ex:   http://localhost:8080/api/locations/fetch_locations/kolkata
        {
        "id": "poi.68719527974",
        "placeName": null,
        "address": "palace Rd.",
        "category": "mall, shop",
        "ratings": null
      }
     */
    @GetMapping("/fetch_locations/{locationName}")
    public List<LocationDto> fetchRefinedLocations(@PathVariable String locationName){
        return this.locationService.fetchAllLocationsByName(locationName);
    }

    /*
        save filtered data in database
     */
    @PostMapping("/save_locations/{locationName}")
    public ResponseEntity<?> saveLocations(@PathVariable String locationName){
        this.locationService.saveAllLocationByLocationName(locationName);
        return ResponseEntity.status(200).body("saved data successfully");
    }

    /*
        delete location from the database
     */
    @DeleteMapping("/delete_locations/{locationName}")
    public ResponseEntity<?> deleteLocationByLocationName(@PathVariable String locationName){
        this.locationService.deleteLocationByName(locationName);
        return ResponseEntity.status(200).body("deleted successfully");
    }

}
