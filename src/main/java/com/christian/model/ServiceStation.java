package com.christian.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table
@Accessors( chain = false )
public class ServiceStation {
  @Id
  @GeneratedValue
  private Long   id;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceStation")
  private List<Employee> employees;
}
