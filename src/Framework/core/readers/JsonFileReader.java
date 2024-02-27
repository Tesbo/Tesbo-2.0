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

/*
    public JSONObject getConfigObject(String FileName) {
        JSONObject object = getTestConfig(FileName);
        return (JSONObject) ((JSONObject) object.get(FileName));
    }*/

    public String getReportKey(String FileName)
    {
        return (String) getTestConfig(FileName).get("tesboReportKey");
    }



    public String getPlatform(String FileName) {
        JSONObject object = getTestConfig(FileName);
        return object.getString("platform");

    }

    public String getCurrentReportDirectory() {
        String dir = System.getProperty("user.dir");

        return dir+"/test-output";
    }



    public JSONObject getAPIConfig(String FileName) {

        return (JSONObject) getTestConfig(FileName).get("apiTestConfig");
    }



    public boolean isAPITestConfigEnable(String FileName) {

        return (boolean) getAPIConfig(FileName).get("enable");
    }

    public String getAPIEnv(String FileName) {

        return (String) getTestConfig(FileName).get("env");
    }

    public String getAPIEnvDirect(String FileName) {

        return (String) getTestConfig(FileName).get("env");
    }


    public JSONObject getTimeAssertion(String FileName) {
        return (JSONObject) getTestConfig(FileName).get("timeAssertion");
    }


    public Boolean isTimeAssertionEnable(String FileName) {
        return (Boolean) getTimeAssertion(FileName).get("enable");
    }

    public int getTimeToCompare(String FileName) {
        return (int) getTimeAssertion(FileName).get("timeToCompareInMs");
    }

    public String getEnv(String FileName) {
        return getTestConfig(FileName).getString("env");
    }


    public boolean isGrid(String FileName) {
        return (boolean) getTestConfig(FileName).get("isGrid");
    }

    public String getBrowser(String FileName) {
        return getTestConfig(FileName).getString("browser");
    }


    public JSONObject get_capabilities(String FileName) {

        return getTestConfig(FileName).getJSONObject("capabilities");
    }


    public JSONObject get_browserStackOption(String FileName) {

        return getTestConfig(FileName).getJSONObject("browserStackOption");
    }


    public JSONObject get_sauceLabOption(String FileName) {

        return getTestConfig(FileName).getJSONObject("sauceLabOption");
    }

    public JSONObject get_lambdaTestOption(String FileName) {
        JSONObject object= getTestConfig(FileName);
        return getTestConfig(FileName).getJSONObject("lambdaTestOption");
    }


    public String get_grid_url(String FileName) {
        JSONObject object = getTestConfig(FileName);
        return object.getString("gridURL");
    }

    public String get_grid_platForm(String FileName) {
        JSONObject object = getTestConfig(FileName);
        return object.getString("gridPlatform");
    }


    public String get_appium_url(String FileName) {
        JSONObject object = getTestConfig(FileName);
        return object.getString("appiumURL");
    }

    public String get_appium_platform(String FileName) {
        JSONObject object = getTestConfig(FileName);
        return object.getString("appiumPlatform");
    }


    public String get_app_name(String FileName) {

        return getTestConfig(FileName).getString("app");
    }


    public String get_final_app_path(String FileName) {

        String app_path = "";

        File file = new File("src/test/java/mobile/app/" + get_app_name(FileName));
        app_path = file.getAbsolutePath();


        return app_path;
    }


    public JSONArray getSuites(String FileName) throws org.json.JSONException {
        JSONObject object = getTestConfig(FileName);
        return (JSONArray) object.get("testNGsuite");
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
