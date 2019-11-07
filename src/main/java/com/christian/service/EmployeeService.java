package com.christian.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.christian.model.Employee;
import com.christian.repository.EmployeeRepository;

@Service
public class EmployeeService {

  private EmployeeRepository repository;

  public EmployeeService( EmployeeRepository repository ) {
    this.repository = repository;
  }

  public Optional<Employee> getEmployeePerId( Long id ) {
    return repository.findById( id );
  }

  public Employee addNewEmployee(Employee employee){
    return repository.saveAndFlush( employee );
  }
}
