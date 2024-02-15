package Pages.employeeProfilePage;

import io.unity.core.exception.locator_validation_exception;
import io.unity.core.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;

public class employeeProfile {

    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;
    HashMap<String, String> map = new HashMap<String, String>();
    List<WebElement> lstOfAgencyTabs;
    JavascriptExecutor jsExecutor;
    List<WebElement> lstOfStatusOptions;

    public employeeProfile(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }

    @MethodsData(method_id = "button_1")
    public void verify_employee_name_is_present_on_page() {
        wait.wait_until_element_is_visible("employee_name");
        verify.element_is_present("employee_name");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_test_employee_name() {
        wait.wait_for_second(3);
        verify.element_is_present("test_employee_name");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_employee_name() {
        wait.wait_until_element_is_visible("employee_name");
        element.click("employee_name");
    }

    @MethodsData(method_id = "button_1")
    public String get_employee_name() {

        String getName = element.get_element_text("employee_name");
        return getName;
    }

    @MethodsData(method_id = "text_box_1")
    public void navigateToNewTab() {
        wait.wait_for_second(5);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
    }

    @MethodsData(method_id = "text_box_1")
    public void navigateToNewSecondTab() {
        wait.wait_for_second(5);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(2));
    }

    @MethodsData(method_id = "button_1")
    public void verify_message_button_is_present_on_page() {
        wait.wait_until_element_is_visible("message_button_web");
        verify.element_is_present("message_button_web");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_message_button() {
        wait.wait_until_element_is_visible("message_button_web");
        element.click("message_button_web");
    }

    @MethodsData(method_id = "button_1")
    public void verify_employee_name_header_is_present_on_page() {
        wait.wait_until_element_is_visible("employee_name_header");
        verify.element_is_present("employee_name_header");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_notes_text_box() {
        wait.wait_until_element_is_visible("notes_text_box");
        element.click("notes_text_box");

    }

    @MethodsData(method_id = "button_1")
    public void enter_text_notes(String text_to_enter) {
        wait.wait_for_second(2);
        element.perform_scroll_to_element("notes_text_box");
        wait.wait_until_element_is_visible("notes_text_box");
        element.find("notes_text_box");
        element.click("notes_text_box");
        element.clear_and_enter_in_text_field("notes_text_box", text_to_enter);

    }

    @MethodsData(method_id = "button_1")
    public void enter_text_edit_notes(String text_to_enter) {
        wait.wait_until_element_is_visible("notes_text_box");
        element.find("notes_text_box");
        element.click("notes_text_box");
        element.clear_text_field("notes_text_box");
        element.enter_text("notes_text_box", text_to_enter);

    }

    @MethodsData(method_id = "button_1")
    public void click_on_save_button() {
        wait.wait_until_element_is_visible("notes_save_button");
        element.click("notes_save_button");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_notes_edit_button() {
        wait.wait_until_element_is_visible("notes_edit_button");
        element.click("notes_edit_button");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_notes_save_button() {
        element.find("notes_edit_button");
        element.click("notes_edit_button");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_notes_update_button() {
        wait.wait_until_element_is_visible("notes_update_button");
        element.click("notes_update_button");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_notes_cancel_button() {
        wait.wait_until_element_is_visible("click_on_notes_cancel_button");
        element.click("click_on_notes_cancel_button");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_first_name_button() {
        wait.wait_until_element_is_visible("message_popup_first_name_button");
        element.click("message_popup_first_name_button");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_last_name_button() {
        wait.wait_for_second(3);
        element.click("message_popup_last_name_button");

    }

    @MethodsData(method_id = "button_1")
    public void message_sent_successfully_validation() {
        wait.wait_until_element_is_visible("message_sent_successfully_msg");
        verify.element_is_present("message_sent_successfully_msg");

    }

    @MethodsData(method_id = "button_1")
    public void verify_send_message_employee_header_is_present_on_page() {
        wait.wait_until_element_is_visible("send_message_employee_header");
        verify.element_is_present("send_message_employee_header");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_send_message_popup_copy_icon() {
        wait.wait_until_element_is_visible("message_popup_copy_icon");
        element.click("message_popup_copy_icon");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_message_text_box() {
        wait.wait_for_second(1);
        element.click("message_text_area");
    }

    @MethodsData(method_id = "button_1")
    public void paste_message() {
        wait.wait_for_second(1);
        element.find("message_text_area").sendKeys(Keys.CONTROL, "v");
        wait.wait_for_second(1);

    }

    @MethodsData(method_id = "button_1")
    public void add_program_popup_paste_copy_message() {
        wait.wait_for_second(2);
        element.find("search_program_text_box").sendKeys(Keys.CONTROL, "v");

    }

    @MethodsData(method_id = "button_1")
    public void verify_copy_message_display() {
        wait.wait_for_second(1);
        element.click("copy_message_display");
    }

    @MethodsData(method_id = "button_1")
    public void verify_add_program_copy_message_display() {
        wait.wait_for_second(1);
        verify.element_is_present("search_program_text_box");
    }


    @MethodsData(method_id = "button_1")
    public void verify_cross_button_is_present_on_page() {
        verify.element_is_present("cross_button");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_cross_button() {
        wait.wait_for_second(1);
        element.click("cross_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_first_name_is_present_on_page() {
        wait.wait_until_element_is_visible("first_name");
        verify.element_is_present("first_name");
    }

    @MethodsData(method_id = "button_1")
    public void verify_last_name_is_present_on_page() {
        wait.wait_until_element_is_visible("last_name");
        verify.element_is_present("last_name");
    }

    @MethodsData(method_id = "button_1")
    public void verify_cancel_button_is_present_on_page() {
        verify.element_is_present("message_cancel_button_popup");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_cancel_button() {
        element.click("message_cancel_button_popup");
    }

    @MethodsData(method_id = "button_1")
    public void verify_send_button_is_present_on_page() {
        verify.element_is_present("send_button");
        wait.wait_for_second(1);
    }

    @MethodsData(method_id = "button_1")
    public void click_on_send_button() {
        wait.wait_for_second(3);
        element.click("send_button");
        wait.wait_for_second(2);
    }

    @MethodsData(method_id = "button_1")
    public void verify_message_sent_successfully_alert_msg() {
        wait.wait_until_element_is_visible("msg_validation_of_successfully_msg");
        verify.element_is_present("msg_validation_of_successfully_msg");
    }

    @MethodsData(method_id = "button_1")
    public void verify_message_sent_successfully_validation_display() {
        element.find("sent_successfully_msg");
        verify.element_is_present("sent_successfully_msg");
    }

    @MethodsData(method_id = "button_1")
    public void verify_message_require_error_msg_is_present_on_page() {
        wait.wait_until_element_is_visible("message_require_error_msg");
        verify.element_is_present("message_require_error_msg");
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_write_message_text_box(String text_to_enter) {
        wait.wait_for_second(3);
        element.click("write_message_text_box");
        element.enter_text("write_message_text_box", text_to_enter);
        wait.wait_for_second(2);
    }

    @MethodsData(method_id = "button_1")
    public void verify_personal_info_edit_button_is_present_on_page() {
        wait.wait_for_second(1);
        verify.element_is_present("personal_info_edit_button");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_personal_info_edit_button() {
        element.click("personal_info_edit_button");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_calendar_icon_of_birthday_field() {
        element.click("click_on_birthday_calendar_icon");
    }

    @MethodsData(method_id = "button_1")
    public void verify_calendar_popup_show() {
        element.click("birthday_calendar_popup_show");
        wait.wait_for_second(2);
    }

    @MethodsData(method_id = "button_1")
    public void select_birthday_date_in_calendar() {
        //("select_birthday_from_calendar");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_country_drop_down_button() {
        element.click("click_on_country_code_drop_down");
    }

    @MethodsData(method_id = "button_1")
    public void enter_text_country_code(String text_to_enter) {
        element.enter_text("enter_country_code", text_to_enter);
    }

    @MethodsData(method_id = "button_1")
    public void select_country_name_with_country_code() {
        element.click("select_country_code_and_name");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_phone_number_text_box() {
        element.click("click_on_phone_number_text_box_edit_info");
    }

    @MethodsData(method_id = "button_1")
    public void mouse_hover_on_email_address() {
        wait.wait_for_second(2);
        verify.element_is_present("email_text_box_edit_info");
    }

    @MethodsData(method_id = "button_1")
    public void verify_not_able_to_edit_the_email_address() {
        wait.wait_for_second(2);
        verify.element_is_present("disable_email_text_box_edit_info");
    }

    @MethodsData(method_id = "button_1")
    public void verify_management_info_edit_button_is_present_on_page() {
        wait.wait_until_element_is_visible("management_info_edit_button");
        verify.element_is_present("management_info_edit_button");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_management_info_edit_button() {
        wait.wait_until_element_is_visible("management_info_edit_button");
        element.click("management_info_edit_button");
    }

    @MethodsData(method_id = "button_1")
    public void enter_management_info_employee_phone_number_as_string(String text_to_enter) {
        element.click("management_info_employee_number");
        element.clear_text_field("management_info_employee_number");
        element.enter_text("management_info_employee_number", text_to_enter);
    }

    @MethodsData(method_id = "button_1")
    public void click_on_calendar_icon() {
        wait.wait_until_element_is_visible("management_info_calendar_icon");
        element.click("management_info_calendar_icon");
    }

    @MethodsData(method_id = "button_1")
    public void calendar_date_picker_popup_display() {
        element.click("management_info_calendar_popup");
        wait.wait_for_second(3);

    }

    @MethodsData(method_id = "button_1")
    public void click_on_disciplines_dropdown_button() {
        element.click("employee_disciplines_dropdown");
    }

    @MethodsData(method_id = "button_1")
    public void verify_discipline_dropdown_list_present_on_page() {
        element.click("employee_disciplines_dropdown_list");
    }

    @MethodsData(method_id = "button_1")
    public void select_disciplines_in_dropdown_list() {
        wait.wait_until_element_is_visible("select_discipline1");
        element.click("select_discipline1");
        wait.wait_until_element_is_visible("select_discipline2");
        element.click("select_discipline2");
        wait.wait_until_element_is_visible("select_discipline3");
        element.click("select_discipline3");
        wait.wait_for_second(1);
        element.click("verify_employee_name");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_location_dropdown_button() {
        element.click("employee_location_dropdown");
    }

    @MethodsData(method_id = "button_1")
    public void verify_location_dropdown_list_present_on_page() {
        wait.wait_for_second(2);
        verify.element_is_present("employee_location_dropdown_list");
    }

    @MethodsData(method_id = "button_1")
    public void select_location_in_dropdown_list() {
        wait.wait_until_element_is_visible("select_location_in_dropdown");
        element.click("select_location_in_dropdown");
        wait.wait_for_second(1);
    }

    @MethodsData(method_id = "button_1")
    public void click_on_sub_location_dropdown_button() {
        wait.wait_for_second(2);
        element.click("sub_location_dropdown");
        wait.wait_for_second(1);
    }

    @MethodsData(method_id = "button_1")
    public void verify_sub_location_dropdown_list_present_on_page() {
        verify.element_is_present("sub_location_dropdown_popup");
        wait.wait_for_second(3);
    }

    @MethodsData(method_id = "button_1")
    public void select_sub_location_in_dropdown_list() {
        wait.wait_for_second(1);
        element.click("click_on_sub_location");
        wait.wait_for_second(2);
        element.click("verify_employee_name");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_Training_Accessible_During_Shift() {
        wait.wait_until_element_is_visible("training_Accessible_check_box");
        element.click("training_Accessible_check_box");

    }

    @MethodsData(method_id = "button_1")
    public void confirm_popup_display() {
        verify.element_is_present("confirm_popup_show_heading");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_confirm_button() {
        element.click("click_confirm_button");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_close_icon() {
        element.click("");

    }

    @MethodsData(method_id = "button_1")
    public void verify_accessible_during_shift_validation_msg() {
        verify.element_is_present("accessible_during_shift_validation_msg_display");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_confirm_popup_cancel_button() {
        element.click("click_cancel_button");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_Is_Applicant_check_box_button() {
        wait.wait_until_element_is_visible("click_on_Is_Applicant_button");
        element.click("click_on_Is_Applicant_button");
        //element.click("click_on_Is_Applicant_button_checked");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_management_employee_number_text_box() {
        element.click("manage_info_employee_number_text_box");
        element.clear_text_field("manage_info_employee_number_text_box");
        element.click("manage_info_employee_number_text_box");
    }

    @MethodsData(method_id = "button_1")
    public void verify_preferred_language_drop_down_is_present_on_page() {
        wait.wait_for_second(3);
        verify.element_is_present("preferred_language_drop_down");
    }

    @MethodsData(method_id = "button_1")
    public void select_language_from_the_dropdown() {
        wait.wait_until_element_is_visible("select_language_from_drop_down");
        element.click("select_language_from_drop_down");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_preferred_language_drop_down() {
        wait.wait_for_second(1);
        element.click("preferred_language_drop_down");
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_employee_first_name(String text_to_enter) {
        wait.wait_for_second(2);
        element.click("employee_first_name");
//        element.clear_text_field("employee_first_name");
        element.clear_and_enter_in_text_field("employee_first_name", text_to_enter);
        wait.wait_for_second(2);
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_employee_last_name(String text_to_enter) {
        wait.wait_for_second(2);
        element.click("employee_last_name");
        element.clear_and_enter_in_text_field("employee_last_name", text_to_enter);
        wait.wait_for_second(2);
    }

    @MethodsData(method_id = "button_1")
    public void remove_first_name() {
        wait.wait_until_element_is_visible("employee_first_name");
        element.clear_text_field("employee_first_name");

    }

    @MethodsData(method_id = "button_1")
    public void remove_last_name() {
        wait.wait_for_second(1);
        element.clear_text_field("employee_last_name");

    }

    @MethodsData(method_id = "button_1")
    public void remove_phone_number() {
        wait.wait_for_second(1);
        element.clear_text_field("employee_phone");

    }

    @MethodsData(method_id = "button_1")
    public void verify_personal_info_mandatory_field_is_validation_msg() {
        wait.wait_until_element_is_visible("first_name_required_validation");
        wait.wait_until_element_is_visible("last_name_required_validation");
        wait.wait_until_element_is_visible("phone_number_required_validation");
        verify.element_is_present("first_name_required_validation");
        verify.element_is_present("last_name_required_validation");
        verify.element_is_present("phone_number_required_validation");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_personal_info_update_button() {
        wait.wait_until_element_is_visible("personal_info_update_button");
        element.click("personal_info_update_button");
        wait.wait_for_second(1);

    }

    @MethodsData(method_id = "button_1")
    public void click_on_management_info_update_button() {
        wait.wait_for_second(2);
        element.click("management_info_update_button");
        wait.wait_for_second(1);

    }

    @MethodsData(method_id = "button_1")
    public void click_on_popup_close_icon() {
        wait.wait_until_element_is_visible("popup_close_icon");
        element.click("popup_close_icon");

    }

    @MethodsData(method_id = "button_1")
    public void verify_info_edited_successfully_alert_msg_is_present_on_page() {

        wait.wait_until_element_is_visible("info_edited_successfully_alert_msg");
        verify.element_is_present("info_edited_successfully_alert_msg");
    }

    @MethodsData(method_id = "button_1")
    public void verify_management_info_employee_phone_number_alert_msg() {
        wait.wait_until_element_is_visible("management_info_employee_number_required_num_msg");
        verify.element_is_present("management_info_employee_number_required_num_msg");
    }


    @MethodsData(method_id = "button_1")
    public void click_on_personal_info_cancel() {
        element.click("personal_info_cancel");
    }

    @MethodsData(method_id = "button_1")
    public void verify_employee_employee_number_is_present_on_page() {
        wait.wait_for_second(3);
        verify.element_is_present("employee_employee_number");
    }

    @MethodsData(method_id = "button_1")
    public void verify_add_program_button_is_present_on_page() {
        wait.wait_until_element_is_visible("add_program_button");
        verify.element_is_present("add_program_button");
    }


    @MethodsData(method_id = "button_1")
    public void click_on_add_program_button() {
        element.find("add_program_button");
        element.click("add_program_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_add_employee_to_program_header_is_present_on_page() {
        wait.wait_until_element_is_visible("add_employee_to_program_header");
        verify.element_is_present("add_employee_to_program_header");
    }

    @MethodsData(method_id = "button_1")
    public void verify_content_of_add_employees_program_popup() {
        wait.wait_for_second(3);
        verify.element_is_present("add_employee_to_program_header");
        verify.element_is_present("program_dropdown_button");
        verify.element_is_present("online_program_button");
        verify.element_is_present("in_class_program_button");
        verify.element_is_present("add_program_Popup_submit_button");
        verify.element_is_present("cancel_button_from_program_popup");
    }

    @MethodsData(method_id = "button_1")
    public void select_on_online_program_button() {
        wait.wait_for_second(4);
        element.click("online_program_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_online_program_details_present() {
        wait.wait_until_element_is_visible("add_program_start_date_dropdown_button");
        verify.element_is_present("add_program_start_date_dropdown_button");
        verify.element_is_present("program_due_date_dropdown_employee_action");
        verify.element_is_present("program_dropdown_button");
        verify.element_is_present("add_program_Popup_submit_button");
    }

    @MethodsData(method_id = "button_1")
    public void select_on_In_class_program__button() {
        wait.wait_until_element_is_visible("in_class_program_button");
        element.click("in_class_program_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_In_class_program_details_present() {
        wait.wait_until_element_is_visible("program_dropdown_button");
        verify.element_is_present("program_dropdown_button");

        verify.element_is_present("session_dropdown_button");
        verify.element_is_present("add_program_Popup_submit_button");
        wait.wait_for_second(1);
    }

    @MethodsData(method_id = "button_1")
    public void verify_session_dropdown_button() {
        wait.wait_until_element_is_visible("session_dropdown_button");
        verify.element_is_present("session_dropdown_button");
    }

    @MethodsData(method_id = "button_1")
    public void Click_on_session_dropdown_button() {
        wait.wait_for_second(2);
        element.click("session_dropdown_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_session_dropdown_options_employee_profile() {
        wait.wait_until_element_is_visible("session_dropdown_options_employee_profile");
        verify.element_is_present("session_dropdown_options_employee_profile");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_session_dropdown_options_employee_profile() {
        element.click("session_dropdown_options_employee_profile");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_cross_button_add_program() {
        element.click("cross_button_add_program");
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_employee_phone(String text_to_enter) {
        wait.wait_for_second(2);
        element.click("employee_phone");
        element.clear_and_enter_in_text_field("employee_phone", text_to_enter);
        wait.wait_for_second(2);
    }

    @MethodsData(method_id = "button_1")
    public void verify_phone_number_validation_msg_show() {
        wait.wait_until_element_is_visible("phone_number_validation_msg");
        verify.element_is_present("phone_number_validation_msg");
    }

    @MethodsData(method_id = "button_1")
    public void verify_help_icon_is_present_on_page() {
        wait.wait_for_second(3);
        verify.element_is_present("help_icon");
    }

    @MethodsData(method_id = "button_1")
    public void Click_on_programs_dropdown() {
        //wait.wait_until_element_is_visible("program_dropdown_button");
        wait.wait_for_second(2);
        element.click("program_dropdown_button");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_add_program_popup_copy_icon() {
        wait.wait_for_second(1);
        element.click("add_program_popup_copy_icon");
    }

    @MethodsData(method_id = "button_1")
    public void verify_display_list_of_programs_added_to_the_agency() {
        wait.wait_until_element_is_visible("program_popup_dropdown_list");
        element.find("program_popup_dropdown_list");
        verify.element_is_present("program_popup_dropdown_list");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_search_program_text_box() {
        wait.wait_until_element_is_visible("search_program_text_box");
        element.click("search_program_text_box");
    }

    @MethodsData(method_id = "button_1")
    public void enter_text_program_name(String text_to_enter) {
        wait.wait_for_second(2);
        element.click("search_program_text_box");
        element.enter_text("search_program_name", text_to_enter);
        wait.wait_for_second(2);
    }

    @MethodsData(method_id = "button_1")
    public void click_on_search_program_name() {
        element.click("click_searched_program_name");
        element.click("add_employee_to_program_header");
    }

    @MethodsData(method_id = "button_1")
    public void Click_on_session_dropdown() {
        wait.wait_until_element_is_visible("session_dropdown");
        element.click("session_dropdown");
        wait.wait_until_element_is_clickable("session_dropdown");
        //element.click("add_employee_popup");


    }

    @MethodsData(method_id = "button_1")
    public void verify_display_create_new_session() {
        wait.wait_until_element_is_visible("display_create_new_session_text");
        verify.element_is_present("display_create_new_session_text");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_create_new_session() {
        element.find("create_new_session_button");
        element.click("create_new_session_button");

    }

    @MethodsData(method_id = "button_1")
    public void verify_create_new_session_details() {
        wait.wait_until_element_is_visible("create_new_session_details");
        verify.element_is_present("create_new_session_details");

    }

    @MethodsData(method_id = "button_1")
    public void text_enter_session_name(String text_to_enter) {
        wait.wait_for_second(1);
        element.click("session_name");
        element.enter_text("session_name", text_to_enter);

    }

    @MethodsData(method_id = "button_1")
    public void text_enter_session_Supervisor(String text_to_enter) {
        wait.wait_for_second(2);
        element.click("session_Supervisor");
        element.enter_text("session_Supervisor", text_to_enter);

    }

    @MethodsData(method_id = "button_1")
    public void session_schedule_click_on_calendar_icon() {
        wait.wait_until_element_is_visible("session_scheduled_calendar_icon");
        element.click("session_scheduled_calendar_icon");

    }

    @MethodsData(method_id = "button_1")
    public void verify_session_schedule_calendar_popup_display() {
        wait.wait_until_element_is_visible("session_scheduled_calendar_popup");
        verify.element_is_present("session_scheduled_calendar_popup");

    }

    @MethodsData(method_id = "button_1")
    public void select_scheduled_from_calendar() {
        wait.wait_for_second(3);
        element.click("session_scheduled_from_calendar");
        wait.wait_for_second(3);
    }

    @MethodsData(method_id = "button_1")
    public void click_on_Add_field() {
        wait.wait_until_element_is_visible("add_field_text");
        element.click("add_field_text");
    }

    @MethodsData(method_id = "button_1")
    public void text_enter_new_field_name(String text_to_enter) {
        wait.wait_until_element_is_visible("new_field_name");
        verify.element_is_present("new_field_name");
        element.click("new_field_name");
        element.enter_text("new_field_name", text_to_enter);
    }

    @MethodsData(method_id = "button_1")
    public void text_enter_new_field_value(String text_to_enter) {
        wait.wait_until_element_is_visible("new_field_value");
        verify.element_is_present("new_field_value");
        element.click("new_field_value");
        element.enter_text("new_field_value", text_to_enter);
    }

    @MethodsData(method_id = "button_1")
    public void click_on_delete_icon() {
        wait.wait_until_element_is_clickable("session_new_field_delete_icon");
        element.click("session_new_field_delete_icon");

    }

    @MethodsData(method_id = "button_1")
    public void verify_display_select_program_first() {
        wait.wait_until_element_is_visible("select_program_first_text");
        verify.element_is_present("select_program_first_text");

    }

    @MethodsData(method_id = "button_1")
    public void verify_display_list_of_session() {
        verify.element_is_present("session_dropdown_list");
        //element.click("add_employee_popup");

    }

    @MethodsData(method_id = "button_1")
    public void verify_display_list_of_session_present() {
        wait.wait_for_second(1);
        verify.element_is_present("session_dropdown_list");
        //element.click("add_employee_popup");

    }

    @MethodsData(method_id = "button_1")
    public void select_session_from_the_dropdown() {
        wait.wait_for_second(2);
        element.find("select_session_in_dropdown");
        element.click("select_session_in_dropdown");
        //element.click("add_employee_popup");

    }

    @MethodsData(method_id = "button_1")
    public void select_program_from_the_dropdown() {
        wait.wait_for_second(2);
        element.click("select_program_from_dropdown");
        //element.click("select_program_more_from_dropdown");
        //element.click("select_program_one_more_from_dropdown");
        element.click("add_employee_to_program_header");
        wait.wait_for_second(1);
    }

    @MethodsData(method_id = "button_1")
    public void select_session_program_from_the_dropdown() {
        //wait.wait_until_element_is_visible("select_in_class_program_from_dropdown");
        element.find("select_in_class_program_from_dropdown");
        element.click("select_in_class_program_from_dropdown");
        //element.click("cross_button_of_Drop_Down");

    }

    @MethodsData(method_id = "button_1")
    public void Click_on_start_date_dropdown() {
        wait.wait_until_element_is_visible("add_program_start_date_dropdown_button");
        element.click("add_program_start_date_dropdown_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_display_list_of_start_date_option() {
        wait.wait_until_element_is_visible("start_date_dropdown_list");
        verify.element_is_present("start_date_dropdown_list");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_start_date_anniversary_month_option() {
        wait.wait_until_element_is_visible("start_date_anniversary_month_option");
        element.click("start_date_anniversary_month_option");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_start_date_anniversary_date_option() {
        wait.wait_until_element_is_visible("start_date_anniversary_date_option");
        element.click("start_date_anniversary_date_option");
    }

    @MethodsData(method_id = "button_1")
    public void Click_on_due_date_dropdown() {
        wait.wait_until_element_is_visible("program_due_date_dropdown_employee_action");
        element.click("program_due_date_dropdown_employee_action");
    }

    @MethodsData(method_id = "button_1")
    public void verify_display_list_of_due_date_option() {
        wait.wait_until_element_is_visible("due_date_dropdown_list");
        verify.element_is_present("due_date_dropdown_list");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_Custom_due_date_option() {
        wait.wait_until_element_is_visible("custom_due_date_option");
        element.click("custom_due_date_option");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_Custom_start_date_option() {
        wait.wait_until_element_is_visible("custom_start_date_option");
        element.click("custom_start_date_option");
    }

    @MethodsData(method_id = "button_1")
    public void verify_display_custom_due_date_calendar_option() {
        wait.wait_until_element_is_visible("custom_due_date_calendar_option");
        verify.element_is_present("custom_due_date_calendar_option");
    }

    @MethodsData(method_id = "button_1")
    public void verify_display_custom_start_date_calendar_option() {
        wait.wait_until_element_is_visible("custom_start_date_calendar_option");
        verify.element_is_present("custom_start_date_calendar_option");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_due_custom_date_picker_calendar_icon() {
        wait.wait_until_element_is_visible("custom_due_date_calendar_option");
        element.click("custom_due_date_calendar_option");
        wait.wait_for_second(4);
    }

    @MethodsData(method_id = "button_1")
    public void click_on_start_custom_date_picker_calendar_icon() {
        wait.wait_until_element_is_visible("click_on_calendar_icon_for_start_custom_date");
        element.click("click_on_calendar_icon_for_start_custom_date");
        wait.wait_for_second(4);
    }

    @MethodsData(method_id = "button_1")
    public void calendar_due_date_picker_popup_display() {
        wait.wait_for_second(4);
        element.click("display_calendar_popup_for_due_custom_date");

//        LocalDate currentdDate1 =  LocalDate.now();
//        LocalDate currentDatePlus1 = currentdDate1.plusDays(1);
//
//        Map map = new HashMap();
//        map.put("day",""+currentDatePlus1.getDayOfMonth());
//
//
//        try {
//            element.find_element_using_dynamic_xpath("display_calendar_popup_for_due_custom_date",map).click();
//        } catch (locator_validation_exception e) {
//            throw new RuntimeException(e);
//        }

        wait.wait_for_second(5);
    }

    @MethodsData(method_id = "button_1")
    public void calendar_start_date_picker_popup_display() {
        wait.wait_for_second(4);
        element.click("display_calendar_popup_for_start_custom_date");

//        LocalDate currentdDate1 =  LocalDate.now();
//        LocalDate currentDatePlus1 = currentdDate1.plusDays(1);
//
//        Map map = new HashMap();
//        map.put("day",""+currentDatePlus1.getDayOfMonth());
//
//
//        try {
//            element.find_element_using_dynamic_xpath("display_calendar_popup_for_start_custom_date",map).click();
//        } catch (locator_validation_exception e) {
//            throw new RuntimeException(e);
//        }

        wait.wait_for_second(5);
    }


    @MethodsData(method_id = "button_1")
    public void clicks_on_submit_without_entering_date_in_custom_date() {
        wait.wait_for_second(4);
        element.click("submit_button_from_program_popup");
    }

    @MethodsData(method_id = "button_1")
    public void verify_due_date_validation_message_displayed() {
        wait.wait_until_element_is_visible("due_date_validation_msg_display");
        element.find("due_date_validation_msg_display");
        wait.wait_for_second(1);
    }

    @MethodsData(method_id = "button_1")
    public void Clicks_on_submit_without_selecting_any_program() {
        wait.wait_for_second(3);
        element.click("add_program_Popup_submit_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_Program_is_required_validation_msg_display() {
        wait.wait_for_second(2);
        element.find("program_required_validation_msg");
        wait.wait_for_second(2);
    }

    @MethodsData(method_id = "button_1")
    public void verify_Provider_added_to_Program_validation_msg_display() {
        wait.wait_until_element_is_visible("already_program_added_validation_msg");
        verify.element_is_present("already_program_added_validation_msg");

    }

    @MethodsData(method_id = "button_1")
    public void verify_employee_added_to_Program_validation_msg() {
        wait.wait_until_element_is_visible("employee_added_program_validation_msg");
        element.find("employee_added_program_validation_msg");
        verify.element_is_present("employee_added_program_validation_msg");
    }

    @MethodsData(method_id = "button_1")
    public void verify_custom_duration_day_validation_msg_display() {
        wait.wait_until_element_is_visible("employee_added_program_validation_msg");
        verify.element_is_present("employee_added_program_validation_msg");

    }

    @MethodsData(method_id = "button_1")
    public void verify_newly_added_program_available_on_program_profile_page() {
        wait.wait_until_element_is_visible("newly_added_program_display");
        verify.element_is_present("newly_added_program_display");

    }

    @MethodsData(method_id = "button_1")
    public void verify_Provider_inactive_added_to_Program_validation_msg_display() {
        wait.wait_until_element_is_visible("inactive_emp_program_added_validation_msg");
        verify.element_is_present("inactive_emp_program_added_validation_msg");

    }

    @MethodsData(method_id = "button_1")
    public void verify_Provider_start_date_mandatory_validation_msg_display() {
        wait.wait_until_element_is_visible("start_date_mandatory_validation_msg");
        verify.element_is_present("start_date_mandatory_validation_msg");

    }

    @MethodsData(method_id = "button_1")
    public void verify_add_program_popup_session_required_validation_msg_display() {
        wait.wait_until_element_is_visible("already_program_added_validation_msg");
        verify.element_is_present("already_program_added_validation_msg");

    }

    @MethodsData(method_id = "button_1")
    public void verify_Provider_already_added_to_Program_validation_msg_display() {

        element.find("already_program_added_validation_msg");
        verify.element_is_present("already_program_added_validation_msg");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_close_icon_button() {
        wait.wait_for_second(1);
        element.click("close_icon_button");
        wait.wait_for_second(5);
    }

    @MethodsData(method_id = "button_1")
    public void add_employee_program_popup_disappears_and_redirect_to_employee_profile_page() {
        verify.element_is_present("employee_profile_page");
        wait.wait_for_second(1);
    }

    @MethodsData(method_id = "button_1")
    public void select_today_option_in_start_date_dropdown() {
        wait.wait_for_second(1);
        element.click("today_option_start_date_dropdown");
        wait.wait_for_second(2);
    }

    @MethodsData(method_id = "button_1")
    public void click_on_add_program_submit_button() {
        wait.wait_until_element_is_visible("add_program_Popup_submit_button");
        element.perform_scroll_to_element("add_program_Popup_submit_button");
        element.click("add_program_Popup_submit_button");


    }

    @MethodsData(method_id = "button_1")
    public void click_on_cancle_button() {
        wait.wait_until_element_is_visible("click_on_cancel_button");
        element.click("click_on_cancel_button");
        //wait.wait_for_second(1);
    }

    @MethodsData(method_id = "button_1")
    public void verify_action_dropdown_button_is_present_on_page() {
        wait.wait_until_element_is_visible("action_dropdown_button");
        verify.element_is_present("action_dropdown_button");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_action_dropdown_button() {
        wait.wait_until_element_is_visible("action_dropdown_button");
        element.click("action_dropdown_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_action_dropdown_option_present() {
        wait.wait_until_element_is_visible("set_status_action_dropdown_option");
        verify.element_is_present("set_status_action_dropdown_option");
        verify.element_is_present("reset_password_action_dropdown_option");
        verify.element_is_present("employee_history_action_dropdown_option");
        verify.element_is_present("open_ticket_action_dropdown_option");
        verify.element_is_present("copy_api_id_action_dropdown_option");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_Custom_duration_option() {
        wait.wait_until_element_is_visible("custom_duration_option");
        element.click("custom_duration_option");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_active_option() {
        wait.wait_until_element_is_visible("active_option");
        element.click("active_option");
        wait.wait_for_second(1);
    }

    @MethodsData(method_id = "button_1")
    public void click_on_on_hold_option() {
        wait.wait_until_element_is_visible("on_hold_option");
        element.click("on_hold_option");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_terminated_option() {
        wait.wait_until_element_is_visible("terminated_option");
        element.click("terminated_option");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_set_status_on_option() {
        wait.wait_until_element_is_visible("set_status_on_option");
        element.click("set_status_on_option");
        element.click("set_status_on_option");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_Employee_History_option() {
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("employee_history_option");
        element.click("employee_history_option");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_open_ticket_option() {
        wait.wait_until_element_is_visible("open_ticket_option");
        element.click("open_ticket_option");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_Copy_API_ID_option() {
        wait.wait_until_element_is_visible("copy_api_id_option");
        element.click("copy_api_id_option");
        wait. wait_for_second(3);

    }

    @MethodsData(method_id = "button_1")
    public void verify_copied_validation_msg_present() {
        wait.wait_until_element_is_visible("copied_msg_validation");
        verify.element_is_present("copied_msg_validation");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_form_submit_button() {
        verify.element_is_present("agency_form_submit_button");
        element.click("agency_form_submit_button");

    }

    @MethodsData(method_id = "button_1")
    public void verify_required_field_validation_msg_present() {
        wait.wait_until_element_is_visible("agency_form_alert_msg");
        verify.element_is_present("agency_form_alert_msg");

    }

    @MethodsData(method_id = "button_1")
    public void verify_agency_form_present_on_page() {
        wait.wait_until_element_is_visible("open_ticket_agency_form");
        verify.element_is_present("open_ticket_agency_form");

    }

    @MethodsData(method_id = "button_1")
    public void verify_Employee_History_popup_present_on_page() {
        wait.wait_until_element_is_visible("employee_history_popup");
        verify.element_is_present("employee_history_popup");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_reset_password_option() {
        wait.wait_until_element_is_visible("reset_password_action_dropdown_option");
        element.click("reset_password_action_dropdown_option");
        element.click("reset_password_action_dropdown_option");
    }

    @MethodsData(method_id = "button_1")
    public void verify_reset_password_option_present_on_page() {
        element.find("reset_password_dropdown_option");
        verify.element_is_present("reset_password_dropdown_option");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_reset_password_SMS_option() {
        wait.wait_until_element_is_visible("sms_option");
        element.click("sms_option");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_reset_password_Email_option() {
        wait.wait_until_element_is_visible("email_option");
        element.click("email_option");
    }

    @MethodsData(method_id = "button_1")
    public void verify_change_password_popup_is_present_on_page() {
        wait.wait_until_element_is_visible("change_password_popup");
        verify.element_is_present("change_password_popup");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_change_password_popup_cancel_button() {
        wait.wait_until_element_is_visible("change_password_popup_cancel_button");
        element.click("change_password_popup_cancel_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_successfully_validation_msg_present_on_page() {
        wait.wait_until_element_is_visible("status_updated_successfully");
        verify.element_is_present("status_updated_successfully");
    }

    @MethodsData(method_id = "button_1")
    public void verify_display_custom_duration_selection_option_present() {
        wait.wait_until_element_is_visible("select_custom_duration_option_available");
        verify.element_is_present("select_custom_duration_option_available");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_upward_dropdown() {
        element.click("upward_custom_duration_dropdown");
        element.click("upward_custom_duration_dropdown");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_start_date_today_option() {
        element.click("start_date_today_option");

    }

    @MethodsData(method_id = "button_1")
    public void verify_start_date_mandatory_validation_msg_display() {
        wait.wait_until_element_is_visible("start_date_mandatory_validation_display");
        verify.element_is_present("start_date_mandatory_validation_display");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_due_date_31st_option() {
        wait.wait_until_element_is_visible("due_date_31st_option");
        element.click("due_date_31st_option");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_due_date_1_year_from_start_option() {
        wait.wait_until_element_is_visible("due_date_1_year_start_option");
        element.click("due_date_1_year_start_option");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_send_button_of_the_pop_up() {
        element.click("send_button_sms_employee_profile");

    }

    @MethodsData(method_id = "button_1")
    public void verify_email_sent_message_present_on_page() {
        wait.wait_until_element_is_visible("email_sent_validation_present");
        verify.element_is_present("email_sent_validation_present");

    }

    @MethodsData(method_id = "button_1")
    public void verify_employee_not_singed_up_validation_message_present_on_page() {
        wait.wait_until_element_is_visible("not_singed_up_sent_email_validation_present");
        verify.element_is_present("not_singed_up_sent_email_validation_present");

    }

    @MethodsData(method_id = "button_1")
    public void verify_SMS_sent_message_present_on_page() {
        wait.wait_until_element_is_visible("sms_send_msg_validation");
        verify.element_is_present("sms_send_msg_validation");

    }

    @MethodsData(method_id = "button_1")
    public void click_on_employee_added_program_kebab_icon_button() {
        wait.wait_until_element_is_visible("kebab_icon_button_available_on_program_list");
        element.click("kebab_icon_button_available_on_program_list");
    }

    @MethodsData(method_id = "button_1")
    public void verify_edit_start_date_option_on_employee_profile_page() {
        verify.element_is_present("edit_start_date_option");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_Edit_start_date_option() {
        wait.wait_until_element_is_visible("edit_start_date_option");
        element.click("edit_start_date_option");
    }

    @MethodsData(method_id = "button_1")
    public void verify_Edit_start_date_pop_up_present_on_page() {
        wait.wait_until_element_is_visible("edit_start_date_popup_header");
        verify.element_is_present("edit_start_date_popup_header");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_Edit_start_date_dropdown_button() {
        wait.wait_until_element_is_visible("edit_start_date_dropdown_button");
        element.click("edit_start_date_dropdown_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_start_date_edit_option_present_on_page() {
        wait.wait_until_element_is_visible("edit_start_date_dropdown_option");
        verify.element_is_present("edit_start_date_dropdown_option");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_Today_option_available_in_edit_start_date_dropdown() {
        wait.wait_until_element_is_visible("today_option_of_edit_start_date_popup");
        element.click("today_option_of_edit_start_date_popup");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_update_button_of_edit_start_date_popup() {
        wait.wait_until_element_is_visible("update_button_edit_start_date_popup");
        element.click("update_button_edit_start_date_popup");
    }

    @MethodsData(method_id = "button_1")
    public void verify_edit_start_date_successfully_validation_msg() {
        wait.wait_until_element_is_visible("edit_start_date_successfully_msg");
        verify.element_is_present("edit_start_date_successfully_msg");
    }

    @MethodsData(method_id = "button_1")
    public void verify_edited_start_date_display_on_program_start_date() {
        wait.wait_until_element_is_visible("edited_start_date_show_on_program");
        verify.element_is_present("edited_start_date_show_on_program");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_remove_option() {
        wait.wait_until_element_is_visible("remove_option");
        element.find("remove_option");
        element.click("remove_option");
        wait.wait_for_second(1);
    }

    @MethodsData(method_id = "button_1")
    public void verify_remove_employee_pop_up_present_on_page() {
        wait.wait_until_element_is_visible("remove_employee_popup");
        verify.element_is_present("remove_employee_popup");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_permanently_remove_program_check_box_button() {
        wait.wait_until_element_is_visible("remove_permanently_check_box");
        element.click("remove_permanently_check_box");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_remove_button() {
        wait.wait_until_element_is_visible("remove_button_on_remove_popup");
        element.click("remove_button_on_remove_popup");
    }

    @MethodsData(method_id = "button_1")
    public void verify_remove_program_successfully_validation_msg() {
        wait.wait_until_element_is_visible("remove_successfully_msg");
        verify.element_is_present("remove_successfully_msg");
    }

    @MethodsData(method_id = "button_1")
    public void verify_edit_due_date_button_on_page() {
        wait.wait_until_element_is_visible("edit_due_date_button");
        verify.element_is_present("edit_due_date_button");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_edit_due_date_button() {
        wait.wait_until_element_is_visible("edit_due_date_button");
        element.click("edit_due_date_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_edit_due_date_header_on_page() {
        wait.wait_until_element_is_visible("edit_due_date_header");
        verify.element_is_present("edit_due_date_header");
    }

    @MethodsData(method_id = "button_1")
    public void verify_edit_due_date_drop_down_on_page() {
        wait.wait_until_element_is_visible("edit_due_date_drop_down");
        verify.element_is_present("edit_due_date_drop_down");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_edit_due_date_drop_down() {
        element.click("edit_due_date_drop_down");
    }


    @MethodsData(method_id = "button_1")
    public void verify_custom_date_edit_date_on_page() {
        wait.wait_until_element_is_visible("custom_date_edit_date");
        verify.element_is_present("custom_date_edit_date");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_custom_date_edit_date() {
        element.click("custom_date_edit_date");
    }


    @MethodsData(method_id = "button_1")
    public void verify_due_date_due_date_choose_date_on_page() {
        wait.wait_until_element_is_visible("due_date_due_date_choose_date");
        verify.element_is_present("due_date_due_date_choose_date");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_due_date_due_date_choose_date() {
        element.click("due_date_due_date_choose_date");
    }

    @MethodsData(method_id = "button_1")
    public void verify_due_date_confirm_edit_due_date_on_page() {
        wait.wait_until_element_is_visible("due_date_confirm_edit_due_date");
        verify.element_is_present("due_date_confirm_edit_due_date");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_due_date_confirm_edit_due_date() {
        wait.wait_until_element_is_visible("due_date_confirm_edit_due_date");
        element.click("due_date_confirm_edit_due_date");
    }

    @MethodsData(method_id = "button_1")
    public void verify_provider_course_modified_alert_on_page() {
        wait.wait_until_element_is_visible("provider_course_modified_alert");
        verify.element_is_present("provider_course_modified_alert");
    }

    @MethodsData(method_id = "button_1")
    public void verify_start_date_confirm_edit_due_date_on_page() {
        wait.wait_until_element_is_visible("start_date_confirm_edit_due_date");
        verify.element_is_present("start_date_confirm_edit_due_date");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_start_date_confirm_edit_due_date() {
        element.click("start_date_confirm_edit_due_date");
    }

    @MethodsData(method_id = "button_1")
    public void verify_edit_due_start_header_on_page() {
        wait.wait_until_element_is_visible("edit_due_start_header");
        verify.element_is_present("edit_due_start_header");
    }

    @MethodsData(method_id = "button_1")
    public void verify_custom_edit_date_on_page() {
        wait.wait_until_element_is_visible("custom_edit_date");
        verify.element_is_present("custom_edit_date");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_custom_edit_date() {
        element.click("custom_edit_date");
    }

    @MethodsData(method_id = "button_1")
    public void verify_choose_text_box_start_date_on_page() {
        wait.wait_until_element_is_visible("choose_text_box_start_date");
        verify.element_is_present("choose_text_box_start_date");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_choose_text_box_start_date() {
        element.click("choose_text_box_start_date");
    }

    @MethodsData(method_id = "button_1")
    public void verify_start_date_confirm_edit_date_on_page() {
        wait.wait_until_element_is_visible("start_date_confirm_edit_date");
        verify.element_is_present("start_date_confirm_edit_date");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_start_date_confirm_edit_date() {
        element.click("start_date_confirm_edit_date");
    }

    @MethodsData(method_id = "button_1")
    public void verify_submit_button_on_open_ticket_option_on_page() {
        wait.wait_until_element_is_visible("submit_button_on_open_ticket_option");
        verify.element_is_present("submit_button_on_open_ticket_option");
    }

    @MethodsData(method_id = "button_1")
    public void verify_more_option_due_date_employee_on_page() {
        wait.wait_until_element_is_visible("more_option_due_date_employee");
        verify.element_is_present("more_option_due_date_employee");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_more_option_due_date_employee() {
        wait.wait_until_element_is_visible("more_option_due_date_employee");
        element.click("more_option_due_date_employee");
    }


    @MethodsData(method_id = "button_1")
    public void verify_edit_start_date_option_program_on_page() {
        wait.wait_until_element_is_visible("edit_start_date_option_program");
        verify.element_is_present("edit_start_date_option_program");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_edit_start_date_option_program() {
        wait.wait_until_element_is_visible("edit_start_date_option_program");
        element.click("edit_start_date_option_program");
    }


    @MethodsData(method_id = "button_1")
    public void verify_edit_due_date_option_program_on_page() {
        wait.wait_until_element_is_visible("edit_due_date_option_program");
        verify.element_is_present("edit_due_date_option_program");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_edit_due_date_option_program() {
        wait.wait_until_element_is_visible("edit_due_date_option_program");
        element.click("edit_due_date_option_program");
    }

    @MethodsData(method_id = "button_1")
    public void verify_100_completed_program() {
        element.find("100_percentage_text_program_present");
        verify.element_is_present("100_percentage_text_program_present");
    }

    @MethodsData(method_id = "button_1")
    public void verify_edit_start_date_and_due_date_option_is_enable() {
        element.find("edit_start_date_option_present");
        verify.element_is_present("edit_start_date_option_present");
    }

    @MethodsData(method_id = "button_1")
    public void verify_corona_care_program_is_present() {
        wait.wait_until_element_is_visible("corona_care_program_present");
        verify.element_is_present("corona_care_program_present");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_corona_care_program_kebab_icon_button() {
        element.find("corona_care_program_kebab_icon");
        element.click("corona_care_program_kebab_icon");
        wait.wait_until_element_is_clickable("corona_care_program_kebab_icon");
    }

    @MethodsData(method_id = "button_1")
    public void verify_download_certificate_option_present_on_page() {
        element.find("download_certificate_option");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_download_certificate_option() {
        wait.wait_until_element_is_visible("download_certificate_option");
        element.click("download_certificate_option");
    }

    @MethodsData(method_id = "button_1")
    public void verify_send_certificate_option_present_on_page() {
        element.find("send_certificate_option");
        verify.element_is_present("send_certificate_option");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_send_certificate_option() {
        wait.wait_until_element_is_visible("send_certificate_option");
        element.click("send_certificate_option");
    }

    @MethodsData(method_id = "button_1")
    public void verify_email_send_certificate_successfully_validation_msg() {
        element.find("send_certificate_successfully_msg");
        verify.element_is_present("send_certificate_successfully_msg");
    }

    @MethodsData(method_id = "button_1")
    public void verify_new_session_successfully_added_to_Program_validation_msg_display() {
        wait.wait_until_element_is_visible("session_added_validation_msg");
        verify.element_is_present("session_added_validation_msg");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_search_box_of_program_page_to_search() {
        wait.wait_until_element_is_visible("search_employee_name");
        element.click("search_employee_name");
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_search_button_employee_profile(String text_to_enter) {
        element.find("search_employee_name");
        element.click("search_employee_name");
        element.enter_text("search_employee_name", text_to_enter);
        wait.wait_for_second(1);

    }

    @MethodsData(method_id = "button_1")
    public void verify_validation_msg_displayed() {
        wait.wait_until_element_is_visible("validation_msg");
        element.find("validation_msg");
        verify.element_is_present("validation_msg");
        wait.wait_for_second(1);
    }

    @MethodsData(method_id = "button_1")
    public void click_on_on_terminated_option() {
        wait.wait_until_element_is_visible("terminated");
        element.click("terminated");
    }

    @MethodsData(method_id = "button_1")
    public void verify_validation_msg_displayed_for_terminated() {
        wait.wait_until_element_is_visible("terminated_validation");
        verify.element_is_present("terminated_validation");
        wait.wait_for_second(1);
    }

    @MethodsData(method_id = "button_1")
    public void verify_notes_title_available() {
        wait.wait_until_element_is_visible("notes_title_present");
        verify.element_is_present("notes_title_present");
    }

    public void verify_csuser_on_employee_profile_page(String expectedEmployee) {
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(60));
        wt.until(ExpectedConditions.jsReturnsValue("return document.title==='Employee Profile'"));
        String employeeName = element.get_element_text("employee_profile_name");
        Assert.assertTrue(employeeName.contains(expectedEmployee));
    }

    public void click_on_add_to_agency_button() {
        wait.wait_until_element_is_visible("cs_add_to_agency_button");
        verify.element_is_present("cs_add_to_agency_button");
        element.click("cs_add_to_agency_button");
    }

    public void search_agency_to_add_employee(String agencyName) {
        wait.wait_until_element_is_visible("cs_search_agency_from_employee_profile");
        verify.element_is_present("cs_search_agency_from_employee_profile");
        element.enter_text("cs_search_agency_from_employee_profile", agencyName);
    }

    public void click_on_searched_agency() {
        wait.wait_until_element_is_visible("cs_panel_employee_profile_searched_agency");
        verify.element_is_present("cs_panel_employee_profile_searched_agency");
        element.click("cs_panel_employee_profile_searched_agency");
    }

    public void add_employee_to_agency() {
        wait.wait_until_element_is_visible("cs_panel_add_employee_pop_up");
        verify.element_is_present("cs_panel_add_employee_pop_up");
        element.click("continue_button_on_pop_up");
        wait.wait_until_element_is_visible("employee_firstname_field_on_pop_up");
        verify.element_is_present("employee_firstname_field_on_pop_up");
        element.click("continue_button_on_pop_up");
        wait.wait_until_element_is_visible("employment_date_field");
        verify.element_is_present("employment_date_field");
        element.click("employment_date_field");
        wait.wait_until_element_is_visible("employment_date");
        verify.element_is_present("employment_date");
        element.click("employment_date");
        element.perform_scroll_to_element("create_employee_button");
        element.click("create_employee_button");
    }

    public void verify_employee_added_successfully_to_agency(String agencyName) {
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("top_agency_nav_button"), agencyName);
    }

    public void update_nevvon_info(String firstName, String lastName, String operation) {
        element.clear_and_enter_in_text_field("nevvon_info_firstname_field", firstName);
        element.clear_and_enter_in_text_field("nevvon_info_lastname_field", lastName);
        element.click("nevvon_info_language_dropdown");
        if (operation == "revert") {
            System.out.println("Revert");
            element.click("nevvon_info_revert_language");
        } else {
            System.out.println("Change");
            element.click("nevvon_info_language");
        }
    }

    public void click_on_login_info_edit_button() {
        wait.wait_until_element_is_visible("edit_login_info");
        element.click("edit_login_info");
    }

    public void edit_and_verify_employee_nevvon_info(String firstName, String lastName) {
        map.put("FirstName", firstName);
        map.put("LastName", lastName);
        map.put("Language", element.get_element_text("employee_preferred_language"));
        wait.wait_until_element_is_clickable("edit_nevvon_info");
        verify.element_is_present("edit_nevvon_info");
        element.click("edit_nevvon_info");
        update_nevvon_info(firstName, lastName, "update");
        element.click("nevvon_info_update_button");
        wait.wait_until_element_is_disappear("nevvon_info_update_button");
        wait.wait_until_element_is_visible("employee_data_modified_success");
        verify.element_text_is_equal_to("employee_data_modified_success", "Provider modified successfully");
    }

    public void revert_nevvon_info() {
        wait.wait_until_element_is_clickable("edit_nevvon_info");
        verify.element_is_present("edit_nevvon_info");
        element.click("edit_nevvon_info");
        update_nevvon_info(map.get("FirstName"), map.get("LastName"), "revert");
        element.click("nevvon_info_update_button");
        wait.wait_until_element_is_disappear("nevvon_info_update_button");
        wait.wait_until_element_is_visible("employee_data_modified_success");
        verify.element_text_is_equal_to("employee_data_modified_success", "Provider modified successfully");
    }

    public void update_login_info(String email) {
        wait.wait_until_element_is_clickable("login_info_email_field");
        element.clear_and_enter_in_text_field("login_info_email_field", email);
    }

    public void edit_and_verify_login_info(String email) {
        element.perform_scroll_by_amount(5, 5);
        map.put("Phone", element.get_element_text("employee_phone_number"));
        map.put("Email", element.get_element_text("employee_login_email"));
        wait.wait_until_element_is_clickable("edit_login_info");
        verify.element_is_present("edit_login_info");
        element.click("edit_login_info");
        wait.wait_for_second(5);
        update_login_info(email);
        element.click("login_info_update_button");
        wait.wait_until_element_is_visible("login_confirmation_box");
        verify.element_is_present("login_confirmation_box");
        element.enter_text("login_confirmation_box", "yes");
        element.click("login_confirmation_button");
    }

    public void revert_login_info() {
        wait.wait_until_element_is_visible("edit_login_info");
        verify.element_is_present("edit_login_info");
        element.click("edit_login_info");
        update_login_info(map.get("Email"));
        element.click("login_info_update_button");
        wait.wait_until_element_is_visible("login_confirmation_box");
        verify.element_is_present("login_confirmation_box");
        element.enter_text("login_confirmation_box", "yes");
        element.click("login_confirmation_button");
    }

    public String get_agency_tab_name() {
        lstOfAgencyTabs = element.find_multiple_elements("list_of_agency_tabs");
        int index = (int) (Math.random() * lstOfAgencyTabs.size());
        while (index == 0) {
            index = (int) (Math.random() * lstOfAgencyTabs.size());
        }
        String agencyTab = (String) jsExecutor.executeScript("return arguments[0].innerText", lstOfAgencyTabs.get(index));

        return agencyTab;
    }

    public void click_on_specific_agency(String agency) {
        for (int i = 0; i < lstOfAgencyTabs.size(); i++) {
            if (((String) jsExecutor.executeScript("return arguments[0].innerText", lstOfAgencyTabs.get(i))).equals(agency)) {
                lstOfAgencyTabs.get(i).click();
                break;
            }
        }
    }

    public void verify_action_options_for_cs_user_on_employee_profile() {
        verify.element_is_present("employee_sign_up_option");
        verify.element_is_present("employee_login_option");
        verify.element_is_present("set_status_to_option");
        verify.element_is_present("employee_history_option");
        verify.element_is_present("open_ticket_option");
        verify.element_is_present("copy_api_id_option");
        verify.element_is_present("send_sms_option");
        verify.element_is_present("reset_password_option");
        verify.element_is_present("generate_verification_code_option");
    }

    public void verify_phone_and_email_is_disabled() {
        Assert.assertTrue(element.find("login_info_phone_field").getAttribute("class").contains("cursor-not-allowed"));
        Assert.assertTrue(element.find("login_info_email_field").getAttribute("class").contains("cursor-not-allowed"));
    }

    public void verify_employee_sign_up_button_is_enabled_and_login_button_is_disabled() {
        Assert.assertFalse(element.find("employee_sign_up_option").getAttribute("class").contains("p-disabled"));
        Assert.assertTrue(element.find("employee_login_option").getAttribute("class").contains("p-disabled"));
    }

    public void click_on_generate_verification_code_option() {
        wait.wait_until_element_is_visible("generate_verification_code_option");
        verify.element_is_present("generate_verification_code_option");
        element.click("generate_verification_code_option");
    }

    public void verify_dialog_box_for_employee(String empName) {
        wait.wait_until_element_is_visible("employee_name_on_dialog_box");
        verify.element_is_present("employee_name_on_dialog_box");
        Assert.assertTrue(element.get_element_text("employee_name_on_dialog_box").contains(empName));
    }

    public void click_on_generate_code_button_from_dialog_box() {
        wait.wait_until_element_is_visible("generate_code_button");
        verify.element_is_present("generate_code_button");
        element.click("generate_code_button");
    }

    public void verify_code_is_generated() {
        wait.wait_until_element_is_visible("generated_code");
        verify.element_is_present("generated_code");
        Assert.assertTrue(element.get_element_text("generated_code").length() == 5);
    }

    public void click_on_done_button_from_dialog_box() {
        wait.wait_until_element_is_visible("done_button_on_dialog");
        verify.element_is_present("done_button_on_dialog");
        element.click("done_button_on_dialog");
    }

    public void verify_tab_on_focus(String tabName) {
        lstOfAgencyTabs = driver.findElements(By.xpath("//a[contains(@class,'p-menuitem-link')]/.."));
        for (WebElement ele : lstOfAgencyTabs) {
            String text = (String) jsExecutor.executeScript("return arguments[0].innerText", ele);
            if (text.equals(tabName)) {
                Assert.assertTrue(ele.getAttribute("class").contains("p-highlight"));
                break;
            }
        }

    }

    public void click_on_dashboard_navigation_icon_link() {
        wait.wait_until_element_is_visible("dashboard_navigation_icon_link");
        element.click("dashboard_navigation_icon_link");
    }

    public void select_status(String status) {
        lstOfStatusOptions = element.find_multiple_elements("status_options");
        for (WebElement ele : lstOfStatusOptions) {
            String name = (String) jsExecutor.executeScript("return arguments[0].innerText", ele);
            if (name.equals(status)) {
                ele.click();
                wait.wait_for_second(5);
                break;
            }
        }
    }

    public void verify_status_of_employee(String status) {
        verify.element_text_is_equal_to("employee_current_status", status);
    }

    public void verify_employee_sign_up_button_is_disabled() {
        Assert.assertTrue(element.find("employee_sign_up_option").getAttribute("class").contains("p-disabled"));
    }
}
