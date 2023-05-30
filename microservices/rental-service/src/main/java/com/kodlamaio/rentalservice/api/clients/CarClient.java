package com.kodlamaio.rentalservice.api.clients;

import com.kodlamaio.commonpackage.utils.dto.CarClientResponse;
import com.kodlamaio.commonpackage.utils.dto.ClientResponse;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "inventory-service", fallback = CarClientFallback.class)
@Retry(name="rentalServiceCallsInventory")
public interface CarClient {
    @GetMapping(value = "/api/cars/check-car-available/{carId}")
    ClientResponse checkIfCarAvailable(@PathVariable UUID carId) throws InterruptedException;

    @GetMapping(value = "/api/cars/get-car-for-invoice/{carId}")
    CarClientResponse getById(@PathVariable UUID carId)throws InterruptedException;
}
