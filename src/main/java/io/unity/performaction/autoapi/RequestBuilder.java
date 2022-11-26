package io.unity.performaction.autoapi;

import io.unity.framework.data.TestData;
import io.unity.framework.readers.GetApiConfig;
import io.unity.performaction.autoweb.testng_logs;
import kong.unirest.HttpRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RequestBuilder {

    testng_logs logs = new testng_logs();

    public JSONObject performRequest(String requestName) {

        String responseBody = "";
        HttpResponse response = null;
        JSONObject responseObject = null;
        HttpRequest request = null;
        String responseSchema = "";


        GetApiConfig apiConfig = new GetApiConfig(requestName);
        String endPoint = apiConfig.getEndPoint();
        org.json.JSONObject schema = apiConfig.getSchema();
        Map Header = apiConfig.getHeaderMap();
        Map Body = apiConfig.getBodyMap();


        logs.test_step("Request End Point : " + endPoint);

        if (apiConfig.getMethodType().equalsIgnoreCase("get")) {


            logs.test_step("Header : " + Header);


            request = Unirest.get(endPoint).headers(Header);
            response = request.asString();
            responseBody = (String) response.getBody();

        }

        if (apiConfig.getMethodType().equalsIgnoreCase("delete")) {

            logs.test_step("Header : " + apiConfig.getHeaderMap());

            request = Unirest.delete(endPoint).headers(apiConfig.getHeaderMap());
            response = request.asString();
            responseBody = (String) response.getBody();


        }

        if (apiConfig.getMethodType().equalsIgnoreCase("post")) {

            logs.test_step("Header : " + Header);

            logs.test_step("Body : " + apiConfig.getBodyMap());
            request = Unirest.post(endPoint).headers(Header).body(apiConfig.getBodyMap());
            response = request.asString();
            responseBody = (String) response.getBody();


        }

        if (apiConfig.getMethodType().equalsIgnoreCase("patch")) {

            logs.test_step("Header : " + apiConfig.getHeaderMap());
            logs.test_step("Body : " + apiConfig.getBody().toString());

            request = Unirest.patch(endPoint).headers(apiConfig.getHeaderMap()).body(apiConfig.getBody().toString());

            response = request.asString();
            responseBody = (String) response.getBody();


        }


        logs.test_step("getting response : ");
        JSONParser parser = new JSONParser();
        try {


            responseObject = (JSONObject) parser.parse(responseBody);
            long responset = 0;
            responseObject.put("responseTime", TimeUnit.MILLISECONDS.convert(responset, TimeUnit.NANOSECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        responseObject.put("statusCode", response.getStatus());
        logs.test_step("Response object : " + responseObject);
        return responseObject;
    }

    @Deprecated
    public JSONObject performRequest(String requestName, String endpoint) {

        String responseBody = "";
        HttpResponse response = null;
        JSONObject responseObject = null;
        HttpRequest request = null;
        GetApiConfig apiConfig = new GetApiConfig(requestName);

        logs.test_step("========================================================================");
        logs.test_step("Performing Request : " + requestName);
        logs.test_step("Request End Point : " + requestName);
        logs.test_step("Request Headers : " + apiConfig.getHeaderMap());


        if (apiConfig.getMethodType().equalsIgnoreCase("get")) {
            request = Unirest.get(endpoint).headers(apiConfig.getHeaderMap());
            response = request.asString();
            responseBody = (String) response.getBody();

        }
        if (apiConfig.getMethodType().equalsIgnoreCase("post")) {
            logs.test_step("Request body : " + apiConfig.getHeaderMap());
            System.out.println(apiConfig.getHeaderMap());
            System.out.println(apiConfig.getBody());


            request = Unirest.post(endpoint).headers(apiConfig.getHeaderMap()).body(apiConfig.getBodyMap());

            response = request.asString();
            responseBody = (String) response.getBody();

        }

        logs.test_step("========================================================================");
        logs.test_step("getting response : ");
        JSONParser parser = new JSONParser();
        try {
            responseObject = (JSONObject) parser.parse(responseBody);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        responseObject.put("statusCode", response.getStatus());
        logs.test_step("Response object : " + responseObject);
        logs.test_step("========================================================================");
        return responseObject;
    }

    @Deprecated
    public JSONObject performRequestWithHeaderAndBody(String requestName, Map headers, Map body) {
        String responseBody = "";
        HttpResponse response = null;
        JSONObject responseObject = null;
        HttpRequest request = null;
        GetApiConfig apiConfig = new GetApiConfig(requestName);

        logs.test_step("========================================================================");
        logs.test_step("Performing Request : " + requestName);
        logs.test_step("Request End Point : " + requestName);
        logs.test_step("Request Headers : " + headers);

        if (apiConfig.getMethodType().equalsIgnoreCase("get")) {
            request = Unirest.get(apiConfig.getEndPoint()).headers(headers);
            response = request.asString();

        }

        if (apiConfig.getMethodType().equalsIgnoreCase("post")) {
            logs.test_step("Request body : " + headers);


            request = Unirest.post(apiConfig.getEndPoint()).headers(headers).body(body);
            response = request.asString();
            responseBody = (String) response.getBody();

        }
        logs.test_step("========================================================================");
        logs.test_step("getting response : ");
        JSONParser parser = new JSONParser();
        try {
            responseObject = (JSONObject) parser.parse(responseBody);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        logs.test_step("Response object : " + responseObject);
        logs.test_step("========================================================================");
        responseObject.put("statusCode", response.getStatus());
        return responseObject;
    }

    @Deprecated
    public JSONObject performRequestWithCustomHeader(String requestName, Map headers) {
        String responseBody = "";
        HttpResponse response = null;
        JSONObject responseObject = null;
        HttpRequest request = null;
        GetApiConfig apiConfig = new GetApiConfig(requestName);

        logs.test_step("========================================================================");
        logs.test_step("Performing Request : " + requestName);
        logs.test_step("Request End Point : " + requestName);
        logs.test_step("Request Headers : " + headers);

        if (apiConfig.getMethodType().equalsIgnoreCase("get")) {
            request = Unirest.get(apiConfig.getEndPoint()).headers(headers);
            response = request.asString();
            responseBody = (String) response.getBody();

        }

        if (apiConfig.getMethodType().equalsIgnoreCase("post")) {
            logs.test_step("Request body : " + apiConfig.getBodyMap());

            request = Unirest.post(apiConfig.getEndPoint()).headers(headers).body(apiConfig.getBodyMap());
            response = request.asString();
            responseBody = (String) response.getBody();

        }
        logs.test_step("========================================================================");
        logs.test_step("getting response : ");
        JSONParser parser = new JSONParser();
        try {
            responseObject = (JSONObject) parser.parse(responseBody);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        logs.test_step("Response object : " + responseObject);
        logs.test_step("========================================================================");
        responseObject.put("statusCode", response.getStatus());
        return responseObject;
    }


    public String createTempFolder() {
        File f = new File("./src/test/java/api/data/temp");
        if (!f.exists()) {
            try {
                f.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return f.getAbsolutePath();
    }


    public String updateRequestObject(String fileName, JSONObject pathParameter, JSONObject queryParameter, JSONObject header, JSONObject body, JSONObject schema) {
        String folder_path = createTempFolder();
        GetApiConfig config = new GetApiConfig(fileName);
        org.json.JSONObject baseConfig = config.getApiConfig();


        if (!pathParameter.isEmpty()) {
            baseConfig.put("pathParameter", pathParameter);
        }

        if (!header.isEmpty()) {
            baseConfig.put("header", header);
        }

        if (!body.isEmpty()) {
            baseConfig.put("body", body);
        }

        if (!queryParameter.isEmpty()) {
            baseConfig.put("queryParameter", queryParameter);
        }

        if (!schema.isEmpty()) {
            baseConfig.put("schema", schema);
        }

        File updatedFile = new File(folder_path + "/" + TestData.random_alpha_numeric_string(6) + ".json");

        try {
            updatedFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter file = null;
        try {
            file = new FileWriter(updatedFile);
            file.write(baseConfig.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return updatedFile.getAbsolutePath();
    }


}
