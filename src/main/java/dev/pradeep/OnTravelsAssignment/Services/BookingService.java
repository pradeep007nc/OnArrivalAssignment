package dev.pradeep.OnTravelsAssignment.Services;


import dev.pradeep.OnTravelsAssignment.Entity.Booking;
import dev.pradeep.OnTravelsAssignment.Entity.Location;
import dev.pradeep.OnTravelsAssignment.Entity.LocationEntites.Feature;
import dev.pradeep.OnTravelsAssignment.Entity.User;
import dev.pradeep.OnTravelsAssignment.Repositories.BookingRepository;
import dev.pradeep.OnTravelsAssignment.Repositories.LocationRepository;
import dev.pradeep.OnTravelsAssignment.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
*
* booking service to write the logic for booking of locations which is mapped with a user
*
* */

@Service
public class BookingService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    /*
        User object has list of saved features/tourist attractions
        in the list of tourist attractions whichever locationId is matched add that to bookings
        feature is a individual tourist spot
     */
    public void saveBooking(String userId, String locationId){
        Optional<User> userData = this.userRepository.findById(userId);
        if (userData.isEmpty()){
            List<Feature> features = locationRepository.findAll();
            if (locationRepository.existsById(locationId)){
                Optional<Feature> locationData = locationRepository.findById(locationId);
                Booking booking = new Booking();
                booking.user = userData.get();
                booking.bookedLocations.add(locationData.get());
                this.bookingRepository.save(booking);
            }
        }
    }

    public List<Booking> showAllBookings(){
        return this.bookingRepository.findAll();
    }

    public void deleteBookingById(String userId){
        Optional<User> user = this.userRepository.findById(userId);
        if (user.isPresent()){
            this.bookingRepository.deleteById(user.get());
        }
    }

}
