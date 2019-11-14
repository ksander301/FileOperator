package ru.test.controller.exception;
import java.io.IOException;

public class FileStoreException extends IOException {

    public FileStoreException(String message) {
        super(message);
    }

    public FileStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
