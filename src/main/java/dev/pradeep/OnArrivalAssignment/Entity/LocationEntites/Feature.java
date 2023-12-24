package dev.pradeep.OnArrivalAssignment.Entity.LocationEntites;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;


/*
    feature is a individual tourist location
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feature {

    private String id;
    private String type;
    private List<String> placeType;
    private int relevance;
    private Properties properties;
    private String text;
    private String placeName;
    private List<Double> center;
    private List<Context> context;


    /*
        this data structure takes two parameters userid and ratings for this tourist attraction object
        by default map doesn't take duplicate values so no user can rate twice
     */
    private Map<String, @Min(0) @Max(5) Integer> touristRatings;

    /*
        Finding average rating of a individual tourist location
     */
    public int findAvgRatings(){
        int avgRatings = 0;
        for (Integer rating: touristRatings.values()){
            avgRatings += rating;
        }
        return avgRatings/touristRatings.size();
    }

}
