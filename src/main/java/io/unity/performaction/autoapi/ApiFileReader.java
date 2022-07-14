package io.unity.performaction.autoapi;
import java.io.File;
import io.unity.framework.readers.json_file_reader;
import java.io.BufferedWriter;
import java.io.FileWriter;


import io.unity.framework.readers.json_file_reader;

public class ApiFileReader {


    public void createtempfile() throws Exception {
        BufferedWriter writer = null;
        json_file_reader reader = new json_file_reader();
        File file = File.createTempFile("temp", ".tmp", null);
        System.out.println(file.getAbsolutePath());
        file.deleteOnExit();
        writer = new BufferedWriter(new FileWriter(file));
        writer.write("Writing data into temp file!!!");
    }
}
