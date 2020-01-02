package com.christian.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christian.model.Car;
import com.christian.model.CarRepairing;

public interface CarRepairingRepository extends JpaRepository<CarRepairing, Long> {
  List<CarRepairing> findAllByCarId( Long carId );

  List<CarRepairing> findAllByServiceStationId( Long serviceStationId );
}
