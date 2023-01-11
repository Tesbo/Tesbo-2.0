package api.test;

import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends base {

    @Test
    public void verify_with_login_valid_credentials() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_valid_credentials");

        ResponseValidator validator = new ResponseValidator(response);

        String message1 = validator.getDataFromBody("$.message");
        assertThat(message1).isEqualTo("Logged in successfully");

        String accestoken = validator.getDataFromBody("$.payload.accessToken");
        assertThat(accestoken).isNotBlank();

        String email = validator.getDataFromBody("payload.email");
        assertThat(email).isEqualTo("vir@qable.io");

        ResponseValidator signup = new ResponseValidator(response);
        signup.statusCodeShouldBe(201);
    }

    @Test
    public void verify_with_login_invalid_email() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_invalid_email");

        ResponseValidator validator = new ResponseValidator(response);

        String message1 = validator.getDataFromBody("$.messages");
        assertThat(message1).isEqualTo("[\"email must be an email\"]");

        ResponseValidator signup = new ResponseValidator(response);
        signup.statusCodeShouldBe(400);
    }

    @Test
    public void verify_with_login_blank_email() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_blank_email");

        ResponseValidator validator = new ResponseValidator(response);

        String message1 = validator.getDataFromBody("$.messages");
        assertThat(message1).isEqualTo("[\"email must be an email\"]");

        ResponseValidator signup = new ResponseValidator(response);
        signup.statusCodeShouldBe(400);
    }

    @Test
    public void verify_with_login_invalid_password() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_invalid_password");

        ResponseValidator validator = new ResponseValidator(response);

        String message1 = validator.getDataFromBody("$.message");
        assertThat(message1).isEqualTo("Invalid username or password");

        ResponseValidator signup = new ResponseValidator(response);
        signup.statusCodeShouldBe(400);
    }

    @Test
    public void verify_with_login_blank_password() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_blank_password");

        ResponseValidator validator = new ResponseValidator(response);

        String message1 = validator.getDataFromBody("$.messages");
        assertThat(message1).isEqualTo("[\"password should not be empty\"]");

        ResponseValidator signup = new ResponseValidator(response);
        signup.statusCodeShouldBe(400);

    }

}
