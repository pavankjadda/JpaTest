package com.pj.jpatest.domain;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
@Data
public class Country {
    @Id
    private Long id;
    private String name;
}
