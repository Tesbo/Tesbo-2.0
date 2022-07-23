package web.object_repository.login;

import io.unity.framework.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class login_page {

    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;

    public login_page(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
    }


    @MethodsData(method_id = "button_1")
    public void verify_password_button_is_present_on_page() {


        //   element.find_element_using_dynamic_xpath("",).click();
        verify.element_is_present("password_password");
    }


    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_password(String text_to_enter) {
        element.click("password_password");
        element.enter_text("password_password", text_to_enter);
    }


    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_email_text_box(String text_to_enter) {
        element.click("email_text_box");
        element.enter_text("email_text_box", text_to_enter);
    }

    @MethodsData(method_id = "button_1")
    public void verify_email_text_box_is_present_on_page() {
        verify.element_is_present("email_text_box");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_login_button() {

        element.click("login_button");
        wait.wait_for_second(4);
    }

    @MethodsData(method_id = "button_1")
    public void verify_login_button_is_present_on_page() {
        verify.element_is_present("login_button");
    }

}
