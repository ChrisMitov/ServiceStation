package com.christian.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode( callSuper = true )
@Data
public class ServiceStationDto extends BaseDto {
  @NotBlank(message = "Name is mandatory")
  private String name;
  @NotBlank(message = "Address is mandatory")
  private String address;
  @NotBlank(message = "Brand is mandatory")
  private String brand;
}
