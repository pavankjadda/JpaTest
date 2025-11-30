package com.pj.jpatest.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.pj.jpatest.domain.Book}
 */
public record BookDto(Long id, String isbn, Integer edition, Integer yearOfPublication, String publisher) implements Serializable {
}