package com.kodlamaio.inventoryservice.business.dto.requests.update.Car;

import com.kodlamaio.inventoryservice.entities.enums.State;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
    @NotNull
    private UUID modelId;
    @Min(value = 2000)
    //TODO: NotFuture custom annotation
    private int modelYear;
    @NotBlank
    //TODO: Regex
    private String plate;
    @NotNull
    private State state;
    @Min(value = 1)
    private double dailyPrice;
}
