package com.pj.jpatest.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Data
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Embedded
    @AttributeOverrides(value = {@AttributeOverride(name = "addressLine1", column = @Column(name = "streetName")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "apartmentNumber"))})
    private Address homeAddress;

}
