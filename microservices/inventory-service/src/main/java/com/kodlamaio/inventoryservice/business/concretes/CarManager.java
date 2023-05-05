package com.kodlamaio.inventoryservice.business.concretes;

import com.kodlamaio.inventoryservice.business.abstracts.CarService;
import com.kodlamaio.inventoryservice.business.dto.requests.create.Car.CreateCarRequest;
import com.kodlamaio.inventoryservice.business.dto.requests.update.Car.UpdateCarRequest;
import com.kodlamaio.inventoryservice.business.dto.responses.create.Car.CreateCarResponse;
import com.kodlamaio.inventoryservice.business.dto.responses.get.Car.GetAllCarsResponse;
import com.kodlamaio.inventoryservice.business.dto.responses.get.Car.GetCarResponse;
import com.kodlamaio.inventoryservice.business.dto.responses.update.Car.UpdateCarResponse;

import java.util.List;
import java.util.UUID;

public class CarManager implements CarService {
    //TODO: update methods
    @Override
    public List<GetAllCarsResponse> getAll(boolean includeMaintenance) {
        return null;
    }

    @Override
    public GetCarResponse getById(UUID id) {
        return null;
    }

    @Override
    public CreateCarResponse create(CreateCarRequest request) {
        return null;
    }

    @Override
    public UpdateCarResponse update(UUID id, UpdateCarRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
