package dev.pradeep.OnTravelsAssignment.Repository;

import dev.pradeep.OnTravelsAssignment.Entity.UserRatings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRatingsRepository extends MongoRepository<UserRatings, String> {
    List<UserRatings> findRatingsByLocationId(String locationId);
}
