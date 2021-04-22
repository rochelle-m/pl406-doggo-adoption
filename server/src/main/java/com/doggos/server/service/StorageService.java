package com.doggos.server.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void init();

    void store(MultipartFile multipartFile) throws StorageException;

    void deleteAll();
}
