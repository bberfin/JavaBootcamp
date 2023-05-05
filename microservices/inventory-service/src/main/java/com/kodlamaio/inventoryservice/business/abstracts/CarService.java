package com.kodlamaio.inventoryservice.business.abstracts;

import com.kodlamaio.inventoryservice.business.dto.requests.create.Car.CreateCarRequest;
import com.kodlamaio.inventoryservice.business.dto.requests.update.Car.UpdateCarRequest;
import com.kodlamaio.inventoryservice.business.dto.responses.create.Car.CreateCarResponse;
import com.kodlamaio.inventoryservice.business.dto.responses.get.Car.GetAllCarsResponse;
import com.kodlamaio.inventoryservice.business.dto.responses.get.Car.GetCarResponse;
import com.kodlamaio.inventoryservice.business.dto.responses.update.Car.UpdateCarResponse;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<GetAllCarsResponse> getAll(boolean includeMaintenance);

    GetCarResponse getById(UUID id);

    CreateCarResponse create(CreateCarRequest request);

    UpdateCarResponse update(UUID id, UpdateCarRequest request);

    void delete(UUID id);
}
