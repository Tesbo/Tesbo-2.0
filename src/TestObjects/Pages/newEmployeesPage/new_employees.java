package Pages.newEmployeesPage;
import io.unity.core.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import io.unity.performaction.autoweb.Window;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import web.object_repository.employeeProfilePage.employeeProfile;

public class new_employees {
	WebDriver driver = null;
	Element element = null;
	Verify verify = null;
	Wait wait = null;
	Window window = null;
	public new_employees(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
		wait = new Wait(driver);
		window = new Window(driver);
	}
	@MethodsData(method_id = "button_1")
	public void verify_employees_Option_is_present_on_page() {
		wait.wait_until_element_is_visible("employees_Option");
		verify.element_is_present("employees_Option");
	}
	@MethodsData(method_id = "button_1")
	public void click_on_employees_Option() {
		wait.wait_until_element_is_visible("employees_Option");
		element.click("employees_Option");
	}
	@MethodsData(method_id = "button_1")
	public void verify_new_employees_button_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("new_employees_button");
	}
	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_phone_number_text_box(String text_to_enter) {
		wait.wait_for_second(3);
		element.click("phone_number_text_box");
		wait.wait_for_second(1);
		element.enter_text("phone_number_text_box", text_to_enter);
		wait.wait_for_second(2);
	}
	@MethodsData(method_id = "button_1")
	public void verify_first_name_text_box_is_present_on_page() {
		wait.wait_until_element_is_visible("first_name_text_box_on_popup");
		element.find("first_name_text_box_on_popup");
		verify.element_is_present("first_name_text_box_on_popup");
	}
	@MethodsData(method_id = "button_1")
	public void verify_create_employee_progress_step() {
		verify.element_is_present("employee_progress");
	}
	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_first_name_text_box(String text_to_enter) {
		element.click("first_name_text_box_on_popup");
		element.enter_text("first_name_text_box_on_popup", text_to_enter);
	}
	@MethodsData(method_id = "button_1")
	public void verify_last_name_text_box_is_present_on_page() {
		verify.element_is_present("last_name_text_box_on_popup");
	}
	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_last_name_text_box(String text_to_enter) {
		element.click("last_name_text_box_on_popup");
		element.enter_text("last_name_text_box_on_popup", text_to_enter);

	}
	@MethodsData(method_id = "button_1")
	public void click_on_management_info_popup() {
		wait.wait_until_element_is_visible("management_info_popup");
		element.click("management_info_popup");
	}
	@MethodsData(method_id = "button_1")
	public void click_on_discipline_removed_cross_icon() {
		wait.wait_until_element_is_visible("remove_discipline_cross_icon");
		element.click("remove_discipline_cross_icon");
	}
	@MethodsData(method_id = "button_1")
	public void verify_employee_hiring_date_text_box_is_present_on_page() {
		verify.element_is_present("calendar_icon_button");
		element.click("calendar_icon_button");
		wait.wait_for_second(1);
	}
	@MethodsData(method_id = "button_1")
	public void select_date_from_calendar_popup() {
		element.click("employee_hiring_date");
	}
	@MethodsData(method_id = "button_1")
	public void verify_employee_redirect_to_employee_profile() {
		wait.wait_until_element_is_visible("employee_display_employee_profile");
		verify.element_is_present("employee_display_employee_profile");
		wait.wait_for_second(5);
	}
	@MethodsData(method_id = "text_box_1")
	public void enter_text_at_employee_hiring_date_text_box(String text_to_enter) {
		wait.wait_for_second(1);
		element.click("employee_hiring_date_text_box");
		//element.enter_text("employee_hiring_date_text_box", text_to_enter);
		wait.wait_for_second(2);
	}
	@MethodsData(method_id = "button_1")
	public void verify_phone_number_require_error_msg_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("phone_number_require_error_msg");
	}
	@MethodsData(method_id = "button_1")
	public void verify_first_name_require_error_msg_is_present_on_page() {
		wait.wait_until_element_is_visible("first_name_require_error_msg");
		verify.element_is_present("first_name_require_error_msg");
	}
	@MethodsData(method_id = "button_1")
	public void verify_last_name_require_error_msg_is_present_on_page() {
		wait.wait_until_element_is_visible("last_name_require_error_msg");
		verify.element_is_present("last_name_require_error_msg");
	}
	@MethodsData(method_id = "button_1")
	public void verify_country_drop_Drop_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("country_drop_Drop");
	}
	@MethodsData(method_id = "button_1")
	public void verify_find_Country_text_box_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("find_Country_text_box");
	}
	@MethodsData(method_id = "button_1")
	public void enter_text_for_search_country_from_country_dropdown_text_box(String text_to_enter) {
		element.click("find_Country_text_box");
		wait.wait_for_second(3);
		element.enter_text("find_Country_text_box" ,text_to_enter);
	}
	@MethodsData(method_id = "button_1")
	public void select_search_country() {
		element.find("india_Country_select");
		element.click("india_Country_select");
		wait.wait_for_second(2);
	}
	@MethodsData(method_id = "button_1")
	public void verify_phone_number_error_msg_is_present_on_page() {
		wait.wait_until_element_is_visible("phone_number_error_msg");
		verify.element_is_present("phone_number_error_msg");
	}
	@MethodsData(method_id = "button_1")
	public void verify_new_employee_header_is_present_on_page() {
		wait.wait_for_second(2);
		verify.element_is_present("new_employee_header");
	}
	@MethodsData(method_id = "button_4")
	public void Verify_cancel_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("cancel_button", button_text);
	}
	@MethodsData(method_id = "button_2")
	public void verify_cancel_button_is_clickable() {
		verify.element_is_enable("cancel_button");
	}
	@MethodsData(method_id = "button_4")
	public void Verify_new_employee_header_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("new_employee_header", button_text);
	}
	@MethodsData(method_id = "button_3")
	public void click_on_new_employee_header() {
		element.click("new_employee_header");
	}
	@MethodsData(method_id = "button_2")
	public void verify_new_employee_header_is_clickable() {
		verify.element_is_enable("new_employee_header");
	}
	@MethodsData(method_id = "text_1")
	public void verify_employee_hiring_date_text_box_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("employee_hiring_date_text_box", button_text);
	}
	@MethodsData(method_id = "text_1")
	public void verify_find_Country_text_box_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("find_Country_text_box", button_text);
	}
	@MethodsData(method_id = "button_4")
	public void Verify_cancel_icon_on_popup_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("cancel_icon_on_popup", button_text);
	}
	@MethodsData(method_id = "button_3")
	public void click_on_cancel_icon_on_popup() {
		wait.wait_for_second(1);
		element.click("cancel_icon_on_popup");
	}
	@MethodsData(method_id = "button_2")
	public void verify_cancel_icon_on_popup_is_clickable() {
		verify.element_is_enable("cancel_icon_on_popup");
	}
	@MethodsData(method_id = "button_1")
	public void verify_cancel_icon_on_popup_is_present_on_page() {
		verify.element_is_present("cancel_icon_on_popup");
	}
	@MethodsData(method_id = "text_1")
	public void verify_phone_number_error_msg_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("phone_number_error_msg", button_text);
	}
	@MethodsData(method_id = "text_box_3")
	public void clear_text_and_enter_text_in_phone_number_text_box(String text_to_enter) {
		element.clear_and_enter_in_text_field("phone_number_text_box", text_to_enter);
	}
	@MethodsData(method_id = "text_box_4")
	public void verify_phone_number_text_box_is_present_on_page() {
		wait.wait_for_second(5);
		verify.element_is_present("phone_number_text_box");
	}
	@MethodsData(method_id = "text_box_2")
	public void clear_text_from_phone_number_text_box() {
		element.clear_text_field("phone_number_text_box");
	}
	@MethodsData(method_id = "link_2")
	public void Verify_employees_Option_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("employees_Option", button_text);
	}
	@MethodsData(method_id = "link_3")
	public void verify_employees_Option_is_clickable() {
		verify.element_is_enable("employees_Option");
	}
	@MethodsData(method_id = "button_4")
	public void Verify_closed_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("closed_button", button_text);
	}
	@MethodsData(method_id = "button_2")
	public void verify_closed_button_is_clickable() {
		verify.element_is_enable("closed_button");
	}
	@MethodsData(method_id = "button_4")
	public void Verify_back_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("back_button", button_text);
	}
	@MethodsData(method_id = "button_2")
	public void verify_back_button_is_clickable() {
		verify.element_is_enable("back_button");
	}
	@MethodsData(method_id = "button_4")
	public void Verify_continue_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("continue_button", button_text);
	}
	@MethodsData(method_id = "button_3")
	public void click_on_continue_button() {
		wait.wait_until_element_is_visible("continue_button");
		element.click("continue_button");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_send_sms_notification() {
		wait.wait_until_element_is_visible("send_sms_notification");
		element.click("send_sms_notification");
	}
	@MethodsData(method_id = "button_2")
	public void verify_continue_button_is_clickable() {
		verify.element_is_enable("continue_button");
	}
	@MethodsData(method_id = "button_4")
	public void Verify_country_drop_Drop_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("country_drop_Drop", button_text);
	}
	@MethodsData(method_id = "button_3")
	public void click_on_country_drop_Drop() {
		element.click("country_drop_Drop");
	}
	@MethodsData(method_id = "button_2")
	public void verify_country_drop_Drop_is_clickable() {
		verify.element_is_enable("country_drop_Drop");
	}
	@MethodsData(method_id = "text_1")
	public void verify_first_name_text_box_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("first_name_text_box", button_text);
	}
	@MethodsData(method_id = "button_4")
	public void Verify_phone_number_require_error_msg_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("phone_number_require_error_msg", button_text);
	}
	@MethodsData(method_id = "button_3")
	public void click_on_phone_number_require_error_msg() {
		element.click("phone_number_require_error_msg");
	}
	@MethodsData(method_id = "button_2")
	public void verify_phone_number_require_error_msg_is_clickable() {
		verify.element_is_enable("phone_number_require_error_msg");
	}
	@MethodsData(method_id = "text_1")
	public void verify_last_name_text_box_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("last_name_text_box", button_text);
	}
	@MethodsData(method_id = "button_4")
	public void Verify_create_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("create_button", button_text);
	}
	@MethodsData(method_id = "button_2")
	public void verify_create_button_is_clickable() {
		verify.element_is_enable("create_button");
	}
	@MethodsData(method_id = "button_4")
	public void Verify_last_name_require_error_msg_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("last_name_require_error_msg", button_text);
	}
	@MethodsData(method_id = "button_3")
	public void click_on_last_name_require_error_msg() {
		element.click("last_name_require_error_msg");
	}
	@MethodsData(method_id = "button_2")
	public void verify_last_name_require_error_msg_is_clickable() {
		verify.element_is_enable("last_name_require_error_msg");
	}
	@MethodsData(method_id = "button_4")
	public void Verify_new_employees_button_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("new_employees_button", button_text);
	}
	@MethodsData(method_id = "button_3")
	public void click_on_new_employees_button() {
		element.click("new_employees_button");
	}
	@MethodsData(method_id = "button_2")
	public void verify_new_employees_button_is_clickable() {
		verify.element_is_enable("new_employees_button");
	}
	@MethodsData(method_id = "button_4")
	public void Verify_first_name_require_error_msg_text_is_equal_to(String button_text) {
		verify.element_text_is_equal_to("first_name_require_error_msg", button_text);
	}
	@MethodsData(method_id = "button_3")
	public void click_on_first_name_require_error_msg() {
		element.click("first_name_require_error_msg");
	}
	@MethodsData(method_id = "button_2")
	public void verify_first_name_require_error_msg_is_clickable() {
		verify.element_is_enable("first_name_require_error_msg");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_cancel_button() {
		wait.wait_until_element_is_visible("cancel_button");
		element.click("cancel_button");
	}
	@MethodsData(method_id = "button_1")
	public void verify_cancel_button_is_present_on_page() {
		verify.element_is_present("cancel_button");
	}


	@MethodsData(method_id = "button_3")
	public void click_on_closed_button() {
		element.click("closed_button");
	}
	@MethodsData(method_id = "button_1")
	public void verify_closed_button_is_present_on_page() {
		verify.element_is_present("closed_button");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_back_button() {
		wait.wait_for_second(2);
		element.click("back_button");
	}
	@MethodsData(method_id = "button_1")
	public void verify_back_button_is_present_on_page() {
		verify.element_is_present("back_button");
	}
	@MethodsData(method_id = "button_1")
	public void verify_continue_button_is_present_on_page() {
		verify.element_is_present("continue_button");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_create_button() {
		wait.wait_until_element_is_visible("new_emp_create_button");
		element.click("new_emp_create_button");
	}

	@MethodsData(method_id = "button_1")
	public void verify_create_button_is_present_on_page() {
		verify.element_is_present("new_emp_create_button");
	}
	@MethodsData(method_id = "button_1")
	public void click_on_employee_check_box() {
		wait.wait_until_element_is_visible("employees_check_box_on_page_first");
		element.click("employees_check_box_on_page_first");
		element.get_element_text("employees_check_box_name_one");
		wait.wait_for_second(1);
		element.click("employees_check_box_on_page_second");
		element.get_element_text("employees_check_box_name_two");
//		wait.wait_for_second(1);
//		element.click("employees_check_box_on_page_third");
//		element.get_element_text("employees_check_box_name_three");
	}
	@MethodsData(method_id = "text_1")
	public void verify_created_employee_display_on_employee_profile() {
		wait.wait_until_element_is_visible("employee_visible_employee_profile");
		verify.element_is_present("employee_visible_employee_profile");
	}
	@MethodsData(method_id = "button_4")
	public void verify_progress_step_is_showing_in_page() {
		verify.element_is_present("employee_progress");
	}
	@MethodsData(method_id = "button_4")
	public void verify_discipline_field_is_present() {
		verify.element_is_present("new_emp_discipline_text_box");
		element.click("new_emp_discipline_text_box");
	}
	@MethodsData(method_id = "button_3")
	public void select_discipline_from_the_dropdown() {
		wait.wait_until_element_is_visible("new_emp_discipline_select");
		element.click("new_emp_discipline_select");
	}
	@MethodsData(method_id = "button_4")
	public void verify_location_field_is_present() {
		verify.element_is_present("new_emp_location_text_box");
		element.click("new_emp_location_text_box");
	}
	@MethodsData(method_id = "button_3")
	public void select_location_from_the_location_dropdown() {
		wait.wait_until_element_is_visible("new_emp_location_select");
		element.click("new_emp_location_select");
	}
	@MethodsData(method_id = "button_3")
	public void verify_discipline_is_required() {
		wait.wait_until_element_is_visible("discipline_required_message");
		verify.element_is_present("discipline_required_message");
	}
	@MethodsData(method_id = "button_3")
	public void verify_selected_location_is_present() {
		wait.wait_until_element_is_visible("selected_location_display");
		verify.element_is_present("selected_location_display");
	}
	@MethodsData(method_id = "button_3")
	public void verify_location_is_required() {
		wait.wait_until_element_is_visible("location_required_message");
		verify.element_is_present("location_required_message");
	}
	@MethodsData(method_id = "button_3")
	public void employment_date_is_required() {
		wait.wait_until_element_is_visible("employment_date_required_message");
		verify.element_is_present("employment_date_required_message");
	}
	@MethodsData(method_id = "button_3")
	public void verify_language_text_box_is_present() {
		wait.wait_until_element_is_visible("language_dropdown_text_box");
		verify.element_is_present("language_dropdown_text_box");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_language_dropdown() {
		wait.wait_until_element_is_visible("language_dropdown_text_box");
		element.click("language_dropdown_text_box");
	}
	@MethodsData(method_id = "button_3")
	public void select_language_from_the_dropdown() {
		wait.wait_until_element_is_visible("select_language_from_the_dropdown");
		element.click("select_language_from_the_dropdown");
	}
	@MethodsData(method_id = "button_3")
	public void click_on_already_taken_phone_number_employee_name_validation() {
		wait.wait_until_element_is_visible("already_taken_phn_emp_name");
		element.click("already_taken_phn_emp_name");

	}
	@MethodsData(method_id = "button_3")
	public void verify_redirect_to_that_employee_profile_page() {
		wait.wait_until_element_is_visible("employee_display_employee_profile");
		element.find("employee_display_employee_profile");
		verify.element_is_present("employee_display_employee_profile");

	}
	@MethodsData(method_id = "button_3")
	public void verify_employee_number_is_present_on_table() {
		wait.wait_until_element_is_visible("employee_number_in_table");
		verify.element_is_present("employee_number_in_table");
	}
	@MethodsData(method_id = "button_3")
	public void copy_employee_number() {
//		wait.wait_until_element_is_visible("employee_number_in_table");
//		element.click("employee_number_in_table");
		element.find("copy_employee_number").sendKeys(Keys.CONTROL,"c");
	}
	@MethodsData(method_id = "button_3")
	public void past_copy_phone_number_of_diff_agency() {
		wait.wait_until_element_is_visible("phone_number_text_box");
		element.find("phone_number_text_box").sendKeys(Keys.CONTROL,"v");
	}
	@MethodsData(method_id = "button_3")
	public void verify_redirect_to_personal_info_details() {
		wait.wait_until_element_is_visible("personal_info_page");
		verify.element_is_present("personal_info_page");
	}

	public boolean verify_phone_number_is_not_in_use(){
		return verify.check_element_is_present("phone_number_in_use_error");
	}

	public void enter_phone_number(String phoneNumber){
		element.clear_and_enter_in_text_field("phone_number_text_box", phoneNumber);
	}

	public employeeProfile click_on_create_button_to_complete_employee_creation(){
		wait.wait_until_element_is_visible("new_emp_create_button");
		element.click("new_emp_create_button");
		return new employeeProfile(driver);
	}

	public int generate_number(String numOfDigits){
		return (int)(Math.random()*Integer.parseInt(numOfDigits))+1;
	}
	public String generate_string(int length){
		return RandomStringUtils.random(length,true,false);
	}

	public void select_date(){
		wait.wait_until_element_is_visible("employment_date_field");
		verify.element_is_present("employment_date_field");
		element.click("employment_date_field");
		wait.wait_until_element_is_visible("employment_date");
		verify.element_is_present("employment_date");
		element.click("employment_date");
	}

}