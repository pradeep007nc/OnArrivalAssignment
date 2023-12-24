package dev.pradeep.OnTravelsAssignment.Repository;

import dev.pradeep.OnTravelsAssignment.Entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
