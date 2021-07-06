package com.doggos.server.controller;

import com.doggos.server.service.StorageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins="http://localhost:5000")
@RestController
@RequestMapping("/api/logo")
public class MainContoller {

    private final StorageService storageService;

    public MainContoller(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping(value = "/", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody
    byte[] getLogo() throws IOException {
        return storageService.getLogo();
    }
}
