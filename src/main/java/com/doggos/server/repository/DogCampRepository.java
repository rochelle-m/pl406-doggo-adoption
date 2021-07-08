package com.doggos.server.repository;

import com.doggos.server.model.Applicant;
import com.doggos.server.model.DogCamp;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DogCampRepository extends MongoRepository<DogCamp, String> {
    @Override
    List<DogCamp> findAll();
}
