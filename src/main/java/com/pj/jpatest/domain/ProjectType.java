package com.pj.jpatest.domain;

import lombok.Getter;

@Getter
public enum ProjectType {
    Internal("Internal"),
    External("External");

    private final String name;

    ProjectType(String name) {
        this.name = name;
    }

    public static ProjectType fromString(String type) {
        for (var pt : ProjectType.values()) {
            if (pt.getName().equalsIgnoreCase(type)) {
                return pt;
            }
        }
        throw new IllegalArgumentException("Invalid ProjectType: " + type);
    }
}