package com.pj.jpatest.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "book_log")
@Getter
@Setter
@ToString
public class BookLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "message", columnDefinition = "varchar(255)")
    private String message;
    private Instant createdDate;
    private String createdBy;

    public BookLog() {
        // Default constructor
    }

    public BookLog(String message, Instant createdDate, String createdBy) {
        this.message = message;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, createdDate, createdBy);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookLog bookLog)) return false;
        return Objects.equals(id, bookLog.id) && Objects.equals(message, bookLog.message) &&
                Objects.equals(createdDate, bookLog.createdDate) && Objects.equals(createdBy, bookLog.createdBy);
    }
}