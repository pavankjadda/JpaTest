package com.pj.jpatest.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

import java.io.Serializable;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Audited(withModifiedFlag = true)
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