package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.CategoryService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateCategoryRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateCategoryRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllCategoriesResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateCategoryResponse;
import kodlama.io.ecommerce.business.rules.CategoryBusinessRules;
import kodlama.io.ecommerce.configuration.mappers.ModelMapperService;
import kodlama.io.ecommerce.entities.Category;
import kodlama.io.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private ModelMapperService mapper;
    private final CategoryRepository repository;
    private final CategoryBusinessRules rules;


    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = repository.findAll();
        List<GetAllCategoriesResponse> response = categories
                .stream()
                .map(category -> mapper.forResponse().map(category, GetAllCategoriesResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetCategoryResponse getById(UUID id) {
        rules.checkIfCategoryExists(id);
        Category category = repository.findById(id).orElseThrow();
        GetCategoryResponse response = mapper.forResponse().map(category, GetCategoryResponse.class);
        return response;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        Category category = mapper.forRequest().map(request, Category.class);
        category.setId(null);
        repository.save(category);

        CreateCategoryResponse response = mapper.forResponse().map(category, CreateCategoryResponse.class);
        return response;
    }

    @Override
    public UpdateCategoryResponse update(UUID id, UpdateCategoryRequest request) {
        rules.checkIfCategoryExists(id);
        Category category = mapper.forRequest().map(request, Category.class);
        category.setId(id);
        repository.save(category);

        UpdateCategoryResponse response = mapper.forResponse().map(category, UpdateCategoryResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfCategoryExists(id);
        repository.deleteById(id);
    }
}
