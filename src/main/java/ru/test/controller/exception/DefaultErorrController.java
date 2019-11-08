package ru.test.controller.exception;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.AbstractFilterRegistrationBean;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* Simply override default /error mapping */

@RestController
@RequestMapping(value = DefaultErorrController.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class DefaultErorrController extends AbstractErrorController {

    static final String PATH = "/error";

    public DefaultErorrController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }
    /*  Bullshit....all you need is super getErrorAttributes method

    @RequestMapping (value = "/detail")
    public ResponseEntity<ExceptionResponse> handleError(HttpServletRequest request) {
        HttpStatus status = HttpStatus.valueOf(Integer.valueOf(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString()));
        String message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE).toString();
        String path = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI).toString();
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), (message.equals("")) ? status.getReasonPhrase() : message, path, String.valueOf(status.value()));
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, status);
    }
    */

    @RequestMapping
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = super.getErrorAttributes(request, false);
        HttpStatus status = super.getStatus(request);
        return new ResponseEntity<>(body, status);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
