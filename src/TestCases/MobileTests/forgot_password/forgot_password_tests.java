package TestCases.MobileTests.forgot_password;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.remotegrid.LambdaTestConfig;
import io.appium.java_client.android.AndroidDriver;

import Screens.login.login_screen;
import org.testng.annotations.Test;
import utility.Logger;

import java.time.Duration;

public class forgot_password_tests extends base {
    @Test
    public void verify_that_when_click_on_forgot_password_it_opens_pop_up() {

        Logger.log_qase_id("TC_FP_001");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_that_when_click_on_forgot_password_it_opens_pop_up");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
        ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.verify_forgot_password_button_is_present_on_page();
        login_screen.click_on_forgot_password_button();

        login_screen.verify_user_email_text_box_is_present_on_page();

    }
    @Test
    public void verify_that_by_entering_registered_email_user_is_able_to_receive_reset_password_mail()
    {
        Logger.log_qase_id("TC_FP_002");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_that_by_entering_registered_email_user_is_able_to_receive_reset_password_mail");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
        ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();
        login_screen.verify_enter_Your_Password_is_present();

        login_screen.verify_forgot_password_button_is_present_on_page();
        login_screen.click_on_forgot_password_button();
        login_screen.verify_user_email_text_box_is_present_on_page();

        login_screen.enter_text_at_user_email_text_box("qa_vir@yopmail.com");
        login_screen.verify_send_reset_password_button_is_present_on_page();
        login_screen.click_on_send_reset_password_button();

        login_screen.Verify_email_send_message_text_is_equal_to("Email sent successfully.");
    }
    @Test
    public void verify_that_by_entering_unregistered_email_user_is_not_able_to_receive_reset_password_mail()
    {
        Logger.log_qase_id("TC_FP_003");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_that_by_entering_unregistered_email_user_is_not_able_to_receive_reset_password_mail");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
        ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();
        login_screen.verify_enter_Your_Password_is_present();

        login_screen.verify_forgot_password_button_is_present_on_page();
        login_screen.click_on_forgot_password_button();
        login_screen.verify_user_email_text_box_is_present_on_page();

        login_screen.enter_text_at_user_email_text_box("abc123@yopmail.com");
        login_screen.verify_send_reset_password_button_is_present_on_page();
        login_screen.click_on_send_reset_password_button();
        login_screen.Verify_user_email_not_found_alert_is_present_on_page();
        login_screen.Verify_ok_button_forgot_Password_invalid_user_is_present_on_page();
        login_screen.click_On_ok_button_forgot_Password_invalid_user_button();
        login_screen.verify_enter_Your_Password_is_present();
    }

    @Test
    public void To_verify_when_keeps_user_email_field_blank() {

        Logger.log_qase_id("TC_FP_004");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_keeps_user_email_field_blank");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
        ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.verify_forgot_password_button_is_present_on_page();
        login_screen.click_on_forgot_password_button();

        login_screen.verify_user_email_text_box_is_present_on_page();
        login_screen.verify_send_reset_password_email_button_is_present();
        login_screen.clear_user_email_text_box();
        login_screen.click_On_send_reset_password_email_button();
        login_screen.verify_please_enter_your_email_alert_is_present();

    }

    @Test
    public void To_verify_when_enter_email_with_space_for_forgot_password() {

        Logger.log_qase_id("FA-309");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_enter_email_with_space_for_forgot_password");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
        ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.verify_forgot_password_button_is_present_on_page();
        login_screen.click_on_forgot_password_button();

        login_screen.verify_user_email_text_box_is_present_on_page();
        login_screen.enter_text_at_forgot_password_email_text_box("mob 123456@yopmail.com");
        login_screen.verify_send_reset_password_email_button_is_present();
        login_screen.click_On_send_reset_password_email_button();
        // login_screen.verify_please_enter_your_email_alert_is_present();

    }

    @Test
    public void To_verify_In_forgot_password_when_user_enter_single_quote_in_email() {

        Logger.log_qase_id("FA-310");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_In_forgot_password_when_user_enter_single_quote_in_email");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
        ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.verify_forgot_password_button_is_present_on_page();
        login_screen.click_on_forgot_password_button();

        login_screen.verify_user_email_text_box_is_present_on_page();
        login_screen.enter_text_at_forgot_password_email_text_box("'mob@yopmail.com'");
        login_screen.verify_send_reset_password_email_button_is_present();
        login_screen.click_On_send_reset_password_email_button();
       // login_screen.verify_please_enter_your_email_alert_is_present();

    }

    @Test
    public void To_verify_unregistered_user_reset_password_using_valid_email() {

        Logger.log_qase_id("FA-311");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_unregistered_user_reset_password_using_valid_email");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
        ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.verify_forgot_password_button_is_present_on_page();
        login_screen.click_on_forgot_password_button();

        login_screen.verify_user_email_text_box_is_present_on_page();
        login_screen.enter_text_at_forgot_password_email_text_box("mob123456@yopmail.com");
        login_screen.verify_send_reset_password_email_button_is_present();
        login_screen.click_On_send_reset_password_email_button();
        // login_screen.verify_please_enter_your_email_alert_is_present();

    }

    @Test
    public void To_verify_when_tab_on_send_reset_password_email_link_without_entering_email() {

        Logger.log_qase_id("FA-277");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_tab_on_send_reset_password_email_link_without_entering_email");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
        ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.verify_forgot_password_button_is_present_on_page();
        login_screen.click_on_forgot_password_button();

        login_screen.verify_user_email_text_box_is_present_on_page();
        login_screen.verify_send_reset_password_email_button_is_present();
        login_screen.click_On_send_reset_password_email_button();
    }


}
