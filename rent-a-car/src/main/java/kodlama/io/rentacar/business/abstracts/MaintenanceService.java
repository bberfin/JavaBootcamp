package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.responses.get.car.GetAllCarsResponse;
import kodlama.io.rentacar.entities.Car;

import java.util.List;

public interface MaintenanceService {
    void maintenance(Car car);
    void stopMaintenance(Car car);
//    List<GetAllCarsResponse> getAllMaintenanceCars();
}
