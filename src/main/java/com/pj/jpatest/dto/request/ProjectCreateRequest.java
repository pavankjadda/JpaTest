package com.pj.jpatest.dto.request;

public record ProjectCreateRequest(String name, String description, String location, String type) {
}