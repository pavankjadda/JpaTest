package com.pj.jpatest.dto.request;

public record CreateSportRequest(String name, Integer players, Integer ageGroup, String description) {
}