package api.tests;

import api.requests.common.ExcelOperation.ExcelReader;
import api.requests.common.SequenceUtility.SequenceUtility;
import api.requests.common.TokenUtility.TokenUtility;
import com.codoid.products.exception.FilloException;
import io.unity.performaction.autoweb.testng_logs;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GetSequenceEmailStepCount extends base {


    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN --------------------------------------------//
    @DataProvider(name = "get_sequence_email_step_count")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Email_Step_Count_Test_case.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "get_sequence_email_step_count")
    public void get_sequence_email_step_count(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();
        ExcelReader reader = new ExcelReader();
        SequenceUtility sequence_utils = new SequenceUtility();

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE1 --------------------------------------------");
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

        logs.test_step("------------------------------------------ GET THE SEQUENCE ID FROM ROLE2--------------------------------------------");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", sequence_utils.getSequenceIdScheduleId(reader.getRecordsSet("Credential.xlsx","Sheet1",params1))[0]);

        logs.test_step("------------------------------------------ GET THE STEP ID FROM ROLE2--------------------------------------------");
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("stepId", sequence_utils.getSequenceIdScheduleId(reader.getRecordsSet("Credential.xlsx","Sheet1",params1))[1]);

        logs.test_step("------------------------------------------ GET THE TOKEN FROM ROLE1--------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1",params,"Token"));
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE EMAIL STEP COUNT--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_email_step_count/get_sequence_email_step_count_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response1 = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response1);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response1.get("responseTime"));

        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");

try{
validator.validateSchema(Schema);}
  catch(Exception PathNotFoundException){}

    }

    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN AND FREE PLAN TEST CASES --------------------------------------------//

    @DataProvider(name = "get_sequence_email_step_count_with_valid_token_free_plan")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Email_Status_Count_Test_case.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "get_sequence_email_step_count_with_valid_token_free_plan")
    public void get_sequence_email_step_count_with_valid_token_free_plan(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        ExcelReader reader = new ExcelReader();


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

        logs.test_step("------------------------------------------ GET THE SEQUENCE ID FROM ROLE2--------------------------------------------");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1447");

        logs.test_step("------------------------------------------ GET THE STEP ID FROM ROLE2--------------------------------------------");
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("stepId", "1367");

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE1 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1",params,"Token"));
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE EMAIL STEP COUNT--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_email_step_count/get_sequence_email_step_count_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response1 = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response1);
        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response1.get("responseTime"));

        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");

try{
validator.validateSchema(Schema);}
  catch(Exception PathNotFoundException){}

    }

    //---------------------------------- GET THE TEST DATA FOR INVALID TOKEN --------------------------------------------//

    @DataProvider(name = "get_sequence_email_step_count_with_invalid_token")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Email_Status_Count_Test_case.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "get_sequence_email_step_count_with_invalid_token")
    public void get_sequence_email_step_count_with_invalid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();


        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role1);
        params1.put("SHaccount1", SHaccount1);

        logs.test_step("------------------------------------------ GET THE SEQUENCE ID FROM ROLE1--------------------------------------------");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1447");

        logs.test_step("------------------------------------------ GET THE STEP ID FROM ROLE1--------------------------------------------");
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("stepId", "1337");

        JSONObject header = new JSONObject();
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9");
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE EMAIL STEP COUNT--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_email_step_count/get_sequence_email_step_count_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response1 = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response1);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response1.get("responseTime"));

        logs.test_step("------------------------------------------ VALIDATE SCHEMA ----------------------------------------------------");
        validator.validateSchema(Schema);
    }

    //---------------------------------- GET THE TEST DATA FOR BLANK TOKEN --------------------------------------------//

    @DataProvider(name = "get_sequence_email_step_count_with_blank_token")
    public Object[][] data_provider3() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Email_Status_Count_Test_case.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "get_sequence_email_step_count_with_blank_token")
    public void get_sequence_email_step_count_with_blank_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        ExcelReader reader = new ExcelReader();
        SequenceUtility sequence_utils = new SequenceUtility();

        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role1);
        params1.put("SHaccount1", SHaccount1);

        logs.test_step("------------------------------------------ GET THE SEQUENCE ID FROM ROLE1--------------------------------------------");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1447");

        logs.test_step("------------------------------------------ GET THE STEP ID FROM ROLE1--------------------------------------------");
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("stepId", "1337");


        JSONObject header = new JSONObject();
        header.put("Authorization", "");
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------------GET THE SEQUENCE EMAIL STEP COUNT--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_email_step_count/get_sequence_email_step_count_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response1 = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response1);
        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response1.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_email_step_count_with_expired_token_data_provider")
    public Object[][] data_provider4() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Email_Status_Count_Test_case.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "get_sequence_email_step_count_with_expired_token_data_provider")
    public void get_sequence_email_step_count_with_expired_token(String Token_Type,String Token, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();


        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role1);
        params1.put("SHaccount1", SHaccount1);

        logs.test_step("------------------------------------------ GET THE SEQUENCE ID FROM ROLE1--------------------------------------------");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId","1447");

        logs.test_step("------------------------------------------ GET THE STEP ID FROM ROLE1--------------------------------------------");
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("stepId", "1337");


        JSONObject header = new JSONObject();
        header.put("Authorization", Token);
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------------GET THE SEQUENCE EMAIL STEP COUNT--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_email_step_count/get_sequence_email_step_count_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response1 = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response1);
        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response1.get("responseTime"));

    }

    @Test
    public void get_sequence_email_step_contact_with_blank_sequence_id()  {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("stepId", "1337");

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE EMAIL STEP COUNT--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_email_step_count/get_sequence_email_step_count_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @DataProvider(name = "get_sequence_email_step_count_with_valid_search_parameter_data_provider")
    public Object[][] data_provider6() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("SEARCH_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "get_sequence_email_step_count_with_valid_search_parameter_data_provider")
    public void get_sequence_email_step_count_with_valid_search_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "3639");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("stepId", "1337");
        queryParameter.put("search",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE EMAIL STEP COUNT--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_email_step_count/get_sequence_email_step_count_with_valid_token", pathParameter, queryParameter, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void get_sequence_email_step_contact_with_blank_search_parameter()  {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "3639");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("stepId", "1337");
        queryParameter.put("search","");

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE EMAIL STEP COUNT--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_email_step_count/get_sequence_email_step_count_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }


    @DataProvider(name = "get_sequence_email_step_contact_with_invalid_sequences_parameter_data_provider")
    public Object[][] data_provider9() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TAGS_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "get_sequence_email_step_contact_with_invalid_sequences_parameter_data_provider")
    public void get_sequence_email_step_contact_with_invalid_sequences_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", Value);

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("stepId", "1337");

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE EMAIL STEP COUNT--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_email_step_count/get_sequence_email_step_count_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_email_step_contact_with_valid_step_parameter_data_provider")
    public Object[][] data_provider10() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TAGS_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "get_sequence_email_step_contact_with_valid_step_parameter_data_provider")
    public void get_sequence_email_step_contact_with_valid_step_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "3639");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("stepId", Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE EMAIL STEP COUNT--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_email_step_count/get_sequence_email_step_count_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_email_step_contact_with_invalid_step_parameter_data_provider")
    public Object[][] data_provider11() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TAGS_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "get_sequence_email_step_contact_with_invalid_step_parameter_data_provider")
    public void get_sequence_email_step_contact_with_invalid_step_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "3639");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("stepId", Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE EMAIL STEP COUNT--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_email_step_count/get_sequence_email_step_count_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void get_sequence_email_step_count_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1447");

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("stepId", "1337");

        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");

        logs.test_step("------------------------------------------GET THE SEQUENCE EMAIL STEP COUNT--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_email_step_count/get_sequence_email_step_count_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @Test
    public void get_sequence_email_step_count_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1447");

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("stepId", "1337");

        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        logs.test_step("------------------------------------------GET THE SEQUENCE EMAIL STEP COUNT--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_email_step_count/get_sequence_email_step_count_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }



}
