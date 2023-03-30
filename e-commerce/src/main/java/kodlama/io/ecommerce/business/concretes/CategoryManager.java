package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.CategoryService;
import kodlama.io.ecommerce.dto.requests.create.CreateCategoryRequest;
import kodlama.io.ecommerce.dto.requests.update.UpdateCategoryRequest;
import kodlama.io.ecommerce.dto.responses.create.CreateCategoryResponse;
import kodlama.io.ecommerce.dto.responses.get.GetAllCategoriesResponse;
import kodlama.io.ecommerce.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.dto.responses.update.UpdateCategoryResponse;
import kodlama.io.ecommerce.entities.Category;
import kodlama.io.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private ModelMapper mapper;
    private final CategoryRepository repository;

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = repository.findAll();
        List<GetAllCategoriesResponse> response = categories
                .stream()
                .map(category -> mapper.map(category, GetAllCategoriesResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetCategoryResponse getById(int id) {
        Category category = repository.findById(id).orElseThrow();
        GetCategoryResponse response = mapper.map(category, GetCategoryResponse.class);
        return response;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        Category category = mapper.map(request, Category.class);
        category.setId(0);
        repository.save(category);

        CreateCategoryResponse response = mapper.map(category, CreateCategoryResponse.class);
        return response;
    }

    @Override
    public UpdateCategoryResponse update(int id, UpdateCategoryRequest request) {
        Category category = mapper.map(request, Category.class);
        category.setId(id);
        repository.save(category);

        UpdateCategoryResponse response = mapper.map(category, UpdateCategoryResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
