package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryBusinessRules {
    private final CategoryRepository repository;

    public void checkIfCategoryExists(UUID id) {
        if (!repository.existsById(id)) throw new IllegalArgumentException("böyle bir kategori mevcut değil.");
    }
}
