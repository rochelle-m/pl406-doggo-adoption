package com.doggos.server.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {
    void init();

    String store(MultipartFile multipartFile, String id) throws StorageException;

    byte[] get(String filename, String id) throws IOException;

    byte[] getLogo() throws IOException;
}
