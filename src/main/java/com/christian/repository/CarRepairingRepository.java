package com.christian.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christian.model.CarRepairing;
import com.christian.model.enums.Brand;
import com.christian.model.enums.CarRepairingType;

public interface CarRepairingRepository extends JpaRepository<CarRepairing, Long> {
  List<CarRepairing> findAllByCarId( Long carId );

  List<CarRepairing> findAllByServiceStationId( Long serviceStationId );

//  Integer countAllByRepairingType( CarRepairingType carRepairingType );
//
//  Integer countAllByCar_Brand( Brand brand );
//
//  Integer countAllByCar_YearOfConstruction( Brand brand );
}
