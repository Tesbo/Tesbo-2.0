package io.unity.framework.generators.locatorgenerator;

import org.json.simple.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;

public class GeneratePageObjectFile {



    public void createPageObjectFile(JSONObject array, String fileName) {

        try {

            Path fileName1 = Path.of(
                    EntryPoint.pageObjectDirectory + "/" + fileName);

            Files.writeString(fileName1, array.toJSONString());


            System.out.println("---------------------------------------- file generated " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
