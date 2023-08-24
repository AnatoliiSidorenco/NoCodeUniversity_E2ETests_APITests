package api.tests;

import api.utils.EmptyFieldsUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static api.utils.EmptyFieldsUtils.*;
import static api.utils.InValidRequestOnDeleteUserUtils.deleteUserRequest;
import static api.utils.ValidDataUtils.validEmail_API;
import static org.junit.Assert.assertEquals;

public class CreateUserWithEmptyFieldsTest {
    EmptyFieldsUtils emptyFieldsUtils;

    @Test
    public void cleanUp() {
        deleteUserRequest(validEmail_API);
    }

    @Test
    public void registerUserWithEmptyFullNameTest() {
        emptyFieldsUtils = new EmptyFieldsUtils();
        Response responseOnUserPostRequest = emptyFieldsUtils.registerUserWithEmptyFields(400, bodyWithEmptyFullName());
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);
    }

    @Test
    public void registerUserWithEmptyEmailTest() {
        emptyFieldsUtils = new EmptyFieldsUtils();
        Response responseOnUserPostRequest = emptyFieldsUtils.registerUserWithEmptyFields(400, bodyWithEmptyEmail());
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);
    }

    @Test
    public void registerUserWithEmptyPasswordTest() {
        emptyFieldsUtils = new EmptyFieldsUtils();
        Response responseOnUserPostRequest = emptyFieldsUtils.registerUserWithEmptyFields(400, bodyWithEmptyPassword());
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);
    }
}
