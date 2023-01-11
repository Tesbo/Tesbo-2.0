package api.requests.Sessions;

import io.unity.framework.init.Session;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class WebsessionTest {
    Wait wait = null;


    @DataProvider(name = "generate_code")
        public Object[][] data_provider() {
            DataReader reader = new DataReader();
            Object[][] data = null;
            data = reader.getExcelDataForDataProvider("Credential.xlsx", 0);
            return data;
        }

        //---------------------------------- GET THE TEST DATA FOR VALID TOKEN --------------------------------------------//

    @Test(dataProvider = "generate_code")
    public void generate_code() {

        Session session = new Session();

        WebDriver driver = session.create_new_web_session("generate_code");
        wait = new Wait(driver);
        driver.findElement(By.xpath("//input[@name = \"email\"]")).sendKeys("testqable905+31@gmail.com");
        driver.findElement(By.xpath("//input[@name = \"password\"]")).sendKeys("QAble@1010");
        driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();
        wait.wait_for_second(10);
        driver.findElement(By.xpath("//a[@href = \"/settings\"]")).click();
        driver.findElement(By.xpath("//a[@href = \"/settings/email-accounts\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Add Email Account\"]")).click();
        driver.findElement(By.xpath("//span[text() = \"Microsoft\"]")).click();
        driver.findElement(By.xpath("//input[@name = \"loginfmt\"]")).sendKeys("dhaval_SH@hotmail.com");
        wait.wait_for_second(3);
        driver.findElement(By.xpath("//input[@type = \"submit\"]")).click();
        driver.findElement(By.xpath("//input[@name = \"passwd\"]")).sendKeys("Sales@handy");
        driver.findElement(By.xpath("//input[@value = \"Sign in\"]")).click();
        System.out.println(driver.getCurrentUrl());

        wait.wait_for_second(3);
//        driver.findElement(By.xpath("//input[@type =\"password\" ]")).sendKeys("QAble@1010");
//        driver.findElement(By.xpath("//span[contains(text(), \"Next\")]")).click();

        WebDriver apidriver = session.create_new_web_session("api_session");
        apidriver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("test");

        WebDriver testdriver = session.create_new_web_session("test_session");
        testdriver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("test");

//        wait.wait_for_second(5);
//        List<WebElement> gmail_subject_text1 = driver.findElements(By.xpath("//span[contains(.,'Saleshandy')]"));
//        for(WebElement emailsub1 : gmail_subject_text1){
//            if(emailsub1.getText().equals("Saleshandy") == true){
//                System.out.println(emailsub1);
//                wait.wait_for_second(5);
//                emailsub1.click();
//                wait.wait_for_second(5);
//                break;
//            }
//        }
//        String otp_string = driver.findElement(By.xpath("//div[@class= \"a3s aiL \"]//div")).getText();
//        String final_otp = otp_string.replaceAll("[^0-9]","");
//        System.out.println(final_otp);
//        wait.wait_for_second(5);
        driver.quit();
        //return final_otp;


    }

}
