package io.unity.framework.init;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.unity.autoweb.Browser;
import io.unity.framework.readers.json_file_reader;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class base {

    String env = "";
    String platform = "";
    String browserName = "";
    String execution_on = "";
    public Browser browser;


    public WebDriver driver;
    json_file_reader config = new json_file_reader();


    @BeforeTest
    public WebDriver init() {

        String currentConfig = config.getRunConfig();
        platform = config.getPlatform(currentConfig);


        System.out.println("Env : " + env);
        System.out.println("Platform Type : " + platform);


        if (platform.equalsIgnoreCase("web")) {

            if (config.isGrid(currentConfig)) {
                setup_browser_for_grid(currentConfig);
            } else {
                setup_browser(currentConfig);
            }
            env = config.getEnv(currentConfig);
            browser = new Browser(driver);
            browser.open_url(env);

        } else if (platform.equalsIgnoreCase("android")) {
            System.out.println("Inside android");
            setup_android(currentConfig);
        } else if (platform.equalsIgnoreCase("iOS")) {
            System.out.println("Inside iOS");
            setup_iOS(currentConfig);
        } else if (platform.equalsIgnoreCase("API")) {

        } else {
            System.out.println("Platform type you entered is not supported");
        }
        return driver;
    }


    public WebDriver setup_browser(String configName) {

        browserName = config.getBrowser(configName);
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }


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
        try {
            driver = new AndroidDriver(new URL(config.get_appium_url(configName)), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
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
        try {
            driver = new IOSDriver(new URL(config.get_appium_url(configName)), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return (IOSDriver) driver;
    }

    @AfterTest
    public void tear_down() {

        driver.quit();

    }

}
