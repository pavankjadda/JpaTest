package com.pj.jpatest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Length;
import org.hibernate.annotations.Nationalized;
import org.hibernate.envers.Audited;

import java.util.Objects;

@Entity
@Table(name = "county")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Audited(withModifiedFlag = true)
public class County {
    @Id
    private Long id;

    @Nationalized
    @Column(name = "name", length = Length.LONG32)
    private String name;

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof County country)) return false;
        return Objects.equals(id, country.id) && Objects.equals(name, country.name);
    }
}