package Screens.sign_up;

import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;
import io.unity.core.generators.methodsgenerator.methods.MethodsData;

public class sign_up_page {

	WebDriver driver = null;
	Element element = null;
	Verify verify = null;
	Wait wait = null;

	public sign_up_page(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
		wait = new Wait(driver);
	}

	@MethodsData(method_id = "button_4")
	public void Verify_sign_up_blue_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("sign_up_blue_button", button_text);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_sign_up_blue_button() {
		wait.wait_for_second(5);
		element.click("sign_up_blue_button");
	}

	@MethodsData(method_id = "button_1")
	public void verify_sign_up_blue_button_is_present_on_page() {
		verify.element_is_present("sign_up_blue_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_sign_up_blue_button_is_clickable() {
		verify.element_is_enable("sign_up_blue_button");
	}

	@MethodsData(method_id = "text_1")
	public void verify_error_message_sign_up_confirm_email_box_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("error_message_sign_up_confirm_email_box");
	}

	@MethodsData(method_id = "text_1")
	public void verify_error_message_sign_up_email_box_is_present_on_page() {
		wait.wait_for_second(10);
		verify.element_is_present("error_message_sign_up_email_box");
	}

	@MethodsData(method_id = "text_1")
	public void verify_error_message_sign_up_confirm_password_is_present_on_page() {
		wait.wait_for_second(10);
		verify.element_is_present("error_message_sign_up_confirm_password");
	}

	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_sign_up_confirm_email_box(String text_to_enter) {
		wait.wait_for_second(2);
		element.click("sign_up_confirm_email_box");
		wait.wait_for_second(2);
		element.enter_text("sign_up_confirm_email_box", text_to_enter);
	}

	@MethodsData(method_id = "text_box_2")
	public void clear_text_from_sign_up_confirm_email_box() {
		element.clear_text_field("sign_up_confirm_email_box");
	}

	@MethodsData(method_id = "text_box_3")
	public void clear_text_and_enter_text_in_sign_up_confirm_email_box(String text_to_enter) {
		element.clear_and_enter_in_text_field("sign_up_confirm_email_box", text_to_enter);
	}

	@MethodsData(method_id = "text_box_4")
	public void verify_sign_up_confirm_email_box_is_present_on_page() {
		verify.element_is_present("sign_up_confirm_email_box");
	}

	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_sign_up_email_box(String text_to_enter) {
		wait.wait_for_second(5);
		element.click("sign_up_email_box");
		wait.wait_for_second(1);
		element.enter_text("sign_up_email_box", text_to_enter);
	}

	@MethodsData(method_id = "text_box_2")
	public void clear_text_from_sign_up_email_box() {
		element.clear_text_field("sign_up_email_box");
	}

	@MethodsData(method_id = "text_box_3")
	public void clear_text_and_enter_text_in_sign_up_email_box(String text_to_enter) {
		element.clear_and_enter_in_text_field("sign_up_email_box", text_to_enter);
	}

	@MethodsData(method_id = "text_box_4")
	public void verify_sign_up_email_box_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("sign_up_email_box");
	}

	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_sign_up_confirm_password(String text_to_enter) {
		wait.wait_for_second(2);
		element.click("sign_up_confirm_password");
		wait.wait_for_second(1);
		element.enter_text("sign_up_confirm_password", text_to_enter);
	}

	@MethodsData(method_id = "text_box_2")
	public void clear_text_from_sign_up_confirm_password() {
		element.clear_text_field("sign_up_confirm_password");
	}

	@MethodsData(method_id = "text_box_3")
	public void clear_text_and_enter_text_in_sign_up_confirm_password(String text_to_enter) {
		element.clear_and_enter_in_text_field("sign_up_confirm_password", text_to_enter);
	}

	@MethodsData(method_id = "text_box_4")
	public void verify_sign_up_confirm_password_is_present_on_page() {
		verify.element_is_present("sign_up_confirm_password");
	}

	@MethodsData(method_id = "text_1")
	public void verify_error_message_sign_up_password_box_is_present_on_page() {
		wait.wait_for_second(10);
		verify.element_is_present("error_message_sign_up_password_box");
	}

	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_sign_up_password_box(String text_to_enter) {
		wait.wait_for_second(2);
		element.click("sign_up_password_box");
		wait.wait_for_second(1);
		element.enter_text("sign_up_password_box", text_to_enter);
	}

	@MethodsData(method_id = "text_box_2")
	public void clear_text_from_sign_up_password_box() {
		element.clear_text_field("sign_up_password_box");
	}

	@MethodsData(method_id = "text_box_3")
	public void clear_text_and_enter_text_in_sign_up_password_box(String text_to_enter) {
		element.clear_and_enter_in_text_field("sign_up_password_box", text_to_enter);
	}

	@MethodsData(method_id = "text_box_4")
	public void verify_sign_up_password_box_is_present_on_page() {
		verify.element_is_present("sign_up_password_box");
	}

	@MethodsData(method_id = "text_1")
	public void verify_error_message_for_email_password_match_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("error_message_for_email_password_match");
	}

	@MethodsData(method_id = "text_1")
	public void verify_user_already_exit_message_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("user_already_exit_message");
	}

	@MethodsData(method_id = "text_1")
	public void verify_terms_and_conditions_link_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("terms_and_conditions_link");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_terms_and_conditions_link() {
		element.click("terms_and_conditions_link");
	}

	@MethodsData(method_id = "text_1")
	public void verify_terms_and_conditions_header_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("terms_and_conditions_header");
	}

	@MethodsData(method_id = "text_1")
	public void verify_agree_button_is_present_on_page() {
		wait.wait_until_element_is_visible("agree_button");
		verify.element_is_present("agree_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_agree_button() {
		element.click("agree_button");
	}

	@MethodsData(method_id = "text_1")
	public void verify_need_Help_SignUp_Screen_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("need_Help_SignUp_Screen");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_need_Help_SignUp_Screen() {
		element.click("need_Help_SignUp_Screen");
	}

	@MethodsData(method_id = "text_1")
	public void verify_phone_number_text_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("phone_number_text");
	}

	@MethodsData(method_id = "text_1")
	public void verify_verify_your_phone_number_signup_is_present_on_page() {
		try {
			wait.wait_until_element_is_visible("verify_your_phone_number_signup");
			verify.element_is_present("verify_your_phone_number_signup");
		} catch (Exception e) {
		}
	}

	@MethodsData(method_id = "button_3")
	public void click_on_verify_your_phone_number_signup() {
		element.click("verify_your_phone_number_signup");
	}

	@MethodsData(method_id = "text_1")
	public void verify_verify_your_phone_number_text_msg_one_signup_is_present_on_page() {
		wait.wait_until_element_is_visible("verify_your_phone_number_text_msg_one_signup");
		verify.element_is_present("verify_your_phone_number_text_msg_one_signup");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_verify_your_phone_number_text_msg_one_signup() {
		element.click("verify_your_phone_number_text_msg_one_signup");
	}

	@MethodsData(method_id = "text_1")
	public void verify_verify_your_phone_number_text_msg_two_signup_is_present_on_page() {
		wait.wait_until_element_is_visible("verify_your_phone_number_text_msg_two_signup");
		verify.element_is_present("verify_your_phone_number_text_msg_two_signup");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_verify_your_phone_number_text_msg_two_signup() {
		element.click("verify_your_phone_number_text_msg_two_signup");
	}

	@MethodsData(method_id = "text_1")
	public void verify_send_me_an_sms_option_is_present_on_page() {
		wait.wait_until_element_is_visible("send_me_an_sms_option");
		verify.element_is_present("send_me_an_sms_option");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_send_me_an_sms_option() {
		element.click("send_me_an_sms_option");
	}

	@MethodsData(method_id = "text_1")
	public void verify_call_me_option_is_present_on_page() {
		wait.wait_until_element_is_visible("call_me_option");
		verify.element_is_present("call_me_option");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_call_me_option() {
		element.click("call_me_option");
	}

	@MethodsData(method_id = "text_1")
	public void verify_continue_button_signup_is_present_on_page() {
		wait.wait_until_element_is_visible("continue_button_signup");
		verify.element_is_present("continue_button_signup");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_continue_button_signup() {
		element.click("continue_button_signup");
	}

	@MethodsData(method_id = "text_1")
	public void verify_need_help_link_signup_screen_is_present_on_page() {
		wait.wait_until_element_is_visible("need_help_link_signup_screen");
		verify.element_is_present("need_help_link_signup_screen");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_need_help_link_signup_screen() {
		element.click("need_help_link_signup_screen");
	}

	@MethodsData(method_id = "text_1")
	public void verify_we_sent_you_an_SMS_signup_text_is_present_on_page() {
		wait.wait_until_element_is_visible("need_help_link_signup_screen");
		verify.element_is_present("need_help_link_signup_screen");
	}

	@MethodsData(method_id = "text_1")
	public void verify_send_an_sms_screen_text_msg_is_present_on_page() {
		wait.wait_until_element_is_visible("send_an_sms_screen_text_msg");
		verify.element_is_present("send_an_sms_screen_text_msg");
	}

	@MethodsData(method_id = "text_1")
	public void verify_enter_code_text_box_is_present_on_page() {
		wait.wait_until_element_is_visible("enter_code_text_box");
		verify.element_is_present("enter_code_text_box");
	}

	@MethodsData(method_id = "button_3")
	public void verify_enter_code_text_box_is_present(String verificationCode) {
		element.click("enter_code_text_box");
		element.clear_and_enter_in_text_field("enter_code_text_box", verificationCode);
	}

	@MethodsData(method_id = "text_1")
	public void verify_verify_button_signup_is_present_on_page() {
		wait.wait_until_element_is_visible("verify_button_signup");
		verify.element_is_present("verify_button_signup");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_verify_button_signup() {
		element.click("verify_button_signup");
	}

}