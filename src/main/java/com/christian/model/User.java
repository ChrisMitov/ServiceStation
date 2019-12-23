package com.christian.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode( callSuper = true )
public class User extends Person {

  @OneToMany( mappedBy = "user" )
  private Set<Car> cars;

}
