package com.hope.todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// by default for exceptions spring provides ResponseEntityExceptionHandler that returns response
//(in some specific format) in case of any exception occurs and if we to use our own format of
//Exception Response then we need to do it this way:

@ControllerAdvice // is used to distribute over all of the controllers
@RestController // its a rest controller cuz it returns a response back in case of exception
public class CustomizedResponseEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class) // we need to apply exception handler on Exception class
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TodoNotFoundException.class)  // we need to apply exception handler on TodoNotFoundException class
    public final ResponseEntity<Object> handleTodoNotFoundException(TodoNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    }
