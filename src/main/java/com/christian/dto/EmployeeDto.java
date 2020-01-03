package com.christian.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeDto extends BaseDto {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Username is mandatory")
    private String username;
    @NotBlank(message = "Password is mandatory")
    private String password;
    private Long serviceStationId;
    private ServiceStationDto serviceStation;
    @NotBlank(message = "Repairing type is mandatory")
    private String carRepairingType;
}
