package dev.pradeep.OnTravelsAssignment.Repository;

import dev.pradeep.OnTravelsAssignment.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
