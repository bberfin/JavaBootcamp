package kodlama.io.ecommerce.repository.concretes;

import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    List<Product> products;

    public InMemoryProductRepository() {
        products = new ArrayList<>();
        products.add(new Product(1, "IPhone 14", 1, 33.000, "phone"));
        products.add(new Product(2, "Monster Abra A5 V19.2", 1, 20.250, "gaming computer"));
        products.add(new Product(3, "LG OLED LED TV", 1, 25.175, "led tv"));
    }

    @Override
    public Product add(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public void delete(int id) {
/*        for (Product product : products) {
            if (product.getId() == id)
                products.remove(product);
        }*/

        products.remove(id - 1);
    }

    @Override
    public Product update(Product product, int id) {
/*        for (Product product1 : products) {
            if (product1.getId() == id) {
                product1.setDescription(product.getDescription());
                product1.setName(product.getName());
                product1.setUnitPrice(product.getUnitPrice());
                product1.setQuantity(product.getQuantity());
            }
        }*/

        products.set(id - 1, product);
        return product;
    }

    @Override
    public Product getById(int id) {
/*        for (Product product : products) {
            if (product.getId() == id)
                return product;
        }
        return null;*/

        return products.get(id - 1);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
