package MobileTests.sign_up;

import io.appium.java_client.android.AndroidDriver;
import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import Screens.change_environment.change_environment;
import Screens.login.login_screen;
import Screens.sign_up.sign_up_page;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;

import java.time.Duration;

public class sign_up_tests extends base {

    @DataProvider(name = "mobile_user_login")
    public Object[][] data_provider() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;

        data = reader.getExcelDataForDataProvider("mobile_user_cred.xlsx", 0);

        return data;
    }
    @Test(dataProvider = "mobile_user_login")
    public void verify_user_is_able_to_go_to_sign_up_form_by_clicking_on_sign_up_tab(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-142");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_user_is_able_to_go_to_sign_up_form_by_clicking_on_sign_up_tab");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.verify_continue_Button_is_present();


        signup_page.verify_sign_up_email_box_is_present_on_page();

    }

    @Test(dataProvider = "mobile_user_login")
    public void verify_user_is_able_to_go_to_sign_up_by_entering_only_Email_and_Confirm_Email(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-143");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_user_is_able_to_go_to_sign_up_by_entering_only_Email_and_Confirm_Email");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        change_environment change_env = new change_environment(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_okey_button_popup_is_present_on_page();
        login_screen.click_on_okey_button_popup();

        login_screen.verify_sign_up_button_is_present_on_page();
        login_screen.click_on_sign_up_button();

        signup_page.enter_text_at_sign_up_email_box(username);
        signup_page.enter_text_at_sign_up_confirm_email_box(username);
        signup_page.click_on_sign_up_blue_button();

        signup_page.verify_error_message_sign_up_password_box_is_present_on_page();
        signup_page.verify_error_message_sign_up_confirm_password_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void verify_user_is_able_to_sign_up_by_entering_Password_and_Confirm_Password(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-144");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_user_is_able_to_sign_up_by_entering_Password_and_Confirm_Password");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        change_environment change_env = new change_environment(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_okey_button_popup_is_present_on_page();
        login_screen.click_on_okey_button_popup();

        login_screen.verify_sign_up_button_is_present_on_page();
        login_screen.click_on_sign_up_button();

        signup_page.enter_text_at_sign_up_password_box(password);
        signup_page.enter_text_at_sign_up_confirm_password(password);

        signup_page.click_on_sign_up_blue_button();

        signup_page.verify_error_message_sign_up_email_box_is_present_on_page();
        signup_page.verify_error_message_sign_up_confirm_email_box_is_present_on_page();

    }

    @Test(dataProvider = "mobile_user_login")
    public void verify_user_is_able_to_sign_up_by_entering_Email_and_Password(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-145");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_user_is_able_to_sign_up_by_entering_Email_and_Password");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        change_environment change_env = new change_environment(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_okey_button_popup_is_present_on_page();
        login_screen.click_on_okey_button_popup();

        login_screen.verify_sign_up_button_is_present_on_page();
        login_screen.click_on_sign_up_button();

        signup_page.enter_text_at_sign_up_email_box(username);
        signup_page.enter_text_at_sign_up_password_box(password);

        signup_page.click_on_sign_up_blue_button();

        signup_page.verify_error_message_sign_up_confirm_email_box_is_present_on_page();
        signup_page.verify_error_message_sign_up_confirm_password_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void verify_user_is_able_to_sign_up_by_entering_mismatched_Email_and_Confirm_Email(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-146");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_user_is_able_to_sign_up_by_entering_mismatched_Email_and_Confirm_Email");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        change_environment change_env = new change_environment(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_okey_button_popup_is_present_on_page();
        login_screen.click_on_okey_button_popup();

        login_screen.verify_sign_up_button_is_present_on_page();
        login_screen.click_on_sign_up_button();

        signup_page.enter_text_at_sign_up_email_box(username);
        signup_page.enter_text_at_sign_up_confirm_email_box("manisha+12345@nevvon.com");
        signup_page.enter_text_at_sign_up_password_box(password);
        signup_page.enter_text_at_sign_up_confirm_password(password);

        signup_page.click_on_sign_up_blue_button();

        signup_page.verify_error_message_for_email_password_match_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void verify_user_is_able_to_sign_up_by_entering_mismatched_Password_and_Confirm_Password(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-147");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_user_is_able_to_sign_up_by_entering_mismatched_Password_and_Confirm_Password");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        change_environment change_env = new change_environment(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_okey_button_popup_is_present_on_page();
        login_screen.click_on_okey_button_popup();

        login_screen.verify_sign_up_button_is_present_on_page();
        login_screen.click_on_sign_up_button();

        signup_page.enter_text_at_sign_up_email_box(username);
        signup_page.enter_text_at_sign_up_confirm_email_box(username);
        signup_page.enter_text_at_sign_up_password_box(password);
        signup_page.enter_text_at_sign_up_confirm_password("Viral@12345");

        signup_page.click_on_sign_up_blue_button();

        signup_page.verify_error_message_for_email_password_match_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void verify_user_is_able_sign_up_by_keeping_all_fields_blank(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-151");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_user_is_able_sign_up_by_keeping_all_fields_blank");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_okey_button_popup_is_present_on_page();
        login_screen.click_on_okey_button_popup();

        login_screen.verify_sign_up_button_is_present_on_page();
        login_screen.click_on_sign_up_button();

        signup_page.click_on_sign_up_blue_button();

        signup_page.verify_error_message_sign_up_email_box_is_present_on_page();
        signup_page.verify_error_message_sign_up_confirm_email_box_is_present_on_page();
        signup_page.verify_error_message_sign_up_password_box_is_present_on_page();
        signup_page.verify_error_message_sign_up_confirm_password_is_present_on_page();

    }

    @Test(dataProvider = "mobile_user_login")
    public void verify_user_is_able_to_sign_up_by_entering_spaces_in_Password_and_Confirm_Password_field_for_registered_user(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-153");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_user_is_able_to_sign_up_by_entering_spaces_in_Password_and_Confirm_Password_field_for_registered_user");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_okey_button_popup_is_present_on_page();
        login_screen.click_on_okey_button_popup();

        login_screen.verify_sign_up_button_is_present_on_page();
        login_screen.click_on_sign_up_button();

        signup_page.enter_text_at_sign_up_email_box(username);
        signup_page.enter_text_at_sign_up_confirm_email_box(username);
        signup_page.enter_text_at_sign_up_password_box("        ");
        signup_page.enter_text_at_sign_up_confirm_password("        ");

        signup_page.click_on_sign_up_blue_button();

        signup_page.verify_user_already_exit_message_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void to_verify_user_is_able_to_see_pop_up_of_terms_and_conditions_by_clicking_on_terms_and_conditions_link(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-150");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_user_is_able_to_see_pop_up_of_terms_and_conditions_by_clicking_on_terms_and_conditions_link");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_okey_button_popup_is_present_on_page();
        login_screen.click_on_okey_button_popup();

        login_screen.verify_sign_up_button_is_present_on_page();
        login_screen.click_on_sign_up_button();

        signup_page.verify_sign_up_confirm_email_box_is_present_on_page();
        signup_page.verify_terms_and_conditions_link_is_present_on_page();
        signup_page.click_on_terms_and_conditions_link();
        signup_page.verify_terms_and_conditions_header_is_present_on_page();
        signup_page.verify_agree_button_is_present_on_page();

    }

    @Test(dataProvider = "mobile_user_login")
    public void to_verify_when_click_on_agree_button_pop_up_closes(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-154");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_click_on_agree_button_pop_up_closes");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_okey_button_popup_is_present_on_page();
        login_screen.click_on_okey_button_popup();

        login_screen.verify_sign_up_button_is_present_on_page();
        login_screen.click_on_sign_up_button();

        signup_page.verify_sign_up_confirm_email_box_is_present_on_page();
        signup_page.verify_terms_and_conditions_link_is_present_on_page();
        signup_page.click_on_terms_and_conditions_link();
        signup_page.verify_terms_and_conditions_header_is_present_on_page();
        signup_page.verify_agree_button_is_present_on_page();
        signup_page.click_on_agree_button();
        signup_page.verify_sign_up_confirm_email_box_is_present_on_page();

    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_is_able_to_sign_up_by_entering_spaced_in_password_and_confirm_password_field_for_unregistered_user(String username,String password,String programName)
    {
        Logger.log_qase_id("NP-153");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_sign_up_by_entering_spaced_in_password_and_confirm_password_field_for_unregistered_user");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_okey_button_popup_is_present_on_page();
        login_screen.click_on_okey_button_popup();

        login_screen.verify_sign_up_button_is_present_on_page();
        login_screen.click_on_sign_up_button();

        String user = "abcxyz" + Math.random() + "@yopmail.com";
        signup_page.enter_text_at_sign_up_email_box(user);
        signup_page.enter_text_at_sign_up_confirm_email_box(user);
        signup_page.enter_text_at_sign_up_password_box(" ");
        signup_page.enter_text_at_sign_up_confirm_password(" ");

        signup_page.click_on_sign_up_blue_button();
        signup_page.verify_phone_number_text_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_the_splash_screen_while_creating_account(String username,String password,String programName)
    {
        Logger.log_qase_id("TC_SU_001");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_the_splash_screen_while_creating_account");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_splash_screen_logo_is_present();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_the_content_of_page_while_user_is_creating_account_for_the_first_time(String username,String password,String programName)
    {
        Logger.log_qase_id("TC_SU_002");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_the_content_of_page_while_user_is_creating_account_for_the_first_time");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_logo_image_is_present();
        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.verify_continue_Button_is_present();
        login_screen.verify_need_help_button_is_present();
        login_screen.verify_version_text_is_present();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_input_field_to_enter_phone_number_or_email_is_clickable_or_not_phone_number(String username,String password,String programName)
    {
        Logger.log_qase_id("TC_SU_003");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_input_field_to_enter_phone_number_or_email_is_clickable_or_not_phone_number");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_logo_image_is_present();
        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("1234567890");
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_input_field_to_enter_phone_number_or_email_is_clickable_or_not_email_address(String username,String password,String programName)
    {
        Logger.log_qase_id("TC_SU_004");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_input_field_to_enter_phone_number_or_email_is_clickable_or_not_email_address");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_should_not_be_able_to_proceed_further_by_entering_phone_number_less_than_8_digit (String username,String password,String programName)
    {
        Logger.log_qase_id("TC_SU_005");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_should_not_be_able_to_proceed_further_by_entering_phone_number_less_than_8_digit");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("1234567");
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_incorrect_alert_message_is_present();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_should_not_be_able_to_proceed_further_by_entering_phone_number_more_than_10_digit  (String username,String password,String programName)
    {
        Logger.log_qase_id("TC_SU_006");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_should_not_be_able_to_proceed_further_by_entering_phone_number_more_than_10_digit");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("12345678910");
        ((AndroidDriver)driver).hideKeyboard();
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_incorrect_alert_message_is_present();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_by_providing_already_registered_phone_number(String username,String password,String programName)
    {
        Logger.log_qase_id("TC_SU_007");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_by_providing_already_registered_phone_number");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("7426472468");
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_by_providing_already_registered_Email_address(String username,String password,String programName)
    {
        Logger.log_qase_id("TC_SU_008");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_by_providing_already_registered_Email_address");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_Need_Help_link_is_clickable_or_not(String username,String password,String programName)
    {
        Logger.log_qase_id("TC_SU_009");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_Need_Help_link_is_clickable_or_not");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();

        login_screen.verify_need_help_button_is_present();
        login_screen.click_on_need_help_button();

    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_continue_button_is_clickable_or_not_after_entering_necessary_details(String username,String password,String programName)
    {
        Logger.log_qase_id("TC_SU_010");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_continue_button_is_clickable_or_not_after_entering_necessary_details");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_when_click_on_continue_button(String username,String password,String programName)
    {
        Logger.log_qase_id("TC_SU_011");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_click_on_continue_button");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("mob@yopmail.com");
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        login_screen.verify_enter_Your_Password_is_present();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_the_content_of_phone_number_verification_page(String username,String password,String programName)
    {
        Logger.log_qase_id("TC_SU_012");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_the_content_of_phone_number_verification_page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("4627626558");
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        signup_page.verify_verify_your_phone_number_signup_is_present_on_page();
        signup_page.verify_verify_your_phone_number_text_msg_one_signup_is_present_on_page();
        signup_page.verify_verify_your_phone_number_text_msg_two_signup_is_present_on_page();
        signup_page.verify_send_me_an_sms_option_is_present_on_page();
        signup_page.verify_call_me_option_is_present_on_page();
        signup_page.verify_continue_button_signup_is_present_on_page();
        signup_page.verify_need_help_link_signup_screen_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_Send_me_an_SMS_is_clickable_or_not(String username,String password,String programName) {
        Logger.log_qase_id("TC_SU_013");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_Send_me_an_SMS_is_clickable_or_not");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("4627626558");
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        signup_page.verify_verify_your_phone_number_signup_is_present_on_page();
        signup_page.verify_verify_your_phone_number_text_msg_one_signup_is_present_on_page();
        signup_page.verify_verify_your_phone_number_text_msg_two_signup_is_present_on_page();
        signup_page.verify_send_me_an_sms_option_is_present_on_page();
        signup_page.click_on_send_me_an_sms_option();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_Call_me_is_clickable_or_not(String username,String password,String programName) {
        Logger.log_qase_id("TC_SU_014");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_Call_me_is_clickable_or_not");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("4627626558");
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        signup_page.verify_verify_your_phone_number_signup_is_present_on_page();
        signup_page.verify_verify_your_phone_number_text_msg_one_signup_is_present_on_page();
        signup_page.verify_verify_your_phone_number_text_msg_two_signup_is_present_on_page();
        signup_page.verify_call_me_option_is_present_on_page();
        signup_page.click_on_call_me_option();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_continue_button_is_clickable_or_not_after_selection_Call_me_Send_me_an_SMS_button(String username,String password,String programName) {
        Logger.log_qase_id("TC_SU_015");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_continue_button_is_clickable_or_not_after_selection_Call_me_Send_me_an_SMS_button");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("4627626558");
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        signup_page.verify_verify_your_phone_number_signup_is_present_on_page();
        signup_page.verify_verify_your_phone_number_text_msg_one_signup_is_present_on_page();
        signup_page.verify_verify_your_phone_number_text_msg_two_signup_is_present_on_page();
        signup_page.verify_send_me_an_sms_option_is_present_on_page();
        signup_page.click_on_send_me_an_sms_option();
        signup_page.verify_continue_button_signup_is_present_on_page();
        signup_page.click_on_continue_button_signup();
        signup_page.verify_we_sent_you_an_SMS_signup_text_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_the_content_of_the_validation_page_after_clicking_on_Continue_button(String username,String password,String programName) {
        Logger.log_qase_id("TC_SU_016");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_the_content_of_the_validation_page_after_clicking_on_Continue_button");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        sign_up_page signup_page = new sign_up_page(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.enter_email_address_or_phone_number("4627626558");
        login_screen.verify_continue_Button_is_present();
        login_screen.click_On_continue_Button();

        signup_page.verify_verify_your_phone_number_signup_is_present_on_page();
        signup_page.verify_verify_your_phone_number_text_msg_one_signup_is_present_on_page();
        signup_page.verify_verify_your_phone_number_text_msg_two_signup_is_present_on_page();
        signup_page.verify_send_me_an_sms_option_is_present_on_page();
        signup_page.click_on_send_me_an_sms_option();
        signup_page.verify_continue_button_signup_is_present_on_page();
        signup_page.click_on_continue_button_signup();
        signup_page.verify_we_sent_you_an_SMS_signup_text_is_present_on_page();
        signup_page.verify_send_an_sms_screen_text_msg_is_present_on_page();
        signup_page.verify_enter_code_text_box_is_present_on_page();
        signup_page.verify_verify_button_signup_is_present_on_page();
        signup_page.verify_need_help_link_signup_screen_is_present_on_page();
    }
}
