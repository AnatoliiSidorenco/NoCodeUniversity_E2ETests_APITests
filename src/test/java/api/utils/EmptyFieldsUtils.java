package api.utils;

import api.ApiBase;
import api.models.CreateUserRequestDto;
import io.restassured.response.Response;

import static api.utils.ValidDataUtils.*;

public class EmptyFieldsUtils extends ApiBase {
    Response response;

    public static CreateUserRequestDto bodyWithEmptyFullName() {

        CreateUserRequestDto createUserDto = CreateUserRequestDto.builder()

                .full_name(" ")
                .email(validEmail_API)
                .password(generateRandomPassword())
                .generate_magic_link(false)
                .build();
        return createUserDto;
    }

    public static CreateUserRequestDto bodyWithEmptyEmail() {

        CreateUserRequestDto createUserDto = CreateUserRequestDto.builder()

                .full_name(generateRandomName())
                .email(" ")
                .password(generateRandomPassword())
                .generate_magic_link(false)
                .build();
        return createUserDto;
    }

    public static CreateUserRequestDto bodyWithEmptyPassword() {

        CreateUserRequestDto createUserDto = CreateUserRequestDto.builder()

                .full_name(generateRandomName())
                .email(validEmail_API)
                .password(" ")
                .generate_magic_link(false)
                .build();
        return createUserDto;
    }

    public Response registerUserWithEmptyFields(Integer code, Object object) {
        response = postRequest(endpointPost, code, object);
        return response;
    }
}

