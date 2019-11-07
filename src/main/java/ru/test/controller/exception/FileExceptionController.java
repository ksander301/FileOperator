package ru.test.controller.exception;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/*
 * Experimental of global handling exceptions, not useful,
 * DefaultErrorController has more functionality
 */
@RestControllerAdvice
public class FileExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler({IOException.class})
    public ResponseEntity<ExceptionResponse> fileNotFound(IOException ex, HttpServletRequest request) {
        HttpStatus status;
        if (ex instanceof FileNotFoundException) {
            status = HttpStatus.NOT_FOUND; //TODO Something better ...
        } else if (ex instanceof NotDirectoryException)
            status = HttpStatus.BAD_REQUEST; //TODO ...as same as previous
        else
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(new Date(), ex.getMessage(), request.getRequestURI(), String.valueOf(status.value())), status);

        /*HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type","text/plain");
        return handleExceptionInternal(ex, ex.getMessage(), httpHeaders, HttpStatus.NOT_FOUND, request)*/
    }

}
