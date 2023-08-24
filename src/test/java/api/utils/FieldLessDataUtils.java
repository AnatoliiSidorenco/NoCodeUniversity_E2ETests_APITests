package api.utils;

import api.ApiBase;
import api.models.CreateUserRequestDto;
import io.restassured.response.Response;

import static api.utils.ValidDataUtils.*;

public class FieldLessDataUtils extends ApiBase {
    Response response;

    public static CreateUserRequestDto bodyWithoutFieldFullName() {

        CreateUserRequestDto invalidRequestBody = CreateUserRequestDto.builder()
                .email(validEmail_API)
                .password(generateRandomPassword())
                .generate_magic_link(false)
                .build();
        return invalidRequestBody;
    }

    public static CreateUserRequestDto bodyWithoutFieldEmail() {

        CreateUserRequestDto invalidRequestBody = CreateUserRequestDto.builder()
                .full_name(generateRandomName())
                .password(generateRandomPassword())
                .generate_magic_link(false)
                .build();
        return invalidRequestBody;
    }

    public static CreateUserRequestDto bodyWithoutFieldPassword() {

        CreateUserRequestDto invalidRequestBody = CreateUserRequestDto.builder()
                .full_name(generateRandomName())
                .email(validEmail_API)
                .generate_magic_link(false)
                .build();
        return invalidRequestBody;
    }

    public static CreateUserRequestDto bodyWithoutFieldMagicLink() {

        CreateUserRequestDto invalidRequestBody = CreateUserRequestDto.builder()
                .full_name(generateRandomName())
                .email(validEmail_API)
                .password(generateRandomPassword())
                .build();
        return invalidRequestBody;
    }

    public static CreateUserRequestDto bodyWithoutFields() {

        CreateUserRequestDto invalidRequestBody = CreateUserRequestDto.builder()
                .build();
        return invalidRequestBody;
    }


    public Response registerUserWithoutFields(Integer code, CreateUserRequestDto createUserDto) {
        response = postRequest(endpointPost, code, createUserDto);
        return response;
    }
}
