package dev.pradeep.OnTravelsAssignment.Controller;

import dev.pradeep.OnTravelsAssignment.Entity.UserRatings;
import dev.pradeep.OnTravelsAssignment.Services.UserRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;

import java.util.List;


/*
    controller for rating a location if saved in database
    integrated to live apis if the location id and user id is saved in database then display the ratings in both mapbox live data and saved data
    any request need authentication
    in postman choose basic auth in username enter email
    in password enter user password
    ex:
    {
        "email": "pradeepnaidu2486@gmail.com",
        "password": "demouser"
    }
 */

@RestController
@RequestMapping("/api/ratings")
public class UserRatingsController {

    @Autowired
    private UserRatingsService userRatingsService;

    /*
     takes userRatings object as a parameter
     save user ratings
  */
    @PostMapping("/save_ratings")
    public ResponseEntity<?> saveRatings(@RequestBody UserRatings userRatings){
        this.userRatingsService.addRatings(userRatings);
        return ResponseEntity.status(200).body("Successfully added ratings");
    }

    /*
        all rated locations
     */
    @GetMapping("/get_all_ratings")
    public ResponseEntity<List<UserRatings>> getRatings(){
        return ResponseEntity.status(200).body(this.userRatingsService.fetchAllRatings());
    }

    /*
        rated by locationName
     */
    @GetMapping("/get_all_ratings/{locationName}")
    public ResponseEntity<List<UserRatings>> getRatingsByLocationName(@PathVariable String locationName){
        return ResponseEntity.status(200).body(this.userRatingsService.fetchByLocationName(locationName));
    }
}
