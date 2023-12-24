package dev.pradeep.OnTravelsAssignment.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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