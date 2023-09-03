package api.tests;

import api.models.ResponseOnCreatedUserDto;
import api.utils.ValidDataUtils;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;

import static api.utils.InValidRequestOnDeleteUserUtils.deleteUserRequest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SuccessCreatedUserTest {
    String actualEmailSuccessCreatedUser;
    ValidDataUtils validDataUtils;

    @After
    public void setup() {
        deleteUserRequest(actualEmailSuccessCreatedUser);
    }

    @Test
    public void successCreatedUserTest() {
        validDataUtils = new ValidDataUtils();
        Response responseOnUserPostRequest = validDataUtils.registerUser(200);
        ResponseOnCreatedUserDto responseOnCreatedUser = responseOnUserPostRequest.jsonPath().getObject("", ResponseOnCreatedUserDto.class);

        actualEmailSuccessCreatedUser = responseOnCreatedUser.getEmail();
        String expectedEmail = validDataUtils.userEmail;
        assertEquals("False, they are different", actualEmailSuccessCreatedUser, expectedEmail);

        String actualName = responseOnCreatedUser.getFull_name();
        String expectedName = validDataUtils.userFullName;
        assertEquals("False, they are different", actualName, expectedName);

        assertNull("False, magic_link", responseOnCreatedUser.getMagic_link());
    }
}


