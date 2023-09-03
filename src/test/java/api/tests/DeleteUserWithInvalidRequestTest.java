package api.tests;

import api.models.ResponseOnCreatedUserDto;
import api.utils.InValidRequestOnDeleteUserUtils;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;

import static api.utils.InValidRequestOnDeleteUserUtils.bodyWithConstEmail;
import static api.utils.InValidRequestOnDeleteUserUtils.deleteUserRequest;
import static api.utils.ValidDataUtils.endpointDelete;
import static api.utils.ValidDataUtils.validEmail_API;
import static org.junit.Assert.assertEquals;

public class DeleteUserWithInvalidRequestTest {
    InValidRequestOnDeleteUserUtils inValidRequestOnDeleteUserUtils;

    @After
    public void setup() {
        deleteUserRequest(validEmail_API);
    }

    @Test
    public void deleteUserWithGetRequestTest() {
        inValidRequestOnDeleteUserUtils = new InValidRequestOnDeleteUserUtils();
        Response responseOnUserPostRequest =
                inValidRequestOnDeleteUserUtils.registerUserWithConstEmail(200, bodyWithConstEmail(validEmail_API));
        ResponseOnCreatedUserDto responseOnCreatedUser = responseOnUserPostRequest.jsonPath().getObject("", ResponseOnCreatedUserDto.class);

        String actualEmail = responseOnCreatedUser.getEmail();
        String endpoint = endpointDelete + actualEmail;

        Response responseOnDeletedUserWithGetRequest =
                inValidRequestOnDeleteUserUtils.getRequestInsteadOfDelete(405, endpoint);

        String answerInFieldCode = responseOnDeletedUserWithGetRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Method Not Allowed", answerInFieldCode);
    }

    @Test
    public void deleteUserWithPutRequestTest() {
        inValidRequestOnDeleteUserUtils = new InValidRequestOnDeleteUserUtils();
        Response responseOnUserPostRequest =
                inValidRequestOnDeleteUserUtils.registerUserWithConstEmail(200, bodyWithConstEmail(validEmail_API));
        ResponseOnCreatedUserDto responseOnCreatedUser = responseOnUserPostRequest.jsonPath().getObject("", ResponseOnCreatedUserDto.class);

        String actualEmail = responseOnCreatedUser.getEmail();
        String endpoint = endpointDelete + actualEmail;

        inValidRequestOnDeleteUserUtils = new InValidRequestOnDeleteUserUtils();
        Response responseOnDeletedUserWithPutRequest =
                inValidRequestOnDeleteUserUtils.putRequestInsteadOfDelete(405, endpoint);

        String answerInFieldCode = responseOnDeletedUserWithPutRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Method Not Allowed", answerInFieldCode);
    }

    @Test
    public void deleteUserWithPostRequestTest() {
        inValidRequestOnDeleteUserUtils = new InValidRequestOnDeleteUserUtils();
        Response responseOnUserPostRequest =
                inValidRequestOnDeleteUserUtils.registerUserWithConstEmail(200, bodyWithConstEmail(validEmail_API));
        ResponseOnCreatedUserDto responseOnCreatedUser = responseOnUserPostRequest.jsonPath().getObject("", ResponseOnCreatedUserDto.class);


        String actualEmail = responseOnCreatedUser.getEmail();
        String endpoint = endpointDelete + actualEmail;

        inValidRequestOnDeleteUserUtils = new InValidRequestOnDeleteUserUtils();
        Response responseOnDeletedUserWithPostRequest =
                inValidRequestOnDeleteUserUtils.putRequestInsteadOfDelete(405, endpoint);

        String answerInFieldCode = responseOnDeletedUserWithPostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Method Not Allowed", answerInFieldCode);
    }
}
