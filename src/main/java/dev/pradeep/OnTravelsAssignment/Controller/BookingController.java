package dev.pradeep.OnTravelsAssignment.Controller;

import dev.pradeep.OnTravelsAssignment.Dto.BookingRequest;
import dev.pradeep.OnTravelsAssignment.Entity.Booking;
import dev.pradeep.OnTravelsAssignment.Services.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    booking service controller
 */

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    /*
        controller to fetch all the bookings done by all the users
     */
    @GetMapping("/all_bookings")
    public ResponseEntity<List<Booking>> listAllBookings(){
        return ResponseEntity.status(200).body(this.bookingService.showAllBookings());
    }


    /*
        controller to save the booking
        booking saves a user and is mapped with list of locations/places for what tourist has booked
        POST Request body takes user id and location id as parameter
        ex
        {
             "userId": "658413342ac5f17963d2dc49",
             "locationId": "poi.1159641213378"
        }
     */
    @PostMapping("/save_booking")
    public ResponseEntity<?> saveBooking(@RequestBody BookingRequest bookingRequest){
        this.bookingService.saveBooking(bookingRequest.userId, bookingRequest.locationId);
        return ResponseEntity.ok("Successfully booked");
    }

    /*
        delete a particular location of a usr
     */
    //todo

    /*
        delete all the bookings done by user
     */
    @DeleteMapping("/delete_booking/{userId}")
    public ResponseEntity<?> deleteBooking(@PathVariable String userId){
        this.bookingService.deleteBookingById(userId);
        return ResponseEntity.ok("Successfully deleted");
    }

}
