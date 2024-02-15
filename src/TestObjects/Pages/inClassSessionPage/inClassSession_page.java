package Pages.inClassSessionPage;

import io.unity.core.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;

public class inClassSession_page {

    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;

    public inClassSession_page(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
    }

    @MethodsData(method_id = "button_1")
    public void verify_inClassSession_option_tab_is_present_on_page() {
        wait.wait_until_element_is_visible("in_class_session_option_inClassSession");
        verify.element_is_present("in_class_session_option_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_inClassSession_tab() {
        wait.wait_until_element_is_visible("in_class_session_tab");
        wait.wait_for_second(6);
        element.click("in_class_session_tab");
    }

    @MethodsData(method_id = "button_1")
    public void verify_schedule_is_present_on_inClassSession_page() {
        wait.wait_until_element_is_visible("in_class_schedule_header");
        verify.element_is_present("in_class_schedule_header");
    }
    @MethodsData(method_id = "button_1")
    public void verify_new_session_popup_header_is_present_on_page() {
        wait.wait_until_element_is_visible("new_session_popup_text");
        verify.element_is_present("new_session_popup_text");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_new_session_button_inClassSession() {
        element.click("new_session_button_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void verify_session_name_inClassSession_is_present_on_page() {
        wait.wait_for_second(1);
        verify.element_is_present("session_name_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_session_name_inClassSession() {

        element.click("session_name_inClassSession");
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_session_name_inClassSession(String text_to_enter) {
        wait.wait_for_second(2);
        element.click("session_name_inClassSession_text_box");
        element.enter_text("session_name_inClassSession_text_box", text_to_enter);
    }

    @MethodsData(method_id = "button_1")
    public void verify_session_supervisor_inClassSession_is_present_on_page() {
        wait.wait_for_second(1);
        verify.element_is_present("session_supervisor_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_session_supervisor_inClassSession() {

        element.click("session_supervisor_inClassSession");
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_session_supervisor_inClassSession(String text_to_enter) {
        wait.wait_for_second(2);
        element.click("session_supervisor_inClassSession");
        element.enter_text("session_supervisor_inClassSession", text_to_enter);
    }


    @MethodsData(method_id = "button_1")
    public void verify_calendar_choose_textbox_inClassSession_is_present_on_page() {
        wait.wait_for_second(1);
        verify.element_is_present("calendar_choose_present");
        element.click("calendar_choose_present");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_calendar_choose_textbox_inClassSession() {
        element.click("calendar_choose_textbox_inClassSession");
        wait.wait_for_second(1);
    }

    @MethodsData(method_id = "text_box_1")
    public void calendar_date_choose_textbox_inClassSession() {
        wait.wait_for_second(2);
        //element.click("calendar_choose_textbox_inClassSession");
        //wait.wait_for_second(1);
        element.click("calendar_choose_textbox_inClassSession");
        wait.wait_for_second(2);
    }


    @MethodsData(method_id = "button_1")
    public void verify_add_field_link_inClassSession_is_present_on_page() {
        wait.wait_until_element_is_visible("add_field_link_inClassSession");
        verify.element_is_present("add_field_link_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_add_field_link_inClassSession() {
       // wait.wait_until_element_is_visible("add_field_link_inClassSession");
        element.perform_scroll_to_element("add_field_link_inClassSession");
        element.click("add_field_link_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void verify_create_session_button_inClassSession_is_present_on_page() {
        wait.wait_for_second(1);
        verify.element_is_present("create_session_button_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_create_session_button_inClassSession() {
        wait.wait_for_second(1);
        element.click("create_session_button_inClassSession");
    }
    @MethodsData(method_id = "button_1")
    public void verify_created_session_present_on_schedule_page() {
        wait.wait_for_second(5);
       wait.wait_until_element_is_visible("created_session_present");
       verify.check_element_is_present("Nothing");
    }


    @MethodsData(method_id = "button_1")
    public void verify_cancel_button_inClassSession_is_present_on_page() {
        wait.wait_for_second(1);
        verify.element_is_present("cancel_new_session_popup");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_cancel_button_inClassSession() {
        element.click("cancel_new_session_popup");
    }

    @MethodsData(method_id = "button_1")
    public void verify_calendar_new_field_name_inClassSession_is_present_on_page() {
        wait.wait_for_second(5);
        verify.element_is_present("new_field_name_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_new_field_name_inClassSession() {

        element.click("new_field_name_inClassSession");
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_new_field_name_inClassSession(String text_to_enter) {
        wait.wait_for_second(2);
        element.click("new_field_name_inClassSession");
        element.enter_text("new_field_name_inClassSession", text_to_enter);
    }

    @MethodsData(method_id = "button_1")
    public void verify_new_field_value_inClassSession_is_present_on_page() {
        wait.wait_until_element_is_visible("new_field_value_inClassSession");
        verify.element_is_present("new_field_value_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_new_field_value_inClassSession() {

        element.click("new_field_value_inClassSession");
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_new_field_value_inClassSession(String text_to_enter) {
        wait.wait_for_second(2);
        element.click("new_field_value_inClassSession");
        element.enter_text("new_field_value_inClassSession", text_to_enter);
    }

    @MethodsData(method_id = "button_1")
    public void verify_delete_button_inClassSession_is_present_on_page() {
        wait.wait_until_element_is_visible("delete_button_inClassSession");
        verify.element_is_present("delete_button_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_delete_button_inClassSession() {
        element.click("delete_button_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void verify_cross_button_inClassSession_is_present_on_page() {
       wait.wait_until_element_is_visible("cross_button_inClassSession_x");
        verify.element_is_present("cross_button_inClassSession_x");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_cross_button_inClassSession() {
        element.click("cross_button_inClassSession_x");
    }

    @MethodsData(method_id = "button_1")
    public void verify_search_text_box_inClassSession_is_present_on_page() {
       wait.wait_until_element_is_visible("search_text_box_inClassSession");
        verify.element_is_present("search_text_box_inClassSession");
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text_at_search_text_box_inClassSession(String text_to_enter) {
        wait.wait_for_second(2);
        element.click("search_text_box_inClassSession");
        element.enter_text("search_text_box_inClassSession", text_to_enter);
    }

    @MethodsData(method_id = "button_1")
    public void verify_search_name_in_viewList_inClassSession_is_present_on_page() {
       wait.wait_until_element_is_visible("search_name_in_viewList_inClassSession");
        verify.element_is_present("search_name_in_viewList_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_search_name_in_viewList_inClassSession() {
        element.click("search_name_in_viewList_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void verify_details_schedule_inClassSession_is_present_on_page() {
        wait.wait_until_element_is_visible("details_schedule_inClassSession");
        verify.element_is_present("details_schedule_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void verify_employees_schedule_inClassSession_is_present_on_page() {
       wait.wait_until_element_is_visible("employees_schedule_inClassSession");
        verify.element_is_present("employees_schedule_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void verify_edit_button_session_inClassSession_is_present_on_page() {
       wait.wait_until_element_is_visible("edit_button_session_inClassSession");
        verify.element_is_present("edit_button_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_edit_button_session_inClassSession() {
        element.click("edit_button_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void verify_update_button_session_inClassSession_is_present_on_page() {
        wait.wait_until_element_is_visible("update_button_session_inClassSession");
        verify.element_is_present("update_button_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_update_button_session_inClassSession() {
        element.click("update_button_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void verify_cancel_button_session_inClassSession_is_present_on_page() {
        wait.wait_until_element_is_visible("cancel_button_session_inClassSession");
        verify.element_is_present("cancel_button_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_cancel_button_session_inClassSession() {
        element.click("cancel_button_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void verify_more_option_session_inClassSession_is_present_on_page() {
        wait.wait_until_element_is_visible("kebab_icon_option_session_inClassSession");
        verify.element_is_present("kebab_icon_option_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_more_option_session_inClassSession() {
        wait.wait_until_element_is_visible("kebab_icon_option_session_inClassSession");
        element.click("kebab_icon_option_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void verify_start_button_session_inClassSession_is_present_on_page() {
        wait.wait_until_element_is_visible("start_button_session_inClassSession");
        verify.element_is_present("start_button_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_start_button_session_inClassSession() {
        element.click("start_button_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void verify_cross_button_session_inClassSession_is_present_on_page() {
        wait.wait_until_element_is_visible("cross_button_session_inClassSession");
        verify.element_is_present("cross_button_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_cross_button_session_inClassSession() {
        element.click("cross_button_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void verify_in_class_session_inClassSession_is_present_on_page() {
        wait.wait_for_second(5);
        verify.element_is_present("in_class_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_in_class_session_inClassSession() {
        element.click("in_class_session_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void verify_add_employee_inClassSession_is_present_on_page() {
        wait.wait_for_second(5);
        verify.element_is_present("add_employee_inClassSession");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_add_employee_inClassSession() {
        element.click("add_employee_inClassSession");
    }
    @MethodsData(method_id = "button_1")
    public void verify_required_validation_message_display() {
        wait.wait_until_element_is_visible("session_name_required_validation_present");
        verify.element_is_present("supervisor_name_required_validation_present");
        //verify.element_is_present("data_required_validation_present");
    }
    @MethodsData(method_id = "button_1")
    public void click_on_add_employee_button_in_popup() {
        wait.wait_until_element_is_visible("add_employee_button_in_popup_present");
        element.click("add_employee_button_in_popup_present");
        wait.wait_for_second(3);
    }
    @MethodsData(method_id = "button_1")
    public void click_on_list_to_grid_converter_of_session_list() {
        wait.wait_until_element_is_visible("list_to_grid_converter");
        element.click("list_to_grid_converter");
    }
    @MethodsData(method_id = "button_1")
    public void click_on_forward_arrow_of_session_list() {
        wait.wait_until_element_is_visible("forward_icon_button");
        element.click("forward_icon_button");
    }
    @MethodsData(method_id = "button_1")
    public void verify_next_session_is_visible() {
        wait.wait_until_element_is_visible("move_to_left_forward");
        verify.element_is_present("move_to_left_forward");

    }
    @MethodsData(method_id = "button_1")
    public void click_on_backward_arrow_of_session_list() {
        wait.wait_until_element_is_visible("backward_icon_button");
        element.click("backward_icon_button");
    }
    @MethodsData(method_id = "button_1")
    public void verify_session_move_to_right_side() {
        wait.wait_until_element_is_visible("move_to_right_backward");
        verify.element_is_present("move_to_right_backward");

    }
    @MethodsData(method_id = "button_1")
    public void verify_riva_patel_employee_display(){
        wait.wait_until_element_is_visible("riva_patel_display");
        verify.element_is_present("riva_patel_display");
        element.click("riva_patel_display");
    }
    @MethodsData(method_id = "button_1")
    public void verify_zeel_patel_employee_display(){
        wait.wait_until_element_is_visible("zeel_patel_display");
        verify.element_is_present("zeel_patel_display");
        element.click("zeel_patel_display");
    }
    @MethodsData(method_id = "button_1")
    public void verify_selected_Employee_count(){
        wait.wait_until_element_is_visible("employee_count_display");
        verify.element_is_present("employee_count_display");

    }
    @MethodsData(method_id = "button_1")
    public void click_start_option(){
        wait.wait_until_element_is_visible("start_button_session_inClassSession");
        element.click("start_button_session_inClassSession");
    }
    @MethodsData(method_id = "button_1")
    public void verify_redirect_to_player_screen(){
        wait.wait_until_element_is_visible("view_full_screen_display");
        verify.element_is_present("view_full_screen_display");

    }
    @MethodsData(method_id = "button_1")
    public void verify_active_in_class_session_present_on_page(){
        wait.wait_until_element_is_visible("active_in_class_session_display");
        verify.element_is_present("active_in_class_session_display");

    }
    @MethodsData(method_id = "button_1")
    public void click_on_play_icon_available_on_active_card(){
        wait.wait_until_element_is_visible("play_active_in_class_session_button");
        element.click("play_active_in_class_session_button");
    }
    @MethodsData(method_id = "button_1")
    public void click_on_active_session_kebab_button(){
        wait.wait_until_element_is_visible("active_session_kebab_icon_option_inClassSession");
        element.click("active_session_kebab_icon_option_inClassSession");
    }
    @MethodsData(method_id = "button_1")
    public void verify_resume_option_present(){
        wait.wait_until_element_is_visible("resume_option_button");
        verify.element_is_present("resume_option_button");

    }
    @MethodsData(method_id = "button_1")
    public void verify_completed_option_present(){
        wait.wait_until_element_is_visible("completed_option_button");
        verify.element_is_present("completed_option_button");

    }
    @MethodsData(method_id = "button_1")
    public void click_on_resume_option(){
        wait.wait_until_element_is_visible("resume_option_button");
        element.click("resume_option_button");
    }
    @MethodsData(method_id = "button_1")
    public void click_on_completed_option(){
        wait.wait_until_element_is_visible("completed_option_button");
        element.click("completed_option_button");
    }
    @MethodsData(method_id = "button_1")
    public void verify_completed_session_popup_present(){
        wait.wait_until_element_is_visible("completed_session_popup_display");
        verify.element_is_present("completed_session_popup_display");

    }
    @MethodsData(method_id = "button_1")
    public void click_on_confirm_button(){
        wait.wait_until_element_is_visible("confirm_button_completed_session_popup");
        element.click("confirm_button_completed_session_popup");
    }
    @MethodsData(method_id = "button_1")
    public void verify_completed_session_display(){
        wait.wait_until_element_is_visible("completed_session_display");
        verify.element_is_present("completed_session_display");
    }
    @MethodsData(method_id = "button_1")
    public void click_on_cancel_button_in_completed_session_popup(){
        wait.wait_until_element_is_visible("cancel_button_completed_session_popup");
        element.click("cancel_button_completed_session_popup");
    }


}
