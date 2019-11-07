package com.christian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.christian.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
