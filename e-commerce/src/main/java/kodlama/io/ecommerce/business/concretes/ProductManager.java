package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.CategoryService;
import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllProductsResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateProductResponse;
import kodlama.io.ecommerce.business.rules.ProductBusinessRules;
import kodlama.io.ecommerce.configuration.mappers.ModelMapperService;
import kodlama.io.ecommerce.entities.Category;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.entities.enums.Status;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductManager implements ProductService {

    private ModelMapperService mapper;
    private final ProductRepository repository;
    private final CategoryService categoryService;
    private final ProductBusinessRules rules;

    @Override
    public List<GetAllProductsResponse> getAll() {
        List<Product> products = repository.findAll();

        List<GetAllProductsResponse> response = products
                .stream()
                .map(product -> {
                    GetAllProductsResponse productResponse = mapper.forResponse().map(product, GetAllProductsResponse.class);
                    productResponse.setCategoryIds(product.getCategories().stream().map(Category::getId).collect(Collectors.toList()));
                    return productResponse;
                })
                .toList();

        return response;
    }

    @Override
    public GetProductResponse getById(UUID id) {
        rules.checkIfProductExists(id);
        Product product = repository.findById(id).orElseThrow();
        GetProductResponse response = mapper.forResponse().map(product, GetProductResponse.class);
        response.setCategoryIds(product.getCategories().stream().map(category -> category.getId()).collect(Collectors.toList()));
        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        Product product = mapper.forRequest().map(request, Product.class);
        rules.validateProduct(product);
        matchCategoryAndProduct(request.getCategoryIds(), product);
        product.setStatus(Status.AVAILABLE);
        product.setId(null);
        repository.save(product);

        CreateProductResponse response = mapper.forResponse().map(product, CreateProductResponse.class);
        response.setCategoryIds(product.getCategories().stream().map(category -> category.getId()).collect(Collectors.toList()));
        return response;
    }

    @Override
    public UpdateProductResponse update(UUID id, UpdateProductRequest request) {
        rules.checkIfProductExists(id);
        Product product = mapper.forRequest().map(request, Product.class);
        rules.validateProduct(product);
        product.setId(id);
        repository.save(product);

        UpdateProductResponse response = mapper.forResponse().map(product, UpdateProductResponse.class);
        response.setCategoryIds(product.getCategories().stream().map(category -> category.getId()).collect(Collectors.toList()));

        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfProductExists(id);
        repository.deleteById(id);
    }

    private void matchCategoryAndProduct(List<UUID> categoryIds, Product product) {
        List<GetCategoryResponse> categories = categoryIds.stream()
                .map(categoryId -> categoryService.getById(categoryId))
                .collect(Collectors.toList());

        Set<Category> categories1 =           categories
                .stream()
                .map(cat -> mapper.forResponse().map(cat, Category.class))
                .collect(Collectors.toSet());

        product.setCategories(categories1);

        for (Category category : categories1) {
            category.getProducts().add(product);
        }
    }
}
