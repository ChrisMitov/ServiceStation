package com.christian.dto;

import com.christian.model.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode( callSuper = true )
@Data
public class CarDto extends BaseDto {
  private String  number;
  private String  brand;
  private String  model;
  private Integer yearOfConstruction;
  private User user;
}
