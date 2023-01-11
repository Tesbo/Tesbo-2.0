package web.object_repository.signup;
import org.openqa.selenium.JavascriptExecutor;
import io.unity.framework.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.*;
import org.openqa.selenium.*;




public class signup {

	WebDriver driver = null;
	Element element = null;
	Verify verify = null;

	Wait wait = null;

	public signup(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
		wait = new Wait(driver);
	}

	@MethodsData(method_id = "text_box_1")
		public void enter_text_at_preferably_your_work_email_text_box(String text_to_enter){
		wait.wait_for_second(5);
		element.click("preferably_your_work_email_text_box");
		element.enter_text("preferably_your_work_email_text_box", text_to_enter);
		wait.wait_for_second(5);
	}

	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_a_secure_one_please_password(String text_to_enter) {
		wait.wait_for_second(5);
		element.enter_text("a_secure_one_please_password", text_to_enter);
		wait.wait_for_second(5);
	}

	@MethodsData(method_id = "button_1")
	public void click_on_sign_up_button() {
		element.click("sign_up_button");
		wait.wait_for_second(4);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_first_name_text(String text_to_enter){
		wait.wait_for_second(5);
		element.enter_text("first_name_text_box", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_last_name_text(String text_to_enter){
		element.enter_text("last_name_text_box", text_to_enter);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_select_people(){
		element.click("select_people");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_select_people_dropdown(){
		wait.wait_for_second(3);
		element.click("select_people_dropdown");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_select_industry(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait.wait_for_second(5);
		element.click("select_industry");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_select_industry_dropdown(){
		wait.wait_for_second(3);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		element.click("select_industry_dropdown");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_saleshandy_name(){
		wait.wait_for_second(5);
		element.click("saleshandy_name");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_continue_signup(){
		wait.wait_for_second(3);
		element.click("continue_signup");
	}

	@MethodsData(method_id = "text_3")
	public void verify_onboard_page_is_present_on_page() {

		verify.element_is_present("onboard_page");
		wait.wait_for_second(5);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_onboard_gmail(){
		wait.wait_for_second(3);
		element.click("onboard_gmail");

	}

	@MethodsData(method_id = "button_3")
	public void verify_gmail_verify_is_present_on_page(){
		verify.element_is_present("gmail_verify");
		wait.wait_for_second(5);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_gmail_verify(){
		element.click("gmail_verify");
		wait.wait_for_second(3);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_gmail_verify_allow(){
		element.click("gmail_verify_allow");
		wait.wait_for_second(3);
	}

	@MethodsData(method_id = "button_3")
	public void verify_setting_menu_is_present_on_page(){
		verify.element_is_present("setting_menu");
		System.out.println("user connected with saleshandy");
		wait.wait_for_second(5);

	}

	@MethodsData(method_id = "button_3")
	public void click_on_close_video(){
		element.click("close_video");
		wait.wait_for_second(5);
	}

	@MethodsData(method_id = "button_3")
		public void click_on_close_startted_get(){
			element.click("close_startted_get");
			wait.wait_for_second(5);
		}



	@MethodsData(method_id = "button_3")
	public void click_on_close_close_comment(){
		element.click("close_comment");
		wait.wait_for_second(5);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_click_on_schedule(){
		element.click("click_on_schedule");
		wait.wait_for_second(3);
	}
	@MethodsData(method_id = "button_3")
	public void click_on_add_new_schedule(){
		element.click("add_new_schedule");
		wait.wait_for_second(3);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_add_schedule_save(){
		element.click("schedule_save");
		wait.wait_for_second(3);
	}

	@MethodsData(method_id = "text_box_3")
	public void click_on_enter_schedule_name(){
		element.click("enter_schedule_name");
		wait.wait_for_second(3);
	}

	@MethodsData(method_id = "text_box_3")
	public void clear_text_and_enter_text_in_enter_schedule_name(String element_name, String element_text_for_click) {
		wait.wait_for_second(5);
		element.clear_text_field("enter_schedule_name");
		element.clear_and_enter_in_text_field("enter_schedule_name","Test 772");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_select_time_zone(){
		element.click("select_time_zone");
		wait.wait_for_second(3);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_change_time_zone(){
		element.click("change_time_zone");
		wait.wait_for_second(3);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_ifram1(){
		wait.wait_for_second(5);
		WebElement iframe = element.find("iframe1");
		driver.switchTo().frame(iframe);
		wait.wait_for_second(5);
		element.click("close_comment");
		driver.switchTo().defaultContent();
	}


	@MethodsData(method_id = "button_3")
	public void click_on_monday_time_1(){
		wait.wait_for_second(5);
		element.click("monday_time_1");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_monday_time_1(String text_to_enter){
		element.enter_text("monday_time_1", text_to_enter);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_monday_time_1_2(){
		wait.wait_for_second(1);
		element.click("monday_time_1_2");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_monday_time_1_2(String text_to_enter){
		element.enter_text("monday_time_1_2", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_monday_time_1_3(String text_to_enter){
		element.enter_text("monday_time_1_3", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_monday_time_1_4(String text_to_enter){
		element.enter_text("monday_time_1_4", text_to_enter);
	}
	@MethodsData(method_id = "button_3")
	public void click_on_monday_add_1(){
		wait.wait_for_second(1);
		element.click("monday_add_1");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_monday_time_2(){
		wait.wait_for_second(1);
		element.click("monday_time_2");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_monday_time_2(String text_to_enter){
		element.enter_text("monday_time_2", text_to_enter);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_monday_time_2_1(){
		wait.wait_for_second(1);
		element.click("monday_time_2_1");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_monday_time_2_1(String text_to_enter){
		element.enter_text("monday_time_2_1", text_to_enter);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_monday_time_2_2(){
		wait.wait_for_second(1);
		element.click("monday_time_2_2");
		wait.wait_for_second(5);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_monday_time_2_2(String text_to_enter){
		element.enter_text("monday_time_2_2", text_to_enter);
	}
	@MethodsData(method_id = "button_3")
	public void click_on_monday_time_2_3(){
		wait.wait_for_second(5);
		element.click("monday_time_2_3");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_monday_time_2_3(String text_to_enter){
		element.enter_text("monday_time_2_3", text_to_enter);
	}




	@MethodsData(method_id = "button_3")
	public void click_on_tuesday_time_1(){
		wait.wait_for_second(1);
		element.click("tuesday_time_1");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_tuesday_time_1(String text_to_enter){
		element.enter_text("tuesday_time_1", text_to_enter);
	}


	@MethodsData(method_id = "text_box_3")
	public void enter_text_tuesday_time_1_2(String text_to_enter){
		element.enter_text("tuesday_time_1_2", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_tuesday_time_1_3(String text_to_enter){
		element.enter_text("tuesday_time_1_3", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_tuesday_time_1_4(String text_to_enter){
		element.enter_text("tuesday_time_1_4", text_to_enter);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_wednesday_time_1(){
		wait.wait_for_second(1);
		element.click("wednesday_time_1");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_wednesday_time_1(String text_to_enter){
		element.enter_text("wednesday_time_1", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_wednesday_time_1_2(String text_to_enter){
		element.enter_text("wednesday_time_1_2", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_wednesday_time_1_3(String text_to_enter){
		element.enter_text("wednesday_time_1_3", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_wednesday_time_1_4(String text_to_enter){
		element.enter_text("wednesday_time_1_4", text_to_enter);
	}


	@MethodsData(method_id = "button_3")
	public void click_on_thursday_time_1(){
		wait.wait_for_second(1);
		element.click("thursday_time_1");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_thursday_time_1(String text_to_enter){
		element.enter_text("thursday_time_1", text_to_enter);
	}
	@MethodsData(method_id = "text_box_3")
	public void enter_text_thursday_time_1_2(String text_to_enter){
		element.enter_text("thursday_time_1_2", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_thursday_time_1_3(String text_to_enter){
		element.enter_text("thursday_time_1_3", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_thursday_time_1_4(String text_to_enter){
		element.enter_text("thursday_time_1_4", text_to_enter);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_friday_time_1(){
		wait.wait_for_second(1);
		element.click("friday_time_1");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_friday_time_1(String text_to_enter){
		element.enter_text("friday_time_1", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_friday_time_1_2(String text_to_enter){
		element.enter_text("friday_time_1_2", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_friday_time_1_3(String text_to_enter){
		element.enter_text("friday_time_1_3", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_friday_time_1_4(String text_to_enter){
		element.enter_text("friday_time_1_4", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void click_on_saturday_add_1(){
		element.click("saturday_add_1");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_saturday_time_1(){
		wait.wait_for_second(1);
		element.click("saturday_time_1");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_saturday_time_1(String text_to_enter){
		element.enter_text("saturday_time_1", text_to_enter);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_saturday_time_1_2(){
		wait.wait_for_second(1);
		element.click("saturday_time_1_2");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_saturday_time_1_2(String text_to_enter){
		element.enter_text("saturday_time_1_2", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_saturday_time_2(String text_to_enter){
		element.enter_text("saturday_time_2", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_saturday_time_2_1(String text_to_enter){
		element.enter_text("saturday_time_2_1", text_to_enter);
	}


	@MethodsData(method_id = "text_box_3")
	public void click_on_sunday_add_1(){
		element.click("sunday_add_1");
	}

	@MethodsData(method_id = "button_3")
	public void click_on_sunday_time_1(){
		wait.wait_for_second(1);
		element.click("sunday_time_1");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_sunday_time_1(String text_to_enter){
		element.enter_text("sunday_time_1", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_sunday_time_1_2(String text_to_enter){
		element.enter_text("sunday_time_1_2", text_to_enter);
	}

	@MethodsData(method_id = "button_3")
	public void click_on_sunday_time_2(){
		wait.wait_for_second(1);
		element.click("sunday_time_2");
		wait.wait_for_second(1);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_sunday_time_2(String text_to_enter){
		element.enter_text("sunday_time_2", text_to_enter);
	}

	@MethodsData(method_id = "text_box_3")
	public void enter_text_sunday_time_2_1(String text_to_enter){
		element.enter_text("sunday_time_2_1", text_to_enter);
	}

}