package TestCases.APITests.getprogram;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetProgramTest extends base {

    @Test
    public void verify_get_program_with_valid_token(){

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

        String  update_file1 = builder.updateRequestObject("listallprograms/list_all_programs_with_valid_token",pathParameter1, queryParameters1, header1, body1,body1);
        JSONObject get_all_program_response=builder.performRequest(update_file1);

        ResponseValidator programs_validator = new ResponseValidator(get_all_program_response);
        programs_validator.statusCodeShouldBe(200);

        String expiration1 = programs_validator.getDataFromBody("$.data[0].id");
        assertThat(expiration1).isNotBlank();

        JSONObject header = new JSONObject();
        header.put("Authorization",token);

        JSONObject pathParameter =new JSONObject();
        pathParameter.put("program",expiration1);
        JSONObject queryParameters = new JSONObject();
        JSONObject body = new JSONObject();

        String  update_file = builder.updateRequestObject("getprogram/get_program_with_valid_token",pathParameter, queryParameters, header, body,body1);
        JSONObject get_program_response=builder.performRequest(update_file);

        ResponseValidator programg_validator = new ResponseValidator(get_program_response);
        programg_validator.statusCodeShouldBe(200);

        String expiration = programg_validator.getDataFromBody("$.data.id");
        assertThat(expiration).isNotBlank();

        String name_ex = programg_validator.getDataFromBody("$.data.name");
        assertThat(name_ex).isNotBlank();

        String duration_ex = programg_validator.getDataFromBody("$.data.duration");
        assertThat(duration_ex).isNotBlank();

        String status_ex = programg_validator.getDataFromBody("$.data.status");
        assertThat(status_ex).isNotBlank();

        String createddatetime_ex = programg_validator.getDataFromBody("$.data.created_datetime");
        assertThat(createddatetime_ex).isNotBlank();

        String updateddatetime_ex = programg_validator.getDataFromBody("$.data.updated_datetime");
        assertThat(updateddatetime_ex).isNotBlank();

    }
@Test
    public void verify_get_program_with_blank_token()
{
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

    String  update_file1 = builder.updateRequestObject("listallprograms/list_all_programs_with_valid_token",pathParameter1, queryParameters1, header1, body1,body1);
    JSONObject get_all_program_response=builder.performRequest(update_file1);

    ResponseValidator programs_validator = new ResponseValidator(get_all_program_response);
    programs_validator.statusCodeShouldBe(200);

    String expiration1 = programs_validator.getDataFromBody("$.data[0].id");
    assertThat(expiration1).isNotBlank();

    JSONObject header = new JSONObject();
    header.put("Authorization","");

    JSONObject pathParameter =new JSONObject();
    pathParameter.put("program",expiration1);
    JSONObject queryParameters = new JSONObject();
    JSONObject body = new JSONObject();

    String  update_file = builder.updateRequestObject("getprogram/get_program_with_valid_token",pathParameter, queryParameters, header, body,body1);
    JSONObject response1 =builder.performRequest(update_file);

    ResponseValidator validator1 = new ResponseValidator(response1);
    validator1.statusCodeShouldBe(401);

    String message = validator1.getDataFromBody("$.message");
    assertThat(message).isEqualTo("Token is missing !!");
}
@Test
    public void verify_get_program_with_invalid_token()
{
    RequestBuilder builder = new RequestBuilder();

    JSONObject header = new JSONObject();
    header.put("Authorization","1234ef");
    JSONObject body = new JSONObject();
    JSONObject pathParameter = new JSONObject();
    JSONObject queryParameters = new JSONObject();

    String  update_file = builder.updateRequestObject("getprogram/get_program_with_invalid_token",pathParameter, queryParameters, header, body,body);
    JSONObject get_program_response=builder.performRequest(update_file);

    ResponseValidator program_validator = new ResponseValidator(get_program_response);
    program_validator.statusCodeShouldBe(401);

    String message = program_validator.getDataFromBody("$.message");
    assertThat(message).isEqualTo("Token is invalid !!");
}
}
