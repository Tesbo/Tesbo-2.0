package api.test;

import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.framework.init.base;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Admin_Auth extends base {

   @Test
    public void verify_get_response() {
        RequestBuilder builder = new RequestBuilder();

        JSONObject response = builder.performRequest("admin_auth/login");

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(201);

        String token =  validator.getDataFromBody("$.token");

       System.out.println(token);

    }
}
