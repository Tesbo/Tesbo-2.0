package Screens.language_Screen;

import io.unity.core.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import io.unity.performaction.autoweb.testng_logs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class language_page {

	WebDriver driver = null;
	Element element = null;
	Verify verify = null;
	Wait wait = null;
	Actions actions = null;
	testng_logs logs = null;

	public language_page(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
		wait = new Wait(driver);
		actions = new Actions(driver);
		logs = new testng_logs();
	}
	@MethodsData(method_id = "button_1")
	public void verify_spanish_language_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("spanish_language");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_spanish_language() {
		element.click("spanish_language");
	}

	@MethodsData(method_id = "button_1")
	public void verify_language_Option_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("language_Option");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_language_Option() {
		element.click("language_Option");
	}

	@MethodsData(method_id = "button_1")
	public void verify_language_preference_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("language_preference");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_language_preference() {
		element.click("language_preference");
	}

	@MethodsData(method_id = "button_1")
	public void verify_save_button_is_present_on_page() {
		wait.wait_until_element_is_visible("save_button");
		verify.element_is_present("save_button");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_save_button() {
		element.click("save_button");
	}

	@MethodsData(method_id = "button_1")
	public void verify_language_preference_in_Spanish_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("language_preference_in_Spanish");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_language_preference_in_Spanish() {
		element.click("language_preference_in_Spanish");
	}

	@MethodsData(method_id = "button_1")
	public void verify_save_Button_Spanish_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("save_Button_Spanish");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_save_Button_Spanish() {
		element.click("save_Button_Spanish");
	}

	@MethodsData(method_id = "button_1")
	public void verify_language_Alert_Msg_Spanish_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("language_Alert_Msg_Spanish");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_language_Alert_Msg_Spanish() {
		element.click("language_Alert_Msg_Spanish");
	}

	@MethodsData(method_id = "button_1")
	public void verify_ok_button_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("ok_button");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_ok_button() {
		element.click("ok_button");
	}


	@MethodsData(method_id = "button_1")
	public void verify_language_Option_In_Spanish_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("language_Option_In_Spanish");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_language_Option_In_Spanish() {
		element.click("language_Option_In_Spanish");
	}


	@MethodsData(method_id = "button_1")
	public void verify_english_Option_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("english_Option");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_english_Option() {
		element.click("english_Option");
	}


	@MethodsData(method_id = "button_1")
	public void verify_language_Alert_Msg_English_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("language_Alert_Msg_English");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_language_Alert_Msg_English() {
		element.click("language_Alert_Msg_English");
	}

	@MethodsData(method_id = "button_1")
	public void verify_language_updated_successfully_alert_is_present_on_page() {
		wait.wait_for_second(5);
		wait.wait_until_element_is_visible("language_updated_successfully_alert");
		verify.element_is_present("language_updated_successfully_alert");
	}

	@MethodsData(method_id = "button_1")
	public void verify_ok_button_language_updated_successfully_alert_is_present_on_page() {
		wait.wait_for_second(5);
		wait.wait_until_element_is_visible("language_updated_successfully_alert");
		verify.element_is_present("language_updated_successfully_alert");
	}

	@MethodsData(method_id = "button_1")
	public void click_ok_button_language_updated_successfully_alert_is_present_on_page() {
		element.click("language_updated_successfully_alert");
	}

	@MethodsData(method_id = "button_1")
	public void verify_your_preferred_language_text_is_present_on_page() {
		wait.wait_until_element_is_visible("your_preferred_language_text");
		verify.element_is_present("your_preferred_language_text");
	}
}