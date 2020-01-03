package com.christian.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.christian.model.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode( callSuper = true )
@Data
public class CarDto extends BaseDto {
  @NotBlank(message = "Number is mandatory")
  private String  number;
  @NotBlank(message = "Brand is mandatory")
  private String  brand;
  @NotBlank(message = "Model is mandatory")
  private String  model;
  @NotNull(message = "Year of construction is mandatory")
  private Integer yearOfConstruction;
  private User user;
}
