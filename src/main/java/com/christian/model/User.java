package com.christian.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.christian.model.enums.CarRepairingType;
import com.christian.model.enums.Roles;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode( callSuper = true , exclude = { "serviceStation" } )
public class User extends AuditModel {
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
  @OneToMany( mappedBy = "user" )
  private Set<Car> cars;
  @ManyToOne
  @JoinColumn( name = "service_station_id" )
  private ServiceStation serviceStation;

  @Enumerated( EnumType.STRING )
  private CarRepairingType carRepairingType;
}
