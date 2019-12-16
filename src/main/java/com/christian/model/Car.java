package com.christian.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Car extends AuditModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String number;
    @Column
    private Brand brand;
    @Column
    private String model;
    @Column
    private Integer yearOfConstruction;
}
