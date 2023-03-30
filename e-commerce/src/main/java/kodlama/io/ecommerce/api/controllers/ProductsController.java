package kodlama.io.ecommerce.api.controllers;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.dto.requests.update.UpdateProductRequest;
import kodlama.io.ecommerce.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.dto.responses.get.GetAllProductsResponse;
import kodlama.io.ecommerce.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.dto.responses.update.UpdateProductResponse;
import kodlama.io.ecommerce.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService service;

    @GetMapping
    public List<GetAllProductsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable int id, @RequestBody UpdateProductRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
