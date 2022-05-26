package io.unity.framework.generators.methodsgenerator.classutilities;

import java.io.BufferedReader;
import java.io.FileReader;

public class JavaFileReader {


    public String read_java_file(String file_to_read) {
        StringBuffer buffer = null;
        try {
            BufferedReader br
                    = new BufferedReader(new FileReader(file_to_read));
            String st;
            buffer = new StringBuffer();
            while ((st = br.readLine()) != null) {
                buffer.append(st);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Java File Generated SuccessFully...");

        return buffer.toString();
    }

}
