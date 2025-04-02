package com.pj.jpatest.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

import java.util.Objects;

@Entity
@Table(name = "book_type")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Audited(withModifiedFlag = true)
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookType bookType)) return false;
        return Objects.equals(id, bookType.id) && Objects.equals(name, bookType.name);
    }
}