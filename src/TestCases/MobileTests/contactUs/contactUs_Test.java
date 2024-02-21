package TestCases.MobileTests.contactUs;



import Framework.java.io.unity.core.remotegrid.LambdaTestConfig;
import io.appium.java_client.android.AndroidDriver;
import Framework.java.io.unity.core.init.base;
import Screens.contactUs_Screen.contactus_page;
import Screens.help_Screen.help_page;
import Screens.home_screen.home_screen;
import Screens.login.login_screen;
import org.testng.annotations.Test;
import utility.Logger;

import java.time.Duration;

public class contactUs_Test extends base {

    @Test()
    public void To_verify_that_when_Tap_on_contact_us_icon_it_open_contact_us_page_for_caregivers()
    {
        Logger.log_qase_id("TC_HP_020");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_that_when_Tap_on_contact_us_icon_it_open_contact_us_page_for_caregivers");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        contactus_page contactus_page = new contactus_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_home_page_video_button();
        home_screen.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
        contactus_page.click_on_contactUs_icon_button();
        contactus_page.verify_contactUs_Page_Header_is_present_on_page();

    }

    @Test()
    public void To_verify_when_user_click_on_FAQ_link_it_opens_help_page()
    {
        Logger.log_qase_id("TC_HP_021");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_user_click_on_FAQ_link_it_opens_help_page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        contactus_page contactus_page = new contactus_page(driver);
        help_page help_page = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_home_page_video_button();
        home_screen.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
        contactus_page.click_on_contactUs_icon_button();
        contactus_page.verify_contactUs_Page_Header_is_present_on_page();
        contactus_page.verify_faq_button_is_present_on_page();
        contactus_page.click_on_faq_button();
        help_page.verify_go_to_how_can_we_help_you_text_is_present_on_page();

    }

    @Test()
    public void User_should_be_able_to_navigate_back_by_clicking_on_back_button()
    {
        Logger.log_qase_id("TC_HP_022");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("User_should_be_able_to_navigate_back_by_clicking_on_back_button");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        contactus_page contactus_page = new contactus_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_home_page_video_button();
        home_screen.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
        contactus_page.click_on_contactUs_icon_button();
        contactus_page.verify_contactUs_Page_Header_is_present_on_page();
        contactus_page.click_on_back_button();
        home_screen.click_on_play_video_button();

    }

    @Test()
    public void To_verify_User_should_be_able_to_select_values_from_the_dropdown()
    {
        Logger.log_qase_id("TC_HP_023");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_User_should_be_able_to_select_values_from_the_dropdown");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        contactus_page contactus_page = new contactus_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_home_page_video_button();
        home_screen.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
        contactus_page.click_on_contactUs_icon_button();
        contactus_page.verify_contactUs_Page_Header_is_present_on_page();
        contactus_page.verify_select_topic_dropdown_is_present_on_page();
        contactus_page.click_on_select_topic_dropdown();
        contactus_page.verify_the_lesson_is_frozen_is_present_on_page();
        contactus_page.verify_complete_the_program_is_present_on_page();
        contactus_page.verify_something_else_is_present_on_page();
        contactus_page.verify_lesson_material_is_present_on_page();
        contactus_page.click_on_something_else();
        contactus_page.verify_something_else_is_present_on_page();
    }

    @Test()
    public void To_verify_user_is_able_to_submit_the_query_without_entering_any_data()
    {
        Logger.log_qase_id("TC_HP_025");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_submit_the_query_without_entering_any_data");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        contactus_page contactus_page = new contactus_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_home_page_video_button();
        home_screen.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
        contactus_page.click_on_contactUs_icon_button();
        contactus_page.verify_contactUs_Page_Header_is_present_on_page();
        contactus_page.click_on_submitButton();
        contactus_page.verify_select_topic_error_alert_is_present_on_page();
        contactus_page.verify_describe_your_problem_is_present_on_page();
    }

    @Test()
    public void To_verify_user_is_not_able_to_submit_query_without_selecting_topic()
    {
        Logger.log_qase_id("TC_HP_026");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_not_able_to_submit_query_without_selecting_topic");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        contactus_page contactus_page = new contactus_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_home_page_video_button();
        home_screen.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
        contactus_page.click_on_contactUs_icon_button();
        contactus_page.verify_contactUs_Page_Header_is_present_on_page();
        contactus_page.verify_select_topic_dropdown_is_present_on_page();
        contactus_page.click_on_select_topic_dropdown();
        contactus_page.verify_something_else_is_present_on_page();
        contactus_page.click_on_something_else();
        contactus_page.verify_something_else_is_present_on_page();
        contactus_page.click_on_submitButton();
        contactus_page.verify_describe_your_problem_is_present_on_page();
    }

    @Test()
    public void To_verify_user_is_not_able_to_submit_query_without_entering_description()
    {
        Logger.log_qase_id("TC_HP_027");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_not_able_to_submit_query_without_entering_description");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        contactus_page contactus_page = new contactus_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_home_page_video_button();
        home_screen.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
        contactus_page.click_on_contactUs_icon_button();
        contactus_page.verify_contactUs_Page_Header_is_present_on_page();
        contactus_page.click_on_submitButton();
        contactus_page.verify_select_topic_error_alert_is_present_on_page();
        contactus_page.verify_describe_your_problem_is_present_on_page();
    }

    @Test()
    public void To_verify_user_is_able_to_submit_query_without_attaching_file()
    {
        Logger.log_qase_id("TC_HP_028");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_submit_query_without_attaching_file");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        contactus_page contactus_page = new contactus_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_home_page_video_button();
        home_screen.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
        contactus_page.click_on_contactUs_icon_button();
        contactus_page.verify_contactUs_Page_Header_is_present_on_page();
        contactus_page.verify_select_topic_dropdown_is_present_on_page();
        contactus_page.click_on_select_topic_dropdown();
        contactus_page.verify_something_else_is_present_on_page();
        contactus_page.click_on_something_else();
        contactus_page.verify_something_else_is_present_on_page();
        contactus_page.enter_text_at_describe_your_problem_textBox("Automation Script");
        ((AndroidDriver)driver).hideKeyboard();
        contactus_page.click_on_submitButton();
        contactus_page.verify_request_sent_is_present_on_page();
        contactus_page.verify_message_sent_successfully_is_present_on_page();
        contactus_page.click_on_ok_button();
    }

    @Test()
    public void To_verify_user_that_when_user_click_on_OK_button_it_redirects_to_lesson()
    {
        Logger.log_qase_id("TC_HP_029");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_that_when_user_click_on_OK_button_it_redirects_to_lesson");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        contactus_page contactus_page = new contactus_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_home_page_video_button();
        home_screen.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
        contactus_page.click_on_contactUs_icon_button();
        contactus_page.verify_contactUs_Page_Header_is_present_on_page();
        contactus_page.verify_select_topic_dropdown_is_present_on_page();
        contactus_page.click_on_select_topic_dropdown();
        contactus_page.verify_something_else_is_present_on_page();
        contactus_page.click_on_something_else();
        contactus_page.verify_something_else_is_present_on_page();
        contactus_page.enter_text_at_describe_your_problem_textBox("Automation Script");
        contactus_page.click_on_submitButton();
        contactus_page.verify_request_sent_is_present_on_page();
        contactus_page.verify_message_sent_successfully_is_present_on_page();
        contactus_page.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
    }

    @Test()
    public void To_verify_user_is_able_to_submit_query_with_adding_all_the_data()
    {
        Logger.log_qase_id("TC_HP_030");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_submit_query_with_adding_all_the_data");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        contactus_page contactus_page = new contactus_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_home_page_video_button();
        home_screen.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
        contactus_page.click_on_contactUs_icon_button();
        contactus_page.verify_contactUs_Page_Header_is_present_on_page();
        contactus_page.verify_select_topic_dropdown_is_present_on_page();
        contactus_page.click_on_select_topic_dropdown();
        contactus_page.verify_something_else_is_present_on_page();
        contactus_page.click_on_something_else();
        contactus_page.verify_something_else_is_present_on_page();
        contactus_page.enter_text_at_describe_your_problem_textBox("Automation Script");
        ((AndroidDriver)driver).hideKeyboard();
        contactus_page.click_on_submitButton();
        contactus_page.verify_request_sent_is_present_on_page();
        contactus_page.verify_message_sent_successfully_is_present_on_page();
        contactus_page.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
    }


}
