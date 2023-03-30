package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.CheckProductService;
import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.dto.requests.update.UpdateProductRequest;
import kodlama.io.ecommerce.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.dto.responses.get.GetAllProductsResponse;
import kodlama.io.ecommerce.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.dto.responses.update.UpdateProductResponse;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductManager implements ProductService {

    private ModelMapper mapper;
    private final ProductRepository repository;
    private final CheckProductService checkProductService;

    @Override
    public List<GetAllProductsResponse> getAll() {
        List<Product> products = repository.findAll();
        List<GetAllProductsResponse> response = products
                .stream()
                .map(product -> mapper.map(product, GetAllProductsResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetProductResponse getById(int id) {
        checkProductService.checkIfProductExists(id);
        Product product = repository.findById(id).orElseThrow();
        GetProductResponse response = mapper.map(product, GetProductResponse.class);
        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        Product product = mapper.map(request, Product.class);
        checkProductService.validateProduct(product);
        product.setId(0);
        repository.save(product);

        CreateProductResponse response = mapper.map(product, CreateProductResponse.class);
        return response;
    }
    @Override
    public UpdateProductResponse update(int id, UpdateProductRequest request) {
        checkProductService.checkIfProductExists(id);
        Product product = mapper.map(request, Product.class);
        checkProductService.validateProduct(product);
        product.setId(id);
        repository.save(product);

        UpdateProductResponse response = mapper.map(product, UpdateProductResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        checkProductService.checkIfProductExists(id);
        repository.deleteById(id);
    }
}
