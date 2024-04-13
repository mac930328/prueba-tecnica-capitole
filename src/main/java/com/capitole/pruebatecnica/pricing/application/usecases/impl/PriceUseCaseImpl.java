package com.capitole.pruebatecnica.pricing.application.usecases.impl;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.capitole.pruebatecnica.pricing.application.mappers.PriceDtoMapper;
import com.capitole.pruebatecnica.pricing.application.usecases.PriceUseCase;
import com.capitole.pruebatecnica.pricing.domain.exceptions.NotFoundObjectException;
import com.capitole.pruebatecnica.pricing.domain.models.dtos.PriceDto;
import com.capitole.pruebatecnica.pricing.domain.repositories.PriceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PriceUseCaseImpl implements PriceUseCase {

    public static final String NOT_FOUND_ERROR_MESSAGE = "No se encontro ningun registro.";

    private final PriceRepository priceRepository;
    private final PriceDtoMapper priceDtoMapper;

    @Override
    public PriceDto getPriceByDate(LocalDateTime date, Long productId, Long brandId) {
        return priceRepository.getPriceByDate(date, productId, brandId)
                .map(priceDtoMapper::priceToPriceDto)
                .orElseThrow(() -> new NotFoundObjectException(HttpStatus.NOT_FOUND, NOT_FOUND_ERROR_MESSAGE));
    }

}
