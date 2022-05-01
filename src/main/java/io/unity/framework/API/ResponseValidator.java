package io.unity.framework.API;

import org.json.simple.JSONObject;
import org.testng.Assert;

public class ResponseValidator {

    JSONObject response;

    public ResponseValidator(JSONObject response) {
        this.response = response;
    }

    public void responseContains(String jsonPath, String excpectd) {


    }

    public void statusCodeShouldBe(int statusCode) {
        Assert.assertTrue(Integer.parseInt(response.get("statusCode").toString()) == statusCode);
    }


}
