package api.tests;

import api.requests.common.ExcelOperation.ExcelReader;
import api.requests.common.SequenceUtility.SequenceUtility;
import api.requests.common.TokenUtility.TokenUtility;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.framework.readers.json_file_reader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import io.unity.performaction.autoweb.testng_logs;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class ReportsSequenceStatsTest extends base {

    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN--------------------------------------------//

    @DataProvider(name = "reports_sequence_stats_with_valid_token")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Reports_Sequence_Stats_Test_Case.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "reports_sequence_stats_with_valid_token")
    public void reports_sequence_stats_with_valid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) throws ParseException {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        ExcelReader reader = new ExcelReader();
        SequenceUtility sequence_utils =new SequenceUtility();

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
        header.put("content-type", Content_Type);

        logs.test_step("----------------------------------------- GET THE SEQUENCE FROM ROLE1 --------------------------------------------");
        JSONArray body_array= new JSONArray();
        body_array.put(parseInt(sequence_utils.getSequenceId(reader.getRecordsSet("Credential.xlsx","Sheet1",params))));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-11-16T00:00:00.000+05:30");
        body.put("endDate", "2022-11-16T12:40:01.859+05:30");
        body.put("limit","25");
        body.put("page","0");
        body.put("orderBy","sequenceCreatedAt");
        body.put("sortOrder","desc");


        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "reports_sequence_stats_with_valid_token_free_plan")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Reports_Sequence_Stats_Test_Case.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "reports_sequence_stats_with_valid_token_free_plan")
    public void reports_sequence_stats_with_valid_token_free_plan(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String SHaccount2, String Ownership, String Role2, String Status_Code, String Schema) {

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
        header.put("content-type", "application/json");

        JSONArray body_array= new JSONArray();
        body_array.put(parseInt("1467"));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-11-16T00:00:00.000+05:30");
        body.put("endDate", "2022-11-16T12:40:01.859+05:30");
        body.put("limit","25");
        body.put("page","0");
        body.put("orderBy","sequenceCreatedAt");
        body.put("sortOrder","desc");

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String response = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
        JSONObject response1 = builder.performRequest(response);

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

    //---------------------------------- GET THE TEST DATA FOR INVALID TOKEN-------------------------------------------//

    @DataProvider(name = "reports_sequence_stats_with_invalid_token")
    public Object[][] data_provider2() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Reports_Sequence_Stats_Test_Case.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "reports_sequence_stats_with_invalid_token")
    public void reports_sequence_stats_with_invalid_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjE4OTQsImlhdCI6MTY2MDc0MTk5NywiZXhwIjoxNjYzMzMzOTk3fQ.1uNPfk7_f45MCaGTIFJdtqYtCVrFhH4H1ZZCc7CSGUU" );
        header.put("content-type", Content_Type);

        JSONArray body_array= new JSONArray();
        body_array.put(parseInt("1467"));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-08-09T16:39:45.000+05:30");
        body.put("endDate", "2022-08-09T16:39:45.000+05:30");
        body.put("limit","25");
        body.put("page","0");
        body.put("orderBy","sequenceCreatedAt");
        body.put("sortOrder","desc");

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "reports_sequence_stats_with_blank_token")
    public Object[][] data_provider3() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Reports_Sequence_Stats_Test_Case.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "reports_sequence_stats_with_blank_token")
    public void reports_sequence_stats_with_blank_token(String Token_Type, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", "");
        header.put("content-type", Content_Type);

        JSONArray body_array= new JSONArray();
        body_array.put(parseInt("1467"));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-08-09T16:39:45.000+05:30");
        body.put("endDate", "2022-08-09T16:39:45.000+05:30");
        body.put("limit","25");
        body.put("page","0");
        body.put("orderBy","sequenceCreatedAt");
        body.put("sortOrder","desc");

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file= builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "reports_sequence_stats_with_expired_token")
    public Object[][] data_provider4() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Reports_Sequence_Stats_Test_Case.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "reports_sequence_stats_with_expired_token")
    public void reports_sequence_stats_with_expired_token(String Token_Type,String Token, String Content_Type, String Subscription_State, String Plan, String Role1, String SHaccount1, String Ownership, String Status_Code, String Schema) {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        Map params = new HashMap();
        params.put("Subscription_State", Subscription_State);
        params.put("Plan", Plan);
        params.put("Role", Role1);
        params.put("SHaccount1", SHaccount1);

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",Token);
        header.put("content-type", Content_Type);

        JSONArray body_array= new JSONArray();
        body_array.put(parseInt("1467"));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-08-09T16:39:45.000+05:30");
        body.put("endDate", "2022-08-09T16:39:45.000+05:30");
        body.put("limit","25");
        body.put("page","0");
        body.put("orderBy","sequenceCreatedAt");
        body.put("sortOrder","desc");

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
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

    @DataProvider(name = "reports_sequence_stats_with_different_sequence_id")
    public Object[][] data_provider5() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Sequence_Path_Parameter_TEST_CASE.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "reports_sequence_stats_with_different_sequence_id")
    public void reports_sequence_stats_with_different_sequence_id(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONArray body_array= new JSONArray();
        body_array.put(Value);

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-08-09T16:39:45.000+05:30");
        body.put("endDate", "2022-08-09T16:39:45.000+05:30");
        body.put("limit","25");
        body.put("page","0");
        body.put("orderBy","sequenceCreatedAt");
        body.put("sortOrder","desc");

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @DataProvider(name = "reports_sequence_stats_with_different_startDate")
    public Object[][] data_provider6() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Date_Functional_TEST_CASE.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "reports_sequence_stats_with_different_startDate")
    public void reports_sequence_stats_with_different_startDate(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONArray body_array= new JSONArray();
        body_array.put(parseInt("1467"));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", Value);
        body.put("endDate", "2022-08-09T16:39:45.000+05:30");
        body.put("limit","25");
        body.put("page","0");
        body.put("orderBy","sequenceCreatedAt");
        body.put("sortOrder","desc");

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }
    @DataProvider(name = "reports_sequence_stats_with_different_endDate")
    public Object[][] data_provider7() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Date_Functional_TEST_CASE.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "reports_sequence_stats_with_different_endDate")
    public void reports_sequence_stats_with_different_endDate(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONArray body_array= new JSONArray();
        body_array.put(parseInt("1467"));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-08-09T16:39:45.000+05:30");
        body.put("endDate", Value);
        body.put("limit","25");
        body.put("page","0");
        body.put("orderBy","sequenceCreatedAt");
        body.put("sortOrder","desc");

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @DataProvider(name = "reports_sequence_stats_with_different_limit")
    public Object[][] data_provider8() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("LIMIT_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }
    @Test(dataProvider = "reports_sequence_stats_with_different_limit")
    public void reports_sequence_stats_with_different_limit(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONArray body_array= new JSONArray();
        body_array.put(parseInt("1467"));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-08-09T16:39:45.000+05:30");
        body.put("endDate", "2022-08-09T16:39:45.000+05:30");
        body.put("limit",Value);
        body.put("page","0");
        body.put("orderBy","sequenceCreatedAt");
        body.put("sortOrder","desc");

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @DataProvider(name = "reports_sequence_stats_with_different_page")
    public Object[][] data_provider9() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("PAGE_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }
    @Test(dataProvider = "reports_sequence_stats_with_different_page")
    public void reports_sequence_stats_with_different_page(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONArray body_array= new JSONArray();
        body_array.put(parseInt("1467"));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-08-09T16:39:45.000+05:30");
        body.put("endDate", "2022-08-09T16:39:45.000+05:30");
        body.put("limit","25");
        body.put("page",Value);
        body.put("orderBy","sequenceCreatedAt");
        body.put("sortOrder","desc");

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @DataProvider(name = "reports_sequence_stats_with_different_orderBy")
    public Object[][] data_provider10() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Report_Sequence_Functional_TEST_CASE.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "reports_sequence_stats_with_different_orderBy")
    public void reports_sequence_stats_with_different_orderBy(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONArray body_array= new JSONArray();
        body_array.put(parseInt("1467"));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-08-09T16:39:45.000+05:30");
        body.put("endDate", "2022-08-09T16:39:45.000+05:30");
        body.put("limit","25");
        body.put("page","0");
        body.put("orderBy","sequenceCreatedAt");
        body.put("sortOrder","desc");

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }
    @DataProvider(name = "reports_sequence_stats_with_valid_sortOrder")
    public Object[][] data_provider11() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Sort_Order_FUNCTIONAL_TEST_CASE.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "reports_sequence_stats_with_valid_sortOrder")
    public void reports_sequence_stats_with_valid_sortOrder(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONArray body_array= new JSONArray();
        body_array.put(parseInt("1467"));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-08-09T16:39:45.000+05:30");
        body.put("endDate", "2022-08-09T16:39:45.000+05:30");
        body.put("limit","25");
        body.put("page","0");
        body.put("orderBy","sequenceCreatedAt");
        body.put("sortOrder",Value);

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(201);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @DataProvider(name = "reports_sequence_stats_with_different_sortOrder")
    public Object[][] data_provider12() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Sort_Order_FUNCTIONAL_TEST_CASE.xlsx", 1);
        return data;
    }
    @Test(dataProvider = "reports_sequence_stats_with_different_sortOrder")
    public void reports_sequence_stats_with_different_sortOrder(String Id,String Filter_Name, String Value, String status_code){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization", utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONArray body_array= new JSONArray();
        body_array.put(parseInt("1467"));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-08-09T16:39:45.000+05:30");
        body.put("endDate", "2022-08-09T16:39:45.000+05:30");
        body.put("limit","25");
        body.put("page","0");
        body.put("orderBy","sequenceCreatedAt");
        body.put("sortOrder",Value);

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }


    @Test
    public void reports_sequence_stats_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        TokenUtility token_utils = new TokenUtility();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");

        JSONArray body_array= new JSONArray();
        body_array.put(parseInt("1467"));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-08-09T16:39:45.000+05:30");
        body.put("endDate", "2022-08-09T16:39:45.000+05:30");
        body.put("limit","10");
        body.put("page","1");
        body.put("orderBy","1");
        body.put("sortOrder","created-date");

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));
    }

    @Test
    public void reports_sequence_stats_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        JSONArray body_array= new JSONArray();
        body_array.put(parseInt("1467"));

        JSONObject body = new JSONObject();
        body.put("sequenceIds",body_array);
        body.put("startDate", "2022-08-09T16:39:45.000+05:30");
        body.put("endDate", "2022-08-09T16:39:45.000+05:30");
        body.put("limit","10");
        body.put("page","1");
        body.put("orderBy","1");
        body.put("sortOrder","created-date");

        logs.test_step("------------------------------------------ REPORT SEQUENCE STATS TEST--------------------------------------------");
        String update_file = builder.updateRequestObject("reports/reports_sequence_stats/reports_sequence_stats_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);


        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

}
