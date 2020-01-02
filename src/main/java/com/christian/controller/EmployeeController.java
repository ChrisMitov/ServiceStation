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
import com.christian.model.Employee;
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
  public Employee getEmployee( @PathVariable Long id ) {
    return employeeService.getEmployeePerId( id );
  }

  @PostMapping
  public Mono<EmployeeDto> addEmployee( @Valid @RequestBody EmployeeDto employeeDto ) {
    return Mono.just( employeeService.addNewEmployee( employeeDto ) );
  }

  @GetMapping( "/cars/{employeeId}" )
  public List<CarRepairingDto> getEmployeeCars( @PathVariable Long employeeId ) {
    return employeeService.getEmployeeCars( employeeId );
  }

  @GetMapping("/statistic")
  public void getStatistic(@RequestParam("type") String type, @RequestParam("brand") String brand, @RequestParam("year") Integer year ){
    employeeService.getStatistic(type, brand, year);
  }

}
