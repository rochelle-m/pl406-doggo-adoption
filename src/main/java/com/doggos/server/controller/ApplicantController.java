package com.applicants.server.controller;

import com.applicants.server.model.Applicant;
import com.applicants.server.model.User;
import com.applicants.server.payload.request.ApplicantRequest;
import com.applicants.server.repository.ApplicantRepository;
import com.applicants.server.repository.UserRepository;
import com.applicants.server.service.StorageException;
import com.applicants.server.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:5000")
@RestController
@RequestMapping("/api/applicant")
public class ApplicantController {

    private final StorageService storageService;
    @Autowired
    ApplicantRepository applicantRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public ApplicantController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @PreAuthorize("hasRole('USER') or hasRole('STAFF') or hasRole('VOLUNTEER')")
    public ResponseEntity<Applicant> create(@RequestBody(name = "applicant") ApplicantRequest applicantRequest) {
        try {
            User user = userRepository.findByUsername(applicantRequest.getUsername()).get();

            Applicant newApplicant = new Applicant(applicantRequest.getDogId(),applicantRequest.getUser(),applicantRequest.getApplicantName(), applicantRequest.getPhoneNumber(), applicantRequest.getAddress(), applicantRequest.getOccupation(), applicantRequest.getOwnPet(),applicantRequest.getAllergy(),applicantRequest.getNoOfAdults(),applicantRequest.getNoOfChildren(),applicantRequest.getTypeOfHome(),applicantRequest.getDescribeHome(),applicantRequest.getReasonToAdopt(),applicantRequest.getHaveTime(),applicantRequest.getAgreement(),user);

            Applicant _applicant = applicantRepository.save(newApplicant);
            return new ResponseEntity<Applicant>(_applicant, HttpStatus.CREATED);
        } catch (Exception | StorageException e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Applicant>> getAllApplicants(@RequestParam(required = false) String applicantName) {

        try {
            List<Applicant> applicants = new ArrayList<>();

            if (name == null) {
                applicantRepository.findAll().forEach(applicants::add);
            } else {
                applicantRepository.findApplicantByName(applicantName).forEach(applicants::add);
            }

            if (applicants.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(applicants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
