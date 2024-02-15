package Screens.profile_page;

import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;
import io.unity.core.generators.methodsgenerator.methods.MethodsData;

public class profile_page {

	WebDriver driver = null;
	Element element = null;
	Verify verify = null;
	Wait wait = null;
	public profile_page(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
		wait = new Wait(driver);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_profile_help_button() {
		element.click("profile_help_button");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_profile_help_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("profile_help_button", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void verify_profile_help_button_is_present_on_page() {
		wait.wait_until_element_is_visible("profile_help_button");
		verify.element_is_present("profile_help_button");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_help_button() {
		element.click("profile_help_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_profile_help_button_is_clickable() {
		verify.element_is_enable("profile_help_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_profile_tab() {
		wait.wait_for_second(4);
		wait.wait_until_element_is_visible("profile_tab");
		element.click("profile_tab");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_profile_tab_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("profile_tab", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void verify_profile_tab_is_present_on_page() {
		wait.wait_until_element_is_visible("profile_tab");
		verify.element_is_present("profile_tab");
	}

	@MethodsData(method_id = "button_2")
	public void verify_profile_tab_is_clickable() {
		verify.element_is_enable("profile_tab");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_language_tab() {
		element.click("language_tab");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_language_tab_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("language_tab", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void verify_language_tab_is_present_on_page() {
		wait.wait_for_second(2);
		wait.wait_until_element_is_visible("language_tab");
		verify.element_is_present("language_tab");
	}

	@MethodsData(method_id = "button_1")
	public void verify_language_tab_button_present_on_page() {
		wait.wait_until_element_is_visible("language_tab_button");
		verify.element_is_present("language_tab_button");
	}

	@MethodsData(method_id = "button_1")
	public void verify_logout_button_is_present_on_page() {
		wait.wait_until_element_is_visible("logout_button");
		verify.element_is_present("logout_button");
	}

	@MethodsData(method_id = "button_1")
	public void verify_logout_btn_is_present_on_page() {
		wait.wait_until_element_is_visible("logout_btn");
		verify.element_is_present("logout_btn");
	}


	@MethodsData(method_id = "button_1")
	public void verify_country_text_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("country_text");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_country_text_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("country_text", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void verify_first_name_text_box_is_present_on_page() {
		wait.wait_until_element_is_visible("first_name_text_box");
		verify.element_is_present("first_name_text_box");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_first_name_text_box() {
		element.click("first_name_text_box");
	}

	@MethodsData(method_id = "button_1")
	public void verify_last_name_text_box_is_present_on_page() {
		wait.wait_until_element_is_visible("last_name_text_box");
		verify.element_is_present("last_name_text_box");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_last_name_text_box() {
		element.click("last_name_text_box");
	}

	@MethodsData(method_id = "button_3")
	public void clear_first_name_text_box() {
		element.clear_text_field("first_name_text_box");
		wait.wait_for_second(2);
	}

	@MethodsData(method_id = "button_3")
	public void enter_text_in_first_name_text_box(String text) {
		element.enter_text("first_name_text_box", text);
	}

	@MethodsData(method_id = "button_3")
	public void clear_last_name_text_box() {
		element.clear_text_field("last_name_text_box");
	}

	@MethodsData(method_id = "button_3")
	public void enter_text_in_last_name_text_box(String text) {
		element.enter_text("last_name_text_box", text);
	}


	@MethodsData(method_id = "button_1")
	public void verify_save_button_is_present_on_page() {
		wait.wait_until_element_is_visible("save_button");
		verify.element_is_present("save_button");
	}

	@MethodsData(method_id = "button_1")
	public boolean verify_save_button_is_displayed_on_page() {
		wait.wait_until_element_is_visible("save_button");
		verify.element_is_present("save_button");
		return false;
	}

	@MethodsData(method_id = "button_1")
	public void click_on_back_button_on_profile_page() {
		wait.wait_until_element_is_visible("profile_back_button");
		verify.element_is_present("profile_back_button");
	}


	@MethodsData(method_id = "button_3")
	public void click_on_save_button() {
		wait.wait_until_element_is_visible("save_button");
		element.click("save_button");
	}


	@MethodsData(method_id = "button_1")
	public void verify_cancel_button_is_present_on_page() {
		wait.wait_for_second(3);
		verify.element_is_present("cancel_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_cancel_button() {
		wait.wait_for_second(5);
		element.click("cancel_button");
	}

	@MethodsData(method_id = "button_1")
	public void verify_first_name_error_alert_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("first_name_error_alert");
	}

	@MethodsData(method_id = "button_1")
	public void verify_last_name_error_alert_is_present_on_page() {
		wait.wait_for_second(8);
		verify.element_is_present("last_name_error_alert");
	}

	@MethodsData(method_id = "button_1")
	public void verify_profile_user_name_text_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("profile_user_name_text");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_back_button() {
		element.click("back_button");
	}



	@MethodsData(method_id = "button_1")
	public void verify_street_text_box_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("street_text_box");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_street_text_box() {
		element.click("street_text_box");
	}

	@MethodsData(method_id = "button_3")
	public void enter_text_in_street_text_box(String text) {
		wait.wait_for_second(1);
		element.enter_text("street_text_box", text);
		driver.navigate().back();
	}

	@MethodsData(method_id = "button_3")
	public void clear_street_text_box() {
		element.clear_text_field("street_text_box");
		driver.navigate().back();
	}

	@MethodsData(method_id = "button_1")
	public void verify_city_text_box_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("city_text_box");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_city_text_box() {
		element.click("city_text_box");
	}

	@MethodsData(method_id = "button_3")
	public void enter_text_in_city_text_box(String text) {
		wait.wait_for_second(1);
		element.enter_text("city_text_box", text);
		driver.navigate().back();
	}


	@MethodsData(method_id = "button_3")
	public void clear_city_text_box() {
		element.clear_text_field("city_text_box");
		driver.navigate().back();
	}

	@MethodsData(method_id = "button_1")
	public void verify_state_text_box_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("state_text_box");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_state_text_box() {
		wait.wait_for_second(2);
		element.click("state_text_box");
	}

	@MethodsData(method_id = "button_3")
	public void enter_text_in_state_text_box(String text) {
		wait.wait_for_second(1);
		element.enter_text("state_text_box", text);
		driver.navigate().back();
	}
	@MethodsData(method_id = "button_3")
	public void clear_state_text_box() {
		element.clear_text_field("state_text_box");
		driver.navigate().back();
	}

	@MethodsData(method_id = "button_1")
	public void verify_country_text_box_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("country_text_box");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_country_text_box() {
		wait.wait_for_second(2);
		element.click("country_text_box");
	}

	@MethodsData(method_id = "button_3")
	public void enter_text_in_country_text_box(String text) {
		wait.wait_for_second(1);
		element.enter_text("country_text_box", text);
		driver.navigate().back();
	}

	@MethodsData(method_id = "button_3")
	public void clear_country_text_box() {
		element.clear_text_field("country_text_box");
		driver.navigate().back();
	}

	@MethodsData(method_id = "button_1")
	public void verify_zip_text_box_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("zip_text_box");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_zip_text_box() {
		wait.wait_for_second(2);
		element.click("zip_text_box");
	}

	@MethodsData(method_id = "button_3")
	public void enter_text_in_zip_text_box(String text) {
		wait.wait_for_second(1);
		element.enter_text("zip_text_box", text);
		driver.navigate().back();
	}

	@MethodsData(method_id = "button_3")
	public void clear_zip_text_box() {
		element.clear_text_field("zip_text_box");
		driver.navigate().back();
	}
	@MethodsData(method_id = "button_1")
	public void verify_profile_updated_successfully_msg_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("profile_updated_successfully_msg");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_ok_button() {

		element.click("ok_button");
	}

	@MethodsData(method_id = "button_1")
	public void verify_not_verified_email_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("not_verified_email");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_not_verified_email() {
		wait.wait_for_second(2);
		element.click("not_verified_email");
	}

	@MethodsData(method_id = "button_1")
	public void verify_not_verified_phone_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("not_verified_phone");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_not_verified_phone() {
		wait.wait_for_second(2);
		element.click("not_verified_phone");
	}

	@MethodsData(method_id = "button_1")
	public void verify_verify_button_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("verify_button");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_verify_button() {
		wait.wait_for_second(2);
		element.click("verify_button");
	}

	@MethodsData(method_id = "button_1")
	public void verify_cancel_button_verify_popup_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("cancel_button");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_cancel_button_popup() {
		wait.wait_for_second(2);
		element.click("cancel_button");
	}

	@MethodsData(method_id = "button_1")
	public void verify_delete_profile_button_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("delete_profile_button");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_delete_profile_button_popup() {
		wait.wait_until_element_is_visible("delete_profile_button");
		element.click("delete_profile_button");
	}

	@MethodsData(method_id = "button_1")
	public void verify_caregiver_employer_is_present_on_page() {
		wait.wait_for_second(10);
		wait.wait_until_element_is_visible("caregiver_employer");
		verify.element_is_present("caregiver_employer");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_caregiver_employer_button_popup() {
		wait.wait_for_second(2);
		element.click("caregiver_employer");
	}

	@MethodsData(method_id = "button_1")
	public void verify_please_enter_code_alert_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("please_enter_code_alert");
	}

	@MethodsData(method_id = "button_1")
	public void verify_verification_code_not_match_alert_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("verification_code_not_match_alert");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_ok_button_verification_code_not_match_alert() {
		wait.wait_for_second(2);
		element.click("ok_button_verification_code_not_match_alert");
	}

	@MethodsData(method_id = "button_1")
	public void verify_after_profile_user_name_text_update_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("after_profile_user_name_text_update");
	}

	@MethodsData(method_id = "button_1")
	public void verify_email_id_profile_page_is_present_on_page() {
		wait.wait_until_element_is_visible("email_id_profile_page");
		verify.element_is_present("email_id_profile_page");
	}

	@MethodsData(method_id = "button_3")
	public void clear_email_id_profile_page() {
		wait.wait_for_second(1);
		element.clear_text_field("email_id_profile_page");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_email_id_profile_page() {
		wait.wait_for_second(1);
		element.click("email_id_profile_page");
	}
	@MethodsData(method_id = "button_3")
	public void clear_and_enter_email_id_profile_page(String text) {
		wait.wait_for_second(1);
	//	element.click("email_id_profile_page");
		element.clear_and_enter_in_text_field("email_id_profile_page", text);
	}



	@MethodsData(method_id = "button_3")
	public void enter_text_in_email_id_profile_page(String text) {
		wait.wait_for_second(1);
		element.clear_text_field("email_id_profile_page");
		element.enter_text("email_id_profile_page", text);
	}


}