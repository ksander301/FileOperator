package ru.test.controller.exception;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

@ControllerAdvice ()
public class FileExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler( value = FileNotFoundException.class)
    public ResponseEntity<Object> fileNotFound(FileNotFoundException ex, WebRequest request) {
         //return new ResponseEntity<Object>( ex.getMessage(), HttpStatus.NOT_FOUND);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type","text/plain");
        return handleExceptionInternal(ex, ex.getMessage(), httpHeaders, HttpStatus.NOT_FOUND, request);

    }

}
