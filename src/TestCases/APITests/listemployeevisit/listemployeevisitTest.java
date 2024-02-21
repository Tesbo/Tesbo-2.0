package TestCases.APITests.listemployeevisit;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class listemployeevisitTest extends base {

    @Test
    public void verify_list_of_employee_visit_details_with_valid_token() {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", gettoken.getToken());

        JSONObject pathParameter1 = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("getallemployeevisitsdetails/get_all_employee_visits_details_with_valid_token", pathParameter1, queryParameters, header, body, schema);
        JSONObject get_employee_response = builder.performRequest(update_file);

        ResponseValidator employee_validator = new ResponseValidator(get_employee_response);
        employee_validator.statusCodeShouldBe(200);

        String expiration1 = employee_validator.getDataFromBody("$.data[0].employee_id");
        assertThat(expiration1).isNotBlank();

        JSONObject pathParameter2 = new JSONObject();
        pathParameter2.put("employee_id", expiration1);

        String update_file2 = builder.updateRequestObject("listemployeevisit/list_employee_visit_with_valid_token", pathParameter2, queryParameters, header, body, schema);
        JSONObject get_specific_visit_response = builder.performRequest(update_file2);
        System.out.println(get_specific_visit_response);

        ResponseValidator visit_validator = new ResponseValidator(get_specific_visit_response);
        visit_validator.statusCodeShouldBe(200);

        String dataobject = visit_validator.getDataFromBody("$.data");
        assertThat(dataobject).isNotBlank();

        String visit_id = visit_validator.getDataFromBody("$.data[*].visit_id");
        assertThat(visit_id).isNotBlank();

        String employee_id = visit_validator.getDataFromBody("$.data[*].employee_id");
        assertThat(employee_id).isNotBlank();

        String start_datetime = visit_validator.getDataFromBody("$.data[*].start_datetime");
        assertThat(start_datetime).isNotBlank();

        String end_datetime = visit_validator.getDataFromBody("$.data[*].end_datetime");
        assertThat(end_datetime).isNotBlank();

        String status = visit_validator.getDataFromBody("$.data[*].status");
        assertThat(status).isNotBlank();

    }

    @DataProvider(name = "visit_QP")
    public Object[][] visit_QP_valid() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("visit_QP.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "visit_QP")
    public void verify_list_employee_visit_by_passing_query_parameter_as_include_past_for_valid_values(String Id , String Filter_Name , String Value , String status_code){
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");
        header.put("Authorization",gettoken.getToken());

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("include_past",Value);
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("getallemployeevisitsdetails/get_all_employee_visits_details_with_valid_token", pathParameter, queryParameters, header, body, schema);
        JSONObject get_employee_response = builder.performRequest(update_file);

        ResponseValidator employee_validator = new ResponseValidator(get_employee_response);
        employee_validator.statusCodeShouldBe(200);

        String expiration1 = employee_validator.getDataFromBody("$.data[0].employee_id");
        assertThat(expiration1).isNotBlank();

        JSONObject pathParameter2 = new JSONObject();
        pathParameter2.put("employee", expiration1);

        String  update_file1 = builder.updateRequestObject("getallemployeevisitsdetails/get_all_employee_visits_details_with_valid_token",pathParameter2, queryParameters, header, body,schema);
        JSONObject get_employee_visit_details_response=builder.performRequest(update_file1);
        System.out.println(get_employee_visit_details_response);

        ResponseValidator visit_validator = new ResponseValidator(get_employee_visit_details_response);
        visit_validator.statusCodeShouldBe(200);

        String visit_id = visit_validator.getDataFromBody("$.data[*].visit_id");
        assertThat(visit_id).isNotBlank();

        String employee_id = visit_validator.getDataFromBody("$.data[*].employee_id");
        assertThat(employee_id).isNotBlank();

        String start_datetime = visit_validator.getDataFromBody("$.data[*].start_datetime");
        assertThat(start_datetime).isNotBlank();

        String end_datetime = visit_validator.getDataFromBody("$.data[*].end_datetime");
        assertThat(end_datetime).isNotBlank();

        String status = visit_validator.getDataFromBody("$.data[*].status");
        assertThat(status).isNotBlank();
    }

    @DataProvider(name = "visit_QP_invalid")
    public Object[][] visit_QP_invalid() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("visit_QP.xlsx", 1);
        return data;
    }
    @Test(dataProvider = "visit_QP_invalid")
    public void verify_list_of_all_employee_visit_details_by_passing_query_parameter_as_include_past_for_invalid_values(String Id , String Filter_Name , String Value , String status_code){
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");
        header.put("Authorization",gettoken.getToken());

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("include_past",Value);
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("getallemployeevisitsdetails/get_all_employee_visits_details_with_valid_token",pathParameter, queryParameters, header, body,schema);
        JSONObject get_employee_visit_details_response=builder.performRequest(update_file);
        System.out.println(get_employee_visit_details_response);

        ResponseValidator employee_validator = new ResponseValidator(get_employee_visit_details_response);
        employee_validator.statusCodeShouldBe(400);

        String message = employee_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("The selected include past is invalid.");

        String metaobject = employee_validator.getDataFromBody("$.meta");
        assertThat(metaobject).isNotBlank();
        System.out.println(metaobject);
    }

    @DataProvider(name = "visit_QP_ia")
    public Object[][] visit_QP_ia_valid() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("visit_QP.xlsx", 2);
        return data;
    }
    @Test(dataProvider = "visit_QP_ia")
    public void verify_list_all_employee_visit_details_by_passing_query_parameter_as_include_inactive_for_valid_values(String Id , String Filter_Name , String Value , String status_code){
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");
        header.put("Authorization",gettoken.getToken());

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("include_inactive",Value);
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("getallemployeevisitsdetails/get_all_employee_visits_details_with_valid_token",pathParameter, queryParameters, header, body,schema);
        JSONObject get_employee_visit_details_response=builder.performRequest(update_file);
        System.out.println(get_employee_visit_details_response);

        ResponseValidator employee_validator = new ResponseValidator(get_employee_visit_details_response);
        employee_validator.statusCodeShouldBe(200);

        String dataobject = employee_validator.getDataFromBody("$.data");
        assertThat(dataobject).isNotBlank();

        String metaobject = employee_validator.getDataFromBody("$.meta");
        assertThat(metaobject).isNotBlank();

        String visit_id = employee_validator.getDataFromBody("$.data[*].visit_id");
        assertThat(visit_id).isNotBlank();

        String employee_id = employee_validator.getDataFromBody("$.data[*].employee_id");
        assertThat(employee_id).isNotBlank();

        String start_datetime = employee_validator.getDataFromBody("$.data[*].start_datetime");
        assertThat(start_datetime).isNotBlank();

        String end_datetime = employee_validator.getDataFromBody("$.data[*].end_datetime");
        assertThat(end_datetime).isNotBlank();

        String status = employee_validator.getDataFromBody("$.data[*].status");
        assertThat(status).isNotBlank();
    }

    @DataProvider(name = "visit_QP_ia_invalid")
    public Object[][] visit_QP_ia_invalid() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("visit_QP.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "visit_QP_invalid")
    public void verify_list_all_employee_visit_details_by_passing_query_parameter_as_include_inactive_for_invalid_values(String Id , String Filter_Name , String Value , String status_code){
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");
        header.put("Authorization",gettoken.getToken());

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("include_inactive",Value);
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("getallemployeevisitsdetails/get_all_employee_visits_details_with_valid_token",pathParameter, queryParameters, header, body,schema);
        JSONObject get_employee_visit_details_response=builder.performRequest(update_file);
        System.out.println(get_employee_visit_details_response);

        ResponseValidator employee_validator = new ResponseValidator(get_employee_visit_details_response);
        employee_validator.statusCodeShouldBe(400);

        String message = employee_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("The selected include inactive is invalid.");

        String metaobject = employee_validator.getDataFromBody("$.meta");
        assertThat(metaobject).isNotBlank();
        System.out.println(metaobject);
    }


    @Test
    public void verify_list_employee_visit_with_invalid_token()
    {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("Authorization","1234ef");
        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("listemployeevisit/list_employee_visit_with_valid_token",pathParameter, queryParameters, header, body, schema);
        JSONObject list_visit_response=builder.performRequest(update_file);

        ResponseValidator visit_validator = new ResponseValidator(list_visit_response);
        visit_validator.statusCodeShouldBe(401);
        System.out.println(list_visit_response);

        String message = visit_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is invalid !!");
    }

    @Test
    public void verify_list_employee_visit_details_with_blank_token(){
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");
        header.put("Authorization","");

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("listemployeevisit/list_employee_visit_with_valid_token",pathParameter, queryParameters, header, body,schema);
        JSONObject list_employee_visit_response=builder.performRequest(update_file);
        System.out.println(list_employee_visit_response);

        ResponseValidator visit_validator = new ResponseValidator(list_employee_visit_response);
        visit_validator.statusCodeShouldBe(401);

        String message = visit_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is missing !!");
    }

    @Test
    public void verify_list_employee_visit_for_invalid_employee() {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();
        GetEmployyVisitId getId = new GetEmployyVisitId();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", gettoken.getToken());

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("employee_id","9876523566");

        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("listemployeevisit/list_employee_visit_with_valid_token",pathParameter, queryParameters, header, body, schema);
        JSONObject get_visit_response=builder.performRequest(update_file);

        ResponseValidator visit_validator = new ResponseValidator(get_visit_response);
        visit_validator.statusCodeShouldBe(404);
        System.out.println(get_visit_response);

        String message = visit_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Employee not found");
    }


    }

