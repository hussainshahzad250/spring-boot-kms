package com.sas.kms.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE_DETAILS")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String mobile;

    private String designation;

    @Column(name = "created_on",columnDefinition = "TIMESTAMP")
    private LocalDateTime createdOn;
}
