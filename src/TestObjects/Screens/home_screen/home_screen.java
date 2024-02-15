package Screens.home_screen;

import io.unity.core.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.automob.Device;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;

import org.openqa.selenium.WebDriver;

public class home_screen {

    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;

    Device device = null;

    public home_screen(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
       // device = new Device(driver);
    }

    @MethodsData(method_id = "button_1")
    public void verify_Notification_bottom_button_is_present_on_page() {
        verify.element_is_present("Notification_bottom_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_Notification_tab_button_is_present_on_page() {
        verify.element_is_present("Notification_tab_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_Notification_tab_button() {
        element.click("Notification_tab_button");
    }

    @MethodsData(method_id = "button_2")
    public void verify_Notification_bottom_button_is_clickable() {
        verify.element_is_enable("Notification_bottom_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_Notification_bottom_button() {
        element.click("Notification_bottom_button");
    }

    @MethodsData(method_id = "button_4")
    public void Verify_Notification_bottom_button_text_is_equal_to(String button_text) {
        verify.element_text_is_equal_to("Notification_bottom_button", button_text);
    }

    @MethodsData(method_id = "button_1")
    public void verify_search_bottom_button_is_present_on_page() {
        verify.element_is_present("search_bottom_button");
    }

    @MethodsData(method_id = "button_2")
    public void verify_search_bottom_button_is_clickable() {
        verify.element_is_enable("search_bottom_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_search_bottom_button() {
        element.click("search_bottom_button");
    }

    @MethodsData(method_id = "button_4")
    public void Verify_search_bottom_button_text_is_equal_to(String button_text) {
        verify.element_text_is_equal_to("search_bottom_button", button_text);
    }

    @MethodsData(method_id = "button_1")
    public void verify_Bookmarks_bottom_button_is_present_on_page() {
        verify.element_is_present("Bookmarks_bottom_button");
    }

    @MethodsData(method_id = "button_1")
    public void verify_Bookmarks_tab_button_is_present_on_page() {
        verify.element_is_present("Bookmarks_Tab");
    }

    @MethodsData(method_id = "button_1")
    public void click_on_Bookmarks_tab_button() {
        element.click("Bookmarks_Tab");
    }

    @MethodsData(method_id = "button_2")
    public void verify_Bookmarks_bottom_button_is_clickable() {
        verify.element_is_enable("Bookmarks_bottom_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_Bookmarks_bottom_button() {
        element.click("Bookmarks_bottom_button");
    }

    @MethodsData(method_id = "button_4")
    public void Verify_Bookmarks_bottom_button_text_is_equal_to(String button_text) {
        verify.element_text_is_equal_to("Bookmarks_bottom_button", button_text);
    }

    @MethodsData(method_id = "button_1")
    public void verify_home_bottom_button_is_present_on_page() {
        wait.wait_until_element_is_visible("home_bottom_button");
        wait.wait_for_second(5);
        verify.element_is_present("home_bottom_button");
    }

    @MethodsData(method_id = "button_2")
    public void verify_home_bottom_button_is_clickable() {
        verify.element_is_enable("home_bottom_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_home_bottom_button() {
        element.click("home_bottom_button");
    }

    @MethodsData(method_id = "button_4")
    public void Verify_home_bottom_button_text_is_equal_to(String button_text) {
        verify.element_text_is_equal_to("home_bottom_button", button_text);
    }

    @MethodsData(method_id = "button_1")
    public void verify_assign_program_text_is_present_on_page() {
        wait.wait_for_second(10);
        verify.element_is_present("assign_program_text");
    }

    @MethodsData(method_id = "button_1")
    public void verify_profile_icon_is_present_on_page() {
        wait.wait_for_second(5);
        wait.wait_until_element_is_visible("profile_icon");
        verify.element_is_present("profile_icon");
    }

    @MethodsData(method_id = "button_2")
    public void verify_profile_icon_is_clickable() {
        verify.element_is_enable("profile_icon");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_profile_icon() {
        try {
            wait.wait_for_second(15);
            wait.wait_until_element_is_visible("profile_icon");
            element.click("profile_icon");
        } catch (Exception e) {
        }
    }

    @MethodsData(method_id = "button_1")
    public void verify_home_back_button_is_present_on_page() {
        wait.wait_until_element_is_visible("home_back_button");
        verify.element_is_present("home_back_button");
    }

    @MethodsData(method_id = "button_2")
    public void verify_home_back_button_is_clickable() {
        verify.element_is_enable("home_back_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_home_back_button() {
        wait.wait_until_element_is_visible("home_back_button");
        wait.wait_for_second(5);
        element.click("home_back_button");
    }

    @MethodsData(method_id =  "button_4")
    public void verify_Bookmarks_bottom_button_is_selected()
    {
        verify.element_is_enable("Bookmarks_bottom_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_home_page_video_button() {
        wait.wait_for_second(10);
        wait.wait_until_element_is_visible("home_page_video");
        element.click("home_page_video");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_play_video_button() {
        wait.wait_until_element_is_visible("play_video_button");
        element.click("play_video_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_bookmarks_icon_button() {
        wait.wait_until_element_is_visible("bookmarks_icon");
        element.click("bookmarks_icon");
    }

    @MethodsData(method_id =  "button_4")
    public void verify_search_bottom_button_is_selected()
    {    wait.wait_until_element_is_visible("search_bottom_button");
        verify.element_is_selected("search_bottom_button");
    }

    @MethodsData(method_id =  "button_4")
    public void verify_change_Agency_button_is_displayed()
    {   wait.wait_for_second(4);
        wait.wait_until_element_is_visible("change_Agency");
        verify.element_is_present("change_Agency");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_change_Agency() {
        element.click("change_Agency");
    }

    @MethodsData(method_id =  "button_4")
    public void verify_test_Agency_option_button_is_displayed()
    {  wait.wait_until_element_is_visible("test_Agency_option");
        verify.element_is_present("test_Agency_option");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_test_Agency_option() {
        element.click("test_Agency_option");
    }

    @MethodsData(method_id =  "button_4")
    public void verify_QA_team_Agency_option_button_is_displayed()
    {  wait.wait_for_second(5);
        verify.element_is_present("QA_team_Agency_option");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_QA_team_Agency_option() {
        element.click("QA_team_Agency_option");
    }

    @MethodsData(method_id =  "button_4")
    public void verify_test_Agency_button_button_is_displayed()
    {  wait.wait_until_element_is_visible("test_Agency_button");
        verify.element_is_present("test_Agency_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_home_tab_button() {
        wait.wait_for_second(2);
        element.click("Home_Tab");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_test_Agency_button() {
        element.click("test_Agency_button");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_first_video_of_6m() {
        element.click("first_video_of_6m");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_ok_button() {
        wait.wait_for_second(2);
        element.click("ok_button");
    }

    @MethodsData(method_id = "button_3")
    public void scrollDownAtHomePage() {
       //element.perform_scroll_by_amount( 5, 8);
    }

    @MethodsData(method_id =  "button_4")
    public void verify_change_Agency_with_no_button_is_displayed()
    {  wait.wait_until_element_is_visible("change_Agency_with_no");
        verify.element_is_present("change_Agency_with_no");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_change_Agency_with_no() {
        element.click("change_Agency_with_no");
    }

    @MethodsData(method_id =  "button_4")
    public void verify_change_Agency_with_no_view_text_is_displayed()
    {  wait.wait_until_element_is_visible("change_Agency_with_no_view_text");
        verify.element_is_present("change_Agency_with_no_view_text");
    }

    @MethodsData(method_id = "button_3")
    public void click_on_change_Agency_with_no_view_text() {
        element.click("change_Agency_with_no_view_text");
    }

    @MethodsData(method_id =  "button_4")
    public void verify_alert_msg_when_no_program_is_assign_is_displayed()
    {  wait.wait_until_element_is_visible("alert_msg_when_npo_program_is_assign");
        verify.element_is_present("alert_msg_when_npo_program_is_assign");
    }


}