package com.christian.model;

import com.christian.model.enums.CarRepairingType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class CarRepairing extends AuditModel {
    @Id
    @GeneratedValue
    private Long             id;
    private CarRepairingType repairingType;

//    private Car car;
//    private ServiceStation serviceStation;
//    private Employee employee;
    private LocalDateTime startingTime;
    private BigDecimal price;

}
