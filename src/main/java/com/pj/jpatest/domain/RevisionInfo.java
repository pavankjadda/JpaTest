package com.pj.jpatest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Changelog;

@Entity
@Table(name = "REVINFO")
@Getter
@Setter
@NoArgsConstructor
@Changelog
public class RevisionInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Changelog.ChangesetId
    @Column(name = "REV")
    private Integer id;

    @Changelog.Timestamp
    @Column(name = "REVTSTMP")
    private Long timestamp;
}
