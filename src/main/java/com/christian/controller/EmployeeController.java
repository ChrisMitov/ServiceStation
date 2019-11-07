package com.christian.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christian.model.Employee;
import com.christian.service.EmployeeService;

@RestController
@RequestMapping( "/employee" )
public class EmployeeController {
  private EmployeeService employeeService;

  public EmployeeController( EmployeeService employeeService ) {
    this.employeeService = employeeService;
  }

  @GetMapping( "/{id}" )
  public Employee getEmployee( @PathVariable Long id ) throws Exception {
    return employeeService.getEmployeePerId( id ).orElseThrow( () -> new Exception( "Invalid number" ) );
  }

  @PostMapping
  public Employee addEmployee( @RequestBody Employee employee ) {
    return employeeService.addNewEmployee( employee );
  }
}
