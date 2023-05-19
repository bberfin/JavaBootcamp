package com.kodlamaio.inventoryservice.repository;

import com.kodlamaio.inventoryservice.entities.Car;
import com.kodlamaio.inventoryservice.entities.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    @Modifying
    @Transactional
    @Query(value = "update Car set state = :state where id= :id")
        //SPel
    void changeStateByCarId(State state, UUID id);
}
