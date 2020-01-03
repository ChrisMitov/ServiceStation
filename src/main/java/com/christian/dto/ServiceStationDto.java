package com.christian.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode( callSuper = true )
@Data
public class ServiceStationDto extends BaseDto {
  private String name;
  private String address;
  private String brand;
}
