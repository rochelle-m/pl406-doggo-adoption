package com.doggos.server.repository;

import com.doggos.server.model.Doggo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DoggoRepository extends MongoRepository<Doggo, String> {
    List<Doggo> findDoggoByName(String name);
}
