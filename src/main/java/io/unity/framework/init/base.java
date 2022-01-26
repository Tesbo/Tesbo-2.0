package io.unity.framework.init;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.unity.autoweb.Browser;
import org.json.JSONObject;
import org.openqa.selenium.Capabilities;
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

import io.unity.framework.readers.json_file_reader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class base {

    String env = "";
    String platformType = "";
    String browserName = "";
    String execution_on = "";
    public Browser browser;

    public WebDriver driver;
    json_file_reader config = new json_file_reader();


    @BeforeTest
    public WebDriver init() {

        env = config.getEnv();
        platformType = config.getPlatformType();

        execution_on = config.get_execution_on();

        System.out.println("Env : " + env);
        System.out.println("Platform Type : " + platformType);


        if (platformType.equalsIgnoreCase("web")) {

            if (execution_on.equalsIgnoreCase("local")) {
                setup_browser();
            }
            if (execution_on.equalsIgnoreCase("grid")) {
                setup_browser_for_grid();
            }
            browser = new Browser(driver);
            browser.open_url(env);


        } else if (platformType.equalsIgnoreCase("mobile")) {

        } else if (platformType.equalsIgnoreCase("API")) {

        } else {
            System.out.println("Platform type you entered is not supported");
        }
        return driver;
    }


    public WebDriver setup_browser() {

        browserName = config.getBrowser();
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

    public WebDriver setup_browser_for_grid() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        JSONObject object = config.get_capabilities();
        Iterator<String> keys = object.keys();
        capabilities.setBrowserName(config.getBrowser());
        while (keys.hasNext()) {
            String key = keys.next();
            capabilities.setCapability(key, object.get(key));
        }
        try {

            driver = new RemoteWebDriver(new URL(config.get_grid_url()), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        return driver;
    }

    @AfterTest
    public void tear_down() {

        driver.quit();

    }

}
