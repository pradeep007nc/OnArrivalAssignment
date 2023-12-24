package dev.pradeep.OnArrivalAssignment.Repository;

import dev.pradeep.OnArrivalAssignment.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
