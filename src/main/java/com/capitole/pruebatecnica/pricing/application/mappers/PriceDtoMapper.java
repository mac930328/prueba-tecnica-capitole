package com.capitole.pruebatecnica.pricing.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.capitole.pruebatecnica.pricing.domain.models.dtos.PriceDto;
import com.capitole.pruebatecnica.pricing.domain.models.pojos.Price;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PriceDtoMapper {

    @Mappings({
            @Mapping(target = "priceList", source = "priceList"),
            @Mapping(target = "productId", source = "product.id"),
            @Mapping(target = "brandId", source = "brand.id"),
            @Mapping(target = "startDate", source = "startDate"),
            @Mapping(target = "endDate", source = "endDate"),
            @Mapping(target = "price", source = "price"),
    })
    PriceDto priceToPriceDto(Price price);

    @Mappings({
            @Mapping(target = "priceList", source = "priceList"),
            @Mapping(target = "product.id", source = "productId"),
            @Mapping(target = "brand.id", source = "brandId"),
            @Mapping(target = "startDate", source = "startDate"),
            @Mapping(target = "endDate", source = "endDate"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "currency", ignore = true),
            @Mapping(target = "priority", ignore = true)
    })
    Price priceDtoToPrice(PriceDto price);

}
