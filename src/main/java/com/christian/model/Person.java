package com.christian.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.christian.model.enums.Roles;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( callSuper = true )
@MappedSuperclass
public abstract class Person extends AuditModel {
  @Id
  @GeneratedValue
  private Long   id;
  @Column( name = "name" )
  private String name;
  @Column(name = "username")
  private String username;
  @Column(name = "password", nullable = false)
  private String password;
  @Column(name = "role")
  @Enumerated( EnumType.STRING )
  private Roles  role;
}
