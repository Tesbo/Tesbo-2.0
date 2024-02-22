package Framework.core.readers;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileReader {


    public JSONObject getTestConfig(String FileName) {


        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get("src/Config/"+ FileName).toAbsolutePath()));
        } catch (Exception e) {
            System.out.println("config file not found");
        }
        JSONObject testConfig = new JSONObject(data);

        return testConfig;
    }

    public String getRunConfig(String FileName) {
        JSONObject object = getTestConfig(FileName);
        return object.getString(FileName);
    }

    public JSONObject getConfigObject(String FileName) {
        JSONObject object = getTestConfig(FileName);
        return (JSONObject) ((JSONObject) object.get(FileName)).get(FileName);
    }

    public String getReportKey(String FileName)
    {
        return (String) getConfigObject(FileName).get("tesboReportKey");
    }



    public String getPlatform(String FileName) {

        return getConfigObject(FileName).getString("platform");

    }

    public String getCurrentReportDirectory() {
        String dir = System.getProperty("user.dir");

        return dir+"/test-output";
    }



    public JSONObject getAPIConfig(String FileName) {

        return (JSONObject) getConfigObject(FileName).get("apiTestConfig");
    }



    public boolean isAPITestConfigEnable(String FileName) {

        return (boolean) getAPIConfig(FileName).get("enable");
    }

    public String getAPIEnv(String FileName) {

        return (String) getAPIConfig(FileName).get("env");
    }

    public String getAPIEnvDirect(String FileName) {

        return (String) getConfigObject(FileName).get("env");
    }


    public JSONObject getTimeAssertion(String FileName) {
        return (JSONObject) getConfigObject(FileName).get("timeAssertion");
    }


    public Boolean isTimeAssertionEnable(String FileName) {
        return (Boolean) getTimeAssertion(FileName).get("enable");
    }

    public int getTimeToCompare(String FileName) {
        return (int) getTimeAssertion(FileName).get("timeToCompareInMs");
    }

    public String getEnv(String FileName) {
        return getConfigObject(FileName).getString("env");
    }


    public boolean isGrid(String FileName) {
        return (boolean) getConfigObject(FileName).get("isGrid");
    }

    public String getBrowser(String FileName) {
        return getConfigObject(FileName).getString("browser");
    }


    public JSONObject get_capabilities(String FileName) {

        return getConfigObject(FileName).getJSONObject("capabilities");
    }


    public JSONObject get_browserStackOption(String FileName) {

        return getConfigObject(FileName).getJSONObject("browserStackOption");
    }


    public JSONObject get_sauceLabOption(String FileName) {

        return getConfigObject(FileName).getJSONObject("sauceLabOption");
    }

    public JSONObject get_lambdaTestOption(String FileName) {

        return getConfigObject(FileName).getJSONObject("lambdaTestOption");
    }


    public String get_grid_url(String FileName) {
        JSONObject object = getTestConfig(FileName);
        return getConfigObject(FileName).getString("gridURL");
    }

    public String get_grid_platForm(String FileName) {
        JSONObject object = getTestConfig(FileName);
        return getConfigObject(FileName).getString("gridPlatform");
    }


    public String get_appium_url(String FileName) {
        JSONObject object = getTestConfig(FileName);
        return getConfigObject(FileName).getString("appiumURL");
    }

    public String get_appium_platform(String FileName) {
        JSONObject object = getTestConfig(FileName);
        return getConfigObject(FileName).getString("appiumPlatform");
    }


    public String get_app_name(String FileName) {

        return getConfigObject(FileName).getString("app");
    }


    public String get_final_app_path(String FileName) {

        String app_path = "";

        File file = new File("src/test/java/mobile/app/" + get_app_name(FileName));
        app_path = file.getAbsolutePath();


        return app_path;
    }


    public JSONArray getSuites(String FileName) throws org.json.JSONException {
        JSONObject object = getTestConfig(FileName);
        return (JSONArray) getConfigObject(FileName).get("testNGsuite");
    }


/*

    public String getEnvFromCurrentConfig() {
        JSONObject object = getTestConfig(configFile);
        JsonFileReader config = new JsonFileReader();
        if (TestRunner.currentConfig.equals("")) {
            TestRunner.currentConfig = config.getRunConfig();
        }
        return getConfigObject(TestRunner.currentConfig).getString("env");
    }
*/



   /* public String getExecutionOn() {
        JSONObject object = getTestConfig();
        return object.getString("executionOn");
    }*/

/*






    public String get_grid_url() {
        JSONObject object = getTestConfig();

        return object.getString("grid_url");

    }

    public JSONObject get_capabilities() {

        JSONObject object = getTestConfig();
        JSONObject platform = (JSONObject) object.get("platform");
        return platform.getJSONObject("capabilities");


    }*/
}
