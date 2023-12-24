package dev.pradeep.OnTravelsAssignment.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.pradeep.OnTravelsAssignment.Dto.LocationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "bookings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
