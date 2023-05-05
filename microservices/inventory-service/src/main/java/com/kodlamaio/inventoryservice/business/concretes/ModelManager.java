package com.kodlamaio.inventoryservice.business.concretes;

import com.kodlamaio.inventoryservice.business.abstracts.ModelService;
import com.kodlamaio.inventoryservice.business.dto.requests.create.Model.CreateModelRequest;
import com.kodlamaio.inventoryservice.business.dto.requests.update.Model.UpdateModelRequest;
import com.kodlamaio.inventoryservice.business.dto.responses.create.Model.CreateModelResponse;
import com.kodlamaio.inventoryservice.business.dto.responses.get.Model.GetAllModelsResponse;
import com.kodlamaio.inventoryservice.business.dto.responses.get.Model.GetModelResponse;
import com.kodlamaio.inventoryservice.business.dto.responses.update.Model.UpdateModelResponse;

import java.util.List;
import java.util.UUID;

public class ModelManager implements ModelService {
    //TODO: update methods
    @Override
    public List<GetAllModelsResponse> getAll() {
        return null;
    }

    @Override
    public GetModelResponse getById(UUID id) {
        return null;
    }

    @Override
    public CreateModelResponse create(CreateModelRequest request) {
        return null;
    }

    @Override
    public UpdateModelResponse update(UUID id, UpdateModelRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
