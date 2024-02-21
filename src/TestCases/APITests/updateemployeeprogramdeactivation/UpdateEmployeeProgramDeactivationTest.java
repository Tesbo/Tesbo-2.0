package TestCases.APITests.updateemployeeprogramdeactivation;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;



public class UpdateEmployeeProgramDeactivationTest extends base {
    @Test
    public void verify_specific_program_completion_with_valid_token (){
        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_credentials");
        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String token = validator.getDataFromBody("$.token");
        System.out.println(token);
        Map header = new HashMap();
        header.put("Authorization", token);


        Map body = new HashMap();

        JSONObject get_program_response = builder.performRequestWithHeaderAndBody("updateemployeeprogramdeactivation/update_employee_program_deactivation_with_valid_data", header, body);

        ResponseValidator specificprogramcompletion_validator = new ResponseValidator(get_program_response);
        specificprogramcompletion_validator.statusCodeShouldBe(200);

    }
}
