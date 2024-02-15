package WebUITests.SurveyLogin;

import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;
import utility.Logger;
import web.object_repository.forgotPassword.forgot_password;
import web.object_repository.Surveyloginpage.survey_login_page;

public class surveylogin extends base{
    survey_login_page surveylogin = null;

    forgot_password forgotPassword = null;

    @DataProvider(name = "login_credentials")
    public Object[][] data_provider() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        if (config.getEnvFromCurrentConfig().contains("surveys")) {
            data = reader.getExcelDataForDataProvider("survey_nevvon_test_env.xlsx", 0);
        }
        return data;
    }

    @Test
    public void To_verify_login_with_survey_tool ()
    {
        Logger.log_qase_id("S_01");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify login with survey tool");

        surveylogin = new survey_login_page(driver);

        surveylogin.verify_email_text_box_is_present_on_survey_login_page();
        surveylogin.verify_password_button_is_present_on_survey_login_page();
        surveylogin.verify_login_button_is_present_on_survey_login_page();

        surveylogin.enter_email_in_email_tex_box("admin@nevvon.com");
        surveylogin.enter_password_in_password_text_box("NeVvon@dm!n123");

        surveylogin.click_on_survey_login_button();
        surveylogin.verify_navigate_to_survey_home_page();
    }
    @Test
    public void To_verify_login_with_blank_password_text_field ()
    {
        Logger.log_qase_id("S_02");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify login with blank password text field");

        surveylogin = new survey_login_page(driver);

        surveylogin.verify_email_text_box_is_present_on_survey_login_page();
        surveylogin.verify_password_button_is_present_on_survey_login_page();
        surveylogin.verify_login_button_is_present_on_survey_login_page();

        surveylogin.enter_email_in_email_tex_box("admin@nevvon.com");
        surveylogin.enter_password_in_password_text_box(" ");
        surveylogin.click_on_survey_login_button();
        surveylogin.verify_required_validation_message_display();
    }
    @Test
    public void To_verify_login_with_blank_username_and_password_text_field ()
    {
        Logger.log_qase_id("S_03");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify login with blank username and password text field");

        surveylogin = new survey_login_page(driver);

        surveylogin.verify_email_text_box_is_present_on_survey_login_page();
        surveylogin.verify_password_button_is_present_on_survey_login_page();
        surveylogin.verify_login_button_is_present_on_survey_login_page();

        surveylogin.enter_email_in_email_tex_box("  ");
        surveylogin.enter_password_in_password_text_box(" ");
        surveylogin.click_on_survey_login_button();
        surveylogin.verify_required_validation_message_display();
    }
    @Test
    public void To_verify_login_with_blank_username_text_field ()
    {
        Logger.log_qase_id("S_04");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify login with blank username text field");

        surveylogin = new survey_login_page(driver);

        surveylogin.verify_email_text_box_is_present_on_survey_login_page();
        surveylogin.verify_password_button_is_present_on_survey_login_page();
        surveylogin.verify_login_button_is_present_on_survey_login_page();

        surveylogin.enter_email_in_email_tex_box("  ");
        surveylogin.enter_password_in_password_text_box("NeVvon@dm!n123");
        surveylogin.click_on_survey_login_button();
        surveylogin.verify_required_validation_message_display();
    }
    @Test
    public void To_verify_login_with_invalid_username_and_password ()
    {
        Logger.log_qase_id("S_05");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify login with invalid username and password");

        surveylogin = new survey_login_page(driver);

        surveylogin.verify_email_text_box_is_present_on_survey_login_page();
        surveylogin.verify_password_button_is_present_on_survey_login_page();
        surveylogin.verify_login_button_is_present_on_survey_login_page();

        surveylogin.clear_email_text_box();
        surveylogin.enter_email_in_email_tex_box("admin123&@nevvon.com");
        surveylogin.clear_password_text_box();
        surveylogin.enter_password_in_password_text_box("NeVvon!**@dm!n123");
        surveylogin.click_on_survey_login_button();
        surveylogin.verify_required_validation_message_display();
    }
    @Test
    public void To_verify_user_can_forgot_password ()
    {
        Logger.log_qase_id("S_06");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify user can forgot password");

        surveylogin = new survey_login_page(driver);

        surveylogin.verify_email_text_box_is_present_on_survey_login_page();
        surveylogin.verify_password_button_is_present_on_survey_login_page();
        surveylogin.verify_login_button_is_present_on_survey_login_page();

        surveylogin.click_on_forgot_password_link();
        surveylogin.verify_forgot_password_popup_display();
        surveylogin.click_on_forgot_password_button();
        surveylogin.verify_successfully_sent_reset_password_validation_display();
    }
    @Test
    public void To_verify_user_can_sent_reset_password_with_blank_email ()
    {
        Logger.log_qase_id("S_07");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify user can sent reset password with blank email");

        surveylogin = new survey_login_page(driver);

        surveylogin.verify_email_text_box_is_present_on_survey_login_page();
        surveylogin.verify_password_button_is_present_on_survey_login_page();
        surveylogin.verify_login_button_is_present_on_survey_login_page();

        surveylogin.click_on_forgot_password_link();
        surveylogin.verify_forgot_password_popup_display();
        surveylogin.clear_email_text_box();
        surveylogin.enter_email_in_email_tex_box("  ");
        surveylogin.click_on_forgot_password_button();
        surveylogin.verify_required_validation_message_display();
    }
    @Test
    public void To_verify_when_user_can_logout_on_survey_tool ()
    {
        Logger.log_qase_id("S_08");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when user can logout on survey tool ");

        surveylogin = new survey_login_page(driver);

        surveylogin.verify_email_text_box_is_present_on_survey_login_page();
        surveylogin.verify_password_button_is_present_on_survey_login_page();
        surveylogin.verify_login_button_is_present_on_survey_login_page();

        surveylogin.enter_email_in_email_tex_box("admin@nevvon.com");
        surveylogin.enter_password_in_password_text_box("NeVvon@dm!n123");

        surveylogin.click_on_survey_login_button();
        surveylogin.verify_navigate_to_survey_home_page();

        surveylogin.click_account_button_in_survey_tool();
        surveylogin.verify_logout_option_present_in_survey();
        surveylogin.click_on_logout_button_in_survey();

        surveylogin.verify_email_text_box_is_present_on_survey_login_page();
        surveylogin.verify_password_button_is_present_on_survey_login_page();
        surveylogin.verify_login_button_is_present_on_survey_login_page();
    }
    @Test
    public void To_verify_when_user_can_make_inactive_on_survey_tool ()
    {
        Logger.log_qase_id("S_09");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when user can make inactive on survey tool ");

        surveylogin = new survey_login_page(driver);

        surveylogin.verify_email_text_box_is_present_on_survey_login_page();
        surveylogin.verify_password_button_is_present_on_survey_login_page();
        surveylogin.verify_login_button_is_present_on_survey_login_page();

        surveylogin.enter_email_in_email_tex_box("admin@nevvon.com");
        surveylogin.enter_password_in_password_text_box("NeVvon@dm!n123");

        surveylogin.click_on_survey_login_button();
        surveylogin.verify_navigate_to_survey_home_page();

       surveylogin.verify_make_inactive_button_present_on_page();
       surveylogin.click_on_make_inactive();
       surveylogin.verify_successfully_de_active_validation_display();
    }

}

