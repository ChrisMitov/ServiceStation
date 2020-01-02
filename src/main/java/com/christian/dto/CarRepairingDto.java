package com.christian.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode( callSuper = true )
@Data
public class CarRepairingDto extends BaseDto {
  private Long          carId;
  private String        carRepairingType;
  private Long          serviceStationId;
  private BigDecimal    price;
  private LocalDateTime startingTime;
}
