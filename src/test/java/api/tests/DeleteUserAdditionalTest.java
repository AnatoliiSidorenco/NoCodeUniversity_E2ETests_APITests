package api.tests;

import api.models.ResponseOnCreatedUserDto;
import api.utils.InValidRequestOnDeleteUserUtils;
import api.utils.ValidDataUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static api.utils.InValidRequestOnDeleteUserUtils.bodyWithConstEmail;
import static api.utils.ValidDataUtils.validEmail_API;
import static org.junit.Assert.assertEquals;

public class DeleteUserAdditionalTest {
    ValidDataUtils validDataUtils;
    InValidRequestOnDeleteUserUtils inValidRequestOnDeleteUserUtils;

    @Test
    public void twiceDeletedUserTest() {
        validDataUtils = new ValidDataUtils();
        Response responseOnUserPostRequest = validDataUtils.registerUser(200);
        ResponseOnCreatedUserDto responseOnCreatedUser = responseOnUserPostRequest.jsonPath().getObject("", ResponseOnCreatedUserDto.class);

        String actualEmail = responseOnCreatedUser.getEmail();

        validDataUtils.deleteUser(200, actualEmail);

        Response responseOnUserDeleteRequest = validDataUtils.deleteUser(404, actualEmail);

        String answerInFieldCode = responseOnUserDeleteRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Not Found", answerInFieldCode);

        String answerInFieldMessage = responseOnUserDeleteRequest.jsonPath().getString("message");
        assertEquals("wrong answer in field message", "User with email: " + actualEmail + " not found", answerInFieldMessage);
    }

    @Test
    public void deleteUserWithInvalidEmailTest() {
        inValidRequestOnDeleteUserUtils = new InValidRequestOnDeleteUserUtils();
        Response responseOnUserPostRequest =
                inValidRequestOnDeleteUserUtils.registerUserWithConstEmail(200, bodyWithConstEmail(validEmail_API));
        ResponseOnCreatedUserDto responseOnCreatedUser = responseOnUserPostRequest.jsonPath().getObject("", ResponseOnCreatedUserDto.class);

        String actualEmail = responseOnCreatedUser.getEmail();
        String inValidEmail = actualEmail + "u";
        System.out.println(inValidEmail);

        validDataUtils = new ValidDataUtils();
        Response responseOnDeletedUserWithInValidEndPoint =
                validDataUtils.deleteUser(404, inValidEmail);

        String answerInFieldCode = responseOnDeletedUserWithInValidEndPoint.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Not Found", answerInFieldCode);

        String answerInFieldMessage = responseOnDeletedUserWithInValidEndPoint.jsonPath().getString("message");
        assertEquals("wrong answer in field message", "User with email: " + inValidEmail + " not found", answerInFieldMessage);
    }
}
