package com.doggos.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Value("/static/json/pet_products.json")
    private String productsPath;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    Object getProducts() throws IOException {
        Resource resource = new ClassPathResource(productsPath);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}
