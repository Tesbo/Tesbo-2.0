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



  /*  public ResponseValidator(JSONObject response) {
        this.response = response;
    }*/


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

   public void validateSchema(String jsonString) {
       UnityJSONParser parser = new UnityJSONParser(response.toJSONString());

       for (String singlePath : parser.getPathList()) {

           Object object = JsonPath.parse(jsonString).read(singlePath);

           try {

               assertThat(object).isNotNull();

           } catch (Exception e) {

           }

       }
   }




    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        ResponseValidator validator = new ResponseValidator();
        try {

           String abc =  parser.parse(new String(Files.readAllBytes(Paths.get("src/test/java/api/data/response.json").toAbsolutePath()))).toString();

            UnityJSONParser parser2 = new UnityJSONParser(abc);
            System.out.println(     parser2.getPathList());

            for(String q : parser2.getPathList())
            {
                System.out.println(q);

                Object object = JsonPath.parse(abc).read(q);

try {
    System.out.println(   ! object.equals(null));
}catch (Exception e)
{

}



            }

      //      validator.compareJsonData((JSONObject) parser.parse(new String(Files.readAllBytes(Paths.get("src/test/java/api/data/response.json").toAbsolutePath()))),"delete_sequence_with_valid_token");

     //   validator. printJsonObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void compareJsonData(JSONObject response,String request_name) throws JSONException, IOException, ParseException {
       /* JSONParser parser = new JSONParser();
        Object obj = parser.parse(new String(Files.readAllBytes(Paths.get("src/test/java/api/data/"+request_name+".json").toAbsolutePath())));
        JSONObject expectedJsonObj = (JSONObject)obj;

        JSONObject actualJsonObj = response;


        JSONAssert.assertEquals(expectedJsonObj.toString(), actualJsonObj.toString(),JSONCompareMode.STRICT_ORDER);*/


    }

    public  void printJsonObject(JSONObject jsonObj) {
       /* jsonObj.keySet().forEach(keyStr ->
        {
            Object keyvalue = jsonObj.get(keyStr);
            System.out.println("key: "+ keyStr + " value: " + keyvalue);

            //for nested objects iteration if required
       //     if (keyvalue instanceof JSONObject)
         //    printJsonObject((JSONObject)keyvalue);
        });*/

        Configuration conf = Configuration.defaultConfiguration();

        Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonObj.toJSONString());

        List<Map<String, Object>> expensiveBooks = JsonPath
                .using(conf)
                .parse(jsonObj.toJSONString())
                .read("$..*");

        System.out.println(expensiveBooks);


      /*  List<String> jsonPaths = JsonPath.using(conf).parse(jsonObj).read("$");

        for (String path : jsonPaths) {
            System.out.println(path);
        }*/


    }

}
