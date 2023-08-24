package api.tests;

import api.utils.FieldLessDataUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static api.utils.FieldLessDataUtils.*;
import static api.utils.InValidRequestOnDeleteUserUtils.deleteUserRequest;
import static api.utils.ValidDataUtils.validEmail_API;
import static org.junit.Assert.assertEquals;

public class CreateUserFieldLessTest {
    FieldLessDataUtils fieldLessDataUtils;

    @Test
    public void cleanUp() {
        deleteUserRequest(validEmail_API);
    }

    @Test
    public void registerUserWithoutFieldFullNameTest() {
        fieldLessDataUtils = new FieldLessDataUtils();
        Response responseOnUserPostRequest = fieldLessDataUtils.registerUserWithoutFields(400, bodyWithoutFieldFullName());
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);
    }

    @Test
    public void registerUserWithoutFieldEmaiTestl() {
        fieldLessDataUtils = new FieldLessDataUtils();
        Response responseOnUserPostRequest = fieldLessDataUtils.registerUserWithoutFields(400, bodyWithoutFieldEmail());
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);
    }

    @Test
    public void registerUserWithoutFieldPasswordTest() {
        fieldLessDataUtils = new FieldLessDataUtils();
        Response responseOnUserPostRequest = fieldLessDataUtils.registerUserWithoutFields(400, bodyWithoutFieldPassword());
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);

    }

    @Test
    public void registerUserWithoutFieldMagicLinkTest() {
        fieldLessDataUtils = new FieldLessDataUtils();
        Response responseOnUserPostRequest = fieldLessDataUtils.registerUserWithoutFields(400, bodyWithoutFieldMagicLink());
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);
    }

    @Test
    public void registerUserWithoutFieldsTest() {
        fieldLessDataUtils = new FieldLessDataUtils();
        Response responseOnUserPostRequest = fieldLessDataUtils.registerUserWithoutFields(400, bodyWithoutFields());
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);
    }
}
