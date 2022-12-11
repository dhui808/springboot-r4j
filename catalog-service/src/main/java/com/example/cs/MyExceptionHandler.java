package com.example.cs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(MyException.class)
    public ResponseEntity<Object> handle(MyException ex, 
                HttpServletRequest request, HttpServletResponse response) {

    	HttpStatus status = null;
    	switch(ex.getStatusCode()) {
    		case "400": status = HttpStatus.BAD_REQUEST;
    		case "401": status = HttpStatus.UNAUTHORIZED;
    		case "500": status = HttpStatus.INTERNAL_SERVER_ERROR;
    		case "502": status = HttpStatus.BAD_GATEWAY;
    		default: status = HttpStatus.INTERNAL_SERVER_ERROR;
    	}
    	
        return ResponseEntity.status(status).build();
    }
}
