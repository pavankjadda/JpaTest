package com.pj.jpatest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static io.restassured.RestAssured.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
@AutoConfigureMockMvc
@ActiveProfiles()
public class AuthorControllerTest {
    @BeforeAll
    void setup() {
        RestAssured.baseURI = "http://localhost:8081";
    }

    @Test
    void findAll_ShouldReturnAllAuthors() {
        given()
                .when().get("/api/v1/author/find/all")
                .then()
                .statusCode(200);
    }
}