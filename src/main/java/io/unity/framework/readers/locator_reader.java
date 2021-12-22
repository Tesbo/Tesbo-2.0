package io.unity.framework.readers;


import io.unity.framework.exception.locator_not_found_exception;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class locator_reader {

    /*public static void main(String[] args) {
        locator_reader reader = new locator_reader();
        try {
            System.out.println(reader.get_locator_value("email_text_box"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String get_locator_value(String locator_name)
    {
        locator_reader reader = new locator_reader();
        JSONObject object = null;
        try {
            object =  reader.get_locator_object(locator_name);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (locator_not_found_exception e) {
            e.printStackTrace();
        }
        return object.get("locator_type").toString()+":"+object.get("locator_value").toString();
    }

    public JSONObject get_locator_object(String locator_object_name) throws IOException, locator_not_found_exception {

        File file = new File("src/test/resources/webapplocators");
        JSONObject object = null;
        try {
            List<File> files = Files.list(Paths.get(file.getAbsolutePath()))
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            for (int i = 0; i < files.size(); i++) {
                System.out.println(files.get(i));
                List<File> folderFiles = Files.list(Paths.get(files.get(i).toString()))
                        .map(Path::toFile)
                        .collect(Collectors.toList());

                for (int j = 0; j < folderFiles.size(); j++) {
                    System.out.println(folderFiles.get(j));
                    object = read_locator_file_and_get_object(folderFiles.get(j).toString(),locator_object_name);
                    if (object != null) {
                        break;
                    }
                }
                if (object != null) {
                    break;
                }
            }
        } catch (IOException e) {
            // Error while reading the directory
        }
        if(object == null)
        {
            throw new locator_not_found_exception("Locator Value " + locator_object_name + " is not found in JSON File");
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

            System.out.println(json);

            object = (JSONObject) json.get(locator_object_name);
        } catch (Exception e) {
                 e.printStackTrace();
        }

        return object;
    }
*/


}
