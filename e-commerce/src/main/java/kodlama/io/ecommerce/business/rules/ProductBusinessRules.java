package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository repository;

    public void validateProduct(Product product){
        checkIfUnitPriceValid(product);
        checkIfDescriptionLengthValid(product);
        checkIfQuantityValid(product);
    }

    public void checkIfProductExists(UUID id) {
        if (!repository.existsById(id)) throw new IllegalArgumentException("böyle bir ürün mevcut değil.");
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
}
