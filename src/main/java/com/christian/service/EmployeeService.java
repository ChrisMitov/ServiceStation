package com.christian.service;

import java.util.Optional;

import com.christian.dto.EmployeeDto;
import com.christian.model.ServiceStation;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.christian.model.Employee;
import com.christian.repository.EmployeeRepository;

@Service
public class EmployeeService {

  private ObjectMapper          objectMapper;
  private EmployeeRepository    employeeRepository;
  private ServiceStationService serviceStationService;

  @Autowired
  public EmployeeService( @Qualifier( "customJson" ) ObjectMapper objectMapper, EmployeeRepository employeeRepository, ServiceStationService serviceStationService ) {
    this.objectMapper = objectMapper;
    this.employeeRepository = employeeRepository;
    this.serviceStationService = serviceStationService;
  }

  public Optional<Employee> getEmployeePerId( Long id ) {
    return employeeRepository.findById( id );
  }

  public EmployeeDto addNewEmployee( EmployeeDto employeeDto ) throws Exception {
    Employee employee = objectMapper.convertValue( employeeDto, Employee.class );
    final ServiceStation serviceStationById = serviceStationService.getServiceStationById( employeeDto.getServiceStationId() );
    employee.setServiceStation( serviceStationById );
    return objectMapper.convertValue( employeeRepository.saveAndFlush( employee ), EmployeeDto.class );
  }
}
