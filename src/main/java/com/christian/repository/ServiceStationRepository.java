package com.christian.repository;

import java.util.List;

import com.christian.model.ServiceStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceStationRepository extends JpaRepository<ServiceStation, Long> {

  List<ServiceStation> getAllByAdmin_Id(Long id);
}
