package com.christian.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christian.dto.CarDto;
import com.christian.dto.CarRepairingDto;
import com.christian.dto.UserDto;
import com.christian.model.Car;
import com.christian.model.User;
import com.christian.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping( "/user" )
@AllArgsConstructor
public class UserController {

  private UserService  userService;
  @Qualifier( "customJson" )
  private ObjectMapper customJson;

  @GetMapping( "/{id}" )
  public UserDto getUserById( @PathVariable String id ) throws Exception {
    final User user = userService.getUserById( Long.parseLong( id ) );
    return customJson.convertValue( user, UserDto.class );
  }

  @PostMapping
  public UserDto createUser( @RequestBody UserDto userDto ) {
    final User user = customJson.convertValue( userDto, User.class );
    return customJson.convertValue( userService.createUser( user ), UserDto.class );
  }

  @PostMapping( "/addCar" )
  public void addCarToUser( @RequestBody CarDto carDto ) {
    final Car car = customJson.convertValue( carDto, Car.class );
    userService.addCarToUser( car );
  }

  @GetMapping( "/showCars" )
  public Set<Car> getMyCars() {
    final User user = userService.getUserByUsername( SecurityContextHolder.getContext().getAuthentication().getName() );
    return user.getCars();
  }

}
