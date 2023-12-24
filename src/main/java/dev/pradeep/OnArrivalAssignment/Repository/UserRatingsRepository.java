package dev.pradeep.OnArrivalAssignment.Repository;

import dev.pradeep.OnArrivalAssignment.Entity.UserRatings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRatingsRepository extends MongoRepository<UserRatings, String> {
    List<UserRatings> findRatingsByLocationId(String locationId);
}
