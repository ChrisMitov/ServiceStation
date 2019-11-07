package com.christian.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class ServiceStation {
  @Id
  @GeneratedValue
  private Long   id;
  @OneToMany( targetEntity = Employee.class )
  private List<Employee> employees;
}
