package api.tests;

import api.requests.common.EmailAccountUtility.EmailAccountUtility;
import api.requests.common.ExcelOperation.ExcelReader;
import api.requests.common.TokenUtility.TokenUtility;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.framework.readers.json_file_reader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class GetEmailAccountIdDisconnectedTest extends base {

    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN--------------------------------------------//

    @DataProvider(name = "get_email_accountId_disconnected_with_valid_token")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Email_AccountID_Disconnected.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_email_accountId_disconnected_with_valid_token")
    public void get_email_accountId_disconnected_with_valid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) throws ParseException {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        ExcelReader reader = new ExcelReader();
        EmailAccountUtility email_id_utils = new EmailAccountUtility();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role2);
        params1.put("SHaccount1", SHaccount2);

        logs.test_step("----------------------------------------- GET THE EMAIL ACCOUNT FROM ROLE1 --------------------------------------------");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("emailAccountId",email_id_utils.getEmailId(reader.getRecordsSet("Credential.xlsx","Sheet1",params)));

        JSONObject queryParameters = new JSONObject();

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE2 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1",params1,"Token"));
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET EMAIL ACCOUNT ID DISCONNECTED--------------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_accountId_disconnected/get_email_accountId_disconnected", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

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

    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN AND FREE PLAN TEST CASES --------------------------------------------//

    @DataProvider(name = "get_email_accountId_disconnected_with_valid_token_with_free_plan")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Email_AccountID_Disconnected.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "get_email_accountId_disconnected_with_valid_token_with_free_plan")
    public void get_email_accountId_disconnected_with_valid_token_with_free_plan(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) {

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
        pathParameter.put("emailAccountId","4512");

        JSONObject queryParameters = new JSONObject();

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE1 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getToken(reader.getRecordsSet("Credential.xlsx","Sheet1",params)));
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET EMAIL ACCOUNT ID DISCONNECTED--------------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_accountId_disconnected/get_email_accountId_disconnected", pathParameter, queryParameters, header, body);
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

    //---------------------------------- GET THE TEST DATA FOR INVALID TOKEN-------------------------------------------//

    @DataProvider(name = "get_email_accountId_disconnected_with_invalid_token")
    public Object[][] data_provider2() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Email_AccountID_Disconnected.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "get_email_accountId_disconnected_with_invalid_token")
    public void get_email_accountId_disconnected_with_invalid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("emailAccountId","4512");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjE4OTQsImlhdCI6MTY2MDc0MTk5NywiZXhwIjoxNjYzMzMzOTk3fQ.1uNPfk7_f45MCaGTIFJdtqYtCVrFhH4H1ZZCc7CSGUU" );
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET EMAIL ACCOUNT ID DISCONNECTED--------------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_accountId_disconnected/get_email_accountId_disconnected", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "get_email_accountId_disconnected_with_blank_token")
    public Object[][] data_provider3() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Email_AccountID_Disconnected.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "get_email_accountId_disconnected_with_blank_token")
    public void get_email_accountId_disconnected_with_blank_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("emailAccountId","4512");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "");
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET EMAIL ACCOUNT ID DISCONNECTED--------------------------------------------");
        String update_file= builder.updateRequestObject("email_account/get_email_accountId_disconnected/get_email_accountId_disconnected", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "get_email_accountId_disconnected_with_expired_token")
    public Object[][] data_provider4() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Email_AccountID_Disconnected.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "get_email_accountId_disconnected_with_expired_token")
    public void get_email_accountId_disconnected_with_expired_token(String Token_Type,String Token, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("emailAccountId","4512");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",Token);
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET EMAIL ACCOUNT ID DISCONNECTED--------------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_accountId_disconnected/get_email_accountId_disconnected", pathParameter, queryParameters, header, body);
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

    //---------------------------------- FUNCTIONAL TEST CASE --------------------------------------------//

    @DataProvider(name = "get_email_accountId_disconnected_with_invalid_email_id_path_parameter")
    public Object[][] data_provider5() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Email_Id_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_email_accountId_disconnected_with_invalid_email_id_path_parameter")
    public void get_email_accountId_disconnected_with_invalid_email_id_path_parameter(String Id,String Filter_Name, String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("emailAccountId",Value);

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",utils.getTokenFromUser());
        header.put("Content_Type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET EMAIL ACCOUNT ID DISCONNECTED--------------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_accountId_disconnected/get_email_accountId_disconnected", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void get_email_accountId_disconnected_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        TokenUtility token_utils = new TokenUtility();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("emailAccountId","4512");

        JSONObject queryParameters = new JSONObject();

        JSONObject body = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");

        logs.test_step("------------------------------------------ GET EMAIL ACCOUNT ID DISCONNECTED--------------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_accountId_disconnected/get_email_accountId_disconnected", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @Test
    public void get_email_accountId_disconnected_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("emailAccountId","4512");

        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        logs.test_step("------------------------------------------GET THE CONNECTED EMAIL ACCOUNT-------------------------------------------");
        String update_file = builder.updateRequestObject("email_account/get_email_accountId_disconnected/get_email_accountId_disconnected_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

}
