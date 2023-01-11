package web.object_repository.login;

import io.unity.framework.generators.methodsgenerator.methods.MethodsData;
import io.unity.framework.init.base;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class login {


        WebDriver driver = null;
        Element element = null;
        Verify verify = null;

        Wait wait = null;

        public login(WebDriver driver) {
            this.driver = driver;
            element = new Element(driver);
            verify = new Verify(driver);
            wait = new Wait(driver);
        }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_login_email(String text_to_enter) {
        wait.wait_for_second(5);
        element.enter_text("login_email", text_to_enter);
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_login_password(String text_to_enter) {
        element.enter_text("login_password", text_to_enter);
        wait.wait_for_second(5);
    }

    @MethodsData(method_id = "text_box_1")
    public void click_on_login_button(){
            element.click("login_button");
            wait.wait_for_second(5);
    }

    public void login()
    {
        enter_text_at_login_email("qabletest+4.36@gmail.com");
        enter_text_at_login_password("QAble@1010");
        click_on_login_button();


    }

    @MethodsData(method_id = "button_3")
    public void click_on_sequence_menu(){
        wait.wait_for_second(5);
        element.click("sequence_menu");
        wait.wait_for_second(5);
    }

    @MethodsData(method_id = "button_3")
    public void click_on_create_sequence_button(){
        element.click("create_sequence_button");
        wait.wait_for_second(5);
    }

    @MethodsData(method_id = "button_3")
    public void click_on_add_step_button(){
        element.click("add_step_button");
        wait.wait_for_second(5);
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_enter_subject(String text_to_enter) {
        element.enter_text("enter_subject", text_to_enter);
        wait.wait_for_second(5);
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_enter_description(String text_to_enter) {
        element.enter_text("enter_description", text_to_enter);
        wait.wait_for_second(5);
    }

    @MethodsData(method_id = "button_3")
    public void click_on_sequence_save_button(){
        wait.wait_for_second(5);

        element.click("sequence_save_button");
        wait.wait_for_second(5);
    }

    @MethodsData(method_id = "button_3")
    public void click_on_sequence_title(){
        element.click("sequence_title");
        wait.wait_for_second(2);
    }

    @MethodsData(method_id = "button_3")
    public void click_on_close_getting_started(){
        element.click("close_getting_started");
        wait.wait_for_second(5);
    }


}

