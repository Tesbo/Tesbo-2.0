package Init;

import common.JsonFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.unity.autoweb.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;

public class Base {

    String env = "";
    String platformType = "";
    String browserName = "";
    public Browser browser;

    WebDriver driver;
    JsonFileReader config = new JsonFileReader();
    @BeforeTest
    public void init() {

        env = config.getEnv();
        platformType = config.getPlatformType();
        browserName = config.getBrowser();

        System.out.println("Env : " + env);
        System.out.println("Platform Type : " + platformType);
        if (platformType.equalsIgnoreCase("web")) {
            setupBrowser(browserName);
            browser.openURL(env);
        } else if (platformType.equalsIgnoreCase("mobile")) {

        } else if (platformType.equalsIgnoreCase("web")) {

        } else {
            System.out.println("Platform type you entered is not supported");
        }

    }


    public WebDriver setupBrowser(String browserName) {

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
        browser = new Browser(driver);
        return driver;
    }




}
