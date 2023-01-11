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

public class AgencyUserInviteTest extends base {

    @Test
    public void verify_user_invite_for_agency() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();
        body.put("email","testqable905+31"+TestData.random_numeric_string(2)+"@gmail.com");
        body.put("firstName","Bob");
        body.put("lastName","Bob");

        String update_file = builder.updateRequestObject("agency/agency_user_invite/agency_user_invite", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(201);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

//        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
//        validator.validateSchemaFromRequestFile("agency/get_agency_config/get_agency_config");
    }

    @Test
    public void verify_user_invite_for_agency_with_invalid_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "testsgtst");
        JSONObject body = new JSONObject();
        body.put("email","testqable905+31"+TestData.random_numeric_string(2)+"@gmail.com");
        body.put("firstName","Bob");
        body.put("lastName","Bob");

        String update_file = builder.updateRequestObject("agency/agency_user_invite/agency_user_invite", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

    }

    @Test
    public void verify_user_invite_for_agency_with_blank_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "");
        JSONObject body = new JSONObject();
        body.put("email","testqable905+31"+TestData.random_numeric_string(2)+"@gmail.com");
        body.put("firstName","Bob");
        body.put("lastName","Bob");

        String update_file = builder.updateRequestObject("agency/agency_user_invite/agency_user_invite", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

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
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();
        body.put("email", Value);
        body.put("firstName","Bob");
        body.put("lastName","Bob");

        String update_file = builder.updateRequestObject("agency/agency_user_invite/agency_user_invite", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @DataProvider(name = "get_firstName_value")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Invalid_Name.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_firstName_value")
    public void verify_user_invite_for_agency_with_invalid_first_name(String Value) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();
        body.put("email", "testqable905+31\"+TestData.random_numeric_string(2)+\"@gmail.com");
        body.put("firstName",Value);
        body.put("lastName","Bob");

        String update_file = builder.updateRequestObject("agency/agency_user_invite/agency_user_invite", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @DataProvider(name = "get_lastName_value")
    public Object[][] data_provider3() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Invalid_Name.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_lastName_value")
    public void verify_user_invite_for_agency_with_invalid_last_name(String Value) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();
        body.put("email", "testqable905+31\"+TestData.random_numeric_string(2)+\"@gmail.com");
        body.put("firstName","Bob");
        body.put("lastName",Value);

        String update_file = builder.updateRequestObject("agency/agency_user_invite/agency_user_invite", pathParameter, queryParameters, header, body);
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
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/zip");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();
        body.put("email","testqable905+31"+TestData.random_numeric_string(2)+"@gmail.com");
        body.put("firstName","Bob");
        body.put("lastName","Bob");

        String update_file = builder.updateRequestObject("agency/agency_user_invite/agency_user_invite", pathParameter, queryParameters, header, body);
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
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/zip");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();
        body.put("email","testqable905+31"+TestData.random_numeric_string(2)+"@gmail.com");
        body.put("firstName","Bob");
        body.put("lastName","Bob");

        String update_file = builder.updateRequestObject("agency/agency_user_invite/agency_user_invite_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

    }


}
