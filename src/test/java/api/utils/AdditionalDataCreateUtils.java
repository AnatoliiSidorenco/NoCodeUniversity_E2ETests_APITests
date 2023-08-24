package api.utils;

import api.ApiBase;
import api.models.CreateUserRequestDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.utils.ValidDataUtils.endpointPost;
import static api.utils.ValidDataUtils.generateRandomPassword;
import static io.restassured.RestAssured.given;

public class AdditionalDataCreateUtils extends ApiBase {
    Response response;
    String validBaseUri = "https://studio-api.softr.io/v1/api";
    String validApiKey = "khIbAyJIU5CIuh1oDuBRx1s49";
    String validDomain = "jere237.softr.app";
    String invalidApiKey = "khIbAyJIU5CIuh1oDuBRx1s50";
    String invalidDomain = "jere245.softr.app";


    public static CreateUserRequestDto bodyWithSuccessCreatedUserData(String fullName, String email) {

        CreateUserRequestDto createUserDto = CreateUserRequestDto.builder()

                .full_name(fullName)
                .email(email)
                .password(generateRandomPassword())
                .generate_magic_link(false)
                .build();
        return createUserDto;
    }

    public Response registerUserWithExistedUserData(Integer code, Object object) {
        response = postRequest(endpointPost, code, object);
        return response;
    }

    public Response postRequestWithInvalidApiKey(int expectedStatusCode, Object body) {
        Response response = given()
                .baseUri(validBaseUri)
                .contentType(ContentType.JSON)
                .header("Softr-Api-Key", invalidApiKey)
                .header("Softr-Domain", validDomain)
                .body(body)
                .when()
                .log().all()
                .post(endpointPost)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    public Response postRequestWithInvalidDomain(int expectedStatusCode, Object body) {
        Response response = given()
                .baseUri(validBaseUri)
                .contentType(ContentType.JSON)
                .header("Softr-Api-Key", validApiKey)
                .header("Softr-Domain", invalidDomain)
                .body(body)
                .when()
                .log().all()
                .post(endpointPost)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }
}
