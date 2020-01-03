package com.christian.service;

import static com.christian.model.enums.StatisticType.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.christian.dto.CarRepairingDto;
import com.christian.dto.EmployeeDto;
import com.christian.exception.CustomException;
import com.christian.model.CarStatistics;
import com.christian.model.ServiceStation;
import com.christian.model.User;
import com.christian.model.enums.Roles;
import com.christian.model.enums.StatisticType;
import com.christian.repository.CarRepairingRepository;
import com.christian.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
  @Qualifier( "customJson" )
  private ObjectMapper           objectMapper;
  private UserRepository         userRepository;
  private CarRepairingRepository carRepairingRepository;
  private ServiceStationService  serviceStationService;
  private CarService             carService;

  public EmployeeDto getEmployeePerId( Long id ) {
    final User user = userRepository.findById( id ).orElseThrow( () -> new CustomException( "Invalid id", "Invalid id for given employee" ) );
    return objectMapper.convertValue( user, EmployeeDto.class );
  }

  public EmployeeDto addNewEmployee( EmployeeDto employeeDto ) {
    User employee = objectMapper.convertValue( employeeDto, User.class );
    final ServiceStation serviceStationById = serviceStationService.getServiceStationById( employeeDto.getServiceStationId() );
    employee.setServiceStation( serviceStationById );
    employee.setRole( Roles.Employee );
    employee.setPassword( new BCryptPasswordEncoder().encode( employeeDto.getPassword() ) );
    return objectMapper.convertValue( userRepository.saveAndFlush( employee ), EmployeeDto.class );
  }

  public List<CarRepairingDto> getEmployeeCars() {
    final User employee = userRepository.findByUsername( SecurityContextHolder.getContext().getAuthentication().getName() );
    return carService.getCarStatisticByServiceId( employee.getServiceStation().getId() );
  }

  public List<CarStatistics> getStatisticByBrand( String type ) {
    final Long serviceId = userRepository.findByUsername( SecurityContextHolder.getContext().getAuthentication().getName() ).getServiceStation().getId();
    switch( StatisticType.valueOf( type ) ) {
      case Type:
        return carRepairingRepository.countAllCarsByRepairingType( serviceId );
      case Year:
        return carRepairingRepository.countAllCarsByYear( serviceId );
      default:
        return carRepairingRepository.countAllCarsByBrand( serviceId );

    }
  }

  public void deleteEmployee( Long id ) {
    userRepository.deleteById( id );
  }
}
