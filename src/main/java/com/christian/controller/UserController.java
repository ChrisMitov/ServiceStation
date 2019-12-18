package com.christian.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christian.dto.CarDto;
import com.christian.dto.CarRepairingDto;
import com.christian.dto.UserDto;

@RestController
@RequestMapping("/user")
public class UserController {


  @GetMapping("/{id}")
  public UserDto getUserById( @PathVariable String id ){
    return null;
  }

  @PostMapping
  public void createUser(@RequestBody UserDto userDto){

  }

  @PostMapping("/addCar/{id}")
  public void addCarToUser( @RequestBody CarDto carDto, @PathVariable("id") String userId ){

  }

  @PostMapping("/repairCar")
  public void repairCar(@RequestBody CarRepairingDto carRepairingDto ){

  }

}
