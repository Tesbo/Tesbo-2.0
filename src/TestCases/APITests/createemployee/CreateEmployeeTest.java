package APITests.createemployee;

import api.requests.common.GetEmployyVisitId;
import api.requests.common.GetTokenUtility;
import io.unity.core.data.TestData;
import io.unity.core.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateEmployeeTest extends base {
    @Test
    public void verify_create_employee_with_valid_data(){
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();
        GetEmployyVisitId getId = new GetEmployyVisitId();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", gettoken.getToken());

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();
        body.put("firstname",TestData.random_alphabetic_string(4));
        body.put("lastname",TestData.random_alphabetic_string(4));
        body.put("country_code","1");
        body.put("phone", TestData.random_numeric_string(10));
        body.put("employee_number", TestData.random_numeric_string(4));
        body.put("firstname",TestData.random_alphabetic_string(5));
        JSONObject schema = new JSONObject();

        String update_file2 = builder.updateRequestObject("createemployee/create_employee_with_valid_data", pathParameter, queryParameters, header, body, schema);
        JSONObject get_specific_visit_response = builder.performRequest(update_file2);

        ResponseValidator createemployee_validator = new ResponseValidator(get_specific_visit_response);
        createemployee_validator.statusCodeShouldBe(200);
        System.out.println(get_specific_visit_response);

        String id_ex = createemployee_validator.getDataFromBody("$.data.id");
        assertThat(id_ex).isNotBlank();

        String firstname_ex = createemployee_validator.getDataFromBody("$.data.first_name");
        assertThat(firstname_ex).isNotBlank();

        String lastname_ex = createemployee_validator.getDataFromBody("$.data.last_name");
        assertThat(lastname_ex).isNotBlank();

        String countrycode_ex = createemployee_validator.getDataFromBody("$.data.country_code");
        assertThat(countrycode_ex).isNotBlank();

        String email_ex = createemployee_validator.getDataFromBody("$.data.email");
        assertThat(email_ex).isNotBlank();

        String phone_ex = createemployee_validator.getDataFromBody("$.data.phone");
        assertThat(phone_ex).isNotBlank();

        String onboarddate_ex = createemployee_validator.getDataFromBody("$.data.onboard_date");
        assertThat(onboarddate_ex).isNotBlank();

        String employeenumber_ex = createemployee_validator.getDataFromBody("$.data.employee_number");
        assertThat(employeenumber_ex).isNotBlank();

        String disciplines_ex = createemployee_validator.getDataFromBody("$.data.disciplines");
        assertThat(disciplines_ex).isNotBlank();

        String location_ex = createemployee_validator.getDataFromBody("$.data.location");
        assertThat(location_ex).isNotBlank();

        String language_ex = createemployee_validator.getDataFromBody("$.data.language");
        assertThat(language_ex).isNotBlank();

        String status_ex = createemployee_validator.getDataFromBody("$.data.status");
        assertThat(status_ex).isNotBlank();

        String createddatetime_ex = createemployee_validator.getDataFromBody("$.data.created_datetime");
        assertThat(createddatetime_ex).isNotBlank();

        String updateddatetime_ex = createemployee_validator.getDataFromBody("$.data.updated_datetime");
        assertThat(updateddatetime_ex).isNotBlank();
    }

    @Test
    public void verify_create_employee_with_blank_token () {
        RequestBuilder builder = new RequestBuilder();

        JSONObject response = builder.performRequest("createemployee/create_employee_with_valid_data");

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is missing !!");

    }

    @Test
    public void verify_create_employee_with_invalid_token() {
        RequestBuilder builder = new RequestBuilder();

        JSONObject response = builder.performRequest("createemployee/create_employee_with_invalid_data");

        ResponseValidator validator = new ResponseValidator(response);

        Map header = new HashMap();
        Map body = new HashMap();
        JSONObject get_employee_response = builder.performRequestWithHeaderAndBody("createemployee/create_employee_with_invalid_data", header, body);

        ResponseValidator programs_validator = new ResponseValidator(get_employee_response);
        programs_validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is invalid !!");
    }

    @Test
    public void verify_create_employee_with_blank_fist_name(){
        RequestBuilder builder = new RequestBuilder();

        JSONObject response = builder.performRequest("createemployee/create_employee_with_blank_first_name");

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(400);

        String message = validator.getDataFromBody("$.message");

        assertThat(message).isNotBlank();
        assertThat(message).isEqualTo("The first name field is required.");

    }

    @Test
    public void verify_create_employee_with_blank_last_name(){
        RequestBuilder builder = new RequestBuilder();

        JSONObject response = builder.performRequest("createemployee/create_employee_with_blank_last_name");

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(400);

        String message = validator.getDataFromBody("$.message");

        assertThat(message).isNotBlank();
        assertThat(message).isEqualTo("The last name field is required.");

    }
    @Test
    public void verify_create_employee_with_blank_phone(){
        RequestBuilder builder = new RequestBuilder();

        JSONObject response = builder.performRequest("createemployee/create_employee_with_blank_phone");

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(400);

        String message = validator.getDataFromBody("$.message");

        assertThat(message).isNotBlank();
        assertThat(message).isEqualTo("The phone field is required.");
    }
}
