package com.christian.service;

import com.christian.dto.ServiceStationDto;
import com.christian.model.Car;
import com.christian.model.CarRepairing;
import com.christian.model.ServiceStation;
import com.christian.repository.ServiceStationRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceStationService {

  private ServiceStationRepository repository;

  public ServiceStation getServiceStationById( Long serviceStationId ) throws Exception {
    return repository.findById( serviceStationId ).orElseThrow( () -> new Exception( "" ) );
  }

  public ServiceStation saveServiceStation( ServiceStation serviceStation ) {
    return repository.save( serviceStation );
  }

  public void repairCar( Long id, Car car ) {
    Optional<ServiceStation> optionalServiceStation = repository.findById( id );
    if( optionalServiceStation.isPresent() ) {
      ServiceStation serviceStation = optionalServiceStation.get();
      CarRepairing carRepairing = new CarRepairing();
//      carRepairing.setCar( car );

    }
  }

  public List<ServiceStation> getAllServiceStation() {
    return repository.findAll();
  }
}
