package api.test;

import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Admin_Auth extends base {

    @Test
    public void verify_get_response() {
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParamter = new JSONObject();
        JSONObject header = new JSONObject();
        JSONObject body = new JSONObject();

        pathParamter.put("mahesh", "1300");
        pathParamter.put("test", "1500");

        body.put("Kamlesh","ramesh");

        String abc = builder.updateRequestObject("admin_auth/admin_auth", pathParamter, header, body);

        JSONObject response = builder.performRequest(abc);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(201);

        String token = validator.getDataFromBody("$.token");

        System.out.println(token);

    }
}
