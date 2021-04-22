package com.doggos.server.service;

public class StorageException extends Throwable {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
