package TestCases.APITests.getemployeedata;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetEmployeeDataTest extends base {
    @Test
    public void verify_get_employee_data_with_valid_token(){
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
        JSONObject get_employee_response=builder.performRequest(update_file1);

        ResponseValidator programs_validator = new ResponseValidator(get_employee_response);
        programs_validator.statusCodeShouldBe(200);

        String expiration1 = programs_validator.getDataFromBody("$.data[0].id");
        assertThat(expiration1).isNotBlank();

        JSONObject header = new JSONObject();
        header.put("Authorization",token);

        JSONObject pathParameter =new JSONObject();
        pathParameter.put("employee",expiration1);
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();

        String  update_file = builder.updateRequestObject("getemployeedata/get_employee_data_with_valid_token",pathParameter, queryParameters, header, body,body1);
        JSONObject get_program_response=builder.performRequest(update_file);


        ResponseValidator getemployeedata_validator = new ResponseValidator(get_program_response);
        getemployeedata_validator.statusCodeShouldBe(200);

        String id_ex = getemployeedata_validator.getDataFromBody("$.data.id");
        assertThat(id_ex).isNotBlank();

        String firstname_ex = getemployeedata_validator.getDataFromBody("$.data.first_name");
        assertThat(firstname_ex).isNotBlank();

        String lastname_ex = getemployeedata_validator.getDataFromBody("$.data.last_name");
        assertThat(lastname_ex).isNotBlank();

        String countrycode_ex = getemployeedata_validator.getDataFromBody("$.data.country_code");
        assertThat(countrycode_ex).isNotBlank();

        String email_ex = getemployeedata_validator.getDataFromBody("$.data.email");
        assertThat(email_ex).isNotBlank();

        String phone_ex = getemployeedata_validator.getDataFromBody("$.data.phone");
        assertThat(phone_ex).isNotBlank();

        String onboarddate_ex = getemployeedata_validator.getDataFromBody("$.data.onboard_date");
        assertThat(onboarddate_ex).isNotBlank();

        String employeenumber_ex = getemployeedata_validator.getDataFromBody("$.data.employee_number");
        assertThat(employeenumber_ex).isNotBlank();

        String status_ex = getemployeedata_validator.getDataFromBody("$.data.status");
        assertThat(status_ex).isNotBlank();

        String createddatetime = getemployeedata_validator.getDataFromBody("$.data.created_datetime");
        assertThat(createddatetime).isNotBlank();

        String updateddaetime = getemployeedata_validator.getDataFromBody("$.data.updated_datetime");
        assertThat(updateddaetime).isNotBlank();


    }
    @Test
    public void verify_get_employee_data_with_blank_token() {
        RequestBuilder builder = new RequestBuilder();

        JSONObject response = builder.performRequest("getemployeedata/get_employee_data_with_blank_token");

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is missing !!");

    }

    @Test
    public void verify_get_employee_data_with_invalid_token() {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("Authorization","1234ef");
        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        String  update_file = builder.updateRequestObject("getemployeedata/get_employee_data_with_invalid_token",pathParameter, queryParameters, header, body,body);
        JSONObject get_employee_response=builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(get_employee_response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is invalid !!");
    }
}
