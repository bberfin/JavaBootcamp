package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.business.abstracts.MaintenanceService;
import kodlama.io.rentacar.business.dto.responses.get.car.GetAllCarsResponse;
import kodlama.io.rentacar.entities.Car;
import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class MaintenanceManager implements MaintenanceService {

    private final MaintenanceRepository repository;
    private final CarService carService;

    @Override
    public void maintenance(Car car) {
        if(car.getState()== State.RENTED){
            System.out.println("araba kirada olduğu için bakıma gönderilemez");
        }
        else if(car.getState()==State.MAINTENANCE){
            System.out.println("araba zaten bakımda olduğu için bakıma gönderilemez");
        }
        else if (car.getState()==State.AVAILABLE){
            System.out.println("araba bakıma gönderiliyorr..");
            car.setState(State.MAINTENANCE);
        }
    }

    @Override
    public void stopMaintenance(Car car) {
        if(car.getState()==State.MAINTENANCE){
            car.setState(State.AVAILABLE);
            System.out.println("araba bakımdan çıktı");
        }
        else {
            System.out.println("araba zaten bakımda değil");
        }
    }

//    @Override
//    public List<GetAllCarsResponse> getAllMaintenanceCars() {
//        List<GetAllCarsResponse> cars= carService.getAll();
//        for(Car car: cars)
//
//    }


}
