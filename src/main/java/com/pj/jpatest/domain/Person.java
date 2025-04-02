package com.pj.jpatest.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.io.Serializable;
import java.util.Objects;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

@Entity
@Table(name = "person")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Audited(targetAuditMode = NOT_AUDITED, withModifiedFlag = true)
public class Person implements Serializable {
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
    @NotAudited
    @ToString.Exclude
    private Address homeAddress;

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email) &&
                Objects.equals(phoneNumber, person.phoneNumber);
    }
}