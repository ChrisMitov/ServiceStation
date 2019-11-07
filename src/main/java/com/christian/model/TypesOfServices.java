package com.christian.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class TypesOfServices {
  @Id
  @GeneratedValue
  private Long   id;
  @Column
  private String name;
}
