package com.capitole.pruebatecnica.pricing.infraestructure.rest.controllers;

import java.time.LocalDateTime;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.pruebatecnica.pricing.application.usecases.PriceUseCase;
import com.capitole.pruebatecnica.pricing.domain.models.dtos.PriceDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/price")
public class PriceController {

    private final PriceUseCase priceUseCase;

    @Operation(summary = "Obtener precio por fecha de aplicacion, codigo de producto y codigo de marca")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PriceDto getPriceByDate(
            @Parameter(description = "Fecha de aplicacion") @RequestParam @NotNull LocalDateTime date,
            @Parameter(description = "ID del producto") @RequestParam @NotNull Long productId,
            @Parameter(description = "ID de la marca") @RequestParam @NotNull Long brandId) {
        return priceUseCase.getPriceByDate(date, productId, brandId);
    }
}
