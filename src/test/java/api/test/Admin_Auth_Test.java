package api.test;

import io.unity.framework.API.RequestBuilder;
import io.unity.framework.API.ResponseValidator;
import io.unity.framework.init.base;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Admin_Auth_Test extends base {

    @Test
    public void verify_get_response() {
        RequestBuilder builder = new RequestBuilder();

        JSONObject response = builder.performRequest("admin_auth/admin_auth");

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(201);

        String token =  validator.getDataFromBody("$.session.accessToken");



    }
}
