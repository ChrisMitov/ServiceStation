package com.christian.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christian.dto.ServiceStationDto;
import com.christian.model.ServiceStation;
import com.christian.model.User;
import com.christian.service.ServiceStationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping( "/service" )
public class ServiceStationController {
  private ObjectMapper          objectMapper;
  private ServiceStationService stationService;

  @Autowired
  public ServiceStationController( @Qualifier( "customJson" ) ObjectMapper objectMapper, ServiceStationService stationService ) {
    this.objectMapper = objectMapper;
    this.stationService = stationService;
  }

  @PostMapping
  public Mono<ServiceStationDto> addServiceStation( @Valid @RequestBody ServiceStationDto serviceStationDto ) {
    ServiceStation serviceStation = objectMapper.convertValue( serviceStationDto, ServiceStation.class );
    ServiceStation serviceStation1 = stationService.saveServiceStation( serviceStation );
    return Mono.just( objectMapper.convertValue( serviceStation1, ServiceStationDto.class ) );
  }

  @GetMapping
  public List<ServiceStationDto> getAllServiceStation() {
    final List<ServiceStation> allServiceStation = stationService.getAllServiceStation();
    return allServiceStation.stream()
        .map( serviceStation -> objectMapper.convertValue( serviceStation, ServiceStationDto.class ) )
        .collect( Collectors.toList() );
  }

  @GetMapping("/user")
  public List<ServiceStationDto> getAdminServiceStation() {
    final List<ServiceStation> allServiceStation = stationService.getAdminServiceStation();
    return allServiceStation.stream()
        .map( serviceStation -> objectMapper.convertValue( serviceStation, ServiceStationDto.class ) )
        .collect( Collectors.toList() );
  }

  @GetMapping( "/{id}" )
  public ServiceStationDto getServiceStation( @PathVariable String id ) {
    final ServiceStation serviceStationById = stationService.getServiceStationById( Long.parseLong( id ) );
    return objectMapper.convertValue( serviceStationById, ServiceStationDto.class );
  }

  @GetMapping( "/employees/{serviceStationId}" )
  public List<User> getAllEmployees( @PathVariable String serviceStationId ) {
    final ServiceStation serviceStationById = stationService.getServiceStationById( Long.parseLong( serviceStationId ) );
    return serviceStationById.getEmployees();
  }

  @PutMapping
  public ServiceStation updateServiceStation(@RequestBody ServiceStationDto serviceStationDto){
    ServiceStation serviceStation = objectMapper.convertValue( serviceStationDto, ServiceStation.class );
    return stationService.updateServiceStation(serviceStation);
  }

  @DeleteMapping("/{id}")
  public void deleteServiceStation( @PathVariable Long id ){
    stationService.deleteServiceStation(id);
  }
}
