package dev.pradeep.OnArrivalAssignment.Services;

import dev.pradeep.OnArrivalAssignment.Dto.LocationDto;
import dev.pradeep.OnArrivalAssignment.Entity.Location;
import dev.pradeep.OnArrivalAssignment.Entity.LocationEntites.Feature;
import dev.pradeep.OnArrivalAssignment.Entity.UserRatings;
import dev.pradeep.OnArrivalAssignment.Repository.LocationRepository;
import dev.pradeep.OnArrivalAssignment.Repository.UserRatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class LocationService {

    @Value("${mapbox.secret.key}")
    public String mapBoxToken;

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private UserRatingsRepository userRatingsRepository;

    /*
        fetch data from mapbox live data
        Note - feature is a individual Location.
        Location is list of features
     */
    public List<Feature> fetchAllLocations(String location) {
        String baseUrl = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + location;
        String url = baseUrl + ".json?types=poi&access_token=" + mapBoxToken;

        ResponseEntity<Location> response = new RestTemplate().exchange(url, HttpMethod.GET, null, Location.class);
        Location mapBoxResponse = response.getBody();

        if (mapBoxResponse != null) {
            return mapBoxResponse.getLocations();
        } else {
            return Collections.emptyList();
        }
    }

    /*
        fetching the filtered data/DTO data for better understanding of data
     */
    public List<LocationDto> fetchAllLocationsByName(String location){
        List<Feature> features = fetchAllLocations(location);
        List<LocationDto> locations =  locationDtoMapper(features);
        return locations;
    }


    /*
        fetches live data
        custom data mapped to location dto
        has only required data/necessary data
        boilerplate code
        automatically adds up ratings here if the user has already rated and is stored in database then,
        by id it is automatically mapped with live data and rating is displayed
     */
    public List<LocationDto> locationDtoMapper(List<Feature> featureData){
        List<LocationDto> locationDto = new ArrayList<>();
        for (Feature feature: featureData){
            LocationDto location = new LocationDto();
            location.setId(feature.getId());
            location.setAddress(feature.getProperties().getAddress());
            location.setCategory(feature.getProperties().getCategory());
            location.setPlaceName(feature.getPlaceName());

            //add up ratings which is queried from database
            location.setRatings(avgRatings(feature.getId()));
            locationDto.add(location);
        }
        return locationDto;
    }

    public LocationDto locationDtoObjectMapper(Feature feature){
        LocationDto location = new LocationDto();
        location.setId(feature.getId());
        location.setAddress(feature.getProperties().getAddress());
        location.setCategory(feature.getProperties().getCategory());
        location.setPlaceName(feature.getPlaceName());

        //add up ratings which is queried from database
        location.setRatings(avgRatings(feature.getId()));
        return location;
    }

    /*
        Location schema: location name
                         list (locations)
        saves all the locations in database
        takes parameter a string : locationName
     */
    public void saveAllLocationByLocationName(String locationName) {
        Location location = new Location();

        location.locationName = locationName;
        // Fetch the locations using the mapbox API
        List<Feature> fetchedLocations = this.fetchAllLocations(locationName);

        // Set the fetched locations to the 'locations' field
        location.setLocations(fetchedLocations);

        // Check if the location already exists in the database
        Optional<Location> existingLocation = locationRepository.findById(locationName);

        if (existingLocation.isEmpty()) {
            // If the location doesn't exist, save it to the database
            this.locationRepository.save(location);
        } else {
            // If the location already exists, update it with the new locations
            existingLocation.get().setLocations(fetchedLocations);
            this.locationRepository.save(existingLocation.get());
        }
    }

    public float avgRatings(String locationId){
        float ans = 0;
        List<UserRatings> ratings = this.userRatingsRepository.findRatingsByLocationId(locationId);
        for (UserRatings ratings1: ratings){
            ans += ratings1.getRatings();
        }
        return Float.parseFloat(String.format("%.1f", ans/ratings.size()));
    }

    public void deleteLocationByName(String locationName) {
        Optional<Location> location = locationRepository.findById(locationName);
        if (location.isPresent())
            this.locationRepository.delete(location.get());
    }
}
