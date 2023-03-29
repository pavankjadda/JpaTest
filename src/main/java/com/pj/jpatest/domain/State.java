package com.pj.jpatest.domain;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "state")
@Data
public class State {
    @Id
    private Long id;
    private String name;
}
