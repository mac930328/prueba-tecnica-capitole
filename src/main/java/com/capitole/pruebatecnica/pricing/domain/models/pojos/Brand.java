package com.capitole.pruebatecnica.pricing.domain.models.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    private Long id;
    private String name;
}
