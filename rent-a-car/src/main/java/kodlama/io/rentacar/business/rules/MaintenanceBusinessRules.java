package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.common.constants.Messages;
import kodlama.io.rentacar.core.exceptions.BusinessException;
import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {

    private final MaintenanceRepository repository;
    public void checkIfCarIsUnderMaintenance(int id) {
        if(repository.existsByCarIdAndIsCompletedIsFalse(id)){
            throw new BusinessException(Messages.Maintenance.CarExists);
        }
    }

    public void checkIfCarIsNotUnderMaintenance(int carId) {
        if (!repository.existsByCarIdAndIsCompletedIsFalse(carId)) {
            throw new BusinessException(Messages.Maintenance.CarNotExists);
        }
    }

    public void checkIfMaintenanceExists(int maintenanceId) {
        if (!repository.existsById(maintenanceId)) {
            throw new BusinessException(Messages.Maintenance.NotExists);
        }
    }

    public void checkCarAvailabilityForMaintenance(State state) {
        if(state.equals(State.RENTED)){
            throw new BusinessException(Messages.Maintenance.CarIsRented);
        }
    }
}
