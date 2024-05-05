package com.pj.jpatest.dto;

/**
 * Projection for {@link com.pj.jpatest.domain.Book}
 */
public interface BookInfo {
    Long getId();

    String getTitle();

    String getIsbn();

    Integer getEdition();

    Integer getYearOfPublication();

    String getPublisher();
}
