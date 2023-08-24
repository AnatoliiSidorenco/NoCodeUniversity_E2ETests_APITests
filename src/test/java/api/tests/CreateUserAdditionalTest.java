package api.tests;

import api.utils.AdditionalDataCreateUtils;
import api.utils.ValidDataUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateUserAdditionalTest {

    ValidDataUtils validDataUtils;
    AdditionalDataCreateUtils additionalDataCreateUtils;


    @Test
    public void registerUserWithInvalidApiKeyTest() {
        additionalDataCreateUtils = new AdditionalDataCreateUtils();
        validDataUtils = new ValidDataUtils();
        Response responseOnInvalidApiKey =
                additionalDataCreateUtils.postRequestWithInvalidApiKey(401, validDataUtils.randomDataBodyForRegisterUser());
        String answerInFieldCode = responseOnInvalidApiKey.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "UNAUTHORIZED", answerInFieldCode);
    }

    @Test
    public void registerUserWithInvalidDomainTest() {
        additionalDataCreateUtils = new AdditionalDataCreateUtils();
        validDataUtils = new ValidDataUtils();
        Response responseOnInvalidDomain =
                additionalDataCreateUtils.postRequestWithInvalidDomain(401, validDataUtils.randomDataBodyForRegisterUser());
        String answerInFieldCode = responseOnInvalidDomain.jsonPath().getString("code");
        assertEquals("wrong answer in field code", "UNAUTHORIZED", answerInFieldCode);
    }
}
