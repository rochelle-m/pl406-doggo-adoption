package com.doggos.server.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageServiceImplementation implements StorageService {

    @Value("logo-w.png")
    private String logoPath;

    private final Path rootLocation;

    @Autowired
    public StorageServiceImplementation(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload");
        }
    }

    @Override
    public String store(MultipartFile multipartFile, String id) throws StorageException {
        try {
            if (multipartFile.isEmpty()) {
                throw new StorageException("Failed to store file");
            }

            Path folderPath = Paths.get(rootLocation.toString() + "\\" + id);

            try {
                Files.createDirectories(folderPath);
            } catch (IOException e) {
                throw new RuntimeException("Could not initialize folder for upload");
            }

            Path destinationFile = folderPath.resolve(
                    Paths.get(multipartFile.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(folderPath.toAbsolutePath())) {
                throw new StorageException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = multipartFile.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
            return ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/doggos/image/" + id + "/")
                    .path(multipartFile.getOriginalFilename())
                    .toUriString();
        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }

    @Override
    public byte[] get(String id, String name) throws IOException {
        Path destination = Paths.get(this.rootLocation.toString() + "\\" + id + "\\" + name);

        return IOUtils.toByteArray(destination.toUri());
    }


    @Override
    public byte[] getLogo() throws IOException {
        return IOUtils.toByteArray(Paths.get(logoPath).toUri());
    }
}
