package io.tesbo.framework.runner;

import com.beust.jcommander.JCommander;
import io.tesbo.framework.readers.CommandlineOption;
import io.tesbo.framework.readers.config.CurrentConfigGenerator;
import org.json.JSONArray;
import org.testng.TestNG;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

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
        try {

            String configToRun = addCommandLine(args);

            String pathSeparator = FileSystems.getDefault().getSeparator();

            CurrentConfigGenerator configGenerator = new CurrentConfigGenerator();
            configGenerator.generatorCurrentConfigFile(configToRun);


            /*
             * if suite is available then read the suite
             * otherwise generate the suite and provide the list
             *
             * */


            JSONArray suiteList = null;
            String directory_path = "." + pathSeparator + "src" + pathSeparator + "test" + pathSeparator + "java" + pathSeparator + "suites" + pathSeparator;
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

    }

    public Boolean checkForSuiteAvailable() {


    }


}
