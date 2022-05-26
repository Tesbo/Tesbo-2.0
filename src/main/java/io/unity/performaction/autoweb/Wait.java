package io.unity.performaction.autoweb;

import io.unity.performaction.autoweb.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Wait {

    WebDriver driver;
    Element element;

    public Wait(WebDriver dri) {
        this.driver = dri;
        element = new Element(driver);

    }

    public void wait_until_element_is_clickable(String locator_value) {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(element.find(locator_value)));
    }


    public void wait_until_element_is_visible(String locator_value) {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOf((element.find(locator_value))));
    }

    public void wait_until_element_is_disappear(String locator_value) {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.invisibilityOf((element.find(locator_value))));
    }

    public void wait_until_all_element_is_visible(String locator_value) {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOfAllElements((element.find(locator_value))));
    }

    public void wait_until_all_element_is_disappear(String locator_value) {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.invisibilityOfAllElements((element.find(locator_value))));
    }

    public void wait_until_alert_is_present() {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void wait_for_second(int second) {
        try {
            Thread.sleep((long)second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();

        }
    }

    public void implicit_wait_for_page(WebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    public void fluent_wait_method_for_element(String locator_value,int TimeoutTime,int PollingTime)
    {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(TimeoutTime))
                .pollingEvery(Duration.ofSeconds(PollingTime))
                .ignoring(Exception.class);

        WebElement element2 = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element2 = element.find(locator_value);
                return element2;
            }
        });
        element2.click();
    }


}
