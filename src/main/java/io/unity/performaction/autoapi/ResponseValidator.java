package io.unity.performaction.autoapi;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import io.unity.framework.readers.GetApiConfig;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.testng_logs;
import kong.unirest.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.testng.Assert;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.*;

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

   public void validateSchema(String expectedJSonSchema) {
       UnityJSONParser parser = new UnityJSONParser(response.toJSONString());

       for (String singlePath : parser.getPathList()) {
           logs.test_step("finding Element :" + singlePath);
           Object object = JsonPath.parse(expectedJSonSchema).read(singlePath);
           logs.test_step("Element found : Schema Matched");
       }
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
