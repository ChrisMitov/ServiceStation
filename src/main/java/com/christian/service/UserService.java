package com.christian.service;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.christian.exception.CustomException;
import com.christian.model.Car;
import com.christian.model.User;
import com.christian.model.enums.Roles;
import com.christian.repository.CarRepository;
import com.christian.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
  private UserRepository userRepository;
  private CarRepository  carRepository;

  public User getUserById( Long id ) throws Exception {
    final Optional<User> optionalUser = userRepository.findById( id );
    return optionalUser.orElseThrow( () -> new Exception( "" ) );
  }

  public void addCarToUser( Car car ) {
    final User user = getUserByUsername( SecurityContextHolder.getContext().getAuthentication().getName() );
    car.setUser( user );
    carRepository.save( car );
  }

  public User createUser( User user ) {
    final User userByUsername = getUserByUsername( user.getUsername() );
    if( userByUsername != null ) {
      throw new CustomException( "Username already exists!", "User with this username already exists!" );
    }
    String encodedPassword = new BCryptPasswordEncoder().encode( user.getPassword() );
    user.setPassword( encodedPassword );
    user.setRole( Roles.User );
    return userRepository.saveAndFlush( user );
  }

  public User getUserByUsername( String username ) {
    return userRepository.findByUsername( username );
  }
}
