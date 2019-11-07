package com.christian.service;

import org.springframework.stereotype.Service;

import com.christian.model.Employee;
import com.christian.repository.EmployeeRepository;

@Service
public class EmployeeService {

  private EmployeeRepository repository;

  public EmployeeService( EmployeeRepository repository ) {
    this.repository = repository;
  }

  public Employee getEmployeePerId( Long id ) {
    return repository.getOne( id );
  }

  public Employee addNewEmployee(Employee employee){
    return repository.save( employee );
  }
}
