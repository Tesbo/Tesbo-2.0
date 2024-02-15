package APITests.updatevisitinformation;

import api.requests.common.GetEmployyVisitId;
import api.requests.common.GetTokenUtility;
import io.unity.core.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class updatevisitinformationTest extends base {

    @Test
    public void verify_update_visit_info_with_valid_token() {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();
        GetEmployyVisitId getId = new GetEmployyVisitId();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", gettoken.getToken());

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("employee_id", getId.getEmployee_id());
        pathParameter.put("visit_id", getId.getVisit_id());
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file2 = builder.updateRequestObject("updatevisitinformation/update_visit_information_with_valid_token", pathParameter, queryParameters, header, body, schema);
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
    public void verify_update_visit_info_with_invalid_token()
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
        pathParameter.put("visit_id",getId.getVisit_id());

        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("updatevisitinformation/update_visit_information_with_valid_token",pathParameter, queryParameters, header, body, schema);
        JSONObject get_visit_response=builder.performRequest(update_file);

        ResponseValidator visit_validator = new ResponseValidator(get_visit_response);
        visit_validator.statusCodeShouldBe(401);
        System.out.println(get_visit_response);

        String message = visit_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is invalid !!");
    }

    @Test
    public void verify_update_visit_info_with_blank_token(){
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();
        GetEmployyVisitId getId = new GetEmployyVisitId();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");
        header.put("Authorization","");

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("employee_id",getId.getEmployee_id());
        pathParameter.put("visit_id",getId.getVisit_id());
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("updatevisitinformation/update_visit_information_with_valid_token",pathParameter, queryParameters, header, body,schema);
        JSONObject get_employee_visit_details_response=builder.performRequest(update_file);
        System.out.println(get_employee_visit_details_response);

        ResponseValidator employee_validator = new ResponseValidator(get_employee_visit_details_response);
        employee_validator.statusCodeShouldBe(401);

        String message = employee_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is missing !!");
    }

    @Test
    public void verify_update_visit_by_providing_invalid_employee_id() {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();
        GetEmployyVisitId getId = new GetEmployyVisitId();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", gettoken.getToken());

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("employee_id","9876523566");
        pathParameter.put("visit_id",getId.getVisit_id());

        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("updatevisitinformation/update_visit_information_with_valid_token",pathParameter, queryParameters, header, body, schema);
        JSONObject get_visit_response=builder.performRequest(update_file);

        ResponseValidator visit_validator = new ResponseValidator(get_visit_response);
        visit_validator.statusCodeShouldBe(404);
        System.out.println(get_visit_response);

        String message = visit_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Employee not found");
    }

    @Test
    public void verify_update_visit_by_providing_invalid_visit_id() {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();
        GetEmployyVisitId getId = new GetEmployyVisitId();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", gettoken.getToken());

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("employee_id",getId.getEmployee_id());
        pathParameter.put("visit_id","123456");

        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("updatevisitinformation/update_visit_information_with_valid_token",pathParameter, queryParameters, header, body, schema);
        JSONObject get_visit_response=builder.performRequest(update_file);

        ResponseValidator visit_validator = new ResponseValidator(get_visit_response);
        visit_validator.statusCodeShouldBe(404);
        System.out.println(get_visit_response);

        String message = visit_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Visit not found");
    }

    @Test
    public void verify_update_visit_by_providing_invalid_employee_id_and_visit_id() {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();
        GetEmployyVisitId getId = new GetEmployyVisitId();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", gettoken.getToken());

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("employee_id","9876523566");
        pathParameter.put("visit_id","098765");

        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("updatevisitinformation/update_visit_information_with_valid_token",pathParameter, queryParameters, header, body, schema);
        JSONObject get_visit_response=builder.performRequest(update_file);

        ResponseValidator visit_validator = new ResponseValidator(get_visit_response);
        visit_validator.statusCodeShouldBe(404);
        System.out.println(get_visit_response);

        String message = visit_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Employee not found");
    }

}
