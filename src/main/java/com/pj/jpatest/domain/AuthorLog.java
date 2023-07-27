package com.pj.jpatest.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "author_log")
@Data
public class AuthorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
