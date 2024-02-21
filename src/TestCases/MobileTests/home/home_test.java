package TestCases.MobileTests.home;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.remotegrid.LambdaTestConfig;
import Screens.Notification_Page.notification_Page;
import Screens.bookmarks.bookmarks;
import Screens.contactUs_Screen.contactus_page;
import Screens.home_screen.home_screen;
import Screens.login.login_screen;
import org.testng.annotations.Test;
import utility.Logger;

import java.time.Duration;

public class home_test extends base {

    @Test()
    public void To_verify_user_can_see_program_and_modules_if_CS_assigns_program() {
        Logger.log_qase_id("TC_HP_001");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_can_see_program_and_modules_if_CS_assigns_program");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        contactus_page contactus_page = new contactus_page(driver);
        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_first_video_of_6m();
        home_screen.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
        contactus_page.click_on_back_button();
        home_screen.verify_change_Agency_button_is_displayed();
    }

    @Test()
    public void To_verify_circular_progress_bar_shows_the_progress_of_the_overall_program()
    {
        Logger.log_qase_id("TC_HP_002");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_circular_progress_bar_shows_the_progress_of_the_overall_program");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_home_page_video_button();
        home_screen.click_on_ok_button();
        home_screen.click_on_play_video_button();

    }



    @Test()
    public void To_verify_user_is_able_to_go_back_by_clicking_on_back_navigation_button() {
        Logger.log_qase_id("TC_HP_003");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_go_back_by_clicking_on_back_navigation_button");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        contactus_page contactus_page = new contactus_page(driver);
        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_first_video_of_6m();
        home_screen.click_on_ok_button();
        contactus_page.verify_contactUs_icon_is_present_on_page();
        contactus_page.click_on_back_button();
        home_screen.verify_change_Agency_button_is_displayed();
    }
    @Test()
    public void To_verify_user_can_change_agencies_from_dropdown_at_the_upper_right_side()
    {
        Logger.log_qase_id("TC_HP_004");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_can_change_agencies_from_dropdown_at_the_upper_right_side");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);

        login_screen.performLoginOnMobileApp("4638746387","QA_12345");

        home_screen.verify_change_Agency_with_no_button_is_displayed();
        home_screen.click_on_change_Agency_with_no();
        home_screen.verify_test_Agency_option_button_is_displayed();
        home_screen.click_on_test_Agency_option();
        home_screen.verify_test_Agency_button_button_is_displayed();
        home_screen.click_on_test_Agency_button();
        home_screen.verify_change_Agency_with_no_view_text_is_displayed();
        home_screen.click_on_change_Agency_with_no_view_text();
    }

    @Test()
    public void To_verify_if_no_program_is_assigned_to_user_then_message_is_shown_at_home_screen() {
        Logger.log_qase_id("TC_HP_011");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_if_no_program_is_assigned_to_user_then_message_is_shown_at_home_screen");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);

        login_screen.performLoginOnMobileApp("4638746387","QA_12345");
        home_screen.verify_alert_msg_when_no_program_is_assign_is_displayed();

    }

    @Test()
    public void To_verify_user_is_able_to_refresh_the_home_page() {
        Logger.log_qase_id("TC_HP_014");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_refresh_the_home_page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.scrollDownAtHomePage();

    }

    @Test()
    public void To_verify_CG_can_change_agency_from_notification_page() {
        Logger.log_qase_id("TC_HP_015");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_CG_can_change_agency_from_notification_page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        notification_Page notification_Page = new notification_Page(driver);

        login_screen.performLoginOnMobileApp("4638746387", "QA_12345");

        home_screen.verify_change_Agency_with_no_button_is_displayed();
        home_screen.verify_Notification_tab_button_is_present_on_page();
        home_screen.click_on_Notification_tab_button();
        notification_Page.verify_Notification_Text_is_present_on_page();
        home_screen.verify_change_Agency_with_no_button_is_displayed();
        home_screen.click_on_change_Agency_with_no();
        home_screen.verify_test_Agency_option_button_is_displayed();
        home_screen.click_on_test_Agency_option();
        home_screen.click_on_home_tab_button();
        home_screen.verify_test_Agency_button_button_is_displayed();
        home_screen.click_on_test_Agency_button();
        home_screen.verify_change_Agency_with_no_view_text_is_displayed();
        home_screen.click_on_change_Agency_with_no_view_text();
    }

    @Test()
    public void To_verify_CG_can_change_agency_from_bookmark_page() {
        Logger.log_qase_id("TC_HP_016");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_CG_can_change_agency_from_bookmark_page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        bookmarks bookmark = new bookmarks(driver);

        login_screen.performLoginOnMobileApp("4638746387", "QA_12345");

        home_screen.verify_change_Agency_with_no_button_is_displayed();
        home_screen.verify_Bookmarks_tab_button_is_present_on_page();
        home_screen.click_on_Bookmarks_tab_button();
        bookmark.verify_bookmark_video_in_bookmark_screen_is_displayed();
        home_screen.verify_change_Agency_with_no_button_is_displayed();
        home_screen.click_on_change_Agency_with_no();
        home_screen.verify_test_Agency_option_button_is_displayed();
        home_screen.click_on_test_Agency_option();
        home_screen.click_on_home_tab_button();
        home_screen.verify_test_Agency_button_button_is_displayed();
    }


}
