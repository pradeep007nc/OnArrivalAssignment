package dev.pradeep.OnTravelsAssignment.Controller;

import dev.pradeep.OnTravelsAssignment.Entity.LocationEntites.Feature;
import dev.pradeep.OnTravelsAssignment.Services.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
    location controller
    GET find_locations/{locationName} for ex : find_locations/kolkata -> returns list of tourist attraction places
    POST save_locations/{locationName} -> saves all the data in database
    GET saved_locations/{locationId} -> fetch all data
 */

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    /*
        note - this data is fetched from mapbox
        not saved in database live data rendered from mapbox
        controller to find all the tourist locations/ poi(point of interest) that are based on location name
     */
    @GetMapping("/find_locations/{locationName}")
    public ResponseEntity<List<Feature>> test(@PathVariable String locationName) {
        return ResponseEntity.ok().body(this.locationService.fetchAllLocations(locationName));
    }

    /*
        controller to save location based on location name in database
     */
    @PostMapping("/save_locations/{locationName}")
    public void saveLocations(@PathVariable String locationName){
        this.locationService.saveAllLocations(locationName);
    }

    /*
        controller to get all the data
     */
    @GetMapping("/saved_locations/{locationId}")
    public List<Feature> savedLocations(@PathVariable String locationId){
        return this.locationService.fetchAllLocations(locationId);
    }


}
