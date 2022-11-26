package io.unity.framework.runner;

import com.beust.jcommander.JCommander;
import io.tesbo.report.ReportGenerator;
import io.tesbo.report.RequestBuilder;
import io.unity.framework.readers.CommandlineOption;
import io.unity.framework.readers.json_file_reader;
import org.json.JSONArray;
import org.testng.TestNG;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static String currentConfig = "";

    public String addCommandLine(String[] args) {
        CommandlineOption option = null;
        try {
            option = new CommandlineOption();

            JCommander runOption = JCommander.newBuilder()
                    .addObject(option)
                    .build();
            runOption.parse(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return option.getConfigName();
    }

    public void start(String[] args) {

        TestNG testng = new TestNG();
        json_file_reader config = new json_file_reader();
        try {

            String configToRun = addCommandLine(args);


            String pathSeparator = FileSystems.getDefault().getSeparator();

            currentConfig = configToRun;

            if (currentConfig.equals(null)) {
                currentConfig = config.getRunConfig();
            }

            System.out.println("config to run : " + currentConfig);
            JSONArray suiteList = null;
            String directory_path = "." + pathSeparator + "src" + pathSeparator + "src/test" + pathSeparator + "java" + pathSeparator + "suites" + pathSeparator;

            suiteList = config.getSuites(currentConfig);

            if (suiteList.length() != 0) {
                List<String> testFilesList = new ArrayList<String>();

                for (Object suiteName : suiteList) {
                    testFilesList.add(new File((directory_path + suiteName)).getAbsolutePath());
                }
                testng.setTestSuites(testFilesList); //you can addd multiple suites either here by adding multiple files or include all suites needed in the testng.xml file
            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            testng.run();
        } catch (Exception e) {
            e.printStackTrace();

        }



        try {
            ReportGenerator generator = new ReportGenerator();
            generator.generateReportDirectly(config.getReportKey(currentConfig), config.getCurrentReportDirectory(), config.getPlatform(currentConfig), config.getBrowser(currentConfig), "", "");
        }catch (Exception e)
        {

        }

    }
}
