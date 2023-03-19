package kodlama.io.ecommerce.repository.abstracts;


import kodlama.io.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductRepository {

    Product add(Product product);

    void delete(int id);

    Product update(Product product, int id);

    Product getById(int id);

    List<Product> getAll();
}
