package dev.pradeep.OnTravelsAssignment.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingLocationDto {
    public String userId;
    public String locationName;
    public String bookingLocationId;
}
