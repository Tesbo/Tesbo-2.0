package io.unity.framework;

import com.beust.jcommander.JCommander;
import io.unity.framework.readers.CommandlineOption;
import io.unity.framework.readers.json_file_reader;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.TestNG;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static String currentConfig = "";

    public String addCommandLine(String[] args) {
        CommandlineOption option = new CommandlineOption();

        JCommander runOption = JCommander.newBuilder()
                .addObject(option)
                .build();
        runOption.parse(args);

        return option.getConfigName();
    }

    public void start(String[] args) {
        String configToRun = addCommandLine(args);

        json_file_reader config = new json_file_reader();

        TestNG testng = new TestNG();
        currentConfig = configToRun;

        if (currentConfig.equals(null)) {
            currentConfig = config.getRunConfig();
        }

        System.out.println("config to run : " + currentConfig);
        JSONArray suiteList = null;
        try {
            suiteList = config.getSuites(currentConfig);

        if (suiteList.length() != 0) {
            List<String> testFilesList = new ArrayList<String>();

            for (Object suiteName : suiteList) {
                testFilesList.add(new File("./src/test/java/suites/" + suiteName).getAbsolutePath());
            }
            testng.setTestSuites(testFilesList); //you can addd multiple suites either here by adding multiple files or include all suites needed in the testng.xml file
        }else{



        }

        } catch (JSONException e) {

        }
        testng.run();


    }
}
