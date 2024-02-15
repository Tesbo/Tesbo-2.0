package MobileTests.profile_tests;

import io.appium.java_client.android.AndroidDriver;
import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import Screens.home_screen.home_screen;
import Screens.login.login_screen;
import Screens.profile_page.profile_page;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;

import java.time.Duration;

public class profile_test extends base {
    @DataProvider(name = "mobile_user_login")
    public Object[][] data_provider() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("mobile_user_cred.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "mobile_user_login")
   public void verify_that_user_is_able_to_see_profile_details_at_profile_option(String username,String password,String programName) {

        Logger.log_qase_id("NP-44");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_that_user_is_able_to_see_profile_details_at_profile_option");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.click_on_profile_icon();

        profile.verify_profile_tab_is_present_on_page();
        profile.verify_language_tab_button_present_on_page();
        profile.verify_profile_help_button_is_present_on_page();
        profile.verify_logout_btn_is_present_on_page();
        profile.click_on_profile_tab();
        profile.verify_first_name_text_box_is_present_on_page();

    }

    @Test
    public void verify_user_is_able_to_navigate_back_by_clicking_on_back_button()
    {
        Logger.log_qase_id("NP-138");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_user_is_able_to_navigate_back_by_clicking_on_back_button");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_back_button();

        home_screen.verify_home_bottom_button_is_present_on_page();

    }

    @Test
    public void To_verify_user_is_able_to_save_profile_by_keeping_first_name_as_blank()
    {
        Logger.log_qase_id("NP-46");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_save_profile_by_keeping_first_name_as_blank");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_first_name_text_box_is_present_on_page();
        profile_page.click_on_first_name_text_box();
        profile_page.clear_first_name_text_box();
        ((AndroidDriver)driver).hideKeyboard();
        profile_page.verify_save_button_is_present_on_page();
        profile_page.click_on_save_button();
        profile_page.verify_first_name_error_alert_is_present_on_page();
    }

    @Test
    public void To_verify_user_is_able_to_save_profile_by_keeping_last_name_as_blank()
    {
        Logger.log_qase_id("NP-47");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_save_profile_by_keeping_last_name_as_blank");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.click_on_last_name_text_box();
        profile_page.clear_last_name_text_box();
        ((AndroidDriver)driver).hideKeyboard();
        profile_page.verify_save_button_is_present_on_page();
        profile_page.click_on_save_button();
        profile_page.verify_last_name_error_alert_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_is_able_to_save_first_name_and_last_name_by_entering_spaces(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-48");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_save_first_name_and_last_name_by_entering_spaces");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_first_name_text_box_is_present_on_page();
        profile_page.click_on_first_name_text_box();
        profile_page.clear_first_name_text_box();
        profile_page.enter_text_in_first_name_text_box("  ");
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.click_on_last_name_text_box();
        profile_page.clear_last_name_text_box();
        profile_page.enter_text_in_last_name_text_box("  ");
        ((AndroidDriver)driver).hideKeyboard();
        profile_page.verify_save_button_is_present_on_page();
        profile_page.click_on_save_button();
        profile_page.verify_first_name_error_alert_is_present_on_page();
        profile_page.verify_last_name_error_alert_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_is_able_to_see_cancel_and_save_button_after_editing_anything_in_the_profile_details(String username,String password,String programName) {
        Logger.log_qase_id("NP-49");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_see_cancel_and_save_button_after_editing_anything_in_the_profile_details");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_first_name_text_box_is_present_on_page();
        profile_page.click_on_first_name_text_box();
        profile_page.clear_first_name_text_box();
        profile_page.enter_text_in_first_name_text_box("Automation");
        ((AndroidDriver)driver).hideKeyboard();
        profile_page.click_on_cancel_button();
        profile_page.verify_profile_user_name_text_is_present_on_page();

    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_that_user_is_able_to_cancel_the_changes_in_profile_by_clicking_on_cancel_button(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-50");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_that_user_is_able_to_cancel_the_changes_in_profile_by_clicking_on_cancel_button");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_first_name_text_box_is_present_on_page();
        profile_page.click_on_first_name_text_box();
        profile_page.clear_first_name_text_box();
        profile_page.enter_text_in_first_name_text_box("Automation");
        ((AndroidDriver)driver).hideKeyboard();
        profile_page.verify_cancel_button_is_present_on_page();
        profile_page.click_on_cancel_button();
        profile_page.verify_profile_user_name_text_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_can_save_first_name_by_entering_spaces(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-951");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_can_save_first_name_by_entering_spaces");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_first_name_text_box_is_present_on_page();
        profile_page.click_on_first_name_text_box();
        profile_page.clear_first_name_text_box();
        ((AndroidDriver)driver).hideKeyboard();
        profile_page.verify_save_button_is_present_on_page();
        profile_page.click_on_save_button();
        profile_page.verify_first_name_error_alert_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_can_save_last_name_by_entering_spaces(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-952");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_can_save_last_name_by_entering_spaces");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.click_on_last_name_text_box();
        profile_page.clear_last_name_text_box();
        ((AndroidDriver)driver).hideKeyboard();
        profile_page.verify_save_button_is_present_on_page();
        profile_page.click_on_save_button();
        profile_page.verify_last_name_error_alert_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_is_able_to_navigate_back_by_clicking_on_back_button(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-137");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_navigate_back_by_clicking_on_back_button");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_first_name_text_box_is_present_on_page();
        profile_page.click_on_back_button();
        profile_page.verify_profile_user_name_text_is_present_on_page();

    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_when_tap_on_cancel_button_profile_screen(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-307");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_tap_on_cancel_button_profile_screen");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_first_name_text_box_is_present_on_page();
        profile_page.click_on_first_name_text_box();
        profile_page.clear_first_name_text_box();
        profile_page.enter_text_in_first_name_text_box("Automation");
        ((AndroidDriver)driver).hideKeyboard();
        profile_page.verify_cancel_button_is_present_on_page();
        profile_page.click_on_cancel_button();
        profile_page.verify_profile_user_name_text_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_when_tap_on_save_button_profile_screen(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-308");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_tap_on_save_button_profile_screen");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.click_on_last_name_text_box();
        profile_page.clear_last_name_text_box();
        ((AndroidDriver)driver).hideKeyboard();
        profile_page.verify_save_button_is_present_on_page();
        profile_page.click_on_save_button();
        profile_page.verify_last_name_error_alert_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_when_click_on_Delete_Profile_button_redirect_to_Profile_Detail_screen(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-312");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_click_on_Delete_Profile_button_redirect_to_Profile_Detail_screen");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_delete_profile_button_is_present_on_page();
        profile_page.click_on_delete_profile_button_popup();
        profile_page.verify_caregiver_employer_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_Not_Verified_tool_tip_is_display_below_mail_text_box(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-313");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_Not_Verified_tool_tip_is_display_below_mail_text_box");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_email_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_Not_Verified_tool_tip_is_display_below_phone_number_text_box(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-314");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_Not_Verified_tool_tip_is_display_below_phone_number_text_box");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_phone_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_when_you_click_on_email_Not_verified_tool_tip_it_opens_a_pop_up(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-315");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_you_click_on_email_Not_verified_tool_tip_it_opens_a_pop_up");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_phone_is_present_on_page();
        profile_page.click_on_not_verified_email();
//        profile_page.verify_verify_button_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_when_you_click_on_phone_number_Not_verified_tool_tip_it_opens_a_pop_up(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-316");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_you_click_on_phone_number_Not_verified_tool_tip_it_opens_a_pop_up");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_phone_is_present_on_page();
        profile_page.click_on_not_verified_phone();
//        profile_page.verify_verify_button_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_header_enter_code_text_box_and_verify_button_is_displayed_on_the_Not_verified_Email_pop_up(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-317");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_header_enter_code_text_box_and_verify_button_is_displayed_on_the_Not_verified_Email_pop_up");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_phone_is_present_on_page();
        profile_page.click_on_not_verified_email();
//        profile_page.verify_verify_button_is_present_on_page();
    }
    @Test(dataProvider = "mobile_user_login")
    public void To_verify_header_enter_code_text_box_and_verify_button_is_displayed_on_the_Not_verified_Phone_number_pop_up(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-318");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_header_enter_code_text_box_and_verify_button_is_displayed_on_the_Not_verified_Phone_number_pop_up");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_phone_is_present_on_page();
        profile_page.click_on_not_verified_phone();
//        profile_page.verify_verify_button_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_when_you_click_on_Cancel_button_of_Not_Verified_Email_Pop_Up_it_navigate_to_profile_screen(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-319");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_you_click_on_Cancel_button_of_Not_Verified_Email_Pop_Up_it_navigate_to_profile_screen");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_email_is_present_on_page();
        profile_page.click_on_not_verified_email();
//        profile_page.verify_cancel_button_verify_popup_is_present_on_page();
//        profile_page.verify_last_name_text_box_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_when_you_click_on_Cancel_button_of_Not_Verified_Phone_Number_Pop_Up_it_navigate_to_profile_screen(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-320");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_you_click_on_Cancel_button_of_Not_Verified_Phone_Number_Pop_Up_it_navigate_to_profile_screen");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_phone_is_present_on_page();
        profile_page.click_on_not_verified_phone();
//        profile_page.verify_cancel_button_verify_popup_is_present_on_page();
//        profile_page.verify_last_name_text_box_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_get_alert_message_if_you_click_on_verify_button_without_entering_the_verification_code_for_email(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-321");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_get_alert_message_if_you_click_on_verify_button_without_entering_the_verification_code_for_email");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_phone_is_present_on_page();
        profile_page.click_on_not_verified_email();
//        profile_page.verify_verify_button_is_present_on_page();
//        profile_page.verify_please_enter_code_alert_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_get_alert_message_if_you_click_on_verify_button_without_entering_the_verification_code_for_phone_number(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-322");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_get_alert_message_if_you_click_on_verify_button_without_entering_the_verification_code_for_phone_number");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_phone_is_present_on_page();
        profile_page.click_on_not_verified_phone();
//        profile_page.verify_verify_button_is_present_on_page();
//        profile_page.verify_please_enter_code_alert_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_if_user_enter_wrong_verification_code_get_alert_popup_Verification_code_does_not_match_for_the_email_text_box(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-326");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_if_user_enter_wrong_verification_code_get_alert_popup_Verification_code_does_not_match_for_the_email_text_box");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_email_is_present_on_page();
        profile_page.click_on_not_verified_email();
//        profile_page.verify_verify_button_is_present_on_page();
//        // code to enter the verification code
//        profile_page.click_on_verify_button();
//        profile_page.verify_verification_code_not_match_alert_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_if_user_enter_wrong_verification_code_get_alert_popup_Verification_code_does_not_match_for_the_Phone_text_box(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-327");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_if_user_enter_wrong_verification_code_get_alert_popup_Verification_code_does_not_match_for_the_Phone_text_box");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_phone_is_present_on_page();
        profile_page.click_on_not_verified_phone();
//        profile_page.verify_verify_button_is_present_on_page();
//        // code to enter the verification code
//        profile_page.click_on_verify_button();
//        profile_page.verify_verification_code_not_match_alert_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_when_user_click_on_OK_button_of_the_code_does_match_alert_the_popup_gets_closed_and_redirected_to_verify_Email_screen(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-327");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_user_click_on_OK_button_of_the_code_does_match_alert_the_popup_gets_closed_and_redirected_to_verify_Email_screen");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_email_is_present_on_page();
        profile_page.click_on_not_verified_email();
//        profile_page.verify_verify_button_is_present_on_page();
//        // code to enter the verification code
//        profile_page.click_on_verify_button();
//        profile_page.verify_verification_code_not_match_alert_is_present_on_page();
//        profile_page.click_on_ok_button_verification_code_not_match_alert();
//        profile_page.verify_verify_button_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_when_user_click_on_OK_button_of_the_code_does_match_alert_the_popup_gets_closed_and_redirected_to_verify_Phone_number_screen(String username,String password,String programName)
    {
        Logger.log_qase_id("FA-328");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_user_click_on_OK_button_of_the_code_does_match_alert_the_popup_gets_closed_and_redirected_to_verify_Phone_number_screen");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.verify_not_verified_phone_is_present_on_page();
        profile_page.click_on_not_verified_phone();
//        profile_page.verify_verify_button_is_present_on_page();
//        // code to enter the verification code
//        profile_page.click_on_verify_button();
//        profile_page.verify_verification_code_not_match_alert_is_present_on_page();
//        profile_page.click_on_ok_button_verification_code_not_match_alert();
//        profile_page.verify_verify_button_is_present_on_page();

    }


    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_is_able_to_change_first_name_and_last_name(String username,String password,String programName) {
        Logger.log_qase_id("TC_PR_003");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_change_first_name_and_last_name");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");


        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();

        int maxAttempts = 2;
        int attempts = 0;
        boolean saveButtonNotDisplayed = true;

        while (attempts < maxAttempts && saveButtonNotDisplayed) {
            profile_page.verify_first_name_text_box_is_present_on_page();
            profile_page.click_on_first_name_text_box();
            profile_page.clear_first_name_text_box();
            profile_page.enter_text_in_first_name_text_box("QA");
            ((AndroidDriver)driver).hideKeyboard();

            profile_page.verify_last_name_text_box_is_present_on_page();
            profile_page.click_on_last_name_text_box();
            profile_page.clear_last_name_text_box();
            profile_page.enter_text_in_last_name_text_box("Automation");
            ((AndroidDriver)driver).hideKeyboard();

            profile_page.verify_save_button_is_displayed_on_page();

            saveButtonNotDisplayed = !profile_page.verify_save_button_is_displayed_on_page();

            if (saveButtonNotDisplayed) {
                profile_page.click_on_back_button_on_profile_page();
            }
            attempts++;
        }

        profile_page.click_on_save_button();
        profile_page.verify_profile_updated_successfully_msg_is_present_on_page();
        profile_page.click_on_ok_button();
        profile_page.click_on_profile_tab();
        profile_page.verify_first_name_text_box_is_present_on_page();
        profile_page.click_on_first_name_text_box();
        profile_page.clear_first_name_text_box();
        profile_page.enter_text_in_first_name_text_box("Mobile");
        ((AndroidDriver)driver).hideKeyboard();

        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.click_on_last_name_text_box();
        profile_page.clear_last_name_text_box();
        profile_page.enter_text_in_last_name_text_box("Testing");
        ((AndroidDriver)driver).hideKeyboard();

        profile_page.verify_save_button_is_displayed_on_page();
        profile_page.click_on_save_button();
        profile_page.verify_profile_updated_successfully_msg_is_present_on_page();
        profile_page.click_on_ok_button();
        profile_page.verify_profile_user_name_text_is_present_on_page();

    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_is_able_not_to_save_profile_by_keeping_first_name_as_blank(String username,String password,String programName)
    {
        Logger.log_qase_id("TC_PR_004");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_not_to_save_profile_by_keeping_first_name_as_blank");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_first_name_text_box_is_present_on_page();
        profile_page.click_on_first_name_text_box();
        profile_page.clear_first_name_text_box();
        ((AndroidDriver)driver).hideKeyboard();
        profile_page.verify_save_button_is_present_on_page();
        profile_page.click_on_save_button();
        profile_page.verify_first_name_error_alert_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_is_able_not_to_save_profile_by_keeping_last_name_as_blank(String username,String password,String programName)
    {
        Logger.log_qase_id("TC_PR_005");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_not_to_save_profile_by_keeping_last_name_as_blank");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_last_name_text_box_is_present_on_page();
        profile_page.click_on_last_name_text_box();
        profile_page.clear_last_name_text_box();
        ((AndroidDriver)driver).hideKeyboard();
        profile_page.verify_save_button_is_present_on_page();
        profile_page.click_on_save_button();
        profile_page.verify_last_name_error_alert_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_is_able_to_change_email(String username,String password,String programName) {
        Logger.log_qase_id("TC_PR_009");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_change_email");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_email_id_profile_page_is_present_on_page();
     // profile_page.clear_and_enter_email_id_profile_page("mob123@yopmail.com");
    //    profile_page.enter_text_in_email_id_profile_page("mob123@yopmail.com");
     //   ((AndroidDriver) driver).hideKeyboard();
     // profile_page.verify_save_button_is_present_on_page();
//        profile_page.click_on_save_button();
//        profile_page.verify_profile_updated_successfully_msg_is_present_on_page();
//        profile_page.click_on_ok_button();

//        profile_page.click_on_profile_tab();
//        profile_page.verify_email_id_profile_page_is_present_on_page();
//        profile_page.click_on_email_id_profile_page();
//        profile_page.clear_email_id_profile_page();
//        profile_page.enter_text_in_eTo_verify_Delete_Profile_buttonail_id_profile_page("mob@yopmail.com");
//        ((AndroidDriver) driver).hideKeyboard();
//        profile_page.verify_save_button_is_present_on_page();
//        profile_page.click_on_save_button();
//        profile_page.verify_profile_updated_successfully_msg_is_present_on_page();
//        profile_page.click_on_ok_button();
    }

    @Test
    public void To_verify_Delete_Profile_button() {

        Logger.log_qase_id("TC_PR_041");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_Delete_Profile_button");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        profile_page profile_page = new profile_page(driver);
        home_screen home_screen = new home_screen(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile_page.click_on_profile_tab();
        profile_page.verify_email_id_profile_page_is_present_on_page();
        profile_page.verify_delete_profile_button_is_present_on_page();
        profile_page.click_on_delete_profile_button_popup();
        profile_page.verify_caregiver_employer_is_present_on_page();

    }


}
