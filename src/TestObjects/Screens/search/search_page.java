package Screens.search;

import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import io.unity.performaction.autoweb.testng_logs;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import io.unity.core.generators.methodsgenerator.methods.MethodsData;

public class search_page {

	WebDriver driver = null;
	Element element = null;
	Verify verify = null;
	Wait wait = null;
	Actions actions = null;
	testng_logs logs = null;

	public search_page(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
		wait = new Wait(driver);
		actions = new Actions(driver);
		logs = new testng_logs();
	}

	@MethodsData(method_id = "button_1")
	public void click_on_search_box_button() {
		wait.wait_for_second(5);
		element.click("search_box_button");
	}
	@MethodsData(method_id = "button_1")
	public void verify_search_box_button_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("search_box_button");
	}
	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_search_text_box(String text_to_enter) {
		wait.wait_for_second(5);
		element.click("search_text_box");
		element.enter_text("search_text_box", text_to_enter);
		actions.sendKeys(Keys.ENTER).perform();
	}

	@MethodsData(method_id = "text_box_2")
	public void clear_text_from_search_text_box() {
		element.clear_text_field("search_text_box");
	}

	@MethodsData(method_id = "text_box_3")
	public void clear_text_and_enter_text_in_search_text_box(String text_to_enter) {
		element.clear_and_enter_in_text_field("search_text_box", text_to_enter);
	}

	@MethodsData(method_id = "text_box_4")
	public void verify_search_text_box_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("search_text_box");
	}

	@MethodsData(method_id = "button_1")
	public void verify_search_result_is_present_on_page() {
		wait.wait_for_second(7);
		verify.element_is_present("search_result");
	}

	@MethodsData(method_id = "button_2")
	public void verify_search_result_is_clickable() {
		verify.element_is_enable("search_result");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_search_result() {
		element.click("search_result");
	}

	@MethodsData(method_id =  "button_4")
	public void verify_search_result_is_selected()
	{
		verify.element_is_selected("search_result");
	}

	@MethodsData(method_id = "button_4")
	public void verify_search_result_is_equal_to_text(String text)
	{
		verify.element_attribute_is_equal_to("search_result","content-desc",text);
	}

	public void verify_search_result_is_displayed_on_page(String program_name){
		wait.wait_for_second(10);
		boolean bool= false;
		String nameOfProgram = element.find("search_result").getAttribute("content-desc");
		if(nameOfProgram.contains(program_name)){
			bool = true;
			Assertions.assertThat(bool).isTrue();
			logs.test_result(bool);
		}else
		{
			Assertions.assertThat(bool).isFalse();
			logs.test_result(bool);
		}

	}


	@MethodsData(method_id = "text_box_4")
	public void verify_modules_text_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("modules_text");
	}

	@MethodsData(method_id = "text_box_4")
	public void verify_lessons_text_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("lessons_text");
	}


}