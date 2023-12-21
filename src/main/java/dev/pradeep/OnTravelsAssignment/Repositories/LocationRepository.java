package dev.pradeep.OnTravelsAssignment.Repositories;

import dev.pradeep.OnTravelsAssignment.Entity.LocationEntites.Feature;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Feature, String> {
}
