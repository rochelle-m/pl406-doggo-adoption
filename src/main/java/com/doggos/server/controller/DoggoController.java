package com.doggos.server.controller;

import com.doggos.server.model.Doggo;
import com.doggos.server.repository.DoggoRepository;
import com.doggos.server.service.StorageException;
import com.doggos.server.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:5000")
@RestController
@RequestMapping("/api/doggos")
public class DoggoController {

    private final StorageService storageService;
    @Autowired
    DoggoRepository doggoRepository;

    @Autowired
    public DoggoController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/")
    public ResponseEntity<Doggo> createDoggo(String id, String name, String breed, String description, String remarks, String location, Boolean adopted, Boolean fostered, MultipartFile primary, MultipartFile secondary) {

        try {

            Doggo doggo = new Doggo(id, name, breed, description, remarks, location, adopted, fostered);

            String primaryImgUrl = storageService.store(primary, id, "doggos");
            String secondaryImgUrl = storageService.store(secondary, id, "doggos");

            doggo.setPrimaryImg(primaryImgUrl);
            doggo.setSecondaryImg(secondaryImgUrl);

            Doggo _doggo = doggoRepository.save(doggo);

            return new ResponseEntity<>(_doggo, HttpStatus.CREATED);
        } catch (Exception | StorageException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
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

    @GetMapping(value = "/image/{id}/{name}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody
    byte[] getImage(@PathVariable(name = "id") String id, @PathVariable(name = "name") String name) throws IOException {
        return storageService.get(id, name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doggo> getDoggoById(@PathVariable("id") String id) {
        Optional<Doggo> doggo = doggoRepository.findById(id);

        return doggo.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDoggo(@PathVariable("id") String id) {
        try {
            doggoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
