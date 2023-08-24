package api.utils;

import api.ApiBase;
import api.models.CreateUserRequestDto;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static api.utils.ValidDataUtils.*;

public class InValidRequestOnDeleteUserUtils extends ApiBase {
    Response response;

    public Response getRequestInsteadOfDelete(int expectedStatusCode, String endpoint) {
        Response response = RestAssured.given()
                .spec(specification)
                .when()
                .log().all()
                .get(endpoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    public Response putRequestInsteadOfDelete(int expectedStatusCode, String endpoint) {
        Response response = RestAssured.given()
                .spec(specification)
                .when()
                .log().all()
                .put(endpoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    public Response postRequestInsteadOfDelete(int expectedStatusCode, String endpoint) {
        Response response = RestAssured.given()
                .spec(specification)
                .when()
                .log().all()
                .post(endpoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    public static CreateUserRequestDto bodyWithConstEmail(String email) {

        CreateUserRequestDto createUserDto = CreateUserRequestDto.builder()

                .full_name(generateRandomName())
                .email(email)
                .password(generateRandomPassword())
                .generate_magic_link(false)
                .build();
        return createUserDto;
    }

    public Response registerUserWithConstEmail(Integer code, Object object) {
        response = postRequest(endpointPost, code, object);
        return response;
    }

    public static void deleteUserRequest(String email) {
        ValidDataUtils validDataUtils = new ValidDataUtils();
        validDataUtils.deleteUser(200, email);
    }
}
