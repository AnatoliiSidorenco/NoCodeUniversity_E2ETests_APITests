package api.tests;

import api.models.ResponseOnCreatedUserDto;
import api.utils.AdditionalDataCreateUtils;
import api.utils.ValidDataUtils;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;

import static api.utils.AdditionalDataCreateUtils.bodyWithSuccessCreatedUserData;
import static api.utils.InValidRequestOnDeleteUserUtils.deleteUserRequest;
import static org.junit.Assert.assertEquals;

public class CreatedTwiceUserTest {
    String actualEmail;
    ValidDataUtils validDataUtils;
    AdditionalDataCreateUtils additionalDataCreateUtils;

    @After
    public void setup() {
        deleteUserRequest(actualEmail);
    }

    @Test
    public void twiceCreatedUserTest() {
        validDataUtils = new ValidDataUtils();
        Response responseOnUserPostRequest = validDataUtils.registerUser(200);
        ResponseOnCreatedUserDto responseOnCreatedUser =
                responseOnUserPostRequest.jsonPath().getObject("", ResponseOnCreatedUserDto.class);

        String actualName = responseOnCreatedUser.getFull_name();
        actualEmail = responseOnCreatedUser.getEmail();

        additionalDataCreateUtils = new AdditionalDataCreateUtils();
        Response responseOnUserTwicePostRequest =
                additionalDataCreateUtils.registerUserWithExistedUserData(404, bodyWithSuccessCreatedUserData(actualName, actualEmail));

        String answerInFieldCode = responseOnUserTwicePostRequest.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "Bad Request", answerInFieldCode);


    }
}
