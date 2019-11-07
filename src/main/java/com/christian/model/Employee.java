package com.christian.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Employee {
  @Id
  @GeneratedValue
  private Long                  id;
  @Column
  private String                name;
  @ManyToOne
  private ServiceStation        serviceStation;
  @OneToMany
  private List<TypesOfServices> typesOfServices;
}
