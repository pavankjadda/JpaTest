package com.pj.jpatest.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Audited;

@Entity
@Table(name = "sport")
@Getter
@Setter
@NoArgsConstructor
@Audited()
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer players;
    private Integer ageGroup;
    private String description;

    public Sport(String name, Integer ageGroup, Integer players, String description) {
        this.name = name;
        this.players = players;
        this.ageGroup = ageGroup;
        this.description = description;
    }
}