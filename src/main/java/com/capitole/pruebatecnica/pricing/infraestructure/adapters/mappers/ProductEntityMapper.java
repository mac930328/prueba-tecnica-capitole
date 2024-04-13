package com.capitole.pruebatecnica.pricing.infraestructure.adapters.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.capitole.pruebatecnica.pricing.domain.models.pojos.Product;
import com.capitole.pruebatecnica.pricing.infraestructure.adapters.entities.ProductEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductEntityMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
    })
    ProductEntity productToProductEntity(Product product);

    @InheritInverseConfiguration
    Product productEntityToProduct(ProductEntity productEntity);
}
