package com.christian.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.christian.model.CarRepairing;
import com.christian.model.CarStatistics;
import com.christian.model.enums.Brand;

public interface CarRepairingRepository extends JpaRepository<CarRepairing, Long> {
  List<CarRepairing> findAllByCarId( Long carId );

  List<CarRepairing> findAllByServiceStationId( Long serviceStationId );

  @Query( "select count(cr) as y, cr.car.brand as label "
      + "from CarRepairing cr "
      + " where cr.serviceStation.id =?1 "
      + "group by cr.car.brand" )
  List<CarStatistics> countAllCarsByBrand( Long serviceStationId );

  @Query( "select count(cr) as y, cr.car.yearOfConstruction as label "
      + "from CarRepairing cr "
      + " where cr.serviceStation.id =?1 "
      + "group by cr.car.yearOfConstruction" )
  List<CarStatistics> countAllCarsByYear( Long serviceStationId );

  @Query( "select count(cr) as y, cr.carRepairingType as label "
      + "from CarRepairing cr "
      + " where cr.serviceStation.id =?1 "
      + "group by cr.carRepairingType" )
  List<CarStatistics> countAllCarsByRepairingType( Long serviceStationId );
}
