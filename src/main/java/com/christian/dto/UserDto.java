package com.christian.dto;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends BaseDto {
  private String      name;
  private String      username;
  private String      password;
  private Set<CarDto> cars;
}
