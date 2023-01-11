package api.tests;

import api.requests.common.ExcelOperation.ExcelReader;
import api.requests.common.SequenceUtility.SequenceUtility;
import api.requests.common.TokenUtility.TokenUtility;
import com.codoid.products.exception.FilloException;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.framework.readers.json_file_reader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.jboss.forge.roaster._shade.org.eclipse.core.runtime.IStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class GetSequenceIdEmailTest extends base {

    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN --------------------------------------------//
    @DataProvider(name = "get_sequence_id_email_with_valid_token")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Id_Email_Test_case.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_sequence_id_email_with_valid_token")
    public void get_sequence_id_email_with_valid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
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

        logs.test_step("----------------------------------------- GET THE SEQUENCE FROM ROLE1 --------------------------------------------");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", sequence_utils.getSequenceId(reader.getRecordsSet("Credential.xlsx","Sheet1",params)));

        JSONObject queryParameters = new JSONObject();

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE2 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1",params1,"Token"));
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email", pathParameter, queryParameters, header, body);
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

    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN WITH FREE PLAN --------------------------------------------//
    @DataProvider(name = "get_sequence_id_email_with_valid_token_free_plan")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Id_Email_Test_case.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "get_sequence_id_email_with_valid_token_free_plan")
    public void get_sequence_id_email_with_valid_token_free_plan(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) {

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
        pathParameter.put("sequenceId","1467");

        JSONObject queryParameters = new JSONObject();

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE1 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getToken(reader.getRecordsSet("Credential.xlsx","Sheet1",params)));
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email", pathParameter, queryParameters, header, body);
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

    //---------------------------------- GET THE TEST DATA FOR INVALID TOKEN --------------------------------------------//

    @DataProvider(name = "get_sequence_id_email_with_invalid_token")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Id_Email_Test_case.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "get_sequence_id_email_with_invalid_token")
    public void get_sequence_id_email_with_invalid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership,String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role1);
        params1.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1467");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9");
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "get_sequence_id_email_with_blank_token")
    public Object[][] data_provider3() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Id_Email_Test_case.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "get_sequence_id_email_with_blank_token")
    public void get_sequence_id_email_with_blank_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership,String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role1);
        params1.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1467");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "");
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email", pathParameter, queryParameters, header, body);
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
    @DataProvider(name = "get_sequence_id_email_with_expired_token_data_provider")
    public Object[][] data_provider4() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Id_Email_Test_case.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "get_sequence_id_email_with_expired_token_data_provider")
    public void get_sequence_id_email_with_expired_token(String Token_Type,String Token, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership,String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role1);
        params1.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1467");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", Token);
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email", pathParameter, queryParameters, header, body);
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

    //---------------------------------- GET THE TEST DATA FOR FUNCTIONAL TEST CASE  --------------------------------------------//
    @DataProvider(name = "get_sequence_id_email_with_different_sequence_id")
    public Object[][] data_provider5() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Sequence_Path_Parameter_TEST_CASE.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "get_sequence_id_email_with_different_sequence_id")
    public void get_sequence_id_email_with_different_sequence_id(String Id,String Filter_Name, String Value, String status_code){

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

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @Test
    public void get_sequence_id_email_with_blank_sequence_id() {

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

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }
    @DataProvider(name = "get_sequence_id_email_with_valid_status_parameter_data_provider")
    public Object[][] data_provider6() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("STATUS_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_sequence_id_email_with_valid_status_parameter_data_provider")
    public void get_sequence_id_email_with_valid_status_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1467");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("status",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_id_email_with_invalid_status_parameter_data_provider")
    public Object[][] data_provider7() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("STATUS_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "get_sequence_id_email_with_invalid_status_parameter_data_provider")
    public void get_sequence_id_email_with_invalid_status_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1467");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("status",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_id_email_with_valid_stepId_parameter_data_provider")
    public Object[][] data_provider8() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("STEP_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_sequence_id_email_with_valid_stepId_parameter_data_provider")
    public void get_sequence_id_email_with_valid_stepId_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1467");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("stepId",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_id_email_with_invalid_stepId_parameter_data_provider")
    public Object[][] data_provider9() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("STEP_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "get_sequence_id_email_with_invalid_stepId_parameter_data_provider")
    public void get_sequence_id_email_with_invalid_stepId_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1467");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("stepId",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @DataProvider(name = "get_sequence_id_email_with_valid_page_parameter_data_provider")
    public Object[][] data_provider10() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PAGE_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_sequence_id_email_with_valid_page_parameter_data_provider")
    public void get_sequence_id_email_with_valid_page_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1467");


        JSONObject queryParameter = new JSONObject();
        queryParameter.put("page",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_id_email_with_invalid_page_parameter_data_provider")
    public Object[][] data_provider11() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PAGE_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "get_sequence_id_email_with_invalid_page_parameter_data_provider")
    public void get_sequence_id_email_with_invalid_page_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1467");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("page",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @DataProvider(name = "get_sequence_id_email_with_valid_limit_parameter_data_provider")
    public Object[][] data_provider12() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("LIMIT_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_sequence_id_email_with_valid_limit_parameter_data_provider")
    public void get_sequence_id_email_with_valid_limit_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1467");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("limit",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_id_email_with_invalid_limit_parameter_data_provider")
    public Object[][] data_provider13() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("LIMIT_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "get_sequence_id_email_with_invalid_limit_parameter_data_provider")
    public void get_sequence_id_email_with_invalid_limit_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1467");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("limit",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


 @DataProvider(name = "get_sequence_id_email_with_valid_search_parameter_data_provider")
    public Object[][] data_provider14() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("SEARCH_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "get_sequence_id_email_with_valid_search_parameter_data_provider")
    public void get_sequence_id_email_with_valid_search_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "1467");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("search",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void get_sequence_id_email_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId","1467");

        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @Test
    public void get_sequence_id_email_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId","1467");

        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        logs.test_step("------------------------------------------GET THE SEQUENCE ID EMAIL--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence_id_email/get_sequence_id_email_with_different_method", pathParameter, queryParameters, header, body);

        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

}
