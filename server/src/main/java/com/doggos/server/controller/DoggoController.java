package com.doggos.server.controller;

import com.doggos.server.model.Doggo;
import com.doggos.server.repository.DoggoRepository;
import com.doggos.server.service.StorageException;
import com.doggos.server.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5000")
@RestController
@RequestMapping("/api")
public class DoggoController {

    private final StorageService storageService;
    @Autowired
    DoggoRepository doggoRepository;

    @Autowired
    public DoggoController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String henlo() {
        return "Henlo fren";
    }

    @PostMapping("/doggos")
    public ResponseEntity<Doggo> createDoggo(@RequestParam("id") String id,
                                             @RequestParam("name") String name,
                                             @RequestParam("breed") String breed,
                                             @RequestParam("description") String description,
                                             @RequestParam("remarks") String remarks,
                                             @RequestParam("adopted") Boolean adopted,
                                             @RequestParam("fostered") Boolean fostered,
                                             @RequestParam("primaryImg") MultipartFile primary,
                                             @RequestParam("secondaryImg") MultipartFile secondary) {

        try {
            Doggo doggo = new Doggo(id, name, breed, description, remarks, adopted, fostered);

            doggo.setPrimaryImg(primary.getOriginalFilename());
            doggo.setSecondaryImg(secondary.getOriginalFilename());

            storageService.store(primary, id);
            storageService.store(secondary, id);

            Doggo _doggo = doggoRepository.save(doggo);

            return new ResponseEntity<>(_doggo, HttpStatus.CREATED);
        } catch (Exception | StorageException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/doggos")
    public ResponseEntity<List<Doggo>> getAllDoggos(@RequestParam(required = false) String name) {

        try {
            List<Doggo> doggos = new ArrayList<>();

            if (name == null) {
                doggoRepository.findAll().forEach(doggos::add);
            } else {
                doggoRepository.findDoggoByName(name).forEach(doggos::add);
            }

            if (doggos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(doggos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/doggos/{id}")
    public ResponseEntity<Doggo> getDoggoById(@PathVariable("id") String id) {
        Optional<Doggo> doggo = doggoRepository.findById(id);

        return doggo.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/doggos/{id}")
    public ResponseEntity<HttpStatus> deleteDoggo(@PathVariable("id") String id) {
        try {
            doggoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
