package com.doggos.server.repository;

import com.doggos.server.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Boolean emailExists(String email);
    Optional<User> findByUsername(String username);
}
