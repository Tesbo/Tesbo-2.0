package api.requests.common.SignUpUtility;

import io.unity.performaction.autoweb.testng_logs;
import io.unity.framework.data.TestData;
import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import org.json.simple.JSONObject;

public class SignUpUtility extends base {

    public JSONObject SignUP() {
        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", "testqable905+" + TestData.random_numeric_string(3) + "@gmail.com");
        body.put("password", "QAble@1010");
        body.put("timeZone", "Asia/Kolkata");
        body.put("rewardfulReferralId", 123);
        body.put("isLtdUser", true);

        logs.test_step("------------------------------------------ SIGNUP VALID EMAIL AND PASSWORD--------------------------------------------");
        String response = builder.updateRequestObject("signup/signup_with_valid_credentials", pathParameter, queryParameters, header, body);
        JSONObject response1 = builder.performRequest(response);

        return response1;

    }
}
