package dev.pradeep.OnTravelsAssignment.Entity.LocationEntites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


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