package api.tests;

import api.utils.InValidDataUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static api.utils.InValidDataUtils.*;
import static api.utils.InValidRequestOnDeleteUserUtils.deleteUserRequest;
import static api.utils.ValidDataUtils.validEmail_API;
import static org.junit.Assert.assertEquals;


public class CreateUserWithInvalidDataTest {

    InValidDataUtils inValidDataUtils;

    @Test
    public void cleanUp() {
        deleteUserRequest(validEmail_API);
    }

    @Test
    public void cleanUpAfterEmail() {
        deleteUserRequest(inValidUserEmail_API);
    }

    @Test
    public void registerUserWithInvalidFullNameTest() {
        inValidDataUtils = new InValidDataUtils();
        Response responseOnUserPostRequest = inValidDataUtils.registerUserWithInvalidData(400, bodyWithInValidFullName());
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);
    }

    @Test
    public void registerUserWithInvalidEmailTest() {
        inValidDataUtils = new InValidDataUtils();
        Response responseOnUserPostRequest = inValidDataUtils.registerUserWithInvalidData(400, bodyWithInValidEmail());
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);
    }

    @Test
    public void registerUserWithInvalidPasswordTest() {
        inValidDataUtils = new InValidDataUtils();
        Response responseOnUserPostRequest = inValidDataUtils.registerUserWithInvalidData(400, bodyWithInValidPassword());
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);
    }

    @Test
    public void registerUserWithInvalidMagicLinkTest() {
        inValidDataUtils = new InValidDataUtils();
        Response responseOnUserPostRequest = inValidDataUtils.registerUserWithInvalidData(400, bodyWithInValidMagicLink());
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);
    }

    @Test
    public void registerUserWithInvalidBodyTest() {
        inValidDataUtils = new InValidDataUtils();
        Response responseOnUserPostRequest = inValidDataUtils.registerUserWithInvalidData(400, inValidBody());
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);
    }
}
