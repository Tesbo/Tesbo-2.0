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
    long startNanos = System.nanoTime();

    public JSONObject performRequest(String requestName) {

        String responseBody = "";
        HttpResponse response = null;
        JSONObject responseObject = null;
        HttpRequest request = null;
        long responset = 0;

        GetApiConfig apiConfig = new GetApiConfig(requestName);
        String endPoint = apiConfig.getEndPoint();
        Map Header = apiConfig.getHeaderMap();
        Map Body = apiConfig.getBodyMap();

        logs.test_step("========================================================================");
        logs.test_step("Performing Request : " + requestName);
        logs.test_step("Request End Point : " + endPoint);
        logs.test_step("Request Headers : " + Header);
        logs.test_step("Request body : " + Body);

        if (apiConfig.getMethodType().equalsIgnoreCase("get")) {

            request = Unirest.get(endPoint).headers(Header);
            long startNanos = System.nanoTime();
            response = request.asString();
            responset = System.nanoTime() - startNanos;
            responseBody = (String) response.getBody();


        }

        if (apiConfig.getMethodType().equalsIgnoreCase("delete")) {

            request = Unirest.delete(endPoint).headers(apiConfig.getHeaderMap());
            response = request.asString();
            responset = System.nanoTime() - startNanos;
            responseBody = (String) response.getBody();

            int responsetime = (int) responset;
            System.out.println("Response Time : " + responsetime + " sec");
        }

        if (apiConfig.getMethodType().equalsIgnoreCase("post")) {

            request = Unirest.post(endPoint).headers(Header).body(apiConfig.getBodyMap());

            response = request.asString();
            responset = System.nanoTime() - startNanos;
            responseBody = (String) response.getBody();


        }

        if (apiConfig.getMethodType().equalsIgnoreCase("patch")) {
            logs.test_step("Request body : " + apiConfig.getHeaderMap());
            System.out.println(apiConfig.getHeaderMap());
            System.out.println(apiConfig.getBody());

            request = Unirest.patch(endPoint).headers(apiConfig.getHeaderMap()).body(apiConfig.getBodyMap());

            response = request.asString();
            responset = System.nanoTime() - startNanos;
            responseBody = (String) response.getBody();

            int responsetime = (int) responset;
            System.out.println("Response Time : " + responsetime + " sec");
        }

        logs.test_step("========================================================================");
        logs.test_step("getting response : ");
        JSONParser parser = new JSONParser();
        try {
            responseObject = (JSONObject) parser.parse(responseBody);
            responseObject.put("responseTime",  TimeUnit.MILLISECONDS.convert(responset, TimeUnit.NANOSECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        responseObject.put("statusCode", response.getStatus());
        logs.test_step("Response object : " + responseObject);
        logs.test_step("========================================================================");
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
            long responset = (System.nanoTime() - startNanos) / 1000000000;
            int responsetime = (int) responset;
            System.out.println(responsetime);
        }
        if (apiConfig.getMethodType().equalsIgnoreCase("post")) {
            logs.test_step("Request body : " + apiConfig.getHeaderMap());
            System.out.println(apiConfig.getHeaderMap());
            System.out.println(apiConfig.getBody());


            request = Unirest.post(endpoint).headers(apiConfig.getHeaderMap()).body(apiConfig.getBodyMap());

            response = request.asString();
            responseBody = (String) response.getBody();
            long responset = (System.nanoTime() - startNanos) / 1000000000;
            int responsetime = (int) responset;
            System.out.println(responsetime);
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
            responseBody = (String) response.getBody();
            long responsetime = System.nanoTime() - startNanos;
            System.out.println(responsetime);
        }

        if (apiConfig.getMethodType().equalsIgnoreCase("post")) {
            logs.test_step("Request body : " + headers);


            request = Unirest.post(apiConfig.getEndPoint()).headers(headers).body(body);
            response = request.asString();
            responseBody = (String) response.getBody();
            long responsetime = System.nanoTime() - startNanos;
            System.out.println(responsetime);
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
            long responsetime = System.nanoTime() - startNanos;
            System.out.println(responsetime);
        }

        if (apiConfig.getMethodType().equalsIgnoreCase("post")) {
            logs.test_step("Request body : " + apiConfig.getBodyMap());

            request = Unirest.post(apiConfig.getEndPoint()).headers(headers).body(apiConfig.getBodyMap());
            response = request.asString();
            responseBody = (String) response.getBody();
            long responsetime = System.nanoTime() - startNanos;
            System.out.println(responsetime);
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
        System.out.println(f.getAbsolutePath());
        if (!f.exists()) {
            try {
                f.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return f.getAbsolutePath();
    }


    public String updateRequestObject(String fileName, JSONObject pathParameter, JSONObject queryParameter, JSONObject header, JSONObject body) {
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

        File updatedFile = new File(folder_path + "/" + TestData.random_alpha_numeric_string(6) + ".json");

        try {
            System.out.println(updatedFile);
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
