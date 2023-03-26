package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.ModelService;
import kodlama.io.rentacar.entities.Model;
import kodlama.io.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository repository;

    @Override
    public List<Model> getAll() {
        return null;
    }

    @Override
    public Model getById(int id) {
        return null;
    }

    @Override
    public Model add(Model model) {
        return repository.save(model);
    }

    @Override
    public Model update(int id, Model model) {
        return null;
    }

    @Override
    public void delete() {

    }
}
