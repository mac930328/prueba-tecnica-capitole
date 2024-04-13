package com.capitole.pruebatecnica.pricing.domain.models.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PriceDto {

    private Long priceList;
    private Long productId;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;

}
