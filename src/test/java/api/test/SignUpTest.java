package api.test;

import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class SignUpTest extends base
{

    @Test
    public void verify_with_valid_credentials() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("signup/signup_with_valid_credentials");

        ResponseValidator validator = new ResponseValidator(response);

        String message1 = validator.getDataFromBody("$.message");
        assertThat(message1).isEqualTo("OTP has been sent successfully");

        String payload = validator.getDataFromBody("$.payload.canResendUserVerificationCode");
        assertThat(payload).isNotBlank();

        ResponseValidator signup = new ResponseValidator(response);
        signup.statusCodeShouldBe(201);

    }

    @Test
    public void verify_with_blank_password() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("signup/signup_with_blank_password");

        ResponseValidator validator = new ResponseValidator(response);

        String message1 = validator.getDataFromBody("$.messages");
        assertThat(message1).isEqualTo("[\"Password must contain at least one upper case, lowercase and a number\",\"password must be longer than or equal to 8 characters\"]");

        ResponseValidator signup = new ResponseValidator(response);
        signup.statusCodeShouldBe(400);
    }

    @Test
    public void verify_with_invalid_password() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("signup/signup_with_invalid_password");

        ResponseValidator validator = new ResponseValidator(response);

        String message1 = validator.getDataFromBody("$.messages");
        assertThat(message1).isEqualTo("[\"Password must contain at least one upper case, lowercase and a number\",\"password must be longer than or equal to 8 characters\"]");

        ResponseValidator signup = new ResponseValidator(response);
        signup.statusCodeShouldBe(400);
    }

    @Test
    public void verify_with_invalid_email() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("signup/signup_with_invalid_email");

        ResponseValidator validator = new ResponseValidator(response);

        String message1 = validator.getDataFromBody("$.messages");
        assertThat(message1).isEqualTo("[\"email must be an email\"]");

        ResponseValidator signup = new ResponseValidator(response);
        signup.statusCodeShouldBe(400);
    }

    @Test
    public void verify_with_blank_email() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("signup/signup_with_blank_email");

        ResponseValidator validator = new ResponseValidator(response);

        String message1 = validator.getDataFromBody("$.messages");
        assertThat(message1).isEqualTo("[\"email must be an email\"]");

        ResponseValidator signup = new ResponseValidator(response);
        signup.statusCodeShouldBe(400);
    }

    @Test
    public void verify_with_blank_timezone() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("signup/signup_with_blank_timezone");

        ResponseValidator validator = new ResponseValidator(response);

        String message1 = validator.getDataFromBody("$.messages");
        assertThat(message1).isEqualTo("[\" is invalid timezone\",\"timeZone should not be empty\"]");

        ResponseValidator signup = new ResponseValidator(response);
        signup.statusCodeShouldBe(400);
    }

    @Test
    public void verify_with_same_credentials() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("signup/signup_with_same_credentials");

        ResponseValidator validator = new ResponseValidator(response);

        String message1 = validator.getDataFromBody("$.message");
        assertThat(message1).isEqualTo("User already exists");

        ResponseValidator signup = new ResponseValidator(response);
        signup.statusCodeShouldBe(400);
    }


}
