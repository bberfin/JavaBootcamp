package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.CheckProductService;
import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private final ProductRepository repository;
    private CheckProductService service;

    public ProductManager(ProductRepository repository, CheckProductService service) {

        this.repository = repository;
        this.service = service;
    }

    @Override
    public Product add(Product product) {

/*        if (!service.isValid(product)) {

            throw new RuntimeException("hatalı kayit");
        } else {

            repository.addProduct(product);
            System.out.println("ürün basariyla eklendi");
        }

        return product;*/

        validateProduct(product);

        return repository.add(product);

    }

    @Override
    public void delete(int id) {
        if (repository.getAll().size() == 0) {
            throw new RuntimeException("ürün yok");
        } else if (repository.getById(id) == null) {
            throw new RuntimeException("ürün bulunamadi");

        } else {
            repository.delete(id);
            System.out.println("ürün basariyla silindi");
        }


    }

    @Override
    public Product update(Product product, int id) {
/*        if (repository.listProducts().size() == 0) {
            throw new RuntimeException("ürün yok");
        } else if (repository.findProductById(id) == null) {
            throw new RuntimeException("bu id ile ürün bulunamadi");
        } else if (!service.isValid(product)) {
            throw new RuntimeException("hatalı ürün bilgisi girdiniz, güncelleme yapilamadi");
        } else {
            repository.updateProduct(product, id);
            System.out.println("ürün basariyla güncellendi");
        }
        return product;*/

        validateProduct(product);

        repository.update(product, id);
        return product;


    }


    @Override
    public Product getById(int id) {

        if (repository.getById(id) == null) {
            throw new RuntimeException("ürün bulunamadi");
        }

        return repository.getById(id);

    }

    @Override
    public List<Product> getAll() {
        if (repository.getAll().size() == 0) {
            throw new RuntimeException("ürün listesi bos");
        }
        return repository.getAll();
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
}
