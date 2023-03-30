package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.entities.Product;


public interface CheckProductService {
    void validateProduct(Product product);
    void checkIfProductExists(int id);
}
