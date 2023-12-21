package dev.pradeep.OnTravelsAssignment.Repositories;

import dev.pradeep.OnTravelsAssignment.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
