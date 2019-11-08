package com.christian.controller;

import com.christian.dto.ServiceStationDto;
import com.christian.model.ServiceStation;
import com.christian.service.ServiceStationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class ServiceStationController {
    private ObjectMapper objectMapper;
    private ServiceStationService stationService;

    @Autowired
    public ServiceStationController(@Qualifier("customJson") ObjectMapper objectMapper, ServiceStationService stationService) {
        this.objectMapper = objectMapper;
        this.stationService = stationService;
    }


    @PostMapping("/service")
    public HttpEntity<ServiceStationDto> addServiceStation(@Valid @RequestBody ServiceStationDto serviceStationDto) {
        ServiceStation serviceStation = objectMapper.convertValue(serviceStationDto, ServiceStation.class);
        ServiceStation serviceStation1 = stationService.saveServiceStation(serviceStation);
        return new HttpEntity<>(objectMapper.convertValue(serviceStation1, ServiceStationDto.class));
    }
}
