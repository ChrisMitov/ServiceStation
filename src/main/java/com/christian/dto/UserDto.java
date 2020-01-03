package com.christian.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode( callSuper = true )
@Data
public class UserDto extends BaseDto {
  @NotBlank( message = "Name is mandatory" )
  private String      name;
  @NotBlank( message = "Username is mandatory" )
  private String      username;
  @NotBlank( message = "Password is mandatory" )
  private String      password;
  private Set<CarDto> cars;
}
