package io.unity.performaction.autoapi;
import org.jetbrains.annotations.NotNull;

import java.io.*;
//import java.util.Arrays;
//
//import io.unity.framework.readers.GetApiConfig;
//import io.unity.framework.readers.json_file_reader;
//
//
//import io.unity.framework.readers.json_file_reader;
//import io.unity.performaction.autoweb.testng_logs;
//import kong.unirest.HttpRequest;
//import kong.unirest.HttpResponse;
//import kong.unirest.Unirest;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import io.unity.performaction.autoweb.testng_logs;

public class ApiFileReader {

    //json_file_reader config = new json_file_reader();
    //testng_logs logs = new testng_logs();

    public String updateendpointest(String requestName)
            throws IOException {

        File file = File.createTempFile("temp", ".tmp", null);
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
      //  GetApiConfig apiConfig = new GetApiConfig(requestName);
      //  BufferedReader br = new BufferedReader(new FileReader(""));


       /* String responseBody = "";
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
        }

        if (apiConfig.getMethodType().equalsIgnoreCase("post")) {
            logs.test_step("Request body : " + apiConfig.getHeaderMap());
            System.out.println(apiConfig.getHeaderMap());
            System.out.println(apiConfig.getBody());


            request = Unirest.post(apiConfig.getEndPoint()).headers(apiConfig.getHeaderMap()).body(apiConfig.getBodyMap());

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
        logs.test_step("========================================================================");*/

        String specialcharacter = "{}";
        for(int i=0; i<requestName.length(); i++){
            char ch = requestName.charAt(i);
            if (specialcharacter.contains(Character.toString(ch))){
                requestName = requestName.replaceAll("[^a-zA-Z0-9]", "");
                System.out.println(requestName);
                bw.write(requestName);
            } else if (i == requestName.length()-1) {
                System.out.println("EndPoint does not contain the path parameter");
            }
        }
        bw.close();
        return requestName;

    }
}