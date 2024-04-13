package com.capitole.pruebatecnica.pricing.domain.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotFoundObjectException extends RuntimeException {

    private HttpStatus status;

    public NotFoundObjectException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

}
