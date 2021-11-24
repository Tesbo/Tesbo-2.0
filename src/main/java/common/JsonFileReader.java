package common;


import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileReader {



    public JSONObject getTestConfig() {


        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get("src/config/TestConfig.json").toAbsolutePath()));
        } catch (Exception e) {
            System.out.println("config file not found");
        }
        JSONObject testConfig = new JSONObject(data);

        return testConfig;
    }

    public String getEnv() {
        JSONObject object = getTestConfig();
        return object.getString("env");
    }

    public String getExecutionOn() {
        JSONObject object = getTestConfig();
        return object.getString("executionOn");
    }


    public String getPlatformType() {
        JSONObject object = getTestConfig();
       JSONObject platform = (JSONObject) object.get("platform");
        return platform.getString("platformType");
    }


    public String getBrowser() {
        JSONObject object = getTestConfig();
        JSONObject platform = (JSONObject) object.get("platform");
        return platform.getString("browser");
    }


    public void getLocatorObject(String file_path)
    {
       JsonFileReader reader = new JsonFileReader();
       try {
           InputStream is = reader.getFileAsIOStream("file_path");
           StringBuilder builder = reader.printFileContent(is);
       }catch(Exception e)
       {

       }

    }

    private InputStream getFileAsIOStream(final String fileName)
    {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    private StringBuilder printFileContent(InputStream is) throws IOException
    {
        StringBuilder builder = new StringBuilder();
        try (InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);)
        {
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            is.close();
        }
        return builder;
    }
}
