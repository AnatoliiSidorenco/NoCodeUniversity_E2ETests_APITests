package api.utils;

import api.ApiBase;
import api.models.CreateUserRequestDto;
import api.models.DeleteUserDto;
import io.restassured.response.Response;

import static api.utils.ValidDataUtils.*;

public class InValidDataUtils extends ApiBase {
    Response response;
    public static String inValidUserFullName_API = "J$9Э";
    public static String inValidUserEmail_API = "frgmail.com";
    public static String inValidUserPassword_API = "ιδιωτικός";


    public static CreateUserRequestDto bodyWithInValidFullName() {

        CreateUserRequestDto createUserDto = CreateUserRequestDto.builder()

                .full_name(inValidUserFullName_API)
                .email(validEmail_API)
                .password(generateRandomPassword())
                .generate_magic_link(false)
                .build();
        return createUserDto;
    }

    public static CreateUserRequestDto bodyWithInValidEmail() {

        CreateUserRequestDto createUserDto = CreateUserRequestDto.builder()

                .full_name(generateRandomName())
                .email(inValidUserEmail_API)
                .password(generateRandomPassword())
                .generate_magic_link(false)
                .build();
        return createUserDto;
    }

    public static CreateUserRequestDto bodyWithInValidPassword() {

        CreateUserRequestDto createUserDto = CreateUserRequestDto.builder()

                .full_name(generateRandomName())
                .email(validEmail_API)
                .password(inValidUserPassword_API)
                .generate_magic_link(false)
                .build();
        return createUserDto;
    }

    public static CreateUserRequestDto bodyWithInValidMagicLink() {

        CreateUserRequestDto createUserDto = CreateUserRequestDto.builder()

                .full_name(generateRandomName())
                .email(validEmail_API)
                .password(generateRandomPassword())
                .generate_magic_link(true)
                .build();
        return createUserDto;
    }

    public static DeleteUserDto inValidBody() {

        DeleteUserDto deleteUserDTO = DeleteUserDto.builder()
                .code("Not Found")
                .message("Try again")
                .instance(null)
                .status(null)
                .title(null)
                .type(null)
                .source(null)
                .build();
        return deleteUserDTO;
    }


    public Response registerUserWithInvalidData(Integer code, Object object) {
        response = postRequest(endpointPost, code, object);
        return response;
    }
}
