package APITests.getallemployeesvisitsdetails;

import api.requests.common.GetEmployyVisitId;
import api.requests.common.GetTokenUtility;
import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class getallemployeevisitsdetailsTest extends base {

    @Test
    public void verify_get_all_employee_visit_details_with_valid_token(){
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");
        header.put("Authorization",gettoken.getToken());

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("getallemployeevisitsdetails/get_all_employee_visits_details_with_valid_token",pathParameter, queryParameters, header, body,schema);
        JSONObject get_employee_visit_details_response=builder.performRequest(update_file);
        System.out.println(get_employee_visit_details_response);

        ResponseValidator employee_validator = new ResponseValidator(get_employee_visit_details_response);
        employee_validator.statusCodeShouldBe(200);

        String dataobject = employee_validator.getDataFromBody("$.data");
        assertThat(dataobject).isNotBlank();

        String visit_id = employee_validator.getDataFromBody("$.data[*].visit_id");
        assertThat(visit_id).isNotBlank();

        String employee_id = employee_validator.getDataFromBody("$.data[*].employee_id");
        assertThat(employee_id).isNotBlank();

        String start_datetime = employee_validator.getDataFromBody("$.data[*].start_datetime");
        assertThat(start_datetime).isNotBlank();
       // employee_validator.responseShouldContains("$.data[*].start_datetime","2023-01-24T20:50:45+00:00");
       // String format = String.format("2023-01-24T20:50:45+00:00");
     //  assertThat(start_datetime).isEqualTo(format);
    // assertThat(start_datetime).containsPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZZ");
      // assertThat(start_datetime).matches("2023-01-24T20:50:45+00:00");
   //   Assert.assertEquals("2023-01-24T20:50:45+00:00",employee_validator.getDataFromBody("$.data[0].start_datetime"));
//        format.equals(start_datetime);
//        System.out.println(format.equals(start_datetime));

        String end_datetime = employee_validator.getDataFromBody("$.data[*].end_datetime");
        assertThat(end_datetime).isNotBlank();

        String status = employee_validator.getDataFromBody("$.data[*].status");
        assertThat(status).isNotBlank();

        String metaobject = employee_validator.getDataFromBody("$.meta");
        assertThat(metaobject).isNotBlank();

        String total = employee_validator.getDataFromBody("$.meta.total");
        assertThat(total).isNotBlank();

        String current_page = employee_validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String last_page = employee_validator.getDataFromBody("$.meta.last_page");
        assertThat(last_page).isNotBlank();
    }

    @DataProvider(name = "visit_QP")
    public Object[][] visit_QP_valid() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("visit_QP.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "visit_QP")
    public void verify_get_all_employee_visit_details_by_passing_query_parameter_as_include_past_for_valid_values(String Id , String Filter_Name , String Value , String status_code){
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
        employee_validator.statusCodeShouldBe(200);

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

    @DataProvider(name = "visit_QP_invalid")
    public Object[][] visit_QP_invalid() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("visit_QP.xlsx", 1);
        return data;
    }
    @Test(dataProvider = "visit_QP_invalid")
    public void verify_get_all_employee_visit_details_by_passing_query_parameter_as_include_past_for_invalid_values(String Id , String Filter_Name , String Value , String status_code){
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
    public void verify_get_all_employee_visit_details_by_passing_query_parameter_as_include_inactive_for_valid_values(String Id , String Filter_Name , String Value , String status_code){
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
    public void verify_get_all_employee_visit_details_by_passing_query_parameter_as_include_inactive_for_invalid_values(String Id , String Filter_Name , String Value , String status_code){
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
    public void verify_get_all_employee_visit_details_with_blank_token(){
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();
        GetEmployyVisitId getid = new GetEmployyVisitId();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");
        header.put("Authorization","");

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("employee-id",getid.getEmployee_id());
        pathParameter.put("visit_id",getid.getVisit_id());
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("getallemployeevisitsdetails/get_all_employee_visits_details_with_valid_token",pathParameter, queryParameters, header, body,schema);
        JSONObject get_employee_visit_details_response=builder.performRequest(update_file);
        System.out.println(get_employee_visit_details_response);

        ResponseValidator employee_validator = new ResponseValidator(get_employee_visit_details_response);
        employee_validator.statusCodeShouldBe(401);

        String message = employee_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is missing !!");
    }

    @Test
    public void verify_get_all_employee_visit_details_with_invalid_token()
    {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("Authorization","1234ef");
        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("getallemployeevisitsdetails/get_all_employee_visits_details_with_valid_token",pathParameter, queryParameters, header, body, schema);
        JSONObject get_employee_response=builder.performRequest(update_file);

        ResponseValidator employee_validator = new ResponseValidator(get_employee_response);
        employee_validator.statusCodeShouldBe(401);
        System.out.println(get_employee_response);

        String message = employee_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is invalid !!");
    }

}
