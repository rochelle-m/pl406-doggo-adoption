package com.doggos.server.repository;

import com.doggos.server.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    Boolean emailExists(String email);
}
