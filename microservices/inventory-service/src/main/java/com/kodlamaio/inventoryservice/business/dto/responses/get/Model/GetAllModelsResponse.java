package com.kodlamaio.inventoryservice.business.dto.responses.get.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllModelsResponse {
    private UUID id;
    private UUID brandId;
    private String name;
}
