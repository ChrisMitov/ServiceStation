package com.christian.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceStationDto extends BaseDto {
    public String name;
}
