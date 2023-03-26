package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.entities.Product;


public interface CheckProductService {
    boolean isValid(Product product);
}
