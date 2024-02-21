package TestCases.APITests.createvisitforemployee;


import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class createvisitforemployeeTest extends base {

    @Test
    public void verify_create_visit_for_employee_with_valid_token() {
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

        String update_file2 = builder.updateRequestObject("createvisitforemployee/create_visit_for_employee_with_valid_token", pathParameter2, queryParameters, header, body, schema);
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

    @Test
    public void verify_create_visit_for_employee_with_invalid_token()
    {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();
        GetEmployyVisitId getId = new GetEmployyVisitId();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");
        header.put("Authorization","1234ef");

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("employee_id",getId.getEmployee_id());

        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("createvisitforemployee/create_visit_for_employee_with_valid_token",pathParameter, queryParameters, header, body, schema);
        JSONObject get_visit_response=builder.performRequest(update_file);

        ResponseValidator visit_validator = new ResponseValidator(get_visit_response);
        visit_validator.statusCodeShouldBe(401);
        System.out.println(get_visit_response);

        String message = visit_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is invalid !!");
    }

    @Test
    public void verify_create_visit_for_employee_with_blank_token(){
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();
        GetEmployyVisitId getId = new GetEmployyVisitId();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");
        header.put("Authorization","");

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("employee_id",getId.getEmployee_id());
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("createvisitforemployee/create_visit_for_employee_with_valid_token",pathParameter, queryParameters, header, body,schema);
        JSONObject get_employee_visit_details_response=builder.performRequest(update_file);
        System.out.println(get_employee_visit_details_response);

        ResponseValidator employee_validator = new ResponseValidator(get_employee_visit_details_response);
        employee_validator.statusCodeShouldBe(401);

        String message = employee_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is missing !!");
    }

//    @Test
//    public void verify_create_visit_by_not_providing_employee_id_in_pathparameter(){
//        RequestBuilder builder = new RequestBuilder();
//        GetTokenUtility gettoken = new GetTokenUtility();
//        GetEmployyVisitId getId = new GetEmployyVisitId();
//
//        JSONObject header = new JSONObject();
//        header.put("content-type","application/json");
//        header.put("Authorization",gettoken.getToken());
//
//        JSONObject pathParameter = new JSONObject();
//        pathParameter.put("employee_id","");
//
//        JSONObject queryParameters = new JSONObject();
//
//        JSONObject body = new JSONObject();
//        body.put("start_datetime","2023-08-09T13:33:44+00:00");
//        body.put("end_datetime","2023-09-09T13:33:44+00:00");
//        JSONObject schema = new JSONObject();
//
//        String  update_file = builder.updateRequestObject("createvisitforemployee/create_visit_for_employee_with_valid_token",pathParameter, queryParameters, header, body,schema);
//        JSONObject get_employee_visit_details_response=builder.performRequest(update_file);
//        System.out.println(get_employee_visit_details_response);
//
//        ResponseValidator employee_validator = new ResponseValidator(get_employee_visit_details_response);
//        employee_validator.statusCodeShouldBe(405);
//
//    }

    @Test
    public void verify_create_visit_by_not_providing_start_date_time() {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();
        GetEmployyVisitId getId = new GetEmployyVisitId();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", gettoken.getToken());

        JSONObject body = new JSONObject();
        body.put("start_datetime","");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("employee_id", getId.getEmployee_id());
        pathParameter.put("visit_id", getId.getVisit_id());

        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("createvisitforemployee/create_visit_for_employee_with_valid_token", pathParameter, queryParameters, header, body, schema);
        JSONObject get_visit_response = builder.performRequest(update_file);

        ResponseValidator employee_validator = new ResponseValidator(get_visit_response);
        employee_validator.statusCodeShouldBe(400);

        String message = employee_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("The start datetime field is required.");

        String metaobject = employee_validator.getDataFromBody("$.meta");
        assertThat(metaobject).isNotBlank();

        String field = employee_validator.getDataFromBody("$.meta.field");
        assertThat(field).isEqualTo("start_datetime");
        System.out.println(get_visit_response);
    }

    @Test
    public void verify_create_visit_by_not_providing_last_date_time() {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();
        GetEmployyVisitId getId = new GetEmployyVisitId();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", gettoken.getToken());

        JSONObject body = new JSONObject();
        body.put("start_datetime","2023-12-02T13:33:44+00:00");
        body.put("last_datetime","");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("employee_id", getId.getEmployee_id());
        pathParameter.put("visit_id", getId.getVisit_id());

        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("createvisitforemployee/create_visit_for_employee_with_valid_token", pathParameter, queryParameters, header, body, schema);
        JSONObject get_visit_response = builder.performRequest(update_file);

        ResponseValidator employee_validator = new ResponseValidator(get_visit_response);
        employee_validator.statusCodeShouldBe(400);

        String message = employee_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("The end datetime field is required.");

        String metaobject = employee_validator.getDataFromBody("$.meta");
        assertThat(metaobject).isNotBlank();

        String field = employee_validator.getDataFromBody("$.meta.field");
        assertThat(field).isEqualTo("end_datetime");
        System.out.println(get_visit_response);
    }

    @Test
    public void verify_create_visit_employee_for_invalid_employee() {
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

        String  update_file = builder.updateRequestObject("createvisitforemployee/create_visit_for_employee_with_valid_token",pathParameter, queryParameters, header, body, schema);
        JSONObject get_visit_response=builder.performRequest(update_file);

        ResponseValidator visit_validator = new ResponseValidator(get_visit_response);
        visit_validator.statusCodeShouldBe(404);
        System.out.println(get_visit_response);

        String message = visit_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Employee not found");
    }




}
