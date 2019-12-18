package com.christian.dto;

import java.time.LocalDateTime;

import com.christian.model.TypesOfServices;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CarRepairingDto extends BaseDto {
  private Long carId;
  private TypesOfServices typesOfServices;
  private Long serviceStationId;
  private Long employeeId;
  private Double amount;
  private LocalDateTime dateTime;

}
