package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.dto.requests.update.UpdateProductRequest;
import kodlama.io.ecommerce.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.dto.responses.get.GetAllProductsResponse;
import kodlama.io.ecommerce.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.dto.responses.update.UpdateProductResponse;

import java.util.List;

public interface ProductService {

    List<GetAllProductsResponse> getAll();
    GetProductResponse getById(int id);
    CreateProductResponse add(CreateProductRequest request);
    UpdateProductResponse update(int id, UpdateProductRequest request);
    void delete(int id);
}
