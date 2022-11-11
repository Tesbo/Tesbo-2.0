package io.unity.performaction.autoapi;

import com.jayway.jsonpath.JsonPath;
import io.unity.framework.exception.ResponseTimeAssertionException;
import io.unity.framework.readers.GetApiConfig;
import io.unity.framework.readers.json_file_reader;
import io.unity.framework.runner.TestRunner;
import io.unity.performaction.autoweb.testng_logs;
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
        logs.test_step("Validating " + jsonPath + " value : " + object + " is equal to expected value : " + excepted);

        Assert.assertTrue(excepted.equals(object));
        logs.test_step("Test Passed");



    }


    public void validateResponseTime(Object apiResponseTime) {
        Long responseTime = (Long) apiResponseTime;
        json_file_reader reader = new json_file_reader();

        if (reader.isTimeAssertionEnable(TestRunner.currentConfig)) {


            if (responseTime <= reader.getTimeToCompare(TestRunner.currentConfig)) {

            } else {
                try {
                    throw new ResponseTimeAssertionException("Api Response time is " + apiResponseTime + " more time then expected : " + reader.getTimeToCompare(TestRunner.currentConfig));
                } catch (ResponseTimeAssertionException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void validateResponseTime(Object ExpectedTime, Object ActualTime) {
        Long expectedTime = (Long) ExpectedTime;
        Long actualTime = (Long) ActualTime;
        json_file_reader reader = new json_file_reader();

        if (actualTime <= expectedTime) {

        } else {
            try {
                throw new ResponseTimeAssertionException("Api Response time is " + actualTime + " more time then expected : " + expectedTime);
            } catch (ResponseTimeAssertionException e) {
                e.printStackTrace();
            }
        }
    }

    public void statusCodeShouldBe(int statusCode) {

        logs.test_step("Validating status code is equal to expected value : " + statusCode);
        Assert.assertTrue(Integer.parseInt(response.get("statusCode").toString()) == statusCode);
        logs.test_step("Test Passed");

    }


    public String getDataFromBody(String jsonPath) {
        return JsonPath.parse(response.toString()).read(jsonPath).toString();

    }


    public void validateSchema(String expectedJSonSchema) {
        UnityJSONParser parser = new UnityJSONParser(expectedJSonSchema);




        for (String singlePath : parser.getPathList()) {

            logs.test_step("Single path to match " + singlePath);
            Object object = JsonPath.parse(response.toJSONString()).read(singlePath);

        }
    }
    public void validateSchemaFromRequestFile(String request_name) {

        GetApiConfig apiConfig = new GetApiConfig(request_name);
        String test = String.valueOf(apiConfig.getSchema());
        UnityJSONParser parser = new UnityJSONParser(test);

        for (String singlePath : parser.getPathList()) {
            Object object = JsonPath.parse(response.toJSONString()).read(singlePath);
        }
    }



}
