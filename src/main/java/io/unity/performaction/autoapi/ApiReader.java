package io.unity.performaction.autoapi;

import io.unity.framework.readers.GetApiConfig;
import io.unity.performaction.autoweb.testng_logs;
import kong.unirest.HttpRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

    public class ApiReader {

        testng_logs logs = new testng_logs();

        public JSONObject performRequestwithrequest(String requestName) throws IOException {

            File file = File.createTempFile("temp", ".tmp", null);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
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

                request = Unirest.get(apiConfig.getEndPoint()).headers(apiConfig.getHeaderMap());
                response = request.asString();
                responseBody = (String) response.getBody();
                bw.write(String.valueOf(request));
                bw.write(String.valueOf(response));
                bw.write(String.valueOf(responseBody));
            }

            if (apiConfig.getMethodType().equalsIgnoreCase("post")) {
                logs.test_step("Request body : " + apiConfig.getHeaderMap());
                System.out.println(apiConfig.getHeaderMap());
                System.out.println(apiConfig.getBody());


                request = Unirest.post(apiConfig.getEndPoint()).headers(apiConfig.getHeaderMap()).body(apiConfig.getBodyMap());

                response = request.asString();
                responseBody = (String) response.getBody();
                bw.write(String.valueOf(request));
                bw.write(String.valueOf(response));
                bw.write(String.valueOf(responseBody));
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

            bw.close();
            return responseObject;
        }
}
