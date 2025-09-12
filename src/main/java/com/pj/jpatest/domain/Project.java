package com.pj.jpatest.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "project")
@Getter
@Setter
@Audited(withModifiedFlag = true)
public class Project implements Serializable {
    @Serial private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String location;

    @Enumerated(EnumType.STRING)
    private ProjectType projectType;
}