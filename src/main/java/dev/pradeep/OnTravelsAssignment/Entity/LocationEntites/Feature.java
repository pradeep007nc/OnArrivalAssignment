package dev.pradeep.OnTravelsAssignment.Entity.LocationEntites;
import dev.pradeep.OnTravelsAssignment.Entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
