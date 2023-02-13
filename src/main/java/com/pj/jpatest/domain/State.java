package com.pj.jpatest.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "state")
@Data
public class State {
    @Id
    private Long id;
    private String name;
}
