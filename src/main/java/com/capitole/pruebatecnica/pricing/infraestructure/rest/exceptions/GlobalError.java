package com.capitole.pruebatecnica.pricing.infraestructure.rest.exceptions;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GlobalError {

    private Integer status;
    private String message;

}
