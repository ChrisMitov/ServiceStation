package com.christian.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.christian.model.User;
import com.christian.repository.UserRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
  private UserRepository userInfoRepository;

  @Override
  public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {

    User user = userInfoRepository.findByUsername( username );
    if( user == null ) {
      throw new UsernameNotFoundException( "User not found with username: " + username );
    }
    return new org.springframework.security.core.userdetails.User( user.getUsername(), user.getPassword(),
        Stream.of( user.getRole() ).collect( Collectors.toList() ) );
  }

}
