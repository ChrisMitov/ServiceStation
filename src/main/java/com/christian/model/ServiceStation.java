package com.christian.model;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table
@Data
public class ServiceStation {
  @Id
  @GeneratedValue
  private Long   id;
  @Column
  private String name;
//  @OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceStation")
//  private List<Employee> employees;
}
