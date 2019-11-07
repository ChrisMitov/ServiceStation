package com.christian.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table
@Accessors( chain = false )
@JsonIgnoreProperties( { "hibernateLazyInitializer" } )
public class Employee {
  @Id
  @GeneratedValue
  private Long           id;
  @Column( name = "name" )
  private String         name;
  @ManyToOne( fetch = FetchType.LAZY )
  @JoinColumn( name = "service_station_id" )
  private ServiceStation serviceStation;
  //  @OneToMany
  //  private List<TypesOfServices> typesOfServices;
}
