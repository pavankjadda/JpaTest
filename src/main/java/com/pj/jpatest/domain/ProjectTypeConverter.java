package com.pj.jpatest.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProjectTypeConverter implements AttributeConverter<ProjectType, String> {
    @Override
    public String convertToDatabaseColumn(ProjectType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getName();
    }

    public ProjectType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        for (ProjectType type : ProjectType.values()) {
            if (type.getName().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown ProjectType: " + code);
    }

}