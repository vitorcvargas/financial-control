package com.financialctl.financialinfo.controllers;

import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserRequestDTO;
import com.financialctl.financialinfo.utils.integration.BaseIT;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

class UserControllerIT extends BaseIT {

    @Test
    @DisplayName("Should retrieve newly created user")
    void shouldRetrieveNewlyCreatedUser() {

        final UserRequestDTO postRequest = createUserRequest();
        final JsonPath postResponse = postUser(postRequest);

        final Object newUserId = postResponse.get("id");
        final Object newUserName = postResponse.get("name");
        final Object newUserFinaceId = postResponse.get("finance_id");

        final JsonPath response = given()
                .contentType(ContentType.JSON)
                .when().get("/users/" + newUserId)
                .then().assertThat()
                .statusCode(200)
                .extract().response().jsonPath();

        final Object id = response.get("id");
        final Object name = response.get("name");
        final Object email = response.get("email");
        final Object financeId = response.get("finance_id");

        assertThat(id).isEqualTo(newUserId);
        assertThat(name).isEqualTo(newUserName);
        assertThat(email).isEqualTo(postRequest.getEmail());
        assertThat(financeId).isEqualTo(newUserFinaceId);
    }

    @Test
    @DisplayName("Should update existing user")
    void shouldUpdateExistingUser() {

        final UserRequestDTO postRequest = createUserRequest();
        final JsonPath postResponse = postUser(postRequest);

        final Object newUserId = postResponse.get("id");
        final Object newUserName = postResponse.get("name");

        final UserRequestDTO putRequest = postRequest;
        putRequest.setName("Pedro");

        final JsonPath putResponse = given()
                .contentType(ContentType.JSON).and().body(putRequest)
                .when().put("/users/" + newUserId)
                .then().assertThat()
                .statusCode(200)
                .extract().response().jsonPath();

        final Object id = putResponse.get("id");
        final Object name = putResponse.get("name");
        final Object email = putResponse.get("email");

        assertThat(id).isEqualTo(newUserId);
        assertThat(name).isNotEqualTo(newUserName);
        assertThat(name).isEqualTo("Pedro");
        assertThat(email).isEqualTo(postRequest.getEmail());
    }

    @Test
    @DisplayName("Should delete existing user")
    void shouldDeleteExistingUser() {

        final UserRequestDTO postRequest = createUserRequest();
        final JsonPath postResponse = postUser(postRequest);

        final Object newUserId = postResponse.get("id");

        given()
                .contentType(ContentType.JSON)
                .when().delete("/users/" + newUserId)
                .then().assertThat()
                .statusCode(200);

        given()
                .contentType(ContentType.JSON)
                .when().get("/users/" + newUserId)
                .then().assertThat()
                .statusCode(404);
    }

    private JsonPath postUser(final UserRequestDTO postRequest) {
        return given()
                .contentType(ContentType.JSON).and().body(postRequest)
                .when().post("/users")
                .then().assertThat()
                .statusCode(201)
                .extract().response().jsonPath();
    }

    private UserRequestDTO createUserRequest() {
        final UserRequestDTO request = new UserRequestDTO();
        request.setEmail(generateRandomEmail());
        request.setName("Vitor");

        return request;
    }

    private String generateRandomEmail() {
        final UUID uuid = UUID.randomUUID();

        return String.format("vitor%s@gmail.com", uuid);
    }
}
