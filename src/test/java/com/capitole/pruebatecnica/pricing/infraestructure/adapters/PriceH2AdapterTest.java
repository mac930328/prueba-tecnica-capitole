package com.capitole.pruebatecnica.pricing.infraestructure.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capitole.pruebatecnica.pricing.domain.models.pojos.Price;
import com.capitole.pruebatecnica.pricing.infraestructure.adapters.entities.PriceEntity;
import com.capitole.pruebatecnica.pricing.infraestructure.adapters.mappers.PriceEntityMapper;
import com.capitole.pruebatecnica.pricing.infraestructure.adapters.repository.PriceJpaRepository;

@ExtendWith(MockitoExtension.class)
public class PriceH2AdapterTest {

    @Mock
    private PriceJpaRepository priceJpaRepository;

    @Mock
    private PriceEntityMapper priceDboMapper;

    @InjectMocks
    private PriceH2Adapter priceH2Adapter;

    @Test
    void testGetPriceByDate() {

        LocalDateTime date = LocalDateTime.now();
        Long productId = 35455L;
        Long brandId = 1L;
        PriceEntity priceEntity = PriceEntity.builder().priceList(54L).build();
        Price price = Price.builder().priceList(54L).build();

        when(priceJpaRepository.findFirstPriceByDateAndProductAndBrand(any(), any(), any()))
                .thenReturn(Optional.of(priceEntity));
        when(priceDboMapper.priceEntitytoPrice(priceEntity)).thenReturn(price);

        Optional<Price> result = priceH2Adapter.getPriceByDate(date, productId, brandId);

        assertEquals(Optional.of(price), result);
    }

}
