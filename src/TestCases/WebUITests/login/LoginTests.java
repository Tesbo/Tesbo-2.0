package TestCases.WebUITests.login;


import Framework.core.init.base;
import Framework.core.readers.DataReader;
import Framework.core.readers.JsonFileReader;
import Framework.core.remotegrid.LambdaTestConfig;
import TestObjects.Pages.login.login_page;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;


public class LoginTests extends base {

    login_page login = null;

    @DataProvider(name = "login_credentials")
    public Object[][] data_provider() {
        JsonFileReader config = new JsonFileReader();
        DataReader reader = new DataReader();
        Object[][] data = null;
       // if (config.getEnvFromCurrentConfig().contains("test") || config.getEnvFromCurrentConfig().contains("ngdev")) {
            data = reader.getExcelDataForDataProvider("nevvon_test_env.xlsx", 0);
        //} else if (config.getEnvFromCurrentConfig().contains("admin")) {
            data = reader.getExcelDataForDataProvider("nevvon_prod_env.xlsx", 0);
        //}
        return data;
    }

@Test
    public void Verify_login_with_valid_credentials() {

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("Verify login with valid credentials");
        Logger.log_qase_id("NEV-101");

        login_page login = new login_page(driver);


        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.performLogin("mahes", "ramesh");


    }

    @Test
    public void verify_login_with_blank_user() {

        Logger.log_qase_id("NEV-1079");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify login with blank user");

        login_page login = new login_page(driver);

        login.verify_login_button_is_present_on_page();
        login.click_on_login_button();
        login.verify_blank_email_message_is_present_on_page();
        login.verify_blank_password_message_is_present_on_page();
    }

    @Test
    public void verify_login_with_blank_password() {
        Logger.log_qase_id("NEV-1080");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify login with blank password");

        login_page login = new login_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.enter_text_at_email_text_box("viral@nevvon.com");
        login.click_on_login_button();
        login.verify_blank_password_message_is_present_on_page();
    }

    @Test
    public void verify_login_with_user_and_password_both_empty() {
        Logger.log_qase_id("NEV-1077");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify login with user and password both empty");


        login_page login = new login_page(driver);

        login.enter_text_at_email_text_box("");
        login.enter_text_at_password("");

        login.click_on_login_button();

        login.verify_blank_email_message_is_present_on_page();
        login.verify_blank_password_message_is_present_on_page();

    }

    @Test
    public void verify_login_with_valid_user_and_invalid_password() {
        Logger.log_qase_id("NEV-1076");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify login with valid user and invalid password");

        login_page login = new login_page(driver);

        login.enter_text_at_email_text_box("viral@nevvon.com");
        login.enter_text_at_password("13245666");

        login.click_on_login_button();

        login.verify_wrong_password_warning_message();

    }

    @Test
    public void verify_login_invalid_user_and_valid_password() {
        Logger.log_qase_id("NEV-1081");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify login invalid user and valid password");

        login_page login = new login_page(driver);

        login.enter_text_at_email_text_box("test@nevvon.com");
        login.enter_text_at_password("132456a");

        login.click_on_login_button();
        login.verify_wrong_credential_warning_message();

    }

    @Test
    public void verify_login_with_wrong_email_format_and_password() {
        Logger.log_qase_id("NEV-1075");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify login with wrong email format and password");

        login_page login = new login_page(driver);

        login.enter_text_at_email_text_box("viral#test#nevvon.com");
        login.enter_text_at_password("132456a");

        login.click_on_login_button();
        login.verify_wrong_email_warning_message();
    }

    @Test
    public void verify_login_with_entering_spaces_in_email_and_password() {
        Logger.log_qase_id("NEV-1074");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify login with entering spaces in email and password");

        login_page login = new login_page(driver);

        login.enter_text_at_email_text_box("vir al@nevvon.com");
        login.enter_text_at_password("132456a ");

        login.click_on_login_button();
        login.verify_wrong_email_warning_message();

    }

    @Test
    public void verify_login_with_invalid_single_quote_in_email_and_password() {
        Logger.log_qase_id("NEV-1073");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify login with invalid single quote in email and password");

        login_page login = new login_page(driver);

        login.enter_text_at_email_text_box("viral's@nevvon.com");
        login.enter_text_at_password("132456a ");

        login.click_on_login_button();
        login.verify_wrong_credential_warning_message();

    }

    @Test
    public void verify_login_with_invalid_user_with_html_tag_and_password() {
        Logger.log_qase_id("NEV-1072");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify login with invalid user with html tag and password");

        login_page login = new login_page(driver);

        login.enter_text_at_email_text_box("viral<123>test@nevvon.com");
        login.enter_text_at_password("132456a ");
        login.click_on_login_button();
        login.verify_wrong_email_warning_message();

    }

    @Test
    public void verify_when_click_on_Back_to_login_link_it_gets_back_to_login_page()
    {
        Logger.log_qase_id("NEV-104");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on Back to login link, it gets back to login page");

        login = new login_page(driver);



        login.verify_forgot_your_password_link_is_present_on_page();
        login.click_on_forgot_your_password_link();
        login.verify_redirect_to_forgot_password_page();
        login.click_on_back_to_login_link();
        login.verify_redirect_to_login_page();

    }
    @Test
    public void  verify_not_getting_reset_password_for_unregistered_user()
    {
        Logger.log_qase_id("NEV-108");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify not getting reset password for unregistered user");

        login = new login_page(driver);



        login.verify_forgot_your_password_link_is_present_on_page();
        login.click_on_forgot_your_password_link();
        login.verify_redirect_to_forgot_password_page();
        login.enter_text_email_at_forgot_password_text_box("viaana@qable.io");
        login.click_on_send_button();
        login.verify_invalid_validation_message_display();

    }
    @Test
    public void  verify_user_gets_mail_when_send_reset_password_mail()
    {
        Logger.log_qase_id("NEV-105");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify user gets mail when send reset password mail");

        login = new login_page(driver);



        login.verify_forgot_your_password_link_is_present_on_page();
        login.click_on_forgot_your_password_link();
        login.verify_redirect_to_forgot_password_page();
        login.enter_text_email_at_forgot_password_text_box("viral@nevvon.com");
        login.click_on_send_button();
        login.verify_set_successfully_validation_msg();

    }
    @Test
    public void   verify_when_click_on_send_button_without_entering_email()
    {
        Logger.log_qase_id("NEV-109");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on send button without entering email");

        login = new login_page(driver);



        login.verify_forgot_your_password_link_is_present_on_page();
        login.click_on_forgot_your_password_link();
        login.verify_redirect_to_forgot_password_page();
        login.click_on_send_button();
        login.verify_email_required_validation_msg_show();

    }

    @Test
    public void To_verify_when_Clicks_on_password_eye_icon_for_password_Masked_UnMasked()
    {
        Logger.log_qase_id("TC_LogIn_026");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when Clicks on password eye icon for password Masked UnMasked");

        login = new login_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();


        login.enter_text_at_password("QA_12345");
        login.click_on_masked_icon();
        login.verify_Password_in_text_visible();
        login.click_on_unmasked_icon();
        login.verify_Password_is_hidden_format();
    }

    @Test
    public void To_verify_logging_in_survey_tool()
    {
        Logger.log_qase_id("1");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify logging in survey tool");

        login = new login_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.click_on_login_button();


    }
    @Test
    public void To_verify_logging_with_blank_user_in_survey_tool()
    {
        Logger.log_qase_id("2");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify logging in survey tool");

        login = new login_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        //login.enter_text_at_email_text_box_in_survey("viral<123>test@nevvon.com");
        login.enter_text_at_password("132456a ");

        login.click_on_login_button();


    }

}
