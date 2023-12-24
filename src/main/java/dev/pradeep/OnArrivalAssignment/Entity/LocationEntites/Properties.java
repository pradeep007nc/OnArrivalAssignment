package dev.pradeep.OnArrivalAssignment.Entity.LocationEntites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Properties {
    private String foursquare;
    private boolean landmark;
    private String address;
    private String category;

}