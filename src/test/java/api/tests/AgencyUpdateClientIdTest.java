package api.tests;

import api.requests.common.AgencyUtility.AgencyUtility;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AgencyUpdateClientIdTest extends base {

    @Test
    public void verify_agency_update_clientId() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility agency_utils = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("clientId",2773);
       // pathParameter.put("clientId",agency_utils.getAgencyClient());
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", agency_utils.getTokenForAgency());
        JSONObject body = new JSONObject();
        body.put("clientName","Newtest");

        String update_file = builder.updateRequestObject("agency/agency_update_clientId/agency_update_clientId", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

//        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
//        validator.validateSchemaFromRequestFile("agency/get_agency_config/get_agency_config");
    }

    @Test
    public void verify_agency_update_clientId_with_invalid_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("clientId",2773);
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "testsgtst");
        JSONObject body = new JSONObject();
        body.put("clientName","Newtest");

        String update_file = builder.updateRequestObject("agency/agency_update_clientId/agency_update_clientId", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

    }

    @Test
    public void verify_agency_update_clientId_with_blank_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("clientId",2773);
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "");
        JSONObject body = new JSONObject();
        body.put("clientName","Newtest");


        String update_file = builder.updateRequestObject("agency/agency_update_clientId/agency_update_clientId", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

    }

    @Test
    public void verify_agency_update_clientId_blank_client_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("clientId",2773);
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();
        body.put("clientName","");


        String update_file = builder.updateRequestObject("agency/agency_update_clientId/agency_update_clientId", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @DataProvider(name = "agency_update_clientId_with_invalid_clientId")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("ID_Functional_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "agency_update_clientId_with_invalid_clientId")
    public void agency_update_clientId_with_invalid_clientId(String Id, String Filter_Name,String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("clientId",Value);
        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();
        body.put("clientName","Newtest");

        String update_file = builder.updateRequestObject("agency/agency_update_clientId/agency_update_clientId", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @Test
    public void verify_agency_update_clientId_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("clientId",2773);
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/zip");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();
        body.put("clientName","Newtest");

        String update_file = builder.updateRequestObject("agency/agency_update_clientId/agency_update_clientId", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

    }

    @Test
    public void verify_agency_update_clientId_with_different_method() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("clientId",2773);
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/zip");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();
        body.put("clientName","Newtest");


        String update_file = builder.updateRequestObject("agency/agency_update_clientId/agency_update_clientId_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

    }


}
