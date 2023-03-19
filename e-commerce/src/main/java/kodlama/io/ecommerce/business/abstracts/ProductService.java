package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    Product add(Product product);

    void delete(int id);

    Product update(Product product, int id);

    Product getById(int id);

    List<Product> getAll();
}
