package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.business.abstracts.InvoiceService;
import kodlama.io.rentacar.business.abstracts.PaymentService;
import kodlama.io.rentacar.business.abstracts.RentalService;
import kodlama.io.rentacar.business.dto.requests.create.invoice.CreateInvoiceRequest;
import kodlama.io.rentacar.business.dto.requests.create.rental.CreateRentalRequest;
import kodlama.io.rentacar.business.dto.requests.update.rental.UpdateRentalRequest;
import kodlama.io.rentacar.business.dto.responses.create.rental.CreateRentalResponse;
import kodlama.io.rentacar.business.dto.responses.get.car.GetCarResponse;
import kodlama.io.rentacar.business.dto.responses.get.rental.GetAllRentalsResponse;
import kodlama.io.rentacar.business.dto.responses.get.rental.GetRentalResponse;
import kodlama.io.rentacar.business.dto.responses.update.rental.UpdateRentalResponse;
import kodlama.io.rentacar.business.rules.RentalBusinessRules;
import kodlama.io.rentacar.common.dto.CreateRentalPaymentRequest;
import kodlama.io.rentacar.entities.Car;
import kodlama.io.rentacar.entities.Rental;
import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private final RentalRepository repository;
    private final ModelMapper mapper;
    private final CarService carService;
    private final PaymentService paymentService;
    private final InvoiceService invoiceService;
    private final RentalBusinessRules rentalBusinessRules;

    @Override
    public List<GetAllRentalsResponse> getAll() {
        List<Rental> rentals = repository.findAll();
        List<GetAllRentalsResponse> response = rentals
                .stream()
                .map(rental -> mapper.map(rental, GetAllRentalsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetRentalResponse getById(int id) {
        rentalBusinessRules.checkIfRentalExists(id);
        Rental rental = repository.findById(id).orElseThrow();
        GetRentalResponse response = mapper.map(rental, GetRentalResponse.class);

        return response;
    }

    @Override
    public CreateRentalResponse add(CreateRentalRequest request) {
        rentalBusinessRules.checkIfCarAvailable(carService.getById(request.getCardId()).getState());
        Rental rental = mapper.map(request, Rental.class);
        rental.setId(0);
        rental.setTotalPrice(getTotalPrice(rental));
        rental.setStartDate(LocalDateTime.now());


        //creating payment
        CreateRentalPaymentRequest paymentRequest = new CreateRentalPaymentRequest();
        mapper.map(request.getPaymentRequest(), paymentRequest);
        paymentRequest.setPrice(getTotalPrice(rental));
        paymentService.processRentalPayment(paymentRequest);

        repository.save(rental);
        carService.changeState(request.getCardId(), State.RENTED);
        CreateRentalResponse response = mapper.map(rental, CreateRentalResponse.class);

        //creating invoice
        Car car = mapper.map(carService.getById(request.getCardId()), Car.class);
        rental.setCar(car);
        CreateInvoiceRequest invoiceRequest = new CreateInvoiceRequest();
        createInvoiceRequest(request,invoiceRequest,rental);
        invoiceService.add(invoiceRequest);

        return response;
    }

    @Override
    public UpdateRentalResponse update(int id, UpdateRentalRequest request) {
        rentalBusinessRules.checkIfRentalExists(id);
        Rental rental = mapper.map(request, Rental.class);
        rental.setId(id);
        rental.setTotalPrice(getTotalPrice(rental));
        repository.save(rental);
        UpdateRentalResponse response = mapper.map(rental, UpdateRentalResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rentalBusinessRules.checkIfRentalExists(id);
        int carId = repository.findById(id).get().getCar().getId();
        carService.changeState(carId, State.AVAILABLE);
        repository.deleteById(id);
    }

    //////////////////////////////
    private double getTotalPrice(Rental rental) {
        return rental.getDailyPrice() * rental.getRentedForDays();
    }
    private void createInvoiceRequest(CreateRentalRequest createRentalRequest, CreateInvoiceRequest invoiceRequest, Rental rental){

        invoiceRequest.setRentedAt(rental.getStartDate());
        invoiceRequest.setModelName(rental.getCar().getModel().getName());
        invoiceRequest.setBrandName(rental.getCar().getModel().getBrand().getName());
        invoiceRequest.setDailyPrice(createRentalRequest.getDailyPrice());
        invoiceRequest.setPlate(rental.getCar().getPlate());
        invoiceRequest.setCardHolder(createRentalRequest.getPaymentRequest().getCardHolder());
        invoiceRequest.setModelYear(rental.getCar().getModelYear());
        invoiceRequest.setRentedForDays(createRentalRequest.getRentedForDays());
    }
}
