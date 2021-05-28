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

    @Value("/static/json/carTravel.json")
    private String travelProducts;

    @Value("/static/json/food.json")
    private String foodProducts;

    @Value("/static/json/feed.json")
    private String feedProducts;

    @Value("/static/json/flea.json")
    private String fleaProducts;

    @Value("/static/json/health.json")
    private String healthProducts;

    @Value("/static/json/scooper.json")
    private String scooperProducts;

    @Value("/static/json/stain.json")
    private String stainRemovalProducts;

    @GetMapping(value = "/food", produces = MediaType.APPLICATION_JSON_VALUE)
    Object getFoodProducts() throws IOException {
        return getObject(foodProducts);
    }

    @GetMapping(value = "/stain-removal", produces = MediaType.APPLICATION_JSON_VALUE)
    Object getStainRemovalProducts() throws IOException {
        return getObject(stainRemovalProducts);
    }

     @GetMapping(value = "/scooper", produces = MediaType.APPLICATION_JSON_VALUE)
    Object getScooperProducts() throws IOException {
        return getObject(scooperProducts);
    }

     @GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    Object getHealthProducts() throws IOException {
        return getObject(healthProducts);
    }

     @GetMapping(value = "/flea", produces = MediaType.APPLICATION_JSON_VALUE)
    Object getFleaProducts() throws IOException {
        return getObject(fleaProducts);
    }

     @GetMapping(value = "/feed", produces = MediaType.APPLICATION_JSON_VALUE)
    Object getFeedProducts() throws IOException {
        return getObject(feedProducts);
    }

     @GetMapping(value = "/travel", produces = MediaType.APPLICATION_JSON_VALUE)
    Object getTravelProducts() throws IOException {
        return getObject(travelProducts);
    }


    /**
     *
     * @param products
     * @return Object
     * @throws IOException
     */
    private Object getObject(String products) throws IOException {
        Resource resource = new ClassPathResource(products);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}
