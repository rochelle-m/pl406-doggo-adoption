package com.doggos.server.controller;

import com.doggos.server.model.DogCamp;
import com.doggos.server.payload.request.DogCampRequest;
import com.doggos.server.repository.DogCampRepository;
import com.doggos.server.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
@RequestMapping("/api/AdoptionCampAug2021")
public class DogCampController {

    private  final StorageService storageService;
    @Autowired
    DogCampRepository dogCampRepository;

    @Autowired
    public DogCampController(StorageService storageService){ this.storageService = storageService; }

    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<DogCamp> create(@RequestBody DogCampRequest dogCampRequest){

        try {
            DogCamp newDogCamp = new DogCamp(dogCampRequest.getFirstName(), dogCampRequest.getLastName(), dogCampRequest.getContact());

            DogCamp _dogCamp = dogCampRepository.save(newDogCamp);

            return new ResponseEntity<>(_dogCamp, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
