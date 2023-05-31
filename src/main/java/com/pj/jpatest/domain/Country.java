package com.pj.jpatest.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "country")
@Data
@Audited(withModifiedFlag = true)
public class Country {
    @Id
    private Long id;
    private String name;
}
