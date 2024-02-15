package Screens.change_environment;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import io.unity.core.generators.methodsgenerator.methods.MethodsData;

import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.point;

public class change_environment {

	WebDriver driver = null;
	Element element = null;
	Verify verify = null;
	Wait wait = null;
	Actions action = null;

	public change_environment(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
		wait = new Wait(driver);
		action = new Actions(driver);

	}

	@MethodsData(method_id = "button_1")
	public void verify_version_text_is_present_on_page() {
		wait.wait_for_second(10);
		verify.element_is_present("version_text");
	}

	@MethodsData(method_id = "button_2")
	public void verify_version_text_is_clickable() {
		verify.element_is_enable("version_text");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_version_text() {
		wait.wait_for_second(5);
		element.click("version_text");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_version_text_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("version_text", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void verify_video_button_is_present_on_page() {
		verify.element_is_present("video_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_video_button_is_clickable() {
		verify.element_is_enable("video_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_video_button() {
		wait.wait_for_second(15);
		element.click("video_button");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_video_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("video_button", button_text);
	}

	@MethodsData(method_id = "text_box_3")
	public void clear_text_and_enter_text_in_prod_password(String text_to_enter) {
		element.clear_and_enter_in_text_field("prod_password", text_to_enter);
	}

	@MethodsData(method_id = "text_box_4")
	public void verify_prod_password_is_present_on_page() {
		verify.element_is_present("prod_password");
	}

	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_prod_password(String text_to_enter) {
		wait.wait_for_second(15);
		element.click("prod_password");
		element.enter_text("prod_password", text_to_enter);
	}

	@MethodsData(method_id = "text_box_2")
	public void clear_text_from_prod_password() {
		element.clear_text_field("prod_password");
	}

	@MethodsData(method_id = "button_1")
	public void verify_test_env_button_is_present_on_page() {
		verify.element_is_present("test_env_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_test_env_button_is_clickable() {
		verify.element_is_enable("test_env_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_test_env_button() {
		wait.wait_for_second(15);
		element.click("test_env_button");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_test_env_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("test_env_button", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void verify_prod_login_button_is_present_on_page() {
		verify.element_is_present("prod_login_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_prod_login_button_is_clickable() {
		verify.element_is_enable("prod_login_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_prod_login_button() {
		wait.wait_for_second(15);
		element.click("prod_login_button");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_prod_login_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("prod_login_button", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void verify_help_icon_is_present_on_page() {
		verify.element_is_present("help_icon");
	}

	@MethodsData(method_id = "button_2")
	public void verify_help_icon_is_clickable() {
		verify.element_is_enable("help_icon");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_help_icon() {
		wait.wait_for_second(15);
		element.click("help_icon");
		wait.wait_for_second(10);
	}

	@MethodsData(method_id = "button_4")
	public void Verify_help_icon_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("help_icon", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void verify_Save_button_is_present_on_page() {
		verify.element_is_present("Save_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_Save_button_is_clickable() {
		verify.element_is_enable("Save_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_Save_button() {
		wait.wait_for_second(15);
		element.click("Save_button");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_Save_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("Save_button", button_text);
	}

	@MethodsData(method_id = "text_box_3")
	public void clear_text_and_enter_text_in_admin_code_text_box(String text_to_enter) {
		element.clear_and_enter_in_text_field("admin_code_text_box", text_to_enter);
	}

	@MethodsData(method_id = "text_box_4")
	public void verify_admin_code_text_box_is_present_on_page() {
		verify.element_is_present("admin_code_text_box");
	}
	@MethodsData(method_id = "text_box_4")
	public void click_on_admin_code_text_box() {
		wait.wait_for_second(10);
		element.click("admin_code_text_box");
	}

	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_admin_code_text_box(String text_to_enter) {
		wait.wait_for_second(10);
		element.enter_text("admin_code_text_box", text_to_enter);
	}

	@MethodsData(method_id = "text_box_2")
	public void clear_text_from_admin_code_text_box() {
		element.clear_text_field("admin_code_text_box");
	}

	@MethodsData(method_id = "button_1")
	public void verify_admin_login_button_is_present_on_page() {
		verify.element_is_present("admin_login_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_admin_login_button_is_clickable() {
		verify.element_is_enable("admin_login_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_admin_login_button() {
		wait.wait_for_second(15);
		element.click("admin_login_button");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_admin_login_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("admin_login_button", button_text);
	}

	@MethodsData(method_id = "button_1")
	public void verify_app_url_button_is_present_on_page() {
		verify.element_is_present("app_url_button");
	}

	@MethodsData(method_id = "button_2")
	public void verify_app_url_button_is_clickable() {
		verify.element_is_enable("app_url_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_app_url_button() {
		wait.wait_for_second(15);
		element.click("app_url_button");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_app_url_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("app_url_button", button_text);
	}

	@MethodsData(method_id = "text_box_3")
	public void clear_text_and_enter_text_in_prod_email(String text_to_enter) {
		element.clear_and_enter_in_text_field("prod_email", text_to_enter);
	}

	@MethodsData(method_id = "text_box_4")
	public void verify_prod_email_is_present_on_page() {
		wait.wait_for_second(15);
		verify.element_is_present("prod_email");
	}

	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_prod_email(String text_to_enter) {
		wait.wait_for_second(5);
		element.click("prod_email");
		element.enter_text("prod_email", text_to_enter);
	}

	@MethodsData(method_id = "text_box_2")
	public void clear_text_from_prod_email() {
		element.clear_text_field("prod_email");
	}

	public void change_prod_to_test_environment()
	{
		verify_prod_email_is_present_on_page();
		enter_text_at_prod_email("viral@nevvon.com");
		verify_prod_password_is_present_on_page();
		enter_text_at_prod_password("Viral@1010");
		click_on_prod_login_button();
		click_on_video_button();
		click_on_help_icon();

		AndroidTouchAction touch = new AndroidTouchAction((PerformsTouchActions) driver);

		verify_version_text_is_present_on_page();
		LongPressOptions long_press = new LongPressOptions();
		long_press.withDuration(Duration.ofSeconds(5)).withElement(ElementOption.element(element.find("version_text")));
		touch.longPress(long_press).release().perform();

		click_on_admin_code_text_box();
		enter_text_at_admin_code_text_box("iWillNotHack");
		click_on_admin_login_button();

		click_on_app_url_button();
		click_on_test_env_button();
		click_on_Save_button();

	}
}