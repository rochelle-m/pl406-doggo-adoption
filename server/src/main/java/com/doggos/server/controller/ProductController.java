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

    @GetMapping(value = "/stain-removal", produces = MediaType.APPLICATION_JSON_VALUE)
    Object getStainRemovalProducts() throws IOException {
        return getObject(stainRemovalProducts);
    }

    // TODO more mappings

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
