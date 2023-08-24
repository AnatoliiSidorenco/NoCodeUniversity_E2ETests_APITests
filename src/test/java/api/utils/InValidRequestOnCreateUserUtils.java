package api.utils;

import api.ApiBase;
import io.restassured.response.Response;

import static api.utils.ValidDataUtils.endpointPost;
import static io.restassured.RestAssured.given;

public class InValidRequestOnCreateUserUtils extends ApiBase {

    public Response postRequestWithoutBody(int expectedStatusCode) {

        Response response = given()
                .spec(specification)
                .when()
                .log().all()
                .post(endpointPost)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    public Response getRequestInsteadOfPost(int expectedStatusCode, Object body) {
        Response response = given()
                .spec(specification)
                .body(body)
                .when()
                .log().all()
                .get(endpointPost)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    public Response putRequestInsteadOfPost(int expectedStatusCode, Object body) {
        Response response = given()
                .spec(specification)
                .body(body)
                .when()
                .log().all()
                .put(endpointPost)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    public Response deleteRequestInsteadOfPost(int expectedStatusCode, Object body) {
        Response response = given()
                .spec(specification)
                .body(body)
                .when()
                .log().all()
                .delete(endpointPost)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }
}
