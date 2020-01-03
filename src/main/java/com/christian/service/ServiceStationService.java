package com.christian.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.christian.exception.CustomException;
import com.christian.model.ServiceStation;
import com.christian.model.User;
import com.christian.repository.ServiceStationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceStationService {

  private ServiceStationRepository repository;
  private UserService              userService;

  public ServiceStation getServiceStationById( Long serviceStationId ) {
    return repository.findById( serviceStationId )
        .orElseThrow( () -> new CustomException( "Service station not found!", "Service station with this id not found!" ) );
  }

  public ServiceStation saveServiceStation( ServiceStation serviceStation ) {
    final User admin = userService.getUserByUsername( SecurityContextHolder.getContext().getAuthentication().getName() );
    serviceStation.setAdmin( admin );
    return repository.save( serviceStation );
  }

  public List<ServiceStation> getAdminServiceStation() {
    final User user = userService.getUserByUsername( SecurityContextHolder.getContext().getAuthentication().getName() );
    return repository.getAllByAdmin_Id( user.getId() );
  }

  public List<ServiceStation> getAllServiceStation() {
    return repository.findAll();
  }

  public void deleteServiceStation( Long id ) {
    repository.deleteById( id );
  }

  public ServiceStation updateServiceStation( ServiceStation serviceStation ) {
    final User admin = userService.getUserByUsername( SecurityContextHolder.getContext().getAuthentication().getName() );
    serviceStation.setAdmin( admin );
    return repository.save( serviceStation );
  }
}
