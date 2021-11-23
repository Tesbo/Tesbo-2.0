package Init;

import common.JsonFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Base {

    String env = "";
    String platformType = "";
    String browser = "";

    WebDriver driver;
    JsonFileReader config = new JsonFileReader();
    @BeforeTest
    public void init() {


        env = config.getEnv();
        platformType = config.getPlatformType();
        browser = config.getBrowser();

        System.out.println("Env : " + env);
        System.out.println("Platform Type : " + platformType);
        if (platformType.equalsIgnoreCase("web")) {
            setupBrowser(browser);

        } else if (platformType.equalsIgnoreCase("mobile")) {

        } else if (platformType.equalsIgnoreCase("web")) {

        } else {
            System.out.println("Platform type you entered is not supported");
        }

    }


    public WebDriver setupBrowser(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        return driver;
    }

    public void getURL()
    {

      driver.get(config.getEnv());

    }


}
