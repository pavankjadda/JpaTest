package com.pj.jpatest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;

import java.time.LocalDate;

class JpaTestApplicationTests {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            var response = mapper.readValue("""
                    {
                      "dateApproved": "2023-09-12",
                      "dateEffective": "2023-09-12",
                      "dateExpiration": "2024-08-02",
                      "dateInitialEffective": "2017-11-22"
                    }                         
                                                """, ProtectProtocolResponse.class);
            System.out.println(response.dateApproved);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Data
    static class ProtectProtocolResponse {
        private LocalDate dateApproved;
        private LocalDate dateEffective;
        private LocalDate dateExpiration;
        private LocalDate dateInitialEffective;
    }
}

