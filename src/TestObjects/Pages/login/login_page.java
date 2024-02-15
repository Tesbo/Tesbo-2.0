package Pages.login;

import io.unity.core.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;

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

        verify.element_is_present("password_password");
    }


    public void enterText()
    {
        element.enter_text("password_hidden_format","ABC");

    }




    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_password(String text_to_enter) {
        element.click("password_password");
        element.enter_text("password_password", text_to_enter);
    }


    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_email_text_box(String text_to_enter) {
        wait.wait_until_element_is_visible("e_mail_text_box");
        element.click("e_mail_text_box");
        element.enter_text("e_mail_text_box", text_to_enter);
    }

    @MethodsData(method_id = "button_1")
    public void verify_email_text_box_is_present_on_page() {
        wait.wait_until_element_is_visible("e_mail_text_box");
        verify.element_is_present("e_mail_text_box");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_login_button() {
        wait.wait_for_second(2);
        element.click("login_button_web");

    }

    @MethodsData(method_id = "button_1")
    public void verify_login_button_is_present_on_page() {
        verify.element_is_present("login_button_web");
    }


    @MethodsData(method_id = "button_1")
    public void verify_blank_email_message_is_present_on_page() {
        wait.wait_for_second(3);
        verify.element_is_present("blank_email_message");
    }

    @MethodsData(method_id = "button_1")
    public void verify_blank_password_message_is_present_on_page() {
        wait.wait_for_second(3);
        verify.element_is_present("blank_password_message");
    }


    public void performLogin(String userName, String password) {
        wait.wait_for_second(1);
        driver.manage().window().maximize();
        verify_email_text_box_is_present_on_page();
        enter_text_at_email_text_box(userName);
        enter_text_at_password(password);
        click_on_login_button();

    }

    public void performLoginToCSPanel(String userName, String password) {
        wait.wait_for_second(1);
        driver.manage().window().maximize();
        verify_email_text_box_is_present_on_page();
        enter_text_at_email_text_box(userName);
        enter_text_at_password(password);

    }
    @MethodsData(method_id = "button_1")
    public void verify_wrong_credential_warning_message()
    {
        wait.wait_until_element_is_visible("wrong_email_pwd_validation_message");
        verify.element_is_present("wrong_email_pwd_validation_message");
    }
    @MethodsData(method_id = "button_1")
    public void verify_wrong_password_warning_message()
    {
        wait.wait_until_element_is_visible("wrong_password_correct_email_validation");
        verify.element_is_present("wrong_password_correct_email_validation");
    }
    @MethodsData(method_id = "button_1")
    public void verify_wrong_email_warning_message()
    {
        wait.wait_until_element_is_visible("warning_message");
        verify.element_is_present("warning_message");
    }


    @MethodsData(method_id = "button_1")
    public void verify_forgot_your_password_link_is_present_on_page()
    {
        wait.wait_for_second(3);
        verify.element_is_present("forgot_your_password_link");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_forgot_your_password_link()
    {
        wait.wait_until_element_is_visible("forgot_your_password_link");
        element.click("forgot_your_password_link");
    }

    @MethodsData(method_id = "button_1")
    public void verify_redirect_to_forgot_password_page() {
        wait.wait_until_element_is_visible("forgot_password_page");
        verify.element_is_present("forgot_password_page");
    }
    @MethodsData(method_id = "button_1")
    public void enter_text_email_at_forgot_password_text_box(String text_to_enter) {
        wait.wait_until_element_is_visible("enter_forgot_pwd_email");
        element.click("enter_forgot_pwd_email");
        element.enter_text("enter_forgot_pwd_email",text_to_enter);
    }
    @MethodsData(method_id = "button_1")
    public void click_on_send_button() {
       wait.wait_until_element_is_visible("click_on_send_button");
        element.click("click_on_send_button");
    }
    @MethodsData(method_id = "button_1")
    public void click_on_back_to_login_link() {
        wait.wait_for_second(2);
        element.click("click_on_back_login_link");
    }
    @MethodsData(method_id = "button_1")
    public void verify_redirect_to_login_page() {
        wait.wait_for_second(3);
        verify.element_is_present("verify_login_page");
    }
    @MethodsData(method_id = "button_1")
    public void verify_invalid_validation_message_display() {
        wait.wait_until_element_is_visible("enter_forgot_email_invalid");
        verify.element_is_present("enter_forgot_email_invalid");
    }
    @MethodsData(method_id = "button_1")
    public void verify_set_successfully_validation_msg() {
        wait.wait_until_element_is_visible("forgot_validation_msg_email_sent");
       element.find("forgot_validation_msg_email_sent");
        verify.element_is_present("forgot_validation_msg_email_sent");
    }
    @MethodsData(method_id = "button_1")
    public void verify_email_required_validation_msg_show() {
        wait.wait_for_second(1);
        verify.element_is_present("forgot_email_required_validation_msg");
        wait.wait_for_second(1);
    }
    @MethodsData(method_id = "button_1")
    public void click_on_masked_icon() {
       wait.wait_until_element_is_visible("masked_icon_button");
        element.click("masked_icon_button");
    }
    @MethodsData(method_id = "button_1")
    public void click_on_unmasked_icon() {
        wait.wait_until_element_is_visible("unmasked_icon_button");
        element.click("unmasked_icon_button");
    }
    @MethodsData(method_id = "button_1")
    public void verify_Password_in_text_visible() {
        wait.wait_until_element_is_visible("password_visible_text");
        verify.element_is_present("password_visible_text");
    }
    @MethodsData(method_id = "button_1")
    public void verify_Password_is_hidden_format() {
        wait.wait_until_element_is_visible("password_hidden_format");
        verify.element_is_present("password_hidden_format");
    }
    @MethodsData(method_id = "button_3")
    public void clear_email_text_box() {
        wait.wait_until_element_is_visible("e_mail_text_box");
        element.clear_text_field("e_mail_text_box");

    }
    @MethodsData(method_id = "button_3")
    public void clear_password_text_box() {
        wait.wait_until_element_is_visible("password_password");
        element.clear_text_field("password_password");

    }


}
