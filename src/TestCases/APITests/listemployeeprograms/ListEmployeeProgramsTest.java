package APITests.listemployeeprograms;

import io.unity.core.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListEmployeeProgramsTest extends base {
    @Test
    public void verify_list_employee_program_with_valid_token (){
        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_credentials");
        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String token = validator.getDataFromBody("$.token");
        System.out.println(token);

        JSONObject header1 = new JSONObject();
        header1.put("Authorization",token);

        JSONObject pathParameter1 =new JSONObject();
        JSONObject queryParameters1 = new JSONObject();
        JSONObject body1 = new JSONObject();

        String  update_file1 = builder.updateRequestObject("listallemployee/list_all_employee_with_valid_token",pathParameter1, queryParameters1, header1, body1,body1);
        JSONObject get_all_employee_response=builder.performRequest(update_file1);

        ResponseValidator programs_validator = new ResponseValidator(get_all_employee_response);
        programs_validator.statusCodeShouldBe(200);

        String expiration1 = programs_validator.getDataFromBody("$.data[0].id");
        assertThat(expiration1).isNotBlank();

        JSONObject header = new JSONObject();
        header.put("Authorization",token);

        JSONObject pathParameter =new JSONObject();
        pathParameter.put("employee",expiration1);
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();

        String  update_file = builder.updateRequestObject("listemployeeprograms/list_employee_programs_valid_token",pathParameter, queryParameters, header, body,body);
        JSONObject get_program_response=builder.performRequest(update_file);

        ResponseValidator listemployee_validator = new ResponseValidator(get_program_response);
        listemployee_validator.statusCodeShouldBe(200);

        String startdate_ex = listemployee_validator.getDataFromBody("$.data[*].start_date");
        assertThat(startdate_ex).isNotBlank();

        String duedate_ex = listemployee_validator.getDataFromBody("$.data[*].due_date");
        assertThat(duedate_ex).isNotBlank();

        String employeeid_ex = listemployee_validator.getDataFromBody("$.data[*].employee_id");
        assertThat(employeeid_ex).isNotBlank();

        String programeid_ex = listemployee_validator.getDataFromBody("$.data[*].program_id");
        assertThat(programeid_ex).isNotBlank();

        String status_ex = listemployee_validator.getDataFromBody("$.data[*].status");
        assertThat(status_ex).isNotBlank();

        String completeddatetime_ex = listemployee_validator.getDataFromBody("$.data[*].completed_datetime");
        assertThat(completeddatetime_ex).isNotBlank();

        String approvaldatetime_ex = listemployee_validator.getDataFromBody("$.data[*].approval_datetime");
        assertThat(approvaldatetime_ex).isNotBlank();
    }
    @Test
    public void verify_list_employee_program_with_blank_token () {
        RequestBuilder builder = new RequestBuilder();

        JSONObject response = builder.performRequest("listemployeeprograms/list_employee_programs_valid_token");

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is missing !!");

    }

    @Test
    public void verify_list_employee_program_with_invalid_token() {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("Authorization","1234ef");
        JSONObject body = new JSONObject();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        String  update_file = builder.updateRequestObject("listemployeeprograms/list_employee_programs_invalid_tokens",pathParameter, queryParameters, header, body,body);
        JSONObject get_employee_response=builder.performRequest(update_file);

        ResponseValidator programs_validator = new ResponseValidator(get_employee_response);
        programs_validator.statusCodeShouldBe(401);

        String message = programs_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is invalid !!");
    }
}

