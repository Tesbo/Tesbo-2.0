package io.unity.framework.init;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.unity.framework.data.TestData;
import io.unity.framework.readers.json_file_reader;
import io.unity.framework.runner.TestRunner;
import io.unity.performaction.autoweb.Browser;
import io.unity.performaction.autoweb.testng_logs;
import kong.unirest.Unirest;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;

public class base {

    String env = "";
    String platform = "";
    String browserName = "";
    String execution_on = "";
    public Browser browser;


    public WebDriver driver;
    json_file_reader config = new json_file_reader();
    testng_logs logs = new testng_logs();


    @BeforeMethod
    public WebDriver init() {

        if (TestRunner.currentConfig.equals("")) {
            TestRunner.currentConfig = config.getRunConfig();
        }

        platform = config.getPlatform(TestRunner.currentConfig);

        System.out.println("Base config to run : " + TestRunner.currentConfig);

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
            System.out.println("Platform type you entered is not supported");
        }

        return driver;
    }


    public WebDriver setup_browser(String configName) {
        System.out.println("Inside  browser");
        browserName = config.getBrowser(configName);
        System.out.println("browser name" + browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Inside chrome");

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Inside firefox");
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("Inside edge");
        } else if (browserName.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            System.out.println("Inside opera");
        }

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return driver;
    }

    public WebDriver setup_browser_for_grid(String configName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        JSONObject object = config.get_capabilities(configName);
        Iterator<String> keys = object.keys();
        capabilities.setBrowserName(config.getBrowser(configName));
        while (keys.hasNext()) {
            String key = keys.next();
            capabilities.setCapability(key, object.get(key));
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
        capabilities.setCapability("app", config.get_final_app_path(configName));
        try {
            driver = new AndroidDriver(new URL(config.get_appium_url(configName)), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
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
                    {

                        TakesScreenshot screenshot = (TakesScreenshot) driver;
                        File src = screenshot.getScreenshotAs(OutputType.FILE);
                        file = new File("src/test/resources/failed_test_screenshot/" + result.getName() + "_" + TestData.random_alpha_numeric_string(5) + ".png");
                        FileUtils.copyFile(src, file);

                        logs.test_result(false);
                        logs.test_step("<img src=\"" + file.getAbsolutePath() + "\" alt=\"test\" width=\"1024\" height=\"640\">");


                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }


}