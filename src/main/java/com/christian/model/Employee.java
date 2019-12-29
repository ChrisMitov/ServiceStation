package com.christian.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.christian.model.enums.CarRepairingType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode( callSuper = true, exclude = { "serviceStation" } )
public class Employee extends Person {

  @ManyToOne
  @JoinColumn( name = "service_station_id" )
  private ServiceStation serviceStation;

  @Enumerated( EnumType.STRING )
  private CarRepairingType typesOfService;
}
