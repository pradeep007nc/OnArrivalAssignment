package dev.pradeep.OnArrivalAssignment.Services;

import dev.pradeep.OnArrivalAssignment.Dto.BookingLocationDto;
import dev.pradeep.OnArrivalAssignment.Dto.LocationDto;
import dev.pradeep.OnArrivalAssignment.Entity.Booking;
import dev.pradeep.OnArrivalAssignment.Entity.Location;
import dev.pradeep.OnArrivalAssignment.Entity.LocationEntites.Feature;
import dev.pradeep.OnArrivalAssignment.Repository.BookingRepository;
import dev.pradeep.OnArrivalAssignment.Repository.LocationRepository;
import dev.pradeep.OnArrivalAssignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationService locationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;


    /*
    booking a individual location for the user
    location name has list of locations in that finding the location based on id
    and then the location is added to user object as LocationDto
 */
    public void bookLocation(BookingLocationDto bookingLocationDto){
      Optional<Booking> bookingData = bookingRepository.findById(bookingLocationDto.userId);

      if (bookingData.isPresent()){
          Optional<Location> locationsData = this.locationRepository.findById(bookingLocationDto.locationName);
          if (locationsData.isPresent()){
              for (Feature feature: locationsData.get().getLocations()){
                  if (bookingLocationDto.bookingLocationId.equals(feature.getId())){
                      LocationDto locationDto = this.locationService.locationDtoObjectMapper(feature);
                      bookingData.get().addBookings(locationDto);
                      bookingRepository.save(bookingData.get());
                  }
              }
          }
      }
    }

    public List<Booking> fetchAllBookings(){
        return this.bookingRepository.findAll();
    }

    /*
        takes userId as parameter and then returns bookings of the user
     */
    public List<LocationDto> fetchBookingsById(String userId){
        Optional<Booking> locationDtos = bookingRepository.findById(userId);
        if (locationDtos.isPresent()){
            return locationDtos.get().bookedLocations;
        }
        return new ArrayList<>();
    }

}
