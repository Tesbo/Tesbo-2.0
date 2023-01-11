package api.tests;

import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetAgencyConfigTest extends base {

    @Test
    public void get_agency_config() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("baseUrl", "https%3A%2F%2Fagency.lifeisgoodforlearner.com%2Flogin");
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_config/get_agency_config", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

//        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
//        validator.validateSchemaFromRequestFile("agency/get_agency_config/get_agency_config");
    }

    @DataProvider(name = "get_agency_value")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("BASE_URL.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_agency_value")
    public void get_agency_with_invalid_baseUrl_config(String Value) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("baseUrl", Value);
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_config/get_agency_config", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @DataProvider(name = "get_agency_invalid_email_value")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("BASE_URL.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_agency_value")
    public void get_agency_with_invalid_email(String Value) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("baseUrl", "https%3A%2F%2Fagency.lifeisgoodforlearner.com%2Flogin");
        queryParameters.put("email",Value);

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_config/get_agency_config", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @Test
    public void get_agency_config_with_other_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("baseUrl", "https%3A%2F%2Fagency.lifeisgoodforlearner.com%2Flogin");
        JSONObject header = new JSONObject();
        header.put("content-type", "application/zip");
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_config/get_agency_config", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

//        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
//        validator.validateSchemaFromRequestFile("agency/get_agency_config/get_agency_config");
    }

    @Test
    public void get_agency_config_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("baseUrl", "https%3A%2F%2Fagency.lifeisgoodforlearner.com%2Flogin");
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_config/get_agency_config_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

//        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
//        validator.validateSchemaFromRequestFile("agency/get_agency_config/get_agency_config");
    }
}
