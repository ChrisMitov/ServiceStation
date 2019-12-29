package com.christian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.christian.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
