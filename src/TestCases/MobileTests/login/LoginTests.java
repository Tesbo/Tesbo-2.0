package TestCases.MobileTests.login;

import Framework.core.init.base;
import Framework.core.remotegrid.LambdaTestConfig;
import TestObjects.Screens.login.login_screen;
import io.appium.java_client.android.AndroidDriver;


import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import utility.Logger;

import java.time.Duration;


public class LoginTests extends base {



    @Test
    public void login_test() {

        Logger.log_qase_id("NP-24");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("login_test");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.enter_Your_Password_Text_Box("QA_12345");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_login_button_is_present();
        login_screen.click_on_login_button();

    }

    @Test
    public void verify_registered_user_is_trying_to_login_by_entering_valid_email_and_invalid_password() {
        Logger.log_qase_id("NP-29");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_registered_user_is_trying_to_login_by_entering_valid_email_and_invalid_password");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("qa_vir@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.enter_Your_Password_Text_Box("1234%$7");
       ((AndroidDriver)driver).hideKeyboard();

        login_screen.verify_login_button_is_present();
        login_screen.click_on_login_button();
        login_screen.Verify_incorrect_username_password_is_present_on_page();
    }

    @Test
    public void verify_registered_user_is_trying_to_login_by_keeping_email_text_field_empty() {
        Logger.log_qase_id("NP-26");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_registered_user_is_trying_to_login_by_keeping_email_text_field_empty");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.Verify_email_error_message_present_on_page();

    }

    @Test
    public void verify_registered_user_is_trying_to_log_in_by_keeping_Password_textfield_empty() {
        Logger.log_qase_id("NP-27");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_registered_user_is_trying_to_log_in_by_keeping_Password_textfield_empty");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("qa_vir@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.verify_login_button_is_present();
        login_screen.click_on_login_button();

        login_screen.Verify_password_error_message_is_present_on_page();


    }

    @Test
    public void verify_registered_user_is_trying_to_log_in_by_keeping_email_and_password_text_field_empty() {
        Logger.log_qase_id("NP-28");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_registered_user_is_trying_to_log_in_by_keeping_email_and_password_text_field_empty");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.Verify_email_error_message_present_on_page();

    }

    @Test
    public void verify_user_is_trying_log_in_using_email_with_wrong_format_and_password() {
        Logger.log_qase_id("NP-31");
        Logger.log_qase_id("NP-32");
        Logger.log_qase_id("NP-33");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_user_is_trying_log_in_using_email_with_wrong_format_and_password");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.enter_Your_Password_Text_Box("123456a");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_login_button_is_present();
        login_screen.click_on_login_button();
        login_screen.Verify_incorrect_username_password_is_present_on_page();

    }

    @Test
    public void To_verify_registered_user_is_trying_to_log_in_by_entering_invalid_email_and_valid_password() {
        Logger.log_qase_id("NP-30");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_registered_user_is_trying_to_log_in_by_entering_invalid_email_and_valid_password");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("q_vir@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_incorrect_alert_message_is_present();

    }

    @Test
    public void To_verify_user_is_trying_to_log_in_by_entering_invalid_email_with_html_tag_and_password_textfield() {
        Logger.log_qase_id("NP-34");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_trying_to_log_in_by_entering_invalid_email_with_html_tag_and_password_textfield");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("<viral>@nevvon.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_incorrect_alert_message_is_present();
    }

    @Test
    public void To_verify_when_click_on_Need_Help_link_of_login_page() {
        Logger.log_qase_id("TC_LG_014");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_click_on_Need_Help_link_of_login_page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();

        login_screen.verify_need_help_button_is_present();
        login_screen.click_on_need_help_button();

    }

    @Test
    public void To_verify_the_splash_screen_while_Login()
    {
        Logger.log_qase_id("TC_LG_001");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_the_splash_screen_while_Login");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_splash_screen_logo_is_present();
    }

    @Test
    public void To_verify_the_content_of_Login_Page()
    {
        Logger.log_qase_id("TC_LG_002");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_the_content_of_Login_Page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_logo_image_is_present();
        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.verify_continue_Button_is_present();
        login_screen.verify_need_help_button_is_present();
        login_screen.verify_version_text_is_present();
    }

    @Test
    public void To_verify_input_field_to_enter_phone_number_or_email_is_clickable_or_not_Login_page()
    {
        Logger.log_qase_id("TC_LU_003");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_input_field_to_enter_phone_number_or_email_is_clickable_or_not_Login_page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_logo_image_is_present();
        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("1234567890");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();
    }

    @Test
    public void To_verify_input_field_to_enter_phone_number_or_email_is_clickable_or_not_email_address_Login_page()
    {
        Logger.log_qase_id("TC_LU_004");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_input_field_to_enter_phone_number_or_email_is_clickable_or_not_email_address_Login_page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
    }

    @Test
    public void To_verify_user_is_not_able_to_login_by_providing_valid_phone_number_and_invalid_password() {
        Logger.log_qase_id("TC_LG_006");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_not_able_to_login_by_providing_valid_phone_number_and_invalid_password");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("7426472468");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.enter_Your_Password_Text_Box("123456a");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_login_button_is_present();
        login_screen.click_on_login_button();
        login_screen.Verify_incorrect_username_password_is_present_on_page();
    }

    @Test
    public void To_verify_user_is_not_able_to_login_by_providing_valid_email_address_and_invalid_password() {
        Logger.log_qase_id("TC_LG_007");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_not_able_to_login_by_providing_valid_email_address_and_invalid_password");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.enter_Your_Password_Text_Box("123456a");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_login_button_is_present();
        login_screen.click_on_login_button();
        login_screen.Verify_incorrect_username_password_is_present_on_page();
    }

    @Test
    public void To_verify_user_is_not_able_to_move_to_password_page_by_providing_invalid_phone_number() {
        Logger.log_qase_id("TC_LG_008");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_not_able_to_move_to_password_page_by_providing_invalid_phone_number");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("873583569");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_incorrect_alert_message_is_present();
    }

    @Test
    public void To_verify_user_is_not_able_to_move_to_password_page_by_providing_invalid_email_address() {
        Logger.log_qase_id("TC_LG_009");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_not_able_to_move_to_password_page_by_providing_invalid_email_address");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmaul.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_incorrect_alert_message_is_present();
    }

    @Test
    public void To_verify_when_click_on_why_cannot_I_login_link() {
        Logger.log_qase_id("TC_LG_010");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_click_on_why_cannot_I_login_link");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("2545353353555");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_why_cannot_i_login_button_is_present();
        login_screen.click_On_why_cannot_i_login_button();
        login_screen.verify_why_cannot_i_login_popup_header_is_present();
    }

    @Test
    public void To_verify_user_is_not_able_to_login_via_unregistered_phone_number() {
        Logger.log_qase_id("TC_LG_012");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_not_able_to_login_via_unregistered_phone_number");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("2654546467989");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_incorrect_alert_message_is_present();
    }

    @Test
    public void To_verify_user_is_not_able_to_login_via_unregistered_Email() {
        Logger.log_qase_id("TC_LG_013");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_not_able_to_login_via_unregistered_Email");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob12345678@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_incorrect_alert_message_is_present();
    }

    @Test
    public void To_verify_by_entering_registered_phone_number_Email_Continue_button_get_enable_or_not() {
        Logger.log_qase_id("TC_LG_015");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_by_entering_registered_phone_number_Email_Continue_button_get_enable_or_not");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();
    }

    @Test
    public void To_verify_by_clicking_eye_icon_besides_password_input_field_Password_should_be_displayed() {
        Logger.log_qase_id("TC_LG_016");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_by_clicking_eye_icon_besides_password_input_field_Password_should_be_displayed");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        String enterPassword = "12345a";
        login_screen.enter_Your_Password_Text_Box(enterPassword);
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_password_eye_button_is_present();
        login_screen.click_On_password_eye_button();
        String password = login_screen.get_Password_Text_from_Text_Box();
        if(password.equals(enterPassword))
        {
            Assertions.assertThat(true).isTrue();
        }else{
            Assertions.assertThat(false).isFalse();
        }
    }

    @Test
    public void To_verify_by_clicking_on_login_button_user_should_be_redirected_to_Home_page_of_the_application() {
        Logger.log_qase_id("TC_LG_017");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_by_clicking_on_login_button_user_should_be_redirected_to_Home_page_of_the_application");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.enter_Your_Password_Text_Box("QA_12345");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_login_button_is_present();
        login_screen.click_on_login_button();
    }

    @Test
    public void To_verify_eye_icon_available_at_the_password_field_is_able_unencrypted_or_encrypt_the_password() {
        Logger.log_qase_id("FA_150");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_eye_icon_available_at_the_password_field_is_able_unencrypted_or_encrypt_the_password");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        String enterPassword = "12345a";
        login_screen.enter_Your_Password_Text_Box(enterPassword);
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_password_eye_button_is_present();
        login_screen.click_On_password_eye_button();
        login_screen.click_on_enter_Your_Password_text_field();
        String password = login_screen.get_Password_Text_from_Text_Box();
        Assertions.assertThat(password.equals(enterPassword));
    }

    @Test
    public void To_verify_spelling_on_Login_button_is_Log_in() {
        Logger.log_qase_id("FA-161");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_spelling_on_Login_button_is_Log_in");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.enter_Your_Password_Text_Box("QA_12345");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_login_button_is_present();
        login_screen.click_on_login_button();
    }

    @Test
    public void To_verify_that_after_entering_email_and_password_entering_Enter_button_logins_the_user() {
        Logger.log_qase_id("FA-162");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_that_after_entering_email_and_password_entering_Enter_button_logins_the_user");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
        login_screen.enter_Your_Password_Text_Box("QA_12345");
       ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_login_button_is_present();
        login_screen.click_on_login_button();
    }
}

