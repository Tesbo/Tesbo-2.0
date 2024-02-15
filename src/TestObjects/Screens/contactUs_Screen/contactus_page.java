package Screens.contactUs_Screen;

import io.unity.core.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import io.unity.performaction.autoweb.testng_logs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class contactus_page {

    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;
    Actions actions = null;
    testng_logs logs = null;

    public contactus_page(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
        actions = new Actions(driver);
        logs = new testng_logs();
    }
    @MethodsData(method_id = "button_1")
    public void verify_contactUs_icon_is_present_on_page() {
        wait.wait_for_second(5);
        verify.element_is_present("contactUs_icon");
    }
    @MethodsData(method_id = "button_1")
    public void click_on_contactUs_icon_button() {
        element.click("contactUs_icon");
    }
    @MethodsData(method_id = "button_1")
    public void verify_contactUs_Page_Header_is_present_on_page() {
        wait.wait_for_second(5);
        verify.element_is_present("contactUs_Page_Header");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_back_button() {
        element.click("back_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_select_topic_dropdown_is_present_on_page() {
        wait.wait_for_second(5);
        verify.element_is_present("select_topic_dropdown");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_select_topic_dropdown() {
        element.click("select_topic_dropdown");
    }


    @MethodsData(method_id = "button_1")
    public void verify_the_lesson_is_frozen_is_present_on_page() {
        wait.wait_for_second(5);
        verify.element_is_present("the_lesson_is_frozen");
    }

    @MethodsData(method_id = "button_1")
    public void verify_complete_the_program_is_present_on_page() {
        verify.element_is_present("complete_the_program");
    }

    @MethodsData(method_id = "button_1")
    public void verify_something_else_is_present_on_page() {
        wait.wait_for_second(2);
        verify.element_is_present("something_else");
    }


    @MethodsData(method_id = "button_1")
    public void verify_lesson_material_is_present_on_page() {
        verify.element_is_present("lesson_material");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_something_else() {
        element.click("something_else");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_submitButton() {
        wait.wait_until_element_is_visible("submit_button");
        element.click("submit_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_select_topic_error_alert_is_present_on_page() {
        wait.wait_for_second(2);
        verify.element_is_present("select_topic_error_alert");
    }

    @MethodsData(method_id = "button_1")
    public void verify_describe_your_problem_is_present_on_page() {
        wait.wait_for_second(2);
        verify.element_is_present("describe_your_problem");
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_describe_your_problem_textBox(String text_to_enter) {
        wait.wait_for_second(1);
        element.click("describe_your_problem_textBox");
        wait.wait_for_second(1);
        element.enter_text("describe_your_problem_textBox", text_to_enter);
        wait.wait_for_second(1);
    }

    @MethodsData(method_id = "button_1")
    public void verify_request_sent_is_present_on_page() {
        wait.wait_for_second(2);
        verify.element_is_present("request_sent");
    }

    @MethodsData(method_id = "button_1")
    public void verify_message_sent_successfully_is_present_on_page() {
        verify.element_is_present("message_sent_successfully");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_ok_button() {
        element.click("ok_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_faq_button_is_present_on_page() {
        verify.element_is_present("faq_button");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_faq_button() {
        element.click("faq_button");
    }
}
