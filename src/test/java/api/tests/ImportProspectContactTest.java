package api.tests;

import api.requests.common.ExcelOperation.ExcelReader;
import api.requests.common.ScheduleUtility.ScheduleUtility;
import api.requests.common.SequenceUtility.SequenceUtility;
import api.requests.common.TokenUtility.TokenUtility;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class ImportProspectContactTest extends base {


    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN --------------------------------------------//

    @DataProvider(name = "import_prospect_contact_with_valid_token")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Import_Contact_Test_case.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "import_prospect_contact_with_valid_token")
    public void import_prospect_contact_with_valid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema){
        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        ExcelReader reader = new ExcelReader();
        ScheduleUtility schedule_id  = new ScheduleUtility();

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
        pathParameter.put("stepId", schedule_id.getScheduleId(reader.getRecordsSet("Credential.xlsx","Sheet1",params1)));

        JSONObject queryParameters = new JSONObject();

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE1 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1",params,"Token"));
        header.put("Content-Type", "multipart/form-data");

        JSONObject body = new JSONObject();
        body.put("file","src\\test\\java\\data\\sh-sample-csv.csv");
        body.put("mapConfig","{\"0\":23269,\"1\":23270,\"2\":23271,\"10\":23273,\"11\":23277,\"12\":23279,\"13\":23272,\"15\":23276,\"16\":23281,\"17\":23282,\"18\":23283,\"19\":23274,\"20\":23278,\"21\":23275}");
        body.put("conflictAction","addMissingFields");
        body.put("includeRiskyContacts",0);
        body.put("verifyContacts",1);


        logs.test_step("------------------------------------------ IMPORT THE PROSPECT --------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contact_prospect_import/contact_prospect_import", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "import_prospect_contact_with_valid_token_free_plan")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Import_Contact_Test_case.xlsx", 1);
        return data;
    }


    @Test(dataProvider = "import_prospect_contact_with_valid_token_free_plan")
    public void import_prospect_contact_with_valid_token_free_plan(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) {

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

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("stepId", "4556");

        JSONObject queryParameters = new JSONObject();

        logs.test_step("----------------------------------------- GET THE TOKEN FROM ROLE1 --------------------------------------------");
        JSONObject header = new JSONObject();
        header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1",params1,"Token"));
        header.put("Content-Type", "multipart/form-data");

        JSONObject body = new JSONObject();
        body.put("file","src\\test\\java\\data\\sh-sample-csv.csv");
        body.put("mapConfig","{\"0\":23269,\"1\":23270,\"2\":23271,\"10\":23273,\"11\":23277,\"12\":23279,\"13\":23272,\"15\":23276,\"16\":23281,\"17\":23282,\"18\":23283,\"19\":23274,\"20\":23278,\"21\":23275}");
        body.put("conflictAction","addMissingFields");
        body.put("includeRiskyContacts",0);
        body.put("verifyContacts",1);

        logs.test_step("------------------------------------------IMPORT THE PROSPECT--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contact_prospect_import/contact_prospect_import", pathParameter, queryParameters, header, body);
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
    @DataProvider(name = "import_prospect_contact_with_invalid_token")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Import_Contact_Test_case.xlsx", 2);
        return data;
    }


    @Test(dataProvider = "import_prospect_contact_with_invalid_token")
    public void import_prospect_contact_with_invalid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role1);
        params1.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("stepId", "4556");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9");
        header.put("Content-Type", "multipart/form-data");

        JSONObject body = new JSONObject();
        body.put("file","src\\test\\java\\data\\sh-sample-csv.csv");
        body.put("mapConfig","{\"0\":23269,\"1\":23270,\"2\":23271,\"10\":23273,\"11\":23277,\"12\":23279,\"13\":23272,\"15\":23276,\"16\":23281,\"17\":23282,\"18\":23283,\"19\":23274,\"20\":23278,\"21\":23275}");
        body.put("conflictAction","addMissingFields");
        body.put("includeRiskyContacts",0);
        body.put("verifyContacts",1);

        logs.test_step("------------------------------------------IMPORT THE PROSPECT--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contact_prospect_import/contact_prospect_import", pathParameter, queryParameters, header, body);
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
    @DataProvider(name = "import_prospect_contact_with_blank_token")
    public Object[][] data_provider4() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Clone_Sequence_Test_case.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "import_prospect_contact_with_blank_token")
    public void import_prospect_contact_with_blank_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role1);
        params1.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("stepId", "4566");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "");
        header.put("Content-Type", "multipart/form-data");

        JSONObject body = new JSONObject();
        body.put("file","src\\test\\java\\data\\sh-sample-csv.csv");
        body.put("mapConfig","{\"0\":23269,\"1\":23270,\"2\":23271,\"10\":23273,\"11\":23277,\"12\":23279,\"13\":23272,\"15\":23276,\"16\":23281,\"17\":23282,\"18\":23283,\"19\":23274,\"20\":23278,\"21\":23275}");
        body.put("conflictAction","addMissingFields");
        body.put("includeRiskyContacts",0);
        body.put("verifyContacts",1);

        logs.test_step("------------------------------------------IMPORT THE PROSPECT--------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contact_prospect_import/contact_prospect_import", pathParameter, queryParameters, header, body);
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
    @DataProvider(name = "import_prospect_contact_with_expired_token_data_provider")
    public Object[][] data_provider5() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Import_Contact_Test_case.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "import_prospect_contact_with_expired_token_data_provider")
    public void import_prospect_contact_with_expired_token_data_provider(String Token_Type,String Token, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params1 = new HashMap();
        params1.put("Subscription_State", Subscription_State);
        params1.put("Plan", Plan);
        params1.put("Role", Role1);
        params1.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("stepId", "4566");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",Token);
        header.put("Content-Type", "multipart/form-data");

        JSONObject body = new JSONObject();
        body.put("file","src\\test\\java\\data\\sh-sample-csv.csv");
        body.put("mapConfig","{\"0\":23269,\"1\":23270,\"2\":23271,\"10\":23273,\"11\":23277,\"12\":23279,\"13\":23272,\"15\":23276,\"16\":23281,\"17\":23282,\"18\":23283,\"19\":23274,\"20\":23278,\"21\":23275}");
        body.put("conflictAction","addMissingFields");
        body.put("includeRiskyContacts",0);
        body.put("verifyContacts",1);

        logs.test_step("------------------------------------------ IMPORT THE PROSPECT --------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contact_prospect_import/contact_prospect_import", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "import_prospect_contact_with_different_step_id_data_provider")
    public Object[][] data_provider6() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Sequence_Path_Parameter_TEST_CASE.xlsx", 0);
        return data;
    }
    @Test(dataProvider ="import_prospect_contact_with_different_step_id_data_provider")
    public void import_prospect_contact_with_different_step_id(String Id,String Filter_Name, String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("stepId", Value);

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("Content-Type", "multipart/form-data");

        JSONObject body = new JSONObject();
        body.put("file","src\\test\\java\\data\\sh-sample-csv.csv");
        body.put("mapConfig","{\"0\":23269,\"1\":23270,\"2\":23271,\"10\":23273,\"11\":23277,\"12\":23279,\"13\":23272,\"15\":23276,\"16\":23281,\"17\":23282,\"18\":23283,\"19\":23274,\"20\":23278,\"21\":23275}");
        body.put("conflictAction","addMissingFields");
        body.put("includeRiskyContacts",0);
        body.put("verifyContacts",1);

        logs.test_step("------------------------------------------ IMPORT THE PROSPECT --------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contact_prospect_import/contact_prospect_import", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }



    @DataProvider(name = "import_prospect_contact_with_invalid_file")
    public Object[][] data_provider7() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Import_contact_invalid_body_test_case.xlsx", 0);
        return data;
    }
    @Test(dataProvider ="import_prospect_contact_with_invalid_file")
    public void import_prospect_contact_with_invalid_file(String Id,String Filter_Name, String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("stepId", "4556");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("Content-Type", "multipart/form-data");

        JSONObject body = new JSONObject();
        body.put("file",Value);
        body.put("mapConfig","{\"0\":23269,\"1\":23270,\"2\":23271,\"10\":23273,\"11\":23277,\"12\":23279,\"13\":23272,\"15\":23276,\"16\":23281,\"17\":23282,\"18\":23283,\"19\":23274,\"20\":23278,\"21\":23275}");
        body.put("conflictAction","addMissingFields");
        body.put("includeRiskyContacts",0);
        body.put("verifyContacts",1);

        logs.test_step("------------------------------------------ IMPORT THE PROSPECT --------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contact_prospect_import/contact_prospect_import", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "import_prospect_contact_with_invalid_map_config")
    public Object[][] data_provider8() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Import_contact_invalid_body_test_case.xlsx", 0);
        return data;
    }
    @Test(dataProvider ="import_prospect_contact_with_invalid_map_config")
    public void import_prospect_contact_with_invalid_map_config(String Id,String Filter_Name, String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("stepId", "4556");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("Content-Type", "multipart/form-data");

        JSONObject body = new JSONObject();
        body.put("file","src\\test\\java\\data\\sh-sample-csv.csv");
        body.put("mapConfig",Value);
        body.put("conflictAction","addMissingFields");
        body.put("includeRiskyContacts",0);
        body.put("verifyContacts",1);

        logs.test_step("------------------------------------------ IMPORT THE PROSPECT --------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contact_prospect_import/contact_prospect_import", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "import_prospect_contact_with_invalid_conflict_action")
    public Object[][] data_provider9() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Import_contact_invalid_body_test_case.xlsx", 0);
        return data;
    }
    @Test(dataProvider ="import_prospect_contact_with_invalid_conflict_action")
    public void import_prospect_contact_with_invalid_conflict_action(String Id,String Filter_Name, String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("stepId", "4556");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("Content-Type", "multipart/form-data");

        JSONObject body = new JSONObject();
        body.put("file","src\\test\\java\\data\\sh-sample-csv.csv");
        body.put("mapConfig","{\"0\":23269,\"1\":23270,\"2\":23271,\"10\":23273,\"11\":23277,\"12\":23279,\"13\":23272,\"15\":23276,\"16\":23281,\"17\":23282,\"18\":23283,\"19\":23274,\"20\":23278,\"21\":23275}");
        body.put("conflictAction",Value);
        body.put("includeRiskyContacts",0);
        body.put("verifyContacts",1);

        logs.test_step("------------------------------------------ IMPORT THE PROSPECT --------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contact_prospect_import/contact_prospect_import", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }
    @DataProvider(name = "import_prospect_contact_with_invalid_include_risky_contacts")
    public Object[][] data_provider10() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Import_contact_invalid_body_test_case.xlsx", 0);
        return data;
    }
    @Test(dataProvider ="import_prospect_contact_with_invalid_include_risky_contacts")
    public void import_prospect_contact_with_invalid_include_risky_contacts(String Id,String Filter_Name, String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("stepId", "4556");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("Content-Type", "multipart/form-data");

        JSONObject body = new JSONObject();
        body.put("file","src\\test\\java\\data\\sh-sample-csv.csv");
        body.put("mapConfig","{\"0\":23269,\"1\":23270,\"2\":23271,\"10\":23273,\"11\":23277,\"12\":23279,\"13\":23272,\"15\":23276,\"16\":23281,\"17\":23282,\"18\":23283,\"19\":23274,\"20\":23278,\"21\":23275}");
        body.put("conflictAction","addMissingFields");
        body.put("includeRiskyContacts",Value);
        body.put("verifyContacts",1);

        logs.test_step("------------------------------------------ IMPORT THE PROSPECT --------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contact_prospect_import/contact_prospect_import", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "import_prospect_contact_with_invalid_verify_contacts")
    public Object[][] data_provider11() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Import_contact_invalid_body_test_case.xlsx", 0);
        return data;
    }
    @Test(dataProvider ="import_prospect_contact_with_invalid_verify_contacts")
    public void import_prospect_contact_with_invalid_verify_contacts(String Id,String Filter_Name, String Value, String status_code) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("stepId", "4556");

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("Content-Type", "multipart/form-data");

        JSONObject body = new JSONObject();
        body.put("file","src\\test\\java\\data\\sh-sample-csv.csv");
        body.put("mapConfig","{\"0\":23269,\"1\":23270,\"2\":23271,\"10\":23273,\"11\":23277,\"12\":23279,\"13\":23272,\"15\":23276,\"16\":23281,\"17\":23282,\"18\":23283,\"19\":23274,\"20\":23278,\"21\":23275}");
        body.put("conflictAction","addMissingFields");
        body.put("includeRiskyContacts",0);
        body.put("verifyContacts",Value);

        logs.test_step("------------------------------------------ IMPORT THE PROSPECT --------------------------------------------");
        String update_file = builder.updateRequestObject("contacts/contact_prospect_import/contact_prospect_import", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void import_prospect_contact_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("stepId", "4566");
        JSONObject queryParameters = new JSONObject();

        JSONObject body = new JSONObject();
        body.put("file","src\\test\\java\\data\\sh-sample-csv.csv");
        body.put("mapConfig","{\"0\":23269,\"1\":23270,\"2\":23271,\"10\":23273,\"11\":23277,\"12\":23279,\"13\":23272,\"15\":23276,\"16\":23281,\"17\":23282,\"18\":23283,\"19\":23274,\"20\":23278,\"21\":23275}");
        body.put("conflictAction","addMissingFields");
        body.put("includeRiskyContacts",0);
        body.put("verifyContacts",1);

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");

        String update_file = builder.updateRequestObject("contacts/contact_prospect_import/contact_prospect_import", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @Test
    public void import_prospect_contact_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("stepId", "4566");
        JSONObject queryParameters = new JSONObject();

        JSONObject body = new JSONObject();
        body.put("file","src\\test\\java\\data\\sh-sample-csv.csv");
        body.put("mapConfig","{\"0\":23269,\"1\":23270,\"2\":23271,\"10\":23273,\"11\":23277,\"12\":23279,\"13\":23272,\"15\":23276,\"16\":23281,\"17\":23282,\"18\":23283,\"19\":23274,\"20\":23278,\"21\":23275}");
        body.put("conflictAction","addMissingFields");
        body.put("includeRiskyContacts",0);
        body.put("verifyContacts",1);

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        String update_file = builder.updateRequestObject("contacts/contact_prospect_import/contact_prospect_import_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


}
