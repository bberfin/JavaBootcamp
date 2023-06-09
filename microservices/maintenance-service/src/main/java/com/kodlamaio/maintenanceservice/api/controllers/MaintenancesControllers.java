package com.kodlamaio.maintenanceservice.api.controllers;

import com.kodlamaio.maintenanceservice.business.abstracts.MaintenanceService;
import com.kodlamaio.maintenanceservice.business.dto.requests.create.CreateMaintenanceRequest;
import com.kodlamaio.maintenanceservice.business.dto.requests.update.UpdateMaintenanceRequest;
import com.kodlamaio.maintenanceservice.business.dto.responses.create.CreateMaintenanceResponse;
import com.kodlamaio.maintenanceservice.business.dto.responses.get.GetAllMaintenancesResponse;
import com.kodlamaio.maintenanceservice.business.dto.responses.get.GetMaintenanceResponse;
import com.kodlamaio.maintenanceservice.business.dto.responses.update.UpdateMaintenanceResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maintenances")
public class MaintenancesControllers {
    private final MaintenanceService service;

//    @PostConstruct
//    public void createdb() throws InterruptedException {
//        service.add(new CreateMaintenanceRequest());
//    }

    @GetMapping
    public List<GetAllMaintenancesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetMaintenanceResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PutMapping("/return")
    public GetMaintenanceResponse returnCarFromMaintenance(@RequestParam UUID carId) {
        return service.returnCarFromMaintenance(carId);
    }

    @PutMapping("/{id}")
    public UpdateMaintenanceResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateMaintenanceRequest request) {
        return service.update(id, request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMaintenanceResponse add(@Valid @RequestBody CreateMaintenanceRequest request) throws InterruptedException {
        return service.add(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
