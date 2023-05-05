package com.kodlamaio.inventoryservice.business.concretes;

import com.kodlamaio.inventoryservice.business.abstracts.BrandService;
import com.kodlamaio.inventoryservice.business.dto.requests.create.Brand.CreateBrandRequest;
import com.kodlamaio.inventoryservice.business.dto.requests.update.Brand.UpdateBrandRequest;
import com.kodlamaio.inventoryservice.business.dto.responses.create.Brand.CreateBrandResponse;
import com.kodlamaio.inventoryservice.business.dto.responses.get.Brand.GetAllBrandsResponse;
import com.kodlamaio.inventoryservice.business.dto.responses.get.Brand.GetBrandResponse;
import com.kodlamaio.inventoryservice.business.dto.responses.update.Brand.UpdateBrandResponse;

import java.util.List;
import java.util.UUID;

public class BrandManager implements BrandService {
    //TODO: update methods
    @Override
    public List<GetAllBrandsResponse> getAll() {
        return null;
    }

    @Override
    public GetBrandResponse getById(UUID id) {
        return null;
    }

    @Override
    public CreateBrandResponse create(CreateBrandRequest request) {
        return null;
    }

    @Override
    public UpdateBrandResponse update(UUID id, UpdateBrandRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
