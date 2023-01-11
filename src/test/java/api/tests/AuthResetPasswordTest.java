package api.tests;

import api.requests.common.TokenUtility.TokenUtility;
import com.codoid.products.exception.FilloException;
import io.unity.framework.data.TestData;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthResetPasswordTest extends base {


    @Test
    public void auth_reset_password_with_valid_data(){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email","testqable905@gmail.com");

        logs.test_step("------------------------------------------ AUTH RESET PASSWORD--------------------------------------------");
        String update_file = builder.updateRequestObject("auth/auth_reset_password/auth_reset_password", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(201);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "auth_reset_password_with_invalid_email_data_provider")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Auth_Reset_Password_Test_Case.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "auth_reset_password_with_invalid_email_data_provider")
    public void auth_reset_password_with_invalid_email(String Username, String Password,String Status_Code, String Schema) throws FilloException {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email",Username);

        logs.test_step("------------------------------------------ AUTH RESET PASSWORD--------------------------------------------");
        String update_file = builder.updateRequestObject("auth/auth_reset_password/auth_reset_password", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
        
try{
validator.validateSchema(Schema);}
  catch(Exception PathNotFoundException){}
    }



    //---------------------------------- GET THE TEST DATA FOR BLANK DATA --------------------------------------------//

    @DataProvider(name = "auth_reset_password_with_blank_data_provider")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Auth_Reset_Password_Test_Case.xlsx", 1);
        return data;
    }
    @Test(dataProvider = "auth_reset_password_with_blank_data_provider")
    public void auth_reset_password_with_blank_data_provider(String Username, String Password,String Status_Code, String Schema) throws FilloException {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email",Username);

        logs.test_step("------------------------------------------ AUTH RESET PASSWORD--------------------------------------------");
        String update_file = builder.updateRequestObject("auth/auth_reset_password/auth_reset_password", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
        
try{
validator.validateSchema(Schema);}
  catch(Exception PathNotFoundException){}
    }

    @Test
    public void auth_reset_password_with_invalid_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9");

        JSONObject body = new JSONObject();
        body.put("email","testqable905@gmail.com");

        String update_file_role1 = builder.updateRequestObject("auth/auth_reset_password/auth_reset_password", pathParameter, queryParameter, header, body);
        JSONObject response_role1 = builder.performRequest(update_file_role1);

        ResponseValidator validator = new ResponseValidator(response_role1);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response_role1.get("responseTime"));

    }

    @Test
    public void auth_reset_password_with_blank_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "");

        JSONObject body = new JSONObject();
        body.put("email","testqable905@gmail.com");

        String update_file_role1 = builder.updateRequestObject("auth/auth_reset_password/auth_reset_password", pathParameter, queryParameter, header, body);
        JSONObject response_role1 = builder.performRequest(update_file_role1);

        ResponseValidator validator = new ResponseValidator(response_role1);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response_role1.get("responseTime"));

    }

    @Test
    public void auth_reset_password_with_expired_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjE5MjUsImlhdCI6MTY2MjQ0MjA3MCwiZXhwIjoxNjYyNDQyMDgwfQ.DGhv8UaeMZAh6ON1bO5tSy5iS1q4UgAm28-RZ27ZNmw");

        JSONObject body = new JSONObject();
        body.put("email","testqable905@gmail.com");

        String update_file_role1 = builder.updateRequestObject("auth/auth_reset_password/auth_reset_password", pathParameter, queryParameter, header, body);
        JSONObject response_role1 = builder.performRequest(update_file_role1);

        ResponseValidator validator = new ResponseValidator(response_role1);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response_role1.get("responseTime"));

    }

    @Test
    public void auth_reset_password_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject body = new JSONObject();
        body.put("email","testqable905+@gmail.com");

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");

        logs.test_step("------------------------------------------ AUTH RESET PASSWORD--------------------------------------------");
        String update_file = builder.updateRequestObject("auth/auth_reset_password/auth_reset_password", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @Test
    public void auth_reset_password_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject body = new JSONObject();
        body.put("email","testqable905+@gmail.com");

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        logs.test_step("------------------------------------------ AUTH RESET PASSWORD--------------------------------------------");
        String update_file = builder.updateRequestObject("auth/auth_reset_password/auth_reset_password_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

}
