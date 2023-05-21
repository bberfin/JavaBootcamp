package com.kodlamaio.paymentservice.business.dto.requests.create;

import com.kodlamaio.paymentservice.business.dto.requests.PaymentRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest  extends PaymentRequest {

    @NotNull
    @Min(value = 1)
    private double balance;
}

