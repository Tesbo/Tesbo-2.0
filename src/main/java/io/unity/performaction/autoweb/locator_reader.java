package io.unity.performaction.autoweb;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class locator_reader {

    public static void main(String[] args) {
           locator_reader reader = new locator_reader();
        try {
            //       System.out.println(reader.get_locator_value("email_text_box"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public org.json.JSONObject getTestConfig() {
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get("src/config/TestConfig.json").toAbsolutePath()));
        } catch (Exception e) {
            System.out.println("config file not found");
        }
        org.json.JSONObject testConfig = new org.json.JSONObject(data);
        return testConfig;
    }


    public String getRunConfig() {
        org.json.JSONObject object = getTestConfig();
        return object.getString("run");
    }

    public org.json.JSONObject getConfigObject(String configName) {
        org.json.JSONObject object = getTestConfig();
        return (org.json.JSONObject) ((org.json.JSONObject) object.get("config")).get(configName);
    }

    public String getPlatform() {

        return getConfigObject(getRunConfig()).getString("platform");

    }

    public String get_locator_value(String locator_name) {
          locator_reader reader = new locator_reader();
        JSONObject object = null;
        String locator_value = null;
        try {
            object = reader.get_locator_object(locator_name, getPlatform());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (getPlatform().equalsIgnoreCase("web")) {
            locator_value = object.get("locator_type").toString() + ":" + object.get("web_locator").toString();
        } else if (getPlatform().equalsIgnoreCase("android")) {
            locator_value = object.get("locator_type").toString() + ":" + object.get("android_locator").toString();
        } else if (getPlatform().equalsIgnoreCase("ios")) {
            locator_value = object.get("locator_type").toString() + ":" + object.get("iOS_locator").toString();
        }


        return locator_value;
    }


    public List<String> look_for_locator_json_file(String folder_path) {
        File dir = new File(folder_path);

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".json");
            }
        };

        List<String> result = null;
        try (Stream<Path> walk = Files.walk(Paths.get(folder_path))) {
            // We want to find only regular files
            result = walk.filter(Files::isRegularFile).filter(p -> p.getFileName().toString().endsWith(".json"))
                    .map(x -> x.toString()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public JSONObject get_locator_object(String locator_object_name, String platform) throws Exception {
        File file = null;
        if (platform.equals("web")) {
            file = new File("src/test/java/web/object_repository/");

        } else if (platform.equalsIgnoreCase("android") || platform.equalsIgnoreCase("iOS")) {
            file = new File("src/test/java/mobile/object_repository/");
        }

        JSONObject object = null;
        try {

            List<String> files = look_for_locator_json_file(file.getAbsolutePath());


            for (int i = 0; i < files.size(); i++) {

                object = read_locator_file_and_get_object(files.get(i).toString(), locator_object_name);
                if (object != null) {
                    break;
                }


            }
        } catch (Exception e) {
            // Error while reading the directory
            e.printStackTrace();
        }
        if (object == null) {
            throw new Exception("Locator Value " + locator_object_name + " is not found in JSON File");
        }
        return object;
    }


    public JSONObject read_locator_file_and_get_object(String file_path, String locator_object_name) {
       locator_reader reader = new locator_reader();
        JSONObject object = null;
        JSONParser parser = new JSONParser();
        JSONObject json = null;
        try {

            json = (JSONObject) parser.parse(new String(Files.readAllBytes(Paths.get(file_path).toAbsolutePath())));


            object = (JSONObject) json.get(locator_object_name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }


}
