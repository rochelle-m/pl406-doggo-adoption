package com.doggos.server.controller;

import com.doggos.server.model.Doggo;
import com.doggos.server.repository.DoggoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<Doggo> createDoggo(@RequestBody Doggo doggo) {
        try {
            Doggo _doggo = doggoRepository.save(new Doggo(doggo.getId(),
                    doggo.getName(),
                    doggo.getBreed(),
                    doggo.getDescription(),
                    doggo.getRemarks(),
                    doggo.getPrimaryImg(),
                    doggo.getSecondaryImg(),
                    doggo.getAdopted(),
                    doggo.getFostered()));
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
