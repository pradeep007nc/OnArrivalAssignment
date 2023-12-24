package dev.pradeep.OnTravelsAssignment.Services;

import dev.pradeep.OnTravelsAssignment.Dto.LocationDto;
import dev.pradeep.OnTravelsAssignment.Entity.Location;
import dev.pradeep.OnTravelsAssignment.Entity.UserRatings;
import dev.pradeep.OnTravelsAssignment.Repository.LocationRepository;
import dev.pradeep.OnTravelsAssignment.Repository.UserRatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.awt.desktop.OpenFilesEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRatingsService {

    @Autowired
    private LocationService locationService;
    @Autowired
    private UserRatingsRepository userRatingsRepository;

    @Autowired
    private LocationRepository locationRepository;

    /*
       save the user ratings in database
    */
    public void addRatings(UserRatings userRatings){
        this.userRatingsRepository.save(userRatings);
    }

    public List<UserRatings> fetchAllRatings() {
        return this.userRatingsRepository.findAll();
    }

    //method to map all location to user rating dto
    public List<UserRatings> fetchByLocationName(String locationName){
        Optional<Location> location= this.locationRepository.findById(locationName);
        if (location.isPresent()){
            List<LocationDto> locationDtos = locationService.locationDtoMapper(location.get().locations);
            List<UserRatings> userRatings = new ArrayList<>();

            for (LocationDto locationDto: locationDtos){
                UserRatings ratings = new UserRatings();
                ratings.locationId = locationDto.id;
                ratings.setRatings(locationDto.ratings);
                userRatings.add(ratings);
            }

            return userRatings;
        }
     return new ArrayList<>();
    }
}
