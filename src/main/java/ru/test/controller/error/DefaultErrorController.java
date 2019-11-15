package ru.test.controller.error;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/* Simply override default /error mapping */

@RestController
@RequestMapping(value = DefaultErrorController.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class DefaultErrorController extends AbstractErrorController {

    static final String PATH = "/error";

    public DefaultErrorController(ErrorAttributes errorAttributes) {
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
