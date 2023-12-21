package dev.pradeep.OnTravelsAssignment.Entity;

import dev.pradeep.OnTravelsAssignment.Entity.LocationEntites.Feature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/*
    locations object to store the features and send this data to rest api
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private List<Feature> features;
}
