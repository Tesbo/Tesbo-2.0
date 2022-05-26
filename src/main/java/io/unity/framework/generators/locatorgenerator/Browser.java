package io.unity.framework.generators.locatorgenerator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {


    public static WebDriver driver;

    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(EntryPoint.website);

    }

    public void generatePageObject()
    {

    }

}
