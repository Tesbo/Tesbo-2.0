package mobile.tests.profileScreenTest;

import io.appium.java_client.AppiumDriver;
import io.unity.framework.init.base;
import io.unity.performaction.autoweb.Wait;
import mobile.object_repository.Utility.UtilityManager;
import mobile.object_repository.profileScreen.profileScreen;
import mobile.object_repository.profileScreen.profileScreen;
import mobile.object_repository.tranactionHomePage.transactionHomePage;
import org.testng.annotations.Test;
import io.unity.performaction.autoweb.testng_logs;

import java.time.Duration;

public class profileScreenTest extends base {
    profileScreen profile = null;
    transactionHomePage transactionHomePage = null;
    Wait wait = new Wait(driver);
    UtilityManager utility = null;
    testng_logs logs = new testng_logs();


    @Test
    public void profileScreen()
    {
        //TCM_127,128,129,130,131,132,
        logs.test_step("<b>Covering Test Cases TCM_127 - TCM_132 : </b> <br><br>");
        profile = new profileScreen(driver);
        transactionHomePage = new transactionHomePage(driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        transactionHomePage.click_on_home_hamburger_button();
//        wait.wait_for_second(5);
        profile.verify_profile_screen_customer_name_text_is_equal_to("Ayush Srivastava");
        transactionHomePage.click_on_profile_image_icon();

        profile.verify_change_mpin_button_is_present_on_page();

        profile.verify_profile_screen_back_button_is_present_on_page();
        profile.verify_profile_screen_back_button_is_clickable();
        profile.click_on_profile_screen_back_button();
        transactionHomePage.verify_profile_image_icon_is_present_on_page();
    }

    @Test
    public void to_verify_profile_personal_mail_verification_functionality()
    {
        //TCM_133,134,135
        logs.test_step("<b>Covering Test Cases TCM_133 - TCM_135 : </b> <br><br>");

        profile = new profileScreen(driver);
        transactionHomePage = new transactionHomePage(driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        transactionHomePage.click_on_home_hamburger_button();

        transactionHomePage.click_on_profile_image_icon();

        profile.verify_profile_details_button_is_present_on_page();
        profile.click_on_profile_details_button();

        profile.verify_personal_detail_full_name_text_text_is_equal_to("Ayush  Srivastava");
        profile.verify_personal_details_screen_mail_verified_customer_mobile_number_text_text_is_equal_to("+917007030012");
        profile.verify_user_residential_address_text_is_equal_to("57 1 21,Mata Ramabai Ambedkar, Dr. E. Moses Road, MUMBAI, india, 400018");


        profile.verify_personal_details_edit_email_button_is_present_on_page();
        profile.click_on_personal_details_edit_email_button();

        profile.verify_add_email_id_text_box_is_present_on_page();
    }

    @Test
    public void profile_personal_change_mpin_functionality()
    {
        //TCM_169,170,171,172,173,174,175,176,177
        logs.test_step("<b>Covering Test Cases TCM_169 - TCM_177 : </b> <br><br>");

        profile = new profileScreen(driver);
        transactionHomePage = new transactionHomePage(driver);
        utility = new UtilityManager((AppiumDriver) driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        transactionHomePage.click_on_home_hamburger_button();

        transactionHomePage.click_on_profile_image_icon();
        profile.verify_change_mpin_button_is_present_on_page();
        profile.click_on_change_mpin_button();

        profile.verify_change_mpin_text_box_is_present_on_page();


        profile.enter_text_at_change_mpin_text_box("132456");
        profile.verify_change_mpin_continue_button_is_clickable();
        profile.click_on_change_mpin_continue_button();

        profile.verify_enter_new_mpin_textbox_is_present_on_page();
        profile.click_on_change_mpin_back_button();
        profile.verify_change_mpin_text_box_is_present_on_page();

        profile.click_on_change_mpin_textbox();
        profile.verify_keyboardStatus();

        profile.enter_text_at_change_mpin_text_box("333");

        profile.verify_change_mpin_text_box_is_present_on_page();
        profile.clear_text_and_enter_text_in_change_mpin_text_box("123432");
        profile.click_on_change_mpin_continue_button();

        profile.clear_text_and_enter_text_in_enter_new_mpin_textbox("123456");
        profile.verify_consecutive_number_message_text_is_equal_to("Passcode with consecutive and sequential numbers are not accepted");

        profile.verify_reenter_new_mpin_textbox_is_present_on_page();
        profile.clear_text_and_enter_text_in_enter_new_mpin_textbox("124334");
        profile.verify_reenter_new_mpin_textbox_is_present_on_page();
        profile.clear_text_and_enter_text_in_reenter_new_mpin_textbox("132934");
        profile.verify_mpin_does_not_match_message_text_is_equal_to("Passcode Does not match");


        profile.clear_text_and_enter_text_in_enter_new_mpin_textbox("192837");
        profile.clear_text_and_enter_text_in_reenter_new_mpin_textbox("192837");

        profile.click_on_change_mpin_continue_button2();

    }

    @Test
    public void Profile_Email_ID_NOT_added_functionality_for_valid_email_id()
    {
        //TCM_150,151,152,153,154
        logs.test_step("<b>Covering Test Cases TCM_150 - TCM_154 : </b> <br><br>");

        profile = new profileScreen(driver);
        transactionHomePage = new transactionHomePage(driver);
        utility = new UtilityManager((AppiumDriver) driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        transactionHomePage.click_on_home_hamburger_button();
        transactionHomePage.click_on_profile_image_icon();
        profile.verify_profile_details_button_is_present_on_page();
        profile.click_on_profile_details_button();

        profile.verify_personal_details_edit_email_button_is_present_on_page();
        profile.verify_personal_details_screen_mail_verified_customer_mobile_number_text_text_is_equal_to("+917007030012");
        profile.click_on_personal_details_edit_email_button();
        profile.verify_add_email_id_text_box_is_present_on_page();
        profile.verify_add_email_id_screen_back_button_is_present_on_page();
        profile.click_on_add_email_id_screen_back_button();
        profile.verify_personal_details_edit_email_button_is_present_on_page();

        profile.click_on_personal_details_edit_email_button();
        profile.enter_text_at_add_email_id_text_box("abc@gmail.com");
        utility.verify_app_run_in_background(Duration.ofSeconds(5));
        wait.wait_for_second(2);
        profile.click_on_add_email_id_verify_and_save_button();

        profile.verify_enter_verification_code_text_box_is_present_on_page();



    }

    @Test
    public void Profile_Email_ID_NOT_added_functionality_for_invalid_email_id()
    {
        //TCM_156,155
        logs.test_step("<b>Covering Test Cases TCM_155 - TCM_156 : </b> <br><br>");

        profile = new profileScreen(driver);
        transactionHomePage = new transactionHomePage(driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        transactionHomePage.click_on_home_hamburger_button();
        transactionHomePage.click_on_profile_image_icon();
        profile.verify_profile_details_button_is_present_on_page();
        profile.click_on_profile_details_button();

        profile.verify_personal_details_edit_email_button_is_present_on_page();
        profile.verify_personal_details_screen_mail_verified_customer_mobile_number_text_text_is_equal_to("+917007030012");
        profile.click_on_personal_details_edit_email_button();
        profile.verify_add_email_id_text_box_is_present_on_page();
        profile.verify_add_email_id_screen_back_button_is_present_on_page();
        profile.click_on_add_email_id_screen_back_button();
        profile.verify_personal_details_edit_email_button_is_present_on_page();
        profile.click_on_personal_details_edit_email_button();

        profile.enter_text_at_add_email_id_text_box("abcgmail.com");
        profile.verify_add_email_id_textBox_error_text_text_is_equal_to("Please enter valid email.");
    }

    @Test
    public void Profile_Email_ID_NOT_added_functionality_for_blank_email()
    {
        //TCM_157
        logs.test_step("<b>Covering Test Cases TCM_157 : </b> <br><br>");

        profile = new profileScreen(driver);
        transactionHomePage = new transactionHomePage(driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        transactionHomePage.click_on_home_hamburger_button();
        transactionHomePage.click_on_profile_image_icon();
        profile.verify_profile_details_button_is_present_on_page();
        profile.click_on_profile_details_button();

        profile.verify_personal_details_edit_email_button_is_present_on_page();
        profile.verify_personal_details_screen_mail_verified_customer_mobile_number_text_text_is_equal_to("+917007030012");
        profile.click_on_personal_details_edit_email_button();
        profile.verify_add_email_id_text_box_is_present_on_page();
        profile.verify_add_email_id_screen_back_button_is_present_on_page();
        profile.click_on_add_email_id_screen_back_button();
        profile.verify_personal_details_edit_email_button_is_present_on_page();
        profile.click_on_personal_details_edit_email_button();

        profile.enter_text_at_add_email_id_text_box("abcd");
        profile.verify_add_email_id_textBox_error_text_text_is_equal_to("Please enter valid email.");
        profile.clear_text_and_enter_text_in_add_email_id_text_box("");
        profile.verify_add_email_id_email_required_message_text_is_equal_to("Email is required");
        profile.Verify_add_email_id_verify_and_save_button_is_disable();


    }

    @Test
    public void To_verify_enter_verification_code_screen()
    {
        //TCM_158
        logs.test_step("<b>Covering Test Cases TCM_158 : </b> <br><br>");

        profile = new profileScreen(driver);
        transactionHomePage = new transactionHomePage(driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        transactionHomePage.click_on_home_hamburger_button();
        transactionHomePage.click_on_profile_image_icon();
        profile.verify_profile_details_button_is_present_on_page();
        profile.click_on_profile_details_button();

        profile.verify_personal_details_edit_email_button_is_present_on_page();
        profile.verify_personal_details_screen_mail_verified_customer_mobile_number_text_text_is_equal_to("+917007030012");
        profile.click_on_personal_details_edit_email_button();

        profile.enter_text_at_add_email_id_text_box("abc@gmail.com");
        profile.click_on_add_email_id_verify_and_save_button();

        profile.verify_enter_verification_code_text_box_is_present_on_page();
//        wait.wait_for_second(50);
        profile.verify_enter_verification_code_resend_button_is_present_on_page();

    }

    @Test
    public void To_verify_the_OTP_field_with_invalid_data()
    {
        //TCM_159,160,161,162
        logs.test_step("<b>Covering Test Cases TCM_159 - TCM_162 : </b> <br><br>");

        profile = new profileScreen(driver);

        transactionHomePage = new transactionHomePage(driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        transactionHomePage.click_on_home_hamburger_button();
        transactionHomePage.click_on_profile_image_icon();
        profile.verify_profile_details_button_is_present_on_page();
        profile.click_on_profile_details_button();

        profile.verify_personal_details_edit_email_button_is_present_on_page();
        profile.verify_personal_details_screen_mail_verified_customer_mobile_number_text_text_is_equal_to("+917007030012");
        profile.click_on_personal_details_edit_email_button();


        profile.enter_text_at_add_email_id_text_box("abc@gmail.com");
        profile.click_on_add_email_id_verify_and_save_button();

        profile.click_On_enter_verification_text_box();
        profile.verify_keyboardStatus();

        profile.click_on_enter_verification_code_back_button();

        profile.clear_text_and_enter_text_in_add_email_id_text_box("abc@gmail.com");
        profile.click_on_add_email_id_verify_and_save_button();
        profile.enter_text_at_enter_verification_code_text_box("123456");
        profile.click_on_profile_verify_email_id_button();
        profile.verify_enter_verification_code_invalid_otp_error_text_is_equal_to("Invalid otp");
    }

    @Test
    public void verify_resend_code_button_functionality()
    {
        //TCM_162,163,164,165,145,146,147,148,149,
        logs.test_step("<b>Covering Test Cases Range TCM_163 - 165, TCM_145 - 149 : </b> <br><br>");


        profile = new profileScreen(driver);
        transactionHomePage = new transactionHomePage(driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        transactionHomePage.click_on_home_hamburger_button();
        transactionHomePage.click_on_profile_image_icon();
        profile.verify_profile_details_button_is_present_on_page();
        profile.click_on_profile_details_button();

        profile.verify_personal_details_edit_email_button_is_present_on_page();
        profile.verify_personal_details_screen_mail_verified_customer_mobile_number_text_text_is_equal_to("+917007030012");
        profile.click_on_personal_details_edit_email_button();


        profile.enter_text_at_add_email_id_text_box("abc@gmail.com");
        profile.click_on_add_email_id_verify_and_save_button();
        profile.verify_enter_verification_code_resend_button_is_clickable();
        wait.wait_for_second(5);

        profile.verify_enter_verification_code_resend_button_is_clickable();
        profile.click_on_enter_verification_code_resend_button();

        profile.minimizeAndReopenApp();
        profile.verify_enter_verification_code_resend_button_is_clickable();


    }

    @Test
    public void verify_profile_personal_details()
    {
        //TCM_166,167,168
        logs.test_step("<b>Covering Test Cases Range TCM_166 - 168 : </b> <br><br>");

        profile = new profileScreen(driver);
        transactionHomePage = new transactionHomePage(driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        transactionHomePage.click_on_home_hamburger_button();
        transactionHomePage.click_on_profile_image_icon();
        profile.verify_profile_details_button_is_present_on_page();
        profile.click_on_profile_details_button();

        profile.verify_user_residential_address_text_is_equal_to("57 1 21,Mata Ramabai Ambedkar, Dr. E. Moses Road, MUMBAI, india, 400018");
        profile.verify_kyc_status_text_is_equal_to("Full KYC");
    }

    @Test
    public void Profile_Email_ID_already_added_functionality()
    {
        //TCM_135,136,137,138,139,140,141,143
        logs.test_step("<b>Covering Test Cases Range TCM_135 - 141, TCM_143 : </b> <br><br>");

        profile = new profileScreen(driver);
        transactionHomePage = new transactionHomePage(driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        transactionHomePage.click_on_home_hamburger_button();
        transactionHomePage.click_on_profile_image_icon();
        profile.verify_profile_details_button_is_present_on_page();
        profile.click_on_profile_details_button();

        profile.verify_personal_details_edit_email_button_is_present_on_page();
        profile.click_on_personal_details_edit_email_button();
        profile.verify_add_email_id_text_box_is_present_on_page();

        profile.enter_text_at_add_email_id_text_box("abcd");
        profile.verify_add_email_id_textBox_error_text_text_is_equal_to("Please enter valid email.");

        profile.clear_text_and_enter_text_in_add_email_id_text_box("");
        profile.verify_add_email_id_email_required_message_text_is_equal_to("Email is required");

        profile.enter_text_at_add_email_id_text_box("shivani@binaryveda.com");
        profile.verify_add_email_id_verify_and_save_button_is_clickable();

        profile.click_on_add_email_id_verify_and_save_button();

        profile.enter_text_at_enter_verification_code_text_box("123456");
        profile.click_on_profile_verify_email_id_button();

        profile.verify_enter_verification_code_invalid_otp_error_text_is_equal_to("Invalid otp");
//        wait.wait_for_second(45);
        profile.verify_enter_verification_code_resend_button_is_present_on_page();


    }
}