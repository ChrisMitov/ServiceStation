package com.christian.controller;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christian.dto.CarRepairingDto;
import com.christian.model.enums.Brand;
import com.christian.model.enums.CarRepairingType;
import com.christian.service.CarService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping( "/car" )
@AllArgsConstructor
public class CarController {

  private CarService carService;

  @PostMapping( "/repairCar" )
  public ResponseEntity<Object> repairCar( @RequestBody CarRepairingDto carRepairingDto ) {
    carService.repairCar( carRepairingDto );
    return new ResponseEntity<>( HttpStatus.OK );
  }

  @GetMapping( "/repairingType" )
  public Set<CarRepairingType> getRepairingTypes() {
    return carService.getRepairingTypes();
  }

  @GetMapping( "/brands" )
  public Set<Brand> getBrands() {
    return carService.getBrands();
  }

  @GetMapping( "/statistic/{carId}" )
  public List<CarRepairingDto> getCarStatisticByCarId( @PathVariable Long carId ) {
    return carService.getCarStatistic( carId );
  }

  @GetMapping( "/statistic/service/{serviceId}" )
  public List<CarRepairingDto> getCarStatisticByServiceId( @PathVariable Long serviceId ) {
    return carService.getCarStatisticByServiceId( serviceId );
  }
}
