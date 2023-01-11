package api.tests;

import api.requests.common.TokenUtility.TokenUtility;
import io.unity.framework.data.TestData;
import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import javax.xml.validation.Schema;


public class UserPasswordTest extends base {

    @Test
    public void user_password_with_valid_data() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils=new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", token_utils.getToken1());

        JSONObject body = new JSONObject();
        body.put("currentPassword", "QAble@1010");
        body.put("newPassword", "QAble@2020");

        logs.test_step("------------------------------------------USER PASSWORD TEST--------------------------------------------");
        String update_file_role1 = builder.updateRequestObject("Users/users_password/users_password", pathParameter, queryParameter, header, body);
        JSONObject response_role1 = builder.performRequest(update_file_role1);

        JSONObject header1 = new JSONObject();
        header1.put("content-type", "application/json");
        header1.put("Authorization", token_utils.getToken2());

        JSONObject body1 = new JSONObject();
        body1.put("currentPassword", "QAble@2020");
        body1.put("newPassword", "QAble@1010");

        logs.test_step("------------------------------------------USER PASSWORD TEST--------------------------------------------");
        String update_file_role2 = builder.updateRequestObject("Users/users_password/users_password", pathParameter, queryParameter, header1, body1);
        JSONObject response_role2 = builder.performRequest(update_file_role2);

        ResponseValidator validator = new ResponseValidator(response_role2);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response_role2.get("responseTime"));

    }

    @Test
    public void user_password_with_invalid_current_password() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils=new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", token_utils.getToken1());

        JSONObject body = new JSONObject();
        body.put("currentPassword", "123456789");
        body.put("newPassword", "QAble@2020");

        logs.test_step("------------------------------------------USER PASSWORD TEST--------------------------------------------");
        String update_file_role1 = builder.updateRequestObject("Users/users_password/users_password", pathParameter, queryParameter, header, body);
        JSONObject response_role1 = builder.performRequest(update_file_role1);

        ResponseValidator validator = new ResponseValidator(response_role1);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response_role1.get("responseTime"));

    }

    @Test
    public void user_password_with_blank_current_password() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils=new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", token_utils.getToken1());

        JSONObject body = new JSONObject();
        body.put("currentPassword", "");
        body.put("newPassword", "QAble@2020");

        logs.test_step("------------------------------------------USER PASSWORD TEST--------------------------------------------");
        String update_file_role1 = builder.updateRequestObject("Users/users_password/users_password", pathParameter, queryParameter, header, body);
        JSONObject response_role1 = builder.performRequest(update_file_role1);

        ResponseValidator validator = new ResponseValidator(response_role1);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response_role1.get("responseTime"));

    }

    @Test
    public void user_password_with_invalid_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9");

        JSONObject body = new JSONObject();
        body.put("currentPassword", "QAble@1010");
        body.put("newPassword", "QAble@2020");

        logs.test_step("------------------------------------------USER PASSWORD TEST--------------------------------------------");
        String update_file_role1 = builder.updateRequestObject("Users/users_password/users_password", pathParameter, queryParameter, header, body);
        JSONObject response_role1 = builder.performRequest(update_file_role1);

        ResponseValidator validator = new ResponseValidator(response_role1);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response_role1.get("responseTime"));

    }

    @Test
    public void user_password_with_blank_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "");

        JSONObject body = new JSONObject();
        body.put("currentPassword", "QAble@1010");
        body.put("newPassword", "QAble@2020");

        logs.test_step("------------------------------------------USER PASSWORD TEST--------------------------------------------");
        String update_file_role1 = builder.updateRequestObject("Users/users_password/users_password", pathParameter, queryParameter, header, body);
        JSONObject response_role1 = builder.performRequest(update_file_role1);

        ResponseValidator validator = new ResponseValidator(response_role1);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response_role1.get("responseTime"));

    }

    @Test
    public void user_password_with_expired_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjE5MjUsImlhdCI6MTY2MjQ0MjA3MCwiZXhwIjoxNjYyNDQyMDgwfQ.DGhv8UaeMZAh6ON1bO5tSy5iS1q4UgAm28-RZ27ZNmw");

        JSONObject body = new JSONObject();
        body.put("currentPassword", "QAble@1010");
        body.put("newPassword", "QAble@2020");

        logs.test_step("------------------------------------------USER PASSWORD TEST--------------------------------------------");
        String update_file_role1 = builder.updateRequestObject("Users/users_password/users_password", pathParameter, queryParameter, header, body);
        JSONObject response_role1 = builder.performRequest(update_file_role1);

        ResponseValidator validator = new ResponseValidator(response_role1);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response_role1.get("responseTime"));

    }
    @Test
    public void user_password_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        TokenUtility token_utils = new TokenUtility();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");

        JSONObject body = new JSONObject();
        body.put("currentPassword", "QAble@1010");
        body.put("newPassword", "QAble@2020");

        String update_file = builder.updateRequestObject("Users/users_password/users_password", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @Test
    public void user_password_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("currentPassword", "QAble@1010");
        body.put("newPassword", "QAble@2020");

        String update_file = builder.updateRequestObject("Users/users_password/users_password_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }
}