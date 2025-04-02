package com.pj.jpatest.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

import java.util.Objects;

@Entity
@Table(name = "state")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Audited(withModifiedFlag = true)
public class State {
    @Id
    private Long id;
    private String name;

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof State state)) return false;
        return Objects.equals(id, state.id) && Objects.equals(name, state.name);
    }
}