package com.christian.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.christian.exception.CustomException;
import com.christian.model.ServiceStation;
import com.christian.repository.ServiceStationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceStationService {

  private ServiceStationRepository repository;

  public ServiceStation getServiceStationById( Long serviceStationId ) {
    return repository.findById( serviceStationId )
        .orElseThrow( () -> new CustomException( "Service station not found!", "Service station with this id not found!" ) );
  }

  public ServiceStation saveServiceStation( ServiceStation serviceStation ) {
    return repository.save( serviceStation );
  }

  public List<ServiceStation> getAllServiceStation() {
    return repository.findAll();
  }
}
