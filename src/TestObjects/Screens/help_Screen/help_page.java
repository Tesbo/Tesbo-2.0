package Screens.help_Screen;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import io.unity.core.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import io.unity.performaction.autoweb.testng_logs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class help_page {

	static WebDriver driver = null;
	Element element = null;
	Verify verify = null;
	Wait wait = null;
	Actions actions = null;
	testng_logs logs = null;

	public help_page(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
		wait = new Wait(driver);
		actions = new Actions(driver);
		logs = new testng_logs();
	}

	@MethodsData(method_id = "button_1")
	public void verify_help_for_caregivers_is_present_on_page() {
		wait.wait_until_element_is_visible("help_for_caregivers");
		verify.element_is_present("help_for_caregivers");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_help_for_caregivers() {
		wait.wait_until_element_is_visible("help_for_caregivers");
		element.click("help_for_caregivers");
	}

	@MethodsData(method_id = "button_1")
	public void verify_back_to_home_button_is_present_on_page() {
		wait.wait_until_element_is_visible("back_to_home_button");
		verify.element_is_present("back_to_home_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_back_to_home_button() {
		element.click("back_to_home_button");
	}

	@MethodsData(method_id = "button_1")
	public void verify_back_to_home_is_present_on_page() {
		wait.wait_until_element_is_visible("back_to_home");
		verify.element_is_present("back_to_home");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_back_to_home() {
		element.click("back_to_home");
	}

	@MethodsData(method_id = "button_1")
	public void verify_hamburger_button_is_present_on_page() {
		wait.wait_until_element_is_visible("hamburger_button");
		verify.element_is_present("hamburger_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_to_hamburger_button() {
		element.click("hamburger_button");
	}

	@MethodsData(method_id = "button_1")
	public void verify_contact_us_option_is_present_on_page() {
		wait.wait_until_element_is_visible("contact_us_option");
		verify.element_is_present("contact_us_option");
	}

	@MethodsData(method_id = "button_1")
	public void verify_go_to_customer_portal_option_is_present_on_page() {
		wait.wait_until_element_is_visible("go_to_customer_portal_option");
		verify.element_is_present("go_to_customer_portal_option");
	}


	@MethodsData(method_id = "button_1")
	public void verify_go_to_how_can_we_help_you_text_is_present_on_page() {
		wait.wait_until_element_is_visible("how_can_we_help_you_text");
		verify.element_is_present("how_can_we_help_you_text");
	}


	@MethodsData(method_id = "button_1")
	public void verify_no_result_for_msg_is_present_on_page() {
		wait.wait_until_element_is_visible("no_result_for_msg");
		verify.element_is_present("no_result_for_msg");
	}

	@MethodsData(method_id = "button_1")
	public void verify_no_result_search_text() {
		wait.wait_until_element_is_visible("no_result_search_text");
		verify.element_is_present("no_result_search_text");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_no_result_for_msg() {
		element.click("no_result_for_msg");
	}

	@MethodsData(method_id = "button_1")
	public void verify_search_option_on_top_help_page_is_present_on_page() {
		wait.wait_until_element_is_visible("search_option_on_top_help_page");
		verify.element_is_present("search_option_on_top_help_page");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_to_search_option_on_top_help_page() {
		element.click("search_option_on_top_help_page");
	}

	@MethodsData(method_id = "button_1")
	public void verify_result_for_help_page_is_present_on_page() {
		wait.wait_until_element_is_visible("result_for_help_page");
		verify.element_is_present("result_for_help_page");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_to_result_for_help_page() {
		element.click("result_for_help_page");
	}

	@MethodsData(method_id = "button_1")
	public void verify_search_text_box_help_page_is_present_on_page() {
		wait.wait_for_second(2);
		wait.wait_until_element_is_visible("search_text_box_help_page");
		verify.element_is_present("search_text_box_help_page");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_to_search_text_box_help_page() {
		wait.wait_until_element_is_visible("search_text_box_help_page");
		element.click("search_text_box_help_page");
	}

	@MethodsData(method_id = "button_3")
	public void enter_text_in_search_text_box_help_page(String text) {
		wait.wait_for_second(4);
		element.enter_text("search_text_box_help_page", text);
		wait.wait_for_second(4);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
//		element.enter_text("search_text_box_help_page", String.valueOf(Keys.ENTER));
	}

	@MethodsData(method_id = "button_1")
	public void verify_help_for_caregivers_text_is_present_on_page() {
		wait.wait_until_element_is_visible("help_for_caregivers_text");
		verify.element_is_present("help_for_caregivers_text");
	}

	@MethodsData(method_id = "button_1")
	public void verify_help_for_caregivers_text_is_present_on_help_page() {
		wait.wait_until_element_is_visible("help_for_caregivers_text_on_help_page");
		verify.element_is_present("help_for_caregivers_text_on_help_page");
	}

	@MethodsData(method_id = "button_1")
	public void verify_still_need_help_link_is_present_on_page() {
		wait.wait_until_element_is_visible("still_need_help_link");
		verify.element_is_present("still_need_help_link");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_to_still_need_help_link() {
		element.click("still_need_help_link");
	}

	@MethodsData(method_id = "button_3")
	public void scroll_to_still_need_help_link() {
		Actions actions = new Actions(driver);
		actions.scrollToElement(element.find("still_need_help_link"));
	}

	@MethodsData(method_id = "button_1")
	public void verify_english_text_help_page_is_present_on_page() {
		wait.wait_until_element_is_visible("english_text_help_page");
		verify.element_is_present("english_text_help_page");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_to_english_text_help_page() {
		element.click("english_text_help_page");
	}


	@MethodsData(method_id = "button_1")
	public void verify_drop_down_menu_button_help_page_is_present_on_page() {
		wait.wait_until_element_is_visible("drop_down_menu_button_help_page");
		verify.element_is_present("drop_down_menu_button_help_page");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_to_drop_down_menu_button_help_page() {
		element.click("drop_down_menu_button_help_page");
	}


	@MethodsData(method_id = "button_1")
	public void verify_contact_us_link_help_page_is_present_on_page() {
		wait.wait_until_element_is_visible("contact_us_link_help_page");
		verify.element_is_present("contact_us_link_help_page");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_to_contact_us_link_help_page() {
		element.click("contact_us_link_help_page");
	}


	@MethodsData(method_id = "button_1")
	public void verify_still_need_help_english_link_is_present_on_page() {
		wait.wait_until_element_is_visible("still_need_help_english_link");
		verify.element_is_present("still_need_help_english_link");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_to_still_need_help_english_link() {
		element.click("still_need_help_english_link");
	}

	@MethodsData(method_id = "button_1")
	public void verify_submit_button_of_still_need_help_form_is_present_on_page() {
		wait.wait_until_element_is_visible("submit_button_of_still_need_help_form");
		verify.element_is_present("submit_button_of_still_need_help_form");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_to_submit_button_of_still_need_help_form() {
		element.click("submit_button_of_still_need_help_form");
	}

	@MethodsData(method_id = "button_1")
	public void verify_please_complete_all_required_fields_text_is_present_on_page() {
		wait.wait_until_element_is_visible("please_complete_all_required_fields_text");
		verify.element_is_present("please_complete_all_required_fields_text");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_to_please_complete_all_required_fields_text() {
		element.click("please_complete_all_required_fields_text");
	}

	@MethodsData(method_id = "button_1")
	public void verify_help_for_manager_is_present_on_page() {
		element.perform_scroll_to_element("help_for_manager");
		wait.wait_until_element_is_visible("help_for_manager");
		verify.element_is_present("help_for_manager");
	}

	@MethodsData(method_id = "button_1")
	public void scroll_to_bottom() {
		wait.wait_for_second(3);
		TouchAction<?> action = new TouchAction<>((PerformsTouchActions) driver);
		action.press(PointOption.point(50, 1700)).moveTo(PointOption.point(50, 100)).release().perform();
	}

	@MethodsData(method_id = "button_1")
	public void verify_help_for_manager_text_is_present_on_page(){
		wait.wait_for_second(4);
		wait.wait_until_element_is_visible("help_for_manager_text");
		verify.element_is_present("help_for_manager_text");
	}

	@MethodsData(method_id = "button_1")
	public void verify_contact_us_link_is_present_on_page() {
		wait.wait_until_element_is_visible("contact_us_link");
		verify.element_is_present("contact_us_link");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_contact_us_link_is() {
		wait.wait_until_element_is_visible("contact_us_link");
		element.click("contact_us_link");
	}


}