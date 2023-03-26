package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    @Override
    public List<Car> getAll() {
        return null;
    }

    @Override
    public Car getById(int id) {
        return null;
    }

    @Override
    public Car add(Car car) {
        return null;
    }

    @Override
    public Car update(int id, Car car) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
