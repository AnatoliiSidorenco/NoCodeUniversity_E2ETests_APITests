package api.tests;

import api.utils.InValidRequestOnCreateUserUtils;
import api.utils.ValidDataUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateUserWithInValidRequestTest {
    InValidRequestOnCreateUserUtils inValidRequestOnCreateUser;
    ValidDataUtils validDataUtils;

    @Test
    public void registerUserWithoutBodyTest() {
        inValidRequestOnCreateUser = new InValidRequestOnCreateUserUtils();
        Response responseOnUserPostRequest = inValidRequestOnCreateUser.postRequestWithoutBody(400);
        String answerInFieldCode = responseOnUserPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);
    }

    @Test
    public void registerUserWithGetRequestTest() {
        inValidRequestOnCreateUser = new InValidRequestOnCreateUserUtils();
        validDataUtils = new ValidDataUtils();
        Response responseOnUserGetRequest =
                inValidRequestOnCreateUser.getRequestInsteadOfPost(405, validDataUtils.randomDataBodyForRegisterUser());
        String answerInFieldCode = responseOnUserGetRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Method Not Allowed", answerInFieldCode);
    }

    @Test
    public void registerUserWithPutRequestTest() {
        inValidRequestOnCreateUser = new InValidRequestOnCreateUserUtils();
        validDataUtils = new ValidDataUtils();
        Response responseOnUserGetRequest =
                inValidRequestOnCreateUser.putRequestInsteadOfPost(405, validDataUtils.randomDataBodyForRegisterUser());
        String answerInFieldCode = responseOnUserGetRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Method Not Allowed", answerInFieldCode);
    }

    @Test
    public void registerUserWithDeleteRequestTest() {
        inValidRequestOnCreateUser = new InValidRequestOnCreateUserUtils();
        validDataUtils = new ValidDataUtils();
        Response responseOnUserGetRequest =
                inValidRequestOnCreateUser.deleteRequestInsteadOfPost(405, validDataUtils.randomDataBodyForRegisterUser());
        String answerInFieldCode = responseOnUserGetRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Method Not Allowed", answerInFieldCode);
    }
}
