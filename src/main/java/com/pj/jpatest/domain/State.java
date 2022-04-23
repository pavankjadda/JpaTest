package com.pj.jpatest.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state")
@Data
public class State {
    @Id
    private Long id;
    private String name;
}
