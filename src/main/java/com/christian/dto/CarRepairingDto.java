package com.christian.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode( callSuper = true )
@Data
public class CarRepairingDto extends BaseDto {
  private Long       carId;
  private String     carRepairingType;
  private Long       serviceStationId;
  private BigDecimal price;
  private LocalDate  startingTime;
  private CarDto     car;
}
