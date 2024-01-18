package com.pj.jpatest.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@Audited(withModifiedFlag = true)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private Integer edition;
    private Integer yearOfPublication;
    private String publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_type_id")
    private BookType bookType;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @JsonManagedReference
    private List<Author> authors = new ArrayList<>();
}
