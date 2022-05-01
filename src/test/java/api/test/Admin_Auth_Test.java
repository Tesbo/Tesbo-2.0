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
        Map headers = new HashMap();
        headers.put("Content-Type", "application/json");

        Map body = new HashMap();
        body.put("email", "vir@qable.io");
        body.put("password", "Admin@admin123");

        JSONObject response = builder.performRequestWithHeaderAndBody("admin_auth/admin_auth", headers, body);
        System.out.println(response);
        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(404);
    }
}
