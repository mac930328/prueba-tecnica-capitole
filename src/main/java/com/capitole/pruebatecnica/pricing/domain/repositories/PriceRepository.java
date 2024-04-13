package com.capitole.pruebatecnica.pricing.domain.repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import com.capitole.pruebatecnica.pricing.domain.models.pojos.Price;

public interface PriceRepository {

    Optional<Price> getPriceByDate(LocalDateTime date, Long productId, Long brandId);
}
