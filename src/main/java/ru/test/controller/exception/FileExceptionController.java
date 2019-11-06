package ru.test.controller.exception;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
import java.util.Date;

@RestControllerAdvice
public class FileExceptionController extends ResponseEntityExceptionHandler {
   @ExceptionHandler( { IOException.class})
    public ResponseEntity<ExceptionResponse> fileNotFound(IOException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse( new Date(),ex.getMessage(),  request.getDescription(false),HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<ExceptionResponse> ( exceptionResponse, HttpStatus.NOT_FOUND);
        /*HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type","text/plain");
        return handleExceptionInternal(ex, ex.getMessage(), httpHeaders, HttpStatus.NOT_FOUND, request)*/
    }

}
