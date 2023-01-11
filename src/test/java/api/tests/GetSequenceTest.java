package api.tests;

import api.requests.common.ExcelOperation.ExcelReader;
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

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.*;

public class GetSequenceTest extends base {
    @DataProvider(name = "get_sequence_with_valid_token")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Test_case.xlsx", 0);
        return data;
    }

    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN --------------------------------------------//

    @Test(dataProvider = "get_sequence_with_valid_token")
    public void get_sequence_with_valid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema){
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

        logs.test_step("------------------------------------------ GET THE SEQUENCE FOR ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

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

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE2--------------------------------------------");
        String update_file_role2 = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_valid_token", pathParameter1, queryParameters1, header1, body1);
        JSONObject response_role2 = builder.performRequest(update_file_role2);

        ResponseValidator validator1 = new ResponseValidator(response_role2);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator1.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator1.validateResponseTime((Long)response_role2.get("responseTime"));

        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
        try {
            validator1.validateSchema(Schema);
        }catch (Exception PathNotFoundException){}


        logs.test_step("------------------------------------------ VALIDATE ROLE1 SEQUENCE ID AND ROLE2 SEQUENCE ID --------------------------------------------");
        assertThat(new ArrayList<String>(Arrays.asList(validator.getDataFromBody("$.payload.sequences[*].id").split(","))).contains(new ArrayList<String>(Arrays.asList(validator1.getDataFromBody("$.payload.sequences[*].id").split(","))))).isFalse();

    }

    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN AND FREE PLAN TEST CASES --------------------------------------------//

    @DataProvider(name = "get_sequence_with_valid_token_with_free_plan")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Test_case.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_valid_token_with_free_plan")
    public void get_sequence_with_valid_token_with_free_plan(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();
        ExcelReader reader = new ExcelReader();
        DataReader reader_test = new DataReader();

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
        System.out.println(header);
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

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
        header1.put("Content_Type", Content_Type);

        JSONObject body1 = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE2--------------------------------------------");
        String update_file_role2 = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_valid_token", pathParameter1, queryParameters1, header1, body1);
        JSONObject response_role2 = builder.performRequest(update_file_role2);

        ResponseValidator validator1 = new ResponseValidator(response_role2);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator1.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator1.validateResponseTime((Long)response_role2.get("responseTime"));

        try {
            validator1.validateSchema(Schema);
        }catch (Exception PathNotFoundException){}


    }

    //---------------------------------- GET THE TEST DATA FOR INVALID TOKEN-------------------------------------------//

    @DataProvider(name = "get_sequence_with_invalid_token")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Test_case.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "get_sequence_with_invalid_token")
    public void get_sequence_with_invalid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {
        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjE4OTQsImlhdCI6MTY2MDc0MTk5NywiZXhwIjoxNjYzMzMzOTk3fQ.1uNPfk7_f45MCaGTIFJdtqYtCVrFhH4H1ZZCc7CSGUU" );
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_valid_token", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "get_sequence_with_blank_token")
    public Object[][] data_provider3() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Test_case.xlsx", 3);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_blank_token")
    public void get_sequence_with_blank_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "");
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_valid_token", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "get_sequence_with_expired_token")
    public Object[][] data_provider4() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Sequence_Test_case.xlsx", 4);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_expired_token")
    public void get_sequence_with_expired_token(String Token_Type,String Token, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",Token);
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_valid_token", pathParameter, queryParameters, header, body);
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


    @DataProvider(name = "get_sequence_with_progress_valid_parameter")
    public Object[][] data_provider5() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PROGRESS_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_progress_valid_parameter")
    public void get_sequence_with_progress_valid_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("progress",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_progress_invalid_parameter")
    public Object[][] data_provider6() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PROGRESS_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_progress_invalid_parameter")
    public void get_sequence_with_progress_invalid_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("progress",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_valid_search_parameter_data_provider")
    public Object[][] data_provider7() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("SEARCH_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_valid_search_parameter_data_provider")
    public void get_sequence_with_valid_search_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

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

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void get_sequence_with_blank_search_parameter()  {

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

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_valid_owner_parameter_data_provider")
    public Object[][] data_provider9() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("OWNER_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_valid_owner_parameter_data_provider")
    public void get_sequence_with_valid_owner_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

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

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_invalid_owners_parameter_data_provider")
    public Object[][] data_provider10() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("OWNER_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_invalid_owners_parameter_data_provider")
    public void get_sequence_with_invalid_owners_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

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

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_valid_sortBy_parameter_data_provider")
    public Object[][] data_provider11() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("SORT_BY_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_valid_sortBy_parameter_data_provider")
    public void get_sequence_with_valid_sortBy_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

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

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_invalid_sortBy_parameter_data_provider")
    public Object[][] data_provider12() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("SORT_BY_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_invalid_sortBy_parameter_data_provider")
    public void get_sequence_with_invalid_sortBy_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("sortBY",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void get_sequence_with_blank_sortBy_parameter()  {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("sortBy","");

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_valid_order_parameter_data_provider")
    public Object[][] data_provider13() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Order_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_valid_order_parameter_data_provider")
    public void get_sequence_with_valid_order_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("order",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_invalid_order_parameter_data_provider")
    public Object[][] data_provider14() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Order_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_invalid_order_parameter_data_provider")
    public void get_sequence_with_invalid_order_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("order",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void get_sequence_with_blank_order_parameter()  {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("order","");

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @DataProvider(name = "get_sequence_with_valid_page_parameter_data_provider")
    public Object[][] data_provider15() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PAGE_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_valid_page_parameter_data_provider")
    public void get_sequence_with_valid_page_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("page",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_invalid_page_parameter_data_provider")
    public Object[][] data_provider16() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PAGE_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_invalid_page_parameter_data_provider")
    public void get_sequence_with_invalid_page_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("page",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void get_sequence_with_blank_page_parameter()  {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("page","");

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_valid_limit_parameter_data_provider")
    public Object[][] data_provider17() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("LIMIT_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_valid_limit_parameter_data_provider")
    public void get_sequence_with_valid_limit_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("limit",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_invalid_limit_parameter_data_provider")
    public Object[][] data_provider18() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("LIMIT_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_invalid_limit_parameter_data_provider")
    public void get_sequence_with_invalid_limit_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("page",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void get_sequence_with_blank_limit_parameter()  {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("limit","");

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_valid_pause_reason_parameter_data_provider")
    public Object[][] data_provider19() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PAUSE_REASON_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_valid_pause_reason_parameter_data_provider")
    public void get_sequence_with_valid_pause_reason_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("pausedReasonIdentifiers",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_invalid_pause_reason_parameter_data_provider")
    public Object[][] data_provider20() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PAUSE_REASON_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_invalid_pause_reason_parameter_data_provider")
    public void get_sequence_with_invalid_pause_reason_parameter_data_provider(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("pausedReasonIdentifiers",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_valid_number_of_step_parameter_data_provider")
    public Object[][] data_provider21() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Number_of_step_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_valid_number_of_step_parameter_data_provider")
    public void get_sequence_with_valid_number_of_step_parameter_data_provider(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("numberOfSteps",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "get_sequence_with_invalid_number_of_step_parameter_data_provider")
    public Object[][] data_provider22() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Number_of_step_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "get_sequence_with_invalid_number_of_step_parameter_data_provider")
    public void get_sequence_with_invalid_number_of_step_parameter(String Id,String Filter_Name, String Value, String status_code) throws FilloException {

        testng_logs logs = new testng_logs();

        RequestBuilder builder = new RequestBuilder();
        TokenUtility get_token = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameter = new JSONObject();
        queryParameter.put("numberOfSteps",Value);

        JSONObject header = new JSONObject();
        header.put("Authorization",get_token.getTokenFromUser());
        header.put("Content_type","application/json");

        JSONObject body = new JSONObject();

        logs.test_step("------------------------------------------ GET THE SEQUENCE FROM ROLE1--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_progress_valid_parameter",pathParameter,queryParameter,header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void get_sequence_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");

        logs.test_step("------------------------------------------GET THE SEQUENCE--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_valid_token", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @Test
    public void get_sequence_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        logs.test_step("------------------------------------------GET THE SEQUENCE--------------------------------------------");
        String update_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }



}
