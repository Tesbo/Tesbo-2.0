package api.tests;

import api.requests.common.ExcelOperation.ExcelReader;
import api.requests.common.SequenceUtility.SequenceUtility;
import api.requests.common.TokenUtility.TokenUtility;
import io.unity.framework.init.base;
import io.unity.performaction.autoweb.testng_logs;import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SendEmailTest extends base {


//---------------------------------- GET THE TEST DATA FOR VALID TOKEN --------------------------------------------//

    @DataProvider(name = "send_email_test_with_valid_token_data_provider")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Send_Email_Sequence_With_Test_case.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "send_email_test_with_valid_token_data_provider")
    public void send_email_test_with_valid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();
        ExcelReader reader = new ExcelReader();
        SequenceUtility sequence_utils = new SequenceUtility();

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

        logs.test_step("------------------------------------------GET THE SEQUENCE ID FROM ROLE2--------------------------------------------");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", sequence_utils.getSequenceId(reader.getRecordsSet("Credential.xlsx","Sheet1",params1)));

        JSONObject queryParameters = new JSONObject();

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE1 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getToken(reader.getRecordsSet("Credential.xlsx","Sheet1",params)));
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ SEND EMAIL TEST --------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/send_email_test/send_email_test_with_valid_token", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "send_email_test_with_valid_token_free_plan")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Send_Email_Sequence_With_Test_case.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "send_email_test_with_valid_token_free_plan")
    public void send_email_test_with_valid_token_free_plan(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) {

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
        pathParameter.put("sequenceId","4556");

        JSONObject queryParameters = new JSONObject();

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE1 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getToken(reader.getRecordsSet("Credential.xlsx","Sheet1",params)));
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ SEND EMAIL TEST --------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/send_email_test/send_email_test_with_valid_token", pathParameter, queryParameters, header, body);
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

    //---------------------------------- GET THE TEST DATA FOR INVALID TOKEN  --------------------------------------------//
    @DataProvider(name = "send_email_test_with_invalid_token")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Send_Email_Sequence_With_Test_case.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "send_email_test_with_invalid_token")
    public void send_email_test_invalid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {


        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId","4556");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9");
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ SEND EMAIL TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/send_email_test/send_email_test_with_valid_token", pathParameter, queryParameters, header, body);
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
    //---------------------------------- GET THE TEST DATA FOR BLANK TOKEN  --------------------------------------------//
    @DataProvider(name = "send_email_test_with_blank_token")
    public Object[][] data_provider3() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Send_Email_Sequence_With_Test_case.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "send_email_test_with_blank_token")
    public void send_email_test_with_blank_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "4556");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "");
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------SEND EMAIL TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/send_email_test/send_email_test_with_valid_token", pathParameter, queryParameters, header, body);
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
    //---------------------------------- GET THE TEST DATA FOR EXPIRED TOKEN  --------------------------------------------//
    @DataProvider(name = "send_email_test_with_expired_token")
    public Object[][] data_provider4() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Send_Email_Sequence_With_Test_case.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "send_email_test_with_expired_token")
    public void send_email_test_with_expired_token(String Token_Type,String Token, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "4556");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", Token);
        header.put("Content-Type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------SEND EMAIL TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/send_email_test/send_email_test_with_valid_token", pathParameter, queryParameters, header, body);
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
    //---------------------------------- GET THE TEST DATA FOR FUNCTIONAL TEST CASE --------------------------------------------//

    @DataProvider(name = "send_email_test_different_sequence_id")
    public Object[][] data_provider5() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Sequence_Path_Parameter_TEST_CASE.xlsx", 0);
        return data;
    }
    @Test(dataProvider ="send_email_test_different_sequence_id")
    public void send_email_test_with_different_sequence_id(String Id,String Filter_Name, String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", Value);

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------SEND EMAIL TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/send_email_test/send_email_test_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "send_email_test_with_different_subject")
    public Object[][] data_provider6() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TEST_EMAIL_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }
    @Test(dataProvider ="send_email_test_with_different_subject")
    public void send_email_test_with_different_subject(String Id,String Filter_Name, String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", 4556);

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("subject",Value);

        logs.test_step("------------------------------------------SEND EMAIL TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/send_email_test/send_email_test_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void send_email_test_with_blank_sequence_id() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId","");

        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        String update_file = builder.updateRequestObject("sequence/send_email_test/send_email_test_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "send_email_test_with_different_preheader")
    public Object[][] data_provider7() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TEST_EMAIL_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }
    @Test(dataProvider ="send_email_test_with_different_preheader")
    public void send_email_test_with_different_preheader(String Id,String Filter_Name, String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", 4556);

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("preheader",Value);

        logs.test_step("------------------------------------------SEND EMAIL TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/send_email_test/send_email_test_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }
    @DataProvider(name = "send_email_test_with_different_content")
    public Object[][] data_provider8() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TEST_EMAIL_FUNCTIONAL_TEST_CASE.xlsx", 2);
        return data;
    }
    @Test(dataProvider ="send_email_test_with_different_content")
    public void send_email_test_with_different_content(String Id,String Filter_Name, String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", 4556);

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("content",Value);

        logs.test_step("------------------------------------------SEND EMAIL TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/send_email_test/send_email_test_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "send_email_test_with_different_stepNumber")
    public Object[][] data_provider9() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TEST_EMAIL_FUNCTIONAL_TEST_CASE.xlsx", 3);
        return data;
    }
    @Test(dataProvider ="send_email_test_with_different_stepNumber")
    public void send_email_test_with_different_stepNumber(String Id,String Filter_Name, String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", 4556);

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("stepNumber",Value);

        logs.test_step("------------------------------------------SEND EMAIL TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/send_email_test/send_email_test_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void send_email_test_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId","4556");

        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");

        String update_file = builder.updateRequestObject("sequence/send_email_test/send_email_test_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @Test
    public void send_email_test_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId","4556");

        JSONObject queryParameters = new JSONObject();

        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        String update_file = builder.updateRequestObject("sequence/send_email_test/send_email_test_with_valid_token_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


}