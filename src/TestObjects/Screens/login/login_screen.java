package TestObjects.Screens.login;

import Framework.core.generators.methodsgenerator.methods.MethodsData;
import Framework.performaction.autoweb.Element;
import Framework.performaction.autoweb.Verify;
import Framework.performaction.autoweb.Wait;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;

public class login_screen {

	WebDriver driver = null;
	Element element = null;
	Verify verify = null;
	Wait wait = null;

	public login_screen(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
		wait = new Wait(driver);
	}

	@MethodsData(method_id = "button_1")
	public void verify_okey_button_popup_is_present_on_page() {
		wait.wait_for_second(5);
		try {
			wait.wait_until_element_is_visible("okey_button_popup");
			verify.element_is_present("okey_button_popup");
		} catch (Exception e) {

		}
	}

	@MethodsData(method_id = "button_2")
	public void verify_okey_button_popup_is_clickable() {
		verify.element_is_enable("okey_button_popup");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_okey_button_popup() {
		wait.wait_for_second(10);
		element.click("okey_button_popup");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_okey_button_popup_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("okey_button_popup", button_text);
	}

	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_password(String text_to_enter) {
		wait.wait_for_second(1);
		element.click("password");
		wait.wait_for_second(1);
		element.enter_text("password", text_to_enter);
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_2")
	public void clear_text_from_password() {
		element.clear_text_field("password");
	}

	@MethodsData(method_id = "text_box_3")
	public void clear_text_and_enter_text_in_password(String text_to_enter) {
		element.clear_and_enter_in_text_field("password", text_to_enter);
	}

	@MethodsData(method_id = "text_box_4")
	public void verify_password_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("password");
	}

	@MethodsData(method_id = "button_1")
	public void verify_login_button_is_present_on_page() {
		verify.element_is_present("login_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_login_button_is_clickable() {
		verify.element_is_enable("login_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_login_button_without_ok_button() {
		wait.wait_for_second(1);
		element.click("login_button");

	}

//	@MethodsData(method_id = "button_3")
//	public void click_on_login_button() {
//		wait.wait_for_second(1);
//		element.click("login_button");
//
////		wait.wait_for_second(5);
////		click_on_okey_button_popup_Error_Invalid();
//	}

	@MethodsData(method_id = "button_4")
	public void Verify_login_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("login_button", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void verify_forgot_password_button_is_present_on_page() {
		wait.wait_until_element_is_visible("forgot_password_button");
		verify.element_is_present("forgot_password_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_forgot_password_button_is_clickable() {
		verify.element_is_enable("forgot_password_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_forgot_password_button() {
		element.click("forgot_password_button");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_forgot_password_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("forgot_password_button", button_text);
	}

	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_email(String text_to_enter) {

		element.click("email");
		wait.wait_for_second(5);
		element.enter_text("email", text_to_enter);
	}

	@MethodsData(method_id = "text_box_2")
	public void clear_text_from_email() {
		element.clear_text_field("email");
	}

	@MethodsData(method_id = "text_box_3")
	public void clear_text_and_enter_text_in_email(String text_to_enter) {
		element.clear_and_enter_in_text_field("email", text_to_enter);
	}

	@MethodsData(method_id = "text_box_4")
	public void verify_email_is_present_on_page() {
		wait.wait_for_second(8);
		verify.element_is_present("email");
	}

	@MethodsData(method_id = "button_1")
	public void verify_sign_up_button_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("sign_up_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_sign_up_button_is_clickable() {
		wait.wait_for_second(5);
		verify.element_is_present("sign_up_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_sign_up_button() {
		wait.wait_for_second(5);
		element.click("sign_up_button");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_sign_up_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("sign_up_button", button_text);
	}


	@MethodsData(method_id = "button_4")
	public void Verify_invalid_login_message_text_is_equal_to(String button_text) {
		verify.element_attribute_is_equal_to("invalid_login_message", "content-desc", button_text);
	}


	@MethodsData(method_id = "button_4")
	public void Verify_email_error_message_present_on_page() {

		wait.wait_until_element_is_visible("email_error_message");
		wait.wait_for_second(5);
		verify.element_is_present("email_error_message");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_password_error_message_text_is_equal_to(String button_text) {
		wait.wait_for_second(10);
		verify.element_text_is_equal_to("password_error_message", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void Verify_password_error_message_is_present_on_page() {
		//wait.wait_for_second(10);
		verify.element_is_present("password_error_message");
	}

	@MethodsData(method_id = "button_1")
	public void Verify_user_not_found_message_is_present_on_page() {
		wait.wait_until_element_is_visible("user_not_found_message");
		verify.element_is_present("user_not_found_message");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_user_not_found_message_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("user_not_found_message", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void verify_need_help_button_is_present_on_page() {
		verify.element_is_present("need_help_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_need_help_button_is_clickable() {
		verify.element_is_enable("need_help_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_need_help_button() {
		wait.wait_for_second(10);
		element.click("need_help_button");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_need_help_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("need_help_button", button_text);
	}

	@MethodsData(method_id = "text_box_4")
	public void verify_help_for_manager_text_is_present_on_page() {
		wait.wait_for_second(10);
		verify.element_is_present("help_for_manager_text");
	}

	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_user_email_text_box(String text_to_enter) {
		element.click("user_email_text_box");
		wait.wait_for_second(2);
		element.clear_text_field("user_email_text_box");
		element.enter_text("user_email_text_box", text_to_enter);
	}

	@MethodsData(method_id = "text_box_1")
	public void clear_user_email_text_box() {
		element.click("user_email_text_box");
		wait.wait_for_second(2);
		element.clear_text_field("user_email_text_box");
	}

	@MethodsData(method_id = "text_box_2")
	public void clear_text_from_user_email_text_box() {
		element.clear_text_field("user_email_text_box");
	}

	@MethodsData(method_id = "text_box_3")
	public void clear_text_and_enter_text_in_user_email_text_box(String text_to_enter) {
		element.clear_and_enter_in_text_field("user_email_text_box", text_to_enter);
	}

	@MethodsData(method_id = "text_box_4")
	public void verify_user_email_text_box_is_present_on_page() {
		wait.wait_for_second(8);
		verify.element_is_present("user_email_text_box");
	}

	@MethodsData(method_id = "button_1")
	public void verify_send_reset_password_button_is_present_on_page() {
		wait.wait_for_second(8);
		verify.element_is_present("send_reset_password_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_send_reset_password_button_is_clickable() {
		verify.element_is_enable("send_reset_password_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_send_reset_password_button() {
		wait.wait_for_second(2);
		try {
			element.click("send_reset_password_button");
		} catch (Exception e) {
			// Handle the exception here
		}
	}

	@MethodsData(method_id = "button_4")
	public void Verify_send_reset_password_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("send_reset_password_button", button_text);
	}

	@MethodsData(method_id = "button_4")
	public void Verify_email_send_message_text_is_equal_to(String button_text) {
		wait.wait_for_second(10);
		verify.element_attribute_is_equal_to("email_send_message", "content-desc", button_text);
	}


	@MethodsData(method_id = "button_3")
	public void click_on_okey_button_popup_Error_Invalid() {
		wait.wait_for_second(4);
		element.click("okay_PopUp_Invalid_Error_Msg");
	}

	public void Verify_invalid_login_message_text_is_present_on_page() {
		wait.wait_for_second(10);
		verify.element_is_present("invalid_login_message");
	}

	@MethodsData(method_id = "button_3")
	public void enter_email_address_or_phone_number(String text_to_enter) {
		wait.wait_for_second(4);
		try {
			wait.wait_until_element_is_visible("enter_Your_Phone_number_Text_Box");
			wait.wait_until_element_is_clickable("enter_Your_Phone_number_Text_Box");
			element.click("enter_Your_Phone_number_Text_Box");
			wait.wait_for_second(3);
			element.clear_and_enter_in_text_field("enter_Your_Phone_number_Text_Box", text_to_enter);
		} catch (Exception e) {
		}
	}

	@MethodsData(method_id = "button_3")
	public void verify_enter_Your_Phone_number_is_present() {
		wait.wait_for_second(3);
		wait.wait_until_element_is_visible("enter_Your_Phone_number");
		verify.element_is_present("enter_Your_Phone_number");
	}

	@MethodsData(method_id = "button_3")
	public void verify_continue_Button_is_present() {
		wait.wait_until_element_is_visible("continue_Button");
		verify.element_is_enable("continue_Button");
		verify.element_is_present("continue_Button");
	}

	@MethodsData(method_id = "button_3")
	public void click_On_continue_Button() {
		wait.wait_until_element_is_visible("continue_Button");
		element.click("continue_Button");
		try {
			wait.wait_for_second(5);
			element.click("continue_Button");
		} catch (Exception e) {

		}
	}

	@MethodsData(method_id = "button_3")
	public void verify_enter_Your_Password_is_present() {
		wait.wait_until_element_is_visible("enter_Your_Password");
		verify.element_is_present("enter_Your_Password");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_enter_Your_Password_text_field() {
		wait.wait_until_element_is_visible("enter_Your_Password");
		verify.element_is_present("enter_Your_Password");
	}

	@MethodsData(method_id = "button_3")
	public void enter_Your_Password_Text_Box(String text_to_enter) {
		wait.wait_until_element_is_visible("enter_Your_Password_Text_Box");
		element.click("enter_Your_Password_Text_Box");
		element.clear_and_enter_in_text_field("enter_Your_Password_Text_Box", text_to_enter);
	}

	@MethodsData(method_id = "button_3")
	public void verify_login_button_is_present() {
		wait.wait_until_element_is_visible("login_button");
		verify.element_is_present("login_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_login_button() {
		element.click("login_button");
	}

	public void performLoginOnMobileApp(String emailAddress, String password) {
		int maxRetries = 3;
		int retries = 0;
		boolean loginSuccessful = false;

		while (retries < maxRetries && !loginSuccessful) {
			try {
				verify_enter_Your_Phone_number_is_present();
				enter_email_address_or_phone_number(emailAddress);
				((AndroidDriver)driver).hideKeyboard();
				verify_continue_Button_is_present();
				click_On_continue_Button();

				try {
					verify_enter_Your_Password_is_present();
					enter_Your_Password_Text_Box(password);
					((AndroidDriver) driver).hideKeyboard();
					verify_login_button_is_present();
					click_on_login_button();
					loginSuccessful = true;
				}
				catch (Exception e){

				}
			} catch (Exception e) {
				retries++;
				if (retries < maxRetries) {
				} else {

				}
			}
		}
	}

	@MethodsData(method_id = "button_3")
	public void verify_splash_screen_logo_is_present() {
		wait.wait_until_element_is_visible("splash_screen_logo");
		verify.element_is_present("splash_screen_logo");
	}

	@MethodsData(method_id = "button_3")
	public void verify_need_help_button_is_present() {
		wait.wait_until_element_is_visible("need_help_button");
		verify.element_is_present("need_help_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_On_need_help_button() {
		wait.wait_until_element_is_visible("need_help_button");
		element.click("need_help_button");
	}

	@MethodsData(method_id = "button_3")
	public void verify_version_text_is_present() {
		wait.wait_until_element_is_visible("version_text");
		verify.element_is_present("version_text");
	}

	@MethodsData(method_id = "button_3")
	public void verify_logo_image_is_present() {
		wait.wait_until_element_is_visible("logo_image");
		verify.element_is_present("logo_image");
	}

	@MethodsData(method_id = "button_3")
	public void verify_incorrect_alert_message_is_present() {
		wait.wait_until_element_is_visible("incorrect_alert_message");
		wait.wait_for_second(2);
		verify.element_is_present("incorrect_alert_message");
	}

	@MethodsData(method_id = "button_3")
	public void verify_why_cannot_i_login_button_is_present() {
		wait.wait_until_element_is_visible("why_cannot_i_login_button");
		verify.element_is_present("why_cannot_i_login_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_On_why_cannot_i_login_button() {
		wait.wait_until_element_is_visible("why_cannot_i_login_button");
		element.click("why_cannot_i_login_button");
	}

	@MethodsData(method_id = "button_3")
	public void verify_why_cannot_i_login_popup_header_is_present() {
		wait.wait_until_element_is_visible("why_cannot_i_login_popup_header");
		verify.element_is_present("why_cannot_i_login_popup_header");
	}

	@MethodsData(method_id = "button_3")
	public void verify_password_eye_button_is_present() {
		wait.wait_until_element_is_visible("password_eye_button");
		verify.element_is_present("password_eye_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_On_password_eye_button() {
		wait.wait_until_element_is_visible("password_eye_button");
		element.click("password_eye_button");
	}

	@MethodsData(method_id = "button_3")
	public String get_Password_Text_from_Text_Box() {
		wait.wait_until_element_is_visible("enter_Your_Password_Text_Box");
		String getPasswordText = element.get_attribute_value("enter_Your_Password_Text_Box","text");
		return getPasswordText;
	}

	@MethodsData(method_id = "button_3")
	public void verify_please_enter_your_email_alert_is_present() {
		wait.wait_until_element_is_visible("please_enter_your_email_alert");
		verify.element_is_present("please_enter_your_email_alert");
	}

	@MethodsData(method_id = "button_3")
	public void click_On_please_enter_your_email_alert_button() {
		wait.wait_until_element_is_visible("please_enter_your_email_alert");
		element.click("please_enter_your_email_alert");
	}

	@MethodsData(method_id = "button_3")
	public void verify_send_reset_password_email_button_is_present() {
		wait.wait_until_element_is_visible("send_reset_password_email_button");
		verify.element_is_present("send_reset_password_email_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_On_send_reset_password_email_button() {
		wait.wait_until_element_is_visible("send_reset_password_email_button");
		element.click("send_reset_password_email_button");
	}

	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_forgot_password_email_text_box(String text_to_enter) {
		wait.wait_for_second(1);
		element.click("forgot_password_email_text_box");
		wait.wait_for_second(1);
		element.enter_text("forgot_password_email_text_box", text_to_enter);
		wait.wait_for_second(1);
	}
	@MethodsData(method_id = "button_1")
	public void Verify_incorrect_username_password_is_present_on_page() {
		wait.wait_until_element_is_visible("incorrect_username_password");
		verify.element_is_present("incorrect_username_password");
	}

	@MethodsData(method_id = "button_1")
	public void Verify_user_email_not_found_alert_is_present_on_page() {
		wait.wait_until_element_is_visible("user_email_not_found_alert");
		verify.element_is_present("user_email_not_found_alert");
	}

	@MethodsData(method_id = "button_1")
	public void Verify_ok_button_forgot_Password_invalid_user_is_present_on_page() {
		wait.wait_until_element_is_visible("ok_button_forgot_Password_invalid_user");
		verify.element_is_present("ok_button_forgot_Password_invalid_user");
	}

	@MethodsData(method_id = "button_3")
	public void click_On_ok_button_forgot_Password_invalid_user_button() {
		wait.wait_until_element_is_visible("ok_button_forgot_Password_invalid_user");
		element.click("ok_button_forgot_Password_invalid_user");
	}


}