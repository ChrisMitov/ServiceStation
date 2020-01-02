package com.christian.service;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.christian.dto.CarRepairingDto;
import com.christian.exception.CustomException;
import com.christian.model.Car;
import com.christian.model.CarRepairing;
import com.christian.model.Employee;
import com.christian.model.ServiceStation;
import com.christian.model.enums.CarRepairingType;
import com.christian.repository.CarRepairingRepository;
import com.christian.repository.CarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarService {

  private ServiceStationService  serviceStationService;
  private CarRepository          carRepository;
  private CarRepairingRepository carRepairingRepository;
  @Qualifier( "customJson" )
  private ObjectMapper           customJson;

  public void repairCar( CarRepairingDto carRepairingDto ) {
    CarRepairing carRepairing = customJson.convertValue( carRepairingDto, CarRepairing.class );
    final ServiceStation serviceStationById = serviceStationService.getServiceStationById( carRepairingDto.getServiceStationId() );
    validateRepairingType( carRepairingDto, serviceStationById );
    carRepairing.setCar( getCarById( carRepairingDto.getCarId() ) );
    carRepairing.setServiceStation( serviceStationById );
    carRepairingRepository.save( carRepairing );
  }

  public List<CarRepairingDto> getCarStatistic( Long carId ) {
    return carRepairingRepository.findAllByCarId( carId ).stream()
        .map( carRepairing -> customJson.convertValue( carRepairing, CarRepairingDto.class ) )
        .collect( Collectors.toList() );
  }

  public List<CarRepairingDto> getCarStatisticByServiceId( Long serviceStationId ) {
    return carRepairingRepository.findAllByServiceStationId( serviceStationId ).stream()
        .map( carRepairing -> customJson.convertValue( carRepairing, CarRepairingDto.class ) )
        .collect( Collectors.toList() );
  }

  public Car getCarById( Long carId ) {
    final Optional<Car> optionalCar = carRepository.findById( carId );
    return optionalCar.orElseThrow( () ->
        new CustomException( "Car not found!", "Car with this id not found" ) );
  }

  public Set<CarRepairingType> getRepairingTypes() {
    return EnumSet.allOf( CarRepairingType.class );
  }

  private void validateRepairingType( CarRepairingDto carRepairingDto, ServiceStation serviceStationById ) {
    serviceStationById.getEmployees().stream()
        .map( Employee::getCarRepairingType )
        .filter( carRepairingType -> carRepairingDto.getCarRepairingType().equals( carRepairingType.name() ) )
        .findAny()
        .orElseThrow( () ->
            new CustomException( "Repairing type not found!", "Employee with this repairing type not found!" )
        );
  }

}
