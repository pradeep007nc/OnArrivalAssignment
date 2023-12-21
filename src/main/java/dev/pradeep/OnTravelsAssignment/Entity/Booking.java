package dev.pradeep.OnTravelsAssignment.Entity;

import dev.pradeep.OnTravelsAssignment.Entity.LocationEntites.Feature;
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
    public User user;

    public List<Feature> bookedLocations;

    public void addFeature(Feature feature){
        if(bookedLocations == null){
            bookedLocations = new ArrayList<>();
        }
        bookedLocations.add(feature);
    }
}
