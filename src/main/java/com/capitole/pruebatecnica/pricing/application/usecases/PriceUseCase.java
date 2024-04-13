package com.capitole.pruebatecnica.pricing.application.usecases;

import java.time.LocalDateTime;

import com.capitole.pruebatecnica.pricing.domain.models.dtos.PriceDto;

public interface PriceUseCase {

    PriceDto getPriceByDate(LocalDateTime date, Long productId, Long brandId);
}
