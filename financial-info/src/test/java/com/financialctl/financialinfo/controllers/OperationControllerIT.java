package com.financialctl.financialinfo.controllers;

import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.finance.FinanceDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.operation.OperationRequestDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserRequestDTO;
import com.financialctl.financialinfo.utils.integration.BaseIT;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

class OperationControllerIT extends BaseIT {

    @Test
    @DisplayName("Should retrieve newly created operation when finance exists")
    void shouldRetrieveNewlyCreatedOperationWhenFinanceExists() {
        final UserRequestDTO postRequest = createUserRequest();
        final JsonPath postUserResponse = postUser(postRequest);

        final Long responseFinanceId = Long.parseLong(postUserResponse.get("finance_id").toString());

        final OperationRequestDTO operationRequest = createOperationRequest(responseFinanceId);

        final JsonPath newOperationJson = given()
                .contentType(ContentType.JSON).and().body(operationRequest)
                .when().post("/operations")
                .then().assertThat()
                .statusCode(201)
                .extract().response().jsonPath();

        final Object newOperationId = newOperationJson.get("id");

        final JsonPath response = given()
                .contentType(ContentType.JSON)
                .when().get("/operations/" + newOperationId)
                .then().assertThat()
                .statusCode(200)
                .extract().response().jsonPath();

        final Object id = response.get("id");
        final Object description = response.get("description");
        final Object finance = response.get("finance");
        final Object amount = response.get("amount");
        final Object date = response.get("date");

        assertThat(id).isEqualTo(newOperationId);
        assertThat(description).isEqualTo(newOperationJson.get("description"));
        assertThat(finance).isEqualTo(newOperationJson.get("finance"));
        assertThat(amount).isEqualTo(newOperationJson.get("amount"));
        assertThat(date).isEqualTo(newOperationJson.get("date"));
    }

    @Test
    @DisplayName("Should update an existing operation")
    void shouldUpdateAnExistingOperation() {
        final UserRequestDTO postRequest = createUserRequest();
        final JsonPath postUserResponse = postUser(postRequest);

        final Long responseFinanceId = Long.parseLong(postUserResponse.get("finance_id").toString());

        final OperationRequestDTO operationPostRequest = createOperationRequest(responseFinanceId);

        final JsonPath operationPostResponse = given()
                .contentType(ContentType.JSON).and().body(operationPostRequest)
                .when().post("/operations")
                .then().assertThat()
                .statusCode(201)
                .extract().response().jsonPath();

        final Object newOperationId = operationPostResponse.get("id");

        var operationUpdateRequest = operationPostRequest;
        operationUpdateRequest.setAmount(14.14);

        final JsonPath response = given()
                .contentType(ContentType.JSON).and().body(operationUpdateRequest)
                .when().put("/operations/" + newOperationId)
                .then().assertThat()
                .statusCode(200)
                .extract().response().jsonPath();

        final Object id = response.get("id");
        final Object description = response.get("description");
        final Object finance = response.get("finance");
        final Double amount = Double.parseDouble(response.get("amount").toString());
        final Object date = response.get("date");

        assertThat(id).isEqualTo(newOperationId);
        assertThat(description).isEqualTo(operationPostResponse.get("description"));
        assertThat(finance).isEqualTo(operationPostResponse.get("finance"));
        assertThat(amount).isEqualTo(operationUpdateRequest.getAmount());
        assertThat(date).isEqualTo(operationPostResponse.get("date"));
    }

    private OperationRequestDTO createOperationRequest(final Long financeId) {
        final OperationRequestDTO request = new OperationRequestDTO();
        final FinanceDTO financeDTO = new FinanceDTO(financeId);
        request.setOperationEntryType("TRANSPORTATION");
        request.setDescription("Some description");
        request.setFinance(financeDTO);
        request.setDate(getDefaultDate());
        request.setAmount(13.13);

        return request;
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

    private String getDefaultDate() {
        return "2022-10-13TAmerica/Sao_Paulo";
    }
}
