package dev.pradeep.OnArrivalAssignment.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.pradeep.OnArrivalAssignment.Entity.LocationEntites.Feature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Locations")
public class Location {

    @Id
    public String locationName;

    @JsonProperty(value = "features")
    public List<Feature> locations;

}
