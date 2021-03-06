package com.christian.model;

import com.christian.model.enums.Brand;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table
@Data
@EqualsAndHashCode( callSuper = true, exclude = {"user"})
public class Car extends AuditModel {
  @Id
  @GeneratedValue
  private Long    id;
  @Column
  private String number;
  @Column
  @Enumerated(EnumType.STRING)
  private Brand  brand;
  @Column
  private String model;
  @Column
  private Integer yearOfConstruction;
  @JsonIgnore
  @ManyToOne
  @JoinColumn( name = "user_id" )
  private User    user;
}
