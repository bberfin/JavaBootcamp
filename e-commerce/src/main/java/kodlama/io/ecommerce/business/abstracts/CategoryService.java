package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.dto.requests.create.CreateCategoryRequest;
import kodlama.io.ecommerce.dto.requests.update.UpdateCategoryRequest;
import kodlama.io.ecommerce.dto.responses.create.CreateCategoryResponse;
import kodlama.io.ecommerce.dto.responses.get.GetAllCategoriesResponse;
import kodlama.io.ecommerce.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.dto.responses.update.UpdateCategoryResponse;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();
    GetCategoryResponse getById(int id);
    CreateCategoryResponse add(CreateCategoryRequest request);
    UpdateCategoryResponse update(int id, UpdateCategoryRequest request);
    void delete(int id);
}
