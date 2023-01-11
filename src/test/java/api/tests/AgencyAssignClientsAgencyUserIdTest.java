package api.tests;

import api.requests.common.AgencyUtility.AgencyUtility;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AgencyAssignClientsAgencyUserIdTest extends base {

    @Test
    public void agency_assign_client_agency_user_id_with_valid_data() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility agency_utils = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("agencyUserId",agency_utils.getAgencyUserId());
        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", agency_utils.getTokenForAgency());

        JSONObject body_temp = new JSONObject();
        JSONArray body_array= new JSONArray();
        body_temp.put("id",agency_utils.getAgencyClient());
        body_temp.put("role", "agency-user");

        body_array.put(body_temp);

        JSONObject body = new JSONObject();
        body.put("clientsToBeAssigned",body_array);
        body.put("adminRole", null);

        System.out.println(body);

        String update_file = builder.updateRequestObject("agency/agency_assign_client_agency_user_id/agency_assign_client_agency_userId", pathParameter, queryParameters, header, body);
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
    public void agency_assign_client_agency_user_id_with_invalid_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("agencyUserId",728);
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "testsgtst");
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/agency_assign_client_agency_user_id/agency_assign_client_agency_userId", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

    }

    @Test
    public void agency_assign_client_agency_user_id_with_blank_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("agencyUserId",728);
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "");
        JSONObject body = new JSONObject();


        String update_file = builder.updateRequestObject("agency/agency_assign_client_agency_user_id/agency_assign_client_agency_userId", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

    }


    @DataProvider(name = "agency_assign_client_agency_user_id_with_invalid_agencyUserId")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("ID_Functional_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "agency_assign_client_agency_user_id_with_invalid_agencyUserId")
    public void agency_assign_client_agency_user_id_with_invalid_agencyUserId(String Id, String Filter_Name,String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("agencyUserId",Value);
        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/agency_assign_client_agency_user_id/agency_assign_client_agency_userId", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @Test
    public void agency_assign_client_agency_user_id_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("agencyUserId",728);
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/zip");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/agency_assign_client_agency_user_id/agency_assign_client_agency_userId", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

    }

    @Test
    public void agency_assign_client_agency_user_id_with_different_method() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("agencyUserId",728);
        JSONObject queryParameters = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/agency_assign_client_agency_user_id/agency_assign_client_agency_userId_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));

    }


}
