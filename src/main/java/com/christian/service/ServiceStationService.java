package com.christian.service;

import com.christian.model.ServiceStation;
import com.christian.repository.ServiceStationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceStationService {

    private ServiceStationRepository repository;

    public ServiceStationService(ServiceStationRepository repository) {
        this.repository = repository;
    }

    public Optional<ServiceStation> getServiceStationById(Long serviceStationId) {
        return repository.findById(serviceStationId);
    }

    public ServiceStation saveServiceStation(ServiceStation serviceStation){
        return repository.save(serviceStation);
    }
}
