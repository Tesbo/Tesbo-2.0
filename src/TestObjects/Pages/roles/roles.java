package Pages.roles;

import io.unity.core.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;

public class roles {

    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;

    public roles(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
    }

    @MethodsData(method_id = "button_3")
    public void click_on_roles_tab() {
        wait.wait_for_second(5);
        element.click("roles_tab");
        wait.wait_for_second(4);
    }


    @MethodsData(method_id = "text_1")
    public void verify_user_text_text_box_is_present_on_page() {
        wait.wait_for_second(5);
        verify.element_is_present("user_text");
        wait.wait_for_second(4);
    }

    @MethodsData(method_id = "button_3")
    public void click_on_new_role() {
        wait.wait_for_second(5);
        element.click("new_role");
        wait.wait_for_second(4);
    }


    @MethodsData(method_id = "text_1")
    public void verify_add_user_pop_up_text_box_is_present_on_page() {
        wait.wait_for_second(5);
        verify.element_is_present("add_user_pop_up");
        wait.wait_for_second(4);
    }

    @MethodsData(method_id = "button_3")
    public void click_on_add_user_create() {
        wait.wait_for_second(5);
        element.click("add_user_create");
    }


    @MethodsData(method_id = "text_1")
    public void verify_access_group_required_pop_up_text_box_is_present_on_page() {
        wait.wait_for_second(5);
        verify.element_is_present("add_user_pop_up");
        wait.wait_for_second(4);
    }

    @MethodsData(method_id = "text_1")
    public void verify_roles_required_pop_up_text_box_is_present_on_page() {
        wait.wait_for_second(5);
        verify.element_is_present("add_user_pop_up");
        wait.wait_for_second(4);
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_add_user_first_name(String text_to_enter) {
        wait.wait_for_second(5);
        element.enter_text("add_user_first_name", text_to_enter);
        wait.wait_for_second(5);

    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_add_user_email(String text_to_enter) {
        wait.wait_for_second(5);
        element.enter_text("add_user_email", text_to_enter);
        wait.wait_for_second(5);

    }

    @MethodsData(method_id = "button_3")
    public void click_on_access_dropdown() {
        wait.wait_for_second(5);
        element.click("access_dropdown");
        wait.wait_for_second(4);
    }

    @MethodsData(method_id = "button_3")
    public void click_on_select_access() {
        wait.wait_for_second(5);
        element.click("select_access");
        wait.wait_for_second(4);
    }

    @MethodsData(method_id = "button_3")
    public void click_on_role_dropdown() {

        wait.wait_for_second(15);
        element.click("role_dropdown");
        wait.wait_for_second(4);
    }

    @MethodsData(method_id = "button_3")
    public void click_on_select_dropdown() {
        wait.wait_for_second(5);
        element.click("select_dropdown");
        wait.wait_for_second(4);
    }

    @MethodsData(method_id = "text_box_4")
    public void verify_add_user_message_text_box_is_present_on_page() {
        wait.wait_for_second(5);
        wait.wait_until_element_is_visible("add_user_message");
        verify.element_is_present("add_user_message");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_add_user_cancel() {
        wait.wait_for_second(5);
        element.click("add_user_cancel");
        wait.wait_for_second(4);
    }

    @MethodsData(method_id = "button_3")
    public void click_on_click_action() {
        wait.wait_for_second(5);
        element.click("click_action");
        wait.wait_for_second(4);
    }

    @MethodsData(method_id = "text_box_4")
    public void verify_edit_action_text_box_is_present_on_page() {
        wait.wait_for_second(5);
        verify.element_is_present("edit_action");
        wait.wait_for_second(5);
    }

    @MethodsData(method_id = "text_box_4")
    public void verify_reset_password_action_text_box_is_present_on_page() {
        wait.wait_for_second(10);
        wait.wait_until_element_is_visible("reset_password_action");
        verify.element_is_present("reset_password_action");
        wait.wait_for_second(5);
    }


}
