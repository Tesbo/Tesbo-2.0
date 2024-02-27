package TestObjects.Pages.login;


import Framework.performaction.autoweb.Element;
import Framework.performaction.autoweb.Verify;
import Framework.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;


public class login_page {
    WebDriver driver;
    Element element;
    Verify verify;
    Wait wait;

    public login_page(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
    }


        public void verify_facebook_opening(){
        element.enter_text("password_password", "jacob");
            }
}
