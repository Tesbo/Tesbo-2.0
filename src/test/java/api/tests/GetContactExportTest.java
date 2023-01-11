package api.tests;

import api.requests.common.ExcelOperation.ExcelReader;
import api.requests.common.TokenUtility.TokenUtility;
import com.codoid.products.exception.FilloException;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GetContactExportTest extends base {


    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN --------------------------------------------//
    @DataProvider(name = "contacts_export_with_valid_token_data_provider")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Contact_Export_Test_case.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "contacts_export_with_valid_token_data_provider")
    public void contacts_export_with_valid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema){
        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        ExcelReader reader = new ExcelReader();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE1 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1",params,"Token"));
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file_role1 = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response_role1 = builder.performRequest(update_file_role1);

        ResponseValidator validator_role1 = new ResponseValidator(response_role1);

        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role2);
        params1.put("SHaccount1", SHaccount2);
        JSONObject pathParameter1 = new JSONObject();

        JSONObject queryParameters1 = new JSONObject();

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE2 --------------------------------------------");
        JSONObject header1 = new JSONObject();
        header1.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1",params1,"Token"));
        header1.put("content-type", Content_Type);

        JSONObject body1 = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file_role2 = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter1, queryParameters1, header1, body1);
        JSONObject response_role2 = builder.performRequest(update_file_role2);

        ResponseValidator validator_role2 = new ResponseValidator(response_role2);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator_role2.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator_role2.validateResponseTime((Long)response_role2.get("responseTime"));

        try {
            logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
            validator_role2.validateSchema(Schema);
        }catch (Exception e){
            System.out.println("path not found");
        }


        logs.test_step("------------------------------------------ VALIDATE ROLE1 ID AND ROLE2 ID --------------------------------------------");
        assertThat(new ArrayList<String>(Arrays.asList(validator_role1.getDataFromBody("$.payload.fields[*].id").split(","))).contains(new ArrayList<String>(Arrays.asList(validator_role2.getDataFromBody("$.payload.fields[*].id").split(","))))).isFalse();

    }

//    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN AND FREE PLAN TEST CASES --------------------------------------------//
//
//    @DataProvider(name = "contacts_export_with_valid_token_with_free_plan_data_provider")
//    public Object[][] data_provider1() {
//        DataReader reader = new DataReader();
//        Object[][] data = null;
//        data = reader.getExcelDataForDataProvider("Get_Contact_Export_Test_case.xlsx", 1);
//        return data;
//    }
//
//
//    @Test(dataProvider = "contacts_export_with_valid_token_with_free_plan_data_provider")
//    public void contacts_export_with_valid_token_with_free_plan(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) {
//
//        testng_logs logs = new testng_logs();
//        RequestBuilder builder = new RequestBuilder();
//        ExcelReader reader = new ExcelReader();
//
//        Map params = new HashMap();
//        params.put("Subscription_State", Subscription_State);
//        params.put("Plan", Plan);
//        params.put("Role", Role1);
//        params.put("SHaccount1", SHaccount1);
//        JSONObject pathParameter = new JSONObject();
//
//        JSONObject queryParameters = new JSONObject();
//
//        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE1 --------------------------------------------");
//        JSONObject header = new JSONObject();
//        header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1",params,"Token"));
//        header.put("content-type", Content_Type);
//
//        JSONObject body = new JSONObject();
//
//        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
//        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameters, header, body);
//        JSONObject response = builder.performRequest(update_file);
//
//        ResponseValidator validator = new ResponseValidator(response);
//
//        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
//        validator.statusCodeShouldBe(400);
//
//        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
//        validator.validateResponseTime((Long)response.get("responseTime"));
//
//        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
//
//try{
//validator.validateSchema(Schema);}
//  catch(Exception PathNotFoundException){}
//
//
//    }

    //---------------------------------- GET THE TEST DATA FOR INVALID TOKEN-------------------------------------------//

    @DataProvider(name = "contacts_export_with_invalid_token_data_provider")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Contact_Export_Test_case.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_invalid_token_data_provider")
    public void contacts_export_with_invalid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {
        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjE4OTQsImlhdCI6MTY2MDc0MTk5NywiZXhwIjoxNjYzMzMzOTk3fQ.1uNPfk7_f45MCaGTIFJdtqYtCVrFhH4H1ZZCc7CSGUU" );
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "contacts_export_with_blank_token_data_provider")
    public Object[][] data_provider3() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Contact_Export_Test_case.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_blank_token_data_provider")
    public void contacts_export_with_blank_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "");
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "contacts_export_with_expired_token_data_provider")
    public Object[][] data_provider4() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Contact_Export_Test_case.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_expired_token_data_provider")
    public void contacts_export_with_expired_token(String Token_Type,String Token, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",Token);
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameters, header, body);
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

    //---------------------------------- GET THE TEST DATA FOR FUNCTIONAL TEST --------------------------------------------//

    @DataProvider(name = "contacts_export_with_valid_sequence_is_none_data_provider")
    public Object[][] data_provider5() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("SEQUENCE_NONE_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_valid_sequence_is_none_data_provider")
    public void contacts_export_with_valid_sequence_is_none_data_provider(String Id,String Filter_Name, String Value, String status_code){
        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("isSequenceNone",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization", get_token.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameter, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_sequence_is_none_data_provider")
    public Object[][] data_provider6() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("SEQUENCE_NONE_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_invalid_sequence_is_none_data_provider")
    public void contacts_export_with_invalid_sequence_is_none_data_provider(String Id,String Filter_Name, String Value, String status_code){
        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("isSequenceNone",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization", get_token.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameter, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_valid_status_data_provider")
    public Object[][] data_provider7() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("STATUS_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_valid_status_data_provider")
    public void contacts_export_with_valid_status_data_provider(String Id,String Filter_Name, String Value, String status_code){
        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("status",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization", get_token.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameter, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_status_data_provider")
    public Object[][] data_provider8() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("STATUS_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_invalid_status_data_provider")
    public void contacts_export_with_invalid_status_data_provider(String Id,String Filter_Name, String Value, String status_code){
        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("status",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization", get_token.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameter, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_valid_verification_data_provider")
    public Object[][] data_provider9() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("VERIFICATION_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_valid_verification_data_provider")
    public void contacts_export_with_valid_verification(String Id,String Filter_Name, String Value, String status_code){
        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("verification",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization", get_token.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameter, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_verification_data_provider")
    public Object[][] data_provider10() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("VERIFICATION_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_invalid_verification_data_provider")
    public void contacts_export_with_invalid_verification_data_provider(String Id,String Filter_Name, String Value, String status_code){
        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("verification",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization", get_token.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameter, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_valid_step_data_provider")
    public Object[][] data_provider11() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("STEP_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_valid_step_data_provider")
    public void contacts_export_with_valid_step(String Id,String Filter_Name, String Value, String status_code){
        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("stepId",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization", get_token.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameter, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_step_data_provider")
    public Object[][] data_provider12() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("STEP_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_invalid_step_data_provider")
    public void contacts_export_with_invalid_step(String Id,String Filter_Name, String Value, String status_code){
        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("stepId",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization", get_token.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameter, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_valid_search_parameter_data_provider")
    public Object[][] data_provider13() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("SEARCH_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_valid_search_parameter_data_provider")
    public void contacts_export_with_valid_search_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("search",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @Test
    public void contacts_export_with_blank_search_parameter()  {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("search","");

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @DataProvider(name = "contacts_export_with_valid_page_size_parameter_data_provider")
    public Object[][] data_provider15() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PAGE_SIZE_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_valid_page_size_parameter_data_provider")
    public void contacts_export_with_valid_page_size_parameter_data_provider(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "3639");

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("pageSize",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_page_size_data_provider")
    public Object[][] data_provider16() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PAGE_SIZE_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_invalid_page_size_data_provider")
    public void contacts_export_with_invalid_page_size_data_provider(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId", "3639");


        JSONObject queryParameter = new JSONObject();
        queryParameter.put("pageSize",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @DataProvider(name = "contacts_export_with_valid_page_num_parameter_data_provider")
    public Object[][] data_provider17() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PAGE_NUM_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_valid_page_num_parameter_data_provider")
    public void contacts_export_with_valid_page_num_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("pageNum",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_page_num_data_provider")
    public Object[][] data_provider18() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PAGE_NUM_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_invalid_page_num_data_provider")
    public void contacts_export_with_invalid_page_num_data_provider(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("pageNum",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_valid_include_all_fields_parameter_data_provider")
    public Object[][] data_provider19() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("INCLUDE_ALL_FIELDS_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_valid_include_all_fields_parameter_data_provider")
    public void contacts_export_with_valid_include_all_fields_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("includeAllFields",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_include_all_fields_data_provider")
    public Object[][] data_provider20() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("INCLUDE_ALL_FIELDS_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_invalid_include_all_fields_data_provider")
    public void contacts_export_with_invalid_include_all_fields(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("includeAllFields",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_valid_sort_order_parameter_data_provider")
    public Object[][] data_provider21() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Sort_Order_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_valid_sort_order_parameter_data_provider")
    public void contacts_export_with_valid_sort_order_parameter_data_provider(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("sortOrder",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_sort_order_parameter_data_provider")
    public Object[][] data_provider22() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Sort_Order_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_invalid_sort_order_parameter_data_provider")
    public void contacts_export_with_invalid_sort_order_parameter_data_provider(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("sortOrder",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_valid_sort_by_parameter_data_provider")
    public Object[][] data_provider23() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Sort_By_Contact_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_valid_sort_by_parameter_data_provider")
    public void contacts_export_with_valid_sort_by_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("sortBy",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_sort_by_parameter_data_provider")
    public Object[][] data_provider24() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Sort_By_Contact_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_invalid_sort_by_parameter_data_provider")
    public void contacts_export_with_invalid_sort_by_parameter_data_provider(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("sortBy",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_valid_tags_parameter_data_provider")
    public Object[][] data_provider25() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TAGS_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_valid_tags_parameter_data_provider")
    public void contacts_export_with_valid_tags_parameter_data_provider(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("tags",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_tags_parameter_data_provider")
    public Object[][] data_provider26() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TAGS_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_invalid_tags_parameter_data_provider")
    public void contacts_export_with_invalid_tags_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("tags",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_valid_sequences_parameter_data_provider")
    public Object[][] data_provider27() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TAGS_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_valid_sequences_parameter_data_provider")
    public void contacts_export_with_valid_sequences_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("sequences",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_sequences_parameter_data_provider")
    public Object[][] data_provider28() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TAGS_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "contacts_export_with_invalid_sequences_parameter_data_provider")
    public void contacts_export_with_invalid_sequences_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("sequences",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_valid_owners_parameter_data_provider")
    public Object[][] data_provider29() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TAGS_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_valid_owners_parameter_data_provider")
    public void contacts_export_with_valid_owners_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("owners",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_owners_parameter_data_provider")
    public Object[][] data_provider30() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TAGS_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_invalid_owners_parameter_data_provider")
    public void contacts_export_with_invalid_owners_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("sequences",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_valid_contact_id_parameter_data_provider")
    public Object[][] data_provider31() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TAGS_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_valid_contact_id_parameter_data_provider")
    public void contacts_export_with_valid_contact_id_parameter_data_provider(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("contactIds",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_contact_id_parameter_data_provider")
    public Object[][] data_provider32() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TAGS_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_invalid_contact_id_parameter_data_provider")
    public void contacts_export_with_invalid_contact_id_parameter_data_provider(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("contactIds",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_valid_created_date_parameter_data_provider")
    public Object[][] data_provider33() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("CREATED_DATE_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_valid_created_date_parameter_data_provider")
    public void contacts_export_with_valid_created_date_parameter_data_provider(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("createdDate",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "contacts_export_with_invalid_created_date_parameter_data_provider")
    public Object[][] data_provider34() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("CREATED_DATE_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "contacts_export_with_invalid_created_date_parameter_data_provider")
    public void contacts_export_with_invalid_created_date_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("createdDate",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void contacts_export_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @Test
    public void contacts_export_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        logs.test_step("------------------------------------------ GET THE CONTACT EXPORT TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contacts_export/contact_export_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

}
