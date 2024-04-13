package com.capitole.pruebatecnica.pricing.infraestructure.adapters;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capitole.pruebatecnica.pricing.domain.models.pojos.Price;
import com.capitole.pruebatecnica.pricing.domain.repositories.PriceRepository;
import com.capitole.pruebatecnica.pricing.infraestructure.adapters.entities.BrandEntity;
import com.capitole.pruebatecnica.pricing.infraestructure.adapters.entities.ProductEntity;
import com.capitole.pruebatecnica.pricing.infraestructure.adapters.mappers.PriceEntityMapper;
import com.capitole.pruebatecnica.pricing.infraestructure.adapters.repository.PriceJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PriceH2Adapter implements PriceRepository {

    private final PriceJpaRepository priceJpaRepository;
    private final PriceEntityMapper priceDboMapper;

    @Override
    public Optional<Price> getPriceByDate(LocalDateTime date, Long productId, Long brandId) {

        ProductEntity product = ProductEntity.builder().id(productId).build();
        BrandEntity brand = BrandEntity.builder().id(brandId).build();

        return priceJpaRepository.findFirstPriceByDateAndProductAndBrand(date, product, brand)
                .map(priceDboMapper::priceEntitytoPrice);
    }

}
