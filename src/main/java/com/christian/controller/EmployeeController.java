package com.christian.controller;

import com.christian.dto.EmployeeDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.christian.model.Employee;
import com.christian.service.EmployeeService;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{id}")
    public Mono<Employee> getEmployee(@PathVariable Long id) throws Exception {
        return Mono.just(employeeService.getEmployeePerId(id).orElseThrow(() -> new Exception("Invalid number")));
    }

    @PostMapping("/employee")
    public Mono<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return Mono.just(employeeService.addNewEmployee(employeeDto));
    }
}
