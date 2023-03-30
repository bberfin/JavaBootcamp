package kodlama.io.ecommerce.api.controllers;

import kodlama.io.ecommerce.business.abstracts.CategoryService;
import kodlama.io.ecommerce.dto.requests.create.CreateCategoryRequest;
import kodlama.io.ecommerce.dto.requests.update.UpdateCategoryRequest;
import kodlama.io.ecommerce.dto.responses.create.CreateCategoryResponse;
import kodlama.io.ecommerce.dto.responses.get.GetAllCategoriesResponse;
import kodlama.io.ecommerce.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.dto.responses.update.UpdateCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoryService service;

    @GetMapping
    public List<GetAllCategoriesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCategoryResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCategoryResponse add(@RequestBody CreateCategoryRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCategoryResponse update(@PathVariable int id, @RequestBody UpdateCategoryRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
