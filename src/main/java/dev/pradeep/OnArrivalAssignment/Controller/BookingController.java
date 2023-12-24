package dev.pradeep.OnArrivalAssignment.Controller;

import dev.pradeep.OnArrivalAssignment.Dto.BookingLocationDto;
import dev.pradeep.OnArrivalAssignment.Dto.LocationDto;
import dev.pradeep.OnArrivalAssignment.Entity.Booking;
import dev.pradeep.OnArrivalAssignment.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book_location")
    public ResponseEntity<?> bookLocation(@RequestBody BookingLocationDto bookingLocationDto){
        this.bookingService.bookLocation(bookingLocationDto);
        return ResponseEntity.status(200).body("successfully booked");
    }

    @GetMapping("/show_bookings")
    public ResponseEntity<List<Booking>> showAllBookings(){
        return ResponseEntity.status(200).body(bookingService.fetchAllBookings());
    }

    @GetMapping("/show_bookings/{userId}")
    public ResponseEntity<List<LocationDto>> showLocationById(String userId){
        return ResponseEntity.status(200).body(this.bookingService.fetchBookingsById(userId));
    }

}
