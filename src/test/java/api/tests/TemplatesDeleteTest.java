package api.tests;

import api.requests.common.ExcelOperation.ExcelReader;
import api.requests.common.TemplateUtility.TemplateUtility;
import api.requests.common.TokenUtility.TokenUtility;
import com.codoid.products.exception.FilloException;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TemplatesDeleteTest extends base {


    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN --------------------------------------------//
    @DataProvider(name = "templates_delete_with_valid_token")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Template_Delete_Test_case.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "templates_delete_with_valid_token")
    public void templates_delete_with_valid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) throws FilloException {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        ExcelReader reader = new ExcelReader();
        TemplateUtility template_utils=new TemplateUtility();

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

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE2 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1",params1,"Token"));
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();

        logs.test_step("----------------------------------------- GET THE TEMPLATE ID FROM ROLE1 --------------------------------------------");
        JSONArray body_array= new JSONArray();
        body_array.put((template_utils.getTemplateId(reader.getRecordsSet("Credential.xlsx","Sheet1",params))));

        body.put("ids",body_array);

        logs.test_step("------------------------------------------ TEMPLATE DELETE TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("templates/template_delete/template_delete", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(201);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
        
try{
validator.validateSchema(Schema);}
  catch(Exception PathNotFoundException){}
    }

    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN AND FREE PLAN TEST CASES --------------------------------------------//

    @DataProvider(name = "templates_delete_with_valid_token_free_plan")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Template_Delete_Test_case.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "templates_delete_with_valid_token_free_plan")
    public void templates_delete_with_valid_token_free_plan(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        ExcelReader reader = new ExcelReader();


        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role2);
        params1.put("SHaccount1", SHaccount2);

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1",params1,"Token"));
        header.put("content-type", "application/json");

        JSONArray body_array = new JSONArray();
        body_array.put(3637);

        JSONObject body = new JSONObject();
        body.put("ids",body_array);

        logs.test_step("------------------------------------------ TEMPLATE DELETE TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("templates/template_delete/template_delete", pathParameter, queryParameters, header, body);
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
    @DataProvider(name = "templates_delete_with_invalid_token")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Template_Delete_Test_case.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "templates_delete_with_invalid_token")
    public void templates_delete_with_invalid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role1);
        params1.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9");
        header.put("content-type", "application/json");

        JSONArray body_array = new JSONArray();
        body_array.put(3637);

        JSONObject body = new JSONObject();
        body.put("ids",body_array);

        logs.test_step("------------------------------------------ TEMPLATE DELETE TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("templates/template_delete/template_delete", pathParameter, queryParameters, header, body);
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

    //---------------------------------- GET THE TEST DATA FOR BLANK TOKEN------------------------------------------//
    @DataProvider(name = "templates_delete_with_blank_token")
    public Object[][] data_provider4() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Template_Delete_Test_case.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "templates_delete_with_blank_token")
    public void templates_delete_with_blank_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role1);
        params1.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "");
        header.put("content-type", "application/json");

        JSONArray body_array = new JSONArray();
        body_array.put(3637);

        JSONObject body = new JSONObject();
        body.put("ids",body_array);

        logs.test_step("------------------------------------------ TEMPLATE DELETE TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("templates/template_delete/template_delete", pathParameter, queryParameters, header, body);
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

    //---------------------------------- GET THE TEST DATA FOR EXPIRED TOKEN------------------------------------------//
    @DataProvider(name = "templates_delete_with_expired_token_data_provider")
    public Object[][] data_provider5() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Template_Delete_Test_case.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "templates_delete_with_expired_token_data_provider")
    public void templates_delete_with_expired_token(String Token_Type,String Token, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role1);
        params1.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",Token);
        header.put("content-type", "application/json");

        JSONArray body_array = new JSONArray();
        body_array.put(3637);

        JSONObject body = new JSONObject();
        body.put("ids",body_array);

        logs.test_step("------------------------------------------ TEMPLATE DELETE TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("templates/template_delete/template_delete", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "templates_delete_with_different_template_id_data_provider")
    public Object[][] data_provider6() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("TemplateID_Functional_TEST_CASE.xlsx", 1);
        return data;
    }
    @Test(dataProvider ="templates_delete_with_different_template_id_data_provider")
    public void templates_delete_with_different_template_id(String Id,String Filter_Name, String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONArray body_array = new JSONArray();
        body_array.put(Integer.parseInt(Value));

        JSONObject body = new JSONObject();
        body.put("ids",body_array);


        logs.test_step("------------------------------------------ TEMPLATE DELETE TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("templates/template_delete/template_delete", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void templates_delete_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONArray body_array = new JSONArray();
        body_array.put(3637);

        JSONObject body = new JSONObject();
        body.put("ids",body_array);


        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE2 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");


        logs.test_step("------------------------------------------ TEMPLATE DELETE TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("templates/template_delete/template_delete", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @Test
    public void templates_delete_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        logs.test_step("----------------------------------------- GET THE SEQUENCE FROM ROLE1 --------------------------------------------");
        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONArray body_array = new JSONArray();
        body_array.put(3637);

        JSONObject body = new JSONObject();
        body.put("ids",body_array);

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE2 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");


        logs.test_step("------------------------------------------ TEMPLATE DELETE TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("templates/template_delete/template_delete_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

}