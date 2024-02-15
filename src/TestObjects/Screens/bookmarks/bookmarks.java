package Screens.bookmarks;

import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;
import io.unity.core.generators.methodsgenerator.methods.MethodsData;

public class bookmarks {

	WebDriver driver = null;
	Element element = null;
	Verify verify = null;
	Wait wait = null;

	public bookmarks(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
		wait = new Wait(driver);
	}

	@MethodsData(method_id = "button_4")
	public void Verify_bookmarks_text_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("bookmarks_text", button_text);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_bookmarks_text() {
		element.click("bookmarks_text");
	}

	@MethodsData(method_id = "button_2")
	public void verify_bookmarks_text_is_clickable() {
		verify.element_is_enable("bookmarks_text");
	}

	@MethodsData(method_id = "button_1")
	public void verify_bookmarks_text_is_present_on_page() {
		verify.element_is_present("bookmarks_text");
	}

	@MethodsData(method_id = "button_1")
	public void verify_bookmarks_text_is_selected() {
		verify.element_is_present("bookmarks_text");
	}

	@MethodsData(method_id = "button_4")
	public void Verify_bookmarks_video_link_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("bookmarks_video_link", button_text);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_bookmarks_video_link() {
		element.click("bookmarks_video_link");
	}

	@MethodsData(method_id = "button_2")
	public void verify_bookmarks_video_link_is_clickable() {
		verify.element_is_enable("bookmarks_video_link");
	}

	@MethodsData(method_id = "button_1")
	public void verify_bookmarks_video_link_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("bookmarks_video_link");
	}

	@MethodsData(method_id = "button_1")
	public void verify_bookmarks_save_and_remove_button_is_selected() {
		verify.element_is_present("bookmarks_save_and_remove_button");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_bookmarks_save_and_remove_button() {
		element.click("bookmarks_save_and_remove_button");
	}

	@MethodsData(method_id = "button_1")
	public void verify_bookmarks_video_saved_video_button_is_selected() {
		verify.element_is_present("bookmarks_video_saved_video");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_back_button_from_video_screen() {
		element.click("back_button_from_video_screen");
	}

	@MethodsData(method_id = "button_1")
	public void verify_bookmark_video_in_bookmark_screen_is_displayed() {
		verify.element_is_present("bookmark_video_in_bookmark_screen");
	}

	@MethodsData(method_id = "button_1")
	public void click_on_bookmark_video_in_bookmark_screen_is_displayed() {
		verify.element_is_present("bookmark_video_in_bookmark_screen");
	}
}