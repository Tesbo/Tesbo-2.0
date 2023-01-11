package api.tests;

import api.requests.common.AgencyUtility.AgencyUtility;
import io.unity.framework.data.TestData;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AgencyLoginTest extends base {

    @Test
    public void verify_login_agency_user() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email","testqable905@gmail.com");
        body.put("password","P@ssword1");

        String update_file = builder.updateRequestObject("agency/agency_login/agency_login", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(201);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

//        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
//        validator.validateSchemaFromRequestFile("agency/get_agency_config/get_agency_config");
    }

    @DataProvider(name = "get_email_value")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("BASE_URL.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_email_value")
    public void verify_user_invite_for_agency_with_invalid_email(String Value) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();


        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", Value);
        body.put("password","P@ssword1");

        String update_file = builder.updateRequestObject("agency/agency_login/agency_login", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @DataProvider(name = "get_password_value")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("BASE_URL.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_password_value")
    public void verify_user_invite_for_agency_with_invalid_password(String Value) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", "testqable905@gmail.com");
        body.put("password",Value);

        String update_file = builder.updateRequestObject("agency/agency_login/agency_login", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @Test
    public void verify_user_invite_for_agency_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();


        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/zip");

        JSONObject body = new JSONObject();
        body.put("email","testqable905@gmail.com");
        body.put("password","P@ssword1");

        String update_file = builder.updateRequestObject("agency/agency_login/agency_login", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

    }

    @Test
    public void verify_user_invite_for_agency_with_different_method() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email","testqable905@gmail.com");
        body.put("password","P@ssword1");

        String update_file = builder.updateRequestObject("agency/agency_login/agency_login_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

    }

}
