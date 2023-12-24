package dev.pradeep.OnTravelsAssignment.Repository;

import dev.pradeep.OnTravelsAssignment.Entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
    Optional<Location> findById(String locationName);
}
