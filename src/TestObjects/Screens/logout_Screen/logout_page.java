package Screens.logout_Screen;

import io.unity.core.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;

public class logout_page {

	WebDriver driver = null;
	Element element = null;
	Verify verify = null;
	Wait wait = null;

	public logout_page(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
		wait = new Wait(driver);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_profile_tab() {
		wait.wait_for_second(1);
		element.click("profile_button");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_profile_tab_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("profile_tab", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void verify_profile_tab_is_present_on_page() {
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
		verify.element_is_present("language_tab");
	}

	@MethodsData(method_id = "button_2")
	public void verify_language_tab_is_clickable() {
		verify.element_is_enable("language_tab");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_logout_button() {
		element.click("logout_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_logout_btn() {
		wait.wait_until_element_is_visible("logout_btn");
		element.click("logout_btn");
	}


	@MethodsData(method_id = "button_4")
	public void Verify_logout_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("logout_button", button_text);
	}
}