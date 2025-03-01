package com.pj.jpatest.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "book_log")
@Data
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
}