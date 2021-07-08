package com.doggos.server.controller;

import com.doggos.server.model.Doggo;
import com.doggos.server.model.ERole;
import com.doggos.server.model.Post;
import com.doggos.server.model.User;
import com.doggos.server.payload.request.DoggoRequest;
import com.doggos.server.payload.request.PostRequest;
import com.doggos.server.repository.DoggoRepository;
import com.doggos.server.repository.UserRepository;
import com.doggos.server.service.StorageException;
import com.doggos.server.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
    UserRepository userRepository;

    @Autowired
    public DoggoController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    @PreAuthorize("hasRole('USER') or hasRole('STAFF') or hasRole('VOLUNTEER')")
    public ResponseEntity<Doggo> create(@RequestPart(name = "doggo") DoggoRequest doggoRequest, @RequestPart(name = "image", required = false) MultipartFile file) {
        try {
            User user = userRepository.findByUsername(doggoRequest.getUsername()).get();

            String imgPath = null;
            if (file != null) {
                imgPath = storageService.store(file, doggoRequest.getName(), "doggos");
            }

            Doggo newDoggo = new Doggo(doggoRequest.getName(), doggoRequest.getBreed(), doggoRequest.getDescription(), doggoRequest.getRemarks(), doggoRequest.getLocation(),imgPath,user);

            Doggo _doggo = doggoRepository.save(newDoggo);
            return new ResponseEntity<Doggo>(_doggo, HttpStatus.CREATED);
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
    @PreAuthorize("hasRole('STAFF')")
    public ResponseEntity<HttpStatus> deleteDoggo(@PathVariable("id") String id) {
        try {
            doggoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{action}/{id}")
    @PreAuthorize("hasRole('STAFF')")
    public ResponseEntity<Doggo> updateToAdopted(@PathVariable("id") String id, @PathVariable("action") String type){
        Optional<Doggo > doggo = doggoRepository.findById(id);
        if(doggo.isPresent()){
            Doggo updatedDoggo = doggo.get();
            if (type.equals("adopt"))
                updatedDoggo.setAdopted(true);
            if (type.equals("foster"))
                updatedDoggo.setFostered(true);
            Doggo _doggo = doggoRepository.save(updatedDoggo);
            return new ResponseEntity<>(_doggo, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
