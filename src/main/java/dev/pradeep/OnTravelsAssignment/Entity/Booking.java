package dev.pradeep.OnTravelsAssignment.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.pradeep.OnTravelsAssignment.Dto.LocationDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "bookings")
public class Booking {

    @Id
    public String userId;

    @JsonProperty(required = false)
    public List<LocationDto> bookedLocations;

    public void addBookings(LocationDto locationDto){
        if (bookedLocations == null){
            bookedLocations = new ArrayList<>();
        }
        bookedLocations.add(locationDto);
    }
}
