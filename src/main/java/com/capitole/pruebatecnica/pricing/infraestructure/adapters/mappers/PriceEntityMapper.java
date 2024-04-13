package com.capitole.pruebatecnica.pricing.infraestructure.adapters.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.capitole.pruebatecnica.pricing.domain.models.pojos.Price;
import com.capitole.pruebatecnica.pricing.infraestructure.adapters.entities.PriceEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { ProductEntityMapper.class,
        BrandEntityMapper.class }, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PriceEntityMapper {

    @Mappings({
            @Mapping(target = "priceList", source = "priceList"),
            @Mapping(target = "brand", source = "brandEntity"),
            @Mapping(target = "product", source = "productEntity"),
            @Mapping(target = "startDate", source = "startDate"),
            @Mapping(target = "endDate", source = "endDate"),
            @Mapping(target = "priority", source = "priority"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "currency", source = "currency")
    })
    Price priceEntitytoPrice(PriceEntity priceEntity);

    @InheritInverseConfiguration
    PriceEntity priceToPriceEntity(Price price);
}
