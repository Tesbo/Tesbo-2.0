package mobile.object_repository.home_screen;

import io.unity.framework.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;

import org.openqa.selenium.WebDriver;

public class home_screen {

    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;

    public home_screen(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
    }

    @MethodsData(method_id = "button_1")
    public void verify_Notification_bottom_button_is_present_on_page() {
        verify.element_is_present("Notification_bottom_button");
    }

    @MethodsData(method_id = "button_2")
    public void verify_Notification_bottom_button_is_clickable() {
        verify.element_is_enable("Notification_bottom_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_Notification_bottom_button() {
        element.click("Notification_bottom_button");
    }

    @MethodsData(method_id = "button_4")
    public void Verify_Notification_bottom_button_text_is_equal_to(String button_text) {
        verify.element_text_is_equal_to("Notification_bottom_button", button_text);
    }

    @MethodsData(method_id = "button_1")
    public void verify_search_bottom_button_is_present_on_page() {
        verify.element_is_present("search_bottom_button");
    }

    @MethodsData(method_id = "button_2")
    public void verify_search_bottom_button_is_clickable() {
        verify.element_is_enable("search_bottom_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_search_bottom_button() {
        element.click("search_bottom_button");
    }

    @MethodsData(method_id = "button_4")
    public void Verify_search_bottom_button_text_is_equal_to(String button_text) {
        verify.element_text_is_equal_to("search_bottom_button", button_text);
    }

    @MethodsData(method_id = "button_1")
    public void verify_Bookmarks_bottom_button_is_present_on_page() {
        verify.element_is_present("Bookmarks_bottom_button");
    }

    @MethodsData(method_id = "button_2")
    public void verify_Bookmarks_bottom_button_is_clickable() {
        verify.element_is_enable("Bookmarks_bottom_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_Bookmarks_bottom_button() {
        element.click("Bookmarks_bottom_button");
    }

    @MethodsData(method_id = "button_4")
    public void Verify_Bookmarks_bottom_button_text_is_equal_to(String button_text) {
        verify.element_text_is_equal_to("Bookmarks_bottom_button", button_text);
    }

    @MethodsData(method_id = "button_1")
    public void verify_home_bottom_button_is_present_on_page() {
        wait.wait_until_element_is_visible("home_bottom_button");
        wait.wait_for_second(3);
        verify.element_is_present("home_bottom_button");
    }

    @MethodsData(method_id = "button_2")
    public void verify_home_bottom_button_is_clickable() {
        verify.element_is_enable("home_bottom_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_home_bottom_button() {
        element.click("home_bottom_button");
    }

    @MethodsData(method_id = "button_4")
    public void Verify_home_bottom_button_text_is_equal_to(String button_text) {
        verify.element_text_is_equal_to("home_bottom_button", button_text);
    }
}