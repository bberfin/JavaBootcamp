package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.business.abstracts.MaintenanceService;
import kodlama.io.rentacar.business.dto.requests.create.maintenance.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.update.maintenance.UpdateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.maintenance.CreateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.maintenance.GetAllMaintenancesResponse;
import kodlama.io.rentacar.business.dto.responses.get.maintenance.GetMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.update.maintenance.UpdateMaintenanceResponse;
import kodlama.io.rentacar.entities.Maintenance;
import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {

    private final MaintenanceRepository repository;
    private final CarService carService;
    private final ModelMapper mapper;

    @Override
    public List<GetAllMaintenancesResponse> getAll() {
        List<Maintenance> maintenances = repository.findAll();
        List<GetAllMaintenancesResponse> response = maintenances
                .stream()
                .map(maintenance -> mapper.map(maintenance, GetAllMaintenancesResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetMaintenanceResponse getById(int id) {
        checkIfMaintenanceExists(id);
        Maintenance maintenance = repository.findById(id).orElseThrow();
        GetMaintenanceResponse response = mapper.map(maintenance, GetMaintenanceResponse.class);

        return response;
    }

    @Override
    public GetMaintenanceResponse returnCarFromMaintenance(int carId) {
        checkIfCarIsNotUnderMaintenance(carId);
        Maintenance maintenance = repository.findByCarIdAndIsCompletedIsFalse(carId);
        maintenance.setIsCompleted(true);
        maintenance.setEndDate(LocalDateTime.now());
        repository.save(maintenance); //update
        carService.changeState(carId, State.AVAILABLE);
        GetMaintenanceResponse response = mapper.map(maintenance, GetMaintenanceResponse.class);

        return response;
    }

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        checkIfCarIsUnderMaintenance(request);
        checkCarAvailabilityForMaintenance(request);
        Maintenance maintenance = mapper.map(request, Maintenance.class);
        maintenance.setId(0);
        maintenance.setIsCompleted(false);
        maintenance.setStartDate(LocalDateTime.now());
        maintenance.setEndDate(null);
        repository.save(maintenance);
        carService.changeState(request.getCarId(), State.MAINTENANCE);
        CreateMaintenanceResponse response = mapper.map(maintenance, CreateMaintenanceResponse.class);

        return response;
    }

    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request) {
        checkIfMaintenanceExists(id);
        Maintenance maintenance = mapper.map(request, Maintenance.class);
        maintenance.setId(id);
        repository.save(maintenance);
        UpdateMaintenanceResponse response = mapper.map(maintenance, UpdateMaintenanceResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        checkIfMaintenanceExists(id);
        repository.deleteById(id);
    }

    //business rules
    private void checkIfCarIsExists(int carId) {
        if (carService.getById(carId) == null) {
            throw new RuntimeException("Böyle bir araç bulunamadı.");
        }
    }

    private void checkIfCarIsUnderMaintenance(CreateMaintenanceRequest request) {
        if(repository.existsByCarIdAndIsCompletedIsFalse(request.getCarId())){
            throw new RuntimeException("Araç şu anda bakımda.");
        }
    }

    private void checkIfCarIsNotUnderMaintenance(int carId) {
        if (!repository.existsByCarIdAndIsCompletedIsFalse(carId)) {
            throw new RuntimeException("Bakımda böyle bir araç bulunamadı.");
        }
    }

    private void checkIfMaintenanceExists(int maintenanceId) {
        if (!repository.existsById(maintenanceId)) {
            throw new RuntimeException("Böyle bir bakım bilgisi bulunamadı.");
        }
    }

    private void checkCarAvailabilityForMaintenance(CreateMaintenanceRequest request) {
        if(carService.getById(request.getCarId()).getState().equals(State.RENTED)){
            throw new RuntimeException("araç kirada olduğu için kiralanamaz.");
        }
    }
}
