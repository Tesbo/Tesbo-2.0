package api.requests.Sessions;

import io.unity.framework.init.Session;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GmailSession {

    Wait wait = null;




    public String generate_otp() {

        Session session = new Session();

        WebDriver driver = session.create_new_web_session("gmail");
        wait = new Wait(driver);
        driver.findElement(By.xpath("//input[@id = \"identifierId\"]")).sendKeys("qabletest@gmail.com");
        driver.findElement(By.xpath("//span[contains(text(), \"Next\")]")).click();
        wait.wait_for_second(3);
        driver.findElement(By.xpath("//input[@type =\"password\" ]")).sendKeys("QAble@1010");
        driver.findElement(By.xpath("//span[contains(text(), \"Next\")]")).click();


        wait.wait_for_second(5);
        List<WebElement> gmail_subject_text1 = driver.findElements(By.xpath("//span[contains(.,'Saleshandy')]"));
        for(WebElement emailsub1 : gmail_subject_text1){
            if(emailsub1.getText().equals("Saleshandy") == true){
                System.out.println(emailsub1);
                wait.wait_for_second(5);
                emailsub1.click();
                wait.wait_for_second(5);
                break;
            }
        }
        String otp_string = driver.findElement(By.xpath("//div[@class= \"a3s aiL \"]//div")).getText();
        String final_otp = otp_string.replaceAll("[^0-9]","");
        System.out.println(final_otp);
        wait.wait_for_second(5);
        driver.quit();
        return final_otp;
    }

}
