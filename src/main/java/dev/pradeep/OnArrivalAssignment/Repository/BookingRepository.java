package dev.pradeep.OnArrivalAssignment.Repository;

import dev.pradeep.OnArrivalAssignment.Entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
