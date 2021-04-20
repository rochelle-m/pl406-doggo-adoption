package com.doggos.server.controller;

import com.doggos.server.model.Doggo;
import com.doggos.server.repository.DoggoRepository;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5000")
@RestController
@RequestMapping("/api")
public class DoggoController {
    @Autowired
    DoggoRepository doggoRepository;

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

            String primaryImgFilename = primary.getOriginalFilename();
            String secImgFilename = secondary.getOriginalFilename();

            if (!(primaryImgFilename != null && primaryImgFilename.isEmpty()))
                doggo.setPrimaryImg(Base64.getEncoder().encodeToString(primary.getBytes()));

            if (!(secImgFilename != null && secImgFilename.isEmpty()))
                doggo.setSecondaryImg(Base64.getEncoder().encodeToString(secondary.getBytes()));

            Doggo _doggo = doggoRepository.save(doggo);

            return new ResponseEntity<>(_doggo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/doggos")
    public ResponseEntity<List<Doggo>> getAllDoggos(@RequestParam(required = false) String name) {

        try {
            List<Doggo> doggos = new ArrayList<Doggo>();

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
