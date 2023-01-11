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

public class GetAgencyUsersTest extends base {

    @Test
    public void get_agency_users() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",1);
        queryParameters.put("sortByKey","createdAt");
        queryParameters.put("order","-1");
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @Test
    public void get_agency_users_with_invalid_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",1);
        queryParameters.put("sortByKey","createdAt");
        queryParameters.put("order","-1");
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "tesbhsgsudghjgd");
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @Test
    public void get_agency_users_with_blank_token() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",1);
        queryParameters.put("sortByKey","createdAt");
        queryParameters.put("order","-1");
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", "");
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @Test
    public void get_agency_users_with_another_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",1);
        queryParameters.put("sortByKey","createdAt");
        queryParameters.put("order","-1");
        JSONObject header = new JSONObject();
        header.put("content-type", "application/zip");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @Test
    public void get_agency_users_with_different_method() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",1);
        queryParameters.put("sortByKey","createdAt");
        queryParameters.put("order","-1");
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @DataProvider(name = "search_with_valid_data")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("SEARCH_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "search_with_valid_data")
    public void get_agency_users_with_valid_search(String Id, String Filter_Name,String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("search",Value);
        queryParameters.put("page",1);
        queryParameters.put("sortByKey","createdAt");
        queryParameters.put("order","-1");
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @DataProvider(name = "search_with_invalid_data")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("SEARCH_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "search_with_invalid_data")
    public void get_agency_users_with_invalid_search(String Id, String Filter_Name,String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("search",Value);
        queryParameters.put("page",1);
        queryParameters.put("sortByKey","createdAt");
        queryParameters.put("order","-1");
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @DataProvider(name = "get_agency_with_invalid_page")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PAGE_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "search_with_valid_data")
    public void get_agency_users_with_valid_page(String Id, String Filter_Name,String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("search","test");
        queryParameters.put("page",Value);
        queryParameters.put("sortByKey","createdAt");
        queryParameters.put("order","-1");;

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @DataProvider(name = "get_agency_user_with_valid_sort_by_key_value")
    public Object[][] data_provider3() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Sort_By_Key.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_agency_user_with_valid_sort_by_key_value")
    public void get_agency_user_with_valid_sort_by_key_value(String Value) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("search","test");
        queryParameters.put("page",1);
        queryParameters.put("sortByKey",Value);
        queryParameters.put("order","-1");
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @DataProvider(name = "get_agency_user_with_invalid_sort_by_key_value")
    public Object[][] data_provider4() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Sort_By_Key.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "get_agency_user_with_invalid_sort_by_key_value")
    public void get_agency_user_with_invalid_sort_by_key_value(String Value) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("search","test");
        queryParameters.put("page",1);
        queryParameters.put("sortByKey",Value);
        queryParameters.put("order",-1);
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }


    @DataProvider(name = "get_agency_user_with_valid_order_value")
    public Object[][] data_provider5() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Order.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_agency_user_with_valid_order_value")
    public void get_agency_user_with_valid_order_value(String Value) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("search","test");
        queryParameters.put("page",1);
        queryParameters.put("sortByKey","createdAt");
        queryParameters.put("order",Value);
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @DataProvider(name = "get_agency_user_with_invalid_order_value")
    public Object[][] data_provider6() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Order.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "get_agency_user_with_invalid_order_value")
    public void get_agency_user_with_invalid_order_value(String Value) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("search","test");
        queryParameters.put("page",1);
        queryParameters.put("sortByKey", "createdAt");
        queryParameters.put("order",Value);
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @DataProvider(name = "get_agency_user_with_valid_limit_value")
    public Object[][] data_provider7() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Order.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_agency_user_with_valid_limit_value")
    public void get_agency_user_with_valid_limit_value(String Value) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("search","test");
        queryParameters.put("page",1);
        queryParameters.put("sortByKey","sent-today");
        queryParameters.put("order","Asc");
        queryParameters.put("limit",Value);
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }

    @DataProvider(name = "get_agency_user_with_invalid_limit_value")
    public Object[][] data_provider8() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Order.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "get_agency_user_with_invalid_limit_value")
    public void get_agency_user_with_invalid_limit_value(String Value) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        AgencyUtility get_token = new AgencyUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("search","test");
        queryParameters.put("page",1);
        queryParameters.put("sortByKey", "sent-today");
        queryParameters.put("order","Asc");
        queryParameters.put("limit",Value);
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", get_token.getTokenForAgency());
        JSONObject body = new JSONObject();

        String update_file = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long) response.get("responseTime"));
    }




}
