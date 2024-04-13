package com.capitole.pruebatecnica.pricing.infraestructure.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.capitole.pruebatecnica.pricing.domain.exceptions.NotFoundObjectException;
import com.capitole.pruebatecnica.pricing.infraestructure.rest.exceptions.GlobalError;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(NotFoundObjectException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<GlobalError> notFoundObjectExceptionHandler(NotFoundObjectException notFoundObjectException) {
        GlobalError globalError = GlobalError.builder().status(notFoundObjectException.getStatus().value())
                .message(notFoundObjectException.getMessage()).build();
        return new ResponseEntity<GlobalError>(globalError, HttpStatus.NOT_FOUND);
    }

}
