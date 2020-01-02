package com.christian.model;

import com.christian.model.enums.CarRepairingType;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Data
@EqualsAndHashCode( callSuper = true )
public class CarRepairing extends AuditModel {
  @Id
  @GeneratedValue
  private Long             id;
  @Enumerated( EnumType.STRING )
  private CarRepairingType carRepairingType;
  @ManyToOne
  @JoinColumn( name = "car_id" )
  private Car              car;
  @ManyToOne
  @JoinColumn( name = "service_station_id" )
  private ServiceStation   serviceStation;
  private LocalDate        startingTime;
  private BigDecimal       price;
}
