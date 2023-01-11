package web.tests;


import io.unity.framework.data.TestData;
import io.unity.framework.init.base;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import web.object_repository.otp.otp;
import web.object_repository.signup.signup;

import java.io.IOException;


public class SignUpTest extends base {

    @Test
    public void verify_signup_with_valid_email_password() throws IOException, InterruptedException {
         signup signup = new signup(driver);
         otp otp = new otp(driver);
         driver.manage().window().maximize();
         signup.enter_text_at_preferably_your_work_email_text_box("qabletest+"+TestData.random_numeric_string(3)+"@gmail.com");
         signup.enter_text_at_a_secure_one_please_password("QAble@1010");

         signup.click_on_sign_up_button();

        otp.verify_a_quick_verification_text_text_is_equal_to("A quick verification");
        otp.gmaillogin();
        otp.clear_text_and_enter_text_in_gmailt("qabletest@gmail.com");
        otp.click_on_gmail_next();
        otp.clear_text_and_enter_text_in_gmail_password("QAble@1010");
        otp.click_on_gmail_password_next();
        otp.click_on_gmail_subject_text();
        otp.get_otp();
        otp.click_on_verify_button();

        signup.enter_text_first_name_text("test 1");
        signup.enter_text_last_name_text("test 3");
        signup.click_on_select_people();
        signup.click_on_select_people_dropdown();
        signup.click_on_select_industry();
        signup.click_on_select_industry_dropdown();
        signup.click_on_saleshandy_name();
        signup.click_on_continue_signup();
        signup.verify_onboard_page_is_present_on_page();

        signup.click_on_onboard_gmail();
        signup.verify_gmail_verify_is_present_on_page();
        signup.click_on_gmail_verify();
        signup.click_on_gmail_verify_allow();
        signup.verify_setting_menu_is_present_on_page();


        signup.click_on_close_video();
        signup.click_on_close_startted_get();
        signup.click_on_ifram1();
        signup.click_on_click_on_schedule();
        signup.click_on_add_new_schedule();
        signup.click_on_add_schedule_save();
        signup.click_on_enter_schedule_name();
        signup.clear_text_and_enter_text_in_enter_schedule_name("enter_schedule_name","enter_schedule_name");
        signup.click_on_select_time_zone();
        signup.click_on_change_time_zone();
        signup.click_on_monday_time_1();
        signup.enter_text_monday_time_1("09");
        signup.enter_text_monday_time_1_2("00");
        signup.enter_text_monday_time_1_3("10");
        signup.enter_text_monday_time_1_4("00");
        signup.click_on_monday_time_1_2();
        signup.enter_text_monday_time_1_2("10");
        signup.click_on_monday_add_1();
        signup.click_on_monday_time_2();
        signup.enter_text_monday_time_2("11");
        signup.click_on_monday_time_2_1();
        signup.enter_text_monday_time_2_1("00");
        signup.click_on_monday_time_2_2();
        signup.enter_text_monday_time_2_2("12");
        signup.click_on_monday_time_2_3();
        signup.enter_text_monday_time_2_3("00");

        signup.click_on_thursday_time_1();
        signup.enter_text_thursday_time_1("09");
        signup.enter_text_thursday_time_1_2("00");
        signup.enter_text_thursday_time_1_3("10");
        signup.enter_text_thursday_time_1_4("00");

        signup.click_on_wednesday_time_1();
        signup.enter_text_wednesday_time_1("09");
        signup.enter_text_wednesday_time_1_2("00");
        signup.enter_text_wednesday_time_1_3("10");
        signup.enter_text_wednesday_time_1_4("00");

        signup.click_on_tuesday_time_1();
        signup.enter_text_tuesday_time_1("09");
        signup.enter_text_tuesday_time_1_2("00");
        signup.enter_text_tuesday_time_1_3("10");
        signup.enter_text_tuesday_time_1_4("00");

        signup.click_on_friday_time_1();
        signup.enter_text_friday_time_1("09");
        signup.enter_text_friday_time_1_2("00");
        signup.enter_text_friday_time_1_3("10");
        signup.enter_text_friday_time_1_4("00");

        signup.click_on_saturday_add_1();
        signup.click_on_saturday_time_1();
        signup.enter_text_saturday_time_1("09");
        signup.enter_text_saturday_time_1_2("00");
        signup.enter_text_saturday_time_2("10");
        signup.enter_text_saturday_time_2_1("00");

        signup.click_on_sunday_add_1();
        signup.click_on_sunday_time_1();
        signup.enter_text_sunday_time_1("09");
        signup.enter_text_sunday_time_1_2("00");
        signup.enter_text_sunday_time_2("10");
        signup.enter_text_sunday_time_2_1("00");

        signup.click_on_add_schedule_save();

    }


}
