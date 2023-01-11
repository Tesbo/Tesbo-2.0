package api.tests;

import api.requests.common.ExcelOperation.ExcelReader;
import api.requests.common.TokenUtility.TokenUtility;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;


public class GetEmailAccountWarmupTest extends base {

    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN--------------------------------------------//

    @DataProvider(name = "get_email_account_warmup_with_valid_token")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("get_email_account_warmup_Test_case.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_email_account_warmup_with_valid_token")
    public void get_email_account_warmup_with_valid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) throws ParseException {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();
        ExcelReader reader = new ExcelReader();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",1);
        queryParameters.put("limit",25);
        queryParameters.put("sortByKey","sent-today");
        queryParameters.put("order","-1");

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE1 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getToken(reader.getRecordsSet("Credential.xlsx","Sheet1",params)));
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET EMAIL ACCOUNT WARMUP LIST---------------------------------------");
        String update_file_role1 = builder.updateRequestObject("email_account/get_email_account_warmup/get_email_account_warmup", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file_role1);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");

try{
validator.validateSchema(Schema);}
  catch(Exception PathNotFoundException){}

    }

    //---------------------------------- GET THE TEST DATA FOR INVALID TOKEN-------------------------------------------//

    @DataProvider(name = "get_email_account_warmup_with_invalid_token")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("get_email_account_warmup_Test_case.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "get_email_account_warmup_with_invalid_token")
    public void get_email_account_warmup_with_invalid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        logs.test_step("------------------------------------------ GET THE EMAIL ACCOUNT ID FROM ROLE1--------------------------------------------");
        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",1);
        queryParameters.put("limit",25);
        queryParameters.put("sortByKey","sent-today");
        queryParameters.put("order","-1");

        JSONObject header = new JSONObject();
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjE4OTQsImlhdCI6MTY2MDc0MTk5NywiZXhwIjoxNjYzMzMzOTk3fQ.1uNPfk7_f45MCaGTIFJdtqYtCVrFhH4H1ZZCc7CSGUU" );
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET EMAIL ACCOUNT WARMUP LIST---------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_account_warmup/get_email_account_warmup", pathParameter, queryParameters, header, body);
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

    //---------------------------------- GET THE TEST DATA FOR BLANK TOKEN --------------------------------------------//

    @DataProvider(name = "get_email_account_warmup_with_blank_token")
    public Object[][] data_provider3() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("get_email_account_warmup_Test_case.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "get_email_account_warmup_with_blank_token")
    public void get_email_account_warmup_with_blank_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",1);
        queryParameters.put("limit",25);
        queryParameters.put("sortByKey","sent-today");
        queryParameters.put("order","-1");

        JSONObject header = new JSONObject();
        header.put("Authorization", "");
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET EMAIL ACCOUNT WARMUP LIST---------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_account_warmup/get_email_account_warmup", pathParameter, queryParameters, header, body);
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

    //---------------------------------- GET THE TEST DATA FOR EXPIRED TOKEN --------------------------------------------//

    @DataProvider(name = "get_email_account_warmup_with_expired_token_data_provider")
    public Object[][] data_provider4() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("get_email_account_warmup_Test_case.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "get_email_account_warmup_with_expired_token_data_provider")
    public void get_email_account_warmup_with_expired_token(String Token_Type,String Token, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",1);
        queryParameters.put("limit",25);
        queryParameters.put("sortByKey","sent-today");
        queryParameters.put("order","-1");

        JSONObject header = new JSONObject();
        header.put("Authorization",Token);
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET EMAIL ACCOUNT WARMUP LIST---------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_account_warmup/get_email_account_warmup", pathParameter, queryParameters, header, body);
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

    //---------------------------------- FUNCTIONAL TEST CASES --------------------------------------------//

    @DataProvider(name = "get_email_account_warmup_with_different_page")
    public Object[][] data_provider5() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PAGE_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }
    @Test(dataProvider = "get_email_account_warmup_with_different_page")
    public void get_email_account_warmup_with_different_page(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",Value);
        queryParameters.put("limit",25);
        queryParameters.put("sortByKey","sent-today");
        queryParameters.put("order","-1");

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET EMAIL ACCOUNT WARMUP LIST---------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_account_warmup/get_email_account_warmup", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @DataProvider(name = "get_email_account_warmup_with_different_limit")
    public Object[][] data_provider6() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("LIMIT_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }
    @Test(dataProvider = "get_email_account_warmup_with_different_limit")
    public void get_email_account_warmup_with_different_limit(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",1);
        queryParameters.put("limit",Value);
        queryParameters.put("sortByKey","sent-today");
        queryParameters.put("order","-1");

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET EMAIL ACCOUNT WARMUP LIST---------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_account_warmup/get_email_account_warmup", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @DataProvider(name = "get_email_account_warmup_with_valid_sortByKey")
    public Object[][] data_provider7() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("SORT_BY_FUNCTIONAL_TEST_CASE.xlsx", 2);
        return data;
    }
    @Test(dataProvider = "get_email_account_warmup_with_valid_sortByKey")
    public void get_email_account_warmup_with_valid_sortByKey(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",1);
        queryParameters.put("limit",25);
        queryParameters.put("sortByKey",Value);
        queryParameters.put("order",-1);

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET EMAIL ACCOUNT WARMUP LIST---------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_account_warmup/get_email_account_warmup", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }


    @DataProvider(name = "get_email_account_warmup_with_different_sortByKey")
    public Object[][] data_provider8() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("SORT_BY_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }
    @Test(dataProvider = "get_email_account_warmup_with_different_sortByKey")
    public void get_email_account_warmup_with_different_sortByKey(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",1);
        queryParameters.put("limit",25);
        queryParameters.put("sortByKey",Value);
        queryParameters.put("order",-1);

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET EMAIL ACCOUNT WARMUP LIST---------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_account_warmup/get_email_account_warmup", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }


    @DataProvider(name = "get_email_account_warmup_with_different_order")
    public Object[][] data_provider9() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("SORT_BY_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }
    @Test(dataProvider = "get_email_account_warmup_with_different_order")
    public void get_email_account_warmup_with_different_order(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("page",1);
        queryParameters.put("limit",25);
        queryParameters.put("sortByKey","sent-today");
        queryParameters.put("order",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET EMAIL ACCOUNT WARMUP LIST---------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_account_warmup/get_email_account_warmup", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @Test
    public void get_email_account_warmup_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");

        logs.test_step("-------------------------------------- GET EMAIL ACCOUNT WARMUP LIST---------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_account_warmup/get_email_account_warmup", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @Test
    public void get_email_account_warmup_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        logs.test_step("-------------------------------------- GET EMAIL ACCOUNT WARMUP LIST---------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_account_warmup/get_email_account_warmup_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

}
