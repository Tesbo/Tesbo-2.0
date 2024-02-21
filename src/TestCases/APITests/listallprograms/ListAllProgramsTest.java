package TestCases.APITests.listallprograms;


import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListAllProgramsTest extends base {

    @Test
    public void verify_get_all_programs_with_valid_token() {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility gettoken = new GetTokenUtility();
        GetEmployyVisitId getId = new GetEmployyVisitId();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization", gettoken.getToken());

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();
        String  update_file = builder.updateRequestObject("listallprograms/list_all_programs_with_valid_token",pathParameter, queryParameters, header, body,schema);
        JSONObject get_program_response=builder.performRequest(update_file);

        ResponseValidator programs_validator = new ResponseValidator(get_program_response);
        programs_validator.statusCodeShouldBe(200);

        String expiration = programs_validator.getDataFromBody("$.data[*].id");
        assertThat(expiration).isNotBlank();
        Reporter.log(expiration,true);

        String name_ex = programs_validator.getDataFromBody("$.data[*].name");
        assertThat(name_ex).isNotBlank();

        String description_ex = programs_validator.getDataFromBody("$.data[*].description");
        assertThat(description_ex).isNotBlank();

        String duration_ex = programs_validator.getDataFromBody("$.data[*].duration");
        assertThat(duration_ex).isNotBlank();

        String image_ex = programs_validator.getDataFromBody("$.data[*].image");
        assertThat(image_ex).isNotBlank();

        String status_ex = programs_validator.getDataFromBody("$.data[*].status");
        assertThat(status_ex).isNotBlank();

        String createddatetime_ex = programs_validator.getDataFromBody("$.data[*].created_datetime");
        assertThat(createddatetime_ex).isNotBlank();

        String updateddatetime_ex = programs_validator.getDataFromBody("$.data[*].updated_datetime");
        assertThat(updateddatetime_ex).isNotBlank();

    }

    @Test
    public void verify_get_all_programs_with_blank_token() {
        RequestBuilder builder = new RequestBuilder();

        JSONObject response = builder.performRequest("listallPrograms/list_all_programs_with_valid_token");

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is missing !!");

    }

    @Test
    public void verify_get_all_programs_with_invalid_token() {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("Authorization","1234ef");
        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        String  update_file = builder.updateRequestObject("listallprograms/list_all_programs_with_valid_token",pathParameter, queryParameters, header, body,body);
        JSONObject get_program_response=builder.performRequest(update_file);

        ResponseValidator programs_validator = new ResponseValidator(get_program_response);
        programs_validator.statusCodeShouldBe(401);

        String message = programs_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is invalid !!");
    }
}
