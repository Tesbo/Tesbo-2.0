package api.tests;

import io.unity.performaction.autoweb.testng_logs;
import io.unity.framework.data.TestData;
import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class ResendOtpTest extends base {

    @Test
    public void resend_otp_with_valid_data() {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", "testqable905+" + TestData.random_numeric_string(3) + "@gmail.com");
        body.put("password", "QAble@1010");
        body.put("timeZone", "Asia/Kolkata");
        body.put("rewardfulReferralId", 123);
        body.put("isLtdUser", true);

        logs.test_step("------------------------------------------ SIGN UP WITH VALID EMAIL AND PASSWORD--------------------------------------------");
        String response = builder.updateRequestObject("signup/signup_with_valid_credentials", pathParameter, queryParameter, header, body);
        JSONObject response1 = builder.performRequest(response);

        JSONObject body1 = new JSONObject();
        body1.put("email", body.get("email"));

        logs.test_step("------------------------------------------ RESEND OTP VALID EMAIL --------------------------------------------");

        String update_resend_otp_file = builder.updateRequestObject("resend_otp/resend_otp", pathParameter, queryParameter, header, body1);
        JSONObject resend_otp_file_response = builder.performRequest(update_resend_otp_file);

        ResponseValidator validator = new ResponseValidator(resend_otp_file_response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) resend_otp_file_response.get("responseTime"));

        logs.test_step("------------------------------------------ VALIDATE RESPONSE MESSAGE --------------------------------------------");
        validator.responseShouldContains("$.message", "OTP has been sent successfully");

    }

    @Test
    public void resend_otp_with_invalid_email() {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", "test");

        logs.test_step("------------------------------------------ RESEND OTP INVALID EMAIL --------------------------------------------");

        String update_resend_otp_file = builder.updateRequestObject("resend_otp/resend_otp", pathParameter, queryParameter, header, body);
        JSONObject resend_otp_file_response = builder.performRequest(update_resend_otp_file);

        ResponseValidator validator = new ResponseValidator(resend_otp_file_response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) resend_otp_file_response.get("responseTime"));

    }

    @Test
    public void resend_otp_with_blank_email() {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", "");

        logs.test_step("------------------------------------------ RESEND OTP BLANK EMAIL --------------------------------------------");

        String update_resend_otp_file = builder.updateRequestObject("resend_otp/resend_otp", pathParameter, queryParameter, header, body);
        JSONObject resend_otp_file_response = builder.performRequest(update_resend_otp_file);

        ResponseValidator validator = new ResponseValidator(resend_otp_file_response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) resend_otp_file_response.get("responseTime"));


    }
}