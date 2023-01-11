package api.tests;

import api.requests.common.ExcelOperation.ExcelReader;
import api.requests.common.TokenUtility.TokenUtility;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class GetCouponCodeValidateTest extends base {

    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN--------------------------------------------//

    @DataProvider(name = "get_coupon_code_validate_with_valid_token")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Coupon_Code_Validate_Test_case.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "get_coupon_code_validate_with_valid_token")
    public void get_coupon_code_validate_with_valid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) throws ParseException {

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
        pathParameter.put("code","V3TEST20");

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("planId",19);
        queryParameters.put("amount",29);

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE1 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getToken(reader.getRecordsSet("Credential.xlsx","Sheet1",params)));
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET COUPON CODE VALIDATE TEST---------------------------------------");
        String update_file = builder.updateRequestObject("Subscription/coupon_code_validate/get_coupon_code_validate", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "get_coupon_code_validate_with_valid_token_with_free_plan")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Coupon_Code_Validate_Test_case.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "get_coupon_code_validate_with_valid_token_with_free_plan")
    public void get_coupon_code_validate_with_valid_token_with_free_plan(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) {

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
        pathParameter.put("code","V3TEST20");

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("planId",19);
        queryParameters.put("amount",29);

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE1 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1",params,"Token"));
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET EMAIL ACCOUNT SETTINGS ACCOUNT ID------------------------------------");
        String update_file = builder.updateRequestObject("Subscription/coupon_code_validate/get_coupon_code_validate", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "get_coupon_code_validate_with_invalid_token")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Coupon_Code_Validate_Test_case.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "get_coupon_code_validate_with_invalid_token")
    public void get_coupon_code_validate_with_invalid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("code","V3TEST20");

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("planId",19);
        queryParameters.put("amount",29);

        JSONObject header = new JSONObject();
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjE4OTQsImlhdCI6MTY2MDc0MTk5NywiZXhwIjoxNjYzMzMzOTk3fQ.1uNPfk7_f45MCaGTIFJdtqYtCVrFhH4H1ZZCc7CSGUU" );
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET COUPON CODE VALIDATE TEST---------------------------------------");
        String update_file = builder.updateRequestObject("Subscription/coupon_code_validate/get_coupon_code_validate", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "get_coupon_code_validate_with_blank_token")
    public Object[][] data_provider3() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Coupon_Code_Validate_Test_case.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "get_coupon_code_validate_with_blank_token")
    public void get_coupon_code_validate_with_blank_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("code","V3TEST20");

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("planId",19);
        queryParameters.put("amount",29);

        JSONObject header = new JSONObject();
        header.put("Authorization", "");
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET COUPON CODE VALIDATE TEST---------------------------------------");
        String update_file = builder.updateRequestObject("Subscription/coupon_code_validate/get_coupon_code_validate", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "get_coupon_code_validate_with_expired_token_data_provider")
    public Object[][] data_provider4() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Get_Coupon_Code_Validate_Test_case.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "get_coupon_code_validate_with_expired_token_data_provider")
    public void get_coupon_code_validate_with_expired_token(String Token_Type,String Token, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("code","V3TEST20");

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("planId",19);
        queryParameters.put("amount",29);

        JSONObject header = new JSONObject();
        header.put("Authorization",Token);
        header.put("content-type", Content_Type);

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET COUPON CODE VALIDATE TEST---------------------------------------");
        String update_file = builder.updateRequestObject("Subscription/coupon_code_validate/get_coupon_code_validate", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "get_coupon_code_validate_with_different_code")
    public Object[][] data_provider5() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Subscription_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "get_coupon_code_validate_with_different_code")
    public void get_coupon_code_validate_with_different_code(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("code",Value);

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("planId",19);
        queryParameters.put("amount",29);

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET COUPON CODE VALIDATE TEST---------------------------------------");
        String update_file = builder.updateRequestObject("Subscription/coupon_code_validate/get_coupon_code_validate", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @DataProvider(name = "get_coupon_code_validate_with_different_planId")
    public Object[][] data_provider6() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Subscription_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "get_coupon_code_validate_with_different_planId")
    public void get_coupon_code_validate_with_different_planId(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("code","V3TEST20");

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("planId",Value);
        queryParameters.put("amount",29);

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET COUPON CODE VALIDATE TEST---------------------------------------");
        String update_file = builder.updateRequestObject("Subscription/coupon_code_validate/get_coupon_code_validate", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @DataProvider(name = "get_coupon_code_validate_with_different_amount")
    public Object[][] data_provider7() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Subscription_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "get_coupon_code_validate_with_different_amount")
    public void get_coupon_code_validate_with_different_amount(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("code","V3TEST20");

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("planId",19);
        queryParameters.put("amount",29);

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("-------------------------------------- GET COUPON CODE VALIDATE TEST---------------------------------------");
        String update_file = builder.updateRequestObject("Subscription/coupon_code_validate/get_coupon_code_validate", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(200);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }


    @Test
    public void get_coupon_code_validate_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("code","V3TEST20");

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("planId",19);
        queryParameters.put("amount",29);
        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");

        logs.test_step("-------------------------------------- GET COUPON CODE VALIDATE TEST---------------------------------------");
        String update_file = builder.updateRequestObject("Subscription/coupon_code_validate/get_coupon_code_validate", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @Test
    public void get_coupon_code_validate_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("code","V3TEST20");

        JSONObject queryParameters = new JSONObject();
        queryParameters.put("planId",19);
        queryParameters.put("amount",29);

        JSONObject body = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        logs.test_step("-------------------------------------- GET COUPON CODE VALIDATE TEST---------------------------------------");
        String update_file = builder.updateRequestObject("Subscription/coupon_code_validate/get_coupon_code_validate_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

}
