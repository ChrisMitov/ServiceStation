package com.christian.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.christian.model.enums.Brand;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table
@Data
public class ServiceStation {
  @Id
  @GeneratedValue
  private Long       id;
  @Column
  private String     name;
  @Column
  private String     address;
  @Enumerated( EnumType.STRING )
  private Brand      brand;
  @JsonIgnore
  @OneToMany( mappedBy = "serviceStation", cascade = CascadeType.REMOVE )
  private List<User> employees;

  @ManyToOne
  @JoinColumn( name = "user_id" )
  private User admin;
}
