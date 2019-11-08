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

import javax.validation.Valid;

@RestController
public class EmployeeController {
    private ObjectMapper objectMapper;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(@Qualifier("customJson") ObjectMapper objectMapper, EmployeeService employeeService) {
        this.objectMapper = objectMapper;
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id) throws Exception {
        return employeeService.getEmployeePerId(id).orElseThrow(() -> new Exception("Invalid number"));
    }

    @PostMapping("/employee")
    public EmployeeDto addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        Employee employee = objectMapper.convertValue(employeeDto, Employee.class);
        return objectMapper.convertValue(employeeService.addNewEmployee(employee), EmployeeDto.class);
    }
}
