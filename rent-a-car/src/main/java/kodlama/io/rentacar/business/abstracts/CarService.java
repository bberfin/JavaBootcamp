package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.entities.Car;
import kodlama.io.rentacar.repository.CarRepository;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    Car getById(int id);

    Car add(Car car);

    Car update(int id, Car car);

    void delete(int id);
}
