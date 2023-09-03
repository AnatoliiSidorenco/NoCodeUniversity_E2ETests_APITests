package api.tests;

import api.models.ResponseOnCreatedUserDto;
import api.utils.ValidDataUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SuccessDeletedUserTest {
    ValidDataUtils validDataUtils;

    @Test
    public void successDeletedUserTest() {
        validDataUtils = new ValidDataUtils();
        Response responseOnUserPostRequest = validDataUtils.registerUser(200);
        ResponseOnCreatedUserDto responseOnCreatedUser = responseOnUserPostRequest.jsonPath().getObject("", ResponseOnCreatedUserDto.class);
        String actualEmail = responseOnCreatedUser.getEmail();

        Response responseOnUserDeleteRequest = validDataUtils.deleteUser(200, actualEmail);
        assertTrue(responseOnUserDeleteRequest.getBody().asString().isEmpty());

    }
}

