package io.unity.performaction.autoweb;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alert {

    WebDriver driver;
    Element element;
    testng_logs logs = new testng_logs();

    public Alert(WebDriver dri) {
        this.driver = dri;
        element = new Element(driver);
    }

    public String get_alert_text() {

        logs.test_step("Get Alert Text");
        org.openqa.selenium.Alert alert = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.alertIsPresent());

        return alert.getText();
    }

    public void accept()
    {
        logs.test_step("Accept the Alert");
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public void dismiss()
    {
        logs.test_step("Dismiss the Alert");
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void enter_text_in_alert(String text)
    {
        logs.test_step("Enter "+text+" in the Alert");
        org.openqa.selenium.Alert alert = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
    }

}
