package com.christian.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.christian.model.Car;
import com.christian.model.User;
import com.christian.repository.CarRepository;
import com.christian.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
  private UserRepository userRepository;
  private CarRepository  carRepository;

  public User addUser( User user ) {
    return userRepository.save( user );
  }

  public User getUserById( Long id ) throws Exception {
    final Optional<User> optionalUser = userRepository.findById( id );
    return optionalUser.orElseThrow( () -> new Exception( "" ) );
  }

  public void addCarToUser( Car car, String userId ) throws Exception {
    final User user = getUserById( Long.parseLong( userId ) );
    car.setUser( user );
    carRepository.save( car );
//    userRepository.save( user );
  }

  public User createUser( User user ) {
    return userRepository.saveAndFlush( user );
  }
}
