package com.christian.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.christian.dto.CarRepairingDto;
import com.christian.dto.EmployeeDto;
import com.christian.exception.CustomException;
import com.christian.model.Employee;
import com.christian.model.ServiceStation;
import com.christian.model.enums.Roles;
import com.christian.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
  @Qualifier( "customJson" )
  private ObjectMapper          objectMapper;
  private EmployeeRepository    employeeRepository;
  private ServiceStationService serviceStationService;
  private CarService            carService;

  public Employee getEmployeePerId( Long id ) {
    return employeeRepository.findById( id ).orElseThrow( () -> new CustomException( "Invalid id", "Invalid id for given employee" ) );
  }

  public EmployeeDto addNewEmployee( EmployeeDto employeeDto ) {
    Employee employee = objectMapper.convertValue( employeeDto, Employee.class );
    final ServiceStation serviceStationById = serviceStationService.getServiceStationById( employeeDto.getServiceStationId() );
    employee.setServiceStation( serviceStationById );
    employee.setRole( Roles.Employee );
    return objectMapper.convertValue( employeeRepository.saveAndFlush( employee ), EmployeeDto.class );
  }

  public List<CarRepairingDto> getEmployeeCars( Long employeeId ) {
    final Employee employee = getEmployeePerId( employeeId );
    return carService.getCarStatisticByServiceId( employee.getServiceStation().getId() );
  }

  public void getStatistic( String type, String brand, Integer year ) {

  }
}
