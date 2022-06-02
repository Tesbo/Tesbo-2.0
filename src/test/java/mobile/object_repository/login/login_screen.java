package mobile.object_repository.login;

import io.unity.framework.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class login_screen {

	WebDriver driver = null;
	Element element = null;
	Verify verify = null;

	public login_screen(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
	}

	@MethodsData(method_id = "button_1")
	public void verify_okey_button_popup_is_present_on_page() {
		verify.element_is_present("okey_button_popup");
	}

	@MethodsData(method_id = "button_2")
	public void verify_okey_button_popup_is_clickable() {
		verify.element_is_enable("okey_button_popup");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_okey_button_popup() {
		element.click("okey_button_popup");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_okey_button_popup_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("okey_button_popup", button_text);
	}

	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_password(String text_to_enter) {
		element.click("password");
		element.enter_text("password", text_to_enter);
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
	public void click_on_login_button() {element.click("login_button");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_login_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("login_button", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void verify_forgot_password_button_is_present_on_page() {
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
		verify.element_is_present("email");
	}

	@MethodsData(method_id = "button_1")
	public void verify_sign_up_button_is_present_on_page() {
		verify.element_is_present("sign_up_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_sign_up_button_is_clickable() {
		verify.element_is_enable("sign_up_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_sign_up_button() {
		element.click("sign_up_button");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_sign_up_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("sign_up_button", button_text);
	}
}