package com.christian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ServiceStationApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServiceStationApplication.class, args);
  }
}
