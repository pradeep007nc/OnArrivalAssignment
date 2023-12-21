package dev.pradeep.OnTravelsAssignment.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.pradeep.OnTravelsAssignment.Entity.LocationEntites.Feature;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


/*
* User object
* user can add list of locations to its own object
* */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "age")
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feature> savedSpots;

    public void addLocations(Feature feature){
        if (this.savedSpots == null){
            this.savedSpots = new ArrayList<>();
        }
        this.savedSpots.add(feature);
    }
}
