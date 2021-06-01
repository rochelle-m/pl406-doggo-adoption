package com.doggos.server.repository;

import com.doggos.server.model.Applicant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApplicantRepository  extends MongoRepository<Applicant, String>{
    @Override
    List<Applicant> findAll();

}
