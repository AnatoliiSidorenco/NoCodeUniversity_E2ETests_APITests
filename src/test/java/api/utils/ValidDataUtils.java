package api.utils;

import api.ApiBase;
import api.models.CreateUserRequestDto;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class ValidDataUtils extends ApiBase {
    Response response;
    public String userFullName;
    public String userEmail;
    public String userPassword;
    public static String endpointPost = "/users";
    public static String endpointDelete = "users/";
    public static String validEmail_API = "jimcarrey@gmail.com";

    public static String generateRandomName() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public static String generateRandomEmail() {
        String SALTCHARS = "abcdefghigk1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 9) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@gmail.com";
    }

    public static String generateRandomPassword() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 9) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public CreateUserRequestDto randomDataBodyForRegisterUser() {
        userFullName = generateRandomName();
        userEmail = generateRandomEmail();
        userPassword = generateRandomPassword();

        CreateUserRequestDto createUserDto = CreateUserRequestDto.builder()
                .email(userEmail)
                .full_name(userFullName)
                .password(userPassword)
                .generate_magic_link(false)
                .build();

        return createUserDto;
    }

    public Response registerUser(Integer code) {
        response = postRequest(endpointPost, code, randomDataBodyForRegisterUser());
        return response;
    }

    public Response deleteUser(Integer code, String email) {
        String endpoint = endpointDelete + email;
        response = deleteRequest(endpoint, code);
        return response;
    }

}
