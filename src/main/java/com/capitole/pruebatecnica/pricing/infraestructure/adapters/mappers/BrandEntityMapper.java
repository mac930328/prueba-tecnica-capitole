package com.capitole.pruebatecnica.pricing.infraestructure.adapters.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.capitole.pruebatecnica.pricing.domain.models.pojos.Brand;
import com.capitole.pruebatecnica.pricing.infraestructure.adapters.entities.BrandEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BrandEntityMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
    })
    Brand brandEntityToBrand(BrandEntity brandEntity);

    @InheritInverseConfiguration
    BrandEntity brandToBrandEntity(Brand brand);
}
