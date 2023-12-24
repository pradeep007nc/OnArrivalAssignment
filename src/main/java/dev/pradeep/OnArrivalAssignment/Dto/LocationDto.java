package dev.pradeep.OnArrivalAssignment.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
    location dto for better communication of rest data
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    public String id;
    public String placeName;
    public String address;
    public String category;
    public float ratings;


}