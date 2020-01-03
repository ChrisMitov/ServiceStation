package com.christian.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.christian.dto.CarRepairingDto;
import com.christian.dto.EmployeeDto;
import com.christian.model.CarStatistics;
import com.christian.service.EmployeeService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping( "/employee" )
public class EmployeeController {
  private EmployeeService employeeService;

  public EmployeeController( EmployeeService employeeService ) {
    this.employeeService = employeeService;
  }

  @GetMapping( "/{id}" )
  public EmployeeDto getEmployee( @PathVariable Long id ) {
    return employeeService.getEmployeePerId( id );
  }

  @PostMapping
  public Mono<EmployeeDto> addEmployee( @Valid @RequestBody EmployeeDto employeeDto ) {
    return Mono.just( employeeService.addNewEmployee( employeeDto ) );
  }

  @GetMapping( "/cars" )
  public List<CarRepairingDto> getEmployeeCars() {
    return employeeService.getEmployeeCars();
  }

  @GetMapping( "/statistic" )
  public List<CarStatistics> getStatistic( @RequestParam String type ) {
    return employeeService.getStatisticByBrand( type);
  }

}
