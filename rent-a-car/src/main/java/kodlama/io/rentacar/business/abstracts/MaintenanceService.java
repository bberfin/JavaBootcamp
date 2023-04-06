package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.requests.create.maintenance.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.update.maintenance.UpdateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.maintenance.CreateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.car.GetAllCarsResponse;
import kodlama.io.rentacar.business.dto.responses.get.maintenance.GetAllMaintenancesResponse;
import kodlama.io.rentacar.business.dto.responses.get.maintenance.GetMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.update.maintenance.UpdateMaintenanceResponse;
import kodlama.io.rentacar.entities.Car;

import java.util.List;

public interface MaintenanceService {

    List<GetAllMaintenancesResponse> getAll();

    GetMaintenanceResponse getById(int id);

    GetMaintenanceResponse returnCarFromMaintenance(int carId); //bakımı sonlandır

    CreateMaintenanceResponse add(CreateMaintenanceRequest request);

    UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request);

    void delete(int id);
}
