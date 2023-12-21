package dev.pradeep.OnTravelsAssignment.Repositories;


import dev.pradeep.OnTravelsAssignment.Entity.Booking;
import dev.pradeep.OnTravelsAssignment.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookingRepository extends MongoRepository<Booking, User> {
}
