package object_repository.Web.login;

import io.unity.framework.readers.locator_reader;
import io.unity.autoweb.Element;
import io.unity.autoweb.Verify;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class login_page_step {

	WebDriver driver = null;
	Element element = null;
	Verify verify = null;
	locator_reader reader = new locator_reader();

	public login_page_step(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
	}

	public void enter_text_at_enter_your_password_password(String text_to_enter) {
		element.enter_text("enter_your_password_password", text_to_enter);
	}

	public void clear_text_from_enter_your_password_password() {
		element.clear_text_field("enter_your_password_password");
	}

	public void verify_enter_your_password_password_is_present_on_page() {
		Assert.assertTrue(verify.element_is_present("enter_your_password_password"));
	}

	public void clear_text_and_enter_text_in_enter_your_password_password(String text_to_enter) {
		element.clear_and_enter_in_text_field("enter_your_password_password", text_to_enter);
	}

	public void enter_text_at_enter_your_email_text_box(String text_to_enter) {
		element.enter_text("enter_your_email_text_box", text_to_enter);
	}

	public void clear_text_from_enter_your_email_text_box() {
		element.clear_text_field("enter_your_email_text_box");
	}

	public void verify_enter_your_email_text_box_is_present_on_page() {
		Assert.assertTrue(verify.element_is_present("enter_your_email_text_box"));
	}

	public void clear_text_and_enter_text_in_enter_your_email_text_box(String text_to_enter) {
		element.clear_and_enter_in_text_field("enter_your_email_text_box", text_to_enter);
	}

	public void verify_sign_in_button_is_present_on_page() {
		Assert.assertTrue(verify.element_is_present("sign_in_button"));
	}

	public void click_on_sign_in_button() {
		element.click("sign_in_button");
	}

	public void verify_sign_in_button_is_clickable() {
		Assert.assertTrue(verify.element_is_enable("sign_in_button"));
	}

	public void click_on_sign_in_button(String button_text) {
		verify.element_text_is_equal_to("sign_in_button", button_text);
	}
}