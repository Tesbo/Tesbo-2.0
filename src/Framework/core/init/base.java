package Framework.core.init;

import Framework.core.data.TestData;
import Framework.core.readers.JsonFileReader;
import Framework.core.remotegrid.LambdaTestConfig;
import Framework.core.runner.TestRunner;
import Framework.performaction.autoweb.Browser;
import Framework.performaction.autoweb.TestngLogs;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import kong.unirest.Unirest;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.tinylog.Logger;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;

public class base {

    String env = "";
    String platform = "";
    String browserName = "";
    String execution_on = "";
    public Browser browser;


    public WebDriver driver;
    JsonFileReader config = new JsonFileReader();
    TestngLogs logs = new TestngLogs();

public static String build_Name;

    @BeforeSuite
    public void beforeSuiteWorks()
    {

        build_Name = "Build_" + TestData.getTodayDateinFormat("dd-MMM-yyyy");

    }
    @BeforeMethod
    public WebDriver init() {

        try {
        if (TestRunner.currentConfig.equals("")) {
                TestRunner.currentConfig = config.getRunConfig();
            }

            platform = config.getPlatform(TestRunner.currentConfig);

            Logger.info("Base config to run : " + TestRunner.currentConfig);

            if (platform.equalsIgnoreCase("web")) {

                if (config.isGrid(TestRunner.currentConfig)) {
                    setup_browser_for_grid(TestRunner.currentConfig);
                } else {
                    setup_browser(TestRunner.currentConfig);
                }
                env = config.getEnv(TestRunner.currentConfig);
                browser = new Browser(driver);
                browser.open_url(env);

                if (config.isAPITestConfigEnable(TestRunner.currentConfig)) {
                    Unirest.config().defaultBaseUrl(config.getAPIEnv(TestRunner.currentConfig));
                }
            } else if (platform.equalsIgnoreCase("android")) {
                System.out.println("Inside android");
                setup_android(TestRunner.currentConfig);
            } else if (platform.equalsIgnoreCase("iOS")) {
                System.out.println("Inside iOS");
                setup_iOS(TestRunner.currentConfig);

            } else if (platform.equalsIgnoreCase("api")) {
                Unirest.config().defaultBaseUrl(config.getAPIEnvDirect(TestRunner.currentConfig));
            } else {
               Logger.info("Platform type you entered is not supported");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    public WebDriver init(String config_name) {

        try {
            platform = config.getPlatform(config_name);

            System.out.println("Base config to run : " + config_name);

            if (platform.equalsIgnoreCase("web")) {

                if (config.isGrid(config_name)) {
                    setup_browser_for_grid(config_name);
                } else {
                    setup_browser(config_name);
                }
                env = config.getEnv(config_name);
                browser = new Browser(driver);
                browser.open_url(env);

                if (config.isAPITestConfigEnable(config_name)) {
                    Unirest.config().defaultBaseUrl(config.getAPIEnv(config_name));
                }
            } else if (platform.equalsIgnoreCase("android")) {
                System.out.println("Inside android");
                setup_android(config_name);
            } else if (platform.equalsIgnoreCase("iOS")) {
                System.out.println("Inside iOS");
                setup_iOS(config_name);

            } else if (platform.equalsIgnoreCase("api")) {
                Unirest.config().defaultBaseUrl(config.getAPIEnvDirect(config_name));
            } else {
                System.out.println("Platform type you entered is not supported");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }


    public WebDriver setup_browser(String configName) {
        System.out.println("Setting up browser");
        browserName = config.getBrowser(configName);
        System.out.println("browser name :" + browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(ops);
            System.out.println("Inside chrome");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Inside firefox");
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("Inside edge");
        }
        else if (browserName.equalsIgnoreCase("chrome-headless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return driver;
    }

    public WebDriver setup_browser_for_grid(String configName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        JSONObject object = config.get_capabilities(configName);
        Iterator<String> keys = object.keys();
        capabilities.setBrowserName(config.getBrowser(configName));

        if (config.get_grid_platForm(configName).equalsIgnoreCase("selenium")) {
            while (keys.hasNext()) {
                String key = keys.next();
                capabilities.setCapability(key, object.get(key));
            }

        } else if (config.get_grid_platForm(configName).equalsIgnoreCase("browserstack")) {

            JSONObject browserStackOptionObject = config.get_browserStackOption(configName);

            while (keys.hasNext()) {
                String key = keys.next();
                capabilities.setCapability(key, object.get(key));
            }
            Iterator<String> browserStackOptionKey = browserStackOptionObject.keys();
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();


            while (browserStackOptionKey.hasNext()) {
                String key = browserStackOptionKey.next();

                browserstackOptions.put(key, object.get(key));
            }

            capabilities.setCapability("bstack:options", browserstackOptions);


        } else if (config.get_grid_platForm(configName).equalsIgnoreCase("saucelab")) {

            JSONObject sauceLabOption = config.get_sauceLabOption(configName);

            while (keys.hasNext()) {
                String key = keys.next();
                capabilities.setCapability(key, object.get(key));
            }
            Iterator<String> saucelabOptionKey = sauceLabOption.keys();
            HashMap<String, Object> sauceLabOptions = new HashMap<String, Object>();


            while (saucelabOptionKey.hasNext()) {
                String key = saucelabOptionKey.next();

                sauceLabOptions.put(key, object.get(key));
            }

            capabilities.setCapability("sauce:options", sauceLabOptions);


        } else if (config.get_grid_platForm(configName).equalsIgnoreCase("lambdatest")) {

            JSONObject lambdaTestOption = config.get_lambdaTestOption(configName);

            while (keys.hasNext()) {
                String key = keys.next();
                capabilities.setCapability(key, object.get(key));
            }
            Iterator<String> lambdaTestOptionKey = lambdaTestOption.keys();

            HashMap<String, Object> lambdaOptions = new HashMap<String, Object>();

            while (lambdaTestOptionKey.hasNext()) {
                String key = lambdaTestOptionKey.next();
                lambdaOptions.put(key, lambdaTestOption.get(key));
            }

            capabilities.setCapability("build",build_Name );
            capabilities.setCapability("LT:options", lambdaOptions);
        }

        try {

            driver = new RemoteWebDriver(new URL(config.get_grid_url(configName)), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        return driver;
    }


    public AndroidDriver setup_android(String configName) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        JSONObject capabilityList = config.get_capabilities(configName);

        Iterator itr = capabilityList.keySet().iterator();

        while (itr.hasNext()) {
            String key = (String) itr.next();
            capabilities.setCapability(key, capabilityList.get(key));
        }

        if (config.get_appium_platform(configName).equalsIgnoreCase("lambdaTest")) {

            JSONObject lambdaTestOption = config.get_lambdaTestOption(configName);

            Iterator<String> lambdaTestOptionKey = lambdaTestOption.keys();
            HashMap<String, Object> lambdaTestOptionsMap = new HashMap<String, Object>();

            while (lambdaTestOptionKey.hasNext()) {
                String key = lambdaTestOptionKey.next();

                lambdaTestOptionsMap.put(key, lambdaTestOption.get(key));
            }

            capabilities.setCapability("build",build_Name );

            capabilities.setCapability("LT:options", lambdaTestOptionsMap);

        } else {
            capabilities.setCapability("appium:app", config.get_final_app_path(configName));
        }

        try {
            driver = new AndroidDriver(new URL(config.get_appium_url(configName)), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        return (AndroidDriver) driver;
    }

    public IOSDriver setup_iOS(String configName) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        JSONObject capabilityList = config.get_capabilities(configName);

        Iterator itr = capabilityList.keySet().iterator();

        while (itr.hasNext()) {
            String key = (String) itr.next();
            capabilities.setCapability(key, capabilityList.get(key));
        }
        capabilities.setCapability("app", config.get_final_app_path(configName));
        try {
            driver = new IOSDriver(new URL(config.get_appium_url(configName)), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return (IOSDriver) driver;
    }

    File file = null;

    @AfterMethod
    public void tear_down(ITestResult result) {


        if (ITestResult.FAILURE == result.getStatus()) {
            try {

                if (!platform.equalsIgnoreCase("api")) {


                    TakesScreenshot screenshot = (TakesScreenshot) driver;
                    File src = screenshot.getScreenshotAs(OutputType.FILE);
                    file = new File("src/test/resources/failed_test_screenshot/" + result.getName() + "_" + TestData.random_alpha_numeric_string(5) + ".png");
                    FileUtils.copyFile(src, file);

                    logs.test_result(false);
                    logs.test_step("<img src=\"" + file.getAbsolutePath() + "\" alt=\"test\" width=\"1024\" height=\"640\">");


                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        if (config.getPlatform(TestRunner.currentConfig).equalsIgnoreCase("web")) {
            if (config.get_grid_platForm(TestRunner.currentConfig).equalsIgnoreCase("lambdatest")) {
                LambdaTestConfig config = new LambdaTestConfig(driver);
                if (ITestResult.FAILURE == result.getStatus()) {
                    config.markTestFailed();
                } else {
                    config.markTestPassed();
                }

            }

        }


        if (config.getPlatform(TestRunner.currentConfig).equalsIgnoreCase("android") || config.getPlatform(TestRunner.currentConfig).equalsIgnoreCase("ios")) {
            if (config.get_appium_platform(TestRunner.currentConfig).equalsIgnoreCase("lambdatest")) {
                LambdaTestConfig config = new LambdaTestConfig(driver);
                if (ITestResult.FAILURE == result.getStatus()) {
                    config.markTestFailed();
                } else {
                    config.markTestPassed();
                }

            }

        }


        if (!platform.equalsIgnoreCase("api")) {
            driver.quit();
        }


    }


    public void suiteTearDown() {
        if (platform.equalsIgnoreCase("api")) {
            File f = new File("./src/test/java/api/data/temp");

            try {
                FileUtils.cleanDirectory(f);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}