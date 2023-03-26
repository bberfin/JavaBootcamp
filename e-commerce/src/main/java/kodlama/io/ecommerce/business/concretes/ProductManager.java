package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.CheckProductService;
import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductManager implements ProductService {

    private final ProductRepository repository;
    private CheckProductService service;

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return repository.save(product);
    }

    @Override
    public void delete(int id) {
        checkIfProductExists(id);
        repository.deleteById(id);
    }

    @Override
    public Product update(Product product, int id) {
        checkIfProductExists(id);
        validateProduct(product);
        product.setId(id);
        return repository.save(product);
    }

    @Override
    public Product getById(int id) {
        checkIfProductExists(id);
        return repository.findById(id).orElseThrow();

    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

//BUSINESS RULES

    private void validateProduct(Product product){
        checkIfUnitPriceValid(product);
        checkIfDescriptionLengthValid(product);
        checkIfQuantityValid(product);
    }

    private void checkIfDescriptionLengthValid(Product product) {
        if(product.getDescription().length() <10 || product.getDescription().length()>50)
            throw new IllegalArgumentException("description length must be between 10 and 50 characters");
    }

    private void checkIfQuantityValid(Product product) {
        if (product.getQuantity() < 0)
            throw new IllegalArgumentException("quantity cannot be less than zero");
    }

    private void checkIfUnitPriceValid(Product product) {
        if (product.getUnitPrice() <= 0)
            throw new IllegalArgumentException("price cannot be less than or equal to zero");
    }


    //BUSINESS RULES
    private void checkIfProductExists(int id) {
        if (!repository.existsById(id)) throw new IllegalArgumentException("böyle bir ürün mevcut değil.");
    }
}
