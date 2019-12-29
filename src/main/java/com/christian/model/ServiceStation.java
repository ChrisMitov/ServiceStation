package com.christian.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table
@Data
public class ServiceStation {
  @Id
  @GeneratedValue
  private Long           id;
  @Column
  private String         name;
  @Column
  private String         address;
  @JsonIgnore
  @OneToMany( mappedBy = "serviceStation" )
  private List<Employee> employees;
}
