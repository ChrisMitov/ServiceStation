package com.christian.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
  @JsonIgnore
  @OneToMany( mappedBy = "serviceStation" )
  private List<User> employees;

  @ManyToOne
  @JoinColumn( name = "user_id" )
  private User admin;
}
