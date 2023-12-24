package dev.pradeep.OnArrivalAssignment.Repository;

import dev.pradeep.OnArrivalAssignment.Entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
    Optional<Location> findById(String locationName);
}
