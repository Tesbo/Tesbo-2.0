package io.unity.framework.API;

import com.jayway.jsonpath.JsonPath;
import io.unity.autoweb.testng_logs;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class ResponseValidator {

    JSONObject response;
    testng_logs logs = new testng_logs();

    public ResponseValidator(JSONObject response) {
        this.response = response;
    }


    public void responseShouldContains(String jsonPath, Object excepted) {

        Object object = JsonPath.parse(response.toString()).read(jsonPath);
        logs.test_step("Validating "+jsonPath + " value : " + object + " is equal to expected value : " + excepted );

        Assert.assertTrue(excepted.equals(object));
        logs.test_step("Test Passed");

    }

    public void statusCodeShouldBe(int statusCode) {

        logs.test_step("Validating status code is equal to expected value : " + statusCode );
        Assert.assertTrue(Integer.parseInt(response.get("statusCode").toString()) == statusCode);
        logs.test_step("Test Passed");

    }


    public String getDataFromBody(String jsonPath) {
        return JsonPath.parse(response.toString()).read(jsonPath).toString();

    }


}
