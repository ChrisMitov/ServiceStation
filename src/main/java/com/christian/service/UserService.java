package com.christian.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.christian.model.User;
import com.christian.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
  private UserRepository userRepository;

  public User addUser( User user ) {
    return userRepository.save( user );
  }

  public User getUserById( Long id ) throws Exception {
    final Optional<User> optionalUser = userRepository.findById( id );
    return optionalUser.orElseThrow( () -> new Exception( "" ) );
  }
}
