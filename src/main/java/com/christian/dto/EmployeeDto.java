package com.christian.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeDto extends BaseDto {
    private String name;
    private String username;
    private String password;
    private Long serviceStationId;
    private ServiceStationDto serviceStation;
    private String carRepairingType;
}
