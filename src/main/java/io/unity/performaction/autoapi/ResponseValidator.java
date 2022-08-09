package io.unity.performaction.autoapi;

import com.jayway.jsonpath.JsonPath;

import com.jayway.jsonpath.Predicate;
import io.unity.framework.readers.GetApiConfig;
import io.unity.performaction.autoweb.testng_logs;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.util.Iterator;

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

   public String validateSchema(String expectedJSonSchema) {
       UnityJSONParser parser = new UnityJSONParser(this.response.toJSONString());
       Iterator var3 = parser.getPathList().iterator();
       String singlePath = null;

       while(var3.hasNext()) {
           singlePath = (String)var3.next();
           this.logs.test_step("finding Element :" + singlePath);
           Object object = JsonPath.parse(expectedJSonSchema).read(singlePath, new Predicate[0]);
           this.logs.test_step("Element found : Schema Matched");
       }
       return singlePath;
   }

    public void validateSchemaFromRequestFile(String request_name) {
        UnityJSONParser parser = new UnityJSONParser(response.toJSONString());

        GetApiConfig apiConfig = new GetApiConfig(request_name);
        for (String singlePath : parser.getPathList()) {
            logs.test_step("finding Element :" + singlePath);
            Object object = JsonPath.parse(apiConfig.getSchema()).read(singlePath);
            logs.test_step("Element found : Schema Matched");
        }
    }

}
