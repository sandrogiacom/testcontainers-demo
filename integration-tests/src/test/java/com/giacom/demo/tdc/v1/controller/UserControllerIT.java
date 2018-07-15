package com.giacom.demo.tdc.v1.controller;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.giacom.demo.tdc.config.TestConfigurations;
import com.giacom.demo.tdc.v1.dto.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = TestConfigurations.class)
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:before_sample_user.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:after_sample_user.sql")
})

//mvn verify -Pintegration-test -DdbVendor=oracle

public class UserControllerIT {

    private static String USERS_RESOURCE;

    @LocalServerPort
    private int randomPort;

    @Before
    public void setUp() {
        port = randomPort;
        USERS_RESOURCE = baseURI + ":" + port + "/api/v1/users";
    }

    @Test
    public void whenRequestGetThenOK() {
        when()
                .get(USERS_RESOURCE)
                .then()
                .statusCode(equalTo(HttpStatus.OK.value()));
    }

    @Test
    public void whenRequestOneUserById() {

        when()
                .get(USERS_RESOURCE.concat("/{id}"), "5b19af1580395b8a662caf3d")
                .then()
                .statusCode(equalTo(HttpStatus.OK.value()))
                .and()
                .body("id", equalTo("5b19af1580395b8a662caf3d"))
                .body("name", equalTo("Lourdes"))
                .body("lastName", equalTo("Blanchard"))
                .body("age", equalTo(12));
    }

    @Test
    public void whenCreateUserThenReturnNewUser() {
        UserDTO userDTO = UserDtoBuilder
                .create()
                .withName("Jose")
                .withLastName("Junior")
                .withAge(39).build();

        given()
                .header("Content-Type", "application/json")
                .body(userDTO)
                .when()
                .post(USERS_RESOURCE)
                .then()
                .statusCode(equalTo(HttpStatus.CREATED.value()))
                .and()
                .body("id", Matchers.is(notNullValue()))
                .body("name", equalTo("Jose"))
                .body("lastName", equalTo("Junior"))
                .body("age", equalTo(39));
    }


    @Test
    public void whenRequestOneByIdNotFound() {
        when()
                .get(USERS_RESOURCE.concat("/{id}"), "111")
                .then()
                .statusCode(equalTo(HttpStatus.NOT_FOUND.value()));
    }

    @Test
    public void whenUpdateUserThenReturnModifiedUser() {
        UserDTO userDTO = UserDtoBuilder
                .create().withId("5b19b0359b1367bbf61fb1d5")
                .withName("Dorsey Jr")
                .withLastName("Hendrix 1")
                .withAge(30)
                .build();
        given()
                .header("Content-Type", "application/json")
                .body(userDTO)
                .when()
                .put(USERS_RESOURCE.concat("/{id}"), userDTO.getId())
                .then()
                .statusCode(equalTo(HttpStatus.OK.value()))
                .and()
                .body("id", equalTo("5b19b0359b1367bbf61fb1d5"))
                .body("name", equalTo("Dorsey Jr"))
                .body("lastName", equalTo("Hendrix 1"))
                .body("age", equalTo(30));
    }

}