package com.kodlamaio.inventoryservice.business.dto.responses.update.Brand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBrandResponse {
    private UUID id;
    private String name;
}
