package WebUITests.forgotPasswordTests;

import io.unity.core.init.base;
import io.unity.core.remotegrid.LambdaTestConfig;
import org.testng.annotations.Test;
import utility.Logger;
import web.object_repository.forgotPassword.forgot_password;
import web.object_repository.login.login_page;


public class ForgotPasswordTests extends base
{
    login_page login = null;
    forgot_password forgotPassword = null;

    @Test
    public void verify_user_reset_password_using_valid_email()
    {
        Logger.log_qase_id("NEV-1047");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify user reset password using valid email");

        login = new login_page(driver);
        forgotPassword = new forgot_password(driver);

        login.verify_forgot_your_password_link_is_present_on_page();
        login.click_on_forgot_your_password_link();

        forgotPassword.verify_email_text_box_is_present_on_page();
        forgotPassword.enter_text_at_email_text_box("viral@nevvon.com");

        forgotPassword.verify_reset_password_button_is_present_on_page();
        forgotPassword.click_on_reset_password_button();

        forgotPassword.verify_email_send_text_is_present_on_page();
    }

    @Test
    public void verify_click_on_reset_button_while_resetField_empty()
    {
        Logger.log_qase_id("NEV-1046");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify click on reset button while resetField empty");

        login = new login_page(driver);
        forgotPassword = new forgot_password(driver);

        login.verify_forgot_your_password_link_is_present_on_page();
        login.click_on_forgot_your_password_link();

        forgotPassword.click_on_reset_password_button();
        forgotPassword.verify_email_error_message_is_present_on_page();

    }

    @Test
    public void verify_forgot_password_functionality_when_user_enter_spaces_in_emailBox()
    {
        Logger.log_qase_id("NEV-1048");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify forgot password functionality when user enter spaces in emailBox");

        login = new login_page(driver);
        forgotPassword = new forgot_password(driver);

        login.verify_forgot_your_password_link_is_present_on_page();
        login.click_on_forgot_your_password_link();

        forgotPassword.verify_email_text_box_is_present_on_page();
        forgotPassword.enter_text_at_email_text_box("  viral's@nevvon.com");
        forgotPassword.click_on_reset_password_button();
        forgotPassword.verify_email_data_invalid_message_is_present_on_page();

    }

    @Test
    public void verify_forgot_password_functionality_when_user_enter_single_quote_in_email()
    {
        Logger.log_qase_id("NEV-1049");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify forgot password functionality when user enter single quote in email");

        login = new login_page(driver);
        forgotPassword = new forgot_password(driver);

        login.verify_forgot_your_password_link_is_present_on_page();
        login.click_on_forgot_your_password_link();

        forgotPassword.enter_text_at_email_text_box("viral's@nevvon.com");
        forgotPassword.click_on_reset_password_button();
        //forgotPassword.verify_given_email_data_invalid_message_is_present_on_page();

    }

    @Test
    public void verify_unregistered_user_reset_password_using_valid_email()
    {
        Logger.log_qase_id("NEV-1050");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify unregistered user reset password using valid email");

        login = new login_page(driver);
        forgotPassword = new forgot_password(driver);

        login.verify_forgot_your_password_link_is_present_on_page();
        login.click_on_forgot_your_password_link();

        forgotPassword.enter_text_at_email_text_box("viralpatelll@nevvon.com");
        forgotPassword.click_on_reset_password_button();

        forgotPassword.verify_given_email_data_invalid_message_is_present_on_page();
    }

    @Test
    public void verify_user_reset_password_using_special_character_in_email()
    {

        Logger.log_qase_id("NEV-1051");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify user reset password using special character in email");

        login = new login_page(driver);
        forgotPassword = new forgot_password(driver);

        login.verify_forgot_your_password_link_is_present_on_page();
        login.click_on_forgot_your_password_link();

        forgotPassword.enter_text_at_email_text_box("viral&#$%^?@nevvon.com");
        forgotPassword.click_on_reset_password_button();

        forgotPassword.verify_given_email_data_invalid_message_is_present_on_page();
    }
    @Test
    public void To_verify_When_Enter_valid_Email_and_Refresh_URl()
    {

        Logger.log_qase_id("NEV-1077");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Enter valid Email and Refresh URl");

        login = new login_page(driver);
        forgotPassword = new forgot_password(driver);

        login.verify_forgot_your_password_link_is_present_on_page();
        login.click_on_forgot_your_password_link();

        forgotPassword.enter_text_at_email_text_box("viral@nevvon.com");
        forgotPassword.refresh_forgot_password_page();
        forgotPassword.verify_forgot_password_page_data_removed();
    }
    @Test
    public void To_verify_when_only_enter_space_in_email_text_box()
    {
        Logger.log_qase_id("NEV-1080");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when only enter space in email text box");

        login = new login_page(driver);
        forgotPassword = new forgot_password(driver);

        login.verify_forgot_your_password_link_is_present_on_page();
        login.click_on_forgot_your_password_link();

        forgotPassword.enter_text_at_email_text_box("         ");
        forgotPassword.click_on_reset_password_button();
        forgotPassword.verify_email_validation_message();
    }


}
